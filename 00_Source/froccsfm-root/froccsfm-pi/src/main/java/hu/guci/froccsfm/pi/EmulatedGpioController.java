/**
 * 
 */
package hu.guci.froccsfm.pi;

import java.util.Collection;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinAnalog;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.GpioPinAnalogOutput;
import com.pi4j.io.gpio.GpioPinDigital;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinInput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.GpioPinShutdown;
import com.pi4j.io.gpio.GpioProvider;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.trigger.GpioTrigger;

import hu.areus.terminus.base.BaseClass;

/**
 * Gpio controller emulator
 * @author adam.katona
 *
 */
public class EmulatedGpioController extends BaseClass implements GpioController 
{

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#export(com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void export(PinMode mode, PinState defaultState, GpioPin... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#export(com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void export(PinMode mode, GpioPin... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#isExported(com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public boolean isExported(GpioPin... pin) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#unexport(com.pi4j.io.gpio.Pin[])
	 */
	@Override
	public void unexport(Pin... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#unexport(com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void unexport(GpioPin... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#unexportAll()
	 */
	@Override
	public void unexportAll() {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setMode(com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void setMode(PinMode mode, GpioPin... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#getMode(com.pi4j.io.gpio.GpioPin)
	 */
	@Override
	public PinMode getMode(GpioPin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#isMode(com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public boolean isMode(PinMode mode, GpioPin... pin) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setPullResistance(com.pi4j.io.gpio.PinPullResistance, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void setPullResistance(PinPullResistance resistance, GpioPin... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#getPullResistance(com.pi4j.io.gpio.GpioPin)
	 */
	@Override
	public PinPullResistance getPullResistance(GpioPin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#isPullResistance(com.pi4j.io.gpio.PinPullResistance, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public boolean isPullResistance(PinPullResistance resistance, GpioPin... pin) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#high(com.pi4j.io.gpio.GpioPinDigitalOutput[])
	 */
	@Override
	public void high(GpioPinDigitalOutput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#isHigh(com.pi4j.io.gpio.GpioPinDigital[])
	 */
	@Override
	public boolean isHigh(GpioPinDigital... pin) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#low(com.pi4j.io.gpio.GpioPinDigitalOutput[])
	 */
	@Override
	public void low(GpioPinDigitalOutput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#isLow(com.pi4j.io.gpio.GpioPinDigital[])
	 */
	@Override
	public boolean isLow(GpioPinDigital... pin) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setState(com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.GpioPinDigitalOutput[])
	 */
	@Override
	public void setState(PinState state, GpioPinDigitalOutput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setState(boolean, com.pi4j.io.gpio.GpioPinDigitalOutput[])
	 */
	@Override
	public void setState(boolean state, GpioPinDigitalOutput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#isState(com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.GpioPinDigital[])
	 */
	@Override
	public boolean isState(PinState state, GpioPinDigital... pin) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#getState(com.pi4j.io.gpio.GpioPinDigital)
	 */
	@Override
	public PinState getState(GpioPinDigital pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#toggle(com.pi4j.io.gpio.GpioPinDigitalOutput[])
	 */
	@Override
	public void toggle(GpioPinDigitalOutput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#pulse(long, com.pi4j.io.gpio.GpioPinDigitalOutput[])
	 */
	@Override
	public void pulse(long milliseconds, GpioPinDigitalOutput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setValue(double, com.pi4j.io.gpio.GpioPinAnalogOutput[])
	 */
	@Override
	public void setValue(double value, GpioPinAnalogOutput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#getValue(com.pi4j.io.gpio.GpioPinAnalog)
	 */
	@Override
	public double getValue(GpioPinAnalog pin) {
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#addListener(com.pi4j.io.gpio.event.GpioPinListener, com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void addListener(GpioPinListener listener, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#addListener(com.pi4j.io.gpio.event.GpioPinListener[], com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void addListener(GpioPinListener[] listeners, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#removeListener(com.pi4j.io.gpio.event.GpioPinListener, com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void removeListener(GpioPinListener listener, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#removeListener(com.pi4j.io.gpio.event.GpioPinListener[], com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void removeListener(GpioPinListener[] listeners, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#removeAllListeners()
	 */
	@Override
	public void removeAllListeners() {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#addTrigger(com.pi4j.io.gpio.trigger.GpioTrigger, com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void addTrigger(GpioTrigger trigger, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#addTrigger(com.pi4j.io.gpio.trigger.GpioTrigger[], com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void addTrigger(GpioTrigger[] triggers, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#removeTrigger(com.pi4j.io.gpio.trigger.GpioTrigger, com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void removeTrigger(GpioTrigger trigger, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#removeTrigger(com.pi4j.io.gpio.trigger.GpioTrigger[], com.pi4j.io.gpio.GpioPinInput[])
	 */
	@Override
	public void removeTrigger(GpioTrigger[] triggers, GpioPinInput... pin) {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#removeAllTriggers()
	 */
	@Override
	public void removeAllTriggers() {
		

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider provider, Pin pin, String name,
			PinMode mode, PinPullResistance resistance) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider provider, Pin pin, PinMode mode,
			PinPullResistance resistance) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider provider, Pin pin, String name,
			PinMode mode) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(GpioProvider provider, Pin pin, PinMode mode) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, String name, PinMode mode,
			PinPullResistance resistance) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, PinMode mode,
			PinPullResistance resistance) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, String name, PinMode mode) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalMultipurposePin(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPinDigitalMultipurpose provisionDigitalMultipurposePin(Pin pin, PinMode mode) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider provider, Pin pin, String name,
			PinPullResistance resistance) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider provider, Pin pin, PinPullResistance resistance) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider provider, Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(GpioProvider provider, Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(Pin pin, String name, PinPullResistance resistance) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(Pin pin, PinPullResistance resistance) {
		return new EmulatedGpioPinDigitalInput();
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalInputPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinDigitalInput provisionDigitalInputPin(Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider provider, Pin pin, String name,
			PinState defaultState) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider provider, Pin pin, PinState defaultState) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider provider, Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(GpioProvider provider, Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin, String name, PinState defaultState) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin, PinState defaultState) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionDigitalOutputPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinDigitalOutput provisionDigitalOutputPin(Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogInputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinAnalogInput provisionAnalogInputPin(GpioProvider provider, Pin pin, String name) {
		return new EmulatedGpioPinAnalogInput();
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogInputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinAnalogInput provisionAnalogInputPin(GpioProvider provider, Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogInputPin(com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinAnalogInput provisionAnalogInputPin(Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogInputPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinAnalogInput provisionAnalogInputPin(Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, double)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider provider, Pin pin, String name,
			double defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, double)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider provider, Pin pin, double defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider provider, Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(GpioProvider provider, Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.Pin, java.lang.String, double)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin, String name, double defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.Pin, double)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin, double defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionAnalogOutputPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinAnalogOutput provisionAnalogOutputPin(Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, int)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider provider, Pin pin, String name, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, int)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider provider, Pin pin, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider provider, Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(GpioProvider provider, Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.Pin, java.lang.String, int)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(Pin pin, String name, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.Pin, int)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(Pin pin, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPwmOutputPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinPwmOutput provisionPwmOutputPin(Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, int)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(GpioProvider provider, Pin pin, String name, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, int)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(GpioProvider provider, Pin pin, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(GpioProvider provider, Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(GpioProvider provider, Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.Pin, java.lang.String, int)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(Pin pin, String name, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.Pin, int)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(Pin pin, int defaultValue) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.Pin, java.lang.String)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(Pin pin, String name) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionSoftPwmOutputPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPinPwmOutput provisionSoftPwmOutputPin(Pin pin) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public GpioPin provisionPin(GpioProvider provider, Pin pin, String name, PinMode mode, PinState defaultState) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPin provisionPin(GpioProvider provider, Pin pin, String name, PinMode mode) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPin(com.pi4j.io.gpio.GpioProvider, com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPin provisionPin(GpioProvider provider, Pin pin, PinMode mode) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPin(com.pi4j.io.gpio.Pin, java.lang.String, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPin provisionPin(Pin pin, String name, PinMode mode) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#provisionPin(com.pi4j.io.gpio.Pin, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public GpioPin provisionPin(Pin pin, PinMode mode) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setShutdownOptions(com.pi4j.io.gpio.GpioPinShutdown, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void setShutdownOptions(GpioPinShutdown options, GpioPin... pin) {

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setShutdownOptions(java.lang.Boolean, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void setShutdownOptions(Boolean unexport, GpioPin... pin) {

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setShutdownOptions(java.lang.Boolean, com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void setShutdownOptions(Boolean unexport, PinState state, GpioPin... pin) {

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setShutdownOptions(java.lang.Boolean, com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.PinPullResistance, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void setShutdownOptions(Boolean unexport, PinState state, PinPullResistance resistance, GpioPin... pin) {

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#setShutdownOptions(java.lang.Boolean, com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.PinPullResistance, com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void setShutdownOptions(Boolean unexport, PinState state, PinPullResistance resistance, PinMode mode,
			GpioPin... pin) {

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#getProvisionedPins()
	 */
	@Override
	public Collection<GpioPin> getProvisionedPins() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#getProvisionedPin(com.pi4j.io.gpio.Pin)
	 */
	@Override
	public GpioPin getProvisionedPin(Pin pin) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#getProvisionedPin(java.lang.String)
	 */
	@Override
	public GpioPin getProvisionedPin(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#unprovisionPin(com.pi4j.io.gpio.GpioPin[])
	 */
	@Override
	public void unprovisionPin(GpioPin... pin) {

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#isShutdown()
	 */
	@Override
	public boolean isShutdown() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioController#shutdown()
	 */
	@Override
	public void shutdown() {

	}

}
