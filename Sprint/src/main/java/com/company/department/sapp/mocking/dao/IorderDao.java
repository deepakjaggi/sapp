package com.company.department.sapp.mocking.dao;

import java.sql.SQLException;

import com.company.department.sapp.mocking.dto.Order;

public interface IorderDao {

	int create(Order order) throws SQLException;	
	
}
