package com.example.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.shoppingdata.commons.entity.Order;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	// getting all Order records
	public List<Order> getAllOrder() {
		List<Order> orders = new ArrayList<Order>();
		orderRepository.findAll().forEach(order -> orders.add(order));
		return orders;
	}

	// getting a specific record
	public Order getOrderById(int id) {
		return orderRepository.findById(id).get();
	}

	// getting a all orders of a customer
	public List<Order> getOrderByCustomerId(int cutomerid) {
		return orderRepository.findByCustomerId(cutomerid);
	}

	public void saveOrUpdate(Order order) {
		orderRepository.save(order);
	}

//	// deleting a specific record
//	public void delete(int id) {
//		orderRepository.deleteById(id);
//	}
}
