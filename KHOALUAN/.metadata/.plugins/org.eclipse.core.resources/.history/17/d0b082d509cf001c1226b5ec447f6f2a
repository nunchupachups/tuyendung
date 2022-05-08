package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cntt.trang.bean.DoanhNghiep;

public class DoanhNghiepDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<DoanhNghiep> getAllDoanhNghiepDaDuyet() throws SQLException {
		ArrayList<DoanhNghiep> ds=new ArrayList<DoanhNghiep>();
		String query = "select * from DoanhNghiep where DaDuyet=1";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maDoanhNghiep = rs.getLong("MaDoanhNghiep");
				String emailDangNhap = rs.getNString("EmailDangNhap"); 
				String matKhau = rs.getNString("MatKhau");  
				String tenLienHe = rs.getNString("TenLienHe"); 
				String emailLienHe = rs.getNString("EmailLienHe"); 
				String soDienThoai = rs.getString("SoDienThoai"); 
				String tenDoanhNghiep = rs.getNString("TenDoanhNghiep"); 
				String maSoThue = rs.getString("MaSoThue"); 
				String maXaPhuong = rs.getString("MaXaPhuong"); 
				String diaChiDuong = rs.getNString("DiaChiDuong"); 
				String maLinhVucHoatDong = rs.getString("MaLinhVucHoatDong"); 
				long maLoaiHinhDoanhNghiep = rs.getLong("MaLoaiHinhDoanhNghiep");
				String giayChungNhan = rs.getNString("GiayChungNhan"); 
				boolean daDuyet = rs.getBoolean("DaDuyet");
				
