package cntt.trang.bean;

public class NganhNghe {
	private long maNganhNghe;
	private String tenNganhNghe;
	public long getMaNganhNghe() {
		return maNganhNghe;
	}
	public void setMaNganhNghe(long maNganhNghe) {
		this.maNganhNghe = maNganhNghe;
	}
	public String getTenNganhNghe() {
		return tenNganhNghe;
	}
	public void setTenNganhNghe(String tenNganhNghe) {
		this.tenNganhNghe = tenNganhNghe;
	}
	public NganhNghe(long maNganhNghe, String tenNganhNghe) {
		super();
		this.maNganhNghe = maNganhNghe;
		this.tenNganhNghe = tenNganhNghe;
	}
	public NganhNghe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
