package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cntt.trang.bean.CV;
import cntt.trang.bean.SinhVien;

public class CVDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public int insertCV(String maSinhVien, String viTriUngTuyen, String soThich, String mucTieuNgheNghiep, 
			boolean showKyNang, boolean showChungChi, boolean showSoThich, boolean showMucTieuNgheNghiep,
			boolean showHocVan, boolean showKinhnghiemLamViec, boolean showHoatDong) throws SQLException {
		String query = "insert into CV(MaSinhVien,ViTriUngTuyen, SoThich, MucTieuNgheNghiep,\r\n" + 
				"			ShowKyNang, ShowChungChi, ShowSoThich, ShowMucTieuNgheNghiep,\r\n" + 
				"			ShowHocVan, ShowKinhnghiemLamViec, ShowHoatDong) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, maSinhVien);
			ps.setNString(2, viTriUngTuyen);
			ps.setNString(3, soThich);
			ps.setNString(4, mucTieuNgheNghiep);
			ps.setBoolean(5, showKyNang);
			ps.setBoolean(6, showChungChi);
			ps.setBoolean(7, showSoThich);
			ps.setBoolean(8, showMucTieuNgheNghiep);
			ps.setBoolean(9, showHocVan);
			ps.setBoolean(10, showKinhnghiemLamViec);
			ps.setBoolean(11, showHoatDong);
			
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
	public int updateCV(String maSinhVien, String viTriUngTuyen, String soThich, String mucTieuNgheNghiep, 
			boolean showKyNang, boolean showChungChi, boolean showSoThich, boolean showMucTieuNgheNghiep,
			boolean showHocVan, boolean showKinhnghiemLamViec, boolean showHoatDong) throws SQLException {
		String query = "update CV set ViTriUngTuyen=?, SoThich=?, MucTieuNgheNghiep=?,\r\n" + 
				"			ShowKyNang=?, ShowChungChi=?, ShowSoThich=?, ShowMucTieuNgheNghiep=?,\r\n" + 
				"			ShowHocVan=?, ShowKinhnghiemLamViec=?, ShowHoatDong=? where MaSinhVien=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, viTriUngTuyen);
			ps.setNString(2, soThich);
			ps.setNString(3, mucTieuNgheNghiep);
			ps.setBoolean(4, showKyNang);
			ps.setBoolean(5, showChungChi);
			ps.setBoolean(6, showSoThich);
			ps.setBoolean(7, showMucTieuNgheNghiep);
			ps.setBoolean(8, showHocVan);
			ps.setBoolean(9, showKinhnghiemLamViec);
			ps.setBoolean(10, showHoatDong);
			ps.setString(11, maSinhVien);
			
			
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
	public CV getCVByMaSinhVien(String maSinhVien) throws SQLException {
		String query = "select * from CV where MaSinhVien=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maSinhVien.toLowerCase());
			rs= ps.executeQuery();	
			if(rs.next()) {
				String viTriUngTuyen=rs.getNString("ViTriUngTuyen");
				String soThich=rs.getNString("SoThich");
				String mucTieuNgheNghiep=rs.getNString("MucTieuNgheNghiep");
				boolean showKyNang=rs.getBoolean("ShowKyNang");
				boolean showChungChi=rs.getBoolean("ShowChungChi"); 
				boolean showSoThich=rs.getBoolean("ShowSoThich");
				boolean showMucTieuNgheNghiep=rs.getBoolean("ShowMucTieuNgheNghiep");
				boolean showHocVan=rs.getBoolean("ShowHocVan");
				boolean showKinhnghiemLamViec=rs.getBoolean("ShowKinhnghiemLamViec");
				boolean showHoatDong=rs.getBoolean("ShowHoatDong");
				return new CV(maSinhVien, viTriUngTuyen, soThich, mucTieuNgheNghiep, showKyNang, showChungChi, showSoThich, showMucTieuNgheNghiep, showHocVan, showKinhnghiemLamViec, showHoatDong);
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
