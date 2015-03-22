package com.ajopaul.web.dao;

import java.sql.Connection;
import java.sql.Statement;

import junit.framework.TestCase;

import com.ajopaul.ds.URLTinyMe;
import com.ajopaul.web.dao.utils.DBUtil;

public class TinyMeDAOJdbcTests extends TestCase {
	
	Connection connection = null;
	String dbQuery = "jdbc:sqlite:tinyurl.db";
	TinyMeDAOJdbc dao;
	URLTinyMe tinyMeURL;
	
	@Override
	protected void setUp() throws Exception {
		dao = new TinyMeDAOJdbc(dbQuery);
		connection = dao.getDatabaseConnection();
		dao.createTables(connection, "tinymeurl");
		tinyMeURL = new URLTinyMe();
		super.setUp();
	}
	@Override
	protected void tearDown() throws Exception {
		Statement st = connection.createStatement();
		st.executeUpdate("drop table tinymeurl");
		DBUtil.closeAll(connection, null, st);
		tinyMeURL = null;
		
	}
	
	public void testGetTinyUr()	{
		String inputUrl = "https://www.google.com";
		tinyMeURL.setInputUrl(inputUrl);
		String tinyMeUrl = tinyMeURL.getTinyMeUrl();
		dao.addTineyMeURL(inputUrl, tinyMeUrl);

		String tinyMeUrlDao = dao.getTinyMeURL(inputUrl);
		assertEquals(tinyMeUrl, tinyMeUrlDao);
	}
	
	public void testExistingTinyMeUrl(){
		String inputUrl = "https://www.yahoo.com";
		/*tinyMeURL.setInputUrl(inputUrl);
		String tinyMeUrl = tinyMeURL.getTinyMeUrl();*/
		String tinyMeUrl = "i";
		dao.addTineyMeURL(inputUrl, tinyMeUrl);
		inputUrl = "https://www.yahoo.com/about";
		boolean resultFlag = dao.addTineyMeURL(inputUrl, tinyMeUrl);
		//String tinyMeUrlDao = dao.getTinyMeURL(inputUrl);
		assertFalse(resultFlag);
	}
}
