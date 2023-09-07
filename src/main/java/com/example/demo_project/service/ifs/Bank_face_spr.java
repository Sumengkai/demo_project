package com.example.demo_project.service.ifs;

import com.example.demo_project.controller.BankController;
import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.vo.BankRes;

public interface Bank_face_spr {
	public  Home_3_Bank_1 getamount(String bank); //ªì©l
	public Home_3_Bank_1 getAmount(Home_3_Bank_1 bank); 

	public Home_3_Bank_1 deposit(String bank, int deposit); //¦s

	public BankRes withdraw(String bank, int withdraw); //»â
}
