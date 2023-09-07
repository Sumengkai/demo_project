package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_1;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_2;

@Service
public class Home_2_Menu_OrderService_impl_2 implements Home_2_Menu_OrderService_face_2 {
//	List<String> food = new ArrayList<>();
//	List<Integer> amount = new ArrayList<>();
//	List<Integer> total = new ArrayList<>();

	@Override
	public Home_2_Menu_1 someprice(String beef) {
		Home_2_Menu_1 foodmenu = new Home_2_Menu_1();
		System.out.println("牛 , 雞 , 豬 三種");
		foodmenu.setName(beef);
		if (beef == "牛") {
			System.out.println(foodmenu.getName() + 100 + "元");
		} else if (beef == "雞") {
			System.out.println(foodmenu.getName() + 90 + "元");
		} else if (beef == "豬") {
			System.out.println(foodmenu.getName() + 80 + "元");
		} else {
			System.out.println("笑死");
		}

		return foodmenu;
	}

	@Override
	public Home_2_Menu_1 toto(String food, String food2, String food3, int a, int b, int c) {
		Home_2_Menu_1 foodmenu = new Home_2_Menu_1();
		System.out.println("牛 , 雞 , 豬 三種/各需要幾份");
		foodmenu.setName(food);
		foodmenu.setName(food2);
		foodmenu.setName(food3);
		foodmenu.setPrice((a * 100) + (b * 90) + (c * 80));
		if (foodmenu.getPrice() >= 500) {
			System.out.println(food + a + "份" + "總共" + (a * 100) + "元");
			System.out.println(food2 + b + "份" + "總共" + (b * 90) + "元");
			System.out.println(food3 + c + "份" + "總共" + (c * 80) + "元");
			System.out.println("原價" + foodmenu.getPrice() + " 滿五百 打九折 = " + foodmenu.getPrice() * 0.9);
		} else {
			System.out.println(food + a + "份" + "總共" + (a * 100) + "元");
			System.out.println(food2 + b + "份" + "總共" + (b * 90) + "元");
			System.out.println(food3 + c + "份" + "總共" + (c * 80) + "元");
			System.out.println(foodmenu.getPrice());
		}
		return foodmenu;

	}

	@Override
	public Home_2_Menu_1 toto2(String food, String food2, String food3, int a, int b, int c) {
		// TODO Auto-generated method stub
		Home_2_Menu_1 foodmenu = new Home_2_Menu_1();
		System.out.println("牛 , 雞 , 豬 三種選項/各需要幾份");
		foodmenu.setName(food);
		foodmenu.setName(food2);
		foodmenu.setName(food3);
		Scanner foodTotal = new Scanner(System.in);
		System.out.println("牛要幾個 : ");
		int cow = foodTotal.nextInt();
		System.out.println("雞要幾個 : ");
		int gg = foodTotal.nextInt();
		System.out.println("豬要幾個 : ");
		int dd = foodTotal.nextInt();
		foodmenu.setPrice((a * cow) + (b * gg) + (c * dd));
		if (foodmenu.getPrice() >= 500) {
			System.out.println(food + cow + "份" + "總共" + (a * cow) + "元");
			System.out.println(food2 + gg + "份" + "總共" + (b * gg) + "元");
			System.out.println(food3 + dd + "份" + "總共" + (c * dd) + "元");
			System.out.println("原價" + foodmenu.getPrice() + " 滿五百 打九折 = " + foodmenu.getPrice() * 0.9);
		} else {
			System.out.println(food + cow + "份" + "總共" + (a * cow) + "元");
			System.out.println(food2 + gg + "份" + "總共" + (b * gg) + "元");
			System.out.println(food3 + dd + "份" + "總共" + (c * dd) + "元");
			System.out.println("一共 "+foodmenu.getPrice()+"元");
		}
		
		return foodmenu;

	}

	@Override
	public Home_2_Menu_1 toto3() {
		Home_2_Menu_OrderService_impl_2 xx=new Home_2_Menu_OrderService_impl_2();
		Home_2_Menu_1 foodmenu2 = new Home_2_Menu_1();
		xx.toto2("牛", "雞", "豬", 100, 90, 80);
		

		
		return foodmenu2;
	}
}
