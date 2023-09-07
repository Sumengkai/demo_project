package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_3;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_3;

@Service
public class Home_2_Menu_OrderService_impl_3 implements Home_2_Menu_OrderService_face_3 {
	private Map<String, Integer> menumap = new HashMap();

	@Override
	public int getTo1(Map<Home_2_Menu_3, Integer> itemMap) {
		int total = 0;
		for (Entry<Home_2_Menu_3, Integer> item : itemMap.entrySet()) {
			Home_2_Menu_3 homemenu = item.getKey();
			int itemprice = homemenu.getPrice();
			int num = item.getValue();
			total += itemprice * num;
		}
		if (total >= 500) {
			total = (int) (total * 0.9);
		}
		System.out.println(total);
		return 0;
	}

	@Override
	public void addmenu(Home_2_Menu_3 menus) {
		menumap.put(menus.getName(), menus.getPrice());
		System.out.println("add new menu : " + menus.getName() + " price : " + menus.getPrice());
	}

	@Override
	public Home_2_Menu_3 someprice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTo3(Map<Home_2_Menu_3, Integer> itemMap) {
		int total = 0;
		for (Entry<Home_2_Menu_3, Integer> item : itemMap.entrySet()) {

			Home_2_Menu_3 homemenu = item.getKey(); // 餐點
			int itemprice = homemenu.getPrice(); // 價格
			int num = item.getValue(); // 份數
			total += itemprice * num;
		}
		if (total >= 500) {

			total = (int) (total * 0.9);

			System.out.println("五折 : " + total);
		}

		return 0;

	}

	@Override
	public int getTo2(Map<Home_2_Menu_3, Integer> itemMap) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void printMenuInfo(Map<Home_2_Menu_3, Integer> orderedMenuMap) {
		String info = ""; //帶入字串加int
		int sum = 0;
		int idx = 0;
		for (var menuNum : orderedMenuMap.entrySet()) {
			idx++;
			Home_2_Menu_3 menu = menuNum.getKey();
			info += menu.getName() + " " + menuNum.getValue() + "份 " + menu.getPrice() * menuNum.getValue()
					+ "塊" 
//					+ (idx == orderedMenuMap.entrySet().size() ? "" : "\n");
					+ "\n";
			sum += menu.getPrice() * menuNum.getValue();
		}
		if (sum > 500) {
			sum = (int) (sum * 0.9);
		}
		System.out.println(info);
		System.out.println("總價格：" + sum + "塊");
	}

}
