package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person_2;
import com.example.demo_project.repository.PersonDao;
import com.example.demo_project.service.ifs.Person_ifs_spr;
import com.example.demo_project.vo.PersonRes_2;

@Service
public class Person_impl_spr implements Person_ifs_spr {
	@Autowired
	private PersonDao personDao;
	// =============共用 (透過建構方法) name id age
	private Person_2 aa = new Person_2("小a", "123", 50);
	private Person_2 bb = new Person_2("小b", "456", 40);
	private Person_2 cc = new Person_2("小c", "789", 30);
	private Person_2 dd = new Person_2("蘇盟凱", "IG:mengkai_su", 23);

	// ============= 1
	@Override
	public List<Person_2> getatolid() {
		// TODO Auto-generated method stub
		// ===========假資料
//		List<Person_2> a = new ArrayList<>();
//		a.add(aa);
//		a.add(bb);
//		a.add(cc);
//		a.add(dd);
		// ===========真資料
		List<Person_2> list = personDao.findAll();
		return list;
	}

	// ============= 2
	@Override
	// 請求
	public Person_2 getid(String id) {
//		List<Person_2> a = new ArrayList<>();
//		a.add(aa);
//		a.add(bb);
//		a.add(cc);
//		personDao.getById(id).getId();
//		x.setId(personDao.getById(id).getId());
		// =============
										// 主鍵
		Optional<Person_2> x = personDao.findById(id);
		if (!x.isPresent()) {	//判斷有無值
			return null;
		}
		return x.get();
// =================================================
//		Person_2 per2 = new Person_2();
//		for(int i=0;i<a.size();i++) {
//			Person_2 per = a.get(i);
//		}

//		Person_2 per = null;
//		for (Person_2 per1 : a) {
//			if (id.equals(per1.getId())) {
//				per = per1;
//				return per;
//			}
//			else {
//				per = new Person_2(); //空殼
//			}
//
//		}
	}

	// ============= 3
	@Override
	// 回傳型態(return) //取得輸入
	public List<Person_2> getage(int age,String name) {
		// TODO Auto-generated method stub
//=====		
//		List<Person_2> list = personDao.findAll(); // 撈資料庫sql
//		List<Person_2> list2 = new ArrayList<>();
//		for (var person : list) {
//			if (person.getAge() > age) {
//				list2.add(person);
//			}
//		}
//		return list2;
//===================================================
//		List<Person_2> list3=personDao.findByAgeGreaterThan(age);
//		return list3;
		//==============================================
		List<Person_2> list4=personDao.findByAgeGreaterThanAndName(age, name);
		return list4;
		
		
	}
}
