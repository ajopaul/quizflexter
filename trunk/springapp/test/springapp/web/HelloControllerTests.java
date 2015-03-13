package springapp.web;

import org.springframework.web.servlet.ModelAndView;

import junit.framework.TestCase;

public class HelloControllerTests extends TestCase
{
  public void testHandleRequestView() throws Exception{
    HelloController hController = new HelloController();
    ModelAndView modelAndView = hController.handleRequest(null, null);
    //assertEquals("WEB-INF/jsp/hello.jsp", modelAndView.getViewName());
    assertEquals("hello", modelAndView.getViewName());
    assertNotNull(modelAndView.getModel());
    String nowValue = (String) modelAndView.getModel().get("now");
    assertNotNull(nowValue);
  } 
}
