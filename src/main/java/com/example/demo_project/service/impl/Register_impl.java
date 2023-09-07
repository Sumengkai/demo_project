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

//@ConditionOnA = �䧹KEY�Ȥ���ܤ@�]ConditionOnA or ConditionOnB
//@Primary = �D�n�|����[�b���ɮת����e�AConditionOnA or ConditionOnB ��ӳ��|�]
//@ConditionOnA
@Primary
@EnableScheduling
@Service
public class Register_impl implements Register_Servic {
	@Autowired
	private RegisterDao registerDao;
//	---
//	�Yreq���]�b�o��
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
			return null; // ������U�w�s�b�b��
		}
		// ==
//		Date now = new Date();//----->�t�η�e�ɶ�
//		long time =now.getTime(); //---->�@��
		// ==
		regis.setReg_time(new Date());// ----->�t�η�e�ɶ�
//		regis.setActuve(false); //-->�p�gB�w�]�Ofalse �i���μg
		regis.setRole("general");
		return registerDao.save(regis);
	}
	// ======================================================�E��

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
			// �h���Ѽ�rolelist�x���ƭ�
			Set<String> roleset = new HashSet<>();
			for (var x : rolelist) {
				roleset.add(x);

			}
			// �h��DB���s�b���ȩM�Ѽƪ��ȭ��Ƴ���
			Register reg = regop.get();
			String role = reg.getRole();// �i��|���h�� �T�γr���Ϲj ex:a , b , c����
			String[] roleArray = role.split(",");// �w��r�갵���� split("�n���N���F��")
			// -------------------------------------------------------------
			for (int i = 0; i < roleArray.length; i++) {
				String item = roleArray[i].trim(); // trim()�h���e��ť�(�r�ꪺ�\��)
				roleset.add(item);
			}
//			for(String i :roleArray) {
//				String strg =i.trim();
//				roleset.add(strg);
//			}
			// -------------------------------------------------------------
			// substring(���]�t����)�e���]�t,�᭱���]�t �]�N�O1~����-1
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
			// �h���Ѽ�rolelist�x���ƭ�

			// �h��DB���s�b���ȩM�Ѽƪ��ȭ��Ƴ���
			Register reg = regop.get();
			String role = reg.getRole();// �i��|���h�� �T�γr���Ϲj ex:a , b , c����
			String[] roleArray = role.split(",");// �w��r�갵���� split("�n���N���F��")
			// -------------------------------------------------------------
			for (int i = 0; i < roleArray.length; i++) {
				String item = roleArray[i].trim(); // trim()�h���e��ť�(�r�ꪺ�\��)
				setlist.add(item);
			}
//			for(String i :roleArray) {
//				String strg =i.trim();
//				roleset.add(strg);
//			}
			// -------------------------------------------------------------
			// substring(���]�t����)�e���]�t,�᭱���]�t �]�N�O1~����-1
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
	// �Ƶ{

//	@Scheduled(cron = "0 0 10 * * *")
//	public void schedulePrintDate() {
//		System.out.println(new Date() + "�Q�I");
//	}
//
//	@Scheduled(cron = "0 * 14-16 * * *")
//	public void schedulePrintDate2() {
//		System.out.println(new Date() + "���I-�|�I");
//	}
//
//	// �� �� �� �� �� �P �~(�i���i�L)
//	@Scheduled(cron = "0/10 0/2 * * * *")
//	public void schedulePrintDate��() {
//		System.out.println(new Date() + "�E�I");
//	}

//	@Scheduled(fixedRateString = "${heartbeat.ms}")
//	public void schedulePrintDateAnnatationTest() {
//		System.out.println(new Date() + "�E�I---ConditionOnA");
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
//		int a = 5 / 0; // (�G�N����)
		System.out.println("�o���T���b <����ɦVbefore> ���� �A <����ɦVafter> ���e");
		return registerDao.findAll();
	}

}
