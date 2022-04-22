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
				String matKhau=rs.getNString("MatKhau");
				String tenSinhVien=rs.getNString("TenSinhVien");
				String maNganhDaoTao=rs.getString("MaNganhDaoTao");
				String khoa=rs.getString("Khoa");
				String lop=rs.getString("Lop");
				Boolean daDuyet=rs.getBoolean("DaDuyet");
				
				ds.add(new SinhVien(maSinhVien, matKhau, tenSinhVien, maNganhDaoTao, khoa, lop, daDuyet));
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
	public SinhVien KiemTraDangNhap(String maSinhVien, String matKhau) throws SQLException {
		String query = "select * from SinhVien where lower(MaSinhVien)=? and MatKhau=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1,maSinhVien.toLowerCase());
			ps.setNString(2, matKhau);
			rs= ps.executeQuery();	
			if(rs.next()) {
				String tenSinhVien=rs.getNString("TenSinhVien");
				String maNganhDaoTao=rs.getString("MaNganhDaoTao");
				String khoa=rs.getString("Khoa");
				String lop=rs.getString("Lop");
				Boolean daDuyet=rs.getBoolean("DaDuyet");
				
				return new SinhVien(maSinhVien, matKhau, tenSinhVien, maNganhDaoTao, khoa, lop, daDuyet);
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
}
