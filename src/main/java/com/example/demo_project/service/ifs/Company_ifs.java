package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Company;

public interface Company_ifs {
	public List<Company> findAll();

	public Company findById(String orgid, String company_id);
	
	public Company updateByid(String orgid, String company_id);
	
	public Company saveCompany();

}
