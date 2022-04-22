package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.HinhThucLamViec;
import cntt.trang.bean.NganhNghe;

public class HinhThucLamViecDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<HinhThucLamViec> getAllHinhThucLamViec() throws SQLException {
		ArrayList<HinhThucLamViec> ds=new ArrayList<HinhThucLamViec>();
		String query = "select * from HinhThucLamViec";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maHinhThuc = rs.getLong("MaHinhThuc");
				String tenHinhThuc = rs.getNString("TenHinhThuc");
			
				ds.add(new HinhThucLamViec(maHinhThuc, tenHinhThuc));
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
	public HinhThucLamViec getHinhThucLamViecByID(long maHinhThuc) throws SQLException {
		
		String query = "select * from HinhThucLamViec where MaHinhThuc=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maHinhThuc);
			rs= ps.executeQuery();	
			if(rs.next()) {

				String tenHinhThuc = rs.getNString("TenHinhThuc");
				return new HinhThucLamViec(maHinhThuc, tenHinhThuc);
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
