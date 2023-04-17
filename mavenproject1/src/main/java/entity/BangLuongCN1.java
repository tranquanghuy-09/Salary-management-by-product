/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author duy19
 */
public class BangLuongCN1 {
    private String maPhieuLuong;
    private int namLuong;
    private int thangLuong;
    private ChamCongCN1 chamCongCN;
    private double tongLuong;
    private Date ngaylap;

    public String getMaPhieuLuong() {
        return maPhieuLuong;
    }

    public int getNamLuong() {
        return namLuong;
    }

    public int getThangLuong() {
        return thangLuong;
    }

    public ChamCongCN1 getChamCongCN() {
        return chamCongCN;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setMaPhieuLuong(String maPhieuLuong) {
        this.maPhieuLuong = maPhieuLuong;
    }

    public void setNamLuong(int namLuong) {
        this.namLuong = namLuong;
    }

    public void setThangLuong(int thangLuong) {
        this.thangLuong = thangLuong;
    }

    public void setChamCongCN(ChamCongCN1 chamCongCN) {
        this.chamCongCN = chamCongCN;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public BangLuongCN1() {
    }

    public BangLuongCN1(String maPhieuLuong, int namLuong, int thangLuong, ChamCongCN1 chamCongCN, double tongLuong, Date ngaylap) {
        this.maPhieuLuong = maPhieuLuong;
        this.namLuong = namLuong;
        this.thangLuong = thangLuong;
        this.chamCongCN = chamCongCN;
        this.tongLuong = tongLuong;
        this.ngaylap = ngaylap;
    }

    public BangLuongCN1(String maPhieuLuong, int namLuong, int thangLuong, ChamCongCN1 chamCongCN, double tongLuong) {
        this.maPhieuLuong = maPhieuLuong;
        this.namLuong = namLuong;
        this.thangLuong = thangLuong;
        this.chamCongCN = chamCongCN;
        this.tongLuong = tongLuong;
    }

    
    @Override
    public String toString() {
        return "BangLuongCN{" + "maPhieuLuong=" + maPhieuLuong + ", namLuong=" + namLuong + ", thangLuong=" + thangLuong + ", chamCongCN=" + chamCongCN + ", tongLuong=" + tongLuong + ", ngaylap=" + ngaylap + '}';
    }
    
    
    
    
    
}
