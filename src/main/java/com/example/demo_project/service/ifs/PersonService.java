package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Person;

public interface PersonService {

//	default Person getPersonInfo(Person p) {
//		return p;
//		
//	}
	public Person getPersonInfo1(String id);

	// default是要在介面中實做的權限
	default Person getPersonInfo(String id) {
		return new Person();
	}
//=================================
	
}
