package com.example.microservice.shoppingdata.commons.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.CascadeType;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int customerId;
	private String name;
	private String email;
	
	
 
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Order> order = new ArrayList<Order	>();
	
	public Customer() {
	}

	public Customer(int customerId, String name,String email) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
	}

	 

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	 
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
}
