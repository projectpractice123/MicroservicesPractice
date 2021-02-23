package com.example.customerservice.repository;

import org.springframework.data.repository.CrudRepository;
 
import org.springframework.stereotype.Repository;

import com.example.microservice.shoppingdata.commons.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
	