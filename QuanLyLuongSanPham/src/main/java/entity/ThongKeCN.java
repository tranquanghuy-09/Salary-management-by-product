/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author trung
 */
public class ThongKeCN {

    private String maPhieuLuong;
    private int namLuong;
    private int thangLuong;
    private int soLuongDaLam;
    private float tongLuong;
    
    private CongNhan congNhan;

    public ThongKeCN(String maPhieuLuong, int namLuong, int thangLuong, int soLuongDaLam, float tongLuong, CongNhan congNhan) {
        this.maPhieuLuong = maPhieuLuong;
        this.namLuong = namLuong;
        this.thangLuong = thangLuong;
        this.soLuongDaLam = soLuongDaLam;
        this.tongLuong = tongLuong;
        this.congNhan = congNhan;
    }

    public String getMaPhieuLuong() {
        return maPhieuLuong;
    }

    public int getNamLuong() {
        return namLuong;
    }

    public int getThangLuong() {
        return thangLuong;
    }

    public int getSoLuongDaLam() {
        return soLuongDaLam;
    }

    public float getTongLuong() {
        return tongLuong;
    }

    public CongNhan getCongNhan() {
        return congNhan;
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

    public void setSoLuongDaLam(int soLuongDaLam) {
        this.soLuongDaLam = soLuongDaLam;
    }

    public void setTongLuong(float tongLuong) {
        this.tongLuong = tongLuong;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    

}
