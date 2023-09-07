package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Person;
import com.example.demo_project.entity.userAIid;
import com.example.demo_project.repository.UserAiID;
import com.example.demo_project.service.ifs.PersonService;

@SpringBootTest
public class UserAiIdTest {
	@Autowired
	private UserAiID userAiID;

	@Test
	public void select() {
		userAIid userAIid = userAiID.select();
		String name ="kai_100";
		System.out.println(userAIid.getId() + "最大流水號");
		System.out.println(userAIid.getName() + "最大名子");
		System.out.println(userAIid.getName().substring(userAIid.getName().lastIndexOf('_') + 1));
		System.out.println(name.substring(name.lastIndexOf('_') + 1));
		int i = userAiID.selAiId();
		System.out.println(i+"男哥教的");
	}

}
