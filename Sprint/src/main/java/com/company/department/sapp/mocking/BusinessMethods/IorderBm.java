package com.company.department.sapp.mocking.BusinessMethods;

import com.company.department.sapp.mocking.dto.Order;
import com.company.department.sapp.mocking.exception.BOException;

public interface IorderBm {
	
	boolean placeOrder(Order order) throws BOException;	
	
}