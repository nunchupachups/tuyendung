package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.KyNang;

public class KyNangDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public int insertKyNang(String tenKyNang, int doThanhThao, String maCV) throws SQLException {
		String query = "insert into KyNang(TenKyNang, DoThanhThao, MaCV) values(?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, tenKyNang);
			ps.setInt(2, doThanhThao);
			ps.setString(3, maCV);
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
	public ArrayList<KyNang> getAllKyNangByMaCV(String maCV) throws SQLException {
		String query = "select * from KyNang where MaCV=?";
		ArrayList<KyNang> ds=new ArrayList<KyNang>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maCV);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maKyNang=rs.getLong("MaKyNang");
				String tenKyNang=rs.getNString("TenKyNang");
				int doThanhThao=rs.getInt("DoThanhThao");
				ds.add(new KyNang(maKyNang, tenKyNang, doThanhThao, maCV));
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
	public ArrayList<KyNang> getAllKyNang() throws SQLException {
		String query = "select * from KyNang";
		ArrayList<KyNang> ds=new ArrayList<KyNang>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maKyNang=rs.getLong("MaKyNang");
				String tenKyNang=rs.getNString("TenKyNang");
				int doThanhThao=rs.getInt("DoThanhThao");
				String maCV= rs.getString("MaCV");
				ds.add(new KyNang(maKyNang, tenKyNang, doThanhThao, maCV));
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
	public int deleteAllKyNangByMaCV(String maCV) throws SQLException {
		String query = "delete from KyNang where MaCV=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maCV);
			
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
