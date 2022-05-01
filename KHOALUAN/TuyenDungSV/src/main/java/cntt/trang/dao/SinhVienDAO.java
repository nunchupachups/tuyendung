package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.SinhVien;

public class SinhVienDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<SinhVien> getAllSinhVien() throws SQLException {
		ArrayList<SinhVien> ds=new ArrayList<SinhVien>();
		String query = "select * from SinhVien";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maSinhVien=rs.getString("MaSinhVien");
				String hoVaTen=rs.getNString("HoVaTen");
				boolean gioiTinh=rs.getBoolean("GioiTinh");
				String ngaySinh=rs.getString("NgaySinh");
				String diaChi=rs.getNString("DiaChi");
				String dienThoai=rs.getString("DienThoai");
				String diDong=rs.getString("DiDong");
				String email=rs.getNString("Email");
				String maNganhDaoTao=rs.getString("MaNganhDaoTao");
				boolean daDuyet=rs.getBoolean("DaDuyet");
				int khoa=rs.getInt("Khoa");
				String anhDaiDien=rs.getNString("AnhDaiDien");
				
				ds.add( new SinhVien(maSinhVien, hoVaTen, gioiTinh, ngaySinh, diaChi, dienThoai, diDong, email, maNganhDaoTao, daDuyet, khoa,anhDaiDien));
				
				
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
	public SinhVien KiemTraDangNhap(String maSinhVien) throws SQLException {
		String query = "select * from SinhVien where lower(MaSinhVien)=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maSinhVien.toLowerCase());
			rs= ps.executeQuery();	
			if(rs.next()) {
				String hoVaTen=rs.getNString("HoVaTen");
				boolean gioiTinh=rs.getBoolean("GioiTinh");
				String ngaySinh=rs.getString("NgaySinh");
				String diaChi=rs.getNString("DiaChi");
				String dienThoai=rs.getString("DienThoai");
				String diDong=rs.getString("DiDong");
				String email=rs.getNString("Email");
				String maNganhDaoTao=rs.getString("MaNganhDaoTao");
				boolean daDuyet=rs.getBoolean("DaDuyet");
				int khoa=rs.getInt("Khoa");
				String anhDaiDien=rs.getNString("AnhDaiDien");
				
				return new SinhVien(maSinhVien, hoVaTen, gioiTinh, ngaySinh, diaChi, dienThoai, diDong, email, maNganhDaoTao, daDuyet, khoa,anhDaiDien);
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
	public int updateAnhDaiDien(String anhDaiDien, String maSinhVien) throws SQLException {
		String query = "update SinhVien set AnhDaiDien=? where MaSinhVien=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, anhDaiDien);
			ps.setString(2, maSinhVien);
			
			
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
