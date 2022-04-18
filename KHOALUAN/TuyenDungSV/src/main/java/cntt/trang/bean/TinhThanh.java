package cntt.trang.bean;

public class TinhThanh {
	private String maTinhThanh;
	private String tenTinhThanh;
	private String type;
	public String getMaTinhThanh() {
		return maTinhThanh;
	}
	public void setMaTinhThanh(String maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}
	public String getTenTinhThanh() {
		return tenTinhThanh;
	}
	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public TinhThanh(String maTinhThanh, String tenTinhThanh, String type) {
		super();
		this.maTinhThanh = maTinhThanh;
		this.tenTinhThanh = tenTinhThanh;
		this.type = type;
	}
	public TinhThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
