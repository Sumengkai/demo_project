package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Person_2;

@Repository
public interface PersonDao extends JpaRepository<Person_2,String>{
						//繼承> JpaRepository // Entity . 主鍵的型態
//=====                     自訂義方法有規定
	public List<Person_2> findByAgeGreaterThan(int age);
	public List<Person_2> findByAgeGreaterThanAndName(int age , String name);
}
