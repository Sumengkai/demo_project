package com.example.demo_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Widget;
import com.example.demo_project.repository.WidgetDao;
import com.example.demo_project.service.ifs.Widget_ifs;
@Service
public class Widget_impl implements Widget_ifs{
	@Autowired
	private WidgetDao widgetDao;

	@Override
	public Widget save() {
		// TODO Auto-generated method stub
		Widget x = new Widget();
		x.setName("³Í");
		
		return widgetDao.save(x);
	}

}
