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
		System.out.println("��榳 1.���� 2.���T 3.�ޱ� �п�J�A�Q�Y�� : ");
		Scanner scan = new Scanner(System.in);
		String food = scan.nextLine();
		if (food.equals("����")) {
			System.out.println("���� �����欰 :" + 100);
		} else if (food.equals("���T")) {
			System.out.println("���T �����欰 :" + 80);
		} else if (food.equals("�ޱ�")) {
			System.out.println("�ޱ� �����欰 :" + 90);
		} else {
			System.out.println("�u�^�h�Y��");
		}
		return foodMenu;
	}

//==================================================
	@Override
	public Home_2_Menu_1 Menu3(String fooda, String foodb, String foodc, int a, int b, int c) {
		Home_2_Menu_1 foodMenu3 = new Home_2_Menu_1();
		System.out.println("���W�� : " + fooda + foodb + foodc + "�T�ؿﶵ");
		Scanner scan3 = new Scanner(System.in);
		System.out.println("�а�" + fooda + "�ݭn�X�� : ");
		int aa = scan3.nextInt();
		System.out.println("�а�" + foodb + "�ݭn�X�� : ");
		int bb = scan3.nextInt();
		System.out.println("�а�" + foodc + "�ݭn�X�� : ");
		int cc = scan3.nextInt();
		int beefmoney = a * aa;
		int ggmoney = b * bb;
		int pigmoney = c * cc;
		int total = beefmoney + ggmoney + pigmoney;
		if (total >= 500) {
			System.out.println(
					"�]����500���E�� �ҥH�\�I���� �`�@�� " + (total * 0.9) + " �� " + " ,���A�٤U�F" + (total - (total * 0.9)) + " ��");
		} else {
			System.out.println(fooda + "�`�@" + aa + " ��" + fooda + "�o�ˬO" + beefmoney + "��");
			System.out.println(foodb + "�`�@" + bb + " ��" + foodb + "�o�ˬO" + ggmoney + "��");
			System.out.println(foodc + "�`�@" + cc + " ��" + foodc + "�o�ˬO" + pigmoney + "��");
			System.out.println("�����O" + total + "��");
		}
		return foodMenu3;

	}

	@Override
	public Home_2_Menu_1 Menu2() {
		// TODO Auto-generated method stub
		
		food.add("��");
		food.add("��");
		food.add("��");
		total.add(100);
		total.add(90);
		total.add(80);
		return null;
	}

}
