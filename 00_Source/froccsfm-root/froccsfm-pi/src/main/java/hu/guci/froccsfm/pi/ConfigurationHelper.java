/**
 * 
 */
package hu.guci.froccsfm.pi;

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
	 * @return
	 */
	public String getOrderServiceUri() 
	{
		return getStringConfigurationValue("OrderServiceUri", "http://localhost:8090/order");
	}
}
