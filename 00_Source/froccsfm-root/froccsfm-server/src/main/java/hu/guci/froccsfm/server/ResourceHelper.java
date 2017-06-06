/**
 * 
 */
package hu.guci.froccsfm.server;

import hu.areus.terminus.base.BaseResourceHelper;

/**
 * Resource helper for this project.
 * @author adam.katona
 *
 */
public final class ResourceHelper extends BaseResourceHelper 
{
	private static final ResourceHelper INSTANCE = new ResourceHelper();

	/**
	 * Gets the current instance.
	 * @return
	 */
	public static ResourceHelper getInstance() 
	{
		return INSTANCE;
	}

	/**
	 * Configure the resource bundle name here.
	 * Format: package.filename
	 */
	private ResourceHelper()
	{
		super("hu.guci.froccsfm.server.server");
	}
}

