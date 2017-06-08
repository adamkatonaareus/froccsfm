package hu.guci.froccsfm.server;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import hu.areus.terminus.testsupport.BaseTestClass;

/**
 * Unit test for Server App.
 */
public class AppTest extends BaseTestClass
{
	/**
	 * Test init and shutdown
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testApp() throws ClassNotFoundException, IOException, URISyntaxException
	{
		//testClassLoading("javax/servlet/Filter");
		App.main(null);
	}
}
