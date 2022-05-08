package cntt.trang.bean;

public class ThongBao {
	private long maThongBao;
	private long maDoanhNghiep;
	private String maSinhVien;
	private String noiDung;
	private String link;
	private boolean daXem;
	public long getMaThongBao() {
		return maThongBao;
	}
	public void setMaThongBao(long maThongBao) {
		this.maThongBao = maThongBao;
	}
	public long getMaDoanhNghiep() {
		return maDoanhNghiep;
	}
	public void setMaDoanhNghiep(long maDoanhNghiep) {
		this.maDoanhNghiep = maDoanhNghiep;
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public boolean isDaXem() {
		return daXem;
	}
	public void setDaXem(boolean daXem) {
		this.daXem = daXem;
	}
	public ThongBao(long maThongBao, long maDoanhNghiep, String maSinhVien, String noiDung, String link,
			boolean daXem) {
		super();
		this.maThongBao = maThongBao;
		this.maDoanhNghiep = maDoanhNghiep;
		this.maSinhVien = maSinhVien;
		this.noiDung = noiDung;
		this.link = link;
		this.daXem = daXem;
	}
	public ThongBao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
