package com.example.demo_project.Constanes;

public enum RtnInfo {
	SUCCESSFUL("200","成功"),
	PARAMTER_REQUIRED("400","缺少必要參數"),
	DATA_REQUIRED("417","填寫完整資料"),
	FAILED("500", "錯誤訊息");
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
