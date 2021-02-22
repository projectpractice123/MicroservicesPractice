package com.example.microservice.shoppingdata.commons.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@Column(name = "id")
	private int id;
	private String name;
	private String email;
	
	
 
	@OneToMany(mappedBy = "customer_id", fetch = FetchType.LAZY )
	private Set<CustomerOrder> orders = new HashSet<CustomerOrder>();
	
	public Customer() {
	}

	public Customer(int id, String name,String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	 
 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CustomerOrder> orders) {
		this.orders = orders;
	}

	 
	
}
