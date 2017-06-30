/**
 * 
 */
package hu.guci.froccsfm.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	                " ISFULFILLED    INT	 NOT NULL, " +
	                " ISVIP			 INT	 NOT NULL, " +
	                " CUSTOMERNAME   TEXT)");
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
			
			String sql = "INSERT INTO ORDERING (WINEAMOUNT, SODAAMOUNT, CREATED, NO, ISFULFILLED, ISVIP, CUSTOMERNAME) " +
	                   "VALUES (" +
	                   order.getWineAmount() + ", " +
	                   order.getSodaAmount() + ", " +
	                   "strftime('%Y.%m.%d %H:%M:%S', 'now'), " +
	                   currentNo + ", " +
	                   "0, " +
	                   (order.isVip() ? 1 : 0) + ", " +
	                   "?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, order.getCustomerName());
			statement.executeUpdate();
			statement.close();
			
			//--- Return id
			Statement statement2 = connection.createStatement();
			ResultSet rs = statement2.executeQuery("SELECT last_insert_rowid()");
			while (rs.next()) 
			{
				order.setId(rs.getInt(1));
			}
			
			statement2.close();
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
			ResultSet rs = statement.executeQuery("SELECT * FROM ORDERING WHERE ISFULFILLED = 0 ORDER BY CREATED DESC");
			
			List<Order> result = new ArrayList<>();
			while (rs.next()) 
			{
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setWineAmount(rs.getFloat("wineamount"));
				order.setSodaAmount(rs.getFloat("sodaamount"));
				order.setCreated(rs.getString("created"));
				order.setNo(rs.getInt("no"));
				order.setFulfilled(rs.getInt("isfulfilled") == 1);
				order.setVip(rs.getInt("isvip") == 1);
				order.setCustomerName(rs.getString("customername"));
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

	/**
	 * @param id
	 */
	public void fulFill(int id)
	{
		try(Connection connection = getConnection())
		{
			String sql = "UPDATE ORDERING SET ISFULFILLED = 1 WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
			connection.close();
			
			getLogger().debug("Order fulfilled: " + id);
		}	
		catch (Exception ex)
		{
			getLogger().error("Error while fulfilling order: " + ex.getMessage(), ex);
			throw new IllegalArgumentException(ex);
		}
	}
}
