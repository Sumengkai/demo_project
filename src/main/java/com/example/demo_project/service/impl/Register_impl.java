package com.example.demo_project.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo_project.Constanes.RegisterRtnCode;
import com.example.demo_project.annotation.ConditionOnA;
import com.example.demo_project.annotation.ConditionOnB;
import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.Register_Servic;
import com.example.demo_project.vo.Register_Res;

//@ConditionOnA = 找完KEY值之後擇一跑ConditionOnA or ConditionOnB
//@Primary = 主要會執行加在該檔案的內容，ConditionOnA or ConditionOnB 兩個都會跑
//@ConditionOnA
@Primary
@EnableScheduling
@Service
public class Register_impl implements Register_Servic {
	@Autowired
	private RegisterDao registerDao;
//	---
//	若req打包在這裡
//	@Cacheable(value = "account", key = "#req.account")
//	---
	@Cacheable(value = "account", key = "#account")
	@Override
	public Register getRegTime(String account, String pwd) {
		Register res = registerDao.findByAccountAndPwd(account, pwd);
		return res;

	}

	@Override
	public Register register(String name, String account, String city, String pwd, int age) {
		Register regis = new Register(name, account, city, pwd, age);

		if (registerDao.existsById(account)) {
			return null; // 不能註冊已存在帳號
		}
		// ==
//		Date now = new Date();//----->系統當前時間
//		long time =now.getTime(); //---->毫秒
		// ==
		regis.setReg_time(new Date());// ----->系統當前時間
//		regis.setActuve(false); //-->小寫B預設是false 可不用寫
		regis.setRole("general");
		return registerDao.save(regis);
	}
	// ======================================================激活

	@Override
	public Register_Res active(String account) {
		// TODO Auto-generated method stub
		Optional<Register> regop = registerDao.findById(account);
		if (regop.isPresent()) {
			Register reg = regop.get();
			reg.setActuve(true);
			registerDao.save(reg);
			return new Register_Res(null, RegisterRtnCode.SUCCESSFUL.getMessage());
		}

		return new Register_Res(null, RegisterRtnCode.FAILURE.getMessage());
	}

	// ======================================================
	@Override
	public Register_Res addrole(String account, List<String> rolelist) {

		Optional<Register> regop = registerDao.findById(account);

		if (regop.isPresent()) {
			// 去除參數rolelistㄉ重複值
			Set<String> roleset = new HashSet<>();
			for (var x : rolelist) {
				roleset.add(x);

			}
			// 去除DB中存在的值和參數的值重複部分
			Register reg = regop.get();
			String role = reg.getRole();// 可能會有多個 固用逗號區隔 ex:a , b , c角色
			String[] roleArray = role.split(",");// 針對字串做切分 split("要替代的東西")
			// -------------------------------------------------------------
			for (int i = 0; i < roleArray.length; i++) {
				String item = roleArray[i].trim(); // trim()去除前後空白(字串的功能)
				roleset.add(item);
			}
//			for(String i :roleArray) {
//				String strg =i.trim();
//				roleset.add(strg);
//			}
			// -------------------------------------------------------------
			// substring(取包含的值)前面包含,後面不包含 也就是1~長度-1
			String newstr = roleset.toString().substring(1, roleset.toString().length() - 1);
			System.out.println(roleset.toString().substring(1, roleset.toString().length() - 1));
			reg.setRole(newstr);
			registerDao.save(reg);
			Register_Res res = new Register_Res(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
			return res;
//			List<String> roleListInDb =Arrays.asList(roleArray);
		}
		return new Register_Res(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

	// ======================================================
	@Override
	public Register_Res addroleSet(String account, Set<String> setlist) {
		// TODO Auto-generated method stub
		Optional<Register> regop = registerDao.findById(account);

		if (regop.isPresent()) {
			// 去除參數rolelistㄉ重複值

			// 去除DB中存在的值和參數的值重複部分
			Register reg = regop.get();
			String role = reg.getRole();// 可能會有多個 固用逗號區隔 ex:a , b , c角色
			String[] roleArray = role.split(",");// 針對字串做切分 split("要替代的東西")
			// -------------------------------------------------------------
			for (int i = 0; i < roleArray.length; i++) {
				String item = roleArray[i].trim(); // trim()去除前後空白(字串的功能)
				setlist.add(item);
			}
//			for(String i :roleArray) {
//				String strg =i.trim();
//				roleset.add(strg);
//			}
			// -------------------------------------------------------------
			// substring(取包含的值)前面包含,後面不包含 也就是1~長度-1
			String newstr = setlist.toString().substring(1, setlist.toString().length() - 1);
			System.out.println(setlist.toString().substring(1, setlist.toString().length() - 1));
			reg.setRole(newstr);
			registerDao.save(reg);
			Register_Res res = new Register_Res(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
			return res;
//			List<String> roleListInDb =Arrays.asList(roleArray);
		}
		return new Register_Res(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());

	}
	// ---------------------------------------------------------------------------------
	// 排程

//	@Scheduled(cron = "0 0 10 * * *")
//	public void schedulePrintDate() {
//		System.out.println(new Date() + "十點");
//	}
//
//	@Scheduled(cron = "0 * 14-16 * * *")
//	public void schedulePrintDate2() {
//		System.out.println(new Date() + "兩點-四點");
//	}
//
//	// 秒 分 時 日 月 周 年(可有可無)
//	@Scheduled(cron = "0/10 0/2 * * * *")
//	public void schedulePrintDateˇ() {
//		System.out.println(new Date() + "九點");
//	}

//	@Scheduled(fixedRateString = "${heartbeat.ms}")
//	public void schedulePrintDateAnnatationTest() {
//		System.out.println(new Date() + "九點---ConditionOnA");
//		System.out.println("------------------");
//	}

//====================================================
//	@Cacheable(value = "account", key = "#amount")
	@Override
	public Register findById(String id) {
		Optional<Register> op = registerDao.findById(id);
		return op.orElse(null);
	}

	@Override
	public List<Register> findAll() {
//		int a = 5 / 0; // (故意報錯)
		System.out.println("這條訊息在 <橫切導向before> 之後 ， <橫切導向after> 之前");
		return registerDao.findAll();
	}

}
