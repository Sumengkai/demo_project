package com.example.demo_project.service.impl;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Count_3;
import com.example.demo_project.entity.Count_5;

@Service
public class Count_5_impl_5 {
	public void getTo3() {
		Count_5 count_5 = new Count_5();
		int max = 5;// �p�ƾ�
		String chick = "";
		while (max != 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println("�п�J�⦡����+ ,- ,* , /");
			String getsign = scan.next();
			String sign = count_5.setSign(getsign);
			if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {
				System.out.println("��J�Ĥ@�ӼƦr,����2-20");
				int getnum1 = scan.nextInt();
				System.out.println("��J�ĤG�ӼƦr,����2-20");
				int getnum2 = scan.nextInt();
				int num1 =  count_5.setNumber1(getnum1);
				int num2 =  count_5.setNumber2(getnum2);
				if ((num1 < 2 || num1 > 20) || (num2 < 2 || num2 > 20)) {
					max--;
					System.out.println("�Ʀr�Q����b2-20,�A�� " + max + "�� ���|");
					continue;
				}
				System.out.println(num1 + count_5.getSign() + num2 + "�o�O�A��J����?,���T�п�Jy,���~�п�Jn,�פ�{���п�J���N�r");
				chick = scan.next();
				if (chick.equalsIgnoreCase("y")) {
					switch (sign) {
					case "+":
//						try {
//							double add = Double.valueOf(count_5.Add());
//							System.out.println(add);
//						} catch (Exception e) {
//							System.out.println("����"+e);
//						}finally {
//							double add = Double.valueOf(count_5.Add());
//							System.out.println(add);
//							
//						}
//						continue;
					case "-":
						String minus = count_5.Minus();
						System.out.println(minus);
						continue;
					case "*":
						String multi = count_5.Multi();
						System.out.println(multi);
						continue;
					case "/":
						String division = count_5.Division();
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
