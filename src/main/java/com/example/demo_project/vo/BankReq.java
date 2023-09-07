package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankReq {
	@JsonProperty("account") // ­n±a¤Jpostman
	private String account; 
	@JsonProperty("deposit")
	private int deposit;
	@JsonProperty("withdraw")
	private int withdraw;
	public BankReq() {
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	
	

}
