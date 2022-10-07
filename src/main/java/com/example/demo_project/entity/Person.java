package com.example.demo_project.entity;

public class Person { // entity
	private String name ="1";// entity
	private String id;// entity
	private String city ="3";// entity
	private int age = 4;// entity
	public Person() {
		
	}
//	public Preson(String name, String id, String city,int age) {
//		this.city = city;
//		this.name = name;
//		this.age = age;
//		this.id = id;
//	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
