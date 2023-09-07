package com.example.demo_project.service.ifs;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_3;
@Service
public interface Home_2_Menu_OrderService_face_3 {
	public Home_2_Menu_3 someprice();
	void addmenu(Home_2_Menu_3 menus);
	int getTo1(Map<Home_2_Menu_3, Integer> itemMap);
	int getTo2(Map<Home_2_Menu_3, Integer> itemMap);
	int getTo3(Map<Home_2_Menu_3, Integer> itemMap);
	public void printMenuInfo(Map<Home_2_Menu_3, Integer> orderedMenuMap);
}
