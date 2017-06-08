/**
 * 
 */
package hu.guci.froccsfm.server;

import java.util.List;

import com.google.gson.Gson;

import hu.areus.terminus.base.BaseClass;
import hu.guci.froccsfm.api.Names;
import hu.guci.froccsfm.api.Order;
import hu.guci.froccsfm.api.Response;
import hu.guci.froccsfm.api.Tokens;
import spark.Spark;
import spark.staticfiles.MimeType;

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
