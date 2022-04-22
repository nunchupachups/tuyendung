package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViTriDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public int insertViTri(String tenViTri, String khoangThoiGian, long maDonVi, String moTa) throws SQLException {
		String query = "insert into ViTri(TenViTri, KhoangThoiGian, MaDonVi, MoTa) values(?,?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, tenViTri);
			ps.setNString(2, khoangThoiGian);
			ps.setLong(3, maDonVi);
			ps.setNString(4, moTa);
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
