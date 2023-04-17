/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class PhanDoan {

    private String maPhanDoan;
    private String tenPhanDoan;
    private double giaPhanDoan;
    private String phanDoanYeuCau;

    private SanPham sanPham;

    public PhanDoan() {
    }

    public PhanDoan(String maPhanDoan) {
        this.maPhanDoan = maPhanDoan;
    }

    public PhanDoan(String maPhanDoan, String tenPhanDoan, double giaPhanDoan, String phanDoanYeuCau, SanPham sanPham) {
        this.maPhanDoan = maPhanDoan;
        this.tenPhanDoan = tenPhanDoan;
        this.giaPhanDoan = giaPhanDoan;
        this.phanDoanYeuCau = phanDoanYeuCau;
        this.sanPham = sanPham;
    }

    public String getMaPhanDoan() {
        return maPhanDoan;
    }

    public String getTenPhanDoan() {
        return tenPhanDoan;
    }

    public double getGiaPhanDoan() {
        return giaPhanDoan;
    }

    public String getPhanDoanYeuCau() {
        return phanDoanYeuCau;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setMaPhanDoan(String maPhanDoan) {
        this.maPhanDoan = maPhanDoan;
    }

    public void setTenPhanDoan(String tenPhanDoan) {
        this.tenPhanDoan = tenPhanDoan;
    }

    public void setGiaPhanDoan(double giaPhanDoan) {
        this.giaPhanDoan = giaPhanDoan;
    }

    public void setPhanDoanYeuCau(String phanDoanYeuCau) {
        this.phanDoanYeuCau = phanDoanYeuCau;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

}
