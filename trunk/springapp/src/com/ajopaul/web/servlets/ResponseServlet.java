package com.ajopaul.web.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajopaul.pojos.ProgramBean;
import com.ajopaul.web.dao.utils.DBUtil;
import com.google.gson.Gson;

public class ResponseServlet extends HttpServlet
{ 
	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	String dbQuery = "jdbc:sqlite:adrdb.db";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                           IOException
    {
      if(null != req.getParameter("listPrograms")){
        doListPrograms(req,resp);
      }else if(null != req.getParameter("addProgram")){
        doAddProgram(req, resp);
      }else if(null != req.getParameter("editProgram")){
        doEditProgram(req,resp);
      }else if(null != req.getParameter("editUpdateProgram")){
        doEditUpdateProgram(req,resp);
      }else if(null != req.getParameter("deleteProgram")){
        doDeleteProgram(req,resp);
      }else{
    	  try{
    	  doAddProgram(req, resp);
    	  }catch(Exception e){
    		  e.printStackTrace();
    	  }
      }
    }
    
    public void doEditProgram(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {

      log.info("Requested for data ");
      Connection connection = DBUtil.getDatabaseConnection(dbQuery);
      if(null != connection){
        Integer programId = Integer.parseInt(req.getParameter("programId"));
        ProgramBean brean = DBUtil.getProgramBeanFromDB(connection, "Select * from programs where ProgramId="+programId.intValue());
        
        Gson gson = new Gson();
        String data = gson.toJson(brean);
        log.info("JSon data\n"+data);
        PrintWriter out = resp.getWriter();
        out.print(data);
      }else{
        log.info("Connection is null");
      }
 
    DBUtil.closeAll(connection,null,null);
      
    }
    /**
     * Perform delete of a program
     * @param req
     * @param resp
     * @throws IOException
     */
    public void doDeleteProgram(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {

      log.info("Requested for data ");
      Connection connection = DBUtil.getDatabaseConnection(dbQuery);
      if(null != connection){
        Integer programId = Integer.parseInt(req.getParameter("programId"));
        boolean result = DBUtil.deleteProgramFromDB(connection, "delete from programs where ProgramId="+programId.intValue());
        
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("result", String.valueOf(result));
        Gson gson = new Gson();
        String jsonData = gson.toJson(resultMap);
        log.info("JSon data\n"+jsonData);
        PrintWriter out = resp.getWriter();
        out.print(jsonData);
      }else{
        log.info("Connection is null");
      }
 
    DBUtil.closeAll(connection,null,null);
      
    }
    
    public void doEditUpdateProgram(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {

      log.info("Requested for data ");
      Connection connection = DBUtil.getDatabaseConnection(dbQuery);
      if(null != connection){
        Integer programId = Integer.parseInt(req.getParameter("programId"));
        ProgramBean brean = DBUtil.getProgramBeanFromDB(connection, "Select * from programs where ProgramId="+programId.intValue());
        
        Gson gson = new Gson();
        String data = gson.toJson(brean);
        log.info("JSon data\n"+data);
        PrintWriter out = resp.getWriter();
        out.print(data);
      }else{
        log.info("Connection is null");
      }
 
    DBUtil.closeAll(connection,null,null);
      
    }

    /**
     * Perform do Listing of the programs
     * @param req
     * @param resp
     * @throws IOException 
     */
    
    protected void doListPrograms(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
     //Create a list of ProgramBeans
    
    	  log.info("Requested for data ");
    	  Connection connection = DBUtil.getDatabaseConnection(dbQuery);
    	  if(null != connection){
/*    		  List<Object> list = DBUtil.getProgramBeansFromDB(connection, "Select * from programs");
    		  //Create a JSONArray
    		  JSONArray arry = new JSONArray(list);

    		  PrintWriter out = resp.getWriter();
    		  out.print(arry.toString());*/
    		  //log.info("JSon data\n"+arry.toString());
    	    List<ProgramBean> list = DBUtil.getProgramBeansFromDB(connection, "Select * from programs");
    	    
    	    Gson gson = new Gson();
    	    String data = gson.toJson(list);
    	    log.info("JSon data\n"+data);
    	    PrintWriter out = resp.getWriter();
          out.print(data);
    	  }else{
    		  log.info("Connection is null");
    	  }
      //Sample JSon output
      /*
       [{"priority":100,"clients":"One Client","programName":"Prog One"},{"priority":200,"clients":"Two Client","programName":"Prog Two"},
       {"priority":300,"clients":"Three Client","programName":"Prog Three"}]

       */
      DBUtil.closeAll(connection,null,null);
    }
    /**
     * Insert the program bean data
     * @param req
     * @param resp
     * @throws IOException
     */
    protected void doAddProgram(HttpServletRequest req, HttpServletResponse resp) throws IOException{
    	StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();
        log.info("Post data "+data);
        Gson gson = new Gson();
        ProgramBean bean = gson.fromJson(data, ProgramBean.class);
        Connection connection = DBUtil.getDatabaseConnection(dbQuery);
        if(null != connection){
        	boolean result = DBUtil.insertProgramBeanData(connection, bean);
        	log.info("DB Write status: "+result);
        	DBUtil.closeAll(connection, null, null);
       }else{
        	log.severe("Connection is null");
        } 
        		
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                         IOException
    {
      doGet(req, resp);
    }
}
