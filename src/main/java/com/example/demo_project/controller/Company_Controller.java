package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Company;
import com.example.demo_project.service.ifs.Company_ifs;
import com.example.demo_project.vo.Company_Req;

@RestController
public class Company_Controller {
	@Autowired
	private Company_ifs company_ifs;

	@PostMapping(value = "/api/getcompany")
	public List<Company> findAll() {
		return company_ifs.findAll();
	}
	@PostMapping(value = "/api/getcompany2")
	public Company findById(@RequestBody  Company_Req req){
		return company_ifs.findById(req.getOrgid(), req.getCompanyid());
		
	}
	@PostMapping(value = "/api/getcompany3")
	public Company updateById(@RequestBody  Company_Req req) {
		
		return company_ifs.updateByid(req.getOrgid(), req.getCompanyid());
		
	}
	@PostMapping(value = "/api/getcompany4")
	public Company saveCompany(@RequestBody  Company_Req req) {
		return company_ifs.saveCompany();
//		return null;
		
	}
}
