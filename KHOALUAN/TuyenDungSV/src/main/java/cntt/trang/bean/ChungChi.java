package cntt.trang.bean;

public class ChungChi {
	private long maChungChi;
	private String tenChungChi;
	private String nam;
	private String maCV;
	public long getMaChungChi() {
		return maChungChi;
	}
	public void setMaChungChi(long maChungChi) {
		this.maChungChi = maChungChi;
	}
	public String getTenChungChi() {
		return tenChungChi;
	}
	public void setTenChungChi(String tenChungChi) {
		this.tenChungChi = tenChungChi;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public ChungChi(long maChungChi, String tenChungChi, String nam, String maCV) {
		super();
		this.maChungChi = maChungChi;
		this.tenChungChi = tenChungChi;
		this.nam = nam;
		this.maCV = maCV;
	}
	public ChungChi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
