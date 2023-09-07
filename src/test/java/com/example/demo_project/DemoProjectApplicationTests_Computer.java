package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Count_3;
import com.example.demo_project.entity.Count_4;
import com.example.demo_project.entity.Person;
import com.example.demo_project.service.impl.Count_1_impl_1;
import com.example.demo_project.service.impl.Count_2_impl_2;
import com.example.demo_project.service.impl.Count_3_impl_3;
//import com.example.demo_project.service.impl.Count_3_impl_3;
import com.example.demo_project.service.impl.Count_4_impl_4;
import com.example.demo_project.service.impl.Count_5_impl_5;

@SpringBootTest
public class DemoProjectApplicationTests_Computer {
	@Autowired
	private Count_1_impl_1 count_1_impl_1;
	@Autowired
	private Count_2_impl_2 count_2_impl_2;
	@Autowired
	private Count_3_impl_3 count_3_impl_3;
	@Autowired
	private Count_4_impl_4 count_4_impl_4;
	@Autowired
	private Count_5_impl_5 count_5_impl_5;

	@Test
	public void context1() {
		count_1_impl_1.getCount();
	}

	@Test
	public void context2() {
		count_2_impl_2.getCount();
	}

	@Test
	public void context3() {
		count_3_impl_3.getTo();
	}

	@Test
	public void context4() {

		count_4_impl_4.getTo2();

	}
	@Test
	public void context5() {

		count_5_impl_5.getTo3();

	}
}
