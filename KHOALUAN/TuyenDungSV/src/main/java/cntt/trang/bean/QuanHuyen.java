package cntt.trang.bean;

public class QuanHuyen {
	private String maQuanHuyen;
	private String tenQuanHuyen;
	private String type;
	private String pathWithType;
	private String maTinhThanh;
	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}
	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}
	public String getTenQuanHuyen() {
		return tenQuanHuyen;
	}
	public void setTenQuanHuyen(String tenQuanHuyen) {
		this.tenQuanHuyen = tenQuanHuyen;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPathWithType() {
		return pathWithType;
	}
	public void setPathWithType(String pathWithType) {
		this.pathWithType = pathWithType;
	}
	public String getMaTinhThanh() {
		return maTinhThanh;
	}
	public void setMaTinhThanh(String maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}
	public QuanHuyen(String maQuanHuyen, String tenQuanHuyen, String type, String pathWithType, String maTinhThanh) {
		super();
		this.maQuanHuyen = maQuanHuyen;
		this.tenQuanHuyen = tenQuanHuyen;
		this.type = type;
		this.pathWithType = pathWithType;
		this.maTinhThanh = maTinhThanh;
	}
	public QuanHuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
