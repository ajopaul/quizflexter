package com.ajopaul.web.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.ajopaul.pojos.ProgramBean;
import com.ajopaul.web.dao.utils.DBUtil;
import com.google.gson.Gson;

public class ResponseServlet extends HttpServlet
{ 
	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	String dbQuery = "jdbc:sqlite:/dbfiles/springdb.db";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                           IOException
    {
      if(null != req.getParameter("listPrograms")){
        doListPrograms(req,resp);
      }else if(null != req.getParameter("addProgram")){
    	doAddProgram(req, resp);
      }else{
    	  try{
    	  doAddProgram(req, resp);
    	  }catch(Exception e){
    		  e.printStackTrace();
    	  }
      }
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
     /* List<Object> list = new ArrayList<Object>();
      list.add(ProgramBeanUtils.getProgramBean("Prog One",100 , "One Client"));
      list.add(ProgramBeanUtils.getProgramBean("Prog Two",200 , "Two Client"));
      list.add(ProgramBeanUtils.getProgramBean("Prog Three",300 , "Three Client"));*/
    	  log.info("Requested for data ");
    	  Connection connection = DBUtil.getDatabaseConnection(dbQuery);
    	  if(null != connection){
    		  List<Object> list = DBUtil.getProgramBeansFromDB(connection, "Select * from programs");
    		  //Create a JSONArray
    		  JSONArray arry = new JSONArray(list);

    		  PrintWriter out = resp.getWriter();
    		  out.print(arry.toString());
    		  log.info("JSon data\n"+arry.toString());
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
