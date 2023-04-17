package entity;

import java.util.Date;

public class ChamCongCN {

    private String maChamCong;
    private int soLuongSanPham;
    private float heSoLuongCa;
    private String caLam;
    private String trangThai;
    private Date ngayChamCong;

    private PhanCong phanCong;

    public ChamCongCN() {
    }

    public ChamCongCN(String maChamCong, PhanCong phanCong, int soLuongSanPham, float heSoLuongCa, String caLam, String trangThai) {
        this.maChamCong = maChamCong;
        this.soLuongSanPham = soLuongSanPham;
        this.heSoLuongCa = heSoLuongCa;
        this.caLam = caLam;
        this.trangThai = trangThai;
        this.phanCong = phanCong;

    }

    public String getMaChamCong() {
        return maChamCong;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public float getHeSoLuongCa() {
        return heSoLuongCa;
    }

    public String getCaLam() {
        return caLam;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public Date getNgayChamCong() {
        return ngayChamCong;
    }

    public PhanCong getPhanCong() {
        return phanCong;
    }

    public void setMaChamCong(String maChamCong) {
        this.maChamCong = maChamCong;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public void setHeSoLuongCa(float heSoLuongCa) {
        this.heSoLuongCa = heSoLuongCa;
    }

    public void setCaLam(String caLam) {
        this.caLam = caLam;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setNgayChamCong(Date ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public void setPhanCong(PhanCong phanCong) {
        this.phanCong = phanCong;
    }

}
