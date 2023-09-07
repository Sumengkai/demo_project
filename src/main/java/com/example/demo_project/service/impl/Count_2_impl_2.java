package com.example.demo_project.service.impl;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Count_1;

@Service
public class Count_2_impl_2 {

	public void getCount() {
		int max = 0;/// 用於偵錯時 跳迴圈的記次器
		String a = "";// 將印出結果接串起來
		float to;
		String chick = "";// 用於確認用戶輸入正確與否
		Count_1 count = new Count_1();// 叫方法用
		while (max < 3) {// 第一層迴圈
			Scanner scan = new Scanner(System.in);// 這裡要注意沒new在迴圈理,會沒有新的記憶體空間
			System.out.println("輸入你想算的方式 + , - , * , / (除法) , % (取餘數)");
			String getsign = scan.nextLine();// 先讓用戶決定算式種類
			count.setSign(getsign);
			if (count.getSign().equals("*") || count.getSign().equals("+") || count.getSign().equals("-")
					|| count.getSign().equals("/") || count.getSign().equals("%")) { // 只要正確會掉進來這層判斷
				System.out.println("輸入第一個數字,限制2-20");
				double number1 = scan.nextDouble();
				count.setNumber1(number1);
				System.out.println("輸入第二個數字,限制2-20");
				double number2 = scan.nextDouble();
				count.setNumber2(number2);
				if (count.getNumber1() < 2 || count.getNumber1() > 20 || count.getNumber2() < 2
						|| count.getNumber2() > 20) {// 輸入完兩個數字後,判斷是否被限制
					System.out.println("數字被限制在2-20");
					max++;// 計次器+1
					System.out.println("這樣輸入不對 有三次機會 這是第" + max + "次");
					continue;// 回到第一層
				}

			} else {// 這層判斷是當用戶輸入不正確的運算符號時會掉進來
				max++;
				System.out.println("這樣輸入不正確 有三次機會 這是第" + max + "次");
				continue;// 回到第一層
			}
			while ((count.getNumber1() >= 2 && count.getNumber1() <= 20)
					&& (count.getNumber2() >= 2 && count.getNumber2() <= 20)) {// while中第二個回圈,當用戶輸入正確,會掉進來
				if (count.getSign().equals("*")) {// 取得原先的運算符號,看是哪一種便會掉進來
					to = (float) (count.getNumber1() * count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);
					System.out.println(a + " 請問這是你輸入的算式嗎? 正確輸入y, 不正確輸入n");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {// 讓用戶確認
						System.out.println("計算結果為 :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("重頭來過");
						break;// 跳出"當前"迴圈,可使用戶無限使用此計算機

					}

				} else if (count.getSign().equals("+")) {
					to = (float) (count.getNumber1() + count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);
					System.out.println(a + " 請問這是你輸入的算式嗎? 正確輸入y, 不正確輸入n");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("計算結果為 :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("重頭來過");
						break;

					} 

				} else if (count.getSign().equals("-")) {
					to = (float) (count.getNumber1() - count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);
					System.out.println(a + " 請問這是你輸入的算式嗎? 正確輸入y, 不正確輸入n");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("計算結果為 :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("重頭來過");
						break;

					}

				} else if (count.getSign().equals("/")) {
					to = (float) (count.getNumber1() / count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);

					System.out.println(a + " 請問這是你輸入的算式嗎? 正確輸入y, 不正確輸入n");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("計算結果為 :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("重頭來過");
						break;

					}

				} else if (count.getSign().equals("%")) {
					to = (int) (count.getNumber1() % count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);

					System.out.println(a + " 請問這是你輸入的算式嗎? 正確輸入y, 不正確輸入n");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("計算結果為 :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("重頭來過");
						break;

					}
									}
			}
		}
	}
}
