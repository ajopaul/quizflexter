package com.ajopaul.web.dao;

public class TinyMeDAOFactory {
 private static TinyMeDAO dao;
 private static	String dbQuery = "jdbc:sqlite:/dbfiles/tinyme.db";
 public static TinyMeDAO getTinyMeDAO(){
	 if(null == dao){
		dao = new TinyMeDAOJdbc(dbQuery);
	 }
	 return dao;
 }
}
