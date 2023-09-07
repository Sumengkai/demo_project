package com.example.demo_project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Person_2;
import com.example.demo_project.entity.userAIid;
import com.example.demo_project.vo.DoubleUserTest;

@Repository
public interface UserAiID extends JpaRepository<userAIid, Integer> {

	@Query(value = "SELECT * FROM users_ai_id WHERE id = (SELECT MAX(id) FROM users_ai_id);", nativeQuery = true)
	public userAIid select();
	@Query(value = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES "+"WHERE TABLE_NAME = 'users_ai_id' AND TABLE_SCHEMA = 'demo_test'", nativeQuery = true)
	public int selAiId();
}
