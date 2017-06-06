package hu.guci.froccsfm.server;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.google.gson.Gson;

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
	 */
	@Test
	public void testOrder()
	{
		SparkService service = new SparkService();
		service.start();

		Order order = new Order();
		order.setWineAmount(3);
		order.setSodaAmount(2);
		order.setToken(Tokens.CLIENT_TOKEN);
		
		RestAssured.given().
			body(new Gson().toJson(order)).
			post("http://localhost:8090/order").
	    	then().
	    	statusCode(200).body("success", Matchers.equalTo(true));		
		
		service.stop();
	}
}
