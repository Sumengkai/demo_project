package com.example.demo_project.service.ifs;

import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.H_menu_5;
import com.example.demo_project.entity.H_menu_5_2;
import com.example.demo_project.vo.H_menu_5_Req;
import com.example.demo_project.vo.H_menu_5_Res;

public interface H_menu_5_ifs {
	public H_menu_5 menu1(String food, int price);

	public List<H_menu_5> menu2();

	public H_menu_5 menu3(String food);
	
	public List<String> menu6(List<H_menu_5_Req>food);
	
	public List<String> menu7(Map<String,Integer> map);
	
	
}
