package com.example.demo_project.vo;

import java.util.Map;

import com.example.demo_project.entity.Home_2_Menu_1;
import com.fasterxml.jackson.annotation.JsonInclude;

public class MenuRes {
	private String message;
	private Map<String,Integer>map;

	
	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public String getMessage() {
		return message;
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public void setMessage(String message) {
		this.message = message;
	}
//===============================================
	
	
	
	
	
	
}
