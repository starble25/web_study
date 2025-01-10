package com.app.dto;

public class Product {
	public String id;
	public String name;
	public int price;
	
//	spring
//	product.id = "id" // X
//	product.setId("id")	// O
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
