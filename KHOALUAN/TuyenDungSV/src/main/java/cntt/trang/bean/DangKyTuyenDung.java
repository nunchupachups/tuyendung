package cntt.trang.bean;

public class DangKyTuyenDung {
	private long maTuyenDung;
	private String maSinhVien;
	private boolean daDuyet;
	public long getMaTuyenDung() {
		return maTuyenDung;
	}
	public void setMaTuyenDung(long maTuyenDung) {
		this.maTuyenDung = maTuyenDung;
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	
	public boolean isDaDuyet() {
		return daDuyet;
	}
	public void setDaDuyet(boolean daDuyet) {
		this.daDuyet = daDuyet;
	}
	public DangKyTuyenDung(long maTuyenDung, String maSinhVien, boolean daDuyet) {
		super();
		this.maTuyenDung = maTuyenDung;
		this.maSinhVien = maSinhVien;
		this.daDuyet = daDuyet;
	}
	public DangKyTuyenDung() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
