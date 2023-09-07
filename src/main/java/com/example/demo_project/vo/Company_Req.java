package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company_Req {
	@JsonProperty("orgid")
	private String orgid;
	@JsonProperty("companyid")
	private String companyid;

	public Company_Req() {
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

}
