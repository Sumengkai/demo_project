package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Home_bank_1;

public interface H_bank_ifs_1 {

	public Home_bank_1 bank1(String id); // 1---

	public Home_bank_1 bank2(String id); // 2---

	public Home_bank_1 deposit(String id, int deposit); // 3---

	public Home_bank_1 withdeaw(String id, int withdeaw); // 4---

	public void delete(String id); // 5--
	
	public void deleteByName(String name); //6
}
