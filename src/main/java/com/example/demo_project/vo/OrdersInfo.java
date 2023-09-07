package com.example.demo_project.vo;

public class OrdersInfo {
	private int customerId;
	private String productName;
	private String name;
	private String quantity;

	public OrdersInfo() {
	}

	public OrdersInfo(int customerId, String productName, String name, String quantity) {
		this.customerId = customerId;
		this.productName = productName;
		this.name = name;
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
