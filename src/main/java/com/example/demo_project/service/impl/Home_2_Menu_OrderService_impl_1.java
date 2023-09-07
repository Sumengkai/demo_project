package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_1;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_1;

@Service
public class Home_2_Menu_OrderService_impl_1 implements Home_2_Menu_OrderService_face_1 {
	List<String> food = new ArrayList<>();
	List<Integer> total = new ArrayList<>();
	@Override
	public Home_2_Menu_1 Menu1() {
		 Home_2_Menu_1 foodMenu = new  Home_2_Menu_1();
		System.out.println("菜單有 1.牛排 2.機掰 3.豬排 請輸入你想吃的 : ");
		Scanner scan = new Scanner(System.in);
		String food = scan.nextLine();
		if (food.equals("牛排")) {
			System.out.println("牛排 的價格為 :" + 100);
		} else if (food.equals("機掰")) {
			System.out.println("機掰 的價格為 :" + 80);
		} else if (food.equals("豬排")) {
			System.out.println("豬排 的價格為 :" + 90);
		} else {
			System.out.println("滾回去吃屎");
		}
		return foodMenu;
	}

//==================================================
	@Override
	public Home_2_Menu_1 Menu3(String fooda, String foodb, String foodc, int a, int b, int c) {
		Home_2_Menu_1 foodMenu3 = new Home_2_Menu_1();
		System.out.println("菜單上有 : " + fooda + foodb + foodc + "三種選項");
		Scanner scan3 = new Scanner(System.in);
		System.out.println("請問" + fooda + "需要幾份 : ");
		int aa = scan3.nextInt();
		System.out.println("請問" + foodb + "需要幾份 : ");
		int bb = scan3.nextInt();
		System.out.println("請問" + foodc + "需要幾份 : ");
		int cc = scan3.nextInt();
		int beefmoney = a * aa;
		int ggmoney = b * bb;
		int pigmoney = c * cc;
		int total = beefmoney + ggmoney + pigmoney;
		if (total >= 500) {
			System.out.println(
					"因為滿500打九折 所以餐點價格 總共為 " + (total * 0.9) + " 元 " + " ,幫你省下了" + (total - (total * 0.9)) + " 元");
		} else {
			System.out.println(fooda + "總共" + aa + " 份" + fooda + "這樣是" + beefmoney + "元");
			System.out.println(foodb + "總共" + bb + " 份" + foodb + "這樣是" + ggmoney + "元");
			System.out.println(foodc + "總共" + cc + " 份" + foodc + "這樣是" + pigmoney + "元");
			System.out.println("全部是" + total + "元");
		}
		return foodMenu3;

	}

	@Override
	public Home_2_Menu_1 Menu2() {
		// TODO Auto-generated method stub
		
		food.add("牛");
		food.add("雞");
		food.add("豬");
		total.add(100);
		total.add(90);
		total.add(80);
		return null;
	}

}
