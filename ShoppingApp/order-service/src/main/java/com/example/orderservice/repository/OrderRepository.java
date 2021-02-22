package com.example.orderservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.shoppingdata.commons.entity.CustomerOrder;

 

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Integer>{
	
	public List<CustomerOrder> findByCustomerId(int customerId);

}
		