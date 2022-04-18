package cntt.trang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DangNhapController {
	@RequestMapping(value= {"/dangnhap"}, method=RequestMethod.GET)
    public String displayDangNhap(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		model.addAttribute("title", "Đăng nhập");
	    	return "dangnhap";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
}
