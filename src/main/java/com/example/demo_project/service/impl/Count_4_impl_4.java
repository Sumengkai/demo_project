package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Count_3;
import com.example.demo_project.entity.Home_4_Shoping_1;

@Service
public class Count_4_impl_4 {
	private static List list;
	static {
		list = new ArrayList<>();
	}
	
	public void getTo2() {
		int max = 5;// �p�ƾ�
		String chick = "";
		Scanner scan = new Scanner(System.in);
		while (max != 0) {
//			Scanner scan = new Scanner(System.in);
			System.out.println("�п�J�⦡����+ ,- ,* , /");
			Count_3 count_3 = new Count_3();
			String getsign = scan.next();
			count_3.setSign(getsign);
			String sign = count_3.getSign();
			if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {
				System.out.println("��J�Ĥ@�ӼƦr,����2-20");
				double getnum1 = (float) scan.nextFloat();
				System.out.println("��J�ĤG�ӼƦr,����2-20");
				double getnum2 = (float) scan.nextFloat();
				count_3.setNumber1(getnum1);
				float num1 = count_3.getNumber1();
				count_3.setNumber2(getnum2);
				float num2 = count_3.getNumber2();
				if ((num1 < 2 || num1 > 20) || (num2 < 2 || num2 > 20)) {
					max--;
					System.out.println("�Ʀr�Q����b2-20,�A�� " + max + "�� ���|");
					continue;
				}
				list.add(count_3);
				System.out.println(num1 + count_3.getSign() + num2 + "�o�O�A��J����?,���T�п�Jy,���~�п�Jn,�פ�{���п�J���N�r");
				chick = scan.next();
				if (chick.equalsIgnoreCase("y")) {
					for (var numto : list) {
						System.out.println(count_3.getNumber1()+count_3.getSign()+count_3.getNumber2());
					}
					switch (sign) {
					case "+":
						String add = count_3.Add();
						System.out.println(add);
						continue;
					case "-":
						String minus = count_3.Minus();
						System.out.println(minus);
						continue;
					case "*":
						String multi = count_3.Multi();
						System.out.println(multi);
						continue;
					case "/":
						String division = count_3.Division();
						System.out.println(division);
						continue;
					}

				} else if (chick.equalsIgnoreCase("n")) {
					// �q�Y
					System.out.println("���s�}�l");
					continue;
				} else {
					System.out.println("�פ�{��");
					break;
				}

			} else {
				max--;
				System.out.println("�Ÿ����i�H�ÿ�J ,�A��" + max + " ���|");
				continue;
			}
		}
	}
}
