package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.ToDo;

public class ToDoRes {
	private String code;
	private String message;
	private List<ToDo> list;

	public ToDoRes() {
	}

	public ToDoRes(String code, String message, List<ToDo> list) {
		this.code = code;
		this.message = message;
		this.list = list;
	}

	public List<ToDo> getList() {
		return list;
	}

	public void setList(List<ToDo> list) {
		this.list = list;
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
