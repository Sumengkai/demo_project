package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.Home_bank_1;
import com.example.demo_project.entity.Person_2;
import com.example.demo_project.repository.BankDao_1;
import com.example.demo_project.service.ifs.H_bank_ifs_1;

@Service
public class H_bank_impl_1 implements H_bank_ifs_1 {
	@Autowired
	private BankDao_1 bankDao_1;

//=========1
	@Override
	public Home_bank_1 bank1(String id) {
		// TODO Auto-generated method stub
		Home_bank_1 a = new Home_bank_1();
		Optional<Home_bank_1> b = bankDao_1.findById(id);
		
		if (b.isPresent()) {
			return null;
		} 

		
		bankDao_1.save(a);
		
		return a;
	}

//=========2
	@Override
	public Home_bank_1 bank2(String id) {
		// TODO Auto-generated method stub
		Optional<Home_bank_1> aa = bankDao_1.findById(id);
		Home_bank_1 xx = aa.orElse(null);
		return xx;
	}

//=========3
	@Override
	public Home_bank_1 deposit(String id, int deposit) {
		// TODO Auto-generated method stub
		Optional<Home_bank_1> aa = bankDao_1.findById(id);
		if (aa.isPresent() && deposit > 0) {
			Home_bank_1 name = aa.get();
			int deposit2 = deposit + name.getAmount();
			name.setAmount(deposit2);
			bankDao_1.save(name);
			return name;
		} else {
			return null;
		}

	}

//=========4
	@Override
	public Home_bank_1 withdeaw(String id, int withdeaw) {
		// TODO Auto-generated method stub
		Optional<Home_bank_1> aa = bankDao_1.findById(id);
		Home_bank_1 name = aa.get();
		if (aa.isPresent() && withdeaw <= name.getAmount() && withdeaw > 0) {
			int withdeaw2 = name.getAmount() - withdeaw;
			name.setAmount(withdeaw2);
			bankDao_1.save(name);
			return name;
		} else {
			return null;
		}
	}

	@Transactional
	@Override
	public void delete(String id) throws RuntimeException {
		// TODO Auto-generated method stub
		bankDao_1.deleteById(id);
		System.out.println("sss");
		throw new RuntimeException("ddd");

	}

//	@Transactional
	@Override
	public void deleteByName(String name) throws RuntimeException {
		// TODO Auto-generated method stub
		bankDao_1.deleteByName(name);
		System.out.println("aaaaaa");
//		throw new RuntimeException("bbbbbb");

	}

}
