package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CVDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public int insertCV(String maSinhVien, String anhDaiDien, String viTriUngTuyen, long maKyNang, String soThich,
			String mucTieuNgheNghiep, long maChungChi) throws SQLException {
		String query = "insert into CV(AnhDaiDien, ViTriUngTuyen, MaKyNang, SoThich, MucTieuNgheNghiep, MaChungChi, MaSinhVien) values(?,?,?,?,?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, anhDaiDien);
			ps.setNString(2, viTriUngTuyen);
			ps.setLong(3, maKyNang);
			ps.setNString(4, soThich);
			ps.setNString(5, mucTieuNgheNghiep);
			ps.setLong(6, maChungChi);
			ps.setString(7, maSinhVien);
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
