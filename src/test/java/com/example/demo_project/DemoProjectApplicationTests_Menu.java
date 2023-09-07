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
	private Home_2_Menu_OrderService_face_1 home_2_Menu_OrderService_face; // ��O
	@Autowired
	private Home_2_Menu_OrderService_face_2 home_2_Menu_OrderService_face_2; // �@�~�ĤG�睊

	@Test
	public void foodtext() {
		home_2_Menu_OrderService_face.Menu1();
	}// ���o�\�I����

	@Test
	public void foodtext2() {
		home_2_Menu_OrderService_face.Menu3(" ���� ", " ���� ", " �ޱ� ", 100, 90, 80);
	}// �`��

	@Test
	public void foodtext3() {
		// �� �� ��
		home_2_Menu_OrderService_face_2.someprice("");
	}// ���o�\�I����

	@Test
	public void foodtext4() {
		// �\�I/������ ����
		home_2_Menu_OrderService_face_2.toto("��", "��", "��", 5, 3, 6);
	}// �`��

	@Test
	public void foodtext5() {
		// �\�I/������/����/���S�g��
		home_2_Menu_OrderService_face_2.toto2("��", "��", "��", 100, 90, 80);
	}// �`��

	@Test
	public void foodtext6() {
		// �\�I/������/����/���S�g��/���O�ð_�ӤF
		home_2_Menu_OrderService_face_2.toto3();
	}// �`��

	@Test
	public void foodtext7() {
		Home_2_Menu_3 food1 = new Home_2_Menu_3();
		Home_2_Menu_3 food2 = new Home_2_Menu_3();
		food1.setName("��");
		food1.setPrice(100);
		food2.setName("gg");
		food2.setPrice(90);
		Map<Home_2_Menu_3, Integer> menumap = new HashMap();
		menumap.put(food1, 5);
		menumap.put(food2, 0);
		home_2_Menu_OrderService_face_3.getTo1(menumap);

	}// �`��

	@Test
	public void foodtext8() {
		Home_2_Menu_3 food1 = new Home_2_Menu_3();
		food1.setName("��");
		food1.setPrice(90);
		home_2_Menu_OrderService_face_3.addmenu(food1);

	}// �`��

	@Test
	public void foodtext9() {
		Home_2_Menu_3 food1 = new Home_2_Menu_3();
		Home_2_Menu_3 food2 = new Home_2_Menu_3();
		Home_2_Menu_3 food3 = new Home_2_Menu_3();
		food1.setName("��");
		food1.setPrice(100);
		food2.setName("gg");
		food2.setPrice(90);
		food3.setName("DD");
		food3.setPrice(80);
		Map<Home_2_Menu_3, Integer> menumap = new HashMap();
		menumap.put(food1, 1);// �\�I+����
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

	}// �`��

	@Test
	public void foodtext12() {
		Map<Home_2_Menu_4, Integer> menumap1 = new HashMap<>();
		menumap1.put(new Home_2_Menu_4("��", 100), 3);
		menumap1.put(new Home_2_Menu_4("��", 90), 2);
		menumap1.put(new Home_2_Menu_4("��", 80), 1);
		menumap1.put(new Home_2_Menu_4("��", 70), 4);
		menumap1.put(new Home_2_Menu_4("��", 60), 4);
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
