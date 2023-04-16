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
public class CongNhanDaChamCong1 {
    private List<CongNhan1> congNhan;
    private List<ChamCongCN1> chamCongCN;

    public List<CongNhan1> getCongNhan() {
        return congNhan;
    }

    public List<ChamCongCN1> getChamCongCN() {
        return chamCongCN;
    }

    public void setCongNhan(List<CongNhan1> congNhan) {
        this.congNhan = congNhan;
    }

    public void setChamCongCN(List<ChamCongCN1> chamCongCN) {
        this.chamCongCN = chamCongCN;
    }

    public CongNhanDaChamCong1(List<CongNhan1> congNhan, List<ChamCongCN1> chamCongCN) {
        this.congNhan = congNhan;
        this.chamCongCN = chamCongCN;
    }

    public CongNhanDaChamCong1() {
    }

    @Override
    public String toString() {
        return "CongNhanDaChamCong{" + "congNhan=" + congNhan + ", chamCongCN=" + chamCongCN + '}';
    }
    
    

    
    
}
