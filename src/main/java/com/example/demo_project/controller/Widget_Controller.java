package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Widget;
import com.example.demo_project.service.ifs.Widget_ifs;

@RestController
public class Widget_Controller {
	@Autowired
	private Widget_ifs widget_ifs;
	@PostMapping(value = "/api/getwidget1")
	public Widget save() {
		return widget_ifs.save();
		
	}
}
