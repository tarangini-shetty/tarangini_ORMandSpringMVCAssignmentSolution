package com.greatlearning.customerrelationmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerrelationmanagement.entity.Customer;
import com.greatlearning.customerrelationmanagement.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService CustomerService;
	
	@RequestMapping("/list")
	public String listCustomer(Model themodel) {
		List<Customer> theCustomers= CustomerService.findAll();
		themodel.addAttribute("customers", theCustomers);
		return "list-customers";
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String ShowFormForAdd(Model themodel) {
		Customer customer = new Customer();
		themodel.addAttribute("customer",customer);
		themodel.addAttribute("mode","Add");
		return "customer-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String ShowFormForUpdate(@RequestParam("customerId") long customerId, Model themodel) {
		Customer customer = CustomerService.findById(customerId);
		themodel.addAttribute("customer",customer);
		themodel.addAttribute("mode", "Update");				
		return "customer-form";		
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("customerId") long customerid, @RequestParam("firstName") String firstname,
			@RequestParam("lastName") String lastname,
			@RequestParam("email") String email) {
		
		Customer customer = null;
		if(customerid == 0) {
			customer = new Customer(firstname, lastname, email);		
		}
		else {
			customer = CustomerService.findById(customerid);
			customer.setFirstname(firstname);
			customer.setLastname(lastname);
			customer.setEmail(email);

		}
		CustomerService.save(customer);
		return "redirect:list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") long customerId) {
		CustomerService.delete(customerId);
		return "redirect:list";
		
	}
	
	
	
	
}
