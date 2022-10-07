package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public Person getPersonInfo1(String id) {
		Person p1 = new Person();

		p1.setId(id);
		p1.setCity("6");
		p1.setName("7");
		p1.setAge(8);
		return p1;
	}
	public void printAll(Person p2) {
//		Person per = new Person();
		System.out.println(p2.getAge());
		System.out.println(p2.getCity());
		System.out.println(p2.getId());
		System.out.println(p2.getName());
	}

	public String getPersonId(Person p2) {
		return p2.getId();
	}

	public String getPersonName(Person p2) {
		return p2.getName();
	}

	public int getPersonAge(Person p2) {
		return p2.getAge();
	}

	public String getPersonCity(Person p2) {
		return p2.getCity();
	}

//	public void printAll(Person p2) {
////		Person per = new Person();
//		System.out.println(p2.getAge());
//		System.out.println(p2.getCity());
//		System.out.println(p2.getId());
//		System.out.println(p2.getName());
//	}

}
