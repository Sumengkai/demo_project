package com.example.demo_project;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo_project.entity.Users;
import com.example.demo_project.repository.UsersDao;
import com.example.demo_project.service.impl.UserDetailsServiceImpl;

@SpringBootTest
public class DemoProjectApplicationTest_Users {
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Test
	public void addUsersInfo() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Users u1 = new Users("AAA", encoder.encode("A123"), "admin", true);
		Users u2 = new Users("BBB", encoder.encode("B123"), "users", true);
		Users u3 = new Users("CCC", encoder.encode("C123"), "users", true);
		Users u4 = new Users("DDD", encoder.encode("D123"), "users", true);
		Users u5 = new Users("DDD", encoder.encode("D123"), "users", true);
		List<Users> list = Arrays.asList(u5);
		usersDao.saveAll(list);
	}
}
