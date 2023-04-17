/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB1;
import entity.ChamCongCN1;
import entity.CongNhan1;
import entity.PhanCong1;
import entity.PhanDoan1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duy19
 */
public class ChamCongCNDao1 {
  
    public ChamCongCN1 getChamCongByID(String id) throws Exception {
        String sql = "select * from CHAMCONGCONGNHAN where MaChamCong =  '" + id + "'";
        try (
                Connection con = ConnectDB1.opConnection();
                PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    ChamCongCN1 chamCongCN = new ChamCongCN1();
                    chamCongCN.setMaChamCong(rs.getString("MaChamCong"));
                    chamCongCN.setCaLam(rs.getString("CaLam"));
                    chamCongCN.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
                    chamCongCN.setHeSoLuongCa((float) rs.getDouble("HeSoLuongCa"));
                    chamCongCN.setNgayChamCong(rs.getDate("NgayChamCong"));
                    PhanCongCNDao1 dao = new PhanCongCNDao1();
                    PhanCong1 phanCongCN = dao.getPCCNByID(rs.getString("MaPhanCong"));
                    chamCongCN.setPhanCongCN(phanCongCN);
                    chamCongCN.setTrangThai(rs.getString("TrangThai"));
                    con.close();
                    return chamCongCN;
                }

            }
            return null;
        }
    }
    
    public List<ChamCongCN1> getAllChamCong() throws Exception {
        List<ChamCongCN1> chamCongList = new ArrayList<>();
        try {
            String sql = "SELECT cc.MaChamCong, cc.SoLuongSanPham, cc.HeSoLuongCa, cc.CaLam, cc.NgayChamCong, pc.MaPhanCong, pc.SoLuongCanLam, pc.NgayPhanCong, pc.NgayHoanThanh, pc.TrangThai, pc.MaPhanDoan, pc.MaCongNhan FROM CHAMCONGCONGNHAN cc JOIN BANGPHANCONG pc ON cc.MaPhanCong = pc.MaPhanCong";
            Connection con = ConnectDB1.opConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhanCong1 phanCong = new PhanCong1();
                phanCong.setMaPC(rs.getString("MaPhanCong"));
                phanCong.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
                phanCong.setNgayPhanCong(rs.getDate("NgayPhanCong"));
                phanCong.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
                phanCong.setTrangThai(rs.getString("TrangThai"));
                PhanDoanDao1 phandao_dao =new PhanDoanDao1();
                PhanDoan1 pd = phandao_dao.getCDByID(rs.getString("MaPhanDoan"));
                CongNhanDao1 cn_dao =new CongNhanDao1();
                CongNhan1 cn = cn_dao.getCNByID(rs.getString("MaCongNhan"));
                phanCong.setCongDoan(pd);
                phanCong.setCongNhan(cn);
                ChamCongCN1 chamCong = new ChamCongCN1();
                chamCong.setMaChamCong(rs.getString("MaChamCong"));
                chamCong.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
                chamCong.setHeSoLuongCa(rs.getFloat("HeSoLuongCa"));
                chamCong.setCaLam(rs.getString("CaLam"));
                chamCong.setNgayChamCong(rs.getDate("NgayChamCong"));
                chamCong.setTrangThai(rs.getString("TrangThai"));
                chamCong.setPhanCongCN(phanCong);
                chamCongList.add(chamCong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chamCongList;
    }
    //String maChamCong, PhanCong phanCong, int soLuongSanPham, float heSoLuongCa, String caLam, String trangThai
    
    public ChamCongCN1 timChamCongTheoMaCN(String ma) throws Exception {
        String sql = "select cc.* from CHAMCONGCONGNHAN cc join BANGPHANCONG pc on cc.MaPhanCong = pc.MaPhanCong join CONGNHAN cn on pc.MaCongNhan = cn.MaCongNhan Where cn.MaCongNhan = '" + ma + "'";
        try (
                Connection con = ConnectDB1.opConnection();
               PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                  ChamCongCN1 chamCongCN = new ChamCongCN1();
                    chamCongCN.setMaChamCong(rs.getString("MaChamCong"));
                    chamCongCN.setCaLam(rs.getString("CaLam"));
                    chamCongCN.setHeSoLuongCa((float)rs.getDouble("HeSoLuongCa"));
                    chamCongCN.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
                    chamCongCN.setNgayChamCong(rs.getDate("NgayChamCong"));
                    PhanCongCNDao1 phanCongCN_dao = new PhanCongCNDao1();
                    PhanCong1 phanCongCN = phanCongCN_dao.getPCCNByID(rs.getString("MaPhanCong"));
                    chamCongCN.setPhanCongCN(phanCongCN);
                    chamCongCN.setTrangThai(rs.getString("TrangThai"));
                    
                    return chamCongCN;
                }

            }
            return null;
        }
    }
}
