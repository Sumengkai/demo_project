package com.example.demo_project.service.ifs;

import java.util.List;
import java.util.Set;

import com.example.demo_project.entity.Register;
import com.example.demo_project.vo.Register_Res;

public interface Register_Servic {
	public Register register(String name, String account, String city, String pwd, int age);

	public Register_Res active(String account);

	public Register_Res addrole(String account, List<String> list);

	public Register_Res addroleSet(String account, Set<String> list);

	public Register findById(String id);
	public Register getRegTime(String id,String pwd);
	public List<Register> findAll();

}
