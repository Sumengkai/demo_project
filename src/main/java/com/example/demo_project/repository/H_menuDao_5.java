package com.example.demo_project.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.H_menu_5;

@Repository
public interface H_menuDao_5 extends JpaRepository<H_menu_5, String> {
//	@Transactional
//	@Modifying
//	@Query(value = "INSERT INTO menu2 (food, price) VALUES (:food, :price);", nativeQuery = true)
//	public int addMenuBySql(@Param("food") String food, @Param("price") int price);
//	@Query(value = "INSERT INTO menu2 (food, price) VALUES (:food, :price);", nativeQuery = true)
//	public int addMenuBySql(@Param("food") List<String> foods, @Param("price") List<Integer> prices);
	@Modifying
	@Query(value = "INSERT INTO menu2 (food, price) VALUES (:food, :price);", nativeQuery = true)
	public void addMenuBySql(@Param("food") List<String> foods, @Param("price") List<Integer> prices);

}
