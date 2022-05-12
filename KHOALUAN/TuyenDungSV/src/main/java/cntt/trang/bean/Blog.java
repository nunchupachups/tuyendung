package cntt.trang.bean;

import java.util.Date;

public class Blog implements Comparable<Blog>{
	private long maBlog;
	private long maDoanhNghiep;
	private String tieuDe;
	private String noiDung;
	private String tacGia;
	private Date ngayDang;
	private String anh;
	private int luotXem;
	private boolean daDuyet;
	private String phanHoi;
	public long getMaBlog() {
		return maBlog;
	}
	public void setMaBlog(long maBlog) {
		this.maBlog = maBlog;
	}
	public long getMaDoanhNghiep() {
		return maDoanhNghiep;
	}
	public void setMaDoanhNghiep(long maDoanhNghiep) {
		this.maDoanhNghiep = maDoanhNghiep;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public Date getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public int getLuotXem() {
		return luotXem;
	}
	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}
	public boolean isDaDuyet() {
		return daDuyet;
	}
	public void setDaDuyet(boolean daDuyet) {
		this.daDuyet = daDuyet;
	}
	public String getPhanHoi() {
		return phanHoi;
	}
	public void setPhanHoi(String phanHoi) {
		this.phanHoi = phanHoi;
	}
	public Blog(long maBlog, long maDoanhNghiep, String tieuDe, String noiDung, String tacGia, Date ngayDang,
			String anh, int luotXem, boolean daDuyet, String phanHoi) {
		super();
		this.maBlog = maBlog;
		this.maDoanhNghiep = maDoanhNghiep;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.tacGia = tacGia;
		this.ngayDang = ngayDang;
		this.anh = anh;
		this.luotXem = luotXem;
		this.daDuyet = daDuyet;
		this.phanHoi = phanHoi;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Blog)
			return maBlog==((Blog)obj).maBlog;
		return false;
	}
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public int compareTo(Blog o) {
		return o.getNgayDang().compareTo(this.getNgayDang());
	}
}
