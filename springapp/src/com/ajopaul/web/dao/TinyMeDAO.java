package com.ajopaul.web.dao;

public interface TinyMeDAO {
	
	public boolean addTineyMeURL(String inputUrl,String tinyMeUrl);
	public String getTinyMeURL(String inputUrl);
	public String getInputUrl(String tinyMeUrl);
	public void init();
}
