package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.NganhNghe;
import cntt.trang.bean.QuangBa;

public class NganhNgheDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<NganhNghe> getAllNganhNghe() throws SQLException {
		ArrayList<NganhNghe> ds=new ArrayList<NganhNghe>();
		String query = "select * from NganhNghe";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maNganhNghe = rs.getLong("MaNganhNghe");
				String tenNganhNghe = rs.getNString("TenNganhNghe");
			
				ds.add(new NganhNghe(maNganhNghe, tenNganhNghe));
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
	public NganhNghe getNganhNgheByID(long maNganhNghe) throws SQLException {
		
		String query = "select * from NganhNghe where MaNganhNghe=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maNganhNghe);
			rs= ps.executeQuery();	
			if(rs.next()) {
				String tenNganhNghe = rs.getNString("TenNganhNghe");
				return new NganhNghe(maNganhNghe, tenNganhNghe);
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
