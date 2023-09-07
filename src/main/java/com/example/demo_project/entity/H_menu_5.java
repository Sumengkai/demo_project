package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu2")
public class H_menu_5 {
	@Id
	@Column(name = "food")
	private String food;
	@Column(name = "price")
	private int price;
	public H_menu_5() {
	}
	public H_menu_5(String food) {
		this.food=food;
	}
	public H_menu_5(String food,int price) {
		this.food=food;
		this.price=price;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
