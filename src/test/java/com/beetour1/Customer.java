package com.beetour1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//注意这里的注解哦，简单看看mongodb的文档就知道这个是文档集合
@Document(collection="customer_int")
public class Customer {

 @Id
 private String id;

 private int firstName;
 private int lastName;
 
 
@Override
public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getFirstName() {
	return firstName;
}
public void setFirstName(int firstName) {
	this.firstName = firstName;
}
public int getLastName() {
	return lastName;
}
public void setLastName(int lastName) {
	this.lastName = lastName;
}

 
}