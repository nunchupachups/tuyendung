package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

import cntt.trang.bean.QuangBa;
import cntt.trang.bean.TimKiemSV;
import cntt.trang.bean.TuyenDung;

public class TuyenDungDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<TuyenDung> getAllTuyenDungByMaDoanhNghiep(long maDoanhNghiep) throws SQLException {
		ArrayList<TuyenDung> ds=new ArrayList<TuyenDung>();
		String query = "select * from TuyenDung where MaDoanhNghiep=? order by ThoiGianDangBai desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maTuyenDung = rs.getLong("MaTuyenDung");
				long maNganhNghe = rs.getLong("MaNganhNghe"); 
				long maHinhThuc = rs.getLong("MaHinhThuc");
				int sinhVienNam = rs.getInt("SinhVienNam");
				String khuVucTuyenDung = rs.getString("KhuVucTuyenDung");
				String mucLuong = rs.getNString("MucLuong"); 
				String tenCongViec = rs.getNString("TenCongViec");
				String thoiGianThuViec = rs.getNString("ThoiGianThuViec");
				String gioiTinh = rs.getNString("GioiTinh");
				int soLuong = rs.getInt("SoLuong");
				Date hanDangKy = rs.getDate("HanDangKy");
				String tieuDe = rs.getNString("TieuDe");
				String moTaCongViec = rs.getNString("MoTaCongViec");
				String yeuCauCongViec = rs.getNString("YeuCauCongViec");
				String quyenLoi = rs.getNString("QuyenLoi");
				boolean daDuyet = rs.getBoolean("DaDuyet");
				Date thoiGianDangBai=rs.getDate("ThoiGianDangBai");
				ds.add(new TuyenDung(maTuyenDung, maNganhNghe, maHinhThuc, sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi, daDuyet, maDoanhNghiep, thoiGianDangBai));
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
	public ArrayList<TuyenDung> getAllTuyenDungDaDuyetByMaDoanhNghiep(long maDoanhNghiep) throws SQLException {
		ArrayList<TuyenDung> ds=new ArrayList<TuyenDung>();
		String query = "select * from TuyenDung where MaDoanhNghiep=? and DaDuyet=1 order by ThoiGianDangBai desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maTuyenDung = rs.getLong("MaTuyenDung");
				long maNganhNghe = rs.getLong("MaNganhNghe"); 
				long maHinhThuc = rs.getLong("MaHinhThuc");
				int sinhVienNam = rs.getInt("SinhVienNam");
				String khuVucTuyenDung = rs.getString("KhuVucTuyenDung");
				String mucLuong = rs.getNString("MucLuong"); 
				String tenCongViec = rs.getNString("TenCongViec");
				String thoiGianThuViec = rs.getNString("ThoiGianThuViec");
				String gioiTinh = rs.getNString("GioiTinh");
				int soLuong = rs.getInt("SoLuong");
				Date hanDangKy = rs.getDate("HanDangKy");
				String tieuDe = rs.getNString("TieuDe");
				String moTaCongViec = rs.getNString("MoTaCongViec");
				String yeuCauCongViec = rs.getNString("YeuCauCongViec");
				String quyenLoi = rs.getNString("QuyenLoi");
				boolean daDuyet = rs.getBoolean("DaDuyet");
				Date thoiGianDangBai=rs.getDate("ThoiGianDangBai");
				ds.add(new TuyenDung(maTuyenDung, maNganhNghe, maHinhThuc, sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi, daDuyet, maDoanhNghiep, thoiGianDangBai));
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
	public ArrayList<TuyenDung> getAllTuyenDungDaDuyet() throws SQLException {
		ArrayList<TuyenDung> ds=new ArrayList<TuyenDung>();
		String query = "select * from TuyenDung where DaDuyet=?  order by ThoiGianDangBai desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setBoolean(1, true);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maTuyenDung = rs.getLong("MaTuyenDung");
				long maNganhNghe = rs.getLong("MaNganhNghe"); 
				long maHinhThuc = rs.getLong("MaHinhThuc");
				int sinhVienNam = rs.getInt("SinhVienNam");
				String khuVucTuyenDung = rs.getString("KhuVucTuyenDung");
				String mucLuong = rs.getNString("MucLuong"); 
				String tenCongViec = rs.getNString("TenCongViec");
				String thoiGianThuViec = rs.getNString("ThoiGianThuViec");
				String gioiTinh = rs.getNString("GioiTinh");
				int soLuong = rs.getInt("SoLuong");
				Date hanDangKy = rs.getDate("HanDangKy");
				String tieuDe = rs.getNString("TieuDe");
				String moTaCongViec = rs.getNString("MoTaCongViec");
				String yeuCauCongViec = rs.getNString("YeuCauCongViec");
				String quyenLoi = rs.getNString("QuyenLoi");
				boolean daDuyet = rs.getBoolean("DaDuyet");
				Date thoiGianDangBai=rs.getDate("ThoiGianDangBai");
				long maDoanhNghiep=rs.getLong("MaDoanhNghiep");
				ds.add(new TuyenDung(maTuyenDung, maNganhNghe, maHinhThuc, sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi, daDuyet, maDoanhNghiep, thoiGianDangBai));
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
	public TuyenDung getTuyenDungByID(long maTuyenDung) throws SQLException {
			
			String query = "select * from TuyenDung where MaTuyenDung=?";
			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				ps.setLong(1, maTuyenDung);
				rs= ps.executeQuery();	
				if(rs.next()) {
					long maNganhNghe = rs.getLong("MaNganhNghe"); 
					long maHinhThuc = rs.getLong("MaHinhThuc");
					int sinhVienNam = rs.getInt("SinhVienNam");
					String khuVucTuyenDung = rs.getString("KhuVucTuyenDung");
					String mucLuong = rs.getNString("MucLuong"); 
					String tenCongViec = rs.getNString("TenCongViec");
					String thoiGianThuViec = rs.getNString("ThoiGianThuViec");
					String gioiTinh = rs.getNString("GioiTinh");
					int soLuong = rs.getInt("SoLuong");
					Date hanDangKy = rs.getDate("HanDangKy");
					String tieuDe = rs.getNString("TieuDe");
					String moTaCongViec = rs.getNString("MoTaCongViec");
					String yeuCauCongViec = rs.getNString("YeuCauCongViec");
					String quyenLoi = rs.getNString("QuyenLoi");
					boolean daDuyet = rs.getBoolean("DaDuyet");
					long maDoanhNghiep = rs.getLong("MaDoanhNghiep");	
					Date thoiGianDangBai=rs.getDate("ThoiGianDangBai");
					return new TuyenDung(maTuyenDung, maNganhNghe, maHinhThuc, sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi, daDuyet, maDoanhNghiep, thoiGianDangBai);
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
		public int insertTuyenDung(long maNganhNghe, long maHinhThuc, int sinhVienNam, String khuVucTuyenDung,
				String mucLuong, String tenCongViec, String thoiGianThuViec, String gioiTinh, int soLuong, Date hanDangKy,
				String tieuDe, String moTaCongViec, String yeuCauCongViec, String quyenLoi, boolean daDuyet,
				long maDoanhNghiep) throws SQLException {
			String query = "insert into TuyenDung(MaNganhNghe, MaHinhThuc,KhuVucTuyenDung,MucLuong, TenCongViec,SoLuong, HanDangKy,TieuDe, MoTaCongViec, YeuCauCongViec, QuyenLoi, DaDuyet,MaDoanhNghiep, ThoiGianDangBai ,SinhVienNam,ThoiGianThuViec,GioiTinh) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int flag=-1;
			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				ps.setLong(1, maNganhNghe);
				ps.setLong(2, maHinhThuc);
				ps.setString(3, khuVucTuyenDung);
				ps.setNString(4, mucLuong);
				ps.setNString(5, tenCongViec);		
				ps.setInt(6, soLuong);
				ps.setDate(7, new java.sql.Date(hanDangKy.getTime()) );
				ps.setNString(8, tieuDe);
				ps.setNString(9, moTaCongViec);
				ps.setNString(10, yeuCauCongViec);
				ps.setNString(11, quyenLoi);
				ps.setBoolean(12, daDuyet);
				ps.setLong(13, maDoanhNghiep);
				ps.setDate(14, new java.sql.Date(new Date().getTime()));
				if(sinhVienNam!=0) ps.setInt(15, sinhVienNam);
				else ps.setNull(15, Types.INTEGER);
				if(thoiGianThuViec!=null) ps.setNString(16, thoiGianThuViec);
				else ps.setNull(16, Types.NVARCHAR);
				if(gioiTinh!=null) ps.setNString(17, gioiTinh);
				else ps.setNull(17, Types.NVARCHAR);
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
		
		public int deleteTuyenDung(long maTuyenDung) throws SQLException {
			String query = "delete from TuyenDung where MaTuyenDung=?";
			int flag=-1;
			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				ps.setLong(1, maTuyenDung);
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
		public int updateTuyenDung(long maTuyenDung, long maNganhNghe, long maHinhThuc, int sinhVienNam, String khuVucTuyenDung,
				String mucLuong, String tenCongViec, String thoiGianThuViec, String gioiTinh, int soLuong, Date hanDangKy,
				String tieuDe, String moTaCongViec, String yeuCauCongViec, String quyenLoi) throws SQLException {
			String query = "update TuyenDung set MaNganhNghe=?, MaHinhThuc=?, SinhVienNam=?,KhuVucTuyenDung=?,MucLuong=?, TenCongViec=?, ThoiGianThuViec=?, GioiTinh=?, SoLuong=?, HanDangKy=?,TieuDe=?, MoTaCongViec=?, YeuCauCongViec=?, QuyenLoi=? where MaTuyenDung=?";
			int flag=-1;
			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				ps.setLong(1, maNganhNghe);
				ps.setLong(2, maHinhThuc);
				if(sinhVienNam!=0) ps.setInt(3, sinhVienNam);
				else ps.setNull(3, Types.INTEGER);
				ps.setString(4, khuVucTuyenDung);
				ps.setNString(5, mucLuong);
				ps.setNString(6, tenCongViec);
				if(thoiGianThuViec!=null) ps.setNString(7, thoiGianThuViec);
				else ps.setNull(7, Types.NVARCHAR);
				if(gioiTinh!=null) ps.setNString(8, gioiTinh);
				else ps.setNull(8, Types.NVARCHAR);
				ps.setInt(9, soLuong);
				ps.setDate(10, new java.sql.Date(hanDangKy.getTime()) );
				ps.setNString(11, tieuDe);
				ps.setNString(12, moTaCongViec);
				ps.setNString(13, yeuCauCongViec);
				ps.setNString(14, quyenLoi);
				ps.setLong(15, maTuyenDung);
				
				
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
		public ArrayList<TuyenDung> timKiemTuyenDung(int page, String key, long maNganhNghe, long maHinhThuc, String maKhuVuc) throws SQLException {
			int startItem= (page-1)*10;
			String query= "select td.* from TuyenDung as td join DoanhNghiep as dn on dn.MaDoanhNghiep=td.MaDoanhNghiep ";
			if(!key.equals("")||maNganhNghe!=-1||maHinhThuc!=-1||!maKhuVuc.equals("-1")) query+="where ";
			int dem=0;
			if(!key.equals("")) {
				if(dem==0) query+="(TenCongViec like ? or TieuDe like ? or TenDoanhNghiep like ?) ";
				else query+="and (TenCongViec like ? or TieuDe like ? or TenDoanhNghiep like ?) ";
				dem++;
			}
			if(maNganhNghe!=-1) {
				if(dem==0) query+="MaNganhNghe=? ";
				else query+="and MaNganhNghe=? ";
				dem++;
			}
			if(maHinhThuc!=-1) {
				if(dem==0) query+="MaHinhThuc=? ";
				else query+="and MaHinhThuc=? ";
				dem++;
			}
			if(!maKhuVuc.equals("-1")) {
				if(dem==0) query+="KhuVucTuyenDung=? ";
				else query+="and KhuVucTuyenDung=? ";
				dem++;
			}
			
			query+=" and td.DaDuyet=1 and HanDangKy>= ? order by ThoiGianDangBai desc OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
			System.out.println(query);
			ArrayList<TuyenDung> ds= new ArrayList<TuyenDung>();
			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				dem=0;
				if(!key.equals("")) {
					ps.setNString(++dem, "%"+key+"%");
					ps.setNString(++dem, "%"+key+"%");
					ps.setNString(++dem, "%"+key+"%");
				}
				
				if(maNganhNghe!=-1) ps.setLong(++dem, maNganhNghe);
				if(maHinhThuc!=-1) ps.setLong(++dem, maHinhThuc);
				if(!maKhuVuc.equals("-1")) ps.setString(++dem, maKhuVuc);
				ps.setDate(++dem, new java.sql.Date(new Date().getTime()));
				ps.setInt(++dem, startItem);
				rs= ps.executeQuery();	
				while(rs.next()) {
					long maNganhNghe1 = rs.getLong("MaNganhNghe"); 
					long maHinhThuc1 = rs.getLong("MaHinhThuc");
					int sinhVienNam = rs.getInt("SinhVienNam");
					String khuVucTuyenDung = rs.getString("KhuVucTuyenDung");
					String mucLuong = rs.getNString("MucLuong"); 
					String tenCongViec = rs.getNString("TenCongViec");
					String thoiGianThuViec = rs.getNString("ThoiGianThuViec");
					String gioiTinh = rs.getNString("GioiTinh");
					int soLuong = rs.getInt("SoLuong");
					Date hanDangKy = rs.getDate("HanDangKy");
					String tieuDe = rs.getNString("TieuDe");
					String moTaCongViec = rs.getNString("MoTaCongViec");
					String yeuCauCongViec = rs.getNString("YeuCauCongViec");
					String quyenLoi = rs.getNString("QuyenLoi");
					boolean daDuyet = rs.getBoolean("DaDuyet");
					long maDoanhNghiep = rs.getLong("MaDoanhNghiep");	
					Date thoiGianDangBai=rs.getDate("ThoiGianDangBai");
					long maTuyenDung=rs.getLong("MaTuyenDung");
					ds.add(new TuyenDung(maTuyenDung, maNganhNghe1, maHinhThuc1, sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi, daDuyet, maDoanhNghiep, thoiGianDangBai));
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
		public ArrayList<TuyenDung> timKiemTuyenDungByMaDoanhNghiep(long maDoanhNghiep, String key, long maNganhNghe, long maHinhThuc, String maKhuVuc) throws SQLException {
			String query= "select * from TuyenDung where ";
			int dem=0;
			if(!key.equals("")) {
				if(dem==0) query+="(TenCongViec like ? or TieuDe like ?) ";
				else query+="and (TenCongViec like ? or TieuDe like ?) ";
				dem++;
			}
			if(maNganhNghe!=-1) {
				if(dem==0) query+="MaNganhNghe=? ";
				else query+="and MaNganhNghe=? ";
				dem++;
			}
			if(maHinhThuc!=-1) {
				if(dem==0) query+="MaHinhThuc=? ";
				else query+="and MaHinhThuc=? ";
				dem++;
			}
			if(!maKhuVuc.equals("-1")) {
				if(dem==0) query+="KhuVucTuyenDung=? ";
				else query+="and KhuVucTuyenDung=? ";
				dem++;
			}
			if(dem==0) query+=" MaDoanhNghiep= ? order by ThoiGianDangBai desc";
			else query+=" and MaDoanhNghiep= ? order by ThoiGianDangBai desc";
			System.out.println(query);
			ArrayList<TuyenDung> ds= new ArrayList<TuyenDung>();
			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				dem=0;
				if(!key.equals("")) {
					ps.setNString(++dem, "%"+key+"%");
					ps.setNString(++dem, "%"+key+"%");
				}
				
				if(maNganhNghe!=-1) ps.setLong(++dem, maNganhNghe);
				if(maHinhThuc!=-1) ps.setLong(++dem, maHinhThuc);
				if(!maKhuVuc.equals("-1")) ps.setString(++dem, maKhuVuc);
				ps.setLong(++dem, maDoanhNghiep);
				rs= ps.executeQuery();	
				while(rs.next()) {
					long maNganhNghe1 = rs.getLong("MaNganhNghe"); 
					long maHinhThuc1 = rs.getLong("MaHinhThuc");
					int sinhVienNam = rs.getInt("SinhVienNam");
					String khuVucTuyenDung = rs.getString("KhuVucTuyenDung");
					String mucLuong = rs.getNString("MucLuong"); 
					String tenCongViec = rs.getNString("TenCongViec");
					String thoiGianThuViec = rs.getNString("ThoiGianThuViec");
					String gioiTinh = rs.getNString("GioiTinh");
					int soLuong = rs.getInt("SoLuong");
					Date hanDangKy = rs.getDate("HanDangKy");
					String tieuDe = rs.getNString("TieuDe");
					String moTaCongViec = rs.getNString("MoTaCongViec");
					String yeuCauCongViec = rs.getNString("YeuCauCongViec");
					String quyenLoi = rs.getNString("QuyenLoi");
					boolean daDuyet = rs.getBoolean("DaDuyet");	
					Date thoiGianDangBai=rs.getDate("ThoiGianDangBai");
					long maTuyenDung=rs.getLong("MaTuyenDung");
					ds.add(new TuyenDung(maTuyenDung, maNganhNghe1, maHinhThuc1, sinhVienNam, khuVucTuyenDung, mucLuong, tenCongViec, thoiGianThuViec, gioiTinh, soLuong, hanDangKy, tieuDe, moTaCongViec, yeuCauCongViec, quyenLoi, daDuyet, maDoanhNghiep, thoiGianDangBai));
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
		public int getSoPage(String key, long maNganhNghe, long maHinhThuc, String maKhuVuc) throws SQLException {
			int soPage=0;
			String query= "select count(1) from TuyenDung as td join DoanhNghiep as dn on dn.MaDoanhNghiep=td.MaDoanhNghiep ";
			if(!key.equals("")||maNganhNghe!=-1||maHinhThuc!=-1||!maKhuVuc.equals("-1")) query+="where ";
			int dem=0;
			if(!key.equals("")) {
				if(dem==0) query+="(TenCongViec like ? or TieuDe like ? or TenDoanhNghiep like ?) ";
				else query+="and (TenCongViec like ? or TieuDe like ? or TenDoanhNghiep like ?) ";
				dem++;
			}
			if(maNganhNghe!=-1) {
				if(dem==0) query+="MaNganhNghe=? ";
				else query+="and MaNganhNghe=? ";
				dem++;
			}
			if(maHinhThuc!=-1) {
				if(dem==0) query+="MaHinhThuc=? ";
				else query+="and MaHinhThuc=? ";
				dem++;
			}
			if(!maKhuVuc.equals("-1")) {
				if(dem==0) query+="KhuVucTuyenDung=? ";
				else query+="and KhuVucTuyenDung=? ";
				dem++;
			}
			query+=" and td.DaDuyet=1 and HanDangKy>= ?";
			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				dem=0;
				if(!key.equals("")) {
					ps.setNString(++dem, "%"+key+"%");
					ps.setNString(++dem, "%"+key+"%");
					ps.setNString(++dem, "%"+key+"%");
				}
				
				if(maNganhNghe!=-1) ps.setLong(++dem, maNganhNghe);
				if(maHinhThuc!=-1) ps.setLong(++dem, maHinhThuc);
				if(!maKhuVuc.equals("-1")) ps.setString(++dem, maKhuVuc);
				ps.setDate(++dem, new java.sql.Date(new Date().getTime()));
				rs= ps.executeQuery();	
				while(rs.next()) {
					soPage = rs.getInt(1);
					
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
			if(soPage%10==0) return soPage/10;
			else return soPage/10+1;
		}
}
