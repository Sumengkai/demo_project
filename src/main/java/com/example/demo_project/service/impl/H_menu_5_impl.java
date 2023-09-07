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
//===�ĤG��,������(��orelse�@�y�ܨ��N)		
////	H_menu_5 aa=new H_menu_5 ();
////		if(b.isPresent()) {
////			aa=b.get();
////			aa.setFood(food);
////		}
//===�ĤG��,������
	}

	

	

	@Override
	
	public List<String> menu6(List<H_menu_5_Req> food) {
		// ���w�]�`���B
		Integer total = 0;
		// �^�Ǫ��r��M��
		List<String> menulist = new ArrayList<>();
		
		// �ˬd�O�_��Ʈw�����o������
		for (H_menu_5_Req menuforeach : food) {
			// ���o����ݩ�:�䤤�@�ӥh����Ʈw���Dkey
			Optional<H_menu_5> menuop = menuDao.findById(menuforeach.getFood());
			// ===
			//����O�_����,�������~���U�@����Ƥ��
			if(!StringUtils.hasText(menuforeach.getFood())){
				continue;
			}
			//����O�_�������,�S������X
			if (!menuop.isPresent()||menuforeach.getNum() <= 0) {
				menuforeach.setNum(0);
				menulist.add(menuforeach.getFood()+" �~���μƶq����T��"+menuforeach.getNum()+" ��");
				continue;
				
			}
			// ===
			// �p�G���Y���o
			H_menu_5 menu1 = menuop.get();
			// ���o����A���o���������W�٤λ���åB�p����ƪ����B
			menulist.add(menuforeach.getFood() + "" + menuforeach.getNum() + "�� �o���\�I�`�@" + menu1.getPrice() * menuforeach.getNum() + "��");
			// �����@�ӫ~�����`���B
			total += menu1.getPrice() * menuforeach.getNum();
		}
		// �p�G�`���B�j��500
		if (total >= 500) {
			// ���E��A�]�����B�I�A�ҥH��double
			double dou =  total * 0.9;
			// �૬��String
			String result = dou + "";
			// �[�J�^�ǲM�椺
			menulist.add("�����ʥ��E�� �`�@:" + result + "��");
		} else {
			// �[�J�^�ǲM�椺
			menulist.add("�`�@:" + total + "��");
		}
		// �^�ǲM��
		return menulist;
	}

	@Override
	// ����req��key��value
	public List<String> menu7(Map<String, Integer> map) {

		int total = 0; // ���o�`���B
		List<String> menulist = new ArrayList<>();
		// �ˬd�O�_��Ʈw�����o������
		for (var menu : map.entrySet()) {
			Optional<H_menu_5> menuop = menuDao.findById(menu.getKey());
//			if(menu.getValue() <= 0) {
//				menu.setValue(0);
//				
//				continue;
//			}
			if (menu.getValue() <= 0 || !menuop.isPresent() || !StringUtils.hasText(menu.getKey())) {
				// ===�o�̵��ѳ���,�[�i�h�|��ܨ��b���e,���ڿ�ܪ�������
//					x.setName("��");
//					x.setNum(0);
//					menulist.add(x.getName()+" "+x.getNum());
				// ===�o�̵��ѳ���,�[�i�h�|��ܨ��b���e,���ڿ�ܪ�������,����continue;
					continue;
				}
			// ���o��Ʈw���F���i��
			H_menu_5 menuentity = menuop.get();
			menulist.add(menu.getKey() + " ��" + menu.getValue() + " ��" + " �@ " + (menuentity.getPrice() * menu.getValue()));
//			total=total+(menuentity.getPrice()*menu.getValue());
			total += (menuentity.getPrice() * menu.getValue());
		}
		if (total > 500) {
			double discount = total * 0.9;
			String result = discount + "";
			menulist.add("�����ʥ��E�� �`�@:" + result + "��");
		} else {
			// �[�J�^�ǲM�椺
			menulist.add("�`�@:" + total + "��");
		}
		return menulist;
	}

}
