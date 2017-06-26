/**
 * 
 */
package hu.guci.froccsfm.server;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import com.google.gson.Gson;

import hu.areus.terminus.base.BaseClass;
import hu.guci.froccsfm.api.Order;

/**
 * Websocket handler.
 * @author adam.katona
 *
 */
@WebSocket
public class OrderWebSocketHandler extends BaseClass 
{
    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();
	private OrderDao dao = new OrderDao();
	private Gson gson = new Gson();
    
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception 
    {
        getLogger().debug("Client connected to websocket.");
        sessions.add(session);
        
        //--- Don't timeout
        session.setIdleTimeout(-1);
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) 
    {
    	getLogger().debug("Client disconnected from the websocket. Reason: " + reason);
    	sessions.remove(session);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) 
    {
        getLogger().debug("Websocket message: " + message);
        
        //--- Send back orders.
        try
        {
        	List<Order> orders = dao.getOrders();
        	session.getRemote().sendString(gson.toJson(orders));
        }
        catch (Exception ex)
        {
        	getLogger().error("Error while sending response: " + ex.getMessage(), ex);
        }
    }
    
    /**
     * Broadcast a message.
     * @param message
     */
    public void broadcast(String message)
    {
    	getLogger().debug("Broadcasting: " + message);
    	
    	for (Session session : sessions)
    	{
            try
            {
            	if (session.isOpen())
            	{
            		session.getRemote().sendString(message);
            	}
            }
            catch (Exception ex)
            {
            	getLogger().error("Error while sending response: " + ex.getMessage(), ex);
            }   		
    	}
    }
}
