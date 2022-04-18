package cntt.trang.bean;

public class NganhDaoTao {
	private String maNganh;
	private String tenNganh;
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
	public NganhDaoTao(String maNganh, String tenNganh) {
		super();
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
	}
	public NganhDaoTao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
