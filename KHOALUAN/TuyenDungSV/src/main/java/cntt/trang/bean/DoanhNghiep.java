package cntt.trang.bean;

public class DoanhNghiep {
	private long maDoanhNghiep;
	private String emailDangNhap;
	private String matKhau;
	private String tenLienHe;
	private String EmailLienHe;
	private String soDienThoai;
	private String tenDoanhNghiep;
	private String maSoThue;
	private String maXaPhuong;
	private String diaChiDuong;
	private String maLinhVucHoatDong;
	private long maLoaiHinhDoanhNghiep;
	private String GiayChungNhan;
	private boolean daDuyet;
	public long getMaDoanhNghiep() {
		return maDoanhNghiep;
	}
	public void setMaDoanhNghiep(long maDoanhNghiep) {
		this.maDoanhNghiep = maDoanhNghiep;
	}
	public String getEmailDangNhap() {
		return emailDangNhap;
	}
	public void setEmailDangNhap(String emailDangNhap) {
		this.emailDangNhap = emailDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenLienHe() {
		return tenLienHe;
	}
	public void setTenLienHe(String tenLienHe) {
		this.tenLienHe = tenLienHe;
	}
	public String getEmailLienHe() {
		return EmailLienHe;
	}
	public void setEmailLienHe(String emailLienHe) {
		EmailLienHe = emailLienHe;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getTenDoanhNghiep() {
		return tenDoanhNghiep;
	}
	public void setTenDoanhNghiep(String tenDoanhNghiep) {
		this.tenDoanhNghiep = tenDoanhNghiep;
	}
	public String getMaSoThue() {
		return maSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public String getMaXaPhuong() {
		return maXaPhuong;
	}
	public void setMaXaPhuong(String maXaPhuong) {
		this.maXaPhuong = maXaPhuong;
	}
	public String getDiaChiDuong() {
		return diaChiDuong;
	}
	public void setDiaChiDuong(String diaChiDuong) {
		this.diaChiDuong = diaChiDuong;
	}
	public String getMaLinhVucHoatDong() {
		return maLinhVucHoatDong;
	}
	public void setMaLinhVucHoatDong(String maLinhVucHoatDong) {
		this.maLinhVucHoatDong = maLinhVucHoatDong;
	}
	public long getMaLoaiHinhDoanhNghiep() {
		return maLoaiHinhDoanhNghiep;
	}
	public void setMaLoaiHinhDoanhNghiep(long maLoaiHinhDoanhNghiep) {
		this.maLoaiHinhDoanhNghiep = maLoaiHinhDoanhNghiep;
	}
	public String getGiayChungNhan() {
		return GiayChungNhan;
	}
	public void setGiayChungNhan(String giayChungNhan) {
		GiayChungNhan = giayChungNhan;
	}
	public boolean isDaDuyet() {
		return daDuyet;
	}
	public void setDaDuyet(boolean daDuyet) {
		this.daDuyet = daDuyet;
	}
	public DoanhNghiep(long maDoanhNghiep, String emailDangNhap, String matKhau, String tenLienHe, String emailLienHe,
			String soDienThoai, String tenDoanhNghiep, String maSoThue, String maXaPhuong, String diaChiDuong,
			String maLinhVucHoatDong, long maLoaiHinhDoanhNghiep, String giayChungNhan, boolean daDuyet) {
		super();
		this.maDoanhNghiep = maDoanhNghiep;
		this.emailDangNhap = emailDangNhap;
		this.matKhau = matKhau;
		this.tenLienHe = tenLienHe;
		EmailLienHe = emailLienHe;
		this.soDienThoai = soDienThoai;
		this.tenDoanhNghiep = tenDoanhNghiep;
		this.maSoThue = maSoThue;
		this.maXaPhuong = maXaPhuong;
		this.diaChiDuong = diaChiDuong;
		this.maLinhVucHoatDong = maLinhVucHoatDong;
		this.maLoaiHinhDoanhNghiep = maLoaiHinhDoanhNghiep;
		GiayChungNhan = giayChungNhan;
		this.daDuyet = daDuyet;
	}
	public DoanhNghiep() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
