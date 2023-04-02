/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author huylauri
 */
public class PhieuChamCongNV {
    private String maChamCong;
    private NhanVien nhanVien;
    private String caLam;
    private float heSoLuong;
    private int trangThai;
    private int nghiPhep;
    private Date ngayChamCong;
    private String ghiChu;

    public PhieuChamCongNV() {
    }

    public PhieuChamCongNV(String maChamCong, NhanVien nhanVien, String caLam, float heSoLuong, int trangThai, int nghiPhep, Date ngayChamCong, String ghiChu) {
        this.maChamCong = maChamCong;
        this.nhanVien = nhanVien;
        this.caLam = caLam;
        this.heSoLuong = heSoLuong;
        this.trangThai = trangThai;
        this.nghiPhep = nghiPhep;
        this.ngayChamCong = ngayChamCong;
        this.ghiChu = ghiChu;
    }

    public PhieuChamCongNV(NhanVien nhanVien, String caLam, float heSoLuong, int trangThai, int nghiPhep, Date ngayChamCong, String ghiChu) {
        this.nhanVien = nhanVien;
        this.caLam = caLam;
        this.heSoLuong = heSoLuong;
        this.trangThai = trangThai;
        this.nghiPhep = nghiPhep;
        this.ngayChamCong = ngayChamCong;
        this.ghiChu = ghiChu;
    }

    public String getMaChamCong() {
        return maChamCong;
    }

    public void setMaChamCong(String maChamCong) {
        this.maChamCong = maChamCong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getCaLam() {
        return caLam;
    }

    public void setCaLam(String caLam) {
        this.caLam = caLam;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getNghiPhep() {
        return nghiPhep;
    }

    public void setNghiPhep(int nghiPhep) {
        this.nghiPhep = nghiPhep;
    }

    public Date getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(Date ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "PhieuChamCongNV{" + "maChamCong=" + maChamCong + ", nhanVien=" + nhanVien + ", caLam=" + caLam + ", heSoLuong=" + heSoLuong + ", trangThai=" + trangThai + ", nghiPhep=" + nghiPhep + ", ngayChamCong=" + ngayChamCong + ", ghiChu=" + ghiChu + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.maChamCong);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhieuChamCongNV other = (PhieuChamCongNV) obj;
        return Objects.equals(this.maChamCong, other.maChamCong);
    }
    
    
    
}
