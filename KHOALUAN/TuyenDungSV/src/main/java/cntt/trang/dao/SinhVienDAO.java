package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import cntt.trang.bean.SinhVien;
import cntt.trang.bean.TimKiemSV;

public class SinhVienDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
//	public ArrayList<SinhVien> getAllSinhVien() throws SQLException {
//		ArrayList<SinhVien> ds=new ArrayList<SinhVien>();
//		String query = "select * from SinhVien";
//		try {
//			conn = new DBConnect().getConnection();
//			ps = conn.prepareStatement(query);
//			rs= ps.executeQuery();	
//			while(rs.next()) {
//				String maSinhVien=rs.getString("MaSinhVien");
//				String hoVaTen=rs.getNString("HoVaTen");
//				boolean gioiTinh=rs.getBoolean("GioiTinh");
//				String ngaySinh=rs.getString("NgaySinh");
//				String diaChi=rs.getNString("DiaChi");
//				String dienThoai=rs.getString("DienThoai");
//				String diDong=rs.getString("DiDong");
//				String email=rs.getNString("Email");
//				String maNganhDaoTao=rs.getString("MaNganhDaoTao");
//				boolean daDuyet=rs.getBoolean("DaDuyet");
//				int khoa=rs.getInt("Khoa");
//				String anhDaiDien=rs.getNString("AnhDaiDien");
//				Date ngayCapNhat=rs.getDate("NgayCapNhat");
//				
//				ds.add( new SinhVien(maSinhVien, hoVaTen, gioiTinh, ngaySinh, diaChi, dienThoai, diDong, email, maNganhDaoTao, daDuyet, khoa,anhDaiDien, ngayCapNhat));
//				
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if(rs!=null) {
//				rs.close();
//			}
//			if(ps!=null) {
//				ps.close();
//			}
//			if(conn!=null) {
//				conn.close();
//			}	
//		}
//		return ds;
//	}
//	public SinhVien getSinhVienById(String maSinhVien) throws SQLException {
//		String query = "select * from SinhVien where lower(MaSinhVien)=?";
//		try {
//			conn = new DBConnect().getConnection();
//			ps = conn.prepareStatement(query);
//			ps.setString(1,maSinhVien.toLowerCase());
//			rs= ps.executeQuery();	
//			if(rs.next()) {
//				String hoVaTen=rs.getNString("HoVaTen");
//				boolean gioiTinh=rs.getBoolean("GioiTinh");
//				String ngaySinh=rs.getString("NgaySinh");
//				String diaChi=rs.getNString("DiaChi");
//				String dienThoai=rs.getString("DienThoai");
//				String diDong=rs.getString("DiDong");
//				String email=rs.getNString("Email");
//				String maNganhDaoTao=rs.getString("MaNganhDaoTao");
//				boolean daDuyet=rs.getBoolean("DaDuyet");
//				int khoa=rs.getInt("Khoa");
//				String anhDaiDien=rs.getNString("AnhDaiDien");
//				Date ngayCapNhat=rs.getDate("NgayCapNhat");
//				
//				return new SinhVien(maSinhVien, hoVaTen, gioiTinh, ngaySinh, diaChi, dienThoai, diDong, email, maNganhDaoTao, daDuyet, khoa,anhDaiDien, ngayCapNhat);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if(rs!=null) {
//				rs.close();
//			}
//			if(ps!=null) {
//				ps.close();
//			}
//			if(conn!=null) {
//				conn.close();
//			}	
//		}
//		return null;
//	}
	public SinhVien getSinhVienByMaSinhVien(String maSinhVien) throws SQLException {
		String query = "select * from SinhVien where lower(MaSinhVien)=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,maSinhVien.toLowerCase());
			rs= ps.executeQuery();	
			if(rs.next()) {
				String hoVaTen=rs.getNString("HoVaTen");
				boolean gioiTinh=rs.getBoolean("GioiTinh");
				String ngaySinh=rs.getString("NgaySinh");
				String diaChi=rs.getNString("DiaChi");
				String dienThoai=rs.getString("DienThoai");
				String diDong=rs.getString("DiDong");
				String email=rs.getNString("Email");
				String maNganh=rs.getString("MaNganh");
				boolean daDuyet=rs.getBoolean("DaDuyet");
				String maKhoaHoc=rs.getString("MaKhoaHoc");
				String tenKhoaHoc=rs.getString("TenKhoaHoc");
				String anhDaiDien=rs.getNString("AnhDaiDien");
				Date ngayCapNhat=rs.getDate("NgayCapNhat");
				return new SinhVien(maSinhVien, hoVaTen, gioiTinh, ngaySinh, diaChi, dienThoai, diDong, email, maNganh, daDuyet, maKhoaHoc, tenKhoaHoc, anhDaiDien, ngayCapNhat);
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
	public int updateAnhDaiDien(String anhDaiDien, String maSinhVien) throws SQLException {
		String query = "update SinhVien set AnhDaiDien=? where MaSinhVien=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, anhDaiDien);
			ps.setString(2, maSinhVien);
			
			
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
	public ArrayList<TimKiemSV> timKiemAllSinhVien() throws SQLException {
		String query = "select TenNganh ,HoVaTen,sv.MaSinhVien,  (CASE \r\n" + 
				"    WHEN round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2) is null THEN 0 \r\n" + 
				"    ELSE round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2)\r\n" + 
				"END) as GPA \r\n" + 
				"from KetQuaHocTap as kq right join SinhVien as sv on sv.MaSinhVien=kq.MaSinhVien join NganhDaoTao as ndt on ndt.MaNganh=sv.MaNganh where DaDuyet=1\r\n" + 
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
	public ArrayList<TimKiemSV> timKiemSinhVien(String key, int nam, String maNganh, int loaiGPA) throws SQLException {
		String query= "select distinct TenNganh,MaSinhVien,HoVaTen,GPA\r\n" + 
				"from(\r\n" + 
				"	select  MaNganh ,TenNganh,MaSinhVien,TenKyNang,(case \r\n" + 
				"				when Nam is null then 0\r\n" + 
				"				else Nam\r\n" + 
				"				end) as Nam,HoVaTen,(case \r\n" + 
				"					when GPA <2 then 1\r\n" + 
				"					when GPA between 2 and 3 then 2\r\n" + 
				"					when GPA >=3 then 3\r\n" + 
				"					end) as LoaiGPA, GPA\r\n" + 
				"	from(\r\n" + 
				"		select MaNganh ,TenNganh,TenKyNang,HoVaTen,sv.MaSinhVien,(case \r\n" + 
				"										when sum(kq.SoTinChi) between 0 and 29 then 1\r\n" + 
				"										when sum(kq.SoTinChi) between 30 and 59 then 2\r\n" + 
				"										when sum(kq.SoTinChi) between 60 and 89 then 3\r\n" + 
				"										when (sum(kq.SoTinChi) between 90 and 119) and ndt.NamDaoTao=5 then 4\r\n" + 
				"										when (sum(kq.SoTinChi) >=90) and ndt.NamDaoTao=4 then 4\r\n" + 
				"										when (sum(kq.SoTinChi) >=120) and ndt.NamDaoTao=5 then 5\r\n" + 
				"			end) as Nam,  (CASE  \r\n" + 
				"							WHEN round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2) is null THEN 0 \r\n" + 
				"							ELSE round(Sum(kq.SoTinChi*DiemHe4)/sum(kq.SoTinChi),2)\r\n" + 
				"							END) as GPA \r\n" + 
				"		from KetQuaHocTap as kq right join SinhVien as sv on sv.MaSinhVien=kq.MaSinhVien \r\n" + 
				"								left join NganhDaoTao as ndt on ndt.MaNganh=sv.MaNganh\r\n" + 
				"								left join KyNang as kn on kn.MaCV=sv.MaSinhVien where DaDuyet=1\r\n" + 
				"		group by MaNganh ,TenNganh,HoVaTen,sv.MaSinhVien,TenKyNang, NamDaoTao\r\n" + 
				"		) as a\r\n";
		if(!key.equals("")) {
			query+="where TenKyNang like ? ";
			
		}
		query+=") as a " ; 
		if(nam!=-1||loaiGPA!=-1||!maNganh.equals("-1")) query+="where ";
		
		
		int dem=0;
		if(nam!=-1) {
			if(dem==0) query+="Nam=? ";
			else query+="and Nam=? ";
			dem++;
		}
		if(loaiGPA!=-1) {
			if(dem==0) query+="LoaiGPA=? ";
			else query+="and LoaiGPA=? ";
			dem++;
		}
		if(!maNganh.equals("-1")) {
			if(dem==0) query+="MaNganh=? ";
			else query+="and MaNganh=? ";
			dem++;
		}
		query+="order by GPA desc";
		System.out.println(query);
		ArrayList<TimKiemSV> ds= new ArrayList<TimKiemSV>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			dem=0;
			if(!key.equals("")) ps.setNString(++dem, "%"+key+"%");
			
			if(nam!=-1) ps.setInt(++dem, nam);
			if(loaiGPA!=-1) ps.setInt(++dem, loaiGPA);
			if(!maNganh.equals("-1")) ps.setString(++dem, maNganh);
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
	public int updateThongTinSinhVien(String maSinhVien, String hoVaTen, boolean gioiTinh, String ngaySinh, String diaChi,
			String dienThoai, String diDong, String email, String maNganh, boolean daDuyet, String maKhoaHoc,String tenKhoaHoc, Date ngayCapNhat) throws SQLException {
		String query = "update SinhVien set HoVaTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?,DienThoai=?, DiDong=?, Email=?, MaNganh=?, DaDuyet=?, MaKhoaHoc=?,TenKhoaHoc=?, NgayCapNhat=? where MaSinhVien=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, hoVaTen);
			ps.setBoolean(2, gioiTinh);
			ps.setString(3, ngaySinh);
			ps.setNString(4, diaChi);
			ps.setString(5, dienThoai);
			ps.setString(6, diDong);
			ps.setNString(7, email);
			ps.setString(8, maNganh);
			ps.setBoolean(9, daDuyet);
			ps.setString(10, maKhoaHoc);
			ps.setNString(11, tenKhoaHoc);
			ps.setDate(12, new java.sql.Date(ngayCapNhat.getTime()));
			ps.setString(13, maSinhVien);
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
	public int insertSinhVien(String maSinhVien) throws SQLException {
		String query = "insert into SinhVien(MaSinhVien) values(?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maSinhVien);
			
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
