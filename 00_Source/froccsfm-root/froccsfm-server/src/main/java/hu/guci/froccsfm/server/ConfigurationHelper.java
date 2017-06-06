/**
 * 
 */
package hu.guci.froccsfm.server;

import hu.areus.terminus.base.BaseConfigurationHelper;

/**
 * Configuration helper.
 * @author adam.katona
 *
 */
public class ConfigurationHelper extends BaseConfigurationHelper
{
	private static final  ConfigurationHelper INSTANCE = new ConfigurationHelper();

	/**
	 * Default constructor.
	 */
	private ConfigurationHelper()
	{
		super(Consts.CONFIGURATION_FILENAME);
	}
	
	/**
	 * Gets the current instance.
	 */
	public static ConfigurationHelper getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Get maximum order number.
	 * @return
	 */
	public int getMaxOrderNo() 
	{
		return getIntConfigurationValue("MaxOrderNo", 99);
	}
}
