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
			res.setAccount("不可重複");
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
			res.setAccount("查無此帳戶");
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
			res.setAccount("帳戶不對或存款不得小於0");
			return res;
		}

		res.setAccount("帳戶: " + bank.getAccount() + " 您的原本存款 : " + (bank.getAmount() - req.getDeposit()) + " 存入: "
				+ req.getDeposit());
		res.setAmount(bank.getAmount());
		res.setMsssage("存款成功");

		if (isMessage == null && bank.getAmount() >= 1000000) {
			session.setAttribute("isMessage", true);
			res.setMsssage("恭喜存到" + (bank.getAmount() / 10000) + "萬");
		}
		return res;
	}

	@PostMapping(value = "/api/getbank4")
	public H_bankRes_1 getbank4(@RequestBody H_bankReq_1 req) {
		H_bankRes_1 res = new H_bankRes_1();
		Home_bank_1 bank = h_bank_ifs_1.withdeaw(req.getAccount(), req.getWithdraw());
		if (req.getWithdraw() < 0) {
			res.setAccount("提款不得是零或小於零");
			return res;
		}
		if (bank == null) {
			res.setAccount("帳戶不對或提款大於餘額,你沒錢");
			return res;
		}
		res.setAccount("帳戶: " + bank.getAccount() + " 您的原本存款 : " + (bank.getAmount() + req.getWithdraw()) + " 提領 : "
				+ req.getWithdraw());
		res.setAmount(bank.getAmount());
		res.setMsssage("提款成功");
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
		res.setMsssage("刪除成功");
		return res;
		
	}

}
