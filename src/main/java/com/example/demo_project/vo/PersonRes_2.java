package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PersonRes_2 {
	private String name;
	private String id;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public void setId(String id) {
		this.id = id;
	}


	public Integer getAge() {
		return age;
	}
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public void setAge(Integer age) {
		this.age = age;
	}

}
