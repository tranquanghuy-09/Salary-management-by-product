/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author duy19
 */
    public class ChamCongCN1 {
        private String maChamCong;
        private int soLuongSanPham;
        private float heSoLuongCa;
        private String caLam;
        private String trangThai;
        private Date ngayChamCong;
        private PhanCong1 phanCong;

    public ChamCongCN1() {
    }

    

    public ChamCongCN1(String maChamCong, PhanCong1 phanCong, int soLuongSanPham, float heSoLuongCa, String caLam, String trangThai) {
        this.maChamCong = maChamCong;
        this.soLuongSanPham = soLuongSanPham;
        this.heSoLuongCa = heSoLuongCa;
        this.caLam = caLam;
        this.trangThai = trangThai;
        this.phanCong = phanCong;

    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setPhanCong(PhanCong1 phanCong) {
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

  

    public Date getNgayChamCong() {
        return ngayChamCong;
    }

    public PhanCong1 getPhanCong() {
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

  
    public void setNgayChamCong(Date ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public void setPhanCongCN(PhanCong1 phanCong) {
        this.phanCong= phanCong;
    }

    @Override
    public String toString() {
        return "ChamCongCN{" + "maChamCong=" + maChamCong + ", soLuongSanPham=" + soLuongSanPham + ", heSoLuongCa=" + heSoLuongCa + ", caLam=" + caLam + ", ngayChamCong=" + ngayChamCong + ", phanCongCN=" + phanCong + '}';
    }

    

   
}
