package com.beetour1;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order_customer")
public class order {
	
	@Id
	private String id;
	private Date date;
	private Customer customer;
	private List<Customer> list;




	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", date=" + date + ", customer=" + customer + ", list=" + list + "]";
	}

	
	
	
}
