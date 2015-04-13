package com.ajopaul.app;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ajopaul.app.spring.di.services.MessageService;
import com.ajopaul.app.spring.di.services.TwitterService;


@Configuration
@ComponentScan(value={"com.ajopaul.app.spring.di.consumer"})
public class DIConfigurator {
	
	@Bean
	public MessageService getMessageService(){
		return new TwitterService();
	}
}
