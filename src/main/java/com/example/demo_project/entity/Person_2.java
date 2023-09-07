package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //�ŧi��������
@Table(name = "person")
public class Person_2 {
	@Id						//�D��
	@Column(name ="id")
	private String id;
	@Column(name ="name") //����sql���
	private String name;	//��W�����O�@�˪�
	@Column(name ="age")
	private int age;

	public Person_2() {
	}

	public Person_2(String name, String id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
