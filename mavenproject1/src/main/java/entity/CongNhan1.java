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
public class CongNhan1 {
    private String maCongNhan;
    private String tenCongNhan;
    private Date ngaySinh;
    private boolean  gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String cmnd;
    private Date ngayBatDau;
    private Double troCap;
    private String tayNghe;

    public String getMaCongNhan() {
        return maCongNhan;
    }

    public String getTenCongNhan() {
        return tenCongNhan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public Double getTroCap() {
        return troCap;
    }

    public String getTayNghe() {
        return tayNghe;
    }

    public void setMaCongNhan(String maCongNhan) {
        this.maCongNhan = maCongNhan;
    }

    public void setTenCongNhan(String tenCongNhan) {
        this.tenCongNhan = tenCongNhan;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setTroCap(Double troCap) {
        this.troCap = troCap;
    }

    public void setTayNghe(String tayNghe) {
        this.tayNghe = tayNghe;
    }

    public CongNhan1(String maCongNhan, String tenCongNhan, Date ngaySinh, boolean gioiTinh, String diaChi, String soDienThoai, String email, String cmnd, Date ngayBatDau, Double troCap, String tayNghe) {
        this.maCongNhan = maCongNhan;
        this.tenCongNhan = tenCongNhan;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.cmnd = cmnd;
        this.ngayBatDau = ngayBatDau;
        this.troCap = troCap;
        this.tayNghe = tayNghe;
    }

    public CongNhan1() {
    }

    @Override
    public String toString() {
        return "CongNhan{" + "maCongNhan=" + maCongNhan + ", tenCongNhan=" + tenCongNhan + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", email=" + email + ", cmnd=" + cmnd + ", ngayBatDau=" + ngayBatDau + ", troCap=" + troCap + ", tayNghe=" + tayNghe + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.maCongNhan);
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
        final CongNhan1 other = (CongNhan1) obj;
        return Objects.equals(this.maCongNhan, other.maCongNhan);
    }

    public CongNhan1(String maCongNhan, String tenCongNhan) {
        this.maCongNhan = maCongNhan;
        this.tenCongNhan = tenCongNhan;
    }

    public CongNhan1(String maCongNhan) {
        this.maCongNhan = maCongNhan;
    }
    
    

   
    
    
}
