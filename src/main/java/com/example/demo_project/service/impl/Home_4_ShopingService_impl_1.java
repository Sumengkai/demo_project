package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_4_Shoping_1;
import com.example.demo_project.service.ifs.Home_4_ShopingService_face_1;

@Service
public class Home_4_ShopingService_impl_1 implements Home_4_ShopingService_face_1 {

	@Override
	public Home_4_Shoping_1 queryProducts(List<String> nameList, List<Home_4_Shoping_1> productList) {
		for (String shop2 : nameList) {
			int a = 0;
			for (Home_4_Shoping_1 shop3 : productList) {
				if (shop2.equals(shop3.getName())) {
					a += 1;
					System.out.println(
							"品項 : " + shop3.getName() + " 價格 : " + shop3.getPrice() + " 庫存 : " + shop3.getStorage());
					break;
				}

			}
			if (a == 0) {
				System.out.println(shop2 + "沒有這個東東");
			}

		}

		return null;
//		return shop;
	}

	@Override
	public Home_4_Shoping_1 checkout(List<Home_4_Shoping_1> productList) {
		for (Home_4_Shoping_1 shop5 : productList) {
			if (shop5.getStorage() >= shop5.getQuantity()) {
				System.out.println("品項:" + shop5.getName() + " 價格 : " + shop5.getPrice() + "庫存 :" + shop5.getStorage());
				int Total = shop5.getQuantity();
				shop5.setQuantity(Total);
				System.out.println("我購買了" + Total + "個" + shop5.getName() + " 該品項全額:" + (Total * shop5.getPrice()));
			}
		}

		return null;
	}

	@Override
	public Home_4_Shoping_1 check(Home_4_Shoping_1 checkk) {
		System.out.println("剛剛的消費明細 : " + checkk.getName() + " 該品購買數量 : " + checkk.getQuantity() + " 該品項全額 : "
				+ (checkk.getPrice() * checkk.getQuantity()));
		return null;

	}
	//============================================================

}
