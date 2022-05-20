package cntt.trang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

import cntt.trang.bean.Blog;

public class BlogDAO {
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs= null;
	
	public ArrayList<Blog> timKiemBlogByMaDoanhNghiep(String key, long maDoanhNghiep) throws SQLException {
		String query= "select * from Blog where MaDoanhNghiep=?";
		if(!key.equals("")) query+="and (TacGia like ? or TieuDe like ?)";
		ArrayList<Blog> ds= new ArrayList<Blog>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1,maDoanhNghiep);
			if(!key.equals("")) {
				ps.setNString(2, "%"+key+"%");
				ps.setNString(3, "%"+key+"%");
			}
			
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maBlog =rs.getLong("MaBlog");
				String tieuDe=rs.getNString("TieuDe"); 
				String noiDung=rs.getNString("NoiDung"); 
				String tacGia=rs.getNString("TacGia"); 
				Date ngayDang=rs.getDate("NgayDang"); 
				String anh=rs.getNString("Anh"); 
				int luotXem=rs.getInt("LuotXem"); 
				boolean daDuyet=rs.getBoolean("DaDuyet"); 
				String phanHoi=rs.getNString("PhanHoi");
				ds.add(new Blog(maBlog, maDoanhNghiep, tieuDe, noiDung, tacGia, ngayDang, anh, luotXem, daDuyet, phanHoi));
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
	
