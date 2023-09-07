package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //把Entity變成實體類
@Table(name = "bank") // 連結資料庫
public class Home_bank_1 {
	@Id
	@Column(name = "account")
	private String account;
	@Column(name = "amount")
	private int amount;
	@Column(name = "name")
	private String name;

	public Home_bank_1() {
	}

	public Home_bank_1(String account) {
		this.account = account;
	}

	public Home_bank_1(String account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
