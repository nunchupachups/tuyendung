package cntt.trang.bean;

public class KyNang {
	private long maKyNang;
	private String tenKyNang;
	private int doThanhThao;
	private long maCV;
	public long getMaKyNang() {
		return maKyNang;
	}
	public void setMaKyNang(long maKyNang) {
		this.maKyNang = maKyNang;
	}
	public String getTenKyNang() {
		return tenKyNang;
	}
	public void setTenKyNang(String tenKyNang) {
		this.tenKyNang = tenKyNang;
	}
	public int getDoThanhThao() {
		return doThanhThao;
	}
	public void setDoThanhThao(int doThanhThao) {
		this.doThanhThao = doThanhThao;
	}
	public long getMaCV() {
		return maCV;
	}
	public void setMaCV(long maCV) {
		this.maCV = maCV;
	}
	public KyNang(long maKyNang, String tenKyNang, int doThanhThao, long maCV) {
		super();
		this.maKyNang = maKyNang;
		this.tenKyNang = tenKyNang;
		this.doThanhThao = doThanhThao;
		this.maCV = maCV;
	}
	public KyNang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
