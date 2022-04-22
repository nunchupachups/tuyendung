package cntt.trang.bean;

public class ViTri {
	private long maViTri;
	private String tenViTri;
	private String khoangThoiGian;
	private long maDonVi;
	private String moTa;
	public long getMaViTri() {
		return maViTri;
	}
	public void setMaViTri(long maViTri) {
		this.maViTri = maViTri;
	}
	public String getTenViTri() {
		return tenViTri;
	}
	public void setTenViTri(String tenViTri) {
		this.tenViTri = tenViTri;
	}
	public String getKhoangThoiGian() {
		return khoangThoiGian;
	}
	public void setKhoangThoiGian(String khoangThoiGian) {
		this.khoangThoiGian = khoangThoiGian;
	}
	public long getMaDonVi() {
		return maDonVi;
	}
	public void setMaDonVi(long maDonVi) {
		this.maDonVi = maDonVi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public ViTri(long maViTri, String tenViTri, String khoangThoiGian, long maDonVi, String moTa) {
		super();
		this.maViTri = maViTri;
		this.tenViTri = tenViTri;
		this.khoangThoiGian = khoangThoiGian;
		this.maDonVi = maDonVi;
		this.moTa = moTa;
	}
	public ViTri() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
