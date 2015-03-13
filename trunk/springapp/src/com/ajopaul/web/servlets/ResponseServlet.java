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
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                         IOException
    {
      doGet(req, resp);
    }
}
