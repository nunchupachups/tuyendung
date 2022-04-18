package cntt.trang.bean;

public class ThongBao {
	private long maThongBao;
	private String noiDung;
	private String loaiThongBao;
	private long maBaiViet;
	private String maNguoiDung;
	public long getMaThongBao() {
		return maThongBao;
	}
	public void setMaThongBao(long maThongBao) {
		this.maThongBao = maThongBao;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getLoaiThongBao() {
		return loaiThongBao;
	}
	public void setLoaiThongBao(String loaiThongBao) {
		this.loaiThongBao = loaiThongBao;
	}
	public long getMaBaiViet() {
		return maBaiViet;
	}
	public void setMaBaiViet(long maBaiViet) {
		this.maBaiViet = maBaiViet;
	}
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public ThongBao(long maThongBao, String noiDung, String loaiThongBao, long maBaiViet, String maNguoiDung) {
		super();
		this.maThongBao = maThongBao;
		this.noiDung = noiDung;
		this.loaiThongBao = loaiThongBao;
		this.maBaiViet = maBaiViet;
		this.maNguoiDung = maNguoiDung;
	}
	public ThongBao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
