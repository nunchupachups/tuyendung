package cntt.trang.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cntt.trang.bean.DoanhNghiep;
import cntt.trang.bean.QuanHuyen;
import cntt.trang.bean.QuangBa;
import cntt.trang.bean.TinhThanh;
import cntt.trang.bean.XaPhuong;
import cntt.trang.dao.DoanhNghiepDAO;
import cntt.trang.dao.LinhVucHoatDongCap1DAO;
import cntt.trang.dao.LinhVucHoatDongCap2DAO;
import cntt.trang.dao.LoaiHinhDoanhNghiepDAO;
import cntt.trang.dao.QuanHuyenDAO;
import cntt.trang.dao.QuangBaDAO;
import cntt.trang.dao.TinhThanhDAO;
import cntt.trang.dao.XaPhuongDAO;

@Controller
@RequestMapping(value = "/doanhnghiep")
public class DoanhNghiepController {
	@RequestMapping(value= {"","/timkiem"}, method=RequestMethod.GET)
    public String tuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		XaPhuongDAO xaPhuongDAO = new XaPhuongDAO();
	 		LinhVucHoatDongCap2DAO linhVucHoatDongCap2DAO = new LinhVucHoatDongCap2DAO();
	 		LinhVucHoatDongCap1DAO linhVucHoatDongCap1DAO = new LinhVucHoatDongCap1DAO();
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		LoaiHinhDoanhNghiepDAO loaiHinhDoanhNghiepDAO= new LoaiHinhDoanhNghiepDAO();
	 		
	 		String tenDN=request.getParameter("txttenDN");
	 		String maTT=request.getParameter("cmbmaTT");
	 		String maLVHD=request.getParameter("cmbmaLVHD");
	 		String maLHDN=request.getParameter("cmbmaLHDN");
	 		
	 		ArrayList<DoanhNghiep> dsdoanhnghiep=doanhNghiepDAO.getAllDoanhNghiepDaDuyet();
			  if(tenDN!=null||maTT!=null||maLHDN!=null||maLVHD!=null)
				  dsdoanhnghiep=doanhNghiepDAO.timKiemDoanhNghiepDaDuyet(tenDN, maTT, maLVHD, maLHDN);

			 	
	 		model.addAttribute("title", "Doanh nghiệp");
	 		model.addAttribute("dsdoanhnghiep", dsdoanhnghiep);
	 		model.addAttribute("xaPhuongDAO", xaPhuongDAO);
	 		model.addAttribute("linhVucHoatDongCap2DAO", linhVucHoatDongCap2DAO);
	 		model.addAttribute("dsTinhThanh", tinhThanhDAO.getAllTinhThanh());
	 		model.addAttribute("dsLinhVuc", linhVucHoatDongCap1DAO.getAllLinhVucHoatDongCap1());
	 		model.addAttribute("dsLoaiHinhDoanhNghiep", loaiHinhDoanhNghiepDAO.getAllLoaiHinhDoanhNghiep());
	 		
	    	return "doanhnghiep/timkiemdoanhnghiep";
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
	 		
	 		model.addAttribute("title", "Đăng nhập tài khoản doanh nghiệp");
	    	return "doanhnghiep/dangnhap";
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
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		
	 		String email=request.getParameter("txtemail");
	 		String password=request.getParameter("txtpassword");
	 		
	 		if(doanhNghiepDAO.KiemTraDangNhap(email, password)!= null) {
	 			session.setAttribute("doanhnghiep",doanhNghiepDAO.KiemTraDangNhap(email, password));
	 			return "redirect:/sinhvien";
	 		}
	 		else model.addAttribute("msg", "Email đăng nhập hoặc mật khẩu sai");
	 		
	 		model.addAttribute("title", "Đăng nhập tài khoản doanh nghiệp");
	    	return "doanhnghiep/dangnhap";
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
	 		
