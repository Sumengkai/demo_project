package com.example.demo_project.service.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person_2;

public interface Person_ifs_spr {
	public List<Person_2> getatolid();//1

	public Person_2 getid(String id);//2

	public List<Person_2> getage(int age,String name);//3
}
