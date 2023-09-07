package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Home_2_Menu_1;
import com.example.demo_project.service.ifs.H_1_ifs_Menu_1;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;
import com.example.demo_project.vo.MenuReq;
import com.example.demo_project.vo.MenuReq2;
import com.example.demo_project.vo.MenuRes;
import com.example.demo_project.vo.MenuRes2;
import com.example.demo_project.vo.Order;

@RestController
public class MenuController {
	@Autowired
	H_1_ifs_Menu_1 h_1_ifs_Menu_1;

	@PostMapping(value = "/api/getfood")
	public MenuRes getfoodprice(@RequestBody MenuReq request) {
		MenuRes res = new MenuRes();
		Map<String, Integer> map = new HashMap<>();
		Home_2_Menu_1 menu = h_1_ifs_Menu_1.getfoodprice(request.getFood());
		map.put("牛cow", 100);
		map.put("小G雞", 90);
		map.put("羊ㄇㄟㄇㄟ", 80);

		if (request.getFood().equals("菜單")) {
			for (var food : map.entrySet()) {
				food.getKey();
				food.getValue();
			}
			res.setMap(map);
		} else {
			res.setMessage("輸入<菜單>二字");
			return res;
		}

		return res;

	}

	private static Map<String, Integer> menumap;
	static {
		menumap = new LinkedHashMap<>();
		menumap.put("beef", 120);
		menumap.put("pork", 110);
		menumap.put("chicken", 100);
	}

	@PostMapping(value = "/api/getfood2")
	public MenuRes2 getTotal(@RequestBody MenuReq request) {
		MenuRes2 res = new MenuRes2();
		String result = h_1_ifs_Menu_1.getTotal(request.getOrderMenu());
//		Map<Home_2_Menu_1, Integer> map = new HashMap<>();
//		String x = "";
//		int y = 0;
//		map.put(new Home_2_Menu_1("牛牛", 120), 5);
//		map.put(new Home_2_Menu_1("雞雞", 110), 3);
//		map.put(new Home_2_Menu_1("羊羊", 100), 6);
//		if (request.equals("點菜")) {
//			for (var food : map.entrySet()) {
//				res.setFood((menu.getName() + food.getValue() + "份" + "總共" + (menu.getPrice() * food.getValue())));
//				y += menu.getPrice() * food.getValue();
//			}
//		}
//		if (y > 500) {
//			y = (int) (y * 0.9);
//		}
//		res.setFood(x);
		res.setOrderMenu(result);
		return res;

	}

//=============================================================
	@PostMapping(value = "/api/getfood3")
	public Order order() {

		return h_1_ifs_Menu_1.ordermenu();

	}
	@PostMapping(value = "/api/getfood4")
	public Home_2_Menu_1 gete(@RequestBody MenuReq2 name) {
		Home_2_Menu_1 menu = h_1_ifs_Menu_1.getMenu(name.getName());
		return menu;
		
	}

}
