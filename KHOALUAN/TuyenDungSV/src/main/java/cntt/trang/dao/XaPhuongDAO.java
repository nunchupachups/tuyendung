package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.QuanHuyen;
import cntt.trang.bean.XaPhuong;

public class XaPhuongDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public XaPhuong getXaPhuongById(String maXaPhuong) throws SQLException {
		String query = "select * from XaPhuong where MaXaPhuong = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maXaPhuong);
			rs= ps.executeQuery();	
			if (rs.next()) {
				String tenXaPhuong = rs.getNString("TenXaPhuong"); 
				String type = rs.getNString("Type"); 
				String pathWithType = rs.getNString("path_with_type"); 
				String maQuanHuyen = rs.getString("MaQuanHuyen");
				return new XaPhuong(maXaPhuong, tenXaPhuong, type, pathWithType, maQuanHuyen);
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
	
	public ArrayList<XaPhuong> getAllXaPhuongByMaQuanHuyen(String maQuanHuyen) throws SQLException {
		ArrayList<XaPhuong> ds= new ArrayList<XaPhuong>();
		String query = "select * from XaPhuong where MaQuanHuyen = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maQuanHuyen);
			rs= ps.executeQuery();	
			while (rs.next()) {
				String maXaPhuong = rs.getString("MaXaPhuong"); 
				String tenXaPhuong = rs.getNString("TenXaPhuong"); 
				String type = rs.getNString("Type"); 
				String pathWithType = rs.getNString("path_with_type"); 
				ds.add(new XaPhuong(maXaPhuong, tenXaPhuong, type, pathWithType, maQuanHuyen));
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
}
