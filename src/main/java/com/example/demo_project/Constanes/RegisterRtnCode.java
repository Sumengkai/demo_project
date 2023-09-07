package com.example.demo_project.Constanes;

public enum RegisterRtnCode {
	SUCCESSFUL("200", "成功"),
	ACCOUNT_REQUIRED("400","NO ACCOUNT"),
	PWD_REQUIRED("400","NO PWD"),
	NAME_REQUIRED("400","NO NAME"),
	ACCOUNT_EXISTED("403","ACCOUNT EXISTED"),
	FAILURE("400","ACCTIVE FAIL"),
	ADD_ROLE_FAILURE("400","ROLE FAILURE"),
	ROLL_LIST_IS_EMPTY("400","ROLE LIST IS EMPTY");
	
	private String code;
	private String message;
	//只允許私有
	private RegisterRtnCode(String a, String b) {
		this.code = a;
		this.message = b;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
