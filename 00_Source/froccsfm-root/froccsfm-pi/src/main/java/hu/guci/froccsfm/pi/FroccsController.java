package hu.guci.froccsfm.pi;

import java.awt.GraphicsEnvironment;
import java.io.IOException;

import com.google.gson.Gson;
import com.pi4j.gpio.extension.ads.ADS1115GpioProvider;
import com.pi4j.gpio.extension.ads.ADS1115Pin;
import com.pi4j.gpio.extension.ads.ADS1x15GpioProvider.ProgrammableGainAmplifierValue;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioProvider;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import de.pi3g.pi.oled.Font;
import de.pi3g.pi.oled.OLEDDisplay;
import de.pi3g.pi.oled.OLEDDisplayImpl;
import hu.areus.terminus.base.BaseClass;
import hu.areus.terminus.helpers.FormatHelper;
import hu.guci.froccsfm.api.Names;
import hu.guci.froccsfm.api.Order;
import hu.guci.froccsfm.api.Response;
import hu.guci.froccsfm.api.Tokens;
import hu.guci.froccsfm.pi.ui.ControlForm;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * The main controller class.
 * @author adam.katona
 *
 */
public class FroccsController extends BaseClass 
{
	public final static double MAX_WINE_AMOUNT = 5; //--- dl
	public final static double MAX_SODA_AMOUNT = 5; //--- dl
	public final static double DEFAULT_WINE_AMOUNT = 1; //--- dl
	public final static double DEFAULT_SODA_AMOUNT = 1; //--- dl
	
	private double wineAmount = DEFAULT_WINE_AMOUNT;
	private double sodaAmount = DEFAULT_SODA_AMOUNT;
	
	private boolean isEmulated;
	private boolean isActive;
	private boolean isOrdering;
	
	private GpioController gpio;
	private GpioPinDigitalInput button;
	private GpioProvider analogProvider;
	private OLEDDisplay display;
	private ControlForm form;
	
	
	/**
	 * Init stuff, start listening to the inputs
	 */
	public void init(boolean isEmulated)
	{
		try
		{
			getLogger().info("Initializing controller...");
			this.isEmulated = isEmulated;
			
			gpio = isEmulated ? new EmulatedGpioController() : GpioFactory.getInstance();
			
			if (!GraphicsEnvironment.isHeadless())
			{
				form = new ControlForm(this);
				form.show();
			}
			
			initDisplay();
			initAnalogInput();
	        initButton();
	        updateDisplay();
	
			getLogger().info("Controller initialized.");
		}
		catch (Exception ex)
		{
			getLogger().error("Error while initializing controller: " + ex.getMessage(), ex);
		}
	}
	
	/**
	 * Init the display
	 * @throws UnsupportedBusNumberException 
	 * @throws IOException 
	 */
	private void initDisplay() throws IOException, UnsupportedBusNumberException
	{
		try
		{
			display = isEmulated ? new EmulatedOledDisplay(form) : new OLEDDisplayImpl();
			writeLine(0, "FROCCSFM", true);
			writeLine(1, "TILOS", false);
			writeLine(2, "UDVAR", false);
			display.update();
			Thread.sleep(5000);
		}
		catch (Exception ex)
		{
			getLogger().error("Error while initializing display: " + ex.getMessage(), ex);
		}
	}
	
	/**
	 * Init the analog inputs.
	 * @throws IOException 
	 * @throws UnsupportedBusNumberException 
	 */
	private void initAnalogInput() throws UnsupportedBusNumberException, IOException
	{
		analogProvider = isEmulated ? new EmulatedGpioProvider() : new ADS1115GpioProvider(I2CBus.BUS_1, ADS1115GpioProvider.ADS1115_ADDRESS_0x48);
        GpioPinAnalogInput myInputs[] = {
                gpio.provisionAnalogInputPin(analogProvider, ADS1115Pin.INPUT_A0, "MyAnalogInput-A0"),
                gpio.provisionAnalogInputPin(analogProvider, ADS1115Pin.INPUT_A1, "MyAnalogInput-A1"),
                gpio.provisionAnalogInputPin(analogProvider, ADS1115Pin.INPUT_A2, "MyAnalogInput-A2"),
                gpio.provisionAnalogInputPin(analogProvider, ADS1115Pin.INPUT_A3, "MyAnalogInput-A3"),
        };
        
        if (isEmulated)
        {
        	((EmulatedGpioProvider)analogProvider).setMonitorInterval(100);
        }
        else
        {
        	((ADS1115GpioProvider)analogProvider).setProgrammableGainAmplifier(ProgrammableGainAmplifierValue.PGA_4_096V, ADS1115Pin.ALL);
        	((ADS1115GpioProvider)analogProvider).setEventThreshold(500, ADS1115Pin.ALL);
        	((ADS1115GpioProvider)analogProvider).setMonitorInterval(100);
        }
        
        AnalogListener listener = new AnalogListener(this);
        myInputs[0].addListener(listener);
        myInputs[1].addListener(listener);
        myInputs[2].addListener(listener);
        myInputs[3].addListener(listener);        
	}
	
