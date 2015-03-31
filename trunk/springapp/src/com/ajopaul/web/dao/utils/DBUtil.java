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
			createTables(connection,"programs");
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
	public static void createTables(Connection connection,String tableName) {
	
		    
		   StringBuilder sqlCreate = new StringBuilder().append("CREATE TABLE IF NOT EXISTS ").append(tableName
		                                                        ).append("(ProgramId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " ).append(
		                                                        "ProgramName TEXT, " ).append(
		                                                        "ShortName TEXT, " ).append(
		                                                        "UtilityName TEXT, " ).append(
		                                                        "Priority  INTEGER, " ).append(
		                                                        "ProgramType TEXT, " ).append(
		                                                        "VenPushLevel  TEXT, ").append(
		                                                        "Description TEXT, " ).append(
		                                                        "TestProgram INTEGER DEFAULT 0, " ).append(
		                                                        "CommercialProgram INTEGER DEFAULT 0, " ).append(
		                                                        "EmergencyDispatch  INTEGER DEFAULT 0, " ).append(
		                                                        "DayAheadDispatch  INTEGER DEFAULT 0, " ).append(
		                                                        "DefIssueTime  TEXT, " ).append(
		                                                        "DefStartTime  TEXT, " ).append(
		                                                        "DefEventDur INTEGER," ).append(
		                                                        "DefToleranceStartTime TEXT, " ).append(
		                                                        "DefToleranceStartAfterTime  TEXT, " ).append(
		                                                        "MinIssueStart TEXT)" );                                                       
		                                                        
		                                                       
		                                                        
		    
		    Statement stmt;
			try {
				stmt = connection.createStatement();
				stmt.execute(sqlCreate.toString());
			} catch (SQLException e) {

				e.printStackTrace();
			}
		    
	}

/**
 * Check if the programs table exists
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
	public static List<ProgramBean> getProgramBeansFromDB(Connection connection,String query){
		List<ProgramBean> list = new ArrayList<>();
		ResultSet rs = (ResultSet) getResultSetData(connection, query);
		if(null != rs){
			try {
			while(rs.next()){
					ProgramBean pBean = ProgramBeanUtils.getProgramBean();
					pBean.setProgramId(rs.getInt("ProgramId"));
					pBean.setShortName(rs.getString("ShortName"));
					pBean.setDescription(rs.getString("Description"));
					pBean.setProgramType(rs.getString("ProgramType"));					
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
   * Return list of program beans from DB
   * @param connection
   * @param query
   * @return
   */
  public static ProgramBean getProgramBeanFromDB(Connection connection,String query){
    ProgramBean pBean = ProgramBeanUtils.getProgramBean();
    ResultSet rs = (ResultSet) getResultSetData(connection, query);
    if(null != rs){
      try {
      if(rs.next()){
        
          pBean.setProgramId(rs.getInt("ProgramId"));
          pBean.setProgramName(rs.getString("ProgramName"));
          pBean.setShortName(rs.getString("ShortName"));
          pBean.setDescription(rs.getString("Description"));
          pBean.setProgramType(rs.getString("ProgramType"));          
      }
              
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return pBean;
  }
  
  /**
   * Delete a program
   * @param connection
   * @param query
   * @return
   */
  public static boolean deleteProgramFromDB(Connection connection,String query){
    boolean isDeleteSuccess = false;
    
    try{
        Statement stmt = connection.createStatement();
        int returnRes = stmt.executeUpdate(query);
        isDeleteSuccess = (returnRes > 0)?true:false;
      } catch (SQLException e) {
        e.printStackTrace();
      }
    
    return isDeleteSuccess;
  }
  
	/**
	 * insret a program bean to db.
	 * @param connection
	 * @param bean
	 * @return
	 */
	public static boolean insertProgramBeanData(Connection connection,ProgramBean bean){
		String sql = "INSERT INTO programs VALUES(?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?)";
		int result = 0;
		try {
			PreparedStatement pStmt = connection.prepareStatement(sql);
		  pStmt.setString(2, bean.getProgramName());
      pStmt.setString(3, bean.getShortName());
      pStmt.setString(4, bean.getUtilityName());
      pStmt.setInt(5, bean.getPriority());
      pStmt.setString(6, bean.getProgramType());
      pStmt.setString(7, bean.getVenPushLevel());
      pStmt.setString(8, bean.getDescription());
      pStmt.setInt(9, bean.getTestProgram()?1:0);
      pStmt.setInt(10, bean.getCommProgram()?1:0);
      pStmt.setInt(11, bean.getEmDispatch()?1:0);
      pStmt.setInt(12, bean.getDayAheadDispatch()?1:0);
			pStmt.setString(13, bean.getDefIssueTime());
			pStmt.setString(14, bean.getDefStartTime());
			pStmt.setInt(15, bean.getDefEventDur());
			pStmt.setString(16, bean.getDefTolStartTime());
      pStmt.setString(17, bean.getDefTolStartAfterTime());
      pStmt.setString(18, bean.getMinIssueStart());
    
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
