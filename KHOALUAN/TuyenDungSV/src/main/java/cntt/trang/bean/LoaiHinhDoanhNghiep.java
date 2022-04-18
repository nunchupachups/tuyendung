package cntt.trang.bean;

public class LoaiHinhDoanhNghiep {
	private long maLoaiHinhDoanhNghiep;
	private String tenLoaiHinhDoanhNghiep;
	public long getMaLoaiHinhDoanhNghiep() {
		return maLoaiHinhDoanhNghiep;
	}
	public void setMaLoaiHinhDoanhNghiep(long maLoaiHinhDoanhNghiep) {
		this.maLoaiHinhDoanhNghiep = maLoaiHinhDoanhNghiep;
	}
	public String getTenLoaiHinhDoanhNghiep() {
		return tenLoaiHinhDoanhNghiep;
	}
	public void setTenLoaiHinhDoanhNghiep(String tenLoaiHinhDoanhNghiep) {
		this.tenLoaiHinhDoanhNghiep = tenLoaiHinhDoanhNghiep;
	}
	public LoaiHinhDoanhNghiep(long maLoaiHinhDoanhNghiep, String tenLoaiHinhDoanhNghiep) {
		super();
		this.maLoaiHinhDoanhNghiep = maLoaiHinhDoanhNghiep;
		this.tenLoaiHinhDoanhNghiep = tenLoaiHinhDoanhNghiep;
	}
	public LoaiHinhDoanhNghiep() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