				ds.add(new DoanhNghiep(maDoanhNghiep, emailDangNhap, matKhau, tenLienHe, emailLienHe, soDienThoai, tenDoanhNghiep, maSoThue, maXaPhuong, diaChiDuong, maLinhVucHoatDong, maLoaiHinhDoanhNghiep, giayChungNhan, daDuyet));
			}
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
		return ds;
	}
	
	public ArrayList<DoanhNghiep> timKiemDoanhNghiepDaDuyet(String tenDN, String maTT, String maLVHD, String maLHDN) throws SQLException {
		ArrayList<DoanhNghiep> ds=new ArrayList<DoanhNghiep>();
		String query = "select * from DoanhNghiep where DaDuyet=1";
		if(!tenDN.equals("")) query+=" and lower(TenDoanhNghiep) like ?";
		if(!maTT.equals("-1")) query+=" and MaXaPhuong in (\r\n" + 
				"select MaXaPhuong\r\n" + 
				"from XaPhuong as xp join QuanHuyen as qh on xp.MaQuanHuyen=qh.MaQuanHuyen\r\n" + 
				"where qh.MaTinhThanh = ?)";
		if(!maLVHD.equals("-1")) query+=" and MaLinhVucHoatDong =?";
		if(!maLHDN.equals("-1")) query+=" and MaLoaiHinhDoanhNghiep =?";
		System.out.println(query);
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			int i=0;
			if(!tenDN.equals("")) ps.setNString(++i, "%"+tenDN.toLowerCase()+"%");
			if(!maTT.equals("-1")) ps.setString(++i, maTT);
			if(!maLVHD.equals("-1")) ps.setString(++i, maLVHD);
			if(!maLHDN.equals("-1")) ps.setString(++i, maLHDN);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maDoanhNghiep = rs.getLong("MaDoanhNghiep");
				String emailDangNhap = rs.getNString("EmailDangNhap"); 
				String matKhau = rs.getNString("MatKhau");  
				String tenLienHe = rs.getNString("TenLienHe"); 
				String emailLienHe = rs.getNString("EmailLienHe"); 
				String soDienThoai = rs.getString("SoDienThoai"); 
				String tenDoanhNghiep = rs.getNString("TenDoanhNghiep"); 
				String maSoThue = rs.getString("MaSoThue"); 
				String maXaPhuong = rs.getString("MaXaPhuong"); 
				String diaChiDuong = rs.getNString("DiaChiDuong"); 
				String maLinhVucHoatDong = rs.getString("MaLinhVucHoatDong"); 
				long maLoaiHinhDoanhNghiep = rs.getLong("MaLoaiHinhDoanhNghiep");
				String giayChungNhan = rs.getNString("GiayChungNhan"); 
				boolean daDuyet = rs.getBoolean("DaDuyet");
				
				ds.add(new DoanhNghiep(maDoanhNghiep, emailDangNhap, matKhau, tenLienHe, emailLienHe, soDienThoai, tenDoanhNghiep, maSoThue, maXaPhuong, diaChiDuong, maLinhVucHoatDong, maLoaiHinhDoanhNghiep, giayChungNhan, daDuyet));
			}
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
		return ds;
	}
	
	public DoanhNghiep KiemTraDangNhap(String emailDangNhap, String matKhau) throws SQLException {
		String query = "select * from DoanhNghiep where EmaildangNhap=? and MatKhau=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, emailDangNhap);
			ps.setNString(2, matKhau);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maDoanhNghiep = rs.getLong("MaDoanhNghiep");
				String tenLienHe = rs.getNString("TenLienHe"); 
				String emailLienHe = rs.getNString("EmailLienHe"); 
				String soDienThoai = rs.getString("SoDienThoai"); 
				String tenDoanhNghiep = rs.getNString("TenDoanhNghiep"); 
				String maSoThue = rs.getString("MaSoThue"); 
				String maXaPhuong = rs.getString("MaXaPhuong"); 
				String diaChiDuong = rs.getNString("DiaChiDuong"); 
				String maLinhVucHoatDong = rs.getString("MaLinhVucHoatDong"); 
				long maLoaiHinhDoanhNghiep = rs.getLong("MaLoaiHinhDoanhNghiep");
				String giayChungNhan = rs.getNString("GiayChungNhan"); 
				boolean daDuyet = rs.getBoolean("DaDuyet");
				
				return new DoanhNghiep(maDoanhNghiep, emailDangNhap, matKhau, tenLienHe, emailLienHe, soDienThoai, tenDoanhNghiep, maSoThue, maXaPhuong, diaChiDuong, maLinhVucHoatDong, maLoaiHinhDoanhNghiep, giayChungNhan, daDuyet);
			}
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
		return null;
	}
	public DoanhNghiep getDoanhNghiepById(long maDoanhNghiep) throws SQLException {
		String query = "select * from DoanhNghiep where MaDoanhNghiep=? ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String emailDangNhap=rs.getNString("EmailDangNhap");
				String matKhau=rs.getNString("MatKhau");
				String tenLienHe = rs.getNString("TenLienHe"); 
				String emailLienHe = rs.getNString("EmailLienHe"); 
				String soDienThoai = rs.getString("SoDienThoai"); 
				String tenDoanhNghiep = rs.getNString("TenDoanhNghiep"); 
				String maSoThue = rs.getString("MaSoThue"); 
				String maXaPhuong = rs.getString("MaXaPhuong"); 
				String diaChiDuong = rs.getNString("DiaChiDuong"); 
				String maLinhVucHoatDong = rs.getString("MaLinhVucHoatDong"); 
				long maLoaiHinhDoanhNghiep = rs.getLong("MaLoaiHinhDoanhNghiep");
				String giayChungNhan = rs.getNString("GiayChungNhan"); 
				boolean daDuyet = rs.getBoolean("DaDuyet");
				
				return new DoanhNghiep(maDoanhNghiep, emailDangNhap, matKhau, tenLienHe, emailLienHe, soDienThoai, tenDoanhNghiep, maSoThue, maXaPhuong, diaChiDuong, maLinhVucHoatDong, maLoaiHinhDoanhNghiep, giayChungNhan, daDuyet);
			}
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
		return null;
	}
	public DoanhNghiep getDoanhNghiepByEmailDangNhap(String emailDangNhap) throws SQLException {
		String query = "select * from DoanhNghiep where EmaildangNhap=? ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, emailDangNhap);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maDoanhNghiep=rs.getLong("MaDoanhNghiep");
				String matKhau=rs.getNString("MatKhau");
				String tenLienHe = rs.getNString("TenLienHe"); 
				String emailLienHe = rs.getNString("EmailLienHe"); 
				String soDienThoai = rs.getString("SoDienThoai"); 
				String tenDoanhNghiep = rs.getNString("TenDoanhNghiep"); 
				String maSoThue = rs.getString("MaSoThue"); 
				String maXaPhuong = rs.getString("MaXaPhuong"); 
				String diaChiDuong = rs.getNString("DiaChiDuong"); 
				String maLinhVucHoatDong = rs.getString("MaLinhVucHoatDong"); 
				long maLoaiHinhDoanhNghiep = rs.getLong("MaLoaiHinhDoanhNghiep");
				String giayChungNhan = rs.getNString("GiayChungNhan"); 
				boolean daDuyet = rs.getBoolean("DaDuyet");
				
				return new DoanhNghiep(maDoanhNghiep, emailDangNhap, matKhau, tenLienHe, emailLienHe, soDienThoai, tenDoanhNghiep, maSoThue, maXaPhuong, diaChiDuong, maLinhVucHoatDong, maLoaiHinhDoanhNghiep, giayChungNhan, daDuyet);
			}
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
		return null;
	}
	public int insertDoanhNghiep(String emailDangNhap, String matKhau, String tenLienHe, String emailLienHe, String soDienThoai, String tenDoanhNghiep, String maSoThue, String maXaPhuong, String diaChiDuong,String maLinhVucHoatDong, long maLoaiHinhDoanhNghiep, String giayChungNhan, boolean daDuyet) throws SQLException {
		String query = "insert into DoanhNghiep(EmailDangNhap, MatKhau, TenLienHe, EmailLienHe, SoDienThoai, TenDoanhNghiep, MaSoThue, MaXaPhuong, DiaChiDuong,MaLinhVucHoatDong,MaLoaiHinhDoanhNghiep, GiayChungNhan, DaDuyet) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, emailDangNhap);
			ps.setNString(2, matKhau);
			ps.setNString(3, tenLienHe);
			ps.setNString(4, emailLienHe);
			ps.setString(5, soDienThoai);
			ps.setNString(6, tenDoanhNghiep);
			ps.setString(7, maSoThue);
			ps.setString(8, maXaPhuong);
			ps.setNString(9, diaChiDuong);
			ps.setString(10, maLinhVucHoatDong);
			ps.setLong(11, maLoaiHinhDoanhNghiep);
			ps.setNString(12, giayChungNhan);
			ps.setBoolean(13, daDuyet);
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
}