	/**
	 * Init the button.
	 */
	private void initButton()
	{
		button = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
		button.setShutdownOptions(true);
		button.addListener(new ButtonListener(this));
	}
	
	/**
	 * Shut down stuff.
	 */
	public void shutdown()
	{
		gpio.shutdown();
	}
	
	/**
	 * Update amount display.
	 */
	public void updateDisplay()
	{
		try
		{
			if (display != null)
			{
				writeLine(0, "BOR: " + FormatHelper.formatDecimalToUI(wineAmount, 1, false) + " DL", true);
				writeLine(1, "SZODA: " + FormatHelper.formatDecimalToUI(sodaAmount, 1, false) + " DL", false);
				writeLine(2, Names.getNameForDisplay(wineAmount, sodaAmount), false);
				display.update();
			}
		}
		catch (Exception ex)
		{
			getLogger().error("Error while writing to display: " + ex.getMessage(), ex);
		}
	}

	
	/**
	 * Write a message to the display.
	 * @param message
	 */
	private void writeLine(int line, String message, boolean clear)
	{
		try
		{
			if (clear)
			{
				display.clear();
			}
			
			display.drawStringCentered(message, Font.FONT_5X8, OLEDDisplay.LINE_HEIGHT * line + OLEDDisplay.MARGIN_TOP, true);
		}
		catch (Exception ex)
		{
			getLogger().error("Error while writing to display: " + ex.getMessage(), ex);
		}
	}
	
	/**
	 * Return the gain amplifier on the given pin.
	 * @param pin
	 * @return
	 */
	public ProgrammableGainAmplifierValue getProgrammableGainAmplifier(GpioPin pin) 
	{
		return isEmulated ?
				null 
				:
				((ADS1115GpioProvider)analogProvider).getProgrammableGainAmplifier(pin);
	}

	/**
	 * A value is changed.
	 * @param i
	 * @param value
	 */
	public void valueChanged(int i, double value) 
	{
		switch (i)
		{
			case 0:
				wineAmount = MAX_WINE_AMOUNT * value / 100;
				break;
			case 1:
				sodaAmount = MAX_SODA_AMOUNT * value / 100;
				break;
		}
		
		updateDisplay();
		
		if (form != null)
		{
			form.changeValue(i, (int)value);
		}
	}

	/**
	 * Do the order.
	 * @throws IOException 
	 */
	public void buttonPushed() throws IOException 
	{
		try
		{
			if (isOrdering)
			{
				return;
			}
			
			isOrdering = true;
			
			writeLine(2, "TURELEM...", true);
			display.update();	
			Thread.sleep(1);
			
			int no = order(); 
			
			writeLine(2, "SORSZAMOD: " + no, true);
			display.update();
			Thread.sleep(5000);
		}
		catch (Exception ex)
		{
			getLogger().error("Error while handling button push: " + ex.getMessage(), ex);
			writeLine(2, "ALULDETERMINALT.", true);
			display.update();			
		}
		finally
		{
			isOrdering = false;
		}
	}
	
	/**
	 * Order the froccs.
	 * @return
	 */
	public int order() 
	{
		getLogger().info("Ordering wine: " + wineAmount + " soda: " + sodaAmount);
		
		Order order = new Order();
		order.setWineAmount(wineAmount);
		order.setSodaAmount(sodaAmount);
		order.setToken(Tokens.CLIENT_TOKEN);
		
//		getLogger().debug("Initializing webtarget...");
//		System.setProperty("javax.ws.rs.ext.RuntimeDelegate", "org.glassfish.jersey.internal.RuntimeDelegateImpl");
//		Client client = ClientBuilder.newClient(new ClientConfig());
//		WebTarget webTarget = client.target(ConfigurationHelper.getInstance().getOrderServiceUri());
//		
//		getLogger().debug("Calling ws...");
//		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.post(Entity.entity(order, MediaType.APPLICATION_JSON));

		io.restassured.response.Response response = RestAssured.
			given().
				body(new Gson().toJson(order)).
				post(ConfigurationHelper.getInstance().getOrderServiceUri()).
			then().
            	contentType(ContentType.JSON). 
            	extract().response();
	
		Response orderResponse = response.as(Response.class);
		
		getLogger().debug("Order response status: " + orderResponse.isSuccess());
		getLogger().debug("Order no: " + orderResponse.getOrderNo());
		
		return orderResponse.getOrderNo();
	}

	/**
	 * Show the emulated UI.
	 */
	public void showDialog()
	{
		 isActive = true;
		 
		 while (isActive)
		 {
			 try
			 {
				 Thread.sleep(1000);
			 }
			 catch (InterruptedException ex)
			 {
				 break;
			 }
		 }
		 
		 if (form != null)
		 {
			 form.close();
		 }
	}
}
