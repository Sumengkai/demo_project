package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Home_1_Bird;
import com.example.demo_project.service.ifs.Home_1_Bird_face;

@Service
public class Home_1_Bird_Impl implements Home_1_Bird_face {
	@Override
	public void Fly4(String name, int age) {
		Home_1_Bird bird1 = new Home_1_Bird();
		bird1.setName(name);
		bird1.setAge(age);
		System.out.println(bird1.getName() + "他今年才" + bird1.getAge() + "歲,正在想入飛飛," + "因為飛飛真的很漂亮");

	}

}
