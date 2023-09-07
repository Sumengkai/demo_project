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
			res.setMessage("��");
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
//	@ResponseBody    ->  (@RestController) �o�ӵ����w���]�t
	// �^�ǫ��A ��k�W�� �]�����O���ѼƦC��
	public BankRes deposit(@RequestBody BankReq request) {
		// ������nreq
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("��");
			return res;
		} else if (request.getDeposit() <= 0) {
			res.setMessage("�s�ڤ��o��0");
			return res;
		}
		// �o���entity�h���󤶭� �եι�@��k //entity�����Ʈw�|�Ψ�
															//string      //int
		Home_3_Bank_1 bank = bank_face_spr.deposit(request.getAccount(), request.getDeposit());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("�s��suces");
		return res; // ������n��res...//��res�Q�����Ҳ�
	}

	// =============================
	@PostMapping(value = "/api/withdraw")

	public BankRes withdraw(@RequestBody BankReq request) {
//		BankRes res = new BankRes();
//		res.setAccount("a01");
//		res.setAmount(1000);
//		if (!StringUtils.hasText(request.getAccount())) {
//			res.setMessage("��");
//			return res;
//
//		} else if (request.getWithdraw() > res.getAmount()) {
//			res.setMessage("�s�ڤ���");
//			return res;
//		}
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("��");
			return res;
		} // �i�H�g�bController �� Impl
		// �~�|���@�d
		return bank_face_spr.withdraw(request.getAccount(), request.getWithdraw());
//		res.setAmount(res.getAmount());
////		System.out.println("�b�� : " + bank.getAccount() + " �ӱb�����ګ�l�B : " + bank.getAmount());
//		res.setMessage("����suces");
//		return res;

	}
	// =============================
	

}
