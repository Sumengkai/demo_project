package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_1;
import com.example.demo_project.service.ifs.H_1_ifs_Menu_1;
import com.example.demo_project.vo.Order;

@Service
public class H_1_impl_Menu_1 implements H_1_ifs_Menu_1 {

	@Override
	public Home_2_Menu_1 getfoodprice(String name) {

		return null;
	}
//=========
	private Home_2_Menu_1 beef = new Home_2_Menu_1("beef", 100);
	private Home_2_Menu_1 pork = new Home_2_Menu_1("pork", 90);
	private Home_2_Menu_1 chick = new Home_2_Menu_1("chick", 80);
//=========
	@Override
	public String getTotal(Map<String, Integer> menumap) {
		String x = "";
		int y = 0;
		for (var s : menumap.entrySet()) {
			String orderMenuName = s.getKey();
			Integer orderMenuNum = s.getValue();
			x += "品項" + orderMenuName + "份數" + orderMenuNum + "價格" + orderMenuNum * menumap.get(orderMenuName);
		}
		// TODO Auto-generated method stub

		return x;
	}
	// ===============================================

	

	@Override
	public Order ordermenu() {
		List<Home_2_Menu_1> menulist = new ArrayList();
		beef.setNum(1);
		pork.setNum(2);
		chick.setNum(3);
		menulist.add(beef);
		menulist.add(pork);
		menulist.add(chick);
		int x = 0;
		for (Home_2_Menu_1 item : menulist) {
			int price = item.getPrice();
			int num = item.getNum();
			x += (price * num);
		}
		Order result = new Order();
		result.setMenu(menulist);
		result.setTotal(x);
		return result;
	}

	@Override
	public Order ordermenu(List<Home_2_Menu_1> menulist) {
		// TODO Auto-generated method stub
		int total = 0;
		for (Home_2_Menu_1  item :  menulist) {
			int price = item.getPrice();
			int num = item.getNum();
			total = total +(price*num);
		}
		Order result = new Order();
		result.setMenu(menulist);
		result.setTotal(total);
		return result;
	}



	@Override
	public Home_2_Menu_1 getMenu(String name) {
		Home_2_Menu_1 beef = new Home_2_Menu_1("beef", 100);
		Home_2_Menu_1 pork = new Home_2_Menu_1("pork", 90);
		Home_2_Menu_1 chick = new Home_2_Menu_1("chick", 80);
		//=====================
		if(name.equals(beef.getName())) {
			return beef;
		}else if(name.equals(pork.getName())) {
			return pork;
		}else if(name.equals(chick.getName())) {
			return chick;
		}else {
			return new Home_2_Menu_1();
		}
//		Home_2_Menu_1 menu = new Home_2_Menu_1(); //by name
		
		
	
	}


}
