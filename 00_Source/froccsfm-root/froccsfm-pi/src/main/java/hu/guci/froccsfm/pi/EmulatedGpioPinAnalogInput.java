/**
 * 
 */
package hu.guci.froccsfm.pi;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.pi4j.io.gpio.GpioPinAnalogInput;
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
 * @author adam.katona
 *
 */
public class EmulatedGpioPinAnalogInput extends BaseClass implements GpioPinAnalogInput {

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalog#getValue()
	 */
	@Override
	public double getValue() {
		// 
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getProvider()
	 */
	@Override
	public GpioProvider getProvider() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getPin()
	 */
	@Override
	public Pin getPin() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getName()
	 */
	@Override
	public String getName() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setTag(java.lang.Object)
	 */
	@Override
	public void setTag(Object tag) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getTag()
	 */
	@Override
	public Object getTag() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public void setProperty(String key, String value) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#hasProperty(java.lang.String)
	 */
	@Override
	public boolean hasProperty(String key) {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getProperty(java.lang.String)
	 */
	@Override
	public String getProperty(String key) {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public String getProperty(String key, String defaultValue) {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getProperties()
	 */
	@Override
	public Map<String, String> getProperties() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#removeProperty(java.lang.String)
	 */
	@Override
	public void removeProperty(String key) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#clearProperties()
	 */
	@Override
	public void clearProperties() {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#export(com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public void export(PinMode mode) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#export(com.pi4j.io.gpio.PinMode, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public void export(PinMode mode, PinState defaultState) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#unexport()
	 */
	@Override
	public void unexport() {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#isExported()
	 */
	@Override
	public boolean isExported() {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setMode(com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public void setMode(PinMode mode) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getMode()
	 */
	@Override
	public PinMode getMode() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#isMode(com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public boolean isMode(PinMode mode) {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setPullResistance(com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public void setPullResistance(PinPullResistance resistance) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getPullResistance()
	 */
	@Override
	public PinPullResistance getPullResistance() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#isPullResistance(com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public boolean isPullResistance(PinPullResistance resistance) {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#getShutdownOptions()
	 */
	@Override
	public GpioPinShutdown getShutdownOptions() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setShutdownOptions(com.pi4j.io.gpio.GpioPinShutdown)
	 */
	@Override
	public void setShutdownOptions(GpioPinShutdown options) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setShutdownOptions(java.lang.Boolean)
	 */
	@Override
	public void setShutdownOptions(Boolean unexport) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setShutdownOptions(java.lang.Boolean, com.pi4j.io.gpio.PinState)
	 */
	@Override
	public void setShutdownOptions(Boolean unexport, PinState state) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setShutdownOptions(java.lang.Boolean, com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.PinPullResistance)
	 */
	@Override
	public void setShutdownOptions(Boolean unexport, PinState state, PinPullResistance resistance) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPin#setShutdownOptions(java.lang.Boolean, com.pi4j.io.gpio.PinState, com.pi4j.io.gpio.PinPullResistance, com.pi4j.io.gpio.PinMode)
	 */
	@Override
	public void setShutdownOptions(Boolean unexport, PinState state, PinPullResistance resistance, PinMode mode) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#getListeners()
	 */
	@Override
	public Collection<GpioPinListener> getListeners() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#addListener(com.pi4j.io.gpio.event.GpioPinListener[])
	 */
	@Override
	public void addListener(GpioPinListener... listener) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#addListener(java.util.List)
	 */
	@Override
	public void addListener(List<? extends GpioPinListener> listeners) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#hasListener(com.pi4j.io.gpio.event.GpioPinListener[])
	 */
	@Override
	public boolean hasListener(GpioPinListener... listener) {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#removeListener(com.pi4j.io.gpio.event.GpioPinListener[])
	 */
	@Override
	public void removeListener(GpioPinListener... listener) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#removeListener(java.util.List)
	 */
	@Override
	public void removeListener(List<? extends GpioPinListener> listeners) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#removeAllListeners()
	 */
	@Override
	public void removeAllListeners() {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#getTriggers()
	 */
	@Override
	public Collection<GpioTrigger> getTriggers() {
		// 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#addTrigger(com.pi4j.io.gpio.trigger.GpioTrigger[])
	 */
	@Override
	public void addTrigger(GpioTrigger... trigger) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#addTrigger(java.util.List)
	 */
	@Override
	public void addTrigger(List<? extends GpioTrigger> triggers) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#removeTrigger(com.pi4j.io.gpio.trigger.GpioTrigger[])
	 */
	@Override
	public void removeTrigger(GpioTrigger... trigger) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#removeTrigger(java.util.List)
	 */
	@Override
	public void removeTrigger(List<? extends GpioTrigger> triggers) {
		// 

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.GpioPinAnalogInput#removeAllTriggers()
	 */
	@Override
	public void removeAllTriggers() {
		// 

	}

}
