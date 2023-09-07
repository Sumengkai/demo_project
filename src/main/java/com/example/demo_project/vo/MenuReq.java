package com.example.demo_project.vo;

import java.util.Map;

import com.example.demo_project.entity.Home_2_Menu_1;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuReq {
	@JsonProperty("getfoodprice")
	private String food;
	@JsonProperty("getfoodprice2")
	private Map<String,Integer> orderMenu;
	public MenuReq() {}
	

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}


	public Map<String, Integer> getOrderMenu() {
		return orderMenu;
	}


	public void setOrderMenu(Map<String, Integer> orderMenu) {
		this.orderMenu = orderMenu;
	}
	//===============================================
	
	
}
