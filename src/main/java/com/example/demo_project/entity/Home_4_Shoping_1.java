package com.example.demo_project.entity;

public class Home_4_Shoping_1 {
	private String name;
	private int price;
	private int quantity;
	private int storage;

	public Home_4_Shoping_1() {

	}
	public Home_4_Shoping_1(String name, int price,  int storage) {
		this.name = name;
		this.price = price;
		this.storage = storage;
	}

	public Home_4_Shoping_1(String name, int price, int quantity, int storage) {
		this.name = name;
		this.price = price;
		this.quantity =quantity;
		this.storage = storage;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
}
