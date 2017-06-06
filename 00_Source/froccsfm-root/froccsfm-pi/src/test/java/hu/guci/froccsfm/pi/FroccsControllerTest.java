/**
 * 
 */
package hu.guci.froccsfm.pi;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import hu.areus.terminus.testsupport.BaseTestClass;

/**
 * Test the FroccsController
 * @author adam.katona
 *
 */
public class FroccsControllerTest extends BaseTestClass 
{
	/**
	 * Test init and shutdown
	 */
	@Test
	public void testInit()
	{
		FroccsController controller = new FroccsController();
		controller.init(true);
		controller.shutdown();
	}
	
	/**
	 * Test interactively.
	 */
	@Test
	public void testWithUI()
	{
		FroccsController controller = new FroccsController();
		controller.init(true);
		controller.showDialog();
	}
	
	/**
	 * Test ordering only.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testOrder() throws ClassNotFoundException, IOException, URISyntaxException
	{
		FroccsController controller = new FroccsController();
		int result = controller.order();
		getLogger().debug("result: " + result);
	}
}