	 		session.removeAttribute("doanhnghiep");
	 		return "redirect:/doanhnghiep";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/dangky"}, method=RequestMethod.GET)
    public String displayDangKy(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		XaPhuongDAO xaPhuongDAO= new XaPhuongDAO();
	 		QuanHuyenDAO quanHuyenDAO=new QuanHuyenDAO();
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		LinhVucHoatDongCap1DAO linhVucHoatDongCap1DAO= new LinhVucHoatDongCap1DAO();
	 		LinhVucHoatDongCap2DAO linhVucHoatDongCap2DAO= new LinhVucHoatDongCap2DAO();
	 		LoaiHinhDoanhNghiepDAO loaiHinhDoanhNghiepDAO= new LoaiHinhDoanhNghiepDAO();
	 		
	 		model.addAttribute("title", "Đăng ký tài khoản doanh nghiệp");
	 		model.addAttribute("xaPhuongDAO", xaPhuongDAO);
	 		model.addAttribute("quanHuyenDAO", quanHuyenDAO);
	 		model.addAttribute("linhVucHoatDongCap2DAO", linhVucHoatDongCap2DAO);
	 		model.addAttribute("dsTinhThanh", tinhThanhDAO.getAllTinhThanh());
	 		model.addAttribute("dsLinhVuc", linhVucHoatDongCap1DAO.getAllLinhVucHoatDongCap1());
	 		model.addAttribute("dsLoaiHinhDoanhNghiep", loaiHinhDoanhNghiepDAO.getAllLoaiHinhDoanhNghiep());
	 		
	 		return "doanhnghiep/dangky";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	
	@RequestMapping(value= {"/dangky"}, method=RequestMethod.POST)
    public String dangKy(@RequestParam("txtEmail") String email,@RequestParam("txtMatKhau") String matKhau,@RequestParam("txtTenLienHe") String tenLienHe,
			@RequestParam("txtEmailLienHe") String emailLienHe,@RequestParam("txtSoDienThoai") String soDienThoai,@RequestParam("txtTenDoanhNghiep") String tenDoanhNghiep,
			@RequestParam("txtMaSoThue") String maSoThue,@RequestParam("cmbXaPhuong") String maXaPhuong,@RequestParam("txtDiaChiDuong") String diaChiDuong,
			@RequestParam("cmbLinhVucHoatDong") String maLinhVucHoatDong, @RequestParam("cmbLoaiHinhDoanhNghiep") String maLoaiHinhDoanhNghiep,
			@RequestParam("giayChungNhan") CommonsMultipartFile[] giayChungNhan, Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String anh="";
			String absolutefilePath=request.getServletContext().getRealPath("/image");
			File dir = new File(absolutefilePath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
	 		for (CommonsMultipartFile file : giayChungNhan) {
					byte[] bytes=file.getBytes();
					Date date=new Date();
					String name="anh"+date.getTime()+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
					
					File uploadfile=new File(dir.getAbsolutePath()+"\\"+name);
					BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(uploadfile));
					outputStream.write(bytes);
					outputStream.close();
					anh+="image/"+name+";";
					
			}
	 		
	 		anh.substring(0, anh.length()-2);
	 		DoanhNghiepDAO doanhNghiepDAO= new DoanhNghiepDAO();
			int hihi=doanhNghiepDAO.insertDoanhNghiep(email, matKhau, tenLienHe, emailLienHe, soDienThoai, tenDoanhNghiep, maSoThue, maXaPhuong, diaChiDuong, maLinhVucHoatDong,Long.parseLong(maLoaiHinhDoanhNghiep) , anh, false);
	 		DoanhNghiep doanhNghiep=doanhNghiepDAO.KiemTraDangNhap(email, matKhau);
			session.setAttribute("doanhnghiep", doanhNghiep);
			redirectAttributes.addFlashAttribute("dktc", "Đăng ký tài khoản doanh nghiệp thành công!");
			return "redirect:/sinhvien";
	 		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/dangky/quanhuyen"}, method=RequestMethod.POST)
    public void setQuanHuyen(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maTinhThanh=request.getParameter("maTinhThanh");
	 		QuanHuyenDAO quanHuyenDAO= new QuanHuyenDAO();
	 		ArrayList<QuanHuyen> ds= quanHuyenDAO.getAllQuanHuyenByMaTinhThanh(maTinhThanh);
	 		PrintWriter out=response.getWriter();
	 		for (QuanHuyen qh : ds) {
				out.print("<option value=\""+qh.getMaQuanHuyen()+"\">"+qh.getTenQuanHuyen()+"</option> ");
			}
	 		
		} catch (Exception e) {
			e.getStackTrace();
		}
       
    }
	@RequestMapping(value= {"/dangky/xaphuong"}, method=RequestMethod.POST)
    public void setXaPhuong(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maQuanHuyen=request.getParameter("maQuanHuyen");
	 		XaPhuongDAO xaPhuongDAO= new XaPhuongDAO();
	 		ArrayList<XaPhuong> ds= xaPhuongDAO.getAllXaPhuongByMaQuanHuyen(maQuanHuyen);
	 		PrintWriter out=response.getWriter();
	 		for (XaPhuong xp : ds) {
				out.print("<option value=\""+xp.getMaXaPhuong()+"\">"+xp.getTenXaPhuong()+"</option> ");
			}
	 		
		} catch (Exception e) {
			e.getStackTrace();
		}
       
    }
	@RequestMapping(value= {"/quangba"}, method=RequestMethod.GET)
    public String displayQuangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		QuangBaDAO quangBaDAO= new QuangBaDAO();
	 		DoanhNghiep doanhnghiep=(DoanhNghiep) session.getAttribute("doanhnghiep");
	 		
	 		model.addAttribute("title", "Quảng Bá");
	 		model.addAttribute("dsQuangBa", quangBaDAO.getAllQuangBaDaDuyetByMaDoanhNghiep(doanhnghiep.getMaDoanhNghiep()));
	 		
	 		return "doanhnghiep/quangba/list";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba"}, method=RequestMethod.POST)
    public String themQuangBa(@RequestParam("txtTieuDe") String tieuDe,@RequestParam("txtNoiDung") String noiDungDaiDien,
    		@RequestParam("imgAnhDaiDien") String hinhAnhDaiDien, @RequestParam("txtBaiViet") String baiViet, 
    		Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
			String absolutefilePath=request.getServletContext().getRealPath("/image");
			File dir = new File(absolutefilePath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
	 		byte[] bytes=hinhAnhDaiDien.getBytes();
			Date date=new Date();
//			String name="anh"+date.getTime()+hinhAnhDaiDien.getOriginalFilename().substring(hinhAnhDaiDien.getOriginalFilename().indexOf("."));
//			File uploadfile=new File(dir.getAbsolutePath()+"\\"+name);
//			BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(uploadfile));
//			outputStream.write(bytes);
//			outputStream.close();
//			String anh ="image/"+name;
//				
//			DoanhNghiep doanhnghiep=(DoanhNghiep)session.getAttribute("doanhnghiep");
//			QuangBaDAO quangBaDAO=new QuangBaDAO();
//			quangBaDAO.insertQuangBa(tieuDe, noiDungDaiDien, anh, baiViet, false, doanhnghiep.getMaDoanhNghiep());
			
			return "redirect:/doanhnghiep/quangba";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
}
