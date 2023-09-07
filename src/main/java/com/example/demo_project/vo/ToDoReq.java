package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoReq {
	
	private String name;
	private String id;
	private boolean isChecked;

	public ToDoReq() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	

}
