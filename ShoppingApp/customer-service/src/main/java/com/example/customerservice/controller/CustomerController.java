package com.example.customerservice.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerservice.OrderClient;
import com.example.microservice.shoppingdata.commons.entity.Customer;
import com.example.customerservice.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	//private List<Customer> customers = Arrays.asList(new Customer(1, "Joe Bloggs"), new Customer(2, "Jane Doe"));

	private OrderClient orderClient;

	public CustomerController(OrderClient orderClient) {
		this.orderClient = orderClient;
	}

	@GetMapping("/")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomer();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
//		return customers.stream().filter(customer -> customer.getId() == id).findFirst()
//				.orElseThrow(IllegalArgumentException::new);
	}
	
	@GetMapping("/{id}/orders")
    public Object getOrdersForCustomer(@PathVariable int id) {
        return orderClient.getOrdersForCustomer(id);
    }

	 
//	@DeleteMapping("/{id}")
//	private void deleteCustomer(@PathVariable("id") int id) {
//		customerService.delete(id);
//	}
	
	 
	@PostMapping("/")
	public int saveCustomer(@RequestBody Customer customer) {
		customerService.saveOrUpdate(customer);
		return customer.getCustomerId();
	}

	 
	@PostMapping("/all")
	public String saveCustomers(@RequestBody List<Customer> customers) {
		for (Customer customer : customers)
			customerService.saveOrUpdate(customer);
		return "Add Customers Successfully";
	}

//	@PostMapping("/{id}/orders")
//	public Object saveOrderForCustomer(@RequestBody Order order) {
//		return orderClient.saveOrdersForCustomer(order);
//	}
//	
//	@PostMapping("/{id}/orders/all")
//	public Object saveOrdersForCustomer(@RequestBody List<Order> orders) {
//		return orderClient.saveAllOrdersForCustomer(orders);
//	}
}