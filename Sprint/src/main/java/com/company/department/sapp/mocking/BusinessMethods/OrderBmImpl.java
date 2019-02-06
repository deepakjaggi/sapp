package com.company.department.sapp.mocking.BusinessMethods;

import java.sql.SQLException;

import com.company.department.sapp.mocking.dao.IorderDao;
import com.company.department.sapp.mocking.dto.Order;
import com.company.department.sapp.mocking.exception.BOException;

public class OrderBmImpl implements IorderBm {

	private IorderDao orderDao;

	@Override
	public boolean placeOrder(Order order) throws BOException {	
		try {
			int result = orderDao.create(order);
			if (result!=0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public IorderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IorderDao orderDao) {
		this.orderDao = orderDao;
	}
}
