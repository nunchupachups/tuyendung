package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.TinhThanh;

public class TinhThanhDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<TinhThanh> getAllTinhThanh() throws SQLException {
		ArrayList<TinhThanh> ds=new ArrayList<TinhThanh>();
		String query = "select * from TinhThanh";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maTinhThanh = rs.getString("MaTinhThanh"); 
				String tenTinhThanh = rs.getNString("TenTinhThanh");  
				String type = rs.getNString("Type"); 
				
				ds.add(new TinhThanh(maTinhThanh, tenTinhThanh, type));
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
	public TinhThanh getTinhThanhById(String maTinhThanh) throws SQLException {
		String query = "select * from TinhThanh where MaTinhThanh=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maTinhThanh);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String tenTinhThanh = rs.getNString("TenTinhThanh");  
				String type = rs.getNString("Type"); 
				
				return new TinhThanh(maTinhThanh, tenTinhThanh, type);
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
