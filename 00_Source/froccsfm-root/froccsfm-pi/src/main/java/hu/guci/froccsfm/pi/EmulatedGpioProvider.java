/**
 * 
 */
package hu.guci.froccsfm.pi;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.PinListener;

import hu.areus.terminus.base.BaseClass;

/**
 * @author adam.katona
 *
 */
public class EmulatedGpioProvider extends BaseClass implements AnalogGpioProvider 
{

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#getName()
	 */
	@Override
	public String getName() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#hasPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public boolean hasPin(Pin pin) {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#export(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public void export(Pin pin, PinMode mode, PinState defaultState) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#export(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public void export(Pin pin, PinMode mode) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#isExported(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public boolean isExported(Pin pin) {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#unexport(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public void unexport(Pin pin) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#setMode(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public void setMode(Pin pin, PinMode mode) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#getMode(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public PinMode getMode(Pin pin) {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#setPullResistance(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public void setPullResistance(Pin pin, PinPullResistance resistance) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#getPullResistance(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public PinPullResistance getPullResistance(Pin pin) {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#setState(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public void setState(Pin pin, PinState state) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#getState(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public PinState getState(Pin pin) {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#setValue(com.pi4j.io.gpio.Pin, double)
	 */
	@Override
	public void setValue(Pin pin, double value) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#getValue(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public double getValue(Pin pin) {
		// 
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#setPwm(com.pi4j.io.gpio.Pin, int)
	 */
	@Override
	public void setPwm(Pin pin, int value) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#setPwmRange(com.pi4j.io.gpio.Pin, int)
	 */
	@Override
	public void setPwmRange(Pin pin, int range) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#getPwm(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public int getPwm(Pin pin) {
		// 
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#addListener(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.event.PinListener)
	 */
	@Override
	public void addListener(Pin pin, PinListener listener) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#removeListener(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.event.PinListener)
	 */
	@Override
	public void removeListener(Pin pin, PinListener listener) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#removeAllListeners()
	 */
	@Override
	public void removeAllListeners() {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#shutdown()
	 */
	@Override
	public void shutdown() {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioProvider#isShutdown()
	 */
	@Override
	public boolean isShutdown() {
		// 
		return false;
	}

	/**
	 * @param i
	 */
	public void setMonitorInterval(int i) {
		// 
		
	}

}
