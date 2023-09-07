package com.example.demo_project.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.entity.Home_3_Bank_2;
import com.example.demo_project.service.ifs.Home_3_BankService_face_2;

@Service
public class Home_3_BankService_impl_2 implements Home_3_BankService_face_2 {

	@Override
	public void getpeople(Map<Home_3_Bank_2, Integer> item) {
		// TODO Auto-generated method stub
		int money1 = 0;

		String name = "";
		for (var people : item.entrySet()) {
			Home_3_Bank_2 id = people.getKey();

			if (people.getValue() > 0) {

				money1 = people.getValue() + id.getmoney();
				System.out.println(
						id.getid() + " 存款原本為 : " + id.getmoney() + " 存入 : " + people.getValue() + "目前餘額 : " + money1);
			} else if (people.getValue() < 0) {

				money1 = id.getmoney() + people.getValue();
				if (money1 < 0) {
					System.out.println(id.getid() + "領錢失敗");
					continue;
				}
				System.out.println(id.getid()  + " 存款原本為 : " + id.getmoney() + " 領出 : " + people.getValue()
						+ "現在存款為 : " + money1); 
			} else {
				money1 = id.getmoney();
				System.out.println(id.getid() + " 存款原本為 : " + " 存款只有 : " + money1 + " 領不出 : " + people.getValue());
			}
		}

//		return 0;

	}

	@Override
	public Home_3_Bank_2 getAmount(Home_3_Bank_1 bank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Home_3_Bank_2 deposit(Home_3_Bank_1 bank, int deposit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Home_3_Bank_2 withdraw(Home_3_Bank_1 bank, int withdraw) {
		// TODO Auto-generated method stub
		return null;
	}

}
