package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "customer_id")
	private int customerId;

	public Orders() {
	}
	

	public Orders(int id, String productName, String quantity, int customerId) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
