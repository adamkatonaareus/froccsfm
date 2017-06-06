/**
 * 
 */
package hu.guci.froccsfm.pi;

import com.pi4j.gpio.extension.ads.ADS1115GpioProvider;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerAnalog;

/**
 * Analog value change event.
 * @author adam.katona
 *
 */
public class AnalogListener extends BaseListener implements GpioPinListenerAnalog
{
	/**
	 * @param parent
	 */
	protected AnalogListener(FroccsController parent) 
	{
		super(parent);
	}

	/**
	 * Handle value change event.
	 */
    @Override
    public void handleGpioPinAnalogValueChangeEvent(GpioPinAnalogValueChangeEvent event)
    {
        // RAW value
        double value = event.getValue();

        // percentage
        double percent =  ((value * 100) / ADS1115GpioProvider.ADS1115_RANGE_MAX_VALUE);

        // approximate voltage ( *scaled based on PGA setting )
        double voltage = getParent().getProgrammableGainAmplifier(event.getPin()).getVoltage() * (percent/100);

        // display output
        getLogger().debug(" (" + event.getPin().getName() +") : VOLTS=" + voltage + "  | PERCENT=" + percent + "% | RAW=" + value + "       ");
        
        //--- Call controller event
        getParent().valueChanged(
        		"MyAnalogInput-A0".equals(event.getPin().getName()) ? 0 : 1,
        		percent);
    }
}
