package cntt.trang.bean;

public class DonVi {
	private long maDonVi;
	private String tenDonVi;
	private long maCV;
	private String mucCV;
	public long getMaDonVi() {
		return maDonVi;
	}
	public void setMaDonVi(long maDonVi) {
		this.maDonVi = maDonVi;
	}
	public String getTenDonVi() {
		return tenDonVi;
	}
	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}
	public long getMaCV() {
		return maCV;
	}
	public void setMaCV(long maCV) {
		this.maCV = maCV;
	}
	public String getMucCV() {
		return mucCV;
	}
	public void setMucCV(String mucCV) {
		this.mucCV = mucCV;
	}
	public DonVi(long maDonVi, String tenDonVi, long maCV, String mucCV) {
		super();
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
		this.maCV = maCV;
		this.mucCV = mucCV;
	}
	public DonVi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
