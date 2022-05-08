package cntt.trang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cntt.trang.dao.ThongBaoDAO;

@Controller
@RequestMapping(value = "/thongbao")
public class ThongBaoController {
	@RequestMapping(value= {"/daxem"}, method=RequestMethod.POST)
    public void xemThongBao(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maThongBao=request.getParameter("maThongBao");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		thongBaoDAO.daXemThongBao(Long.parseLong(maThongBao));
	    	
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
}
