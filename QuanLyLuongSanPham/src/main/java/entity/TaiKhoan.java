/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author huylauri
 */
public class TaiKhoan {
    private String maNhanVien;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String maNhanVien, String tenTaiKhoan, String matKhau) {
        this.maNhanVien = maNhanVien;
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }


    public String getMatKhau() {
        return matKhau;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "maNhanVien=" + maNhanVien + ", matKhau=" + matKhau + '}';
    }

    
    
}
