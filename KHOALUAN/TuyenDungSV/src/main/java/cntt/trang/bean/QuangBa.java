package cntt.trang.bean;

public class QuangBa {
	private long maQuangBa;
	private String tieuDe;
	private String noiDungDaiDien;
	private String hinhAnhDaiDien;
	private String baiViet;
	private boolean daDuyet;
	private long maDoanhNghiep;
	public long getMaQuangBa() {
		return maQuangBa;
	}
	public void setMaQuangBa(long maQuangBa) {
		this.maQuangBa = maQuangBa;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getNoiDungDaiDien() {
		return noiDungDaiDien;
	}
	public void setNoiDungDaiDien(String noiDungDaiDien) {
		this.noiDungDaiDien = noiDungDaiDien;
	}
	public String getHinhAnhDaiDien() {
		return hinhAnhDaiDien;
	}
	public void setHinhAnhDaiDien(String hinhAnhDaiDien) {
		this.hinhAnhDaiDien = hinhAnhDaiDien;
	}
	public String getBaiViet() {
		return baiViet;
	}
	public void setBaiViet(String baiViet) {
		this.baiViet = baiViet;
	}
	public boolean isDaDuyet() {
		return daDuyet;
	}
	public void setDaDuyet(boolean daDuyet) {
		this.daDuyet = daDuyet;
	}
	public long getMaDoanhNghiep() {
		return maDoanhNghiep;
	}
	public void setMaDoanhNghiep(long maDoanhNghiep) {
		this.maDoanhNghiep = maDoanhNghiep;
	}
	public QuangBa(long maQuangBa, String tieuDe, String noiDungDaiDien, String hinhAnhDaiDien, String baiViet,
			boolean daDuyet, long maDoanhNghiep) {
		super();
		this.maQuangBa = maQuangBa;
		this.tieuDe = tieuDe;
		this.noiDungDaiDien = noiDungDaiDien;
		this.hinhAnhDaiDien = hinhAnhDaiDien;
		this.baiViet = baiViet;
		this.daDuyet = daDuyet;
		this.maDoanhNghiep = maDoanhNghiep;
	}
	public QuangBa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
