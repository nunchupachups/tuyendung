package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.LinhVucHoatDongCap1;
import cntt.trang.bean.LinhVucHoatDongCap2;
import cntt.trang.bean.TinhThanh;

public class LinhVucHoatDongCap2DAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<LinhVucHoatDongCap2> getAllLinhVucHoatDong() throws SQLException {
		ArrayList<LinhVucHoatDongCap2> ds=new ArrayList<LinhVucHoatDongCap2>();
		String query = "select * from LinhVucHoatDongCap2";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maLinhVuc = rs.getString("MaLinhVuc"); 
				String tenLinhVuc = rs.getNString("TenLinhVuc");  
				String maLinhVucCap1 = rs.getString("MaLinhVucCap1");  
				
				ds.add(new LinhVucHoatDongCap2(maLinhVuc, tenLinhVuc, maLinhVucCap1));
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
	public ArrayList<LinhVucHoatDongCap2> getAllLinhVucHoatDongByIdCap1(String maLinhVucCap1) throws SQLException {
		ArrayList<LinhVucHoatDongCap2> ds=new ArrayList<LinhVucHoatDongCap2>();
		String query = "select * from LinhVucHoatDongCap2 where MaLinhVucCap1 = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maLinhVucCap1);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maLinhVuc = rs.getString("MaLinhVuc"); 
				String tenLinhVuc = rs.getNString("TenLinhVuc");  
				
				ds.add(new LinhVucHoatDongCap2(maLinhVuc, tenLinhVuc, maLinhVucCap1));
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
	public LinhVucHoatDongCap2 getLinhVucHoatDongById(String maLinhVuc) throws SQLException {
		String query = "select * from LinhVucHoatDongCap2 where MaLinhVuc = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maLinhVuc);
			rs= ps.executeQuery();	
			if (rs.next()) {
				String tenLinhVuc = rs.getNString("TenLinhVuc"); 
				String maLinhVucCap1 = rs.getString("MaLinhVucCap1");  
				return new LinhVucHoatDongCap2(maLinhVuc, tenLinhVuc, maLinhVucCap1);
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
