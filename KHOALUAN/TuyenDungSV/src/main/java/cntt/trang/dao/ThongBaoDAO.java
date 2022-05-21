package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import cntt.trang.bean.ThongBao;

public class ThongBaoDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public int insertThongBao(long maDoanhNghiep, String maSinhVien, String noiDung, String link) throws SQLException {
		String query = "insert into ThongBao(MaDoanhNghiep, MaSinhVien, NoiDung, Link) values(?,?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			if(maSinhVien!=null) {
				ps.setNull(1, Types.BIGINT);
				ps.setString(2, maSinhVien);
			}
			else {
				ps.setLong(1, maDoanhNghiep);
				ps.setNull(2, Types.CHAR);
			}
			ps.setNString(3, noiDung);
			ps.setNString(4, link);
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
	
	public int daXemThongBao(long maThongBao) throws SQLException {
		String query = "update ThongBao set DaXem=1 where MaThongBao=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maThongBao);
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
	public ArrayList<ThongBao> getAllThongBaoByMaDoanhNghiep(long maDoanhNghiep) throws SQLException {
		String query = "select * from ThongBao where MaDoanhNghiep=? order by MaThongBao desc";
		ArrayList<ThongBao> ds= new ArrayList<ThongBao>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			rs= ps.executeQuery();	
			while(rs.next()) {
				Long maThongBao=rs.getLong("MaThongBao");
				String noiDung=rs.getNString("NoiDung");
				String link=rs.getNString("Link");
				boolean daXem=rs.getBoolean("DaXem");
				ds.add(new ThongBao(maThongBao, maDoanhNghiep, null, noiDung, link, daXem));
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
	public ArrayList<ThongBao> getAllThongBaoByMaSinhVien(String maSinhVien) throws SQLException {
		String query = "select * from ThongBao where MaSinhVien=? order by MaThongBao desc";
		ArrayList<ThongBao> ds= new ArrayList<ThongBao>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			rs= ps.executeQuery();	
			while(rs.next()) {
				Long maThongBao=rs.getLong("MaThongBao");
				String noiDung=rs.getNString("NoiDung");
				String link=rs.getNString("Link");
				boolean daXem=rs.getBoolean("DaXem");
				ds.add(new ThongBao(maThongBao, 0, maSinhVien, noiDung, link, daXem));
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
	public int getSumThongBaoChuaXemByMaDoanhNghiep(long maDoanhNghiep) throws SQLException {
		String query = "select count(1) from ThongBao where MaDoanhNghiep=? and DaXem=0";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			rs= ps.executeQuery();	
			if(rs.next()) {
				int tong=rs.getInt(1);
				return tong;
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
		return 0;
	}
	public int getSumThongBaoChuaXemByMaSinhVien(String maSinhVien) throws SQLException {
		String query = "select count(1) from ThongBao where MaSinhVien=? and DaXem=0";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			rs= ps.executeQuery();	
			if(rs.next()) {
				int tong=rs.getInt(1);
				return tong;
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
		return 0;
	}
}
