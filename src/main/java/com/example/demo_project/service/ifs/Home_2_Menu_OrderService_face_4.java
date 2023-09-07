package com.example.demo_project.service.ifs;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_3;
import com.example.demo_project.entity.Home_2_Menu_4;
@Service
public interface Home_2_Menu_OrderService_face_4 {
//	public void getsomeprice(Home_2_Menu_4 menu);
//	public int getTo(Home_2_Menu_4 menu);
	//============================================
//	public int getsomeToto(Home_2_Menu_4 menu);
	//============================================
	public Home_2_Menu_4 getsomeprice(Home_2_Menu_4 menu);
	public int getTotal(Map<Home_2_Menu_4, Integer> itemMap);
	public Home_2_Menu_4 getAll();
	public void getTotal2(Map<Home_2_Menu_4, Integer> itemMap);
}
