package cntt.trang.bean;

import java.util.Date;

public class TuyenDung {
	private long maTuyenDung;
	private long maNganhNghe;
	private long maHinhThuc;
	private int sinhVienNam;
	private String khuVucTuyenDung;
	private String mucLuong;
	private String tenCongViec;
	private String thoiGianThuViec;
	private String gioiTinh;
	private int soLuong;
	private Date hanDangKy;
	private String tieuDe;
	private String moTaCongViec;
	private String yeuCauCongViec;
	private String QuyenLoi;
	private boolean daDuyet;
	private long maDoanhNghiep;
	public long getMaTuyenDung() {
		return maTuyenDung;
	}
	public void setMaTuyenDung(long maTuyenDung) {
		this.maTuyenDung = maTuyenDung;
	}
	public long getMaNganhNghe() {
		return maNganhNghe;
	}
	public void setMaNganhNghe(long maNganhNghe) {
		this.maNganhNghe = maNganhNghe;
	}
	public long getMaHinhThuc() {
		return maHinhThuc;
	}
	public void setMaHinhThuc(long maHinhThuc) {
		this.maHinhThuc = maHinhThuc;
	}
	public int getSinhVienNam() {
		return sinhVienNam;
	}
	public void setSinhVienNam(int sinhVienNam) {
		this.sinhVienNam = sinhVienNam;
	}
	public String getKhuVucTuyenDung() {
		return khuVucTuyenDung;
	}
	public void setKhuVucTuyenDung(String khuVucTuyenDung) {
		this.khuVucTuyenDung = khuVucTuyenDung;
	}
	public String getMucLuong() {
		return mucLuong;
	}
	public void setMucLuong(String mucLuong) {
		this.mucLuong = mucLuong;
	}
	public String getTenCongViec() {
		return tenCongViec;
	}
	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}
	public String getThoiGianThuViec() {
		return thoiGianThuViec;
	}
	public void setThoiGianThuViec(String thoiGianThuViec) {
		this.thoiGianThuViec = thoiGianThuViec;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getHanDangKy() {
		return hanDangKy;
	}
	public void setHanDangKy(Date hanDangKy) {
		this.hanDangKy = hanDangKy;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getMoTaCongViec() {
		return moTaCongViec;
	}
	public void setMoTaCongViec(String moTaCongViec) {
		this.moTaCongViec = moTaCongViec;
	}
	public String getYeuCauCongViec() {
		return yeuCauCongViec;
	}
	public void setYeuCauCongViec(String yeuCauCongViec) {
		this.yeuCauCongViec = yeuCauCongViec;
	}
	public String getQuyenLoi() {
		return QuyenLoi;
	}
	public void setQuyenLoi(String quyenLoi) {
		QuyenLoi = quyenLoi;
	}
	public boolean isDaDuyet() {
		return daDuyet;
	}
	public void setDaDuyet(boolean daDuyet) {
		this.daDuyet = daDuyet;
	}
	public long getMaDoanhNghiep() {
		return maDoanhNghiep;
	}
	public void setMaDoanhNghiep(long maDoanhNghiep) {
		this.maDoanhNghiep = maDoanhNghiep;
	}
	public TuyenDung(long maTuyenDung, long maNganhNghe, long maHinhThuc, int sinhVienNam, String khuVucTuyenDung,
			String mucLuong, String tenCongViec, String thoiGianThuViec, String gioiTinh, int soLuong, Date hanDangKy,
			String tieuDe, String moTaCongViec, String yeuCauCongViec, String quyenLoi, boolean daDuyet,
			long maDoanhNghiep) {
		super();
		this.maTuyenDung = maTuyenDung;
		this.maNganhNghe = maNganhNghe;
		this.maHinhThuc = maHinhThuc;
		this.sinhVienNam = sinhVienNam;
		this.khuVucTuyenDung = khuVucTuyenDung;
		this.mucLuong = mucLuong;
		this.tenCongViec = tenCongViec;
		this.thoiGianThuViec = thoiGianThuViec;
		this.gioiTinh = gioiTinh;
		this.soLuong = soLuong;
		this.hanDangKy = hanDangKy;
		this.tieuDe = tieuDe;
		this.moTaCongViec = moTaCongViec;
		this.yeuCauCongViec = yeuCauCongViec;
		QuyenLoi = quyenLoi;
		this.daDuyet = daDuyet;
		this.maDoanhNghiep = maDoanhNghiep;
	}
	public TuyenDung() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
