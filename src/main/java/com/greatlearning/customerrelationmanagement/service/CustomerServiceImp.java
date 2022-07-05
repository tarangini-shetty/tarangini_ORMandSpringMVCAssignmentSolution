package com.greatlearning.customerrelationmanagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.customerrelationmanagement.entity.Customer;

@Repository
public class CustomerServiceImp implements CustomerService{
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public CustomerServiceImp(SessionFactory sessionFactory) {
		super();
		
		this.sessionFactory = sessionFactory;
		try
		{
			this.session = this.sessionFactory.getCurrentSession();
		}
		catch(HibernateException exptn)
		{
			this.session = this.sessionFactory.openSession();
		}
	}
	
	@Override
	public List<Customer> findAll(){
		List<Customer> customers = this.session.createQuery("from Customer").list();
		return customers;
		
	}
	
	@Override
	public Customer findById(long customerid) {
		Customer customer = this.session.get(Customer.class, customerid);
		return customer;		
		
	}
	
	@Override
	@Transactional
	public void save(Customer customer) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(customer);
		tx.commit();
	}
	
	@Override
	public void delete(long customerid) {
		Transaction tx = this.session.beginTransaction();
		Customer customer = this.session.get(Customer.class, customerid);
		this.session.delete(customer);
		tx.commit();
	}
	
	
	

}
