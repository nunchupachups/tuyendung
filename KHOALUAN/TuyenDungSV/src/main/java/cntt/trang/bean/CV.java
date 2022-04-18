package cntt.trang.bean;

public class CV {
	private String maSinhVien;
	private String anhDaiDien;
	private String viTriUngTuyen;
	private long maKyNang;
	private String soThich;
	private String mucTieuNgheNghiep;
	private long maChungChi;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public String getViTriUngTuyen() {
		return viTriUngTuyen;
	}
	public void setViTriUngTuyen(String viTriUngTuyen) {
		this.viTriUngTuyen = viTriUngTuyen;
	}
	public long getMaKyNang() {
		return maKyNang;
	}
	public void setMaKyNang(long maKyNang) {
		this.maKyNang = maKyNang;
	}
	public String getSoThich() {
		return soThich;
	}
	public void setSoThich(String soThich) {
		this.soThich = soThich;
	}
	public String getMucTieuNgheNghiep() {
		return mucTieuNgheNghiep;
	}
	public void setMucTieuNgheNghiep(String mucTieuNgheNghiep) {
		this.mucTieuNgheNghiep = mucTieuNgheNghiep;
	}
	public long getMaChungChi() {
		return maChungChi;
	}
	public void setMaChungChi(long maChungChi) {
		this.maChungChi = maChungChi;
	}
	public CV(String maSinhVien, String anhDaiDien, String viTriUngTuyen, long maKyNang, String soThich,
			String mucTieuNgheNghiep, long maChungChi) {
		super();
		this.maSinhVien = maSinhVien;
		this.anhDaiDien = anhDaiDien;
		this.viTriUngTuyen = viTriUngTuyen;
		this.maKyNang = maKyNang;
		this.soThich = soThich;
		this.mucTieuNgheNghiep = mucTieuNgheNghiep;
		this.maChungChi = maChungChi;
	}
	public CV() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
