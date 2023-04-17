package entity;

import java.util.Date;

public class PhanCong {

    private String maPhanCong;
    private PhanDoan phanDoan;
    private CongNhan congNhan;
    private int soLuongCanLam;
    private Date ngayPhanCong;
    private Date ngayHoanThanh;
    private String trangThai;

    public PhanCong(String maPhanCong, PhanDoan phanDoan, CongNhan congNhan, int soLuongCanLam, Date ngayPhanCong, Date ngayHoanThanh, String trangThai) {
        this.maPhanCong = maPhanCong;
        this.phanDoan = phanDoan;
        this.congNhan = congNhan;
        this.soLuongCanLam = soLuongCanLam;
        this.ngayPhanCong = ngayPhanCong;
        this.ngayHoanThanh = ngayHoanThanh;
        this.trangThai = trangThai;
    }

    public PhanCong() {
        
    }

    public String getMaPhanCong() {
        return maPhanCong;
    }

    public PhanDoan getPhanDoan() {
        return phanDoan;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public int getSoLuongCanLam() {
        return soLuongCanLam;
    }

    public Date getNgayPhanCong() {
        return ngayPhanCong;
    }

    public Date getNgayHoanThanh() {
        return ngayHoanThanh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaPhanCong(String maPhanCong) {
        this.maPhanCong = maPhanCong;
    }

    public void setPhanDoan(PhanDoan phanDoan) {
        this.phanDoan = phanDoan;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    public void setSoLuongCanLam(int soLuongCanLam) {
        this.soLuongCanLam = soLuongCanLam;
    }

    public void setNgayPhanCong(Date ngayPhanCong) {
        this.ngayPhanCong = ngayPhanCong;
    }

    public void setNgayHoanThanh(Date ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
