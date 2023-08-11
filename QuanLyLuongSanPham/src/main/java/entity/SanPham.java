/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author trung
 */
public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private String loaiSanPham;
	private String mauSac;
	private String chatLieu;
	private int soLuongCanLam;
	private int soLuongDaLam;
	private Date ngayHoanThanh;
	private String trangThai;

	public SanPham(String maSanPham, String tenSanPham, String loaiSanPham, String mauSac, String chatLieu,
			int soLuongCanLam, int soLuongDaLam, Date ngayHoanThanh, String trangThai) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.loaiSanPham = loaiSanPham;
		this.mauSac = mauSac;
		this.chatLieu = chatLieu;
		this.soLuongCanLam = soLuongCanLam;
		this.soLuongDaLam = soLuongDaLam;
		this.ngayHoanThanh = ngayHoanThanh;
		this.trangThai = trangThai;
	}
        
         public SanPham(String maSanPham, String tenSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
    }


	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public int getSoLuongCanLam() {
		return soLuongCanLam;
	}

	public void setSoLuongCanLam(int soLuongCanLam) {
		this.soLuongCanLam = soLuongCanLam;
	}

	public int getSoLuongDaLam() {
		return soLuongDaLam;
	}

	public void setSoLuongDaLam(int soLuongDaLam) {
		this.soLuongDaLam = soLuongDaLam;
	}

	public Date getNgayHoanThanh() {
		return ngayHoanThanh;
	}

	public void setNgayHoanThanh(Date ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	// Phương thức kiểm tra xem
	// sản phẩm đã được hoàn thành chưa
	public boolean daHoanThanh() {
		return trangThai.equalsIgnoreCase("Hoàn thành");
	}

	// Phương thức tính số lượng còn lại cần làm
	public int soLuongConLai() {
		return soLuongCanLam - soLuongDaLam;
	}

	// Phương thức kiểm tra xem sản phẩm đã quá hạn hoàn thành chưa
	public boolean quaHan() {
		if (ngayHoanThanh == null) {
			return false;
		}
		Date ngayHienTai = new Date();
		return ngayHoanThanh.before(ngayHienTai);
	}



	@Override
	public String toString() {
		return "Mã sản phẩm: " + maSanPham + "\nTên sản phẩm: " + tenSanPham + "\nLoại sản phẩm: " + loaiSanPham
				+ "\nMàu sắc: " + mauSac + "\nChất liệu: " + chatLieu + "\nSố lượng cần làm: " + soLuongCanLam
				+ "\nSố lượng đã làm: " + soLuongDaLam + "\nNgày hoàn thành: " + ngayHoanThanh
				+ "\nTrạng thái: " + trangThai;
	}

    public SanPham() {
    }

    public SanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
        
    
        
}
