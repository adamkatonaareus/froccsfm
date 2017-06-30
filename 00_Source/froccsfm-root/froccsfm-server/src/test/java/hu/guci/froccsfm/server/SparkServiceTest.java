package hu.guci.froccsfm.server;

import java.io.IOException;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.google.gson.Gson;

import hu.areus.terminus.helpers.FormatHelper;
import hu.areus.terminus.testsupport.BaseTestClass;
import hu.guci.froccsfm.api.Order;
import hu.guci.froccsfm.api.Tokens;
import io.restassured.RestAssured;

/**
 * Unit test for the Spark Service.
 */
public class SparkServiceTest extends BaseTestClass
{
	/**
	 * Test the order ws.
	 * @throws InterruptedException 
	 */
	@Test
	public void testOrder() throws InterruptedException
	{
		SparkService service = new SparkService();
		service.start();

		for (int i=0; i<5; i++)
		{
			Thread.sleep(2000);
			
			Order order = new Order();
			order.setWineAmount(3);
			order.setSodaAmount(2);
			order.setCreated(FormatHelper.formatDateTimeToUI(new Date()));
			order.setToken(Tokens.CLIENT_TOKEN);
			
			RestAssured.given().
				body(new Gson().toJson(order)).
				post("http://localhost:8090/order").
		    	then().
		    	statusCode(200).body("success", Matchers.equalTo(true));		
		}
		
		service.stop();
	}
	
	/**
	 * Just start the server.
	 */
	@Test
	public void testStartStop()
	{
		SparkService service = new SparkService();
		service.start();
		
		try
		{
			while (true)
			{
				System.in.read();
			}
		}
		catch (IOException ex)
		{
			//--- Nothing to do here
		}
		
		service.stop();
	}
}
