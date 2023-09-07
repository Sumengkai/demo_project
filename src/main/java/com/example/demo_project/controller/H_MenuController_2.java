package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.H_menu_5;
import com.example.demo_project.entity.H_menu_5_2;
import com.example.demo_project.service.ifs.Bank_face_spr;
import com.example.demo_project.service.ifs.H_menu_5_ifs;
import com.example.demo_project.vo.H_menu_5_Req;
import com.example.demo_project.vo.H_menu_5_Res;

@RestController
public class H_MenuController_2 {
	@Autowired
	private H_menu_5_ifs menu5_ifs;

	@PostMapping(value = "/api/menu1")
	public H_menu_5_Res getmenu1(@RequestBody H_menu_5_Req req) {
		H_menu_5_Res res = new H_menu_5_Res();
		H_menu_5 menu = menu5_ifs.menu1(req.getFood(), req.getPrice());
		if (menu == null) {
			res.setFood("不可重複或food為空");
			return res;
		}
		res.setFood(menu.getFood());
		res.setPrice(menu.getPrice());
		return res;

	}

	@PostMapping(value = "/api/menu2")
	public H_menu_5_Res getmenu2() {
		//==
//		H_menu_5_Res res = new H_menu_5_Res();
//		List<H_menu_5> a = menu5_ifs.menu2();
//		res.setList(a);
//		return res;
		//==簡寫步驟 1.
//		List<H_menu_5> b = menu5_ifs.menu2();
//		H_menu_5_Res res = new H_menu_5_Res(b);
//		return res;
		//==簡寫步驟 2. >
		return new H_menu_5_Res(menu5_ifs.menu2());
		//==
	}

	@PostMapping(value = "/api/menu3")
	public H_menu_5_Res getmenu3(@RequestBody H_menu_5_Req req) {
		H_menu_5_Res res = new H_menu_5_Res();
		H_menu_5 menu = menu5_ifs.menu3(req.getFood());
		if (menu == null) {
			res.setFood("不能空");
			return res;
		}
		res.setFood(menu.getFood());
		res.setPrice(menu.getPrice());
		return res;
	}

	@PostMapping(value = "/api/menu6")
	public H_menu_5_Res getmenu6(@RequestBody H_menu_5_Req req) {
		H_menu_5_Res res = new H_menu_5_Res();
		List<String> a = menu5_ifs.menu6(req.getList());
		res.setList2(a);
		return res;

	}

	@PostMapping(value = "/api/menu7")
	public H_menu_5_Res getmenu7(@RequestBody H_menu_5_Req req) {
		H_menu_5_Res res = new H_menu_5_Res();
//		Map<String,Integer> map = menu5_ifs.menu7(req.getMap());
		List<String> menulist = menu5_ifs.menu7(req.getMap());
		res.setList2(menulist);
		return res;

	}
}
