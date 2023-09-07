package com.example.demo_project.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.example.demo_project.entity.Home_bank_1;
import com.fasterxml.jackson.annotation.JsonInclude;

public class H_bankRes_1 {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String account;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer amount;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String msssage;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMsssage() {
		return msssage;
	}

	public void setMsssage(String msssage) {
		this.msssage = msssage;
	}

}
