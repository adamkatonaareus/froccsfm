/**
 * 
 */
package hu.guci.froccsfm.server;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import hu.areus.terminus.base.BaseClass;
import hu.areus.terminus.helpers.FormatHelper;
import hu.guci.froccsfm.api.Names;
import hu.guci.froccsfm.api.Order;
import hu.guci.froccsfm.api.Response;
import hu.guci.froccsfm.api.Tokens;
import spark.Spark;
import spark.staticfiles.MimeType;
import spark.utils.StringUtils;

/**
 * @author adam.katona
 *
 */
public class SparkService extends BaseClass 
{
	private int port = 8090;
	private Gson gson = new Gson();
	private OrderDao dao = new OrderDao();
	private OrderWebSocketHandler wsHandler = new OrderWebSocketHandler();
	
	
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	
	
	/**
	 * Init and start the server.
	 */
	public void start()
	{
		getLogger().debug("Starting Spark routes...");
		
		Spark.port(getPort());
		MimeType.register("xhtml", "text/html");
		
		dao.init();
		
		//--- Define websocket for live update
		//--- Must be defined before any other routes.
		Spark.webSocket("/orderupdate", wsHandler);
		
		//--- Serve static files from here
		Spark.staticFileLocation("public");
		
		//--- Define a main page
		Spark.get("/", (request, response) -> { response.redirect("/index.xhtml"); return null; });
		
		//--- Define a test url
		Spark.get("/test", (request, response) -> "Hello REST of the world!"); 
		
		//--- Define order post call
		Spark.post("/order", (request, response) -> 
		{
			try
			{
				//--- Get body
				Order data = gson.fromJson(request.body(), Order.class);
				
				//--- Check token
				if (!Tokens.CLIENT_TOKEN.equals(data.getToken()))
				{
					return gson.toJson(Response.failure("Fuck you."));
				}
				
				//--- Process it
				getLogger().info("Wine: " + data.getWineAmount() + " Soda: " + data.getSodaAmount());
				int no = dao.storeOrder(data);
				
				if (StringUtils.isBlank(data.getCreated()))
				{
					data.setCreated(FormatHelper.formatDateTimeToUI(new Date()));
				}
				
				//--- Broadcast the order
				data.setNo(no);
				data.setToken(null);
				data.setName(Names.getName(data.getWineAmount(), data.getSodaAmount()));
				wsHandler.broadcast(gson.toJson(data));
				
				//--- Return number to client
				response.type("application/json");
				return gson.toJson(Response.success(no));
			}
			catch (Exception ex)
			{
				getLogger().error("Error while reporting condition: " + ex.getMessage(), ex);
				return gson.toJson(Response.failure("Sikertelen rendelés."));
			}
		});
		
		//--- Define orders get call
		Spark.get("/orders", (request, response) -> 
		{ 
			try
			{
				//--- Get orders
				List<Order> orders = dao.getOrders();
				
				response.type("application/json");
				return gson.toJson(orders);
			}
			catch (Exception ex)
			{
				getLogger().error("Error while reporting condition: " + ex.getMessage(), ex);
				return gson.toJson(Response.failure("Sikertelen rendelés."));
			}			
		});
		
		//--- Define order fulfill call
		Spark.post("/fulfill", (request, response) -> 
		{
			try
			{
				int id = Integer.parseInt(request.body());
				dao.fulFill(id);
				return "Ok.";
			}
			catch (Exception ex)
			{
				getLogger().error("Error while fulfilling order: " + ex.getMessage(), ex);
				return "Sorry.";
			}
		});
		
		//--- Signup, if enabled.
		if (ConfigurationHelper.getInstance().isSignupEnabled())
		{
			getLogger().warn("Warning! Signup is enabled!");
			
			Spark.get("/signup", (request, response) ->
			{
				try
				{
					response.type("text/html");
					return IOUtils.toString(this.getClass().getResourceAsStream("/private/signup.xhtml"), "UTF-8");
				}
				catch (Exception ex)
				{
					getLogger().error("Error while returning Signup page: " + ex.getMessage(), ex);
					return "Sorry.";
				}
			}
			);
		}
		
		getLogger().debug("Spark started.");
	}


	/**
	 * Stop the server
	 */
	public void stop()
	{
		getLogger().debug("Stopping Spark...");
		Spark.stop();
		getLogger().debug("Spark stopped.");
	}
}
