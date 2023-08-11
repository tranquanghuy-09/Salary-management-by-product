/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author huylauri
 */
public class BangLuongNhanVien {
    private String maBangLuong;
    private NhanVien nhanVien;
    private int namLuong;
    private int thangLuong;
    private double soNgayLam;
    private double tongLuong;
    private Date ngayLapPhieuLuong;

    public BangLuongNhanVien() {
    }

    public BangLuongNhanVien(String maBangLuong, NhanVien nhanVien, int namLuong, int thangLuong, double soNgayLam, double tongLuong, Date ngayLapPhieuLuong) {
        this.maBangLuong = maBangLuong;
        this.nhanVien = nhanVien;
        this.namLuong = namLuong;
        this.thangLuong = thangLuong;
        this.soNgayLam = soNgayLam;
        this.tongLuong = tongLuong;
        this.ngayLapPhieuLuong = ngayLapPhieuLuong;
    }

    public BangLuongNhanVien(NhanVien nhanVien, int namLuong, int thangLuong, double soNgayLam, double tongLuong) {
        this.nhanVien = nhanVien;
        this.namLuong = namLuong;
        this.thangLuong = thangLuong;
        this.soNgayLam = soNgayLam;
        this.tongLuong = tongLuong;
    }

    public String getMaBangLuong() {
        return maBangLuong;
    }

    public void setMaBangLuong(String maBangLuong) {
        this.maBangLuong = maBangLuong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getNamLuong() {
        return namLuong;
    }

    public void setNamLuong(int namLuong) {
        this.namLuong = namLuong;
    }

    public int getThangLuong() {
        return thangLuong;
    }

    public void setThangLuong(int thangLuong) {
        this.thangLuong = thangLuong;
    }

    public double getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(double soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }

    public Date getNgayLapPhieuLuong() {
        return ngayLapPhieuLuong;
    }

    public void setNgayLapPhieuLuong(Date ngayLapPhieuLuong) {
        this.ngayLapPhieuLuong = ngayLapPhieuLuong;
    }

    @Override
    public String toString() {
        return "BangLuongNhanVien{" + "maBangLuong=" + maBangLuong + ", nhanVien=" + nhanVien + ", namLuong=" + namLuong + ", thangLuong=" + thangLuong + ", soNgayLam=" + soNgayLam + ", tongLuong=" + tongLuong + ", ngayLapPhieuLuong=" + ngayLapPhieuLuong + '}';
    }
}
