/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author duy19
 */
public class PhanDoan1 {
    private String maPhanDoan;
    private String tenPhanDoan;
    private SanPham1 sanPham;
    private double giaPhanDoan;
    private String phanDoanYeuCau;

    public String getMaPhanDoan() {
        return maPhanDoan;
    }

    public String getTenPhanDoan() {
        return tenPhanDoan;
    }

    public SanPham1 getSanPham() {
        return sanPham;
    }

    public double getGiaPhanDoan() {
        return giaPhanDoan;
    }

    public String getPhanDoanYeuCau() {
        return phanDoanYeuCau;
    }

    public void setMaPhanDoan(String maPhanDoan) {
        this.maPhanDoan = maPhanDoan;
    }

    public void setTenPhanDoan(String tenPhanDoan) {
        this.tenPhanDoan = tenPhanDoan;
    }

    public void setSanPham(SanPham1 sanPham) {
        this.sanPham = sanPham;
    }

    public void setGiaPhanDoan(double giaPhanDoan) {
        this.giaPhanDoan = giaPhanDoan;
    }

    public void setPhanDoanYeuCau(String phanDoanYeuCau) {
        this.phanDoanYeuCau = phanDoanYeuCau;
    }

    public PhanDoan1(String maPhanDoan, String tenPhanDoan, SanPham1 sanPham, double giaPhanDoan, String phanDoanYeuCau) {
        this.maPhanDoan = maPhanDoan;
        this.tenPhanDoan = tenPhanDoan;
        this.sanPham = sanPham;
        this.giaPhanDoan = giaPhanDoan;
        this.phanDoanYeuCau = phanDoanYeuCau;
    }

    public PhanDoan1() {
    }

    @Override
    public String toString() {
        return "CongDoan{" + "maPhanDoan=" + maPhanDoan + ", tenPhanDoan=" + tenPhanDoan + ", sanPham=" + sanPham + ", giaPhanDoan=" + giaPhanDoan + ", phanDoanYeuCau=" + phanDoanYeuCau + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.maPhanDoan);
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
        final PhanDoan1 other = (PhanDoan1) obj;
        return Objects.equals(this.maPhanDoan, other.maPhanDoan);
    }
    
    
}
