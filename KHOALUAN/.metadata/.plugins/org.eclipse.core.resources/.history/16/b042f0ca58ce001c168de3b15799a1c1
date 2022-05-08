package cntt.trang.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cntt.trang.bean.SinhVien;
import cntt.trang.bean.TimKiemSV;
import cntt.trang.bean.TuyenDung;
import cntt.trang.dao.DangKyTuyenDungDAO;
import cntt.trang.dao.DoanhNghiepDAO;
import cntt.trang.dao.HinhThucLamViecDAO;
import cntt.trang.dao.NganhNgheDAO;
import cntt.trang.dao.SinhVienDAO;
import cntt.trang.dao.TinhThanhDAO;
import cntt.trang.dao.TuyenDungDAO;
import cntt.trang.dao.VNCharacterUtils;

@Controller
@RequestMapping(value = "/tuyendung")
public class TuyenDungController {
	@RequestMapping(value= {"","/timkiem"}, method=RequestMethod.GET)
    public String tuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		NganhNgheDAO nganhNgheDAO=new NganhNgheDAO();
	 		HinhThucLamViecDAO hinhThucLamViecDAO=new HinhThucLamViecDAO();
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 
	 		model.addAttribute("dsNganhNghe", nganhNgheDAO.getAllNganhNghe());
	 		model.addAttribute("dsHinhThuc",hinhThucLamViecDAO.getAllHinhThucLamViec());
	 		model.addAttribute("dsTinhThanh", tinhThanhDAO.getAllTinhThanh());
	 		model.addAttribute("nganhNgheDAO", nganhNgheDAO);
	 		model.addAttribute("hinhThucLamViecDAO", hinhThucLamViecDAO);
	 		model.addAttribute("doanhNghiepDAO", doanhNghiepDAO);
	 		model.addAttribute("tinhThanhDAO", tinhThanhDAO);
	 		model.addAttribute("dangKyTuyenDungDAO", dangKyTuyenDungDAO);
	 		model.addAttribute("tuyenDungs",tuyenDungDAO.timKiemTuyenDung(1, "", -1, -1, "-1"));
	 		model.addAttribute("soPage",tuyenDungDAO.getSoPage("", -1, -1, "-1"));
	 		model.addAttribute("title", "Tuyển dụng");
	 		model.addAttribute("tuyenDungDeXuat", tuyenDungDAO.getAllTuyenDungDaDuyet());
	 		
	    	return "tuyendung/timkiemtuyendung";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/timkiem"}, method=RequestMethod.POST)
    public void timKiemTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String key= request.getParameter("key");
	 		String maNganhNghe= request.getParameter("maNganhNghe");
	 		String maHinhThuc= request.getParameter("maHinhThuc");
	 		String maKhuVuc= request.getParameter("maKhuVuc");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 		
	 		
	 		ArrayList<TuyenDung> tuyenDungs;
	 		Set<TuyenDung> ds=new HashSet<TuyenDung>();
	 		if(!key.equals("")) {
	 			String keys[] =key.split(" ");
	 			for(int i=0; i< keys.length;i++) {
	 				ds.addAll(tuyenDungDAO.timKiemTuyenDung(1,VNCharacterUtils.removeAccent(keys[i]) ,Long.parseLong(maNganhNghe), Long.parseLong(maHinhThuc), maKhuVuc));
	 			}
	 			tuyenDungs=new ArrayList<TuyenDung>();
	 			for (TuyenDung td : ds) {
	 				tuyenDungs.add(td);
				}
	 		}
	 		else tuyenDungs=tuyenDungDAO.timKiemTuyenDung(1,VNCharacterUtils.removeAccent(key) ,Long.parseLong(maNganhNghe), Long.parseLong(maHinhThuc), maKhuVuc);
	 		int soPage=tuyenDungDAO.getSoPage(VNCharacterUtils.removeAccent(key) ,Long.parseLong(maNganhNghe), Long.parseLong(maHinhThuc), maKhuVuc);
	 		
