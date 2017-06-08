/**
 * 
 */
package hu.guci.froccsfm.pi;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * Button event listener.
 * @author adam.katona
 *
 */
public class ButtonListener extends BaseListener implements GpioPinListenerDigital
{
	/**
	 * @param parent
	 */
	protected ButtonListener(FroccsController parent)
	{
		super(parent);
	}

	/**
	 * Handle the event.
	 */
    @Override
    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) 
    {
    	try
    	{
	        // display pin state on console
	        getLogger().debug(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
	        
	        //--- Call controller
	        getParent().buttonPushed();
    	}
    	catch (Exception ex)
    	{
    		getLogger().error("Error in button push event: " + ex.getMessage(), ex);
    	}
    }
}
