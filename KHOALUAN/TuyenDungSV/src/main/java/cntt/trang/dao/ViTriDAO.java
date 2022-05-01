package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.DonVi;
import cntt.trang.bean.ViTri;

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
	public ArrayList<ViTri> getAllViTriByMaDonVi(long maDonVi) throws SQLException {
		String query = "select * from ViTri where MaDonVi=?";
		ArrayList<ViTri> ds=new ArrayList<ViTri>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1,maDonVi);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maViTri= rs.getLong("MaViTri");
				String tenViTri=rs.getNString("TenViTri");
				String khoangThoiGian=rs.getNString("KhoangThoiGian");
				String moTa=rs.getNString("MoTa");
				ds.add(new ViTri(maViTri, tenViTri, khoangThoiGian, maDonVi, moTa));
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
	public ArrayList<ViTri> getAllViTri() throws SQLException {
		String query = "select * from ViTri";
		ArrayList<ViTri> ds=new ArrayList<ViTri>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maViTri= rs.getLong("MaViTri");
				String tenViTri=rs.getNString("TenViTri");
				String khoangThoiGian=rs.getNString("KhoangThoiGian");
				String moTa=rs.getNString("MoTa");
				long maDonVi=rs.getLong("maDonVi");
				ds.add(new ViTri(maViTri, tenViTri, khoangThoiGian, maDonVi, moTa));
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
	public int deleteAllViTriByMaCV(String maCV) throws SQLException {
		String query = "delete from ViTri where MaViTri in(select MaViTri\r\n" + 
				"from ViTri as vt join DonVi as dv on vt.MaDonVi=dv.MaDonVi\r\n" + 
				"where MaCV=?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maCV);
			
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
