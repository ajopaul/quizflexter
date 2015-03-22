package com.ajopaul.web.mgr;

public class TinyMgrFactory {
	private static TinyMeMgr tinyMeMgr;
	
	public static TinyMeMgr getTinyMeMgr(){
		if(null == tinyMeMgr){
			tinyMeMgr = new TinyMeMgrImpl();
		}
		return tinyMeMgr;
	}
}
