package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.ChungChi;
import cntt.trang.bean.ViTri;

public class ChungChiDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public int insertChungChi(String tenChungChi, String nam, String maCV) throws SQLException {
		String query = "insert into ChungChi(TenChungChi, Nam, MaCV) values(?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, tenChungChi);
			ps.setString(2, nam);
			ps.setString(3, maCV);
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
	public ArrayList<ChungChi> getAllChungChiByMaCV(String maCV) throws SQLException {
		String query = "select * from ChungChi where MaCV=?";
		ArrayList<ChungChi> ds=new ArrayList<ChungChi>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maCV);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maChungChi= rs.getLong("MaChungChi");
				String tenChungChi=rs.getNString("TenChungChi");
				String nam=rs.getString("Nam");
				
				ds.add(new ChungChi(maChungChi, tenChungChi, nam, maCV));
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
	public ArrayList<ChungChi> getAllChungChi() throws SQLException {
		String query = "select * from ChungChi";
		ArrayList<ChungChi> ds=new ArrayList<ChungChi>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maChungChi= rs.getLong("MaChungChi");
				String tenChungChi=rs.getNString("TenChungChi");
				String nam=rs.getString("Nam");
				String maCV=rs.getString("MaCV");
				ds.add(new ChungChi(maChungChi, tenChungChi, nam, maCV));
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
	public int deleteAllChungChiByMaCV(String maCV) throws SQLException {
		String query = "delete from ChungChi where MaCV=?";
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
