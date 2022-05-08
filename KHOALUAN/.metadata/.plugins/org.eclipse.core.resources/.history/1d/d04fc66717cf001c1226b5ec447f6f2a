package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.QuanHuyen;

public class QuanHuyenDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<QuanHuyen> getAllQuanHuyenByMaTinhThanh(String maTinhThanh) throws SQLException {
		ArrayList<QuanHuyen> ds= new ArrayList<QuanHuyen>();
		String query = "select * from QuanHuyen where MaTinhThanh = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maTinhThanh);
			rs= ps.executeQuery();	
			while (rs.next()) {
				String maQuanHuyen = rs.getString("MaQuanHuyen"); 
				String tenQuanHuyen = rs.getNString("TenQuanHuyen"); 
				String type = rs.getNString("Type"); 
				String pathWithType = rs.getNString("path_with_type"); 
				ds.add(new QuanHuyen(maQuanHuyen, tenQuanHuyen, type, pathWithType, maTinhThanh));
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
