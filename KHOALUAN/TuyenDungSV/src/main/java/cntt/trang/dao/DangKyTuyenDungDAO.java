package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.DangKyTuyenDung;
import cntt.trang.bean.TuyenDung;

public class DangKyTuyenDungDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public DangKyTuyenDung getDangKyByMaSinhVienAndMaTuyenDung(String maSinhVien, long maTuyenDung) throws SQLException {
		String query = "select * from DangKyTuyenDung where MaSinhVien=? and MaTuyenDung=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			ps.setLong(2, maTuyenDung);
			rs= ps.executeQuery();	
			if(rs.next()) {
				boolean daDuyet=rs.getBoolean("DaDuyet");
				return new DangKyTuyenDung(maTuyenDung, maSinhVien, daDuyet);
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
	public ArrayList<DangKyTuyenDung> getDangKyByMaTuyenDung(long maTuyenDung) throws SQLException {
		String query = "select * from DangKyTuyenDung where MaTuyenDung=?";
		ArrayList<DangKyTuyenDung> ds= new ArrayList<DangKyTuyenDung>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maTuyenDung);
			rs= ps.executeQuery();	
			while(rs.next()) {
				boolean daDuyet=rs.getBoolean("DaDuyet");
				String maSinhVien=rs.getString("MaSinhVien");
				ds.add(new DangKyTuyenDung(maTuyenDung, maSinhVien, daDuyet));
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
	public int updateDangKyTuyenDung(String maSinhVien, long maTuyenDung, boolean daDuyet) throws SQLException {
		String query = "update DangKyTuyenDung set DaDuyet=? where MaSinhVien=? and MaTuyenDung=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setBoolean(1, daDuyet);
			ps.setString(2, maSinhVien);
			ps.setLong(3, maTuyenDung);
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
	public int insertDangKyTuyenDung(String maSinhVien, long maTuyenDung) throws SQLException {
		String query = "insert into DangKyTuyenDung(MaSinhVien, MaTuyenDung, DaDuyet) values(?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			ps.setLong(2, maTuyenDung);
			ps.setBoolean(3, false);
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
	public int deleteDangKyTuyenDung(String maSinhVien, long maTuyenDung) throws SQLException {
		String query = "delete from DangKyTuyenDung where MaSinhVien=? and MaTuyenDung=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			ps.setLong(2, maTuyenDung);
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
