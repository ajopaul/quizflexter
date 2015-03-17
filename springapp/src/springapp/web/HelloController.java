package springapp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ajopaul.pojos.ProgramBeanUtils;

public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      /* String now = (new Date()).toString();
       logger.info("Returning hello view with "+now);

       //return new ModelAndView("WEB-INF/jsp/hello.jsp","now",now);
       return new ModelAndView("hello","now",now);*/
    	
    	
    	  Map<String, String> model = new HashMap<String, String>();
          model.put("firstname", "Peter");
          model.put("secondname", "Schmitt");

    	
    	List<Object> list = new ArrayList<Object>();
        list.add(ProgramBeanUtils.getProgramBean("Prog One",100 , "One Client"));
        list.add(ProgramBeanUtils.getProgramBean("Prog Two",200 , "Two Client"));
        list.add(ProgramBeanUtils.getProgramBean("Prog Three",300 , "Three Client"));
        //Create a JSONArray
        JSONArray arry = new JSONArray(list);
         return new ModelAndView("jsonView", model);
        //return new ModelAndView("jsonView", arry);
    }

}
