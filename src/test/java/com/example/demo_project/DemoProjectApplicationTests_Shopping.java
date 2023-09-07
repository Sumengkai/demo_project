package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Home_4_Shoping_1;
import com.example.demo_project.service.ifs.Company_ifs;
import com.example.demo_project.service.ifs.Home_4_ShopingService_face_1;

@SpringBootTest
public class DemoProjectApplicationTests_Shopping {
	@Autowired
	private Home_4_ShopingService_face_1 home_4_ShopingService_face_1;
	@Autowired
	private Company_ifs company_ifs;
	@Test
	public void shoptext() {
		Home_4_Shoping_1 a = new Home_4_Shoping_1("¦B½c", 100, 3);
		Home_4_Shoping_1 b = new Home_4_Shoping_1("¯N½c", 90, 8);
		List<Home_4_Shoping_1> productList = new ArrayList<>();
		List<String> nameList = new ArrayList<>();
		productList.add(a);
		productList.add(b);
		nameList.add("£}");
		nameList.add("¦B½c");
		nameList.add("¯N½c");
		nameList.add("");
		nameList.add("");
		home_4_ShopingService_face_1.queryProducts(nameList, productList);

	}

	@Test
	public void shoptext2() {
		List<Home_4_Shoping_1> productList1 = new ArrayList<>();
		Home_4_Shoping_1 shopping = new Home_4_Shoping_1("±½§â", 100, 10);
		Home_4_Shoping_1 shopping1 = new Home_4_Shoping_1("©ì§â", 90, 9);
		Home_4_Shoping_1 shopping2 = new Home_4_Shoping_1("¦B½c", 80, 8);
		productList1.add(shopping);
		productList1.add(shopping1);
		productList1.add(shopping2);
		shopping.setQuantity(1);
		shopping1.setQuantity(9);
		shopping2.setQuantity(7);
		home_4_ShopingService_face_1.checkout(productList1);
		home_4_ShopingService_face_1.check(shopping1);

	}
	@Test
	public void ss() {
		company_ifs.saveCompany();
	}
	
}
