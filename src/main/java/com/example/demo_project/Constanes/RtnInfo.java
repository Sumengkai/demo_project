package com.example.demo_project.Constanes;

public enum RtnInfo {
	SUCCESSFUL("200","���\"),
	PARAMTER_REQUIRED("400","�ʤ֥��n�Ѽ�"),
	DATA_REQUIRED("417","��g������"),
	FAILED("500", "���~�T��");
	private String code;
	private String message;

	private RtnInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
