package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuReq2 {
	@JsonProperty("name")
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
