package com.example.demo_project.entity;

import org.springframework.stereotype.Service;

@Service
public class Home_1_Bird {
	String name;
	int age;

	public Home_1_Bird() {

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
