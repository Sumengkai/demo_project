package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Person_2;
import com.example.demo_project.service.ifs.Person_ifs_spr;
import com.example.demo_project.vo.PersonReq_2;
import com.example.demo_project.vo.PersonReq_3;
import com.example.demo_project.vo.PersonRes_1;
import com.example.demo_project.vo.PersonRes_2;
import com.example.demo_project.vo.PersonRes_3;

@RestController
public class Person_Conteoller {
	@Autowired
	private Person_ifs_spr person_2_ifs;
	// ============= 1
	@PostMapping(value = "/api/getatolid")
	public PersonRes_1 getaltolid() {
		PersonRes_1 res = new PersonRes_1();
		res.setList(person_2_ifs.getatolid());
		return res;

	}
	// ============= 2
	@PostMapping(value = "/api/getatolid2")
	public PersonRes_2 gesomeid(@RequestBody PersonReq_2 req) {
		Person_2 person = person_2_ifs.getid(req.getId());
		PersonRes_2 res = new PersonRes_2();
		if (person==null) {
			res.setName("查無此人");
			return res;
		}

		res.setName(person.getName());
		res.setAge(person.getAge());
		res.setId(person.getId());
		return res;

	}
	// ============= 3
	@PostMapping(value = "/api/getatolid3")
	
	public PersonRes_3 getsomeage(@RequestBody PersonReq_3 req) {
		PersonRes_3 res = new PersonRes_3();
		res.setList(person_2_ifs.getage(req.getAge(),req.getName())); 
		return res;

	}

}
