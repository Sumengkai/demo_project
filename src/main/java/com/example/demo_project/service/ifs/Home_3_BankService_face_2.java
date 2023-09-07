package com.example.demo_project.service.ifs;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_2_Menu_4;
import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.entity.Home_3_Bank_2;
@Service
public interface Home_3_BankService_face_2 {
	public  void getpeople(Map<Home_3_Bank_2, Integer> item);
	public Home_3_Bank_2 getAmount(Home_3_Bank_1 bank);

	public Home_3_Bank_2 deposit(Home_3_Bank_1 bank, int deposit);

	public Home_3_Bank_2 withdraw(Home_3_Bank_1 bank, int withdraw);
}
