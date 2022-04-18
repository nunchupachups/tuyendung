package cntt.trang.bean;

public class LinhVucHoatDongCap2 {
	private String maLinhVuc;
	private String tenLinhVuc;
	private String maLinhVucCap1;
	public String getMaLinhVuc() {
		return maLinhVuc;
	}
	public void setMaLinhVuc(String maLinhVuc) {
		this.maLinhVuc = maLinhVuc;
	}
	public String getTenLinhVuc() {
		return tenLinhVuc;
	}
	public void setTenLinhVuc(String tenLinhVuc) {
		this.tenLinhVuc = tenLinhVuc;
	}
	public String getMaLinhVucCap1() {
		return maLinhVucCap1;
	}
	public void setMaLinhVucCap1(String maLinhVucCap1) {
		this.maLinhVucCap1 = maLinhVucCap1;
	}
	public LinhVucHoatDongCap2(String maLinhVuc, String tenLinhVuc, String maLinhVucCap1) {
		super();
		this.maLinhVuc = maLinhVuc;
		this.tenLinhVuc = tenLinhVuc;
		this.maLinhVucCap1 = maLinhVucCap1;
	}
	public LinhVucHoatDongCap2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
