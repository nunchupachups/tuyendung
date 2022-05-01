package cntt.trang.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cntt.trang.bean.DonVi;
import cntt.trang.bean.SinhVien;


public class DocJSON {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public static int insertTinhThanh(String maTinhThanh, String tenTinhThanh, String type) throws SQLException {
		int flag= -1;
		String query = "insert into TinhThanh(MaTinhThanh,TenTinhThanh,Type) values(?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, maTinhThanh);
			ps.setNString(2, tenTinhThanh);
			ps.setNString(3, type);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	
	public static int insertQuanHuyen(String maQuanHuyen, String tenQuanHuyen, String type,String pathWithType, String maTinhThanh) throws SQLException {
		int flag= -1;
		String query = "insert into QuanHuyen(MaQuanHuyen,TenQuanHuyen,Type, path_with_type, MaTinhThanh) values(?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, maQuanHuyen);
			ps.setNString(2, tenQuanHuyen);
			ps.setNString(3, type);
			ps.setNString(4, pathWithType);
			ps.setNString(5, maTinhThanh);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	
	public static int insertXaPhuong(String maXaPhuong, String tenXaPhuong, String type,String pathWithType, String maQuanHuyen) throws SQLException {
		int flag= -1;
		String query = "insert into XaPhuong(MaXaPhuong,TenXaPhuong,Type,path_with_type, MaQuanHuyen) values(?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, maXaPhuong);
			ps.setNString(2, tenXaPhuong);
			ps.setNString(3, type);
			ps.setNString(4, pathWithType);
			ps.setNString(5, maQuanHuyen);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	public static int insertSinhVien(String maSinhVien,String hoVaTen, Boolean gioiTinh, String ngaySinh, String TTru_ThongTin, 
			String dienThoai, String diDong, String email, String maNganhDaoTao) throws SQLException {
		int flag= -1;
		String query = "insert into SinhVien(MaSinhVien,MatKhau,HoVaTen,GioiTinh, NgaySinh, DiaChi,DienThoai, DiDong, Email, MaNganhDaoTao,  DaDuyet) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			ps.setNString(2, "123");
			ps.setNString(3, hoVaTen);
			ps.setBoolean(4, gioiTinh);
			ps.setString(5, ngaySinh);
			if(!TTru_ThongTin.equals("")) ps.setNString(6, TTru_ThongTin);
			else ps.setNull(6, Types.NVARCHAR);
			if(!dienThoai.equals("")) ps.setString(7, dienThoai);
			else ps.setNull(7, Types.CHAR);
			if(!diDong.equals("")) ps.setString(8, diDong);
			else ps.setNull(8, Types.CHAR);
			if(!email.equals("")) ps.setNString(9, email);
			else ps.setNull(9, Types.NVARCHAR);
			ps.setString(10, maNganhDaoTao);
			ps.setBoolean(11, false);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	public static int insertDiem(String maHocPhan,String maSinhVien, String tenHocPhan, int soTinChi, String hocKy, String namHoc, float diemHe10, float diemHe4, String diemChu) throws SQLException {
		int flag= -1;
		String query = "insert into KetQuaHocTap(MaHocPhan,MaSinhVien, TenHocPhan, SoTinChi, HocKy, NamHoc, DiemHe10, DiemHe4, DiemChu) values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maHocPhan);
			ps.setString(2, maSinhVien);
			ps.setNString(3, tenHocPhan);
			ps.setInt(4, soTinChi);
			ps.setString(5, hocKy);
			ps.setString(6, namHoc);
			ps.setFloat(7, diemHe10);
			ps.setFloat(8, diemHe4);
			ps.setString(9, diemChu);
			
			flag= ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}	
		}
		return flag;
	}
	
	public static void main(String[] args) throws SQLException {
		JSONParser jsonParser = new JSONParser();
		
////tinh thanh
//        try (
//        	FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\tinh_tp.json")) {
//            // Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONObject userList = (JSONObject) obj;
//            Set<String> keys=userList.keySet();
//            Iterator<String> keyIt=keys.iterator();
//            while(keyIt.hasNext()) {
//            	JSONObject hi= (JSONObject)userList.get(keyIt.next());
//                String code=(String) hi.get("code");
//                String name=(String) hi.get("name");
//                String type=(String) hi.get("type");
//                insertTinhThanh(code, name, type);
//                System.out.println("ok");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        
//        quanhuyen
//        try (
//            	FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\quan_huyen.json")) {
//                // Read JSON file
//                Object obj = jsonParser.parse(reader);
//
//                JSONObject userList = (JSONObject) obj;
//                Set<String> keys=userList.keySet();
//                Iterator<String> keyIt=keys.iterator();
//                while(keyIt.hasNext()) {
//                	JSONObject hi= (JSONObject)userList.get(keyIt.next());
//                    String code=(String) hi.get("code");
//                    String name=(String) hi.get("name");
//                    String type=(String) hi.get("type");
//                    String parent_code=(String) hi.get("parent_code");
//                    String path_with_type=(String) hi.get("path_with_type");
//                    insertQuanHuyen(code, name, type, path_with_type, parent_code);
//                    System.out.println("ok");
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        xaphuong
//        try {
//        	FileReader reader1 = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\quan_huyen.json");
//              // Read JSON file
//              Object obj1 = jsonParser.parse(reader1);
//
//              JSONObject listQuanHuyen = (JSONObject) obj1;
//              Iterator<String> keysQuanHuyen=listQuanHuyen.keySet().iterator();
//              while(keysQuanHuyen.hasNext()) {
//            	  FileReader reader = new FileReader("C:\\Users\\Admin\\Desktop\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\xaphuong\\"+keysQuanHuyen.next()+".json");
//                  // Read JSON file
//                  Object obj = jsonParser.parse(reader);
//
//                  JSONObject list = (JSONObject) obj;
//                  Set<String> keys=list.keySet();
//                  Iterator<String> keyIt=keys.iterator();
//                  while(keyIt.hasNext()) {
//                  	JSONObject hi= (JSONObject)list.get(keyIt.next());
//                      String code=(String) hi.get("code");
//                      String name=(String) hi.get("name");
//                      String type=(String) hi.get("type");
//                      String path_with_type=(String) hi.get("path_with_type");
//                      String parent_code=(String) hi.get("parent_code");
//                      insertXaPhuong(code, name, type, path_with_type, parent_code);
//                      System.out.println("ok");
//                  }
//              }
//              SinhVien
              
//              try {
//              	FileReader reader1 = new FileReader("C:\\Users\\Admin\\Desktop\\TuyenDung\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\profile.json");
//                    // Read JSON file
//                    Object obj1 = jsonParser.parse(reader1);
//
//                    JSONArray listSinhVien = (JSONArray) obj1;
//                    for (Object object : listSinhVien) {
//                    	JSONObject sv=(JSONObject)object;
//                    	String maSinhVien = (String)sv.get("MaSinhVien");
//                    	String hoVaTen = (String)sv.get("HoVaTen");
//                    	boolean gioiTinh = (boolean)sv.get("GioiTinh");
//                    	String ngaySinh = (String)sv.get("NgaySinh");
//                    	String TTru_ThongTin = (String)sv.get("TTru_ThongTin");
//                    	String dienThoai = (String)sv.get("DienThoai");
//                    	String diDong = (String)sv.get("DiDong");
//                    	String email = (String)sv.get("Email");
//                    	String maNganhDaoTao = (String)sv.get("MaNganhDaoTao");
//                    	insertSinhVien(maSinhVien, hoVaTen, gioiTinh, ngaySinh, TTru_ThongTin, dienThoai, diDong, email, maNganhDaoTao);
//                        System.out.println("ok");
//					}
//                    
//            	
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//	}	
//		diem
//		try {
//          	FileReader reader1 = new FileReader("C:\\Users\\Admin\\Desktop\\TuyenDung\\KHOALUAN\\TuyenDungSV\\src\\main\\webapp\\json\\learning_result.json");
//                // Read JSON file
//                Object obj1 = jsonParser.parse(reader1);
//
//                JSONObject list = (JSONObject) obj1;
//                Iterator<String> listMaSV=list.keySet().iterator();
//                while(listMaSV.hasNext()) {
//                	String maSinhVien=listMaSV.next();
//                	JSONArray listDiem = (JSONArray)list.get(maSinhVien);
//                	for (Object object : listDiem) {
//                		JSONObject kq=(JSONObject)object;
//                    	String maHocPhan = (String)kq.get("MaHocPhan");
//                    	String tenHocPhan = (String)kq.get("TenHocPhan");
//                    	long soTinChi = (long) kq.get("SoTinChi");
//                    	String hocKy = (String)kq.get("HocKy");
//                    	String namHoc = (String)kq.get("NamHoc");
//                    	double diemHe10 = (double)kq.get("DiemHe10");
//                    	double diemHe4 = (double)kq.get("DiemHe4");
//                    	String diemChu = (String)kq.get("DiemChu");
//                    	insertDiem(maHocPhan, maSinhVien, tenHocPhan, (int)soTinChi, hocKy, namHoc, (float)diemHe10, (float)diemHe4, diemChu);
//                        System.out.println("ok");
//					}
//                }
//        	
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
		SinhVienDAO sinhVienDAO= new SinhVienDAO();
		ArrayList<SinhVien> sinhvien=sinhVienDAO.getAllSinhVien();
		NganhDaoTaoDAO nganhDaoTaoDAO= new NganhDaoTaoDAO();
		DonViDAO donViDAO=new DonViDAO();
		ViTriDAO viTriDAO= new ViTriDAO();
		
		for (SinhVien sv : sinhvien) {
			donViDAO.insertDonVi("Trường Đại học Khoa học Huế", sv.getMaSinhVien(), "hocvan");
			DonVi truong= donViDAO.getDonViByTenDonViAndMucCVAndMaCV("hocvan", sv.getMaSinhVien(), "Trường Đại học Khoa học Huế");
			viTriDAO.insertViTri("Sinh viên ngành "+nganhDaoTaoDAO.getNganhDaoTaoById(sv.getMaNganhDaoTao()).getTenNganh(), (1976+sv.getKhoa())+" - "+(1976+sv.getKhoa()+nganhDaoTaoDAO.getNganhDaoTaoById(sv.getMaNganhDaoTao()).getNamDaoTao()>=new Date().getYear() ? "Nay" : 1976+sv.getKhoa()+nganhDaoTaoDAO.getNganhDaoTaoById(sv.getMaNganhDaoTao()).getNamDaoTao()), truong.getMaDonVi(), "");
		}
}

}
