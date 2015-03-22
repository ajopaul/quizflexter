package com.ajopaul.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class URLTinyMe {
	private String inputUrl;

	private Set<String> uniqueUrlSet = new HashSet<String>();
	private Map<String,String> urlMap = new HashMap<String,String>();

	public URLTinyMe(){
		super();
	}
	public URLTinyMe(String url) {
		this.inputUrl = url;
	}

	/**
	 * TinyMefy a URL 
	 * @return String
	 */
	public String getTinyMeUrl(){
		String tinyUrl = inputUrl;
		System.out.println("Processing inputurl "+tinyUrl);
		if(urlMap.containsKey(inputUrl)){
			tinyUrl =  urlMap.get(inputUrl);
			System.out.println("Existing TinyURL "+tinyUrl);
		}else{
			StringBuilder charList = new StringBuilder();
			do{
				int random = getRandonNumber(48,122);//Accept only characters and numericals A-Z,0-9,a-z
				charList.append((char)random);	
			}while(uniqueUrlSet.contains(charList.toString()));
			uniqueUrlSet.add(charList.toString());
			urlMap.put(inputUrl, charList.toString());

			System.out.println("TinyURL "+charList.toString());
			tinyUrl =  charList.toString();
		}
		return tinyUrl;
	}
	/*
	 * Return random number for the limit
	 * */
	private int getRandonNumber(int lowLimit, int highLimit){
		int random = 0;
		Random randomObj = new Random();
		do{
			random = randomObj.nextInt(highLimit);
			
		}while(!(random >= lowLimit && random <= highLimit) ||
				(random > 57 && random < 65) || 
				(random > 90 && random <97));
		
		return random;
	}
	public String getInputUrl() {
		return inputUrl;
	}

	public void setInputUrl(String inputUrl) {
		this.inputUrl = inputUrl;
	}
}
