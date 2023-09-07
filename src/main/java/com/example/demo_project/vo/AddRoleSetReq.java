package com.example.demo_project.vo;

import java.util.Set;

public class AddRoleSetReq {
private String account;
private Set<String> roleset;
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public Set<String> getRoleset() {
	return roleset;
}
public void setRoleset(Set<String> roleset) {
	this.roleset = roleset;
}

}
