package com.example.demo_project.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.kafka.StreamsBuilderFactoryBeanCustomizer;

import com.example.demo_project.entity.Register;

public class RegisterDaoImpl extends BaseDao {
	public List<Register> doQueryByExpiredRegtime(Date date) {
		StringBuffer sb = new StringBuffer(); // Q1 #實作方法
		sb.append(" SELECT r FROM Register r ");
		sb.append(" WHERE r.reg_time > :expiredDate ");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		return doQuery(sb.toString(), params, Register.class);
	}

	// ---
	public List<Register> doQueryByExpiredRegtime(Date date, int pageSize) {
		StringBuffer sb = new StringBuffer(); // Q1 #實作方法
		sb.append(" SELECT r FROM Register r ");
		sb.append(" WHERE r.reg_time > :expiredDate ");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		return doQuery(sb.toString(), params, Register.class, pageSize);
	}

	// ---do quertwith pagesize and startposition
	public List<Register> doQueryByExpiredRegtime(Date date, int pageSize, int startPosition) {
		StringBuffer sb = new StringBuffer(); // Q1 #實作方法
		sb.append(" SELECT r FROM Register r ");
		sb.append(" WHERE r.reg_time > :expiredDate ");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		return doQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}

	// ---
	public List<Register> doNativeQueryByExpiredRegtime(Date date, int pageSize, int startPosition) {
		StringBuffer sb = new StringBuffer(); // Q1 #實作方法
		sb.append(" SELECT * FROM register r "); // 這裡是跟著table <遵照sql語法>
		sb.append(" WHERE r.reg_time > :expiredDate ");
		Map<String, Object> params = new HashMap<>();
		params.put("expiredDate", date);
		return doNativeQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}

	// ---
	public int updateAgeByname(String name, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE Register SET age = :age");
		sb.append(" WHERE name = :newName");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newName", name);
		return doQuery(sb.toString(), params);

	}

	// ---
	public int updateAgeByAccount(String account, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE Register SET age = :age");
		sb.append(" WHERE account = :newAccount");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newAccount", account);
		return doQuery(sb.toString(), params);

	}

	// ---native要用sql的table
	public int nativeUpdateAgeByName(String name, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE register SET age = :age");
		sb.append(" WHERE name = :newName");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newName", name);
		return doNativeUpdateByName(sb.toString(), params);

	}

	// ---native要用sql的table
	public int nativeUpdateAgeByAccount(String account, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE register SET age = :age");
		sb.append(" WHERE account = :newAccount");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newAccount", account);
		return doNativeUpdateByAccount(sb.toString(), params);

	}

	// ----
//	params = {role(i) = %SD%,role(i) = %SA%} 相同ㄉKEY會後蓋前,為了避免key重複 故需要用迴圈 並加上index
//  StringBuffer > SQL語法: SELECT * FROM register r WHERE ROLE like role(i) or role like role(i)
// 上面 StringBuffer sql 中 (i) 取自參數列的index
//  要判斷參數列是否為最後一個 , 會決定 StringBuffer 是否需要加 or 
	public List<Register> doQueryRoleContains(List<String> roleList) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * FROM register r WHERE ");
		Map<String, Object> params = new HashMap<>();
		for (int i = 0; i < roleList.size(); i++) {
			String item = roleList.get(i);
			if (i < roleList.size() - 1) { // ex: (0 < 3 - 1)
				// SELECT * FROM register r WHERE role like :role
				// or role like :role
				// or role like SA + (i)
				// params = {role = SD} key值 為了避免key重複 故需要用迴圈 並加上index
				// params = {role(i) = %SD%,role(i) = %SA%} key值 為了避免key重複 故需要用迴圈 並加上index
				sb.append(" role like :role" + i + " OR ");
			} else {
				// or role like SD
				sb.append(" role like :role" + i);
			}
			params.put("role" + i, "%" + item + "%");
		}
		System.out.println(sb.toString()+" sb ");
		return doNativeQuery(sb.toString(), params, Register.class, -1, 0);

	}

}
