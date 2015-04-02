package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface  CustomerDao extends BasisDao<Customer>  {

	public List<Customer> search(List<Object> columnList, List<Object> valueList, int startingAt, int maxPerPage);
	
	public List<Customer> generateCode(String code);
	

}