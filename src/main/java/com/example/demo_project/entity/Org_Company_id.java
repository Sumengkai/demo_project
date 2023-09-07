package com.example.demo_project.entity;

import java.io.Serializable;
import java.util.Objects;
//АUКо
@SuppressWarnings("serial")
public class Org_Company_id implements Serializable {
	private String orgId;
	private String companyId;

	public Org_Company_id() {
	}
	public Org_Company_id(String orgId,String companyId) {
		this.orgId = orgId;
		this.companyId = companyId;
	}

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

	
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("EQUALS...=======");
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Org_Company_id other = (Org_Company_id) obj;
//		return orgId == other.orgId && Objects.equals(companyid, other.companyid);
//	}
//
//	// equals============================================================
//	public Integer tryParse(Object x) {
//		Integer rere;
//		try {
//			rere = Integer.parseInt(x.toString());
//		} catch (Exception e) {
//			// TODO: handle exception
//			rere = null;
//		}
//		return rere;
//
//	}
	
}
