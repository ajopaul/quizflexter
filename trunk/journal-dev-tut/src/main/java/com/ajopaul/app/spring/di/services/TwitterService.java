package com.ajopaul.app.spring.di.services;

public class TwitterService implements MessageService {

	public boolean sendMessage(String msg, String rec) {
		System.out.println("twitter message sent to "+rec+" with message "+msg);
		return true;
	}

}
