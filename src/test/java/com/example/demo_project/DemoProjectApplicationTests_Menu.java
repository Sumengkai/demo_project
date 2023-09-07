package com.example.demo_project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.H_menu_5;
import com.example.demo_project.entity.Home_2_Menu_3;
import com.example.demo_project.entity.Home_2_Menu_4;
import com.example.demo_project.repository.H_menuDao_5;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_1;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_2;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_3;
import com.example.demo_project.service.ifs.Home_2_Menu_OrderService_face_4;

@SpringBootTest
public class DemoProjectApplicationTests_Menu {
	@Autowired
	private H_menuDao_5 h_menuDao_5;
	@Autowired
	private Home_2_Menu_OrderService_face_4 home_2_Menu_OrderService_face_4;
	@Autowired
	private Home_2_Menu_OrderService_face_3 home_2_Menu_OrderService_face_3;
	@Autowired
	private Home_2_Menu_OrderService_face_1 home_2_Menu_OrderService_face; // 原板
	@Autowired
	private Home_2_Menu_OrderService_face_2 home_2_Menu_OrderService_face_2; // 作業第二改版

	@Test
	public void foodtext() {
		home_2_Menu_OrderService_face.Menu1();
	}// 取得餐點價格

	@Test
	public void foodtext2() {
		home_2_Menu_OrderService_face.Menu3(" 牛排 ", " 雞排 ", " 豬排 ", 100, 90, 80);
	}// 總價

	@Test
	public void foodtext3() {
		// 牛 雞 豬
		home_2_Menu_OrderService_face_2.someprice("");
	}// 取得餐點價格

	@Test
	public void foodtext4() {
		// 餐點/牛雞豬 份數
		home_2_Menu_OrderService_face_2.toto("牛", "雞", "豬", 5, 3, 6);
	}// 總價

	@Test
	public void foodtext5() {
		// 餐點/牛雞豬/價錢/都沒寫死
		home_2_Menu_OrderService_face_2.toto2("牛", "雞", "豬", 100, 90, 80);
	}// 總價

	@Test
	public void foodtext6() {
		// 餐點/牛雞豬/價錢/都沒寫死/但是藏起來了
		home_2_Menu_OrderService_face_2.toto3();
	}// 總價

	@Test
	public void foodtext7() {
		Home_2_Menu_3 food1 = new Home_2_Menu_3();
		Home_2_Menu_3 food2 = new Home_2_Menu_3();
		food1.setName("牛");
		food1.setPrice(100);
		food2.setName("gg");
		food2.setPrice(90);
		Map<Home_2_Menu_3, Integer> menumap = new HashMap();
		menumap.put(food1, 5);
		menumap.put(food2, 0);
		home_2_Menu_OrderService_face_3.getTo1(menumap);

	}// 總價

	@Test
	public void foodtext8() {
		Home_2_Menu_3 food1 = new Home_2_Menu_3();
		food1.setName("雞");
		food1.setPrice(90);
		home_2_Menu_OrderService_face_3.addmenu(food1);

	}// 總價

	@Test
	public void foodtext9() {
		Home_2_Menu_3 food1 = new Home_2_Menu_3();
		Home_2_Menu_3 food2 = new Home_2_Menu_3();
		Home_2_Menu_3 food3 = new Home_2_Menu_3();
		food1.setName("牛");
		food1.setPrice(100);
		food2.setName("gg");
		food2.setPrice(90);
		food3.setName("DD");
		food3.setPrice(80);
		Map<Home_2_Menu_3, Integer> menumap = new HashMap();
		menumap.put(food1, 1);// 餐點+份數
		menumap.put(food2, 2);
		menumap.put(food3, 3);
//		home_2_Menu_OrderService_face_3.getTo3(menumap, food3);
	}

	@Test
	public void foodtext10() {
		Map<Home_2_Menu_4, Integer> menumap = new HashMap<>();
		menumap.put(new Home_2_Menu_4("b", 100), 2);
		menumap.put(new Home_2_Menu_4("a", 90), 1);
		menumap.put(new Home_2_Menu_4("c", 80), 1);
		menumap.put(new Home_2_Menu_4("d", 80), 1);
		home_2_Menu_OrderService_face_4.getTotal2(menumap);
	}

	@Test
	public void foodtext11() {
		Map<Home_2_Menu_3, Integer> menumap = new HashMap<>();
		menumap.put(new Home_2_Menu_3("beef", 100), 3);
		menumap.put(new Home_2_Menu_3("pork", 90), 2);
		menumap.put(new Home_2_Menu_3("chicken", 80), 1);
		home_2_Menu_OrderService_face_3.printMenuInfo(menumap);

	}// 總價

	@Test
	public void foodtext12() {
		Map<Home_2_Menu_4, Integer> menumap1 = new HashMap<>();
		menumap1.put(new Home_2_Menu_4("牛", 100), 3);
		menumap1.put(new Home_2_Menu_4("雞", 90), 2);
		menumap1.put(new Home_2_Menu_4("豬", 80), 1);
		menumap1.put(new Home_2_Menu_4("魚", 70), 4);
		menumap1.put(new Home_2_Menu_4("楊", 60), 4);
		home_2_Menu_OrderService_face_4.getTotal(menumap1);
	}

	@Test
	public void addSql() {
		List<String> foods = Arrays.asList("Food1", "Food2", "Food3");
		List<Integer> prices = Arrays.asList(10, 20, 30);
	h_menuDao_5.addMenuBySql(foods, prices);
//		System.out.println(i);
	}

}
