package com.example.demo_project.vo;

import com.example.demo_project.entity.Home_3_Bank_1;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRes {
	private String account; //id
	private int amount; //�l�B
	private String message; //�T��

	public String getAccount() {
		return account;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
