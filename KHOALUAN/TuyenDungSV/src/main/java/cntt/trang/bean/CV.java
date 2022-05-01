package cntt.trang.bean;

public class CV {
	private String maSinhVien;
	private String viTriUngTuyen;
	private String soThich;
	private String mucTieuNgheNghiep;
	private boolean ShowKyNang;
	private boolean ShowChungChi;
	private boolean ShowSoThich;
	private boolean ShowMucTieuNgheNghiep;
	private boolean ShowHocVan;
	private boolean ShowKinhNghiemLamViec;
	private boolean ShowHoatDong;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getViTriUngTuyen() {
		return viTriUngTuyen;
	}
	public void setViTriUngTuyen(String viTriUngTuyen) {
		this.viTriUngTuyen = viTriUngTuyen;
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
	
	
	public boolean isShowKyNang() {
		return ShowKyNang;
	}
	public void setShowKyNang(boolean showKyNang) {
		ShowKyNang = showKyNang;
	}
	public boolean isShowChungChi() {
		return ShowChungChi;
	}
	public void setShowChungChi(boolean showChungChi) {
		ShowChungChi = showChungChi;
	}
	public boolean isShowSoThich() {
		return ShowSoThich;
	}
	public void setShowSoThich(boolean showSoThich) {
		ShowSoThich = showSoThich;
	}
	public boolean isShowMucTieuNgheNghiep() {
		return ShowMucTieuNgheNghiep;
	}
	public void setShowMucTieuNgheNghiep(boolean showMucTieuNgheNghiep) {
		ShowMucTieuNgheNghiep = showMucTieuNgheNghiep;
	}
	public boolean isShowHocVan() {
		return ShowHocVan;
	}
	public void setShowHocVan(boolean showHocVan) {
		ShowHocVan = showHocVan;
	}
	public boolean isShowKinhNghiemLamViec() {
		return ShowKinhNghiemLamViec;
	}
	public void setShowKinhNghiemLamViec(boolean showKinhNghiemLamViec) {
		ShowKinhNghiemLamViec = showKinhNghiemLamViec;
	}
	public boolean isShowHoatDong() {
		return ShowHoatDong;
	}
	public void setShowHoatDong(boolean showHoatDong) {
		ShowHoatDong = showHoatDong;
	}
	
	public CV(String maSinhVien, String viTriUngTuyen, String soThich, String mucTieuNgheNghiep,
			boolean showKyNang, boolean showChungChi, boolean showSoThich, boolean showMucTieuNgheNghiep,
			boolean showHocVan, boolean showKinhNghiemLamViec, boolean showHoatDong) {
		super();
		this.maSinhVien = maSinhVien;
		this.viTriUngTuyen = viTriUngTuyen;
		this.soThich = soThich;
		this.mucTieuNgheNghiep = mucTieuNgheNghiep;
		ShowKyNang = showKyNang;
		ShowChungChi = showChungChi;
		ShowSoThich = showSoThich;
		ShowMucTieuNgheNghiep = showMucTieuNgheNghiep;
		ShowHocVan = showHocVan;
		ShowKinhNghiemLamViec = showKinhNghiemLamViec;
		ShowHoatDong = showHoatDong;
	}
	public CV() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
