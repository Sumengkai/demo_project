package com.example.demo_project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Orders;
import com.example.demo_project.vo.OrdersInfo;

@Repository
@Transactional
public interface OrdersDao extends JpaRepository<Orders, Integer> {
	@Modifying
	@Query(" SELECT NEW com.example.demo_project.vo.OrdersInfo(o.customerId, o.productName, c.name, o.quantity) FROM Customers c JOIN Orders o ON c.id = o.customerId ")
	public List<OrdersInfo> findAllOrdersInfo();

//-----
//	@Modifying
//	@Query(" SELECT o.customerId, o.productName, c.name, o.quantity FROM Customers c JOIN Orders o ON c.id = o.customerId ")
//	public List<Object> findAllOrdersInfo();
//-----
	@Modifying
	@Query(" SELECT NEW com.example.demo_project.vo.OrdersInfo(o.customerId, o.productName, c.name, o.quantity) FROM Customers c JOIN Orders o ON c.id = o.customerId "
			+ "where o.customerId = :CustomerId")
	public List<OrdersInfo> findOrdersInfoByCustomerIdIn(@Param("CustomerId") List<Integer> CustomerId);
}
