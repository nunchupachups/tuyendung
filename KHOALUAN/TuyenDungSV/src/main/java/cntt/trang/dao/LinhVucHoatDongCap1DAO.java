package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.LinhVucHoatDongCap1;

public class LinhVucHoatDongCap1DAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<LinhVucHoatDongCap1> getAllLinhVucHoatDongCap1() throws SQLException {
		ArrayList<LinhVucHoatDongCap1> ds=new ArrayList<LinhVucHoatDongCap1>();
		String query = "select * from LinhVucHoatDongCap1";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maLinhVuc = rs.getString("MaLinhVuc"); 
				String tenLinhVuc = rs.getNString("TenLinhVuc");  
				
				ds.add(new LinhVucHoatDongCap1(maLinhVuc, tenLinhVuc));
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
	
	public LinhVucHoatDongCap1 getLinhVucHoatDongCap1ById(String maLinhVuc) throws SQLException {
		String query = "select * from LinhVucHoatDongCap1 where MaLinhVuc = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maLinhVuc);
			rs= ps.executeQuery();	
			if (rs.next()) {
				String tenLinhVuc = rs.getNString("TenLinhVuc"); 
				return new LinhVucHoatDongCap1(maLinhVuc, tenLinhVuc);
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
