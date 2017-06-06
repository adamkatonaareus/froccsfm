package hu.guci.froccsfm.server;

import java.util.List;

import org.junit.Test;

import hu.areus.terminus.testsupport.BaseTestClass;
import hu.guci.froccsfm.api.Order;

/**
 * Unit test for Order DAO
 */
public class OrderDaoTest extends BaseTestClass
{
	/**
	 * Test ordering.
	 */
	@Test
	public void testStoreOrder()
	{
		OrderDao dao = new OrderDao();
		dao.init();
		
		Order order = new Order();
		order.setWineAmount(3);
		order.setSodaAmount(2);
		
		for (int i=0; i<10; i++)
		{
			int no = dao.storeOrder(order);
			getLogger().debug("Order no: " + no);
		}
		
		testGetOrders();
	}
	
	/**
	 * Test getting orders.
	 */
	@Test
	public void testGetOrders()
	{
		OrderDao dao = new OrderDao();
		dao.init();
		
		List<Order> orders = dao.getOrders();
		
		for(Order order: orders)
		{
			getLogger().debug("Order: " + order.getId() + " no: " + order.getNo() + " created: " + order.getCreated());
		}
	}
}
