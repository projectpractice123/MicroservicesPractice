package com.example.orderservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.orderservice.ResponseWrapper;
import com.example.microservice.shoppingdata.commons.entity.CustomerOrder;
import com.example.orderservice.service.OrderService;

@RestController
public class OrderController {
//	private final List<Order> orders = Arrays.asList(new Order(1, 1, "Product A"), new Order(2, 1, "Product B"),
//			new Order(3, 2, "Product C"), new Order(4, 1, "Product D"), new Order(5, 2, "Product E"));
	private List<CustomerOrder> orders = new ArrayList<>();
	@Autowired
	OrderService orderService;
	private final Environment environment;

	@Autowired
	public OrderController(final Environment environment) {
		this.environment = environment;
	}

//	    @GetMapping()
//	    public List<Order> getAllOrders() {
//	        return  orderService.getAllOrder();
//	    }

	@GetMapping("/{id}")
	public CustomerOrder getOrderById(@PathVariable int id) {
//	        return orders.stream()
//	                     .filter(order -> order.getId() == id)
//	                     .findFirst()
//	                     .orElseThrow(IllegalArgumentException::new);
	 	return orderService.getOrderById(id);
	}

	@GetMapping("/")
	public ResponseWrapper<List<CustomerOrder>> getOrdersForCustomer(@RequestParam(required = false) Integer customerId) {
//		if (customerId != null) {
//			return new ResponseWrapper<>(environment, orders.stream()
//					.filter(order -> customerId.equals(order.getCustomerId())).collect(Collectors.toList()));
//		}

		if (customerId != null) {
			orders = orderService.getOrderByCustomerId(customerId);
			return new ResponseWrapper<>(environment, orders);
		}
		return new ResponseWrapper<>(environment, orders);
	}
	
	
	@PostMapping("/")
	public int saveOrder(@RequestBody CustomerOrder order) {
		orderService.saveOrUpdate(order);
		return order.getId();
	}

	 
	@PostMapping("/all")
	public String saveOrders(@RequestBody List<CustomerOrder> orders) {
		for (CustomerOrder order : orders)
			orderService.saveOrUpdate(order);
		return "Added Orders Successfully";
	}

}