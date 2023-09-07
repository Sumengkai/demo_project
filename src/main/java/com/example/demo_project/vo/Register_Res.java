package com.example.demo_project.vo;

import com.example.demo_project.entity.Register;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) // 全部
public class Register_Res {
	@JsonInclude(JsonInclude.Include.NON_NULL) // 個別
	@JsonProperty("register_info")
	private Register register;
	private String message;
	@JsonProperty("verify_Code")
	private int verifyCode;

	public Register_Res() {
	}

	public Register_Res(String message) {
		this.message = message;
	}

	public Register_Res(Register reg, String message) {
		this.register = reg;
		this.message = message;
	}

	public Register_Res(Register reg, String message, int verifyCode) {
		this.register = reg;
		this.message = message;
		this.verifyCode = verifyCode;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

}
