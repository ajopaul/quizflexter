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

import com.ajopaul.web.mgr.TinyMeMgr;
import com.ajopaul.web.mgr.TinyMgrFactory;

public class TinyMeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String inputUrl = req.getParameter("inputUrl");
		if(null != inputUrl && inputUrl.trim().length() != 0){
			doTinyMeUrl(inputUrl,resp);
		}else{
			String tinyUrl = req.getParameter("tinyUrl");
			if(null != tinyUrl && tinyUrl.trim().length() != 0){
				doRedirectTinyMeUrl(tinyUrl,req,resp);
			}
		}
			
	}
	
	/**
	 * Get the original url of the tiny url and redirect to equivalent target
	 * @param tinyUrl
	 * @param req
	 * @param resp
	 */
	protected void doRedirectTinyMeUrl(String tinyUrl, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Set the response as json object of tinyUrl 
	 * @param inputUrl
	 * @param resp
	 * @throws IOException 
	 */
	protected void doTinyMeUrl(String inputUrl, HttpServletResponse resp) throws IOException {
		Map<String,Object> json = new HashMap<String,Object>();
		TinyMeMgr mgr = TinyMgrFactory.getTinyMeMgr();
		String result = mgr.getTinyMeURL(inputUrl);
		json.put("target", result);
		JSONObject jObj = new JSONObject(json);
		PrintWriter out = resp.getWriter();
		out.print(jObj.toString());//Write Json to result stream;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
