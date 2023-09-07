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

	// "name" = hello.html的參數

//	@GetMapping(value = "/hello")
//	@RequestMapping(method=RequestMethod, value = "/hello") //這個不知道
//	@PostMapping(value="/hello") //這個會報錯
	@RequestMapping(value = "/hello") // 用這個最好
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "hello.html";// 回傳頁面 => htmlㄉ頁面 <thymeleaf>只能回傳頁面
//		return "hello"; //這樣也可
	}
}
