package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.NganhDaoTao;
import cntt.trang.bean.QuanHuyen;

public class NganhDaoTaoDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<NganhDaoTao> getAllNganhDaoTao() throws SQLException {
		ArrayList<NganhDaoTao> ds= new ArrayList<NganhDaoTao>();
		String query = "select * from NganhDaoTao";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while (rs.next()) {
				String maNganh = rs.getString("MaNganh"); 
				String tenNganh = rs.getNString("TenNganh"); 
				ds.add(new NganhDaoTao(maNganh, tenNganh));
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
