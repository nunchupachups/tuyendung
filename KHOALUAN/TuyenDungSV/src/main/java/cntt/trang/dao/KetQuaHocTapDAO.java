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
		String query = "select * from KetQuaHocTap where MaSinhVien=?";
		ArrayList<KetQuaHocTap> ds=new ArrayList<KetQuaHocTap>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maSinhVien);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maHocPhan=rs.getString("MaHocPhan");
				String tenSinhVien= rs.getNString("TenSinhVien");
				int soTinChi=rs.getInt("SoTinChi");
				int hocKy=rs.getInt("HocKy");
				String namHoc=rs.getString("NamHoc");
				float diemHe10=rs.getFloat("DiemHe10");
				float diemHe4=rs.getFloat("DiemHe4");
				String diemChu=rs.getString("DiemChu");
				ds.add(new KetQuaHocTap(maHocPhan, maSinhVien, tenSinhVien, soTinChi, hocKy, namHoc, diemHe10, diemHe4, diemChu));
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
	public ArrayList<TimKiemSV> getAllGPA() throws SQLException {
		String query = "select TenNganh ,HoVaTen,sv.MaSinhVien,  (CASE \r\n" + 
				"    WHEN round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2) is null THEN 0 \r\n" + 
				"    ELSE round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2)\r\n" + 
				"END) as GPA \r\n" + 
				"from KetQuaHocTap as kq right join SinhVien as sv on sv.MaSinhVien=kq.MaSinhVien join NganhDaoTao as ndt on ndt.MaNganh=sv.MaNganhDaoTao\r\n" + 
				"group by TenNganh ,HoVaTen,sv.MaSinhVien order by GPA desc";
		ArrayList<TimKiemSV> ds= new ArrayList<TimKiemSV>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				String maSinhVien=rs.getString("MaSinhVien");
				float GPA=rs.getFloat("GPA");
				String hoVaTen=rs.getNString("HoVaTen");
				String tenNganh=rs.getNString("TenNganh");
				ds.add(new TimKiemSV(maSinhVien, GPA, hoVaTen, tenNganh));
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
}
