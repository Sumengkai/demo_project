package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Home_3_Bank_1;
import com.example.demo_project.service.ifs.Bank_face_spr;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;
import com.example.demo_project.vo.Order;

@RestController
public class BankController {
	@Autowired
	private Bank_face_spr bank_face_spr;

	@PostMapping(value = "/api/getamount")
	public BankRes getAmount(@RequestBody BankReq request) {
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("空");
			return res;
		}

		// entity //face
		Home_3_Bank_1 bank = bank_face_spr.getamount(request.getAccount());
		int amount = bank.getAmount();
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("suces");
		return res;
	}

//	//=============================
	@PostMapping(value = "/api/deposit")
//	@ResponseBody    ->  (@RestController) 這個註釋已有包含
	// 回傳型態 方法名稱 包住類別的參數列表
	public BankRes deposit(@RequestBody BankReq request) {
		// 為什麼要req
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("空");
			return res;
		} else if (request.getDeposit() <= 0) {
			res.setMessage("存款不得為0");
			return res;
		}
		// 這邊用entity去等於介面 調用實作方法 //entity之後資料庫會用到
															//string      //int
		Home_3_Bank_1 bank = bank_face_spr.deposit(request.getAccount(), request.getDeposit());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("存款suces");
		return res; // 為什麼要用res...//把res想像成模組
	}

	// =============================
	@PostMapping(value = "/api/withdraw")

	public BankRes withdraw(@RequestBody BankReq request) {
//		BankRes res = new BankRes();
//		res.setAccount("a01");
//		res.setAmount(1000);
//		if (!StringUtils.hasText(request.getAccount())) {
//			res.setMessage("空");
//			return res;
//
//		} else if (request.getWithdraw() > res.getAmount()) {
//			res.setMessage("存款不足");
//			return res;
//		}
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("空");
			return res;
		} // 可以寫在Controller 或 Impl
		// 才會有一千
		return bank_face_spr.withdraw(request.getAccount(), request.getWithdraw());
//		res.setAmount(res.getAmount());
////		System.out.println("帳號 : " + bank.getAccount() + " 該帳號提款後餘額 : " + bank.getAmount());
//		res.setMessage("提款suces");
//		return res;

	}
	// =============================
	

}
