package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
@IdClass(value=Org_Company_id.class)//讓他知道被託管了
public class Company {
	@Id
	@Column(name = "org_id")
	private String orgId;
	@Id
	@Column(name = "company_id")
	private String companyId;
	@Column(name = "company_name")
	private String companyName;
	public Company(String orgId,String companyId,String companyName) {
		this.orgId=orgId;
		this.companyId=companyId;
		this.companyName=companyName;
	}
	public Company() {}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

}
