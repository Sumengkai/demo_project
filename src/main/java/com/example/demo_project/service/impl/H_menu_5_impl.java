package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.H_menu_5;
import com.example.demo_project.entity.H_menu_5_2;
import com.example.demo_project.repository.BankDao_1;
import com.example.demo_project.repository.H_menuDao_5;
import com.example.demo_project.service.ifs.H_menu_5_ifs;
import com.example.demo_project.vo.H_menu_5_Req;
import com.example.demo_project.vo.H_menu_5_Res;

@Service
public class H_menu_5_impl implements H_menu_5_ifs {
	@Autowired
	private H_menuDao_5 menuDao;

	@Override
	public H_menu_5 menu1(String food, int price) {
		// TODO Auto-generated method stub
		H_menu_5 a = new H_menu_5();
		Optional<H_menu_5> b = menuDao.findById(food);
		if (b.isPresent() || !StringUtils.hasText(food)) {
			return null;
		} else {
			a.setFood(food);
			a.setPrice(price);
			menuDao.save(a);
		}
		return a;
	}

	@Override
	public List<H_menu_5> menu2() {
		// TODO Auto-generated method stub
		List<H_menu_5> a = menuDao.findAll();
		return a;
	}

	@Override
	public H_menu_5 menu3(String food) {
		// TODO Auto-generated method stub
		Optional<H_menu_5> b = menuDao.findById(food);
		H_menu_5 a = b.orElse(null);
		return a;
//===第二種,較複雜(用orelse一句話取代)		
////	H_menu_5 aa=new H_menu_5 ();
////		if(b.isPresent()) {
////			aa=b.get();
////			aa.setFood(food);
////		}
//===第二種,較複雜
	}

	

	

	@Override
	
	public List<String> menu6(List<H_menu_5_Req> food) {
		// 先預設總金額
		Integer total = 0;
		// 回傳的字串清單
		List<String> menulist = new ArrayList<>();
		
		// 檢查是否資料庫內有這筆食物
		for (H_menu_5_Req menuforeach : food) {
			// 取得兩個屬性:其中一個去比對資料庫的主key
			Optional<H_menu_5> menuop = menuDao.findById(menuforeach.getFood());
			// ===
			//比較是否為空,不為空繼續找下一筆資料比對
			if(!StringUtils.hasText(menuforeach.getFood())){
				continue;
			}
			//比較是否有此資料,沒有先輸出
			if (!menuop.isPresent()||menuforeach.getNum() <= 0) {
				menuforeach.setNum(0);
				menulist.add(menuforeach.getFood()+" 品項或數量不對固為"+menuforeach.getNum()+" 元");
				continue;
				
			}
			// ===
			// 如果有即取得
			H_menu_5 menu1 = menuop.get();
			// 取得之後，找到這項食物的名稱及價格並且計算份數的金額
			menulist.add(menuforeach.getFood() + "" + menuforeach.getNum() + "份 這項餐點總共" + menu1.getPrice() * menuforeach.getNum() + "元");
			// 完成一個品項的總金額
			total += menu1.getPrice() * menuforeach.getNum();
		}
		// 如果總金額大於500
		if (total >= 500) {
			// 打九折，因為有浮點，所以用double
			double dou =  total * 0.9;
			// 轉型成String
			String result = dou + "";
			// 加入回傳清單內
			menulist.add("滿五百打九折 總共:" + result + "元");
		} else {
			// 加入回傳清單內
			menulist.add("總共:" + total + "元");
		}
		// 回傳清單
		return menulist;
	}

	@Override
	// 取的req的key跟value
	public List<String> menu7(Map<String, Integer> map) {

		int total = 0; // 取得總價額
		List<String> menulist = new ArrayList<>();
		// 檢查是否資料庫內有這筆食物
		for (var menu : map.entrySet()) {
			Optional<H_menu_5> menuop = menuDao.findById(menu.getKey());
//			if(menu.getValue() <= 0) {
//				menu.setValue(0);
//				
//				continue;
//			}
			if (menu.getValue() <= 0 || !menuop.isPresent() || !StringUtils.hasText(menu.getKey())) {
				// ===這裡註解部分,加進去會顯示防呆內容,但我選擇直接消失
//					x.setName("空");
//					x.setNum(0);
//					menulist.add(x.getName()+" "+x.getNum());
				// ===這裡註解部分,加進去會顯示防呆內容,但我選擇直接消失,直接continue;
					continue;
				}
			// 取得資料庫的東西丟進來
			H_menu_5 menuentity = menuop.get();
			menulist.add(menu.getKey() + " 有" + menu.getValue() + " 份" + " 共 " + (menuentity.getPrice() * menu.getValue()));
//			total=total+(menuentity.getPrice()*menu.getValue());
			total += (menuentity.getPrice() * menu.getValue());
		}
		if (total > 500) {
			double discount = total * 0.9;
			String result = discount + "";
			menulist.add("滿五百打九折 總共:" + result + "元");
		} else {
			// 加入回傳清單內
			menulist.add("總共:" + total + "元");
		}
		return menulist;
	}

}