	 		PrintWriter out=response.getWriter();
	 		if(tuyenDungs.isEmpty()) 
	 			out.print("<h4 style=\"color: #c0c0c0;\">Không tìm thấy công việc nào phù hợp với yêu cầu tìm kiếm của bạn</h4>");
	 		else
	 			for (TuyenDung td : tuyenDungs) {
					out.print("<div class=\"tuyendung\" style=\"position: relative;\">\r\n" + 
							"		        <div class=\"tuyendung-container\">\r\n" + 
							"		        	<a href=\"/tuyendung/chitiet?id="+td.getMaTuyenDung() +"\" style=\"text-decoration: none; \">\r\n" + 
							"		            	<h4>"+td.getTieuDe() +"</h4>\r\n" + 
							"		            </a>\r\n" + 
							"		            <a href=\"/doanhnghiep/chitiet?id="+td.getMaDoanhNghiep() +"\"  style=\"text-decoration: none; color: black;\">\r\n" + 
							"		            	<span style=\"margin-bottom:20px;\">"+doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  +"</span>\r\n" + 
							"		            </a>\r\n" + 
							"		            <div style=\"margin: 5px 0;\">\r\n" + 
							"		            	<b><i>Tên công việc : </i></b>"+td.getTenCongViec() +" \r\n" + 
							"		            </div>\r\n" + 
							"		            \r\n" + 
							"		            <div class=\"tuyendung-item\">\r\n"); 
					if(td.getKhuVucTuyenDung().equals("00"))
						out.print("<span>Cả nước</span>");
					else out.print("<span>"+tinhThanhDAO.getTinhThanhById(td.getKhuVucTuyenDung()).getTenTinhThanh() +"</span>");
					out.print("		            	<span>"+td.getMucLuong() +"</span>\r\n" + 
							"		            	<span>Hạn đăng ký : "+td.getHanDangKy() +"</span>\r\n" + 
							"		            </div>\r\n" + 
							"		            \r\n" + 
							"		        </div>\r\n" + 
							"		        \r\n" + 
							"				<div id=\"btn-dangky\" style=\"position: absolute;bottom: 15px;right: 50px;\">\r\n");
							if(sinhVien==null) {
								out.print("<button class=\"btn btn-success\" onclick=\"alert('Bạn cần phải đăng nhập trước!')\">Đăng ký</button>\r\n");
							}else {
								if(dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sinhVien.getMaSinhVien(), td.getMaTuyenDung())==null) {
									out.print("<button class=\"btn btn-success\" onclick=\"dangKyTuyenDung("+td.getMaTuyenDung()+")\">Đăng ký</button>\r\n");
								}else if (dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sinhVien.getMaSinhVien(), td.getMaTuyenDung())!=null&&dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sinhVien.getMaSinhVien(), td.getMaTuyenDung()).isDaDuyet()) {
									out.print("<button class=\"btn btn-primary\">Đã duyệt</button>\r\n");
								}else out.print("<button class=\"btn btn-danger\" onclick=\"huyDangKy("+td.getMaTuyenDung()+")\">Huỷ đăng ký</button>\r\n");
							}
						
							out.print("		        </div>" + 
							"		    </div>");
				}
	 		if(soPage>1) {
	 			out.print("<nav aria-label=\"Page navigation example\">\r\n" + 
	 					"  <ul class=\"pagination justify-content-center\">\r\n" + 
	 					"    <li class=\"page-item disabled\">\r\n" + 
	 					"      <a class=\"page-link\" aria-label=\"Previous\">\r\n" + 
	 					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
	 					"      </a>\r\n" + 
	 					"    </li>\r\n" + 
	 					"    <li class=\"page-item active\" onclick=\"timKiemTuyenDung()\"><a class=\"page-link\" >1</a></li>\r\n");
	 		for(int i=2;i<=soPage;i++)
	 			if(i<4) out.print("<li class=\"page-item\" onclick=\"timKiemTuyenDungByPage("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 					
	 			out.print("    <li class=\"page-item\">\r\n" + 
	 					"      <a class=\"page-link\" onclick=\"timKiemTuyenDung(2)\" aria-label=\"Next\">\r\n" + 
	 					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
	 					"      </a>\r\n" + 
	 					"    </li>\r\n" + 
	 					"  </ul>\r\n" + 
	 					"</nav>");
	 		}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
	@RequestMapping(value= {"/timkiem/page"}, method=RequestMethod.POST)
    public void timKiemTuyenDungByPage(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String key= request.getParameter("key");
	 		String maNganhNghe= request.getParameter("maNganhNghe");
	 		String maHinhThuc= request.getParameter("maHinhThuc");
	 		String maKhuVuc= request.getParameter("maKhuVuc");
	 		int page= Integer.parseInt(request.getParameter("page"));
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		TuyenDungDAO tuyenDungDAO= new TuyenDungDAO();
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 		
	 		
	 		ArrayList<TuyenDung> tuyenDungs;
	 		Set<TuyenDung> ds=new HashSet<TuyenDung>();
	 		if(!key.equals("")) {
	 			String keys[] =key.split(" ");
	 			for(int i=0; i< keys.length;i++) {
	 				ds.addAll(tuyenDungDAO.timKiemTuyenDung(page,VNCharacterUtils.removeAccent(keys[i]) ,Long.parseLong(maNganhNghe), Long.parseLong(maHinhThuc), maKhuVuc));
	 			}
	 			tuyenDungs=new ArrayList<TuyenDung>();
	 			for (TuyenDung td : ds) {
	 				tuyenDungs.add(td);
				}
	 		}
	 		else tuyenDungs=tuyenDungDAO.timKiemTuyenDung(page,VNCharacterUtils.removeAccent(key) ,Long.parseLong(maNganhNghe), Long.parseLong(maHinhThuc), maKhuVuc);
	 		int soPage=tuyenDungDAO.getSoPage(VNCharacterUtils.removeAccent(key) ,Long.parseLong(maNganhNghe), Long.parseLong(maHinhThuc), maKhuVuc);
	 		
	 		PrintWriter out=response.getWriter();
	 		if(tuyenDungs.isEmpty()) 
	 			out.print("<h4 style=\"color: #c0c0c0;\">Không tìm thấy công việc nào phù hợp với yêu cầu tìm kiếm của bạn</h4>");
	 		else
	 			for (TuyenDung td : tuyenDungs) {
					out.print("<div class=\"tuyendung\" style=\"position: relative;\">\r\n" + 
							"		        <div class=\"tuyendung-container\">\r\n" + 
							"		        	<a href=\"/tuyendung/chitiet?id="+td.getMaTuyenDung() +"\" style=\"text-decoration: none; \">\r\n" + 
							"		            	<h4>"+td.getTieuDe() +"</h4>\r\n" + 
							"		            </a>\r\n" + 
							"		            <a href=\"/doanhnghiep/chitiet?id="+td.getMaDoanhNghiep() +"\"  style=\"text-decoration: none; color: black;\">\r\n" + 
							"		            	<span style=\"margin-bottom:20px;\">"+doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  +"</span>\r\n" + 
							"		            </a>\r\n" + 
							"		            <div style=\"margin: 5px 0;\">\r\n" + 
							"		            	<b><i>Tên công việc : </i></b>"+td.getTenCongViec() +" \r\n" + 
							"		            </div>\r\n" + 
							"		            \r\n" + 
							"		            <div class=\"tuyendung-item\">\r\n"); 
					if(td.getKhuVucTuyenDung().equals("00"))
						out.print("<span>Cả nước</span>");
					else out.print("<span>"+tinhThanhDAO.getTinhThanhById(td.getKhuVucTuyenDung()).getTenTinhThanh() +"</span>");
					out.print("		            	<span>"+td.getMucLuong() +"</span>\r\n" + 
							"		            	<span>Hạn đăng ký : "+td.getHanDangKy() +"</span>\r\n" + 
							"		            </div>\r\n" + 
							"		            \r\n" + 
							"		        </div>\r\n" + 
							"		        \r\n");
					if(sinhVien==null) {
						out.print("<button class=\"btn btn-success\" onclick=\"alert('Bạn cần phải đăng nhập trước!')\">Đăng ký</button>\r\n");
					}else {
						if(dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sinhVien.getMaSinhVien(), td.getMaTuyenDung())==null) {
							out.print("<button class=\"btn btn-success\" onclick=\"dangKyTuyenDung("+td.getMaTuyenDung()+")\">Đăng ký</button>\r\n");
						}else if (dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sinhVien.getMaSinhVien(), td.getMaTuyenDung())!=null&&dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sinhVien.getMaSinhVien(), td.getMaTuyenDung()).isDaDuyet()) {
							out.print("<button class=\"btn btn-primary\">Đã duyệt</button>\r\n");
						}else out.print("<button class=\"btn btn-danger\" onclick=\"huyDangKy("+td.getMaTuyenDung()+")\">Huỷ đăng ký</button>\r\n");
					}
				
					out.print("		        </div>" + 
					"		    </div>");
				}
	 		if(soPage!=1) {
	 			if(page==1) {
	 				out.print("<nav aria-label=\"Page navigation example\">\r\n" + 
		 					"  <ul class=\"pagination justify-content-center\">\r\n" + 
		 					"    <li class=\"page-item disabled\">\r\n" + 
		 					"      <a class=\"page-link\" aria-label=\"Previous\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n"); 	
	 				for(int i=page;i<=page+2;i++) {
	 					if(i>soPage) break;
	 					if(i==page) out.print("<li class=\"page-item active\" onclick=\"timKiemTuyenDungByPage("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 					else out.print("<li class=\"page-item\" onclick=\"timKiemTuyenDungByPage("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 				}
	 					out.print("    <li class=\"page-item\">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemTuyenDungByPage(2)\" aria-label=\"Next\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n" + 
		 					"  </ul>\r\n" + 
		 					"</nav>");
	 				
	 			}else
	 			if(page==soPage) {
	 				out.print("<nav aria-label=\"Page navigation example\">\r\n" + 
		 					"  <ul class=\"pagination justify-content-center\">\r\n" + 
		 					"    <li class=\"page-item \">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemTuyenDungByPage("+(page-1)+")\" aria-label=\"Previous\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n"); 	
	 				for(int i=page-2;i<=page;i++) {
	 					if(i<1) continue;
	 					if(i==page) out.print("<li class=\"page-item active\" onclick=\"timKiemTuyenDungByPage("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 					else out.print("<li class=\"page-item\" onclick=\"timKiemTuyenDungByPage("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 				}
	 					out.print("    <li class=\"page-item\">\r\n" + 
		 					"      <a class=\"page-link disabled\" aria-label=\"Next\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n" + 
		 					"  </ul>\r\n" + 
		 					"</nav>");
	 			}else
	 			{
	 				out.print("<nav aria-label=\"Page navigation example\">\r\n" + 
		 					"  <ul class=\"pagination justify-content-center\">\r\n" + 
		 					"    <li class=\"page-item \">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemTuyenDungByPage("+(page-1)+")\" aria-label=\"Previous\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n"); 	
	 				for(int i=page-1;i<=page+1;i++) {
	 					if(i<1) continue;
	 					if(i==page) out.print("<li class=\"page-item active\" onclick=\"timKiemTuyenDungByPage("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 					else out.print("<li class=\"page-item\" onclick=\"timKiemTuyenDungByPage("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 				}
	 					out.print("    <li class=\"page-item\">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemTuyenDungByPage("+(page+1)+")\" aria-label=\"Next\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n" + 
		 					"  </ul>\r\n" + 
		 					"</nav>");
	 			}
	 		}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
	@RequestMapping(value= {"/chitiet"}, method=RequestMethod.GET)
    public String chiTiet(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		int maTuyenDung= Integer.parseInt(request.getParameter("id"));
	 		
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		NganhNgheDAO nganhNgheDAO=new NganhNgheDAO();
	 		HinhThucLamViecDAO hinhThucLamViecDAO=new HinhThucLamViecDAO();
	 		TinhThanhDAO tinhThanhDAO= new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 		TuyenDung tuyenDung=tuyenDungDAO.getTuyenDungByID(maTuyenDung);
	 		
	 		model.addAttribute("tuyenDung", tuyenDung);
	 		model.addAttribute("nganhNgheDAO", nganhNgheDAO);
	 		model.addAttribute("doanhNghiepDAO", doanhNghiepDAO);
	 		model.addAttribute("hinhThucLamViecDAO", hinhThucLamViecDAO);
	 		model.addAttribute("dangKyTuyenDungDAO", dangKyTuyenDungDAO);
	 		model.addAttribute("tuyenDungCungCongTy", tuyenDungDAO.getAllTuyenDungDaDuyetByMaDoanhNghiep(tuyenDung.getMaDoanhNghiep()));
	 		model.addAttribute("tinhThanhDAO", tinhThanhDAO);
	 		model.addAttribute("tuyenDungLienQuan",tuyenDungDAO.timKiemTuyenDung(1, "", tuyenDung.getMaNganhNghe(), -1, "-1"));
	 		model.addAttribute("title", "Tuyển dụng");
	 		
	    	return "tuyendung/chitiet";
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/dangky"}, method=RequestMethod.POST)
    public void dangKyTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maTuyenDung= request.getParameter("maTuyenDung");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		TinhThanhDAO tinhThanhDAO=new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		TuyenDung td=tuyenDungDAO.getTuyenDungByID(Long.parseLong(maTuyenDung));
	 		
	 		int kq=dangKyTuyenDungDAO.insertDangKyTuyenDung(sinhVien.getMaSinhVien(), Long.parseLong(maTuyenDung));
	 		
	 		PrintWriter out=response.getWriter();
	 		if(kq!=-1)	{
	 			out.print("<div class=\"tuyendung\" style=\"position: relative;\">\r\n" + 
						"		        <div class=\"tuyendung-container\">\r\n" + 
						"		        	<a href=\"/tuyendung/chitiet?id="+td.getMaTuyenDung() +"\" style=\"text-decoration: none; \">\r\n" + 
						"		            	<h4>"+td.getTieuDe() +"</h4>\r\n" + 
						"		            </a>\r\n" + 
						"		            <a href=\"/doanhnghiep/chitiet?id="+td.getMaDoanhNghiep() +"\"  style=\"text-decoration: none; color: black;\">\r\n" + 
						"		            	<span style=\"margin-bottom:20px;\">"+doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  +"</span>\r\n" + 
						"		            </a>\r\n" + 
						"		            <div style=\"margin: 5px 0;\">\r\n" + 
						"		            	<b><i>Tên công việc : </i></b>"+td.getTenCongViec() +" \r\n" + 
						"		            </div>\r\n" + 
						"		            \r\n" + 
						"		            <div class=\"tuyendung-item\">\r\n"); 
				if(td.getKhuVucTuyenDung().equals("00"))
					out.print("<span>Cả nước</span>");
				else out.print("<span>"+tinhThanhDAO.getTinhThanhById(td.getKhuVucTuyenDung()).getTenTinhThanh() +"</span>");
				out.print("		            	<span>"+td.getMucLuong() +"</span>\r\n" + 
						"		            	<span>Hạn đăng ký : "+td.getHanDangKy() +"</span>\r\n" + 
						"		            </div>\r\n" + 
						"		            \r\n" + 
						"		        </div>\r\n" + 
						"		        \r\n<div style=\"position: absolute;bottom: 15px;right: 50px;\">");
				
					out.print("<button class=\"btn btn-danger\" onclick=\"huyDangKy("+td.getMaTuyenDung()+")\">Huỷ đăng ký</button>\r\n");
				
			
				out.print("		        </div>" + 
				"		    </div>");
	 		}
	 			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
	@RequestMapping(value= {"/huydangky"}, method=RequestMethod.POST)
    public void huyDangKyTuyenDung(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maTuyenDung= request.getParameter("maTuyenDung");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		TinhThanhDAO tinhThanhDAO=new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		
	 		TuyenDung td=tuyenDungDAO.getTuyenDungByID(Long.parseLong(maTuyenDung));
	 		int kq=dangKyTuyenDungDAO.deleteDangKyTuyenDung(sinhVien.getMaSinhVien(), Long.parseLong(maTuyenDung));
	 		
	 		PrintWriter out=response.getWriter();
	 		if(kq!=-1)	{
	 			out.print("<div class=\"tuyendung\" style=\"position: relative;\">\r\n" + 
						"		        <div class=\"tuyendung-container\">\r\n" + 
						"		        	<a href=\"/tuyendung/chitiet?id="+td.getMaTuyenDung() +"\" style=\"text-decoration: none; \">\r\n" + 
						"		            	<h4>"+td.getTieuDe() +"</h4>\r\n" + 
						"		            </a>\r\n" + 
						"		            <a href=\"/doanhnghiep/chitiet?id="+td.getMaDoanhNghiep() +"\"  style=\"text-decoration: none; color: black;\">\r\n" + 
						"		            	<span style=\"margin-bottom:20px;\">"+doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  +"</span>\r\n" + 
						"		            </a>\r\n" + 
						"		            <div style=\"margin: 5px 0;\">\r\n" + 
						"		            	<b><i>Tên công việc : </i></b>"+td.getTenCongViec() +" \r\n" + 
						"		            </div>\r\n" + 
						"		            \r\n" + 
						"		            <div class=\"tuyendung-item\">\r\n"); 
				if(td.getKhuVucTuyenDung().equals("00"))
					out.print("<span>Cả nước</span>");
				else out.print("<span>"+tinhThanhDAO.getTinhThanhById(td.getKhuVucTuyenDung()).getTenTinhThanh() +"</span>");
				out.print("		            	<span>"+td.getMucLuong() +"</span>\r\n" + 
						"		            	<span>Hạn đăng ký : "+td.getHanDangKy() +"</span>\r\n" + 
						"		            </div>\r\n" + 
						"		            \r\n" + 
						"		        </div>\r\n" + 
						"		        \r\n"
						+ "<div style=\"position: absolute;bottom: 15px;right: 50px;\">");
				
				out.print("<button class=\"btn btn-success\" onclick=\"dangKyTuyenDung("+td.getMaTuyenDung()+")\">Đăng ký</button>\r\n");
					
				out.print("		        </div>" + 
				"		    </div>");
	 		}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
	@RequestMapping(value= {"/chitiet/dangky"}, method=RequestMethod.POST)
    public void dangKyTuyenDungChiTiet(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maTuyenDung= request.getParameter("maTuyenDung");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		TinhThanhDAO tinhThanhDAO=new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		TuyenDung td=tuyenDungDAO.getTuyenDungByID(Long.parseLong(maTuyenDung));
	 		
	 		int kq=dangKyTuyenDungDAO.insertDangKyTuyenDung(sinhVien.getMaSinhVien(), Long.parseLong(maTuyenDung));
	 		
	 		PrintWriter out=response.getWriter();
	 		if(kq!=-1)	{
	 			out.print("<div style=\"position: relative;padding: 30px;\" >\r\n" + 
	 					"		        <div class=\"tuyendung-container\">\r\n" + 
	 					"		        	\r\n" + 
	 					"		            <h3 style=\"color: green;\">"+td.getTieuDe()+"</h3>\r\n" + 
	 					"		            <a href=\"/doanhnghiep/chitiet/id="+td.getMaDoanhNghiep() +"\" style=\"text-decoration: none; color: black;\">\r\n" + 
	 					"		            	<span style=\"margin-bottom:20px;\">"+doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  +"</span>\r\n" + 
	 					"		            </a>\r\n" + 
	 					"		            <div style=\"margin: 5px 0;\">\r\n" + 
	 					"		            	<b><i>Tên công việc : </i></b>"+td.getTenCongViec() +" \r\n" + 
	 					"		            </div>    \r\n" + 
	 					"		        </div>\r\n" + 
	 					"		        \r\n" + 
	 					"		        <div style=\"position: absolute;bottom: 15px;right: 50px;\">");
				
					out.print("<button class=\"btn btn-danger\" onclick=\"huyDangKy("+td.getMaTuyenDung()+")\">Huỷ đăng ký</button>\r\n");
				
			
				out.print("		        </div>" + 
				"		    </div>");
	 		}
	 			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
	@RequestMapping(value= {"/chitiet/huydangky"}, method=RequestMethod.POST)
    public void huyDangKyTuyenDungChiTiet(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String maTuyenDung= request.getParameter("maTuyenDung");
	 		SinhVien sinhVien=(SinhVien)session.getAttribute("sinhvien");
	 		
	 		DangKyTuyenDungDAO dangKyTuyenDungDAO=new DangKyTuyenDungDAO();
	 		TuyenDungDAO tuyenDungDAO=new TuyenDungDAO();
	 		TinhThanhDAO tinhThanhDAO=new TinhThanhDAO();
	 		DoanhNghiepDAO doanhNghiepDAO=new DoanhNghiepDAO();
	 		
	 		TuyenDung td=tuyenDungDAO.getTuyenDungByID(Long.parseLong(maTuyenDung));
	 		int kq=dangKyTuyenDungDAO.deleteDangKyTuyenDung(sinhVien.getMaSinhVien(), Long.parseLong(maTuyenDung));
	 		
	 		PrintWriter out=response.getWriter();
	 		if(kq!=-1)	{
	 			out.print("<div style=\"position: relative;padding: 30px;\" >\r\n" + 
	 					"		        <div class=\"tuyendung-container\">\r\n" + 
	 					"		        	\r\n" + 
	 					"		            <h3 style=\"color: green;\">"+td.getTieuDe()+"</h3>\r\n" + 
	 					"		            <a href=\"/doanhnghiep/chitiet/id="+td.getMaDoanhNghiep() +"\" style=\"text-decoration: none; color: black;\">\r\n" + 
	 					"		            	<span style=\"margin-bottom:20px;\">"+doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  +"</span>\r\n" + 
	 					"		            </a>\r\n" + 
	 					"		            <div style=\"margin: 5px 0;\">\r\n" + 
	 					"		            	<b><i>Tên công việc : </i></b>"+td.getTenCongViec() +" \r\n" + 
	 					"		            </div>    \r\n" + 
	 					"		        </div>\r\n" + 
	 					"		        \r\n" + 
	 					"		        <div style=\"position: absolute;bottom: 15px;right: 50px;\">");
				out.print("<button class=\"btn btn-success\" onclick=\"dangKyTuyenDung("+td.getMaTuyenDung()+")\">Đăng ký</button>\r\n");
					
				out.print("		        </div>" + 
				"		    </div>");
	 		}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
}
