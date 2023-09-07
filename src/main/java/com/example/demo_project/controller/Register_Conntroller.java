package com.example.demo_project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.Constanes.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.service.ifs.Register_Servic;
import com.example.demo_project.vo.AcctiveAccountReq;
import com.example.demo_project.vo.AddRoleListReq;
import com.example.demo_project.vo.AddRoleSetReq;
import com.example.demo_project.vo.Register_Req;
import com.example.demo_project.vo.Register_Res;
import com.example.demo_project.vo.loginInfo;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
public class Register_Conntroller {
	@Autowired
	private Register_Servic register_Servic;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping(value = "/api/getRegTime")
	public Register_Res getRegTime(@RequestBody Register_Req req) {
		Register_Res res = new Register_Res();
		res.setRegister(register_Servic.getRegTime(req.getAccount(), req.getPwd()));
		return res;

	}

	@PostMapping(value = "/api/register1")
	public Register_Res register1(@RequestBody Register_Req req, HttpSession httpSession) {
		// ======================
//		if (!StringUtils.hasText(req.getAccount())) {
//			return new Register_Res("no Account");
//		} else if (!StringUtils.hasText(req.getName())) {
//			return new Register_Res("no name");
//		} else if (!StringUtils.hasText(req.getPwd())) {
//			return new Register_Res("no pwd");
//		}
		// ====================將上面抽起來做成私有方法
		Register_Res chickres = chickparameter(req);
		if (chickres != null) {
			return chickres;
		}
		// ==
		Register reg = register_Servic.register(req.getName(), req.getAccount(), req.getCity(), req.getPwd(),
				req.getAge());
		if (reg == null) {
			return new Register_Res(RegisterRtnCode.ACCOUNT_EXISTED.getMessage());
		}
		// add verify code into httpSession
		int verifyCode = (int) Math.round(Math.random() * 10000);
		httpSession.setAttribute("驗證碼", verifyCode);
		httpSession.setMaxInactiveInterval(1000);// 限時1000秒
		httpSession.setAttribute("帳號", req.getAccount());
		httpSession.setMaxInactiveInterval(1000);// 限時1000秒
		return new Register_Res(reg, RegisterRtnCode.SUCCESSFUL.getMessage(), verifyCode);
//		return res;

	}

	// ==============================
	// 私有方法 確認參數用 確認參數
	private Register_Res chickparameter(@RequestBody Register_Req req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new Register_Res(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage()); // 列舉
		} else if (!StringUtils.hasText(req.getName())) {
			return new Register_Res(RegisterRtnCode.NAME_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getPwd())) {
			return new Register_Res("no pwd");
		}
		return null;
	}

	// ==============================
	// ================================================================================
	// --激活
	@PostMapping(value = "/api/register2")
	public Register_Res register2(@RequestBody Register_Req req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new Register_Res(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		return register_Servic.active(req.getAccount());
//		if(boolx) {
//			return new Register_Res(null, RegisterRtnCode.SUCCESSFUL.getMessage());
//		}
//		return new Register_Res(null, RegisterRtnCode.FAILURE.getMessage());

	}

	// =====================================新增腳色list
	@PostMapping(value = "/api/registerlist3")
	public Register_Res addrleList(@RequestBody AddRoleListReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new Register_Res(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		if (CollectionUtils.isEmpty(req.getList())) {
			return new Register_Res(RegisterRtnCode.ROLL_LIST_IS_EMPTY.getMessage());
		}
		return register_Servic.addrole(req.getAccount(), req.getList());

	}

	// =====================================新增腳色set
	@PostMapping(value = "/api/registerset4")
	public Register_Res addrleSet(@RequestBody AddRoleSetReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new Register_Res(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
//		if(req.getRoleset()==null||req.getRoleset().isEmpty()) {
		if (CollectionUtils.isEmpty(req.getRoleset())) {
			return new Register_Res(RegisterRtnCode.ROLL_LIST_IS_EMPTY.getMessage());
		}
		return register_Servic.addroleSet(req.getAccount(), req.getRoleset());

	}

	// =====================================
	// 可以限制使用者的登入時效
	@PostMapping(value = "/api/login")
	public Register_Res login(@RequestBody loginInfo loginInfos, HttpSession httpSession) {
		if (!StringUtils.hasText(loginInfos.getAccount()) || !StringUtils.hasText(loginInfos.getPassword())) {
			return new Register_Res("參數不能空");
		}
		Register result = register_Servic.findById(loginInfos.getAccount());
		if (result == null) {
			return new Register_Res("錯誤的帳號");
		}
		// 字串,物件
		httpSession.setAttribute("ㄏㄏ", result.getAccount());
		// 設定有效時間
		httpSession.setMaxInactiveInterval(20);
		return new Register_Res(result, "登入成功");
	}

	// =====================================
	@PostMapping(value = "/api/logout")
	public Register_Res logout(HttpSession httpSession) {
		httpSession.removeAttribute("ㄏㄏ");
		return new Register_Res("登出成功");
	}

	// =====================================
	@PostMapping(value = "/api/get_User_Info")
	public Register_Res getUserInfo(HttpSession httpSessions) {
//		httpSession.removeAttribute("ㄏㄏ ^.^");
		// key/value
		Object attValue = httpSessions.getAttribute("ㄏㄏ");
		if (attValue != null) {
			String account = httpSessions.getAttribute("ㄏㄏ").toString();
			Register result = register_Servic.findById(account);
			return new Register_Res(result, "取得用戶資訊成功");
		}
		return new Register_Res("取得用戶資訊錯誤");
	}

	// =====================================
	// --激活
	@PostMapping(value = "/api/activeAccount2")
	public Register_Res acctiveAccount(@RequestBody AcctiveAccountReq req, HttpSession httpSession) {
		Object verifyCode = httpSession.getAttribute("驗證碼");
		String account = httpSession.getAttribute("帳號").toString();
		if (verifyCode != null && account != null) {
			int checkVerifyCode = (int) verifyCode;
			if (checkVerifyCode == req.getVerifyCode()) {
				Register result = register_Servic.findById(account);
				register_Servic.active(result.getAccount());
				return new Register_Res(result, "通過驗證");
			}

		}

		return new Register_Res(new Register(), "驗證失敗");

	}
}
