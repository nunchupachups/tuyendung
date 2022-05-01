package cntt.trang.bean;

public class NganhDaoTao {
	private String maNganh;
	private String tenNganh;
	private int soTinChi;
	private int namDaoTao;
	public String getMaNganh() {
		return maNganh;
	}
	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}
	public String getTenNganh() {
		return tenNganh;
	}
	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}
	public int getNamDaoTao() {
		return namDaoTao;
	}
	public void setNamDaoTao(int namDaoTao) {
		this.namDaoTao = namDaoTao;
	}
	public NganhDaoTao(String maNganh, String tenNganh, int soTinChi, int namDaoTao) {
		super();
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		this.soTinChi = soTinChi;
		this.namDaoTao = namDaoTao;
	}
	public NganhDaoTao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
