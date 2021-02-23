package com.example.orderservice.repository;

import java.util.List;

import com.example.microservice.shoppingdata.commons.entity.CustomerOrder;

public interface OrderRepositoryCustom {
	public List<CustomerOrder> findByCustomerId(int customerId);
}
