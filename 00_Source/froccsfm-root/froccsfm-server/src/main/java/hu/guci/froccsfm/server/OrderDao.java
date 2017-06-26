/**
 * 
 */
package hu.guci.froccsfm.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.areus.terminus.base.BaseClass;
import hu.guci.froccsfm.api.Names;
import hu.guci.froccsfm.api.Order;

/**
 * Order Data Access.
 * @author adam.katona
 *
 */
public class OrderDao extends BaseClass 
{
	private static int currentNo = 0;
	
	/**
	 * Get a connection.
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:sqlite:froccsfm.db");
	}
	
	/**
	 * Init tables and stuff.
	 */
	public void init()
	{
		try(Connection connection = getConnection())
		{
			Statement statement = connection.createStatement();
			//statement.execute("DROP TABLE ORDERING");
			statement.execute("CREATE TABLE if not exists ORDERING " +
	                "(ID INTEGER PRIMARY KEY," +
	                " WINEAMOUNT     REAL    NOT NULL, " + 
	                " SODAAMOUNT     REAL    NOT NULL, " + 
	                " CREATED        TEXT	 NOT NULL, " + 
	                " NO             INT	 NOT NULL, " +
	                " FULFILLED      INT	 NOT NULL)");
			statement.close();
			connection.close();
		}
		catch (Exception ex)
		{
			getLogger().error("Error while initializing tables: " + ex.getMessage(), ex);
		}
	}
	
	/**
	 * Store an order, return order number.
	 * @param order
	 * @return
	 */
	public int storeOrder(Order order)
	{
		try(Connection connection = getConnection())
		{
			synchronized(this) 
			{
				advanceCurrentNo();	
			}
			
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO ORDERING (WINEAMOUNT, SODAAMOUNT, CREATED, NO, FULFILLED) " +
	                   "VALUES (" +
	                   order.getWineAmount() + ", " +
	                   order.getSodaAmount() + ", " +
	                   "strftime('%Y.%m.%d %H:%M:%S', 'now'), " +
	                   currentNo + ", " +
	                   "0)";
			
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
			
			return currentNo;
		}	
		catch (Exception ex)
		{
			getLogger().error("Error while storing order: " + ex.getMessage(), ex);
			throw new IllegalArgumentException(ex);
		}
	}
	
	/**
	 * Get current orders
	 * @return
	 */
	public List<Order> getOrders()
	{
		try(Connection connection = getConnection())
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ORDERING WHERE FULFILLED = 0 ORDER BY CREATED DESC");
			
			List<Order> result = new ArrayList<>();
			while (rs.next()) 
			{
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setWineAmount(rs.getFloat("wineamount"));
				order.setSodaAmount(rs.getFloat("sodaamount"));
				order.setCreated(rs.getString("created"));
				order.setNo(rs.getInt("no"));
				order.setFulfilled(rs.getInt("fulfilled") == 1);
				order.setName(Names.getName(order.getWineAmount(), order.getSodaAmount()));
				result.add(order);
			}

			rs.close();
			statement.close();
			connection.close();
			
			return result;
		}
		catch (Exception ex)
		{
			getLogger().error("Error while getting orders: " + ex.getMessage(), ex);
			throw new IllegalArgumentException(ex);
		}
	}

	
	/**
	 * Advance the number.
	 */
	private static void advanceCurrentNo() 
	{
		currentNo++;
		
		if (currentNo > ConfigurationHelper.getInstance().getMaxOrderNo())
		{
			currentNo = 1;
		}
	}
}
