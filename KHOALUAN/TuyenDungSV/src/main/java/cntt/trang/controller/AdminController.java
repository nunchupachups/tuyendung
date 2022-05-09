package cntt.trang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cntt.trang.dao.AdminDAO;
import cntt.trang.dao.HashMD5;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@RequestMapping(value= {"/dangnhap"}, method=RequestMethod.GET)
    public String displayDangNhap(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		model.addAttribute("title", "Đăng nhập tài khoản quản trị");
	    	return "admin/dangnhap";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/dangnhap"}, method=RequestMethod.POST)
    public String dangNhap(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		AdminDAO adminDAO= new AdminDAO();
	 		HashMD5 hashMD5=new HashMD5();
	 		String username=request.getParameter("txtUsername");
	 		String password=request.getParameter("txtPassword");
	 		
	 		if(adminDAO.KiemTraDangNhap(username, hashMD5.convertHashToString(password))!= null) {
	 			session.setAttribute("admin",adminDAO.KiemTraDangNhap(username, hashMD5.convertHashToString(password)));
	 			return "redirect:/admin/doanhnghiep";
	 		}
	 		else model.addAttribute("msg", "Tên đăng nhập hoặc mật khẩu sai");
	 		
	 		model.addAttribute("title", "Đăng nhập tài khoản quản trị");
	    	return "admin/dangnhap";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/doanhnghiep"}, method=RequestMethod.GET)
    public String doanhNghiep(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		model.addAttribute("title", "Đăng nhập tài khoản quản trị");
	    	return "admin/dangnhap";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
}
