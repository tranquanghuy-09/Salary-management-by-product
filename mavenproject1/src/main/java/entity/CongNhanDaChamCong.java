/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author duy19
 */
public class CongNhanDaChamCong {
    private List<CongNhan> congNhan;
    private List<ChamCongCN> chamCongCN;

    public List<CongNhan> getCongNhan() {
        return congNhan;
    }

    public List<ChamCongCN> getChamCongCN() {
        return chamCongCN;
    }

    public void setCongNhan(List<CongNhan> congNhan) {
        this.congNhan = congNhan;
    }

    public void setChamCongCN(List<ChamCongCN> chamCongCN) {
        this.chamCongCN = chamCongCN;
    }

    public CongNhanDaChamCong(List<CongNhan> congNhan, List<ChamCongCN> chamCongCN) {
        this.congNhan = congNhan;
        this.chamCongCN = chamCongCN;
    }

    public CongNhanDaChamCong() {
    }

    @Override
    public String toString() {
        return "CongNhanDaChamCong{" + "congNhan=" + congNhan + ", chamCongCN=" + chamCongCN + '}';
    }
    
    

    
    
}
