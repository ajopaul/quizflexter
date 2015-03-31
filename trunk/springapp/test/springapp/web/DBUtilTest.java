package springapp.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import junit.framework.TestCase;

import org.json.JSONObject;

import com.ajopaul.pojos.ProgramBean;
import com.ajopaul.pojos.ProgramBeanUtils;
import com.ajopaul.web.dao.utils.DBUtil;

public class DBUtilTest extends TestCase{
	
	Connection connection = null;
	String dbQuery = "jdbc:sqlite:adrtest.db";
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
		List<ProgramBean> list = DBUtil.getProgramBeansFromDB(connection, "select * from programs");
		assertNotNull(list);
	}
	
	public void testInsertProgramBeanData(){
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ProgramBean programBean = getSampleProgramBean();
		

		boolean result = DBUtil.insertProgramBeanData(connection, programBean);
		assertTrue(result);
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

  private ProgramBean getSampleProgramBean()
  {
    ProgramBean programBean = ProgramBeanUtils.getProgramBean();
		programBean.setProgramName("sampleprogramName");
		programBean.setShortName("sampleshortName");
		programBean.setUtilityName("sampleutility");
		programBean.setPriority(100);
		programBean.setProgramType("level");
		programBean.setVenPushLevel("full event");
		programBean.setDescription("sampledescName");
		programBean.setTestProgram(true);
		programBean.setCommProgram(true);
		programBean.setEmDispatch(true);
		programBean.setDayAheadDispatch(true);
		programBean.setDefIssueTime("01");
		programBean.setDefStartTime("11");
		programBean.setDefEventDur(200);
		programBean.setDefTolStartTime("11");
		programBean.setDefTolStartAfterTime("32");
		programBean.setMinIssueStart("11");
    return programBean;
  }
	
	public void testCheckIfTablesExist(){
		DBUtil.createTables(connection,"programs");
		assertTrue(DBUtil.checkIfTableExists(connection));
	}
	
	public void testJsonData(){
		ProgramBean bean = ProgramBeanUtils.getProgramBean();
		JSONObject obj = new JSONObject(bean);
		System.out.println("Obj "+obj);
	}
}
