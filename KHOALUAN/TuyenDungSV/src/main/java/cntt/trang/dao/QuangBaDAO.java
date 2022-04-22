package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.QuangBa;

public class QuangBaDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<QuangBa> getAllQuangBaByMaDoanhNghiep(long maDoanhNghiep) throws SQLException {
		ArrayList<QuangBa> ds=new ArrayList<QuangBa>();
		String query = "select * from QuangBa where MaDoanhNghiep=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maQuangBa = rs.getLong("MaQuangBa");
				String tieuDe = rs.getNString("TieuDe");
				String noiDungDaiDien = rs.getNString("NoiDungDaiDien");
				String hinhAnhDaiDien = rs.getNString("HinhAnhDaiDien");
				String baiViet = rs.getNString("BaiViet");
				boolean daDuyet = rs.getBoolean("DaDuyet");
					
				ds.add(new QuangBa(maQuangBa, tieuDe, noiDungDaiDien, hinhAnhDaiDien, baiViet, daDuyet, maDoanhNghiep));
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
	public ArrayList<QuangBa> getAllQuangBaDaDuyetByMaDoanhNghiep(long maDoanhNghiep) throws SQLException {
		ArrayList<QuangBa> ds=new ArrayList<QuangBa>();
		String query = "select * from QuangBa where DaDuyet=1 and MaDoanhNghiep=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maQuangBa = rs.getLong("MaQuangBa");
				String tieuDe = rs.getNString("TieuDe");
				String noiDungDaiDien = rs.getNString("NoiDungDaiDien");
				String hinhAnhDaiDien = rs.getNString("HinhAnhDaiDien");
				String baiViet = rs.getNString("BaiViet");
				boolean daDuyet = rs.getBoolean("DaDuyet");
					
				ds.add(new QuangBa(maQuangBa, tieuDe, noiDungDaiDien, hinhAnhDaiDien, baiViet, daDuyet, maDoanhNghiep));
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
	public QuangBa getQuangBaByID(long maQuangBa) throws SQLException {
		
		String query = "select * from QuangBa where MaQuangBa=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maQuangBa);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String tieuDe = rs.getNString("TieuDe");
				String noiDungDaiDien = rs.getNString("NoiDungDaiDien");
				String hinhAnhDaiDien = rs.getNString("HinhAnhDaiDien");
				String baiViet = rs.getNString("BaiViet");
				boolean daDuyet = rs.getBoolean("DaDuyet");
				long maDoanhNghiep = rs.getLong("MaDoanhNghiep");	
				return new QuangBa(maQuangBa, tieuDe, noiDungDaiDien, hinhAnhDaiDien, baiViet, daDuyet, maDoanhNghiep);
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
	public int insertQuangBa(String tieuDe, String noiDungDaiDien, String hinhAnhDaiDien, String baiViet, boolean daDuyet, long maDoanhNghiep) throws SQLException {
		String query = "insert into QuangBa(TieuDe, NoiDungDaiDien, HinhAnhDaiDien, BaiViet, DaDuyet, MaDoanhNghiep) values(?,?,?,?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, tieuDe);
			ps.setNString(2, noiDungDaiDien);
			ps.setNString(3, hinhAnhDaiDien);
			ps.setNString(4, baiViet);
			ps.setBoolean(5, daDuyet);
			ps.setLong(6, maDoanhNghiep);
			
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
	
	public int deleteQuangBa(long maQuangBa) throws SQLException {
		String query = "delete from QuangBa where MaQuangBa=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maQuangBa);
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
	public int updateQuangBa(long maQuangBa, String tieuDe, String noiDungDaiDien, String hinhAnhDaiDien, String baiViet) throws SQLException {
		String query = "update QuangBa set TieuDe=?, NoiDungDaiDien=?, HinhAnhDaiDien=?, BaiViet=? where MaQuangBa=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, tieuDe);
			ps.setNString(2, noiDungDaiDien);
			ps.setNString(3, hinhAnhDaiDien);
			ps.setNString(4, baiViet);
			ps.setLong(5, maQuangBa);
			
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
