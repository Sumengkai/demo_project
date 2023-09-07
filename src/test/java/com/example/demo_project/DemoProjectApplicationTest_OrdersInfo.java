package com.example.demo_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Customers;
import com.example.demo_project.entity.Orders;
import com.example.demo_project.repository.OrdersDao;
import com.example.demo_project.vo.OrdersInfo;

@SpringBootTest(classes = DemoProjectApplication.class)
public class DemoProjectApplicationTest_OrdersInfo {
	@Autowired
	private OrdersDao ordersDao;
	private EntityManager entityManger;

	@Test
	// OrdersInfo�n�g���Ѫ��غc��k,�åB�n�`�N �غc��k ����"����"
	public void Oeders() {
		List<OrdersInfo> list = ordersDao.findAllOrdersInfo();
		for (OrdersInfo item : list) {
			System.out.print(item.getCustomerId() + " . ");
			System.out.print("���� : " + item.getProductName());
			System.out.print(" �W�l : " + item.getName());
			System.out.print(" �ƶq : " + item.getQuantity());
			System.out.println("");
		}
	}

// -----------------------------------------------------------------
//		@Test
	// OrdersInfo�n�g���Ѫ��غc��k,�åB�n�`�N �غc��k ����"����"
//		public void Oeders2() {
//			List<Object> list = (List<OrdersInfo>) ordersDao.findAllOrdersInfo();
//			for (OrdersInfo item : list) {
//				System.out.print(item.getCustomerId()+" . ");
//				System.out.print("���� : "+item.getProductName());
//				System.out.print(" �W�l : "+item.getName());
//				System.out.print(" �ƶq : "+item.getQuantity());
//				System.out.println("");
//			}
//	}
// -----------------------------------------------------------------
	@Test
	// OrdersInfo�n�g���Ѫ��غc��k,�åB�n�`�N �غc��k ����"����"
	public void Oeders2() {
		List<Integer> listint = new ArrayList<>();
		listint.add(1);
		listint.add(2);
		List<OrdersInfo> list = ordersDao.findOrdersInfoByCustomerIdIn(listint);
		for (OrdersInfo item : list) {
			System.out.print(item.getCustomerId() + " . ");
			System.out.print("���� : " + item.getProductName());
			System.out.print(" �W�l : " + item.getName());
			System.out.print(" �ƶq : " + item.getQuantity());
			System.out.println("");
		}
	}
// -----------------------------------------------------------------
	@Test
	public void mapTestOrders3() {
		Map<String,Object> map = new HashMap<>();
		map.put("inputId", "A01");
		map.put("inputAge", 20);
		String sql ="SELECT c.name , c.phone FROM Customers c WHERE ID = :inputId and age > :inputAge";
		Query query = entityManger.createQuery(sql,Customers.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
