package com.ajopaul.ds;

import junit.framework.TestCase;

public class URLTinyMeTests extends TestCase{
	
	public void testGetTinyMeUrl(){
		System.out.println("\nTest testGetTinyMeUrl");
	URLTinyMe tin = new URLTinyMe("https://www.google.com");
	assertNotNull(tin.getTinyMeUrl());
	
	}
	
	public void testGetTinyMeUrlSameInput(){
		System.out.println("\nTest testGetTinyMeUrlSameInput");
		URLTinyMe tin = new URLTinyMe("https://www.google.com");
		String urlout = tin.getTinyMeUrl();
		tin.setInputUrl("https://www.google.com");
		assertEquals(urlout, tin.getTinyMeUrl());
		
		
	}
	
	public void testGetTinyMeNotEquals(){
		System.out.println("\nTest testGetTinyMeNotEquals");
		URLTinyMe tin = new URLTinyMe("https://www.google.com");
		String urlout = tin.getTinyMeUrl();
		
		tin.setInputUrl("https://www.google.com/about");
		assertNotSame(urlout, tin.getTinyMeUrl());
	}
}
