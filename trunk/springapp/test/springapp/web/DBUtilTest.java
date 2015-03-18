package springapp.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import junit.framework.TestCase;

import com.ajopaul.pojos.ProgramBean;
import com.ajopaul.pojos.ProgramBeanUtils;
import com.ajopaul.web.dao.utils.DBUtil;

public class DBUtilTest extends TestCase{
	
	Connection connection = null;
	String dbQuery = "jdbc:sqlite:/home/ajopaul/dbfiles/springdb2.db";
	@Override
	protected void setUp() throws Exception {
		connection = DBUtil.getDatabaseConnection(dbQuery);
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		if(null != connection ){
			connection.close();
		}
		super.tearDown();
	}
	
	public void testGetDatabaseConnection(){
		connection = DBUtil.getDatabaseConnection(dbQuery);
		assertNotNull("Message Not null", connection);
	}
	
	public void testSpringDbProgramsTableData(){
		Connection connection = DBUtil.getDatabaseConnection(dbQuery);
		try {
			Statement stmnt = connection.createStatement();
			ResultSet rs = stmnt.executeQuery("select * from programs");
			assertNotNull("Resultset is null ",rs);
			while(rs.next()){
				String programName = rs.getString("program_name");
				int priority = rs.getInt("priority");
				String clients = rs.getString("clients");
				assertNotNull("program name is null",programName);
				assertNotNull("priority name is null",priority);
				assertNotNull("clients name is null",clients);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testGetDBDataNull(){
		Object obj = DBUtil.getResultSetData(connection, "select * from programs");
		
		assertTrue(obj instanceof ResultSet);
	}
	
	public void testProgramBeansListSize(){
		List<Object> list = DBUtil.getProgramBeansFromDB(connection, "select * from programs");
		assertNotNull(list);
	}
	
	public void testInsertProgramBeanData(){
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean result = DBUtil.insertProgramBeanData(connection, ProgramBeanUtils.getProgramBean("test", 1, "test"));
		assertTrue(result);
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testJsonData(){
		ProgramBean bean = ProgramBeanUtils.getProgramBean("Prog", 1, "clients all");
		JSONObject obj = new JSONObject(bean);
		System.out.println("Obj "+obj);
	}
}
