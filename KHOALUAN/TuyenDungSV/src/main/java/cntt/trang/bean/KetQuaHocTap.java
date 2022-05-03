package cntt.trang.bean;

public class KetQuaHocTap {
	private String maHocPhan;
	private String maSinhVien;
	private String tenSinhVien;
	private int soTinChi;
	private int hocKy;
	private String namHoc;
	private float diemHe10;
	private float diemHe4;
	private String diemChu;
	public String getMaHocPhan() {
		return maHocPhan;
	}
	public void setMaHocPhan(String maHocPhan) {
		this.maHocPhan = maHocPhan;
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getTenSinhVien() {
		return tenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}
	public int getHocKy() {
		return hocKy;
	}
	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}
	public String getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
	public float getDiemHe10() {
		return diemHe10;
	}
	public void setDiemHe10(float diemHe10) {
		this.diemHe10 = diemHe10;
	}
	public float getDiemHe4() {
		return diemHe4;
	}
	public void setDiemHe4(float diemHe4) {
		this.diemHe4 = diemHe4;
	}
	public String getDiemChu() {
		return diemChu;
	}
	public void setDiemChu(String diemChu) {
		this.diemChu = diemChu;
	}
	public KetQuaHocTap(String maHocPhan, String maSinhVien, String tenSinhVien, int soTinChi, int hocKy, String namHoc,
			float diemHe10, float diemHe4, String diemChu) {
		super();
		this.maHocPhan = maHocPhan;
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.soTinChi = soTinChi;
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.diemHe10 = diemHe10;
		this.diemHe4 = diemHe4;
		this.diemChu = diemChu;
	}
	public KetQuaHocTap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
