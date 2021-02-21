package com.example.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customerservice.model.Customer;
import com.example.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	// getting all Customer records	
	public List<Customer> getAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}

	// getting a specific record
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}

	public void saveOrUpdate(Customer customer) {
		customerRepository.save(customer);
	}

//	// deleting a specific record
//	public void delete(int id) {
//		customerRepository.deleteById(id);
//	}
}
