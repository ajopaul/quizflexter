package com.ajopaul.web.dao.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ajopaul.pojos.ProgramBean;
import com.ajopaul.pojos.ProgramBeanUtils;

public class DBUtil {
	private static Logger log = Logger.getLogger("DBUtil");
	/**
	 * Get the connection using sqlite jdbc driver
	 * @return
	 *///dbQuery = "jdbc:sqlite:springdb.db";
	public static Connection getDatabaseConnection(String dbQuery) {
		
		Connection connection = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:springdb.db");
	      ///home/bigdata/workspace/
	       connection = DriverManager.getConnection(dbQuery);
	    //  connection = DriverManager.getConnection("jdbc:sqlite:sqlitedb/springdb.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      e.printStackTrace();
	    }
	  
		return connection;
	}
	
	public static Object getResultSetData(Connection connection,String query){
		Statement stmnt = null;
		ResultSet rs = null;
		boolean result = checkIfTableExists(connection);
		if(!result){
			createTables(connection);
		}
		try {
			stmnt = connection.createStatement();
			rs = stmnt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/**
	 * Create tables.
	 */
	public static void createTables(Connection connection) {
		    String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "programs"
		            + "  (program_name          TEXT,"
		            + "   priority            NUMERIC,"
		            + "   clients          TEXT)";

		    Statement stmt;
			try {
				stmt = connection.createStatement();
				stmt.execute(sqlCreate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}

/**
 * Check if the programs table exists`
 * @param connection
 */
	public static boolean checkIfTableExists(Connection connection) {
		boolean result = false;
		try{
		DatabaseMetaData dbm = connection.getMetaData();
		
	    ResultSet rs = dbm.getTables(null, null, "programs", null);
	      result = rs.next();
		}catch(Exception e){
			log.severe("Cannot check if table exists");
			e.printStackTrace();
		}
	    return result;		
	}

	/**
	 * Return list of program beans from DB
	 * @param connection
	 * @param query
	 * @return
	 */
	public static List<Object> getProgramBeansFromDB(Connection connection,String query){
		List<Object> list = new ArrayList<Object>();
		ResultSet rs = (ResultSet) getResultSetData(connection, query);
		if(null != rs){
			try {
			while(rs.next()){
				

					String programName = rs.getString("program_name");
					int priority = rs.getInt("priority");
					String clients = rs.getString("clients");
					ProgramBean pBean = ProgramBeanUtils.getProgramBean(programName, priority, clients);
					list.add(pBean);
			}
							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * insret a program bean to db.
	 * @param connection
	 * @param bean
	 * @return
	 */
	public static boolean insertProgramBeanData(Connection connection,ProgramBean bean){
		String sql = "INSERT INTO programs VALUES(?, ?, ?)";
		int result = 0;
		try {
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, bean.getProgramName());
			pStmt.setInt(2, bean.getPriority());
			pStmt.setString(3, bean.getClients());
			result = pStmt.executeUpdate();
			log.info("finished inserting data");
			System.out.println("Finished inserting yo!");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result > 0;
	}
	/**
	 * Close all the connections
	 * @param connection
	 * @param rs
	 * @param stmt
	 */
	public static void closeAll(Connection connection,ResultSet rs,Statement stmt){
		try{
			if(null != connection){
				connection.close();
			}
			if(null != rs){
				rs.close();
			}

			if(null != stmt){
				stmt.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
