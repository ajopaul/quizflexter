package com.ajopaul.app.spring.di.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajopaul.app.spring.di.services.MessageService;

@Component
public class MyApplication {
	
	
	   //field-based dependency injection
    //@Autowired
    private MessageService service;
     
//  constructor-based dependency injection  
//  @Autowired
//  public MyApplication(MessageService svc){
//      this.service=svc;
//  }
	@Autowired
	public void setService(MessageService service){
		this.service = service;
	}
	
	public boolean processMessage(String msg,String rec){
		return service.sendMessage(msg, rec);
	}
}
