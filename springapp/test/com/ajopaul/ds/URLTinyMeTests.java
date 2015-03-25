package com.ajopaul.ds;

import junit.framework.TestCase;

public class URLTinyMeTests extends TestCase{
	
	public void testGetTinyMeUrl(){
		System.out.println("\nTest testGetTinyMeUrl");
	URLTinyMe tin = URLTinyMe.getInstance();// new URLTinyMe("https://www.google.com");
	assertNotNull(tin.getTinyMeUrl("https://www.google.com"));
	
	}
	
	public void testGetTinyMeUrlSameInput(){
		System.out.println("\nTest testGetTinyMeUrlSameInput");
		URLTinyMe tin = URLTinyMe.getInstance();//new URLTinyMe("https://www.google.com");
		String urlout = tin.getTinyMeUrl("https://www.google.com");		
		assertEquals(urlout, tin.getTinyMeUrl("https://www.google.com"));
		
		
	}
	
	public void testGetTinyMeNotEquals(){
		System.out.println("\nTest testGetTinyMeNotEquals");
		URLTinyMe tin = URLTinyMe.getInstance();// new URLTinyMe("https://www.google.com");
		String urlout = tin.getTinyMeUrl("https://www.google.com");
		assertNotSame(urlout, tin.getTinyMeUrl("https://www.google.com/about"));
	}
	
	public void testGetOriginalUrl(){
	  
    URLTinyMe tin = URLTinyMe.getInstance();// new URLTinyMe("https://www.google.com");
    String inputUrl = "https://www.google.in";
    String urlout = tin.getTinyMeUrl(inputUrl);
    assertEquals(inputUrl, tin.getOriginalUrl(urlout));
	}
}
