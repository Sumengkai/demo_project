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
		System.out.println("�b�� : " + bank.getAccount() + " �ӱb����l�l�B : " + bank.getAmount());
		return null;
	}

	@Override
	public Home_3_Bank_1 deposit(Home_3_Bank_1 bank, int deposit) {
		int x = bank.getAmount() + deposit;
		bank.setAmount(x);
		System.out.println("�b�� : " + bank.getAccount() + " �ӱb���s�ګ�l�B : " + bank.getAmount());
		return null;
	}

	@Override
	public Home_3_Bank_1 withdraw(Home_3_Bank_1 bank, int withdraw) {
		if (withdraw > 0 && bank.getAmount() >= withdraw) {
			int y = bank.getAmount() - withdraw;
			bank.setAmount(y);
			System.out.println("�b�� : " + bank.getAccount() + " �ӱb����X��l�B : " + bank.getAmount());

		} else {
			System.out.println("�ӱb���l�B�u�� : " + bank.getAmount() + " �⤣�X " + withdraw);
		}

		return null;
	}

}
