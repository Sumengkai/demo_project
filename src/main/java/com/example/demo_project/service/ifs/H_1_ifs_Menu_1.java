package com.example.demo_project.service.ifs;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_1;
import com.example.demo_project.entity.Home_2_Menu_4;
import com.example.demo_project.vo.MenuReq;
import com.example.demo_project.vo.Order;

@Service
public interface H_1_ifs_Menu_1 {
//public Home_2_Menu_1 getfoodprice(Map<String, Integer> itemMap); //取得餐點價格

	Home_2_Menu_1 getfoodprice(String name);
//	Home_2_Menu_1 getTotal(String name);
	String getTotal(Map<String, Integer> menumap);
	//===============================================
	
	public Order ordermenu();
	public Order ordermenu(List<Home_2_Menu_1> menulist);
	public Home_2_Menu_1 getMenu(String name);
}
