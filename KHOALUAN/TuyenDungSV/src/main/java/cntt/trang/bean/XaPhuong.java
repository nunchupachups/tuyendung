package cntt.trang.bean;

public class XaPhuong {
	private String maXaPhuong;
	private String tenXaPhuong;
	private String Type;
	private String pathWithType;
	private String maQuanHuyen;
	public String getMaXaPhuong() {
		return maXaPhuong;
	}
	public void setMaXaPhuong(String maXaPhuong) {
		this.maXaPhuong = maXaPhuong;
	}
	public String getTenXaPhuong() {
		return tenXaPhuong;
	}
	public void setTenXaPhuong(String tenXaPhuong) {
		this.tenXaPhuong = tenXaPhuong;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getPathWithType() {
		return pathWithType;
	}
	public void setPathWithType(String pathWithType) {
		this.pathWithType = pathWithType;
	}
	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}
	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}
	public XaPhuong(String maXaPhuong, String tenXaPhuong, String type, String pathWithType, String maQuanHuyen) {
		super();
		this.maXaPhuong = maXaPhuong;
		this.tenXaPhuong = tenXaPhuong;
		Type = type;
		this.pathWithType = pathWithType;
		this.maQuanHuyen = maQuanHuyen;
	}
	public XaPhuong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
