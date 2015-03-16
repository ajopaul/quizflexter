package com.ajopaul.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ajopaul.pojos.ProgramBeanUtils;

public class ResponseServlet extends HttpServlet
{ 
	Logger log = Logger.getLogger(getClass().getSimpleName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                           IOException
    {
      if(null != req.getParameter("listPrograms")){
        doListPrograms(req,resp);
      }else{

        //Currently do nothing, nada
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
      List<Object> list = new ArrayList<Object>();
      list.add(ProgramBeanUtils.getProgramBean("Prog One",100 , "One Client"));
      list.add(ProgramBeanUtils.getProgramBean("Prog Two",200 , "Two Client"));
      list.add(ProgramBeanUtils.getProgramBean("Prog Three",300 , "Three Client"));
      //Create a JSONArray
      JSONArray arry = new JSONArray(list);
      PrintWriter out = resp.getWriter();
      out.print(arry.toString());
      log.info("JSon data\n"+arry.toString());
      //Sample JSon output
      /*
       [{"priority":100,"clients":"One Client","programName":"Prog One"},{"priority":200,"clients":"Two Client","programName":"Prog Two"},
       {"priority":300,"clients":"Three Client","programName":"Prog Three"}]

       */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                         IOException
    {
      doGet(req, resp);
    }
}
