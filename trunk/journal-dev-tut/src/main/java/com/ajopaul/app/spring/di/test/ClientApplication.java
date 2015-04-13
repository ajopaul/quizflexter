package com.ajopaul.app.spring.di.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ajopaul.app.spring.di.consumer.MyXMLApplication;

public class ClientApplication {
	public static void main(String... args){
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfigurator.class);
		MyApplication myapp = context.getBean(MyApplication.class);
		myapp.processMessage("Hi","a@abc");
		context.close();*/
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	                "applicationContext.xml");
		MyXMLApplication myapp = context.getBean(MyXMLApplication.class);
		myapp.processMessage("Hello","aaa@abc");
		context.close();
	}
	
}
