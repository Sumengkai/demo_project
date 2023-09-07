package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.service.ifs.Home_3_BankService_face_1;

@Service
public class Home_3_BankService_impl_1 implements Home_3_BankService_face_1 {

	@Override
	public Home_3_Bank_1 getAmount(Home_3_Bank_1 bank) {
		// TODO Auto-generated method stub
//		bank.getAccount();
//		bank.getAmount();
		System.out.println("帳號 : " + bank.getAccount() + " 該帳號原始餘額 : " + bank.getAmount());
		return null;
	}

	@Override
	public Home_3_Bank_1 deposit(Home_3_Bank_1 bank, int deposit) {
		int x = bank.getAmount() + deposit;
		bank.setAmount(x);
		System.out.println("帳號 : " + bank.getAccount() + " 該帳號存款後餘額 : " + bank.getAmount());
		return null;
	}

	@Override
	public Home_3_Bank_1 withdraw(Home_3_Bank_1 bank, int withdraw) {
		if (withdraw > 0 && bank.getAmount() >= withdraw) {
			int y = bank.getAmount() - withdraw;
			bank.setAmount(y);
			System.out.println("帳號 : " + bank.getAccount() + " 該帳號領出後餘額 : " + bank.getAmount());

		} else {
			System.out.println("該帳號餘額只有 : " + bank.getAmount() + " 領不出 " + withdraw);
		}

		return null;
	}

}
