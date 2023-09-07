package com.example.demo_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	// "name" = hello.html���Ѽ�

//	@GetMapping(value = "/hello")
//	@RequestMapping(method=RequestMethod, value = "/hello") //�o�Ӥ����D
//	@PostMapping(value="/hello") //�o�ӷ|����
	@RequestMapping(value = "/hello") // �γo�ӳ̦n
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "hello.html";// �^�ǭ��� => html�x���� <thymeleaf>�u��^�ǭ���
//		return "hello"; //�o�ˤ]�i
	}
}