	public ArrayList<Blog> timKiemBlogDaDuyetByKey(String key) throws SQLException {
		String query= "select * from Blog where DaDuyet=1";
		if(!key.equals("")) query+="and TacGia like ? or TieuDe like ?";
		query+=" order by NgayDang desc ";
		ArrayList<Blog> ds= new ArrayList<Blog>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			if(!key.equals("")) {
				ps.setNString(1, "%"+key+"%");
				ps.setNString(2, "%"+key+"%");
			}
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maBlog =rs.getLong("MaBlog");
				String tieuDe=rs.getNString("TieuDe"); 
				String noiDung=rs.getNString("NoiDung"); 
				String tacGia=rs.getNString("TacGia"); 
				Date ngayDang=rs.getDate("NgayDang"); 
				String anh=rs.getNString("Anh"); 
				int luotXem=rs.getInt("LuotXem"); 
				boolean daDuyet=rs.getBoolean("DaDuyet"); 
				String phanHoi=rs.getNString("PhanHoi");
				long maDoanhNghiep =rs.getLong("MaDoanhNghiep");
				ds.add(new Blog(maBlog, maDoanhNghiep, tieuDe, noiDung, tacGia, ngayDang, anh, luotXem, daDuyet, phanHoi));
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
	public ArrayList<Blog> getTop10BlogByLuotXem() throws SQLException {
		String query= "select top 10 * from Blog where DaDuyet=1 order by LuotXem desc";
		ArrayList<Blog> ds= new ArrayList<Blog>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maBlog =rs.getLong("MaBlog");
				String tieuDe=rs.getNString("TieuDe"); 
				String noiDung=rs.getNString("NoiDung"); 
				String tacGia=rs.getNString("TacGia"); 
				Date ngayDang=rs.getDate("NgayDang"); 
				String anh=rs.getNString("Anh"); 
				int luotXem=rs.getInt("LuotXem"); 
				boolean daDuyet=rs.getBoolean("DaDuyet"); 
				String phanHoi=rs.getNString("PhanHoi");
				long maDoanhNghiep =rs.getLong("MaDoanhNghiep");
				ds.add(new Blog(maBlog, maDoanhNghiep, tieuDe, noiDung, tacGia, ngayDang, anh, luotXem, daDuyet, phanHoi));
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
	public ArrayList<Blog> getAllBlogDaDuyet() throws SQLException {
		String query= "select * from Blog where DaDuyet=1 order by NgayDang desc";
		ArrayList<Blog> ds= new ArrayList<Blog>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maBlog =rs.getLong("MaBlog");
				String tieuDe=rs.getNString("TieuDe"); 
				String noiDung=rs.getNString("NoiDung"); 
				String tacGia=rs.getNString("TacGia"); 
				Date ngayDang=rs.getDate("NgayDang"); 
				String anh=rs.getNString("Anh"); 
				int luotXem=rs.getInt("LuotXem"); 
				boolean daDuyet=rs.getBoolean("DaDuyet"); 
				String phanHoi=rs.getNString("PhanHoi");
				long maDoanhNghiep =rs.getLong("MaDoanhNghiep");
				ds.add(new Blog(maBlog, maDoanhNghiep, tieuDe, noiDung, tacGia, ngayDang, anh, luotXem, daDuyet, phanHoi));
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
	public ArrayList<Blog> getAllBlogChuaDuyet() throws SQLException {
		String query= "select * from Blog where DaDuyet=0 order by NgayDang desc";
		ArrayList<Blog> ds= new ArrayList<Blog>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();	
			while(rs.next()) {
				long maBlog =rs.getLong("MaBlog");
				String tieuDe=rs.getNString("TieuDe"); 
				String noiDung=rs.getNString("NoiDung"); 
				String tacGia=rs.getNString("TacGia"); 
				Date ngayDang=rs.getDate("NgayDang"); 
				String anh=rs.getNString("Anh"); 
				int luotXem=rs.getInt("LuotXem"); 
				boolean daDuyet=rs.getBoolean("DaDuyet"); 
				String phanHoi=rs.getNString("PhanHoi");
				long maDoanhNghiep =rs.getLong("MaDoanhNghiep");
				ds.add(new Blog(maBlog, maDoanhNghiep, tieuDe, noiDung, tacGia, ngayDang, anh, luotXem, daDuyet, phanHoi));
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
	
	public Blog getBlogById(long maBlog) throws SQLException {
		String query= "select * from Blog where MaBlog=? ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maBlog);
			rs= ps.executeQuery();	
			if(rs.next()) {
				long maDoanhNghiep =rs.getLong("MaDoanhNghiep");
				String tieuDe=rs.getNString("TieuDe"); 
				String noiDung=rs.getNString("NoiDung"); 
				String tacGia=rs.getNString("TacGia"); 
				Date ngayDang=rs.getDate("NgayDang"); 
				String anh=rs.getNString("Anh"); 
				int luotXem=rs.getInt("LuotXem"); 
				boolean daDuyet=rs.getBoolean("DaDuyet"); 
				String phanHoi=rs.getNString("PhanHoi");
				return new Blog(maBlog, maDoanhNghiep, tieuDe, noiDung, tacGia, ngayDang, anh, luotXem, daDuyet, phanHoi);
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
	public int insertBlog(long maDoanhNghiep, String tieuDe, String noiDung, String tacGia,String anh) throws SQLException {
		String query = "insert into Blog(MaDoanhNghiep, TieuDe, NoiDung, TacGia,NgayDang,Anh) values(?,?,?,?,?,?)";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maDoanhNghiep);
			ps.setNString(2, tieuDe);
			ps.setNString(3, noiDung);		;
			ps.setNString(4, tacGia);
			ps.setDate(5, new java.sql.Date(new Date().getTime()));
			ps.setNString(6, anh);
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
	
	public int deleteBlog(long maBlog) throws SQLException {
		String query = "delete from Blog where MaBlog=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maBlog);
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
	public int updateBlog(long maBlog, String tieuDe, String noiDung, String tacGia,String anh) throws SQLException {
		String query = "update Blog set TieuDe=?, NoiDung=?, TacGia=?,Anh=?, PhanHoi=?, DaDuyet=0 where MaBlog=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setNString(1, tieuDe);
			ps.setNString(2, noiDung);
			ps.setNString(3, tacGia);
			ps.setNString(4, anh);
			ps.setNull(5, Types.NVARCHAR);
			ps.setLong(6, maBlog);
			
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
	public int updatePhanHoi(long maBlog, String phanHoi) throws SQLException {
		String query = "update Blog set PhanHoi=? where MaBlog=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setNString(1, phanHoi);
			ps.setLong(2, maBlog);
			
			
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
	public int duyetBlog(long maBlog) throws SQLException {
		String query = "update Blog set DaDuyet=1 where MaBlog=?";
		int flag=-1;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maBlog);
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
