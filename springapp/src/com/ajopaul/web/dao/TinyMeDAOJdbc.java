package com.ajopaul.web.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ajopaul.web.dao.utils.DBUtil;

public class TinyMeDAOJdbc implements TinyMeDAO{

	Connection connection;
	String dbQuery = "jdbc:sqlite:tinyme.db";
	
	public TinyMeDAOJdbc(String dbQuery){
	   this.dbQuery = dbQuery;
	}
	
	public TinyMeDAOJdbc() {
		// TODO Auto-generated constructor stub
	}

	public void init(){
		connection = getDatabaseConnection();
		   createTables(connection, "tinymeurl");
		   DBUtil.closeAll(connection, null,null);
	}
	
	public Connection getDatabaseConnection(){
		 try {
		      Class.forName("org.sqlite.JDBC");
		       connection = DriverManager.getConnection(dbQuery);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      e.printStackTrace();
		    }
		 return connection;
	}
	
	@Override
	public boolean addTineyMeURL(String inputUrl, String tinyMeUrl) {
		
		//check if it exists in db
		String tinyUrl = getTinyMeURL(inputUrl);
		if(null != tinyUrl){
			System.out.println("uRL EXISTS");
			return true;//already exists in database;
		}
		
		try {
			inputUrl = URLEncoder.encode(inputUrl, "UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		connection = getDatabaseConnection();
		String sql = "INSERT INTO tinymeurl VALUES(?, ?)";
		int result = 0;
		
		try {
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, inputUrl);
			pStmt.setString(2, tinyMeUrl);
			result = pStmt.executeUpdate();
			//log.info("finished inserting data");
			System.out.println("Finished inserting yo!");
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return result > 0;		
	}

	@Override
	public String getTinyMeURL(String inputUrl) {
		connection = getDatabaseConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String tinyUrl = null;
		try {
			inputUrl = URLEncoder.encode(inputUrl,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String query = "select tinyme_url from tinymeurl where input_url = '"+inputUrl+"'";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				tinyUrl = rs.getString("tinyme_url");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(connection,rs,stmt);
		}
		return tinyUrl;
	}
/**
 * Create table 
 * @param connection
 * @param tableName
 */
	public  void createTables(Connection connection,String tableName) {
		String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
				+ "  (input_url          TEXT NOT NULL UNIQUE,"
				+ "   tinyme_url         TEXT NOT NULL UNIQUE)";
		

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.execute(sqlCreate);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, null, stmt);
		}

	}

@Override
public String getInputUrl(String tinyMeUrl) {
	connection = getDatabaseConnection();
	Statement stmt = null;
	ResultSet rs = null;
	String inputUrl = null;
	try {
		String query = "select input_url from tinymeurl where tinyme_url = '"+tinyMeUrl+"'";
		stmt = connection.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()){
			inputUrl = rs.getString("tinyme_url");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBUtil.closeAll(connection,rs,stmt);
	}
	return inputUrl;	
}
}
