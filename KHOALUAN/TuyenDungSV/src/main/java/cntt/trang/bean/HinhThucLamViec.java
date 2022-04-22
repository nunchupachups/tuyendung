package cntt.trang.bean;

public class HinhThucLamViec {
	private long maHinhThuc;
	private String tenHinhThuc;
	public long getMaHinhThuc() {
		return maHinhThuc;
	}
	public void setMaHinhThuc(long maHinhThuc) {
		this.maHinhThuc = maHinhThuc;
	}
	public String getTenHinhThuc() {
		return tenHinhThuc;
	}
	public void setTenHinhThuc(String tenHinhThuc) {
		this.tenHinhThuc = tenHinhThuc;
	}
	public HinhThucLamViec(long maHinhThuc, String tenHinhThuc) {
		super();
		this.maHinhThuc = maHinhThuc;
		this.tenHinhThuc = tenHinhThuc;
	}
	public HinhThucLamViec() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
