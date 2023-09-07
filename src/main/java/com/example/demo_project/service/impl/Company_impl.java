package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.Org_Company_id;
import com.example.demo_project.repository.CompanyDao;
import com.example.demo_project.service.ifs.Company_ifs;

@Service
public class Company_impl implements Company_ifs {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyDao.findAll();

	}
	//=====

	@Override
	public Company findById(String orgid, String company_id) {
		// TODO Auto-generated method stub
		Org_Company_id x = new Org_Company_id(orgid, company_id);
		Optional<Company> companyOp = companyDao.findById(x);
		//=====
//		if(companyOp.isPresent()) {
//			Company com= companyOp.get();
//			return com;
//		}
		//=====
		return companyOp.orElse(new Company());
	}
	//=====
	@Override
	public Company updateByid(String orgid, String company_id) {
		// TODO Auto-generated method stub
//jpe������update�y�k,�N�u����hfind�� ,���ݭn��s�����,�N�����hsave
		Org_Company_id x = new Org_Company_id(orgid, company_id);
		Optional<Company> companyOp = companyDao.findById(x);
		//update name
		if(companyOp.isPresent()) {
			Company com= companyOp.get();
			com.setCompanyName("A02");
			Company newcom=companyDao.save(com);
			return newcom;
		}
		return new Company();
	}
	//=====
	@Override
	public Company saveCompany() {
		// TODO Auto-generated method stub
		Company a = new Company("��4","��4","��6");
	
		return companyDao.save(a);
	}
	

}
