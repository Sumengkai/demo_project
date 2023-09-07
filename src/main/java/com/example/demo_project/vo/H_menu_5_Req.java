package com.example.demo_project.vo;

import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.H_menu_5;
import com.example.demo_project.entity.H_menu_5_2;
import com.fasterxml.jackson.annotation.JsonProperty;

public class H_menu_5_Req {
	@JsonProperty("food")
	private String food;
	@JsonProperty("price")
	private int price;
	@JsonProperty("num")
	private int num;
	@JsonProperty("list2")
	private List<H_menu_5_Req> list;
	@JsonProperty("map")
	private Map<String,Integer> map;

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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<H_menu_5_Req> getList() {
		return list;
	}

	public void setList(List<H_menu_5_Req> list) {
		this.list = list;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	
}
