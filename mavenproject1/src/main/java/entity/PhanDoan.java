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
public class PhanDoan {
    private String maPhanDoan;
    private String tenPhanDoan;
    private SanPham sanPham;
    private double giaPhanDoan;
    private String phanDoanYeuCau;

    public String getMaPhanDoan() {
        return maPhanDoan;
    }

    public String getTenPhanDoan() {
        return tenPhanDoan;
    }

    public SanPham getSanPham() {
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

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setGiaPhanDoan(double giaPhanDoan) {
        this.giaPhanDoan = giaPhanDoan;
    }

    public void setPhanDoanYeuCau(String phanDoanYeuCau) {
        this.phanDoanYeuCau = phanDoanYeuCau;
    }

    public PhanDoan(String maPhanDoan, String tenPhanDoan, SanPham sanPham, double giaPhanDoan, String phanDoanYeuCau) {
        this.maPhanDoan = maPhanDoan;
        this.tenPhanDoan = tenPhanDoan;
        this.sanPham = sanPham;
        this.giaPhanDoan = giaPhanDoan;
        this.phanDoanYeuCau = phanDoanYeuCau;
    }
     public PhanDoan(String maPhanDoan, String tenPhanDoan, double giaPhanDoan, String phanDoanYeuCau, SanPham sanPham) {
        this.maPhanDoan = maPhanDoan;
        this.tenPhanDoan = tenPhanDoan;
        this.giaPhanDoan = giaPhanDoan;
        this.phanDoanYeuCau = phanDoanYeuCau;
        this.sanPham = sanPham;
    }
     
       public PhanDoan(String maPhanDoan) {
        this.maPhanDoan = maPhanDoan;
    }
    public PhanDoan() {
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
        final PhanDoan other = (PhanDoan) obj;
        return Objects.equals(this.maPhanDoan, other.maPhanDoan);
    }
    
    
}
