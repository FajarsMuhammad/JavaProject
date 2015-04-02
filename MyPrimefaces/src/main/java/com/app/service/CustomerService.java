package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.CustomerDao;
import com.app.model.Customer;

@Component("customerService")
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void save(Customer customer) {
		customerDao.save(customer);
	}

	public List<Customer> findAllCustomer() {
		return customerDao.findAll();
	}

	public Customer searchCustomerById(long id) {
		return customerDao.findById(id);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	
	public List<Customer> generateCode(String code) {
		return customerDao.generateCode(code);
	}
	
	
	public List<Customer> searchCustomer(List<Object> columnList, List<Object> valueList, int startingAt, int maxPerPage){
		return customerDao.search(columnList, valueList, startingAt, maxPerPage);
	}

}