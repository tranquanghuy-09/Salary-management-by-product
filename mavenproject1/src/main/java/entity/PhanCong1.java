/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author duy19
 */
public class PhanCong1 {
    private String maPC;
    private PhanDoan1 congDoan;
    private CongNhan1 congNhan;
    private int soLuongCanLam;
    private Date ngayPhanCong;
    private Date ngayHoanThanh;
    private String trangThai;

    public String getMaPC() {
        return maPC;
    }

    public PhanDoan1 getCongDoan() {
        return congDoan;
    }

    public CongNhan1 getCongNhan() {
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

    public void setMaPC(String maPC) {
        this.maPC = maPC;
    }

    public void setCongDoan(PhanDoan1 congDoan) {
        this.congDoan = congDoan;
    }

    public void setCongNhan(CongNhan1 congNhan) {
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

    public PhanCong1(String maPC, PhanDoan1 congDoan, CongNhan1 congNhan, int soLuongCanLam, Date ngayPhanCong, Date ngayHoanThanh, String trangThai) {
        this.maPC = maPC;
        this.congDoan = congDoan;
        this.congNhan = congNhan;
        this.soLuongCanLam = soLuongCanLam;
        this.ngayPhanCong = ngayPhanCong;
        this.ngayHoanThanh = ngayHoanThanh;
        this.trangThai = trangThai;
    }

    public PhanCong1() {
    }

    @Override
    public String toString() {
        return "PhanCongCN{" + "maPC=" + maPC + ", congDoan=" + congDoan + ", congNhan=" + congNhan + ", soLuongCanLam=" + soLuongCanLam + ", ngayPhanCong=" + ngayPhanCong + ", ngayHoanThanh=" + ngayHoanThanh + ", trangThai=" + trangThai + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.maPC);
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
        final PhanCong1 other = (PhanCong1) obj;
        return Objects.equals(this.maPC, other.maPC);
    }
            
            
}
