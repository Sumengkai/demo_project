package com.example.demo_project.service.impl;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Count_3;
import com.example.demo_project.entity.Count_5;

@Service
public class Count_5_impl_5 {
	public void getTo3() {
		Count_5 count_5 = new Count_5();
		int max = 5;// 計數器
		String chick = "";
		while (max != 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println("請輸入算式種類+ ,- ,* , /");
			String getsign = scan.next();
			String sign = count_5.setSign(getsign);
			if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {
				System.out.println("輸入第一個數字,限制2-20");
				int getnum1 = scan.nextInt();
				System.out.println("輸入第二個數字,限制2-20");
				int getnum2 = scan.nextInt();
				int num1 =  count_5.setNumber1(getnum1);
				int num2 =  count_5.setNumber2(getnum2);
				if ((num1 < 2 || num1 > 20) || (num2 < 2 || num2 > 20)) {
					max--;
					System.out.println("數字被限制在2-20,你剩 " + max + "次 機會");
					continue;
				}
				System.out.println(num1 + count_5.getSign() + num2 + "這是你輸入的嗎?,正確請輸入y,錯誤請輸入n,終止程式請輸入任意字");
				chick = scan.next();
				if (chick.equalsIgnoreCase("y")) {
					switch (sign) {
					case "+":
//						try {
//							double add = Double.valueOf(count_5.Add());
//							System.out.println(add);
//						} catch (Exception e) {
//							System.out.println("失敗"+e);
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
