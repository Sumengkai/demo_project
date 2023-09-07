package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_3;
import com.example.demo_project.entity.Home_2_Menu_4;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_4;

@Service
public class Home_2_Menu_OrderService_impl_4 implements Home_2_Menu_OrderService_face_4 {

	@Override
	public Home_2_Menu_4 getsomeprice(Home_2_Menu_4 menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal(Map<Home_2_Menu_4, Integer> itemMap) {
		// TODO Auto-generated method stub
		String a = "";// 盿﹃int
		int sum = 0;// 羆基
		for (Map.Entry<Home_2_Menu_4, Integer> menuNum : itemMap.entrySet()) {
			Home_2_Menu_4 menu = menuNum.getKey();
			a += menu.getName() + " " + menuNum.getValue() + "" + (menu.getPrice() * menuNum.getValue()) + " じ" + "\n";
			sum += menu.getPrice() * menuNum.getValue();
//			int aa =menuNum.getValue();

		}
		System.out.println(a);// a=name+?+(基*计)
		System.out.println("羆基" + sum + "じ");
		return 0;
	}

	@Override
	public Home_2_Menu_4 getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// ============================================
	@Override
	public void getTotal2(Map<Home_2_Menu_4, Integer> itemMap) {
		int counter = 0;
		for (Map.Entry<Home_2_Menu_4, Integer> menuNum : itemMap.entrySet()) {
			if (counter > 2) {
				break;
			}
//			int value = itemMap.entrySet();
//			Map.Entry entry = null ;
//			int value = (int) entry.getValue();
//			Set set = itemMap.entrySet();
			Home_2_Menu_4 menus =  menuNum.getKey();
			System.out.println("獽讽:"+menus.getName()+"赣獽讽基"+menus.getPrice()+"赣獽讽羆基:"+(menus.getPrice()));			
			counter++;
			}

	}
}
