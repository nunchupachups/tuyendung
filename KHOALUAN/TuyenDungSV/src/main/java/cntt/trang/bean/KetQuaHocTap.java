package cntt.trang.bean;

public class KetQuaHocTap {
	private String maHocPhan;
	private String maSinhVien;
	private String tenHocPhan;
	private int soTinChi;
	private int hocKy;
	private String namHoc;
	private float diemHe10;
	private float diemHe4;
	private String diemChu;
	private int tongSoTinChiTheoKy;
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
	public String getTenHocPhan() {
		return tenHocPhan;
	}
	public void setTenHocPhan(String tenHocPhan) {
		this.tenHocPhan = tenHocPhan;
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
	
	public int getTongSoTinChiTheoKy() {
		return tongSoTinChiTheoKy;
	}
	public void setTongSoTinChiTheoKy(int tongSoTinChiTheoKy) {
		this.tongSoTinChiTheoKy = tongSoTinChiTheoKy;
	}
	public KetQuaHocTap(String maHocPhan, String maSinhVien, String tenHocPhan, int soTinChi, int hocKy, String namHoc,
			float diemHe10, float diemHe4, String diemChu, int tongSoTinChiTheoKy) {
		super();
		this.maHocPhan = maHocPhan;
		this.maSinhVien = maSinhVien;
		this.tenHocPhan = tenHocPhan;
		this.soTinChi = soTinChi;
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.diemHe10 = diemHe10;
		this.diemHe4 = diemHe4;
		this.diemChu = diemChu;
		this.tongSoTinChiTheoKy = tongSoTinChiTheoKy;
	}
	public KetQuaHocTap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
