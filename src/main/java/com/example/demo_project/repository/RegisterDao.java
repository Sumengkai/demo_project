package com.example.demo_project.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Register;

@Repository
public interface RegisterDao extends JpaRepository<Register, String> {

	// sql�y�k -> ���W��<���Entity> �ܼƦW��(reg) ���W�� :�ק諸�F��(�ۭq�q)
	@Transactional
	@Modifying
	@Query(" update Register reg set reg.name = :newName, reg.city = :newCity, reg.age=:newAge, reg.reg_time = :regtime "
			+ "where reg.account = :account")
	public int updateRegisterInfo(

			// @Param( �_���᭱���W�l )

			@Param("newName") String newName, // ( �Ŧⳡ�����ѼƦW�٭n��۫_���᭱���ѼƦW�� )
			@Param("newCity") String newCity, @Param("newAge") int newAge, @Param("regtime") Date regtime,
			@Param("account") String account

	);

	// ---
	public List<Register> doQueryByExpiredRegtime(Date date);

	// ---
	public List<Register> doQueryByExpiredRegtime(Date date, int pageSize);

	// ---
	public List<Register> doQueryByExpiredRegtime(Date date, int pageSize, int startPosition);

	// ---
	public List<Register> doNativeQueryByExpiredRegtime(Date date, int pageSize, int startPosition);

	// ---
	@Transactional
	public int updateAgeByname(String name, int newAge);

	// ---
	@Transactional
	public int updateAgeByAccount(String account, int newAge);

	// ---
	@Transactional
	public int nativeUpdateAgeByName(String name, int newAge);

	// ---
	@Transactional
	public int nativeUpdateAgeByAccount(String account, int newAge);

	// ---dynamic params
	public List<Register> doQueryRoleContains(List<String> roleList);

	public Register findByAccountAndPwd(String account, String pwd);
}
