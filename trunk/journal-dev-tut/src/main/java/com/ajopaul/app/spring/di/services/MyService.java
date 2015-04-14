package com.ajopaul.app.spring.di.services;

import com.ajopaul.app.bean.MyBean;

public class MyService {
	public String getData(String input){
		return "Hi" +input;
	}
	
	public MyBean getObjectData(MyBean bean){
		String name= bean.getName();
		int id = bean.getId();
		bean.setId(id+100);
		bean.setName("Output "+name);
		return bean;
	}
}
