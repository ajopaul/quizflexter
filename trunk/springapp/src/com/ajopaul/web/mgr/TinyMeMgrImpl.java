package com.ajopaul.web.mgr;

import com.ajopaul.ds.URLTinyMe;
import com.ajopaul.web.dao.TinyMeDAO;
import com.ajopaul.web.dao.TinyMeDAOFactory;


public class TinyMeMgrImpl implements TinyMeMgr{
	
	URLTinyMe tinyMeUrlObj = null;
	TinyMeDAO dao = null;
	private static int RETRY_MAX_COUNTER = 1000;
	
	public TinyMeMgrImpl(){
		dao = TinyMeDAOFactory.getTinyMeDAO();
		dao.init();
		tinyMeUrlObj = new URLTinyMe();
	}
	@Override
	public void addTineyMeURL(String inputUrl, String tinyMeUrl) {
		dao.addTineyMeURL(inputUrl, tinyMeUrl);
	}

	@Override
	public String getTinyMeURL(String inputUrl) {
		String tinyUrl = inputUrl;
		int retryCount = 0;
		tinyUrl = dao.getTinyMeURL(inputUrl);
		if(null == tinyUrl){
			tinyMeUrlObj.setInputUrl(inputUrl);
			
			boolean resultFlag = false;
			
			do{
			tinyUrl = tinyMeUrlObj.getTinyMeUrl();
			resultFlag = dao.addTineyMeURL(inputUrl, tinyUrl);
			retryCount++;
			}while(!resultFlag && retryCount < RETRY_MAX_COUNTER);
		}
		if(retryCount >= RETRY_MAX_COUNTER){
			tinyUrl = inputUrl;
		}
		return tinyUrl;
	}



}
