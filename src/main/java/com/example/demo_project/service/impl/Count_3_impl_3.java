package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Count_3;
import com.example.demo_project.entity.Home_4_Shoping_1;

@Service
public class Count_3_impl_3 {
	public void getTo() {
		Count_3 count_3 = new Count_3();
		int max = 5;// 計數器
		String chick = "";
		while (max != 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println("請輸入算式種類+ ,- ,* , /");
			String getsign = scan.next();
			String sign = count_3.setSign(getsign);
			if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {
				System.out.println("輸入第一個數字,限制2-20");
				double getnum1 = (float) scan.nextFloat();
				System.out.println("輸入第二個數字,限制2-20");
				double getnum2 = (float) scan.nextFloat();
				float num1 = count_3.setNumber1(getnum1);
				float num2 = count_3.setNumber2(getnum2);
				if ((num1 < 2 || num1 > 20) || (num2 < 2 || num2 > 20)) {
					max--;
					System.out.println("數字被限制在2-20,你剩 " + max + "次 機會");
					continue;
				}
				System.out.println(num1 + count_3.getSign() + num2 + "這是你輸入的嗎?,正確請輸入y,錯誤請輸入n,終止程式請輸入任意字");
				chick = scan.next();
				if (chick.equalsIgnoreCase("y")) {
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
					// 從頭
					System.out.println("重新開始");
					continue;
				} else {
					System.out.println("終止程式");
					break;
				}

			} else {
				max--;
				System.out.println("符號不可以亂輸入 ,你剩" + max + " 機會");
				continue;
			}
		}
	}
}
