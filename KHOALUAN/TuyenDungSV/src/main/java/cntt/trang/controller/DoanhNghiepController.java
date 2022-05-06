package cntt.trang.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cntt.trang.bean.DoanhNghiep;
import cntt.trang.bean.QuanHuyen;
import cntt.trang.bean.QuangBa;
import cntt.trang.bean.SinhVien;
import cntt.trang.bean.TuyenDung;
import cntt.trang.bean.XaPhuong;
import cntt.trang.dao.DangKyTuyenDungDAO;
import cntt.trang.dao.DoanhNghiepDAO;
import cntt.trang.dao.HinhThucLamViecDAO;
import cntt.trang.dao.LinhVucHoatDongCap1DAO;
import cntt.trang.dao.LinhVucHoatDongCap2DAO;
import cntt.trang.dao.LoaiHinhDoanhNghiepDAO;
import cntt.trang.dao.NganhNgheDAO;
import cntt.trang.dao.QuanHuyenDAO;
import cntt.trang.dao.QuangBaDAO;
import cntt.trang.dao.TinhThanhDAO;
import cntt.trang.dao.TuyenDungDAO;
import cntt.trang.dao.VNCharacterUtils;
import cntt.trang.dao.XaPhuongDAO;

@Controller
@RequestMapping(value = "/doanhnghiep")
public class DoanhNghiepController {
	@RequestMapping(value= {"","/timkiem"}, method=RequestMethod.GET)
    public String doanhNghiep(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
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
	 		model.addAttribute("dsQuangBa", quangBaDAO.getAllQuangBaByMaDoanhNghiep(doanhnghiep.getMaDoanhNghiep()));
	 		
	 		return "doanhnghiep/quangba/list";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba"}, method=RequestMethod.POST)
    public String themQuangBa(@RequestParam("txtTieuDe") String tieuDe,@RequestParam("txtNoiDung") String noiDungDaiDien,
    		@RequestParam("imgAnhDaiDien") CommonsMultipartFile hinhAnhDaiDien, @RequestParam("txtBaiViet") String baiViet, 
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
			String name="anh"+date.getTime()+hinhAnhDaiDien.getOriginalFilename().substring(hinhAnhDaiDien.getOriginalFilename().indexOf("."));
			File uploadfile=new File(dir.getAbsolutePath()+"\\"+name);
			BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(uploadfile));
			outputStream.write(bytes);
			outputStream.close();
			String anh ="image/"+name;
				
			DoanhNghiep doanhnghiep=(DoanhNghiep)session.getAttribute("doanhnghiep");
			QuangBaDAO quangBaDAO=new QuangBaDAO();
			int kq=quangBaDAO.insertQuangBa(tieuDe, noiDungDaiDien, anh, baiViet, false, doanhnghiep.getMaDoanhNghiep());
			
			if(kq!=-1) redirectAttributes.addFlashAttribute("msg1", "Thêm bài quảng bá thành công!");
			else redirectAttributes.addFlashAttribute("msg2", "Thêm bài quảng bá thất bại!");
			return "redirect:/doanhnghiep/quangba";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	
	@RequestMapping(value= {"/quangba/chitiet"}, method=RequestMethod.GET)
    public String chiTietQuangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
		try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		String id = (String) model.asMap().get("id1");
	 		long maQuangBa;
	 		if(request.getParameter("id")!=null) maQuangBa= Long.parseLong(request.getParameter("id")) ;
	 		else maQuangBa=Long.parseLong(id);
	 		QuangBaDAO quangBaDAO= new QuangBaDAO();
	 		QuangBa quangBa= quangBaDAO.getQuangBaByID(maQuangBa);
	 		

	 		model.addAttribute("title", "Chi Tiết Quảng Bá");
	 		model.addAttribute("quangBa", quangBa);
	 		
	 		return "doanhnghiep/quangba/chitiet";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba/xoa"}, method=RequestMethod.GET)
    public String xoaQuangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		long maQuangBa = Long.parseLong(request.getParameter("id")) ;
	 		QuangBaDAO quangBaDAO= new QuangBaDAO();
	 		int kq= quangBaDAO.deleteQuangBa(maQuangBa);
	 		
	 		if(kq!=-1) redirectAttributes.addFlashAttribute("msg1", "Xoá bài quảng bá thành công!");
			else redirectAttributes.addFlashAttribute("msg2", "Xoá bài quảng bá thất bại!");
	 		return "redirect:/doanhnghiep/quangba";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba/sua"}, method=RequestMethod.GET)
    public String displaySuaQuangBa(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
		try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		long maQuangBa = Long.parseLong(request.getParameter("id")) ;
	 		QuangBaDAO quangBaDAO= new QuangBaDAO();
	 		QuangBa quangBa= quangBaDAO.getQuangBaByID(maQuangBa);
	 		model.addAttribute("quangBa", quangBa);
	 		model.addAttribute("title", "Sửa Quảng Bá");
	 		return "doanhnghiep/quangba/sua";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/quangba/sua"}, method=RequestMethod.POST)
    public String suaQuangBa(@RequestParam("txtTieuDe") String tieuDe,@RequestParam("txtNoiDung") String noiDungDaiDien,
    		@RequestParam("imgAnhDaiDien") CommonsMultipartFile hinhAnhDaiDien, @RequestParam("txtBaiViet") String baiViet,
    		@RequestParam("txtMaQuangBa") String maQuangBa, 
    		Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		QuangBaDAO quangBaDAO=new QuangBaDAO();
	 		String anh;
	 		if(hinhAnhDaiDien!= null) anh=quangBaDAO.getQuangBaByID(Long.parseLong(maQuangBa)).getHinhAnhDaiDien();
	 		else {
	 			String absolutefilePath=request.getServletContext().getRealPath("/image");
				File dir = new File(absolutefilePath);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				
		 		byte[] bytes=hinhAnhDaiDien.getBytes();
				Date date=new Date();
				String name="anh"+date.getTime()+hinhAnhDaiDien.getOriginalFilename().substring(hinhAnhDaiDien.getOriginalFilename().indexOf("."));
				File uploadfile=new File(dir.getAbsolutePath()+"\\"+name);
				BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(uploadfile));
				outputStream.write(bytes);
				outputStream.close();
				anh ="image/"+name;
	 		}

			int kq=quangBaDAO.updateQuangBa(Long.parseLong(maQuangBa), tieuDe, noiDungDaiDien, anh, baiViet);
			
			redirectAttributes.addFlashAttribute("id1", maQuangBa);
			if(kq!=-1) redirectAttributes.addFlashAttribute("msg1", "Sửa bài quảng bá thành công!");
			else redirectAttributes.addFlashAttribute("msg2", "Sửa bài quảng bá thất bại!");
			return "redirect:/doanhnghiep/quangba/chitiet";

		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung"}, method=RequestMethod.GET)
    public String timKiemTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		NganhNgheDAO nganhNgheDAO= new NganhNgheDAO();
	 		HinhThucLamViecDAO hinhThucLamViecDAO = new HinhThucLamViecDAO();
	 	
	 		DoanhNghiep doanhNghiep=(DoanhNghiep) session.getAttribute("doanhnghiep");
	 		model.addAttribute("dsTuyenDung", tuyenDungDAO.getAllTuyenDungByMaDoanhNghiep(doanhNghiep.getMaDoanhNghiep()));
	 		System.out.println(tuyenDungDAO.getAllTuyenDungByMaDoanhNghiep(doanhNghiep.getMaDoanhNghiep()).size());
	 		model.addAttribute("nganhNgheDAO",nganhNgheDAO);
	 		model.addAttribute("hinhThucLamViecDAO",hinhThucLamViecDAO);
	 		model.addAttribute("title", "Tuyển Dụng");
	 		
	    	return "doanhnghiep/tuyendung/list";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/taotuyendung"}, method=RequestMethod.GET)
    public String displayTaoTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		NganhNgheDAO nganhNgheDAO= new NganhNgheDAO();
	 		HinhThucLamViecDAO hinhThucLamViecDAO=new HinhThucLamViecDAO();
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		
	 		model.addAttribute("dsNganhNghe", nganhNgheDAO.getAllNganhNghe());
	 		model.addAttribute("dsHinhThuc",hinhThucLamViecDAO.getAllHinhThucLamViec());
	 		model.addAttribute("dsTinhThanh", tinhThanhDAO.getAllTinhThanh());
	 		model.addAttribute("title", "Tạo Tuyển Dụng");
	 		
	    	return "doanhnghiep/tuyendung/tao";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/taotuyendung"}, method=RequestMethod.POST)
    public String taoTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		long maNganhNghe=Long.parseLong(request.getParameter("cmbNganhNghe")) ;
	 		String tenCongViec=request.getParameter("txtTenCongViec");
	 		long maHinhThuc=Long.parseLong(request.getParameter("cmbHinhThuc")) ;
	 		String thoiGianThuViec=null;
	 		if(!request.getParameter("cmbThoiGianThuViec").equals("0")) thoiGianThuViec=request.getParameter("cmbThoiGianThuViec");
	 		Integer sinhVienNam=Integer.parseInt(request.getParameter("cmbSinhVienNam"));
	 		String gioiTinh=null;
	 		if(!request.getParameter("cmbGioiTinh").equals("0")) gioiTinh=request.getParameter("cmbGioiTinh");
	 		String khuVucTuyenDung=request.getParameter("cmbKhuVucTuyen");
	 		int soLuong=Integer.parseInt(request.getParameter("numSoLuong")) ;
	 		String mucLuong=request.getParameter("txtMucLuong");
	 		System.out.println(request.getParameter("dHanDangKy"));
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			Date hanDangKy= sdf.parse(request.getParameter("dHanDangKy"));
	 		String tieuDe=request.getParameter("txtTieuDe");
	 		String moTaCongViec=request.getParameter("txtMoTaCongViec");
	 		String yeuCauCongViec=request.getParameter("txtYeuCauCongViec");
	 		String quyenLoi=request.getParameter("txtQuyenLoi");
	 		DoanhNghiep doanhNghiep=(DoanhNghiep)session.getAttribute("doanhnghiep");
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		int kq=tuyenDungDAO.insertTuyenDung(maNganhNghe, maHinhThuc, sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi, false, doanhNghiep.getMaDoanhNghiep());
	 		if(kq!=-1) redirectAttributes.addFlashAttribute("msg1", "Thêm bài tuyển dụng thành công!");
			else redirectAttributes.addFlashAttribute("msg2", "Thêm bài tuyển dụng thất bại!");
	 		
	    	return "redirect:/doanhnghiep/tuyendung";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/xoa"}, method=RequestMethod.GET)
    public String xoaTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		long maTuyenDung = Long.parseLong(request.getParameter("id")) ;
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		int kq= tuyenDungDAO.deleteTuyenDung(maTuyenDung);
	 		
	 		if(kq!=-1) redirectAttributes.addFlashAttribute("msg1", "Xoá bài tuyển dụng thành công!");
			else redirectAttributes.addFlashAttribute("msg2", "Xoá bài tuyển dụng thất bại!");
	 		return "redirect:/doanhnghiep/tuyendung";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/sua"}, method=RequestMethod.GET)
    public String displaySuaTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
		try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		long maTuyenDung = Long.parseLong(request.getParameter("id")) ;
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		TuyenDung tuyenDung= tuyenDungDAO.getTuyenDungByID(maTuyenDung);
	 		NganhNgheDAO nganhNgheDAO= new NganhNgheDAO();
	 		HinhThucLamViecDAO hinhThucLamViecDAO=new HinhThucLamViecDAO();
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		
	 		model.addAttribute("dsNganhNghe", nganhNgheDAO.getAllNganhNghe());
	 		model.addAttribute("dsHinhThuc",hinhThucLamViecDAO.getAllHinhThucLamViec());
	 		model.addAttribute("dsTinhThanh", tinhThanhDAO.getAllTinhThanh());
	 		model.addAttribute("tuyenDung", tuyenDung);
	 		model.addAttribute("title", "Sửa Tuyển Dụng");
	 		return "doanhnghiep/tuyendung/sua";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/tuyendung/sua"}, method=RequestMethod.POST)
    public String suaTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		long maNganhNghe=Long.parseLong(request.getParameter("cmbNganhNghe")) ;
	 		String tenCongViec=request.getParameter("txtTenCongViec");
	 		long maHinhThuc=Long.parseLong(request.getParameter("cmbHinhThuc")) ;
	 		String thoiGianThuViec=request.getParameter("cmbThoiGianThuViec");
	 		if(thoiGianThuViec.equals("0")) thoiGianThuViec=null;
	 		Integer sinhVienNam=Integer.parseInt(request.getParameter("cmbSinhVienNam"));
	 		String gioiTinh=request.getParameter("cmbGioiTinh");
	 		if(gioiTinh.equals("0")) gioiTinh=null;
	 		String khuVucTuyenDung=request.getParameter("cmbKhuVucTuyen");
	 		int soLuong=Integer.parseInt(request.getParameter("numSoLuong")) ;
	 		String mucLuong=request.getParameter("txtMucLuong");
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			Date hanDangKy= sdf.parse(request.getParameter("dHanDangKy"));
	 		String tieuDe=request.getParameter("txtTieuDe");
	 		String moTaCongViec=request.getParameter("txtMoTaCongViec");
	 		String yeuCauCongViec=request.getParameter("txtYeuCauCongViec");
	 		String quyenLoi=request.getParameter("txtQuyenLoi");
	 		long maTuyenDung= Long.parseLong(request.getParameter("txtMaTuyenDung")) ;
	 		
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		int kq=tuyenDungDAO.updateTuyenDung(maTuyenDung, maNganhNghe, maHinhThuc,sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi);
	 		if(kq!=-1) redirectAttributes.addFlashAttribute("msg1", "Sửa bài tuyển dụng thành công!");
			else redirectAttributes.addFlashAttribute("msg2", "Sửa bài tuyển dụng thất bại!");
	 		return "redirect:/doanhnghiep/tuyendung";

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/chitiet"}, method=RequestMethod.GET)
	public String chiTiet(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		long maDoanhNghiep= Long.parseLong(request.getParameter("id"));
	 		
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		QuangBaDAO quangBaDAO=new QuangBaDAO();
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		XaPhuongDAO xaPhuongDAO= new XaPhuongDAO();
	 		TinhThanhDAO tinhThanhDAO=new TinhThanhDAO();
	 		
	 		model.addAttribute("doanhNghiep", doanhNghiepDAO.getDoanhNghiepById(maDoanhNghiep));
	 		model.addAttribute("quangBas", quangBaDAO.getAllQuangBaDaDuyetByMaDoanhNghiep(maDoanhNghiep));
	 		model.addAttribute("tuyenDungs", tuyenDungDAO.getAllTuyenDungDaDuyetByMaDoanhNghiep(maDoanhNghiep));
	 		model.addAttribute("xaPhuongDAO", xaPhuongDAO);
	 		model.addAttribute("tinhThanhDAO", tinhThanhDAO);
	 		model.addAttribute("title", "Doanh Nghiệp");
	 		System.out.println(quangBaDAO.getAllQuangBaDaDuyetByMaDoanhNghiep(maDoanhNghiep).size());
	 		for (QuangBa a : quangBaDAO.getAllQuangBaDaDuyetByMaDoanhNghiep(maDoanhNghiep)) {
				System.out.println(a.getTieuDe());
			}
	    	return "doanhnghiep/chitiet";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
}
