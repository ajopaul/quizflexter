package com.ajopaul.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class ResponseServlet extends HttpServlet
{ 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                           IOException
    {
      if(null != req.getParameter("listPrograms")){
        doListPrograms(req,resp);
      }else{

        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        resp.setContentType("application/json"); 
        PrintWriter out = resp.getWriter(); 

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("Region", "West");
        map.put("Category", "Retail");



        JSONObject obj = new JSONObject(map);
        obj.put("message","hello" );
        System.out.append("Printing Map ");
        System.out.println(obj.toString());
        out.print(obj);
      }
    }
    
    /**
     * Perform do Listing of the programs
     * @param req
     * @param resp
     * @throws IOException 
     */
    
    private void doListPrograms(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
      Map<String,Object> data = new HashMap<String,Object>();
      data.put("programs1", "Program One,1,Client One");
      data.put("programs2", "Program Two,2,Client Two");
      data.put("programs3", "Program Three,3,Client Three");
      JSONObject obj = new JSONObject(data);
      PrintWriter out = resp.getWriter();
      out.print(obj);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                         IOException
    {
      doGet(req, resp);
    }
}
