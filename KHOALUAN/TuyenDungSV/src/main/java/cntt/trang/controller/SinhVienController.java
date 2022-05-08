package cntt.trang.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cntt.trang.bean.CV;
import cntt.trang.bean.ChungChi;
import cntt.trang.bean.DoanhNghiep;
import cntt.trang.bean.DonVi;
import cntt.trang.bean.KyNang;
import cntt.trang.bean.NganhDaoTao;
import cntt.trang.bean.SinhVien;
import cntt.trang.bean.TimKiemSV;
import cntt.trang.bean.ViTri;
import cntt.trang.dao.CVDAO;
import cntt.trang.dao.ChungChiDAO;
import cntt.trang.dao.DoanhNghiepDAO;
import cntt.trang.dao.DonViDAO;
import cntt.trang.dao.KetQuaHocTapDAO;
import cntt.trang.dao.KyNangDAO;
import cntt.trang.dao.NganhDaoTaoDAO;
import cntt.trang.dao.QuangBaDAO;
import cntt.trang.dao.SinhVienDAO;
import cntt.trang.dao.ThongBaoDAO;
import cntt.trang.dao.VNCharacterUtils;
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
	 		SinhVienDAO sinhVienDAO= new SinhVienDAO();
	 		
	 		
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		model.addAttribute("dsNganhDaoTao", nganhDaoTaoDAO.getAllNganhDaoTao());
	 		model.addAttribute("dssinhvien", sinhVienDAO.timKiemAllSinhVien());
	 		model.addAttribute("nganhDaoTaoDAO", nganhDaoTaoDAO);
	 		
	 		
	    	return "sinhvien/timkiemsinhvien";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/timkiem"}, method=RequestMethod.POST)
    public void timKiemSinhVien(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String key= request.getParameter("key");
	 		String nam= request.getParameter("nam");
	 		String maNganhDaoTao= request.getParameter("maNganhDaoTao");
	 		String loaiGPA= request.getParameter("loaiGPA");
	 		SinhVienDAO sinhVienDAO=new SinhVienDAO();
	 		
	 		ArrayList<TimKiemSV> dssv;
	 		Set<TimKiemSV> ds=new HashSet<TimKiemSV>();
	 		if(!key.equals("")) {
	 			String keys[] =key.split(" ");
	 			for(int i=0; i< keys.length;i++) {
	 				ds.addAll(sinhVienDAO.timKiemSinhVien(VNCharacterUtils.removeAccent(keys[i]) , Integer.parseInt(nam), maNganhDaoTao, Integer.parseInt(loaiGPA)));
	 			}
	 			dssv=new ArrayList<TimKiemSV>();
	 			for (TimKiemSV sv : ds) {
					dssv.add(sv);
				}
	 		}
	 		else dssv=sinhVienDAO.timKiemSinhVien(VNCharacterUtils.removeAccent(key), Integer.parseInt(nam), maNganhDaoTao, Integer.parseInt(loaiGPA));
	 		
	 		for (TimKiemSV timKiemSV : dssv) {
				System.out.println(timKiemSV.getHoVaTen());
				
			}
	 		PrintWriter out=response.getWriter();
	 		if(dssv.isEmpty()) 
	 			out.print("<h4 style=\"color: #c0c0c0;\">Không có sinh viên nào thoả mãn yêu cầu tìm kiếm</h4>");
	 		else
	 			for (TimKiemSV sv : dssv) {
					out.print("<div class=\"sinhvien\" >\r\n" + 
							"	            <h5><a href=\"/sinhvien/CV/id?id="+sv.getMaSinhVien() +"\">"+sv.getHoVaTen()+" </a></h5>\r\n" + 
							"	            <div><b> Ngành đào tạo:</b> "+sv.getTenNganh() +"</div>\r\n" + 
							"	            <div><b>GPA:</b> "+sv.getGPA()+" </div>\r\n" + 
							"        	</div>");
				}
		} catch (Exception e) {
			e.printStackTrace();
			
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
	 		
//	 		String result = "";
//	        HttpPost post = new HttpPost("http://ums-dev.husc.edu.vn/apigateway/account/v1/authorize/student");
//	        StringBuilder json = new StringBuilder();
//	        json.append("{");
//	        json.append("\"UserName\":\"18T1021198\",");
//	        json.append("\"Password\":\"b027a4ee25b6cfde014f2083563929fa\"");
//	        json.append("}");
//	        post.setEntity(new StringEntity(json.toString()));
//	        
//	        post.addHeader("Content-Type", "application/json");
//	        post.addHeader("ums-application", "TestApp");
//	        post.addHeader("ums-time", "20220401230000");
//	        post.addHeader("ums-signature", "1adcbf88065227d7c8cdbaf25be7aa00");
//	        
//	        
//	        try (CloseableHttpClient httpClient = HttpClients.createDefault();
//	                CloseableHttpResponse res = httpClient.execute(post)) {
//
//	               result = EntityUtils.toString(res.getEntity());
//	           }
//
//	           System.out.println(result);
	 		if(sinhVienDAO.KiemTraDangNhap(maSinhVien)!= null) {
	 			SinhVien sinhvien= sinhVienDAO.KiemTraDangNhap(maSinhVien);
	 			session.setAttribute("sinhvien",sinhvien);
	 			
	 			return "redirect:/trangchu";
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
	 		return "redirect:/trangchu";
	 		
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
	 		CVDAO cvdao = new CVDAO();
	 		KyNangDAO kyNangDAO= new KyNangDAO();
	 		DonViDAO donViDAO= new DonViDAO();
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		ChungChiDAO chungChiDAO=new ChungChiDAO();
	 		
	 		ArrayList<ChungChi> chungChis= chungChiDAO.getAllChungChiByMaCV(sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> hocVans= donViDAO.getAllDonViByMucCVAndMaCV("hocvan", sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> kinhNghiems= donViDAO.getAllDonViByMucCVAndMaCV("kinhnghiemlamviec", sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> hoatDongs= donViDAO.getAllDonViByMucCVAndMaCV("hoatdong", sinhVien.getMaSinhVien());
	 		ArrayList<KyNang> kynangs= kyNangDAO.getAllKyNangByMaCV(sinhVien.getMaSinhVien());
	 		CV cv=cvdao.getCVByMaSinhVien(sinhVien.getMaSinhVien());
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		model.addAttribute("sinhVien", sinhVien);
	 		model.addAttribute("cv", cv);
	 		model.addAttribute("kynangs", kynangs);
	 		model.addAttribute("hocVans", hocVans);
	 		model.addAttribute("kinhNghiems", kinhNghiems);
	 		model.addAttribute("hoatDongs", hoatDongs);
	 		model.addAttribute("viTriDAO", viTriDAO);
	 		model.addAttribute("chungChis", chungChis);
	 		
	 		return "sinhvien/CV/show";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/CV/id"}, method=RequestMethod.GET)
    public String xemCV(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		SinhVienDAO sinhVienDAO= new SinhVienDAO();
	 		String maSinhVien= request.getParameter("id");
	 		SinhVien sinhVien= sinhVienDAO.getSinhVienByMaSinhVien(maSinhVien);
	 		CVDAO cvdao = new CVDAO();
	 		KyNangDAO kyNangDAO= new KyNangDAO();
	 		DonViDAO donViDAO= new DonViDAO();
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		ChungChiDAO chungChiDAO=new ChungChiDAO();
	 		
	 		ArrayList<ChungChi> chungChis= chungChiDAO.getAllChungChiByMaCV(sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> hocVans= donViDAO.getAllDonViByMucCVAndMaCV("hocvan", sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> kinhNghiems= donViDAO.getAllDonViByMucCVAndMaCV("kinhnghiemlamviec", sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> hoatDongs= donViDAO.getAllDonViByMucCVAndMaCV("hoatdong", sinhVien.getMaSinhVien());
	 		ArrayList<KyNang> kynangs= kyNangDAO.getAllKyNangByMaCV(sinhVien.getMaSinhVien());
	 		CV cv=cvdao.getCVByMaSinhVien(sinhVien.getMaSinhVien());
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		model.addAttribute("sinhVien", sinhVien);
	 		model.addAttribute("cv", cv);
	 		model.addAttribute("kynangs", kynangs);
	 		model.addAttribute("hocVans", hocVans);
	 		model.addAttribute("kinhNghiems", kinhNghiems);
	 		model.addAttribute("hoatDongs", hoatDongs);
	 		model.addAttribute("viTriDAO", viTriDAO);
	 		model.addAttribute("chungChis", chungChis);
	 		
	 		return "sinhvien/CV/xem";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/diem/id"}, method=RequestMethod.GET)
    public String xemDiem(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		KetQuaHocTapDAO ketQuaHocTapDAO= new KetQuaHocTapDAO();
	 		SinhVienDAO sinhVienDAO=new SinhVienDAO();
	 		NganhDaoTaoDAO nganhDaoTaoDAO=new NganhDaoTaoDAO();
	 		
	 		String maSinhVien=request.getParameter("id");
	 		SinhVien sinhVien=sinhVienDAO.getSinhVienByMaSinhVien(maSinhVien);
	 		int khoa=sinhVien.getKhoa();
	 		NganhDaoTao nganhDaoTao=nganhDaoTaoDAO.getNganhDaoTaoById(sinhVien.getMaNganhDaoTao());
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		
	 		model.addAttribute("ketQuas", ketQuaHocTapDAO.getAllKetQuaHocTapByMaSinhVien(maSinhVien));
	 		model.addAttribute("maSinhVien",maSinhVien);
	 		model.addAttribute("khoa", "Khoa "+khoa+" ("+(khoa+1976)+"-"+(khoa+1976+nganhDaoTao.getNamDaoTao())+")");
	 		model.addAttribute("nganh", nganhDaoTao.getTenNganh().toUpperCase());
	 		model.addAttribute("soTinChi", ketQuaHocTapDAO.getSumSoTinChiByMaSinhVien(maSinhVien));
	 		model.addAttribute("GPA", ketQuaHocTapDAO.getGPAByMaSinhVien(maSinhVien));
	 		return "sinhvien/diem";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/suaCV"}, method=RequestMethod.GET)
    public String taoCV(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		SinhVien sinhVien= (SinhVien)session.getAttribute("sinhvien");
	 		CVDAO cvdao = new CVDAO();
	 		KyNangDAO kyNangDAO= new KyNangDAO();
	 		DonViDAO donViDAO= new DonViDAO();
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		ChungChiDAO chungChiDAO=new ChungChiDAO();
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		ArrayList<DonVi> hocVans=donViDAO.getAllDonViByMucCVAndMaCV("hocvan", sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> kinhNghiems=donViDAO.getAllDonViByMucCVAndMaCV("kinhnghiemlamviec", sinhVien.getMaSinhVien());
	 		ArrayList<DonVi> hoatDongs=donViDAO.getAllDonViByMucCVAndMaCV("hoatdong", sinhVien.getMaSinhVien());
	 		ArrayList<ViTri> viTris=new ArrayList<ViTri>();
	 		ArrayList<ViTri> viTriTam= null;
	 		for (DonVi h : hocVans) {
				System.out.println(h.getTenDonVi());
			}
	 		for (DonVi h : kinhNghiems) {
				System.out.println(h.getTenDonVi());
			}
	 		for (DonVi h : hoatDongs) {
				System.out.println(h.getTenDonVi());
			}
	 		for (DonVi dv : hocVans) {
				viTriTam=viTriDAO.getAllViTriByMaDonVi(dv.getMaDonVi());
				for (ViTri viTri : viTriTam) {
					viTris.add(viTri);
					System.out.println(viTri.getTenViTri());
				}
			}
	 		for (DonVi dv : kinhNghiems) {
				viTriTam=viTriDAO.getAllViTriByMaDonVi(dv.getMaDonVi());
				for (ViTri viTri : viTriTam) {
					viTris.add(viTri);
					System.out.println(viTri.getTenViTri());
				}
			}
	 		for (DonVi dv : hoatDongs) {
				viTriTam=viTriDAO.getAllViTriByMaDonVi(dv.getMaDonVi());
				for (ViTri viTri : viTriTam) {
					viTris.add(viTri);
					System.out.println(viTri.getTenViTri());
				}
			}
	 		
	 		
	 		
	 		session.setAttribute("hocVans",hocVans );
	 		session.setAttribute("hoatDongs", hoatDongs);
	 		session.setAttribute("kinhNghiems",kinhNghiems );
	 		session.setAttribute("viTris", viTris);
	 		session.setAttribute("kyNangs", kyNangDAO.getAllKyNangByMaCV(sinhVien.getMaSinhVien()));
	 		session.setAttribute("chungChis", chungChiDAO.getAllChungChiByMaCV(sinhVien.getMaSinhVien()));
	 		session.setAttribute("cv", cvdao.getCVByMaSinhVien(sinhVien.getMaSinhVien()));
	 		
	 		model.addAttribute("sinhVien", sinhVien);
	 		model.addAttribute("viTriDAO", viTriDAO);
	 		
	 		
	 		return "sinhvien/CV/sua";
	 		
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/suaCV"}, method=RequestMethod.POST)
    public String suaCV(@RequestParam("avatar") CommonsMultipartFile anhDaiDien,@RequestParam("position") String viTriUngTuyen,
    		@RequestParam("soThich") String soThich,
    		 @RequestParam("mucTieuNgheNghiep") String mucTieuNgheNghiep, @RequestParam("showKyNang") String showKyNang, 
    		 @RequestParam("showSoThich") String showSoThich, @RequestParam("showChungChi") String showChungChi, 
    		 @RequestParam("showMucTieuNgheNghiep") String showMucTieuNgheNghiep, @RequestParam("showHocVan") String showHocVan, 
    		 @RequestParam("showKinhNghiemLamViec") String showKinhNghiemLamViec, @RequestParam("showHoatDong") String showHoatDong, 
    		Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response, RedirectAttributes redirectAttributes) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		ArrayList<KyNang> kyNangs=(ArrayList<KyNang>)session.getAttribute("kyNangs");
	 		ArrayList<ChungChi> chungChis=(ArrayList<ChungChi>)session.getAttribute("chungChis");
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hocVans=(ArrayList<DonVi>)session.getAttribute("hocVans");
	 		ArrayList<DonVi> kinhNghiems=(ArrayList<DonVi>)session.getAttribute("kinhNghiems");
	 		ArrayList<DonVi> hoatDongs=(ArrayList<DonVi>)session.getAttribute("hoatDongs");
	 		
	 		
	 		
	 		
	 		String anh="";
	 		if(!anhDaiDien.getOriginalFilename().equals("")) {
	 			String absolutefilePath=request.getServletContext().getRealPath("/image");
				File dir = new File(absolutefilePath);
				if(!dir.exists()) {
					dir.mkdirs();
				}
	 			byte[] bytes=anhDaiDien.getBytes();
				Date date=new Date();
				String name="anh"+sinhVien.getMaSinhVien()+anhDaiDien.getOriginalFilename().substring(anhDaiDien.getOriginalFilename().indexOf("."));
				File uploadfile=new File(dir.getAbsolutePath()+"\\"+name);
				BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(uploadfile));
				outputStream.write(bytes);
				outputStream.close();
				anh ="image/"+name;
	 		}
	 		
	 		CVDAO cvdao= new CVDAO();
	 		SinhVienDAO sinhVienDAO= new SinhVienDAO();
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		DonViDAO donViDAO=new DonViDAO();
	 		KyNangDAO kyNangDAO=new KyNangDAO();
	 		ChungChiDAO chungChiDAO=new ChungChiDAO();
	 		
			CV cv=cvdao.getCVByMaSinhVien(sinhVien.getMaSinhVien());
			cvdao.updateCV(sinhVien.getMaSinhVien(), viTriUngTuyen, soThich, mucTieuNgheNghiep, showKyNang.equals("1")?true:false, showChungChi.equals("1")?true:false, showSoThich.equals("1")?true:false, showMucTieuNgheNghiep.equals("1")?true:false, showHocVan.equals("1")?true:false, showKinhNghiemLamViec.equals("1")?true:false, showHoatDong.equals("1")?true:false);
			if(!anhDaiDien.getOriginalFilename().equals("")) {
				sinhVienDAO.updateAnhDaiDien(anh, sinhVien.getMaSinhVien());
				sinhVien.setAnhDaiDien(anh);
				session.removeAttribute("sinhvien");
		 		session.setAttribute("sinhvien", sinhVien);
			}
			
			viTriDAO.deleteAllViTriByMaCV(sinhVien.getMaSinhVien());
			donViDAO.deleteAllDonViByMaCV(sinhVien.getMaSinhVien());
			kyNangDAO.deleteAllKyNangByMaCV(sinhVien.getMaSinhVien());
			chungChiDAO.deleteAllChungChiByMaCV(sinhVien.getMaSinhVien());
			
			for (KyNang kn : kyNangs) {
				kyNangDAO.insertKyNang(kn.getTenKyNang(), kn.getDoThanhThao(), kn.getMaCV());
			}
			for (ChungChi cc : chungChis) {
				chungChiDAO.insertChungChi(cc.getTenChungChi(), cc.getNam(), cc.getMaCV());
			}
			for (DonVi donVi : hocVans) {
				donViDAO.insertDonVi(donVi.getTenDonVi(), donVi.getMaCV(), donVi.getMucCV());
				long maDonVi=0;
				for(DonVi dv:donViDAO.getAllDonVi())
					if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
				for (ViTri vt : viTris) {
					if(vt.getMaDonVi()==donVi.getMaDonVi()) 
						viTriDAO.insertViTri(vt.getTenViTri(), vt.getKhoangThoiGian(), maDonVi, vt.getMoTa());	
				}
			}
			for (DonVi donVi : kinhNghiems) {
				donViDAO.insertDonVi(donVi.getTenDonVi(), donVi.getMaCV(), donVi.getMucCV());
				long maDonVi=0;
				for(DonVi dv:donViDAO.getAllDonVi())
					if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
				for (ViTri vt : viTris) {
					if(vt.getMaDonVi()==donVi.getMaDonVi()) 
						viTriDAO.insertViTri(vt.getTenViTri(), vt.getKhoangThoiGian(), maDonVi, vt.getMoTa());	
				}
			}
			for (DonVi donVi : hoatDongs) {
				donViDAO.insertDonVi(donVi.getTenDonVi(), donVi.getMaCV(), donVi.getMucCV());
				long maDonVi=0;
				for(DonVi dv:donViDAO.getAllDonVi())
					if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
				for (ViTri vt : viTris) {
					if(vt.getMaDonVi()==donVi.getMaDonVi()) 
						viTriDAO.insertViTri(vt.getTenViTri(), vt.getKhoangThoiGian(), maDonVi, vt.getMoTa());	
				}
			}
			
			
			session.removeAttribute("hocVans");
			session.removeAttribute("hoatDongs");
			session.removeAttribute("kinhNghiems");
			session.removeAttribute("kyNangs");
			session.removeAttribute("chungChis");
			session.removeAttribute("cv");
			session.removeAttribute("viTris");
			
			return "redirect:/sinhvien/CV";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
    @RequestMapping(value= {"/suaCV/addkynang"}, method=RequestMethod.POST)
    public void addKyNang(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		KyNangDAO kyNangDAO= new KyNangDAO();
	 		String tenKyNang= request.getParameter("tenKyNang");
	 		String doThanhThao= request.getParameter("doThanhThao");
	 		
	 		ArrayList<KyNang> kyNangs=(ArrayList<KyNang>)session.getAttribute("kyNangs");
	 		SinhVien sinhvien=(SinhVien)session.getAttribute("sinhvien");
	 		long maKyNang=0;
	 		for (KyNang kn : kyNangDAO.getAllKyNang()) {
				if(kn.getMaKyNang()>maKyNang) maKyNang=kn.getMaKyNang();
			}
	 		kyNangs.add(new KyNang(maKyNang+1, tenKyNang, Integer.parseInt(doThanhThao), sinhvien.getMaSinhVien()));
	 		session.removeAttribute("kyNangs");
	 		session.setAttribute("kyNangs", kyNangs);
	 		PrintWriter out=response.getWriter();
	 		
	 		for (KyNang kn : kyNangs) {
	 			System.out.println(kn.getMaKyNang()+ " - "+kn.getTenKyNang()+" - "+kn.getDoThanhThao());
	 		}
	 		for (KyNang kn : kyNangs) {
				out.print("<div class=\"row mb-1\">\r\n" + 
						"	                                <div class=\"col-6\">\r\n" + 
							                                    kn.getTenKyNang()+ 
						"	                                </div>\r\n" + 
						"	                                <div class=\"col-5\">\r\n" + 
						"	                                    Thành thạo: "+ kn.getDoThanhThao() +"/10\r\n" + 
						"	                                </div>\r\n" + 
						"	                                <div class=\"col-1\">\r\n" + 
						"	                                    <i class=\"fas fa-trash-alt trash\" onclick=\"deleteKyNang('"+kn.getMaKyNang()+"')\"></i>" + 
						"	                                </div>\r\n" + 
						"	                            </div>");
			}
	 		out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalKynang\"><i\r\n" + 
	 				"                                    class=\"fas fa-plus-square\"></i>Thêm kỹ năng</a>");
	 		
		} catch (Exception e) {
			e.getStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deletekynang"}, method=RequestMethod.POST)
    public void deleteKyNang(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maKyNang= request.getParameter("maKyNang");
	 		
	 		ArrayList<KyNang> kyNangs=(ArrayList<KyNang>)session.getAttribute("kyNangs");
	 		
	 		KyNang kyNang = null;
	 		for (KyNang kn : kyNangs) {
				if(kn.getMaKyNang()==Long.parseLong(maKyNang)) kyNang=kn;
			}
	 		kyNangs.remove(kyNang);
	 		session.removeAttribute("kyNangs");
	 		session.setAttribute("kyNangs", kyNangs);
	 		for (KyNang kn : kyNangs) {
	 			System.out.println(kn.getMaKyNang()+ " - "+kn.getTenKyNang()+" - "+kn.getDoThanhThao());
	 		}
	 		System.out.println("ok");
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!kyNangs.isEmpty()) {
				for (KyNang kn : kyNangs) { 
					out.print("<div class=\"row mb-1\">\r\n" + 
							"	                                <div class=\"col-6\">\r\n" + 
							kn.getTenKyNang()+ 
							"	                                </div>\r\n" + 
							"	                                <div class=\"col-5\">\r\n" + 
							"	                                    Thành thạo: "+ kn.getDoThanhThao() +"/10\r\n" + 
							"	                                </div>\r\n" + 
							"	                                <div class=\"col-1\">\r\n" + 
							"	                                    <i class=\"fas fa-trash-alt trash\" onclick=\"deleteKyNang('"+kn.getMaKyNang()+"')\"></i>" + 
							"	                                </div>\r\n" + 
							"	                            </div>"); 
				}
				
	 		}
	 			
	 		out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalKynang\"><i\r\n" + 
	 				"                                    class=\"fas fa-plus-square\"></i>Thêm kỹ năng</a>");
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/addChungChi"}, method=RequestMethod.POST)
    public void addChungChi(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		ChungChiDAO chungChiDAO = new ChungChiDAO();
	 		String tenChungChi= request.getParameter("tenChungChi");
	 		String nam= request.getParameter("nam");
	 		
	 		ArrayList<ChungChi> chungChis=(ArrayList<ChungChi>)session.getAttribute("chungChis");
	 		SinhVien sinhvien=(SinhVien)session.getAttribute("sinhvien");
	 		long maChungChi=0;
	 		for (ChungChi cc : chungChiDAO.getAllChungChi()) {
				if(cc.getMaChungChi()>maChungChi) maChungChi=cc.getMaChungChi();
			}
	 		chungChis.add(new ChungChi(maChungChi+1, tenChungChi, nam, sinhvien.getMaSinhVien()));
	 		session.removeAttribute("chungChis");
	 		session.setAttribute("chungChis", chungChis);
	 		PrintWriter out=response.getWriter();
	 		
	 		
	 		for (ChungChi cc : chungChis) {
				out.print("<div class=\"row mb-1\">\r\n" + 
						"	                                <div class=\"col-6\">\r\n" + cc.getTenChungChi() + 
						"	                                </div>\r\n" + 
						"	                                <div class=\"col-5\">\r\n" + 
						"	                                    Năm:  "+cc.getNam() + 
						"	                                </div>\r\n" + 
						"	\r\n" + 
						"	                                <div class=\"col-1\">\r\n" + 
						"	                                    <i class=\"fas fa-trash-alt trash\" onclick=\"deleteChungChi('"+cc.getMaChungChi()+"')\"></i>\r\n" + 
						"	                                </div>\r\n" + 
						"	                            </div>");
			}
	 		out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalChungchi\"><i\r\n" + 
	 				"                                    class=\"fas fa-plus-square\"></i>Thêm chứng chỉ</a>");
	 		
		} catch (Exception e) {
			e.getStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deleteChungChi"}, method=RequestMethod.POST)
    public void deleteChungChi(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maChungChi= request.getParameter("maChungChi");
	 		
	 		ArrayList<ChungChi> chungChis=(ArrayList<ChungChi>)session.getAttribute("chungChis");
	 		
	 		ChungChi chungChi = null;
	 		for (ChungChi cc : chungChis) {
				if(cc.getMaChungChi()==Long.parseLong(maChungChi)) chungChi=cc;
			}
	 		chungChis.remove(chungChi);
	 		session.removeAttribute("chungChis");
	 		session.setAttribute("chungChis", chungChis);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!chungChis.isEmpty()) {
	 			for (ChungChi cc : chungChis) {
					out.print("<div class=\"row mb-1\">\r\n" + 
							"	                                <div class=\"col-6\">\r\n" + cc.getTenChungChi() + 
							"	                                </div>\r\n" + 
							"	                                <div class=\"col-5\">\r\n" + 
							"	                                    Năm:  "+cc.getNam() + 
							"	                                </div>\r\n" + 
							"	\r\n" + 
							"	                                <div class=\"col-1\">\r\n" + 
							"	                                    <i class=\"fas fa-trash-alt trash\" onclick=\"deleteChungChi('"+cc.getMaChungChi()+"')\"></i>\r\n" + 
							"	                                </div>\r\n" + 
							"	                            </div>");
				}
	 		}
	 			
	 		out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalChungchi\"><i\r\n" + 
	 				"                                    class=\"fas fa-plus-square\"></i>Thêm chứng chỉ</a>");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/addViTriHocVan"}, method=RequestMethod.POST)
    public void addViTriHocVan(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String tenViTri= request.getParameter("viTri");
	 		String khoangThoiGian= request.getParameter("khoangThoiGian");
	 		String moTa= request.getParameter("moTa");
	 		String maDonVi= request.getParameter("maDonVi");
	 		
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hocVans=(ArrayList<DonVi>)session.getAttribute("hocVans");
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		
	 		long maViTri=0;
	 		for (ViTri vt : viTriDAO.getAllViTri()) {
				if(vt.getMaViTri()>maViTri) maViTri=vt.getMaViTri();
			}
	 		for (ViTri vt : viTris) {
	 			if(vt.getMaViTri()>maViTri) maViTri=vt.getMaViTri();
			}
	 		viTris.add(new ViTri(maViTri+1, tenViTri, khoangThoiGian, Long.parseLong(maDonVi), moTa));
	 		
	 		
	 		for (DonVi donVi : hocVans) {
				System.out.println(donVi.getMaDonVi()+" - "+donVi.getTenDonVi());
			}
	 		System.out.println("--------------------------");
	 		for (ViTri vt : viTris) {
				System.out.println(vt.getMaDonVi()+" - "+vt.getMaViTri()+" - "+vt.getTenViTri()+" - "+vt.getKhoangThoiGian()+" - "+vt.getMoTa());
			}
	 		System.out.println("--------------------------");
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hocVans.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hv : hocVans) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hv.getTenDonVi()+"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHocVan('"+hv.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hv.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\"> <b><i>"+vt.getTenViTri() +"</i></b> "+
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa() + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHocVan('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHocVan"+hv.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm ngành, vị trí học tập</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHocVan"+hv.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Học Vấn</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHocVan"+hv.getMaDonVi() +"\" placeholder=\"Sinh viên ngành Công nghệ thông tin\">\r\n" + 
							"								                                    	<small id=\"errorViTriHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtKhoangThoiGianHocVan"+hv.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHocVan"+hv.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHocVan('"+hv.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/addViTriLamViec"}, method=RequestMethod.POST)
    public void addViTriLamViec(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String tenViTri= request.getParameter("viTri");
	 		String khoangThoiGian= request.getParameter("khoangThoiGian");
	 		String moTa= request.getParameter("moTa");
	 		String maDonVi= request.getParameter("maDonVi");
	 		
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> kinhNghiems=(ArrayList<DonVi>)session.getAttribute("kinhNghiems");
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		
	 		long maViTri=0;
	 		for (ViTri vt : viTriDAO.getAllViTri()) {
				if(vt.getMaViTri()>maViTri) maViTri=vt.getMaViTri();
			}
	 		for (ViTri vt : viTris) {
	 			if(vt.getMaViTri()>maViTri) maViTri=vt.getMaViTri();
			}
	 		viTris.add(new ViTri(maViTri+1, tenViTri, khoangThoiGian, Long.parseLong(maDonVi), moTa));
	 		
	 		
	 		for (DonVi donVi : kinhNghiems) {
				System.out.println(donVi.getMaDonVi()+" - "+donVi.getTenDonVi());
			}
	 		System.out.println("--------------------------");
	 		for (ViTri vt : viTris) {
				System.out.println(vt.getMaDonVi()+" - "+vt.getMaViTri()+" - "+vt.getTenViTri()+" - "+vt.getKhoangThoiGian()+" - "+vt.getMoTa());
			}
	 		System.out.println("--------------------------");
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!kinhNghiems.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi kn : kinhNghiems) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+kn.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteKinhNghiem('"+kn.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==kn.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriLamViec('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriLamViec"+kn.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm vị trí, chức vụ làm việc</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Lam Viec-->\r\n" + 
							"							                <div class=\"modal\" id=\"myModalViTriLamViec"+kn.getMaDonVi() +"\">\r\n" + 
							"							                    <div class=\"modal-dialog\">\r\n" + 
							"							                        <div class=\"modal-content\">\r\n" + 
							"							                            <!-- Modal Header -->\r\n" + 
							"							                            <div class=\"modal-header\">\r\n" + 
							"							                                <h4 class=\"modal-title\">Thêm Vị Trí Làm Việc</h4>\r\n" + 
							"							                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"							                            </div>\r\n" + 
							"							                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriLamViec"+kn.getMaDonVi() +"\" placeholder=\"Trưởng phòng nhân sự\">\r\n" + 
							"								                                    	<small id=\"errorViTriLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianLamViec"+kn.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaLamViec"+kn.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriLamViec('"+kn.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"							                        </div>\r\n" + 
							"							                    </div>\r\n" + 
							"							                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/addViTriHoatDong"}, method=RequestMethod.POST)
    public void addViTriHoatDong(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String tenViTri= request.getParameter("viTri");
	 		String khoangThoiGian= request.getParameter("khoangThoiGian");
	 		String moTa= request.getParameter("moTa");
	 		String maDonVi= request.getParameter("maDonVi");
	 		
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hoatDongs=(ArrayList<DonVi>)session.getAttribute("hoatDongs");
	 		ViTriDAO viTriDAO=new ViTriDAO();
	 		
	 		long maViTri=0;
	 		for (ViTri vt : viTriDAO.getAllViTri()) {
				if(vt.getMaViTri()>maViTri) maViTri=vt.getMaViTri();
			}
	 		for (ViTri vt : viTris) {
	 			if(vt.getMaViTri()>maViTri) maViTri=vt.getMaViTri();
			}
	 		viTris.add(new ViTri(maViTri+1, tenViTri, khoangThoiGian, Long.parseLong(maDonVi), moTa));
	 		
	 		
	 		for (DonVi donVi : hoatDongs) {
				System.out.println(donVi.getMaDonVi()+" - "+donVi.getTenDonVi());
			}
	 		System.out.println("--------------------------");
	 		for (ViTri vt : viTris) {
				System.out.println(vt.getMaDonVi()+" - "+vt.getMaViTri()+" - "+vt.getTenViTri()+" - "+vt.getKhoangThoiGian()+" - "+vt.getMoTa());
			}
	 		System.out.println("--------------------------");
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hoatDongs.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hd : hoatDongs) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hd.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHoatDong('"+hd.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hd.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian()  + 
									"				                                        </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHoatDong('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHoatDong"+hd.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm nhóm, bộ phận, chức vụ hoạt động</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHoatDong"+hd.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Hoạt Động</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHoatDong"+hd.getMaDonVi() +"\" placeholder=\"Trưởng ban văn nghệ\">\r\n" + 
							"								                                    	<small id=\"errorViTriHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianHoatDong"+hd.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHoatDong"+hd.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHoatDong('"+hd.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/addTruongHoc"}, method=RequestMethod.POST)
    public void addTruongHoc(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String tenDonVi= request.getParameter("tenDonVi");

	 		System.out.println(tenDonVi);
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hocVans=(ArrayList<DonVi>)session.getAttribute("hocVans");
	 		ArrayList<DonVi> kinhNghiems=(ArrayList<DonVi>)session.getAttribute("kinhNghiems");
	 		ArrayList<DonVi> hoatDongs=(ArrayList<DonVi>)session.getAttribute("hoatDongs");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		DonViDAO donViDAO=new DonViDAO();
	 		
	 		long maDonVi=0;
	 		for (DonVi dv : donViDAO.getAllDonVi()) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : hocVans) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : kinhNghiems) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : hoatDongs) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		hocVans.add(new DonVi(maDonVi+1, tenDonVi, sinhVien.getMaSinhVien(), "hocvan"));
	 		session.removeAttribute("hocVans");
	 		session.setAttribute("hocVans", hocVans);
	 		
	 		for (DonVi donVi : hocVans) {
				System.out.println(donVi.getMaDonVi()+" - "+donVi.getTenDonVi());
			}
	 		System.out.println("--------------------------");
	 		for (ViTri vt : viTris) {
				System.out.println(vt.getMaDonVi()+" - "+vt.getMaViTri()+" - "+vt.getTenViTri()+" - "+vt.getKhoangThoiGian()+" - "+vt.getMoTa());
			}
	 		System.out.println("--------------------------");
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hocVans.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hv : hocVans) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hv.getTenDonVi()+"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHocVan('"+hv.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hv.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\"> <b><i>"+vt.getTenViTri() +"</i></b> "+
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa() + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHocVan('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHocVan"+hv.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm ngành, vị trí học tập</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHocVan"+hv.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Học Vấn</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHocVan"+hv.getMaDonVi() +"\" placeholder=\"Sinh viên ngành Công nghệ thông tin\">\r\n" + 
							"								                                    	<small id=\"errorViTriHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtKhoangThoiGianHocVan"+hv.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHocVan"+hv.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHocVan('"+hv.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/addCongTy"}, method=RequestMethod.POST)
    public void addCongTy(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String tenDonVi= request.getParameter("tenDonVi");

	 		System.out.println(tenDonVi);
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hocVans=(ArrayList<DonVi>)session.getAttribute("hocVans");
	 		ArrayList<DonVi> kinhNghiems=(ArrayList<DonVi>)session.getAttribute("kinhNghiems");
	 		ArrayList<DonVi> hoatDongs=(ArrayList<DonVi>)session.getAttribute("hoatDongs");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		DonViDAO donViDAO=new DonViDAO();
	 		
	 		long maDonVi=0;
	 		for (DonVi dv : donViDAO.getAllDonVi()) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : hocVans) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : kinhNghiems) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : hoatDongs) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		kinhNghiems.add(new DonVi(maDonVi+1, tenDonVi, sinhVien.getMaSinhVien(), "kinhnghiemlamviec"));
	 		session.removeAttribute("kinhNghiems");
	 		session.setAttribute("kinhNghiems", kinhNghiems);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!kinhNghiems.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi kn : kinhNghiems) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+kn.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteKinhNghiem('"+kn.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==kn.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriLamViec('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriLamViec"+kn.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm vị trí, chức vụ làm việc</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Lam Viec-->\r\n" + 
							"							                <div class=\"modal\" id=\"myModalViTriLamViec"+kn.getMaDonVi() +"\">\r\n" + 
							"							                    <div class=\"modal-dialog\">\r\n" + 
							"							                        <div class=\"modal-content\">\r\n" + 
							"							                            <!-- Modal Header -->\r\n" + 
							"							                            <div class=\"modal-header\">\r\n" + 
							"							                                <h4 class=\"modal-title\">Thêm Vị Trí Làm Việc</h4>\r\n" + 
							"							                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"							                            </div>\r\n" + 
							"							                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriLamViec"+kn.getMaDonVi() +"\" placeholder=\"Trưởng phòng nhân sự\">\r\n" + 
							"								                                    	<small id=\"errorViTriLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianLamViec"+kn.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaLamViec"+kn.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriLamViec('"+kn.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"							                        </div>\r\n" + 
							"							                    </div>\r\n" + 
							"							                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/addHoatDong"}, method=RequestMethod.POST)
    public void addHoatDong(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String tenDonVi= request.getParameter("tenDonVi");

	 		System.out.println(tenDonVi);
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hocVans=(ArrayList<DonVi>)session.getAttribute("hocVans");
	 		ArrayList<DonVi> kinhNghiems=(ArrayList<DonVi>)session.getAttribute("kinhNghiems");
	 		ArrayList<DonVi> hoatDongs=(ArrayList<DonVi>)session.getAttribute("hoatDongs");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		DonViDAO donViDAO=new DonViDAO();
	 		
	 		long maDonVi=0;
	 		for (DonVi dv : donViDAO.getAllDonVi()) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : hocVans) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : kinhNghiems) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		for (DonVi dv : hoatDongs) {
				if(dv.getMaDonVi()>maDonVi) maDonVi=dv.getMaDonVi();
			}
	 		hoatDongs.add(new DonVi(maDonVi+1, tenDonVi, sinhVien.getMaSinhVien(), "hoatdong"));
	 		session.removeAttribute("hoatDongs");
	 		session.setAttribute("hoatDongs", hoatDongs);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hoatDongs.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hd : hoatDongs) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hd.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHoatDong('"+hd.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hd.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian()  + 
									"				                                        </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHoatDong('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHoatDong"+hd.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm nhóm, bộ phận, chức vụ hoạt động</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHoatDong"+hd.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Hoạt Động</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHoatDong"+hd.getMaDonVi() +"\" placeholder=\"Trưởng ban văn nghệ\">\r\n" + 
							"								                                    	<small id=\"errorViTriHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianHoatDong"+hd.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHoatDong"+hd.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHoatDong('"+hd.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deleteTruongHoc"}, method=RequestMethod.POST)
    public void deleteTruongHoc(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maDonVi= request.getParameter("maDonVi");

	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hocVans=(ArrayList<DonVi>)session.getAttribute("hocVans");
	 		
	 		DonVi donVi=null;
	 		for (DonVi dv : hocVans) {
				if(dv.getMaDonVi()==Long.parseLong(maDonVi)) donVi=dv;
			}
	 		hocVans.remove(donVi);
	 		
	 		ArrayList<ViTri> viTri=new ArrayList<ViTri>();
	 		for (ViTri vt : viTris) {
				if(vt.getMaDonVi()==Long.parseLong(maDonVi)) viTri.add(vt);
			}
	 		viTris.removeAll(viTri);
	 		
	 		session.removeAttribute("hocVans");
	 		session.setAttribute("hocVans", hocVans);
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		for (DonVi dv : hocVans) {
				System.out.println(dv.getMaDonVi()+" - "+dv.getTenDonVi());
			}
	 		System.out.println("--------------------------");
	 		for (ViTri vt : viTris) {
				System.out.println(vt.getMaDonVi()+" - "+vt.getMaViTri()+" - "+vt.getTenViTri()+" - "+vt.getKhoangThoiGian()+" - "+vt.getMoTa());
			}
	 		System.out.println("--------------------------");
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hocVans.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hv : hocVans) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hv.getTenDonVi()+"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHocVan('"+hv.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hv.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\"> <b><i>"+vt.getTenViTri() +"</i></b> "+
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa() + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHocVan('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHocVan"+hv.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm ngành, vị trí học tập</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHocVan"+hv.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Học Vấn</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHocVan"+hv.getMaDonVi() +"\" placeholder=\"Sinh viên ngành Công nghệ thông tin\">\r\n" + 
							"								                                    	<small id=\"errorViTriHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtKhoangThoiGianHocVan"+hv.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHocVan"+hv.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHocVan('"+hv.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deleteKinhNghiem"}, method=RequestMethod.POST)
    public void deleteKinhNghiem(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maDonVi= request.getParameter("maDonVi");

	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> kinhNghiems=(ArrayList<DonVi>)session.getAttribute("kinhNghiems");
	 		
	 		DonVi donVi=null;
	 		for (DonVi dv : kinhNghiems) {
				if(dv.getMaDonVi()==Long.parseLong(maDonVi)) donVi=dv;
			}
	 		kinhNghiems.remove(donVi);
	 		
	 		ArrayList<ViTri> viTri=new ArrayList<ViTri>();
	 		for (ViTri vt : viTris) {
				if(vt.getMaDonVi()==Long.parseLong(maDonVi)) viTri.add(vt);
			}
	 		viTris.removeAll(viTri);
	 		
	 		session.removeAttribute("kinhNghiems");
	 		session.setAttribute("kinhNghiems", kinhNghiems);
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!kinhNghiems.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi kn : kinhNghiems) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+kn.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteKinhNghiem('"+kn.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==kn.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriLamViec('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriLamViec"+kn.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm vị trí, chức vụ làm việc</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Lam Viec-->\r\n" + 
							"							                <div class=\"modal\" id=\"myModalViTriLamViec"+kn.getMaDonVi() +"\">\r\n" + 
							"							                    <div class=\"modal-dialog\">\r\n" + 
							"							                        <div class=\"modal-content\">\r\n" + 
							"							                            <!-- Modal Header -->\r\n" + 
							"							                            <div class=\"modal-header\">\r\n" + 
							"							                                <h4 class=\"modal-title\">Thêm Vị Trí Làm Việc</h4>\r\n" + 
							"							                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"							                            </div>\r\n" + 
							"							                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriLamViec"+kn.getMaDonVi() +"\" placeholder=\"Trưởng phòng nhân sự\">\r\n" + 
							"								                                    	<small id=\"errorViTriLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianLamViec"+kn.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaLamViec"+kn.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriLamViec('"+kn.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"							                        </div>\r\n" + 
							"							                    </div>\r\n" + 
							"							                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deleteHoatDong"}, method=RequestMethod.POST)
    public void deleteHoatDong(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maDonVi= request.getParameter("maDonVi");

	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hoatDongs=(ArrayList<DonVi>)session.getAttribute("hoatDongs");
	 		
	 		DonVi donVi=null;
	 		for (DonVi dv : hoatDongs) {
				if(dv.getMaDonVi()==Long.parseLong(maDonVi)) donVi=dv;
			}
	 		hoatDongs.remove(donVi);
	 		
	 		ArrayList<ViTri> viTri=new ArrayList<ViTri>();
	 		for (ViTri vt : viTris) {
				if(vt.getMaDonVi()==Long.parseLong(maDonVi)) viTri.add(vt);
			}
	 		viTris.removeAll(viTri);
	 		
	 		session.removeAttribute("hoatDongs");
	 		session.setAttribute("hoatDongs", hoatDongs);
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hoatDongs.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hd : hoatDongs) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hd.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHoatDong('"+hd.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hd.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian()  + 
									"				                                        </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHoatDong('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHoatDong"+hd.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm nhóm, bộ phận, chức vụ hoạt động</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHoatDong"+hd.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Hoạt Động</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHoatDong"+hd.getMaDonVi() +"\" placeholder=\"Trưởng ban văn nghệ\">\r\n" + 
							"								                                    	<small id=\"errorViTriHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianHoatDong"+hd.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHoatDong"+hd.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHoatDong('"+hd.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deleteViTriHocVan"}, method=RequestMethod.POST)
    public void deleteViTriHocVan(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maViTri= request.getParameter("maViTri");
	 		System.out.println(maViTri);
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hocVans=(ArrayList<DonVi>)session.getAttribute("hocVans");
	 		
	 		ViTri viTri=null;
	 		for (ViTri vt : viTris) {
				if(vt.getMaViTri()==Long.parseLong(maViTri)) viTri=vt;
			}
	 		viTris.remove(viTri);
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		for (DonVi donVi : hocVans) {
				System.out.println(donVi.getMaDonVi()+" - "+donVi.getTenDonVi());
			}
	 		System.out.println("--------------------------");
	 		for (ViTri vt : viTris) {
				System.out.println(vt.getMaDonVi()+" - "+vt.getMaViTri()+" - "+vt.getTenViTri()+" - "+vt.getKhoangThoiGian()+" - "+vt.getMoTa());
			}
	 		System.out.println("--------------------------");
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hocVans.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hv : hocVans) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hv.getTenDonVi()+"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHocVan('"+hv.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hv.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\"> <b><i>"+vt.getTenViTri() +"</i></b> "+
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa() + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHocVan('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHocVan"+hv.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm ngành, vị trí học tập</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHocVan"+hv.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Học Vấn</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHocVan"+hv.getMaDonVi() +"\" placeholder=\"Sinh viên ngành Công nghệ thông tin\">\r\n" + 
							"								                                    	<small id=\"errorViTriHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtKhoangThoiGianHocVan"+hv.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHocVan\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHocVan"+hv.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHocVan('"+hv.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deleteViTriLamViec"}, method=RequestMethod.POST)
    public void deleteViTriLamViec(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maViTri= request.getParameter("maViTri");
	 		System.out.println(maViTri);
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> kinhNghiems=(ArrayList<DonVi>)session.getAttribute("kinhNghiems");
	 		
	 		ViTri viTri=null;
	 		for (ViTri vt : viTris) {
				if(vt.getMaViTri()==Long.parseLong(maViTri)) viTri=vt;
			}
	 		viTris.remove(viTri);
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!kinhNghiems.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi kn : kinhNghiems) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+kn.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteKinhNghiem('"+kn.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==kn.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian() + 
									"				                                        </div>\r\n" + 
									"				                                        \r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriLamViec('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriLamViec"+kn.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm vị trí, chức vụ làm việc</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Lam Viec-->\r\n" + 
							"							                <div class=\"modal\" id=\"myModalViTriLamViec"+kn.getMaDonVi() +"\">\r\n" + 
							"							                    <div class=\"modal-dialog\">\r\n" + 
							"							                        <div class=\"modal-content\">\r\n" + 
							"							                            <!-- Modal Header -->\r\n" + 
							"							                            <div class=\"modal-header\">\r\n" + 
							"							                                <h4 class=\"modal-title\">Thêm Vị Trí Làm Việc</h4>\r\n" + 
							"							                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"							                            </div>\r\n" + 
							"							                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriLamViec"+kn.getMaDonVi() +"\" placeholder=\"Trưởng phòng nhân sự\">\r\n" + 
							"								                                    	<small id=\"errorViTriLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianLamViec"+kn.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianLamViec\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaLamViec"+kn.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriLamViec('"+kn.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"							                        </div>\r\n" + 
							"							                    </div>\r\n" + 
							"							                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
    @RequestMapping(value= {"/suaCV/deleteViTriHoatDong"}, method=RequestMethod.POST)
    public void deleteViTriHoatDong(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maViTri= request.getParameter("maViTri");
	 		System.out.println(maViTri);
	 		ArrayList<ViTri> viTris=(ArrayList<ViTri>)session.getAttribute("viTris");
	 		ArrayList<DonVi> hoatDongs=(ArrayList<DonVi>)session.getAttribute("hoatDongs");
	 		
	 		ViTri viTri=null;
	 		for (ViTri vt : viTris) {
				if(vt.getMaViTri()==Long.parseLong(maViTri)) viTri=vt;
			}
	 		viTris.remove(viTri);
	 		session.removeAttribute("viTris");
	 		session.setAttribute("viTris", viTris);
	 		
	 		PrintWriter out=response.getWriter();
	 		
	 		if(!hoatDongs.isEmpty()) {
	 			out.print("<ul >");
				for (DonVi hd : hoatDongs) { 
					out.print("<li>\r\n" + 
							"			                                <div class=\"row\">\r\n" + 
							"			                                	<div class=\"col-11\">\r\n" + 
							"			                                		<b>"+hd.getTenDonVi() +"</b>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                	<div class=\"col-1\">\r\n" + 
							"			                                		<i class=\"fas fa-trash-alt trash\" onclick=\"deleteHoatDong('"+hd.getMaDonVi()+"')\"></i>\r\n" + 
							"			                                	</div>\r\n" + 
							"			                                </div>"); 
					for(ViTri vt:viTris) {
						if(vt.getMaDonVi()==hd.getMaDonVi()) {
							out.print("<div class=\"row mb-3\">\r\n" + 
									"				                                	<div class=\"col-11\">\r\n" + 
									"				                                    <div class=\"row mb-2\"    >\r\n" + 
									"				                                        <div class=\"col-9\">\r\n" + 
									"				                                           <b><i>"+vt.getTenViTri() +"</i></b> \r\n" + 
									"				                                        </div>\r\n" + 
									"				                                        <div class=\"col-3\">\r\n" + vt.getKhoangThoiGian()  + 
									"				                                        </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div style=\"margin-left: 20px;\">\r\n" + vt.getMoTa()  + 
									"				                                    </div>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                    <div class=\"col-1\">\r\n" + 
									"				                                    	<i class=\"fas fa-trash-alt trash\" onclick=\"deleteViTriHoatDong('"+vt.getMaViTri()+"')\"></i>\r\n" + 
									"				                                    </div>\r\n" + 
									"				                                </div>");
						}
					}
					out.print("<a href=\"\" data-bs-toggle=\"modal\" data-bs-target=\"#myModalViTriHoatDong"+hd.getMaDonVi() +"\"><i class=\"fas fa-plus-square\"></i> Thêm nhóm, bộ phận, chức vụ hoạt động</a>\r\n" + 
							"			                            	<!-- The Modal vi tri Hoc Van-->\r\n" + 
							"								                <div class=\"modal\" id=\"myModalViTriHoatDong"+hd.getMaDonVi() +"\">\r\n" + 
							"								                    <div class=\"modal-dialog\">\r\n" + 
							"								                        <div class=\"modal-content\">\r\n" + 
							"								                            <!-- Modal Header -->\r\n" + 
							"								                            <div class=\"modal-header\">\r\n" + 
							"								                                <h4 class=\"modal-title\">Thêm Vị Trí Hoạt Động</h4>\r\n" + 
							"								                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal body -->\r\n" + 
							"								                            <div class=\"modal-body\">\r\n" + 
							"								                                    <div class=\"mb-3 mt-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Vị trí<span class=\"required\">\r\n" + 
							"                                        												*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\"  id=\"txtViTriHoatDong"+hd.getMaDonVi() +"\" placeholder=\"Trưởng ban văn nghệ\">\r\n" + 
							"								                                    	<small id=\"errorViTriHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Khoảng thời gian<span class=\"required\">\r\n" + 
							"                                        														*</span></label>\r\n" + 
							"								                                        <input type=\"text\" class=\"form-control\" id=\"txtKhoangThoiGianHoatDong"+hd.getMaDonVi() +"\" placeholder=\"2018 - Nay\">\r\n" + 
							"								                                    	<small id=\"errorKhoangThoiGianHoatDong\" class=\"required\"></small>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                                    <div class=\"mb-3\">\r\n" + 
							"								                                        <label class=\"form-label\">Mô tả:</label>\r\n" + 
							"								                                        <textarea id=\"txtMoTaHoatDong"+hd.getMaDonVi() +"\" rows=\"5\" cols=\"20\" class=\"form-control\"></textarea>\r\n" + 
							"								                                    </div>\r\n" + 
							"								                            </div>\r\n" + 
							"								                            <!-- Modal footer -->\r\n" + 
							"								                            <div class=\"modal-footer\">\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addViTriHoatDong('"+hd.getMaDonVi() +"')\">Thêm</button>\r\n" + 
							"								                                <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
							"								                            </div>\r\n" + 
							"								                        </div>\r\n" + 
							"								                    </div>\r\n" + 
							"								                </div>\r\n" + 
							"			                            </li>");
					
				}
				out.print("</ul>");
	 		}
	 		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
}
