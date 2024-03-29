package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //宣告為實體類
@Table(name = "person")
public class Person_2 {
	@Id						//主鍵
	@Column(name ="id")
	private String id;
	@Column(name ="name") //對應sql欄位
	private String name;	//跟上面不是一樣的
	@Column(name ="age")
	private int age;

	public Person_2() {
	}

	public Person_2(String name, String id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
