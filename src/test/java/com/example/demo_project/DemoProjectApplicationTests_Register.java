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

	@BeforeEach // �C�@�Ӵ��դ��e���O�إߤ@�������
	public void beforeach() {
		System.out.println("bbbbbb");
	}

	// --------------------------------------
	@Autowired
	private WebApplicationContext wac;// ���WebApplicationContext�إߪ�����,�Ψӽs�gweb����X����
	private MockMvc mockMvc; // ��{��http�ШD�������ΨӴ���controller

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	// -------------------�ۤv�gpostman �s�W�b��
	@SuppressWarnings("unchecked")
	@Test
	public void RegisterControllerTest() throws Exception {
		HttpHeaders headers = new HttpHeaders();// �L�� �n�Φb�o��.headers(headers) //�p�GHeaders�n�[���ѼƦ��h��,�i�Φ��覡;
		headers.setContentType(MediaType.APPLICATION_JSON); // �L��
		// srt request_body
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("account", "a98");
		map.put("pwd", "a12345");
		map.put("name", "David");
		map.put("age", 22);
		map.put("city", "Taiwan");
		// map to string (��������postman���ʧ@)
		ObjectMapper objectmap = new ObjectMapper(); // ���F�ŦXpostman���榡
		String mapstring = objectmap.writeValueAsString(map);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register1")
//				.headers(headers) //�p�GHeaders�n�[���ѼƦ��h��,�i�Φ��覡;
				.contentType(CONTENT_TYPE) // Headers �n�[�����ѼƴN�u��contentType��,�i�����ϥ�,����Headers�[�J
				.content(mapstring));
		// get res
		String resString = result.andReturn().getResponse().getContentAsString();
		// �o�쪺res�নjson(map)
		JacksonJsonParser json = new JacksonJsonParser();
		Map<String, Object> resdata = json.parseMap(resString);
		System.out.println(resdata);
//		MockHttpServletResponse http = result.andReturn().getResponse();
//		String httpstring =http.getContentAsString(); 

//		String rtnmessage1 = (String) resdata.get("register_info");
//		System.out.println("�j��r�ꫬ�A : " + rtnmessage1);
		Object rtnmessage2 = resdata.get("register_info");
		System.out.println("���󫬺A : " + rtnmessage2);
//		Register rtnmessage3 = (Register) resdata.get("register_info");
//		System.out.println("Register�����󫬺A : " + rtnmessage3);
		Map<String, Object> rtninfo = (Map<String, Object>) resdata.get("register_info");
//		Assert.isTrue(rtnmessage3.getAccount().equals("a88"),"���");
		Assert.isTrue(((String) rtninfo.get("�૬���:")).equals("a98"), "�T�T");
		System.out.println("rtninfo--" + rtninfo);
		System.out.println("resdata--" + resdata);

	}

	// -----------�ۤv�gpostman �s�W�}��----------------
	@Test
	public void RegisterControllerByaddroleTest() throws Exception {

	}
	// ====================

	@Test // ���U
	public void register1() {
		Register reg = register_Servic.register("kai", "1", "taiwan", "123", 23);
//		Optional<Register>  result =registerDao.findById("a01");
//		if(result.isPresent()) {}
//		if(registerDao.existsById("a01")) {}
		Assert.notNull(reg, "�T�T"); // -->�P�_�O�_����,���O���ܦ^�ǫe�����ݩ�,�O���ܦ^�ǫ᭱���T�T
		Assert.isTrue(reg.getAccount().equals("1"), "�T�T�T"); // -->�P�_�O�_��true,�O���ܦ^�ǫe�����ݩ�,���O���ܦ^�ǫ᭱���T�T,�B���

		// registerDao.delete(reg); //�R��
//		Optional<Register> regop = registerDao.findById("a99");
//		Assert.isTrue(!regop.isPresent(), "ss"); //�Ĥ@��
		Assert.isTrue(registerDao.existsById("1"), "ss"); // �ĤG��
		System.out.println("����1");
	}
	// ====================================================================================

	@Test // �E��
	public void register2() {
		// pkid
		Register reg = register_Servic.register("kai", "a99", "taiwan", "123", 23);
		// �s�ت��b��,���L�Ȭ�false
		// istrue(��줺�O�@��Ʊ� , ��ڤW���Ȥ���)
		Assert.isTrue(!reg.isActuve(), "�P�_�O�_��true,��줺������O false,�[��ĸ��|�ܦ�true");// -->�P�_�O�_��true,��줺������O false ,
																				// �[��ĸ��|�ܦ�true
		register_Servic.active("a99");
		Register newreg = registerDao.findById("a99").get();
		Assert.isTrue(newreg.isActuve(), "��");
		registerDao.delete(newreg);
		System.out.println("Test�E��");
	}
	// ======================================================================================

	@Test // ����
	public void addrole() {
		List<String> x = new ArrayList();
		x.add("SA");
		x.add("SA");
		x.add("SD");
		x.add("SD");
		register_Servic.addrole("a02", x);
		System.out.println("Test�}��");
	}

	// ========================================================

	@Test
	public void updateRegisterInfoDaoTest() {
		int res = registerDao.updateRegisterInfo("Levi", "�D�w", 1000, new Date(), "a09");
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
		System.out.println(" �O�����} " + result);
	}
}
