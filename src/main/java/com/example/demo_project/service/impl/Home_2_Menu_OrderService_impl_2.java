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
		System.out.println("�� , �� , �� �T��");
		foodmenu.setName(beef);
		if (beef == "��") {
			System.out.println(foodmenu.getName() + 100 + "��");
		} else if (beef == "��") {
			System.out.println(foodmenu.getName() + 90 + "��");
		} else if (beef == "��") {
			System.out.println(foodmenu.getName() + 80 + "��");
		} else {
			System.out.println("����");
		}

		return foodmenu;
	}

	@Override
	public Home_2_Menu_1 toto(String food, String food2, String food3, int a, int b, int c) {
		Home_2_Menu_1 foodmenu = new Home_2_Menu_1();
		System.out.println("�� , �� , �� �T��/�U�ݭn�X��");
		foodmenu.setName(food);
		foodmenu.setName(food2);
		foodmenu.setName(food3);
		foodmenu.setPrice((a * 100) + (b * 90) + (c * 80));
		if (foodmenu.getPrice() >= 500) {
			System.out.println(food + a + "��" + "�`�@" + (a * 100) + "��");
			System.out.println(food2 + b + "��" + "�`�@" + (b * 90) + "��");
			System.out.println(food3 + c + "��" + "�`�@" + (c * 80) + "��");
			System.out.println("���" + foodmenu.getPrice() + " ������ ���E�� = " + foodmenu.getPrice() * 0.9);
		} else {
			System.out.println(food + a + "��" + "�`�@" + (a * 100) + "��");
			System.out.println(food2 + b + "��" + "�`�@" + (b * 90) + "��");
			System.out.println(food3 + c + "��" + "�`�@" + (c * 80) + "��");
			System.out.println(foodmenu.getPrice());
		}
		return foodmenu;

	}

	@Override
	public Home_2_Menu_1 toto2(String food, String food2, String food3, int a, int b, int c) {
		// TODO Auto-generated method stub
		Home_2_Menu_1 foodmenu = new Home_2_Menu_1();
		System.out.println("�� , �� , �� �T�ؿﶵ/�U�ݭn�X��");
		foodmenu.setName(food);
		foodmenu.setName(food2);
		foodmenu.setName(food3);
		Scanner foodTotal = new Scanner(System.in);
		System.out.println("���n�X�� : ");
		int cow = foodTotal.nextInt();
		System.out.println("���n�X�� : ");
		int gg = foodTotal.nextInt();
		System.out.println("�ޭn�X�� : ");
		int dd = foodTotal.nextInt();
		foodmenu.setPrice((a * cow) + (b * gg) + (c * dd));
		if (foodmenu.getPrice() >= 500) {
			System.out.println(food + cow + "��" + "�`�@" + (a * cow) + "��");
			System.out.println(food2 + gg + "��" + "�`�@" + (b * gg) + "��");
			System.out.println(food3 + dd + "��" + "�`�@" + (c * dd) + "��");
			System.out.println("���" + foodmenu.getPrice() + " ������ ���E�� = " + foodmenu.getPrice() * 0.9);
		} else {
			System.out.println(food + cow + "��" + "�`�@" + (a * cow) + "��");
			System.out.println(food2 + gg + "��" + "�`�@" + (b * gg) + "��");
			System.out.println(food3 + dd + "��" + "�`�@" + (c * dd) + "��");
			System.out.println("�@�@ "+foodmenu.getPrice()+"��");
		}
		
		return foodmenu;

	}

	@Override
	public Home_2_Menu_1 toto3() {
		Home_2_Menu_OrderService_impl_2 xx=new Home_2_Menu_OrderService_impl_2();
		Home_2_Menu_1 foodmenu2 = new Home_2_Menu_1();
		xx.toto2("��", "��", "��", 100, 90, 80);
		

		
		return foodmenu2;
	}
}
