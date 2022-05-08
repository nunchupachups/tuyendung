package cntt.trang.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cntt.trang.dao.ThongBaoDAO;
@Controller
public class TrangChuController {
	@RequestMapping("/trangchu")
    public String dangNhap(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		model.addAttribute("title","Trang Chủ");
	    	return "trangchu";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
}
