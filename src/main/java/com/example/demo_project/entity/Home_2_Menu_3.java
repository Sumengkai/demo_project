package com.example.demo_project.entity;

import org.springframework.stereotype.Service;

@Service
public class Home_2_Menu_3 {
	private String name;
	private int price;
	
	public Home_2_Menu_3() {
		
	}
	public Home_2_Menu_3(String name, int price) {
		this.name = name;
		this.price = price;
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
