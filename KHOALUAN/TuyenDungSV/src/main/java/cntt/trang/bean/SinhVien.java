package cntt.trang.bean;

public class SinhVien {
	private String maSinhVien;
	private String matKhau;
	private String tenSinhVien;
	private String maNganhDaoTao;
	private String khoa;
	private String lop;
	private Boolean daDuyet;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenSinhVien() {
		return tenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}
	public String getMaNganhDaoTao() {
		return maNganhDaoTao;
	}
	public void setMaNganhDaoTao(String maNganhDaoTao) {
		this.maNganhDaoTao = maNganhDaoTao;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	
	public Boolean getDaDuyet() {
		return daDuyet;
	}
	public void setDaDuyet(Boolean daDuyet) {
		this.daDuyet = daDuyet;
	}
	public SinhVien(String maSinhVien, String matKhau, String tenSinhVien, String maNganhDaoTao, String khoa,
			String lop, Boolean daDuyet) {
		super();
		this.maSinhVien = maSinhVien;
		this.matKhau = matKhau;
		this.tenSinhVien = tenSinhVien;
		this.maNganhDaoTao = maNganhDaoTao;
		this.khoa = khoa;
		this.lop = lop;
		this.daDuyet = daDuyet;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
