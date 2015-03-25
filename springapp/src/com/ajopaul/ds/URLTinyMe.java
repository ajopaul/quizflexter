package com.ajopaul.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class URLTinyMe {

  //Map stores 1:1 mapping of input url and tinyurl
	private Map<String,String> urlMap = new HashMap<String,String>();
  private static URLTinyMe urlTinyMeObj = null;
	
	/**
	 * return static instance of URLTinyMe
	 * @return
	 */
	public static URLTinyMe getInstance(){
	  if(null == urlTinyMeObj){
	    synchronized (URLTinyMe.class){
	      if(null == urlTinyMeObj){
	        urlTinyMeObj =  new URLTinyMe();

	      }        
      }
	  }
	  return urlTinyMeObj;
	}
	
	/*
	 * Private constructor, restrict instance creation
	 */
	private URLTinyMe() {
		
	}

	/**
	 * TinyMefy a URL 
	 * @return String
	 */
	public String getTinyMeUrl(String inputUrl){

		String tinyUrl = inputUrl;

		if(urlMap.containsKey(inputUrl)){//Check if url already exists
			tinyUrl =  urlMap.get(inputUrl);		
		}else{
			StringBuilder charList = new StringBuilder();
			do{
				int random = getRandonNumber(48,122);//Accept only characters and numericals A-Z,0-9,a-z
				charList.append((char)random);	
			}while(urlMap.containsValue(charList.toString()));
		
			urlMap.put(inputUrl, charList.toString());
			tinyUrl =  charList.toString();
		}
		return tinyUrl;
	}
	
	/**
	 * From the tinyUrl return the original input url
	 * @param tinyUrl
	 * @return
	 */
	public String getOriginalUrl(String tinyUrl){
	  String inputUrl = null;
	  if(urlMap.containsValue(tinyUrl)){	    
	   for(Entry<String,String> entry:urlMap.entrySet()){
	     if(entry.getValue().equals(tinyUrl)){
	       inputUrl = entry.getKey();
	     }
	   }
	  }
	  return inputUrl;
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

}
