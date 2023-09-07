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

	// sql語法 -> 表格名稱<跟著Entity> 變數名稱(reg) 欄位名稱 :修改的東西(自訂義)
	@Transactional
	@Modifying
	@Query(" update Register reg set reg.name = :newName, reg.city = :newCity, reg.age=:newAge, reg.reg_time = :regtime "
			+ "where reg.account = :account")
	public int updateRegisterInfo(

			// @Param( 冒號後面的名子 )

			@Param("newName") String newName, // ( 藍色部分的參數名稱要跟著冒號後面的參數名稱 )
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
