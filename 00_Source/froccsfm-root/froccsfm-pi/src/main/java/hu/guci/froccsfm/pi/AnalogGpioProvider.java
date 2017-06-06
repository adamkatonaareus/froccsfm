/**
 * 
 */
package hu.guci.froccsfm.pi;

import com.pi4j.io.gpio.GpioProvider;

/**
 * We need a new interface here because GpioProvider does not define the analog stuff.
 * @author adam.katona
 *
 */
public interface AnalogGpioProvider extends GpioProvider
{

}
