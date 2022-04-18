package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.LoaiHinhDoanhNghiep;

public class LoaiHinhDoanhNghiepDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<LoaiHinhDoanhNghiep> getAllLoaiHinhDoanhNghiep() throws SQLException {
		ArrayList<LoaiHinhDoanhNghiep> ds=new ArrayList<LoaiHinhDoanhNghiep>();
		String query = "select * from LoaiHinhDoanhNghiep";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maLoaiHinhDoanhNghiep = rs.getLong("MaLoaiHinhDoanhNghiep"); 
				String tenLoaiHinhDoanhNghiep = rs.getNString("TenLoaiHinhDoanhNghiep");   
				
				ds.add(new LoaiHinhDoanhNghiep(maLoaiHinhDoanhNghiep, tenLoaiHinhDoanhNghiep));
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
