package cntt.trang.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cntt.trang.dao.NganhDaoTaoDAO;


@Controller
@RequestMapping(value = "/sinhvien")
public class SinhVienController {
	@RequestMapping(value= {"","/timkiem"}, method=RequestMethod.GET)
    public String tuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		NganhDaoTaoDAO nganhDaoTaoDAO= new NganhDaoTaoDAO();
	 		
	 		model.addAttribute("dsNganhDaoTao", nganhDaoTaoDAO.getAllNganhDaoTao());
	    	return "sinhvien/timkiemsinhvien";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
}
