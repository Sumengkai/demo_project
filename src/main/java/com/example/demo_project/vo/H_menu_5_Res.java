package com.example.demo_project.vo;

import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.H_menu_5;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)

public class H_menu_5_Res {
	
	private String food;
	
	private String message;
	
	private Integer price;
	
	private List<H_menu_5> list;
	
	private List<String> list2;

	private Integer num;
	
	private Map<String,Integer> map;
	public H_menu_5_Res() {} 
	public H_menu_5_Res (List<H_menu_5> list3) {
		this.list=list3;
	}
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<H_menu_5> getList() {
		return list;
	}

	public void setList(List<H_menu_5> list) {
		this.list = list;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getList2() {
		return list2;
	}

	public void setList2(List<String> list2) {
		this.list2 = list2;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
}
