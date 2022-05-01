package cntt.trang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/testti")
public class HelloController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String index(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	    	return "testAPI";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String displayindex(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		String hi= request.getParameter("test1ti");
	 		model.addAttribute("text", hi);
	    	return "test";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

}
