package cntt.trang.bean;

import java.util.Date;

public class SinhVien {
	private String maSinhVien;
	private String hoVaTen;
	private boolean gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String dienThoai;
	private String diDong;
	private String email;
	private String maNganh;
	private boolean daDuyet;
	private String maKhoaHoc;
	private String tenKhoaHoc;
	private String anhDaiDien;
	private Date ngayCapNhat;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getDiDong() {
		return diDong;
	}
	public void setDiDong(String diDong) {
		this.diDong = diDong;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMaNganh() {
		return maNganh;
	}
	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}
	public boolean isDaDuyet() {
		return daDuyet;
	}
	public void setDaDuyet(boolean daDuyet) {
		this.daDuyet = daDuyet;
	}
	
	
	
	public String getMaKhoaHoc() {
		return maKhoaHoc;
	}
	public void setMaKhoaHoc(String maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}
	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(String maSinhVien, String hoVaTen, boolean gioiTinh, String ngaySinh, String diaChi,
			String dienThoai, String diDong, String email, String maNganh, boolean daDuyet, String maKhoaHoc,
			String tenKhoaHoc, String anhDaiDien, Date ngayCapNhat) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.diDong = diDong;
		this.email = email;
		this.maNganh = maNganh;
		this.daDuyet = daDuyet;
		this.maKhoaHoc = maKhoaHoc;
		this.tenKhoaHoc = tenKhoaHoc;
		this.anhDaiDien = anhDaiDien;
		this.ngayCapNhat = ngayCapNhat;
	}
	
	
}
