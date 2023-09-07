package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.controller.BankController;
import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.service.ifs.Bank_face_spr;
import com.example.demo_project.vo.BankRes;

@Service
public class Bank_impl_spr implements Bank_face_spr {

	@Override
	public Home_3_Bank_1 getamount(String account) {
		Home_3_Bank_1 bank = new Home_3_Bank_1();
		bank.setAccount(account);// 初始值
		bank.setAmount(1000);// 初始值

		return bank;

	}

//=============================
	@Override
	public Home_3_Bank_1 deposit(String bank, int deposit) {
		Home_3_Bank_1 bank1 = new Home_3_Bank_1();
		bank1.setAccount(bank);
		bank1.setAmount(1000);
		int amount = deposit + bank1.getAmount();
		bank1.setAmount(amount);
		return bank1;
	}

//=============================
	@Override
	public BankRes withdraw(String bank, int withdraw) {
//		Home_3_Bank_1 bank1 = new Home_3_Bank_1();
		int x = 500;// 初始值$$
		BankRes res = new BankRes();
//		res.setAccount(bank);
		if(withdraw<0) {
			res.setMessage("不得小於零");
			return res;
		}
		if (withdraw > x) {
			res.setMessage("存款不足");
			return res;
		}
//		int amount = res.getAmount() - withdraw;
//		bank1.setAmount(amount);
		res.setAmount(x - withdraw);
		res.setAccount(bank);
		res.setMessage("成功");
		return res;
	}

	@Override
	public Home_3_Bank_1 getAmount(Home_3_Bank_1 bank) {
		// TODO Auto-generated method stub
		return null;
	}

}
