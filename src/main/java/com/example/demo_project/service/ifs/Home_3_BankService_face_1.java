package com.example.demo_project.service.ifs;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_3_Bank_1;

@Service
public interface Home_3_BankService_face_1 {
	public Home_3_Bank_1 getAmount(Home_3_Bank_1 bank);

	public Home_3_Bank_1 deposit(Home_3_Bank_1 bank, int deposit);

	public Home_3_Bank_1 withdraw(Home_3_Bank_1 bank, int withdraw);
}
