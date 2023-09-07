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
							"�~�� : " + shop3.getName() + " ���� : " + shop3.getPrice() + " �w�s : " + shop3.getStorage());
					break;
				}

			}
			if (a == 0) {
				System.out.println(shop2 + "�S���o�ӪF�F");
			}

		}

		return null;
//		return shop;
	}

	@Override
	public Home_4_Shoping_1 checkout(List<Home_4_Shoping_1> productList) {
		for (Home_4_Shoping_1 shop5 : productList) {
			if (shop5.getStorage() >= shop5.getQuantity()) {
				System.out.println("�~��:" + shop5.getName() + " ���� : " + shop5.getPrice() + "�w�s :" + shop5.getStorage());
				int Total = shop5.getQuantity();
				shop5.setQuantity(Total);
				System.out.println("���ʶR�F" + Total + "��" + shop5.getName() + " �ӫ~�����B:" + (Total * shop5.getPrice()));
			}
		}

		return null;
	}

	@Override
	public Home_4_Shoping_1 check(Home_4_Shoping_1 checkk) {
		System.out.println("��誺���O���� : " + checkk.getName() + " �ӫ~�ʶR�ƶq : " + checkk.getQuantity() + " �ӫ~�����B : "
				+ (checkk.getPrice() * checkk.getQuantity()));
		return null;

	}
	//============================================================

}
