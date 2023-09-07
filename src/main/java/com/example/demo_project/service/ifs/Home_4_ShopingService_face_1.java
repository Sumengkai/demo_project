package com.example.demo_project.service.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_4_Shoping_1;
@Service
public interface Home_4_ShopingService_face_1 {
	public Home_4_Shoping_1 queryProducts(List<String> nameList,List<Home_4_Shoping_1> productList);
	public Home_4_Shoping_1 checkout(List<Home_4_Shoping_1> productList);
	public Home_4_Shoping_1 check(Home_4_Shoping_1 checkk);
	
}
