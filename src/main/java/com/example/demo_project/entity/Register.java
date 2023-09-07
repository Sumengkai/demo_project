package com.example.demo_project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register {
	@Id
	@Column(name = "account")
	private String account;
	@Column(name = "pwd")
	private String pwd;
	@Column(name = "age")
	private int age;
	@Column(name = "city")
	private String city;
	@Column(name = "reg_time")
	private Date reg_time;
	@Column(name = "active")
	private boolean active;
	//會有多個 用逗號區隔 impl 68行
	@Column(name = "role")
	private String role;
	@Column(name = "name")
	private String name;

	public Register() {
	}
	public Register(String name, String account, String city, String pwd, int age) {
		this.account=account;
		this.name=name;
		this.city=city;
		this.pwd=pwd;
		this.age=age;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getReg_time() {
		return reg_time;
	}

	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}

	public boolean isActuve() {
		return active;
	}

	public void setActuve(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
