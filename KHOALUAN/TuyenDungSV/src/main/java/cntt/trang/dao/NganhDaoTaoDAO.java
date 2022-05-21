package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.DonVi;
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
				int soTinChi = rs.getInt("SoTinChi");
				int namDaoTao = rs.getInt("NamDaoTao");
				ds.add(new NganhDaoTao(maNganh, tenNganh, soTinChi, namDaoTao));
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
	public NganhDaoTao getNganhDaoTaoById(String maNganh) throws SQLException {
		String query = "select * from NganhDaoTao where MaNganh=?";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1,maNganh);
			rs= ps.executeQuery();	
			if(rs.next()) {
				String tenNganh=rs.getNString("TenNganh");
				int soTinChi=rs.getInt("SoTinChi");
				int namDaoTao=rs.getInt("NamDaoTao");
				return new NganhDaoTao(maNganh, tenNganh, soTinChi, namDaoTao);
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
	public int insertNganhDaoTao(String maNganh, String tenNganh) throws SQLException {
		String query = "insert into NganhDaoTao(MaNganh, TenNganh) values(?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maNganh);
			ps.setNString(2, tenNganh);
			
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
