package hu.guci.froccsfm.pi;

import hu.areus.terminus.base.BaseStaticClass;

/**
 * Hello world!
 *
 */
public class App extends BaseStaticClass
{
	private App()
	{
		//--- Default constructor.
	}
	
	/**
	 * Main entry point.
	 * @param args
	 */
    public static void main( String[] args )
    {
    	try
    	{
    		initLogger(App.class);
			FroccsController controller = new FroccsController();
			controller.init(false);
			controller.showDialog();
    	}
    	catch (Exception ex)
    	{
    		getLogger().error(ex);
    		System.err.println("Error while running app: " + ex.toString());
    	}
    }
}
