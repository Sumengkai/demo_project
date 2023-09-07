package com.example.demo_project;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.controller.BankController;
import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.entity.Home_3_Bank_2;
import com.example.demo_project.service.ifs.Home_3_BankService_face_1;
import com.example.demo_project.service.impl.Home_3_BankService_impl_2;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;

@SpringBootTest
public class DemoProjectApplicationTests_Bank {
	@Autowired
	private Home_3_BankService_impl_2 home_3_BankService_impl_2;
	@Autowired
	private Home_3_BankService_face_1 home_3_BankService_face_1;
	@Autowired
	private BankController bankController; //1018

	@Test
	public void banktext1() {
		Home_3_Bank_1 money = new Home_3_Bank_1("kai", 1000);
		home_3_BankService_face_1.getAmount(money);
		home_3_BankService_face_1.deposit(money, 2000);
		home_3_BankService_face_1.withdraw(money, 3000);
	}

	@Test
	public void banktext2() {
		Map<Home_3_Bank_2, Integer> bigbank = new LinkedHashMap<>();
		bigbank.put(new Home_3_Bank_2("小A", 1000), 1000);
		bigbank.put(new Home_3_Bank_2("小B", 2000), -1000);
		bigbank.put(new Home_3_Bank_2("小C", 3000), -4000);
		bigbank.put(new Home_3_Bank_2("小D", 4000), -4000);
		home_3_BankService_impl_2.getpeople(bigbank);
	}
	@Test
	public void banktext3() {
		BankReq req = new BankReq();
		req.setAccount("a01");
		BankRes res = bankController.getAmount(req);
		System.out.println(res.getAccount());
		System.out.println(res.getAmount());
		System.out.println(res.getMessage());
	}
	
	
	
}
