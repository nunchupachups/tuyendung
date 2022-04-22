package cntt.trang.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cntt.trang.bean.SinhVien;
import cntt.trang.dao.CVDAO;
import cntt.trang.dao.ChungChiDAO;
import cntt.trang.dao.DoanhNghiepDAO;
import cntt.trang.dao.DonViDAO;
import cntt.trang.dao.KyNangDAO;
import cntt.trang.dao.NganhDaoTaoDAO;
import cntt.trang.dao.SinhVienDAO;
import cntt.trang.dao.ViTriDAO;


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
	@RequestMapping(value= {"/dangnhap"}, method=RequestMethod.GET)
    public String displayDangNhap(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		model.addAttribute("title", "Đăng nhập tài khoản sinh viên");
	    	return "sinhvien/dangnhap";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	
	@RequestMapping(value= {"/dangnhap"}, method=RequestMethod.POST)
    public String dangNhap(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		SinhVienDAO sinhVienDAO = new SinhVienDAO();
	 		
	 		String maSinhVien=request.getParameter("txtMaSinhVien");
	 		String matKhau=request.getParameter("txtMatKhau");
	 		
	 		if(sinhVienDAO.KiemTraDangNhap(maSinhVien, matKhau)!= null) {
	 			session.setAttribute("sinhvien",sinhVienDAO.KiemTraDangNhap(maSinhVien, matKhau));
	 			return "redirect:/doanhnghiep";
	 		}
	 		else model.addAttribute("msg", "Mã sinh viên hoặc mật khẩu sai");
	 		
	 		model.addAttribute("title", "Đăng nhập tài khoản sinh viên");
	    	return "sinhvien/dangnhap";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/dangxuat"}, method=RequestMethod.GET)
    public String dangXuat(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		session.removeAttribute("sinhvien");
	 		return "redirect:/doanhnghiep";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/CV"}, method=RequestMethod.GET)
    public String displayCV(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		SinhVien sinhVien= (SinhVien)session.getAttribute("sinhvien");
	 		model.addAttribute("sinhVien", sinhVien);
	 		return "sinhvien/CV/show";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/taoCV"}, method=RequestMethod.GET)
    public String taoCV(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		SinhVien sinhVien= (SinhVien)session.getAttribute("sinhvien");
	 		CVDAO cvdao=new CVDAO();
	 		KyNangDAO kyNangDAO=new KyNangDAO();
	 		ChungChiDAO chungChiDAO= new ChungChiDAO();
	 		DonViDAO donViDAO=new DonViDAO();
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		
	 		
	 		
	 		return "sinhvien/CV/show";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
}
