package com.example.mockitoTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.company.department.sapp.mocking.BusinessMethods.OrderBmImpl;
import com.company.department.sapp.mocking.dao.OrderDaoImpl;
import com.company.department.sapp.mocking.dto.Order;
import com.company.department.sapp.mocking.exception.BOException;

public class OrderBmImplTests {
	
	private OrderBmImpl orderBm;
	
	private OrderDaoImpl orderDao;
	
	
	@BeforeEach
	void setup()
	{
		MockitoAnnotations.initMocks(this);
		orderBm=new OrderBmImpl();
		// Now we want to mock this Implementation class.
		orderDao = mock(OrderDaoImpl.class);
		orderBm.setOrderDao(orderDao);
	}
	
	@Test
	public void placeOrder_should_createAnOrder() throws SQLException, BOException {
		
		Order order=new Order();		
		try
		{
			when(orderDao.create(order)).thenReturn(new Integer(1));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		boolean result = orderBm.placeOrder(order);	
		assertTrue(result);	
	}
}
