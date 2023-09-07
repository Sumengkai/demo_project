package com.example.demo_project.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Home_bank_1;
import com.example.demo_project.repository.BankDao_1;
import com.example.demo_project.service.ifs.H_bank_ifs_1;
import com.example.demo_project.vo.H_bankReq_1;
import com.example.demo_project.vo.H_bankRes_1;

@RestController
public class H_BankController_1 {
	@Autowired
	private H_bank_ifs_1 h_bank_ifs_1;
	// ===========
	@Autowired
	private BankDao_1 bankDao_1;
	// ===========

	// ======================1
	@PostMapping(value = "/api/getbank1")
	public H_bankRes_1 getbank1(@RequestBody H_bankReq_1 req) {
		H_bankRes_1 res = new H_bankRes_1();
		Home_bank_1 x = h_bank_ifs_1.bank1(req.getAccount());
		
		if (x == null) {
			res.setAccount("���i����");
			return res;
		}
		res.setAccount(x.getAccount());
		res.setAmount(x.getAmount());
		return res;
	}

	// ======================2
	@PostMapping(value = "/api/getbank2")
	public H_bankRes_1 getbank2(@RequestBody H_bankReq_1 req) {
		H_bankRes_1 res = new H_bankRes_1();
		Home_bank_1 x = h_bank_ifs_1.bank2(req.getAccount());
		if (x == null) {
			res.setAccount("�d�L���b��");
			return res;
		}

		res.setAccount(x.getAccount());
		res.setAmount(x.getAmount());
		return res;

	}

	// ======================3
	@PostMapping(value = "/api/getbank3")
	public H_bankRes_1 getbank3(@RequestBody H_bankReq_1 req, HttpSession session) {
		// ======================================================
		Boolean isMessage = (Boolean) session.getAttribute("isMessage");
//		// ======================================================
//		Boolean x = false;
//		Home_bank_1 bank1 = h_bank_ifs_1.deposit(req.getAccount(), req.getDeposit());
//		@SuppressWarnings("unchecked")
//		Map<String, Boolean> map = (Map<String, Boolean>) session.getAttribute("map");
////		for(int i=0;i<=map.size();i++) {
////			
////		}
//		map.put(bank1.getAccount(), x);
//		if(x=false&& bank1.getAmount() >= 1000000) {
//			x=true;
//			session.setAttribute("map",x);
//		}
		// ======================================================
		H_bankRes_1 res = new H_bankRes_1();
		Home_bank_1 bank = h_bank_ifs_1.deposit(req.getAccount(), req.getDeposit());
		if (bank == null) {
			res.setAccount("�b�ᤣ��Φs�ڤ��o�p��0");
			return res;
		}

		res.setAccount("�b��: " + bank.getAccount() + " �z���쥻�s�� : " + (bank.getAmount() - req.getDeposit()) + " �s�J: "
				+ req.getDeposit());
		res.setAmount(bank.getAmount());
		res.setMsssage("�s�ڦ��\");

		if (isMessage == null && bank.getAmount() >= 1000000) {
			session.setAttribute("isMessage", true);
			res.setMsssage("���ߦs��" + (bank.getAmount() / 10000) + "�U");
		}
		return res;
	}

	@PostMapping(value = "/api/getbank4")
	public H_bankRes_1 getbank4(@RequestBody H_bankReq_1 req) {
		H_bankRes_1 res = new H_bankRes_1();
		Home_bank_1 bank = h_bank_ifs_1.withdeaw(req.getAccount(), req.getWithdraw());
		if (req.getWithdraw() < 0) {
			res.setAccount("���ڤ��o�O�s�Τp��s");
			return res;
		}
		if (bank == null) {
			res.setAccount("�b�ᤣ��δ��ڤj��l�B,�A�S��");
			return res;
		}
		res.setAccount("�b��: " + bank.getAccount() + " �z���쥻�s�� : " + (bank.getAmount() + req.getWithdraw()) + " ���� : "
				+ req.getWithdraw());
		res.setAmount(bank.getAmount());
		res.setMsssage("���ڦ��\");
		return res;

	}

	// ============
	@PostMapping(value = "/api/getbank5")
	public H_bankRes_1 delete(@RequestBody H_bankReq_1 req) {
		H_bankRes_1 res = new H_bankRes_1();
		h_bank_ifs_1.delete(req.getAccount());
		res.setMsssage("ssss");
		return res;
	}
	// ============
	@PostMapping(value = "/api/getbank6")
	public H_bankRes_1 deletebyname(@RequestBody H_bankReq_1 req) {
		H_bankRes_1 res = new H_bankRes_1();
		h_bank_ifs_1.deleteByName(req.getName());
		res.setMsssage("�R�����\");
		return res;
		
	}

}
