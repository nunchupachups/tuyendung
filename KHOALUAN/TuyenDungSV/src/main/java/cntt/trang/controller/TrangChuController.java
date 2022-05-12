package cntt.trang.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cntt.trang.dao.BlogDAO;
import cntt.trang.dao.DoanhNghiepDAO;
import cntt.trang.dao.QuangBaDAO;
import cntt.trang.dao.ThongBaoDAO;
import cntt.trang.dao.TinhThanhDAO;
import cntt.trang.dao.TuyenDungDAO;
@Controller
public class TrangChuController {
	@RequestMapping(value = {"","/trangchu"})
    public String dangNhap(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		QuangBaDAO quangBaDAO=new QuangBaDAO();
	 		BlogDAO blogDAO=new BlogDAO();
	 		model.addAttribute("tinhThanhDAO", tinhThanhDAO);	
	 		model.addAttribute("blogs", blogDAO.getAllBlogDaDuyet());	
	 		model.addAttribute("doanhNghieps", doanhNghiepDAO.getAllDoanhNghiepDaDuyet());	
	 		model.addAttribute("quangBaDAO", quangBaDAO);	
	 		model.addAttribute("tuyenDungs",tuyenDungDAO.getAllTuyenDungDaDuyet() );
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		model.addAttribute("title","Trang Chủ");
	    	return "trangchu";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
}
