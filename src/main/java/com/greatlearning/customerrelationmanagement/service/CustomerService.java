package com.greatlearning.customerrelationmanagement.service;

import java.util.List;

import com.greatlearning.customerrelationmanagement.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	public Customer findById(long customerid);
	public void save(Customer customer);
	public void delete(long customerid);

}
