package com.example.demo_project.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRoleListReq {
private String account;
@JsonProperty("List")
private List<String> list;
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public List<String> getList() {
	return list;
}
public void setList(List<String> list) {
	this.list = list;
}

}
