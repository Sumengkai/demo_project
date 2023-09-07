package com.example.demo_project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Home_bank_1;
@Transactional
@Repository											
public interface BankDao_1 extends JpaRepository<Home_bank_1,String>{
//	@Transactional
	public void deleteByName(String name);
}
