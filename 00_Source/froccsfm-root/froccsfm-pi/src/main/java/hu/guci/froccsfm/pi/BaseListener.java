/**
 * 
 */
package hu.guci.froccsfm.pi;

import hu.areus.terminus.base.BaseClass;

/**
 * Base class for listeners.
 * @author adam.katona
 *
 */
public abstract class BaseListener extends BaseClass 
{
	private FroccsController parent;

	protected BaseListener(FroccsController parent)
	{
		this.parent = parent;
	}
	
	/**
	 * @return the parent
	 */
	public FroccsController getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(FroccsController parent) {
		this.parent = parent;
	}
}
