package com.example.customerservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerservice.OrderClient;
import com.example.customerservice.model.Customer;

@RestController
public class CustomerController {
	private List<Customer> customers = Arrays.asList(new Customer(1, "Joe Bloggs"), new Customer(2, "Jane Doe"));

	private OrderClient orderClient;

	public CustomerController(OrderClient orderClient) {
		this.orderClient = orderClient;
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customers;
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customers.stream().filter(customer -> customer.getId() == id).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
	 @GetMapping("/{id}/orders")
	    public Object getOrdersForCustomer(@PathVariable int id) {
	        return orderClient.getOrdersForCustomer(id);
	    }
}