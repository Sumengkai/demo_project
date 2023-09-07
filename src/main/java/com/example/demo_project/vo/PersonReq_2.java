package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonReq_2 {
	@JsonProperty("id")
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
