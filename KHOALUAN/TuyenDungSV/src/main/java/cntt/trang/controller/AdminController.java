package cntt.trang.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cntt.trang.bean.DoanhNghiep;
import cntt.trang.bean.QuangBa;
import cntt.trang.bean.TuyenDung;
import cntt.trang.dao.AdminDAO;
import cntt.trang.dao.DoanhNghiepDAO;
import cntt.trang.dao.HashMD5;
import cntt.trang.dao.HinhThucLamViecDAO;
import cntt.trang.dao.LinhVucHoatDongCap2DAO;
import cntt.trang.dao.LoaiHinhDoanhNghiepDAO;
import cntt.trang.dao.NganhNgheDAO;
import cntt.trang.dao.QuangBaDAO;
import cntt.trang.dao.ThongBaoDAO;
import cntt.trang.dao.TinhThanhDAO;
import cntt.trang.dao.TuyenDungDAO;
import cntt.trang.dao.XaPhuongDAO;

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
	@RequestMapping(value= {"/dangxuat"}, method=RequestMethod.GET)
    public String dangXuat(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		session.removeAttribute("admin");
	 		return "redirect:/trangchu";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/doanhnghiep"}, method=RequestMethod.GET)
    public String doanhNghiep(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		ArrayList<DoanhNghiep> doanhNghiepChuaDuyets=doanhNghiepDAO.getAllDoanhNghiepChuaDuyet();
	 		ArrayList<DoanhNghiep> doanhNghiepDaDuyets=doanhNghiepDAO.getAllDoanhNghiepDaDuyet();
	 		model.addAttribute("doanhNghiepChuaDuyets",doanhNghiepChuaDuyets);
	 		model.addAttribute("doanhNghiepDaDuyets",doanhNghiepDaDuyets);
	 		model.addAttribute("title", "Doanh Nghiệp");
	    	return "admin/doanhnghiep/list";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung"}, method=RequestMethod.GET)
    public String tuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		
	 		ArrayList<TuyenDung> tuyenDungChuaDuyets=tuyenDungDAO.getAllTuyenDungChuaDuyet();
	 		ArrayList<TuyenDung> tuyenDungDaDuyets=tuyenDungDAO.getAllTuyenDungDaDuyet();
	 		model.addAttribute("tuyenDungChuaDuyets",tuyenDungChuaDuyets);
	 		model.addAttribute("tuyenDungDaDuyets",tuyenDungDaDuyets);
	 		model.addAttribute("doanhNghiepDAO", doanhNghiepDAO);
	 		model.addAttribute("title", "Tuyển Dụng");
	    	return "admin/tuyendung/list";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba"}, method=RequestMethod.GET)
    public String quangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		QuangBaDAO quangBaDAO=new QuangBaDAO();
	 		
	 		ArrayList<QuangBa> quangBaChuaDuyets=quangBaDAO.getAllQuangChuaDuyet();
	 		ArrayList<QuangBa> quangBaDaDuyets=quangBaDAO.getAllQuangDaDuyet();
	 		model.addAttribute("quangBaDaDuyets",quangBaDaDuyets);
	 		model.addAttribute("quangBaChuaDuyets",quangBaChuaDuyets);
	 		model.addAttribute("title", "Quảng Bá");
	    	return "admin/quangba/list";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/doanhnghiep/chitiet"}, method=RequestMethod.GET)
    public String chiTietDoanhNghiep(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		XaPhuongDAO xaPhuongDAO= new XaPhuongDAO();
	 		LinhVucHoatDongCap2DAO linhVucHoatDongCap2DAO=new LinhVucHoatDongCap2DAO();
	 		LoaiHinhDoanhNghiepDAO loaiHinhDoanhNghiepDAO=new LoaiHinhDoanhNghiepDAO();
	 		String maDoanhNghiep=request.getParameter("id");
	 		DoanhNghiep doanhNghiep=doanhNghiepDAO.getDoanhNghiepById(Long.parseLong(maDoanhNghiep));
	 		
	 		
	 		ArrayList<String> anh=new ArrayList<String>();
	 		if(doanhNghiep.getGiayChungNhan()!=null&&!doanhNghiep.getGiayChungNhan().equals(""))
	 			for(String i:doanhNghiep.getGiayChungNhan().split(";"))
	 				anh.add(i);
	 		
	 		model.addAttribute("doanhNghiep",doanhNghiep);
	 		model.addAttribute("xaPhuongDAO",xaPhuongDAO);
	 		model.addAttribute("linhVucHoatDongCap2DAO",linhVucHoatDongCap2DAO);
	 		model.addAttribute("loaiHinhDoanhNghiepDAO",loaiHinhDoanhNghiepDAO);
	 		model.addAttribute("anh",anh);
	 		model.addAttribute("title", "Chi Tiết Doanh Nghiệp");
	    	return "admin/doanhnghiep/chitiet";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/chitiet"}, method=RequestMethod.GET)
    public String chiTietTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maTuyenDung=request.getParameter("id");
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		NganhNgheDAO nganhNgheDAO=new NganhNgheDAO();
	 		HinhThucLamViecDAO hinhThucLamViecDAO=new HinhThucLamViecDAO();
	 		TinhThanhDAO tinhThanhDAO=new TinhThanhDAO();
	 		
	 		
	 		model.addAttribute("tuyenDung", tuyenDungDAO.getTuyenDungByID(Long.parseLong(maTuyenDung)));
	 		model.addAttribute("title", "Chi Tiết Tuyển Dụng");
	 		model.addAttribute("nganhNgheDAO", nganhNgheDAO);
	 		model.addAttribute("hinhThucLamViecDAO", hinhThucLamViecDAO);
	 		model.addAttribute("tinhThanhDAO", tinhThanhDAO);
	    	return "admin/tuyendung/chitiet";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba/chitiet"}, method=RequestMethod.GET)
    public String chiTietQuangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maQuangBa=request.getParameter("id");
	 		QuangBaDAO quangBaDAO=new QuangBaDAO();
	 		
	 		model.addAttribute("quangBa", quangBaDAO.getQuangBaByID(Long.parseLong(maQuangBa)));
	 		model.addAttribute("title", "Chi Tiết Quảng Bá");
	    	return "admin/quangba/chitiet";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/doanhnghiep/duyet"}, method=RequestMethod.GET)
    public String duyetDoanhNghiep(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		
	 		String maDoanhNghiep=request.getParameter("id");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		
	 		doanhNghiepDAO.duyetDoanhNghiep(Long.parseLong(maDoanhNghiep));
	 		thongBaoDAO.insertThongBao(Long.parseLong(maDoanhNghiep), null, "Tài khoản đã được duyệt, hãy bắt đầu với các chức năng của website.", "");
	 		
	    	return "redirect:/admin/doanhnghiep";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/duyet"}, method=RequestMethod.GET)
    public String duyetTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		
	 		String maTuyenDung=request.getParameter("id");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		
	 		tuyenDungDAO.duyetTuyenDung(Long.parseLong(maTuyenDung));
	 		thongBaoDAO.insertThongBao(tuyenDungDAO.getTuyenDungByID(Long.parseLong(maTuyenDung)).getMaDoanhNghiep(), null, "Bài tuyển dụng của bạn đã được duyệt !", "/doanhnghiep/tuyendung/chitiet?id="+maTuyenDung);
	 		
	    	return "redirect:/admin/tuyendung";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba/duyet"}, method=RequestMethod.GET)
    public String duyetQuangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		QuangBaDAO quangBaDAO=new QuangBaDAO();
	 		
	 		String maQuangBa=request.getParameter("id");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		
	 		quangBaDAO.duyetQuangBa(Long.parseLong(maQuangBa));
	 		thongBaoDAO.insertThongBao(quangBaDAO.getQuangBaByID(Long.parseLong(maQuangBa)).getMaDoanhNghiep(), null, "Bài quảng bá của bạn đã được duyệt !", "/doanhnghiep/quangba/chitiet?id="+maQuangBa);
	 		
	    	return "redirect:/admin/quangba";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/doanhnghiep/phanhoi"}, method=RequestMethod.POST)
    public String phanHoiDoanhNghiep(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		
	 		String maDoanhNghiep=request.getParameter("txtMaDoanhNghiep");
	 		String phanHoi=request.getParameter("txtPhanHoi");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		
	 		doanhNghiepDAO.updatePhanHoi(Long.parseLong(maDoanhNghiep), phanHoi);
	 		thongBaoDAO.insertThongBao(Long.parseLong(maDoanhNghiep), null, "Tài khoản chưa được duyệt: "+phanHoi, "");
	 		
	    	return "redirect:/admin/doanhnghiep";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/phanhoi"}, method=RequestMethod.POST)
    public String phanHoiTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		
	 		String maTuyenDung=request.getParameter("txtMaTuyenDung");
	 		String phanHoi=request.getParameter("txtPhanHoi");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		
	 		tuyenDungDAO.updatePhanHoi(Long.parseLong(maTuyenDung), phanHoi);
	 		thongBaoDAO.insertThongBao(tuyenDungDAO.getTuyenDungByID(Long.parseLong(maTuyenDung)).getMaDoanhNghiep(), null, "Bài tuyển dụng của bạn chưa được duyệt: "+phanHoi, "/doanhnghiep/tuyendung/chitiet?id="+maTuyenDung);
	 		
	    	return "redirect:/admin/tuyendung";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba/phanhoi"}, method=RequestMethod.POST)
    public String phanHoiQuangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		QuangBaDAO quangBaDAO=new QuangBaDAO();
	 		
	 		String maQuangBa=request.getParameter("txtMaQuangBa");
	 		String phanHoi=request.getParameter("txtPhanHoi");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		
	 		quangBaDAO.updatePhanHoi(Long.parseLong(maQuangBa), phanHoi);
	 		thongBaoDAO.insertThongBao(quangBaDAO.getQuangBaByID(Long.parseLong(maQuangBa)).getMaDoanhNghiep(), null, "Bài quảng bá của bạn chưa được duyệt: "+phanHoi, "/doanhnghiep/quangba/chitiet?id="+maQuangBa);
	 		
	    	return "redirect:/admin/quangba";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
}
