package com.example.demo_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Home_1_Bird;
import com.example.demo_project.entity.Home_2_Menu_1;
import com.example.demo_project.entity.Home_2_Menu_3;
import com.example.demo_project.entity.Home_2_Menu_4;
import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.entity.Home_3_Bank_2;
import com.example.demo_project.entity.Home_4_Shoping_1;
import com.example.demo_project.entity.Person;
import com.example.demo_project.repository.OrdersDao;
import com.example.demo_project.service.ifs.Home_1_Bird_face;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_1;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_2;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_3;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_4;
import com.example.demo_project.service.ifs.Home_3_BankService_face_1;
import com.example.demo_project.service.ifs.Home_4_ShopingService_face_1;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.service.impl.Home_1_Bird_Impl;
import com.example.demo_project.service.impl.Home_3_BankService_impl_2;
import com.example.demo_project.service.impl.PersonServiceImpl;
import com.example.demo_project.vo.OrdersInfo;

@SpringBootTest
class DemoProjectApplicationTests {
	@Autowired
	private PersonService personService;
	@Autowired
	private Home_1_Bird_face home_1_Bird_face; // ¤¶­±
	@Autowired
	private Home_1_Bird_Impl home_1_Bird_Impl; // ¹ê°µ
	


	@Test
	public void context() {
		Person p1 = personService.getPersonInfo1("12345678");
		System.out.println(p1.getId());
	}

	@Test
	public void cotext2() {
		home_1_Bird_face.Fly4("kai", 23);
	}

	@Test
	public void cotext3() {
		home_1_Bird_Impl.Fly4("Sukai", 23);
	}
	
	//==
	
}
