package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Home_2_Menu_1;

public class Order {
	private List<Home_2_Menu_1> menu;
	private int total;

	public List<Home_2_Menu_1> getMenu() {
		return menu;
	}

	public void setMenu(List<Home_2_Menu_1> menu) {
		this.menu = menu;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public Order(List<Home_2_Menu_1> menu,int total) {
		this.menu=menu;
		this.total=total;
	}
	public Order() {}

}
