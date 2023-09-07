package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.Constanes.RtnInfo;
import com.example.demo_project.entity.ToDo;
import com.example.demo_project.service.ifs.ToDoservice;
import com.example.demo_project.vo.ToDoReq;
import com.example.demo_project.vo.ToDoRes;

@CrossOrigin
@RestController
public class ToDo_Controller {
	@Autowired
	private ToDoservice toDoservice;

	@PostMapping("/getToDoList")
	public ToDoRes getToDoList(@RequestBody ToDoReq req) {
		List<ToDo> toDoListRes = new ArrayList<>();
		try {
			toDoListRes = StringUtils.hasText(req.getName()) ? toDoservice.getToDoList(req) : toDoservice.getToDoList();
		} catch (Exception e) {
			return new ToDoRes(RtnInfo.FAILED.getCode(), RtnInfo.FAILED.getMessage(), null);
		}
		return new ToDoRes(RtnInfo.SUCCESSFUL.getCode(), RtnInfo.SUCCESSFUL.getMessage(), toDoListRes);
	}

	// ---
	@PostMapping("/createToDo")
	public ToDoRes createToDo(@RequestBody ToDoReq req) {
		List<ToDo> toDoListRes = new ArrayList<>();
		try {
			if (!StringUtils.hasText(req.getName())) {
				return new ToDoRes(RtnInfo.DATA_REQUIRED.getCode(), RtnInfo.DATA_REQUIRED.getMessage(), null);
			}

			toDoservice.createToDo(req);
			toDoListRes = toDoservice.getToDoList();

		} catch (Exception e) {
			return new ToDoRes(RtnInfo.FAILED.getCode(), RtnInfo.FAILED.getMessage(), null);
		}
		return new ToDoRes(RtnInfo.SUCCESSFUL.getCode(), RtnInfo.SUCCESSFUL.getMessage(), toDoListRes);
	}

	// ---
	@PostMapping("/deleteToDo")
	public ToDoRes deleteToDo(@RequestBody ToDoReq req) {
		List<ToDo> toDoListRes = new ArrayList<>();

		try {
			if (!StringUtils.hasText(req.getId())) {
				return new ToDoRes(RtnInfo.DATA_REQUIRED.getCode(), RtnInfo.DATA_REQUIRED.getMessage(), null);
			}
			toDoservice.deleteToDo(req);
			toDoListRes = toDoservice.getToDoList();
		} catch (Exception e) {
			return new ToDoRes(RtnInfo.FAILED.getCode(), RtnInfo.FAILED.getMessage(), null);
		}
		return new ToDoRes(RtnInfo.SUCCESSFUL.getCode(), RtnInfo.SUCCESSFUL.getMessage(), toDoListRes);
	}

	// ---
	@PostMapping("/updateToDo")
	public ToDoRes updateToDo(@RequestBody ToDoReq req) {
		List<ToDo> toDoListRes = new ArrayList<>();

		try {
			if (!StringUtils.hasText(req.getId())) {
				return new ToDoRes(RtnInfo.DATA_REQUIRED.getCode(), RtnInfo.DATA_REQUIRED.getMessage(), null);
			}
			toDoservice.updateToDo(req);
			toDoListRes = toDoservice.getToDoList();
		} catch (Exception e) {
			return new ToDoRes(RtnInfo.FAILED.getCode(), RtnInfo.FAILED.getMessage(), null);
		}
		return new ToDoRes(RtnInfo.SUCCESSFUL.getCode(), RtnInfo.SUCCESSFUL.getMessage(), toDoListRes);

	}

	// ---
	@PostMapping("/setIsCheckedOfToDo")
	public ToDoRes setIsCheckedOfToDo(@RequestBody ToDoReq req) {
		List<ToDo> toDoListRes = new ArrayList<>();
		try {
			if (!StringUtils.hasText(req.getId())) {
				return new ToDoRes(RtnInfo.DATA_REQUIRED.getCode(), RtnInfo.DATA_REQUIRED.getMessage(), null);
			}
			toDoservice.setIsCheckedOfToDo(req);
			toDoListRes = toDoservice.getToDoList();
		} catch (Exception e) {
			return new ToDoRes(RtnInfo.FAILED.getCode(), RtnInfo.FAILED.getMessage(), null);
		}
		return new ToDoRes(RtnInfo.SUCCESSFUL.getCode(), RtnInfo.SUCCESSFUL.getMessage(), toDoListRes);

	}
}
