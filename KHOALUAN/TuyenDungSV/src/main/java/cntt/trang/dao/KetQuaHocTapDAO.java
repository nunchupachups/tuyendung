package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import cntt.trang.bean.KetQuaHocTap;
import cntt.trang.bean.TimKiemSV;

public class KetQuaHocTapDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	public ArrayList<KetQuaHocTap> getAllKetQuaHocTapByMaSinhVien(String maSinhVien) throws SQLException {
		String query = "select MaHocPhan, MaSinhVien,TenHocPhan, SoTinChi, a.NamHoc, DiemHe10, DiemHe4, DiemChu, a.HocKy,TongSoTinChiTheoKy\r\n" + 
				"from(\r\n" + 
				"select NamHoc,HocKy, sum(SoTinChi) as TongSoTinChiTheoKy\r\n" + 
				"from KetQuaHocTap\r\n" + 
				"where MaSinhVien=?\r\n" + 
				"group by NamHoc,  HocKy\r\n" + 
				") as a join KetQuaHocTap as kq on kq.HocKy=a.HocKy and a.NamHoc=kq.NamHoc\r\n" + 
				"where MaSinhVien=?\r\n" + 
				"order by NamHoc,HocKy, MaHocPhan";
		ArrayList<KetQuaHocTap> ds=new ArrayList<KetQuaHocTap>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maSinhVien);
			ps.setString(2,maSinhVien);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maHocPhan=rs.getString("MaHocPhan");
				String tenHocPhan= rs.getNString("TenHocPhan");
				int soTinChi=rs.getInt("SoTinChi");
				int hocKy=rs.getInt("HocKy");
				String namHoc=rs.getString("NamHoc");
				float diemHe10=rs.getFloat("DiemHe10");
				float diemHe4=rs.getFloat("DiemHe4");
				String diemChu=rs.getString("DiemChu");
				int tongSoTinChiTheoKy=rs.getInt("TongSoTinChiTheoKy");
				ds.add(new KetQuaHocTap(maHocPhan, maSinhVien, tenHocPhan, soTinChi, hocKy, namHoc, diemHe10, diemHe4, diemChu,tongSoTinChiTheoKy));
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
	
	public int getSumSoTinChiByMaSinhVien(String maSinhVien) throws SQLException {
		String query = "select MaSinhVien, Sum(SoTinChi) as SoTinChi from KetQuaHocTap where MaSinhVien=? group by MaSinhVien";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maSinhVien);
			rs= ps.executeQuery();	
			if(rs.next()) {
				int soTinChi=rs.getInt("SoTinChi");
				return soTinChi;
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
		return 0;
	}
	public float getGPAByMaSinhVien(String maSinhVien) throws SQLException {
		String query = "select sv.MaSinhVien,(CASE \r\n" + 
				"    WHEN round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2) is null THEN 0 \r\n" + 
				"    ELSE round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2)\r\n" + 
				"END) as GPA \r\n" + 
				"from KetQuaHocTap as kq right join SinhVien as sv on sv.MaSinhVien=kq.MaSinhVien where sv.MaSinhVien=?\r\n" + 
				"group by sv.MaSinhVien";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			rs= ps.executeQuery();	
			if(rs.next()) {
				float GPA=rs.getFloat("GPA");
				return GPA;
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
		return 0;
	}
}
