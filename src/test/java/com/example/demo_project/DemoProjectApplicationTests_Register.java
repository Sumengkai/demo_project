package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.Register_Servic;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.x.protobuf.MysqlxExpr.Array;

@WebAppConfiguration
@SpringBootTest(classes = DemoProjectApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class DemoProjectApplicationTests_Register {
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	@Autowired
	private Register_Servic register_Servic;
	@Autowired
	private RegisterDao registerDao;
	// ====================
//	@BeforeAll
//	public void beforeAll() {
//		System.out.println("aaaaa");
//	}

	@BeforeEach // 每一個測試之前都是建立一筆假資料
	public void beforeach() {
		System.out.println("bbbbbb");
	}

	// --------------------------------------
	@Autowired
	private WebApplicationContext wac;// 基於WebApplicationContext建立的物件,用來編寫web的整合測試
	private MockMvc mockMvc; // 實現對http請求的模擬用來測試controller

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	// -------------------自己寫postman 新增帳號
	@SuppressWarnings("unchecked")
	@Test
	public void RegisterControllerTest() throws Exception {
		HttpHeaders headers = new HttpHeaders();// 無用 要用在這條.headers(headers) //如果Headers要加的參數有多個,可用此方式;
		headers.setContentType(MediaType.APPLICATION_JSON); // 無用
		// srt request_body
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("account", "a98");
		map.put("pwd", "a12345");
		map.put("name", "David");
		map.put("age", 22);
		map.put("city", "Taiwan");
		// map to string (類似打到postman的動作)
		ObjectMapper objectmap = new ObjectMapper(); // 為了符合postman的格式
		String mapstring = objectmap.writeValueAsString(map);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register1")
//				.headers(headers) //如果Headers要加的參數有多個,可用此方式;
				.contentType(CONTENT_TYPE) // Headers 要加的的參數就只有contentType時,可直接使用,不用Headers加入
				.content(mapstring));
		// get res
		String resString = result.andReturn().getResponse().getContentAsString();
		// 得到的res轉成json(map)
		JacksonJsonParser json = new JacksonJsonParser();
		Map<String, Object> resdata = json.parseMap(resString);
		System.out.println(resdata);
//		MockHttpServletResponse http = result.andReturn().getResponse();
//		String httpstring =http.getContentAsString(); 

//		String rtnmessage1 = (String) resdata.get("register_info");
//		System.out.println("強轉字串型態 : " + rtnmessage1);
		Object rtnmessage2 = resdata.get("register_info");
		System.out.println("物件型態 : " + rtnmessage2);
//		Register rtnmessage3 = (Register) resdata.get("register_info");
//		System.out.println("Register的物件型態 : " + rtnmessage3);
		Map<String, Object> rtninfo = (Map<String, Object>) resdata.get("register_info");
//		Assert.isTrue(rtnmessage3.getAccount().equals("a88"),"比對");
		Assert.isTrue(((String) rtninfo.get("轉型比對:")).equals("a98"), "掰掰");
		System.out.println("rtninfo--" + rtninfo);
		System.out.println("resdata--" + resdata);

	}

	// -----------自己寫postman 新增腳色----------------
	@Test
	public void RegisterControllerByaddroleTest() throws Exception {

	}
	// ====================

	@Test // 註冊
	public void register1() {
		Register reg = register_Servic.register("kai", "1", "taiwan", "123", 23);
//		Optional<Register>  result =registerDao.findById("a01");
//		if(result.isPresent()) {}
//		if(registerDao.existsById("a01")) {}
		Assert.notNull(reg, "掰掰"); // -->判斷是否為空,不是的話回傳前面的屬性,是的話回傳後面的掰掰
		Assert.isTrue(reg.getAccount().equals("1"), "掰掰掰"); // -->判斷是否為true,是的話回傳前面的屬性,不是的話回傳後面的掰掰,且抱錯

		// registerDao.delete(reg); //刪除
//		Optional<Register> regop = registerDao.findById("a99");
//		Assert.isTrue(!regop.isPresent(), "ss"); //第一種
		Assert.isTrue(registerDao.existsById("1"), "ss"); // 第二種
		System.out.println("測試1");
	}
	// ====================================================================================

	@Test // 激活
	public void register2() {
		// pkid
		Register reg = register_Servic.register("kai", "a99", "taiwan", "123", 23);
		// 新建的帳號,布林值為false
		// istrue(欄位內是一件事情 , 實際上的值不變)
		Assert.isTrue(!reg.isActuve(), "判斷是否為true,欄位內的條件是 false,加驚嘆號會變成true");// -->判斷是否為true,欄位內的條件是 false ,
																				// 加驚嘆號會變成true
		register_Servic.active("a99");
		Register newreg = registerDao.findById("a99").get();
		Assert.isTrue(newreg.isActuve(), "成");
		registerDao.delete(newreg);
		System.out.println("Test激活");
	}
	// ======================================================================================

	@Test // 角色
	public void addrole() {
		List<String> x = new ArrayList();
		x.add("SA");
		x.add("SA");
		x.add("SD");
		x.add("SD");
		register_Servic.addrole("a02", x);
		System.out.println("Test腳色");
	}

	// ========================================================

	@Test
	public void updateRegisterInfoDaoTest() {
		int res = registerDao.updateRegisterInfo("Levi", "澳洲", 1000, new Date(), "a09");
		System.out.println(res);
	}

	// ========================================================
	@Test
	public void doQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegtime(date);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
			System.out.println(item.getReg_time());
		}
	}

	// ========================================================
	@Test
	public void doQueryWithPageSizeTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegtime(date, 3);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	// ========================================================
	@Test
	public void doQueryWithStartPositionTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegtime(date, 4, 3);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	// ========================================================
	@Test
	public void doNativeQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doNativeQueryByExpiredRegtime(date, -1, 2);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	// ========================================================
	@Test
	public void doUpdateTest() {
		int result = registerDao.updateAgeByname("kai", 100);
		System.out.println(result);
	}

	// ========================================================
	@Test
	public void updateAgeByAccount() {
		int result = registerDao.updateAgeByAccount("a01", 200);
		System.out.println(result);
	}

	// ========================================================
	@Test
	public void nativeUpdateAgeByName() {
		int result = registerDao.nativeUpdateAgeByName("kai", 300);
		System.out.println(result);
	}

	// ========================================================
	@Test
	public void doNativeUpdateByAccount() {
		int result = registerDao.nativeUpdateAgeByAccount("a01", 400);
		System.out.println(result);
	}

	// ========================================================
	@Test
	public void doQueryRoleContains() {
		List<String> roleList2 = Arrays.asList("SD", "general");
		List<String> roleList = new ArrayList<>();
		roleList.add("SD");
		roleList.add("general");
		List<Register> result = registerDao.doQueryRoleContains(roleList);
		System.out.println(result);
		System.out.println(result.size());
	}

	// ========================================================
	@Test
	public void findAll() {
		List<Register> result = register_Servic.findAll();
		System.out.println("List(size) "+result.size());
		System.out.println(" 記憶體位址 " + result);
	}
}
