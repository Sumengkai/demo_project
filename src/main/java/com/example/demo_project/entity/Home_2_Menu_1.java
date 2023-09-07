package com.example.demo_project.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Home_2_Menu_1 {
	String name;
	int price;
	int num;
	public Home_2_Menu_1() {}

	public Home_2_Menu_1(String name, int price) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.price=price;
	}


	public void Menu1() {
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

	public void setPrice(int money) {
		this.price = money;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	

}
