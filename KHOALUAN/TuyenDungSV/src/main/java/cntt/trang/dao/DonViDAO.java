package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cntt.trang.bean.DonVi;
import cntt.trang.bean.KyNang;

public class DonViDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public int insertDonVi(String tenDonVi, String maCV, String mucCV) throws SQLException {
		String query = "insert into DonVi(TenDonVi, MaCV, MucCV) values(?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, tenDonVi);
			ps.setString(2, maCV);
			ps.setNString(3, mucCV);
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
	public ArrayList<DonVi> getAllDonViByMucCVAndMaCV(String mucCV, String maCV) throws SQLException {
		String query = "select * from DonVi where MucCV=? and MaCV=?";
		ArrayList<DonVi> ds=new ArrayList<DonVi>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1,mucCV);
			ps.setString(2,maCV);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maDonVi= rs.getLong("MaDonVi");
				String tenDonVi=rs.getNString("TenDonVi");
				ds.add(new DonVi(maDonVi, tenDonVi, maCV, mucCV));
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
	public ArrayList<DonVi> getAllDonVi() throws SQLException {
		String query = "select * from DonVi";
		ArrayList<DonVi> ds=new ArrayList<DonVi>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maDonVi= rs.getLong("MaDonVi");
				String tenDonVi=rs.getNString("TenDonVi");
				String maCV=rs.getString("MaCV");
				String mucCV=rs.getNString("MucCV");
				ds.add(new DonVi(maDonVi, tenDonVi, maCV, mucCV));
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
	public DonVi getDonViByTenDonViAndMucCVAndMaCV(String mucCV, String maCV,String tenDonVi) throws SQLException {
		String query = "select * from DonVi where TenDonVi=? and MucCV=? and MaCV=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1,tenDonVi);
			ps.setNString(2,mucCV);
			ps.setString(3,maCV);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maDonVi= rs.getLong("MaDonVi");
				return new DonVi(maDonVi, tenDonVi, maCV, mucCV);
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
	public int deleteAllDonViByMaCV(String maCV) throws SQLException {
		String query = "delete from DonVi where MaCV=?";
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
