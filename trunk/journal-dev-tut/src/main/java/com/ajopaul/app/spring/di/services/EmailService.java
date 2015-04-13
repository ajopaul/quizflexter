package com.ajopaul.app.spring.di.services;

public class EmailService implements MessageService {

	public boolean sendMessage(String msg, String rec) {
		System.out.println("email sent to "+rec+" with message "+msg);
		return true;
	}

}
