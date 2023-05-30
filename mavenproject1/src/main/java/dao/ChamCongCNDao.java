/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChamCongCN;
import entity.CongNhan;
import entity.PhanCong;
import entity.PhanDoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectDB.ConnectDB;
/**
 *
 * @author duy19
 */
public class ChamCongCNDao {
  
    public ChamCongCN getChamCongByID(String id) throws Exception {
        String sql = "select * from CHAMCONGCONGNHAN where MaChamCong =  '" + id + "'";
        Connection con = ConnectDB.getInstance().getConnection();
        try (
               // Connection con = ConnectDB1.opConnection();
               
                PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    ChamCongCN chamCongCN = new ChamCongCN();
                    chamCongCN.setMaChamCong(rs.getString("MaChamCong"));
                    chamCongCN.setCaLam(rs.getString("CaLam"));
                    chamCongCN.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
                    chamCongCN.setHeSoLuongCa((float) rs.getDouble("HeSoLuongCa"));
                    chamCongCN.setNgayChamCong(rs.getDate("NgayChamCong"));
                    PhanCongCNDao dao = new PhanCongCNDao();
                    PhanCong phanCongCN = dao.getPCCNByID(rs.getString("MaPhanCong"));
                    chamCongCN.setPhanCongCN(phanCongCN);
                    chamCongCN.setTrangThai(rs.getString("TrangThai"));
                    con.commit();
                    return chamCongCN;
                }

            }
            return null;
        }
    }
    
    public List<ChamCongCN> getAllChamCong() throws Exception {
        List<ChamCongCN> chamCongList = new ArrayList<>();
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            String sql = "SELECT cc.MaChamCong, cc.SoLuongSanPham, cc.HeSoLuongCa, cc.CaLam, cc.NgayChamCong, pc.MaPhanCong, pc.SoLuongCanLam, pc.NgayPhanCong, pc.NgayHoanThanh, pc.TrangThai, pc.MaPhanDoan, pc.MaCongNhan FROM CHAMCONGCONGNHAN cc JOIN BANGPHANCONG pc ON cc.MaPhanCong = pc.MaPhanCong";
           // Connection con = ConnectDB1.opConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhanCong phanCong = new PhanCong();
                phanCong.setMaPC(rs.getString("MaPhanCong"));
                phanCong.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
                phanCong.setNgayPhanCong(rs.getDate("NgayPhanCong"));
                phanCong.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
                phanCong.setTrangThai(rs.getString("TrangThai"));
                PhanDoanDao phandao_dao =new PhanDoanDao();
                PhanDoan pd = phandao_dao.getCDByID(rs.getString("MaPhanDoan"));
                CongNhanDao cn_dao =new CongNhanDao();
                CongNhan cn = cn_dao.getCNByID(rs.getString("MaCongNhan"));
                phanCong.setCongDoan(pd);
                phanCong.setCongNhan(cn);
                ChamCongCN chamCong = new ChamCongCN();
                chamCong.setMaChamCong(rs.getString("MaChamCong"));
                chamCong.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
                chamCong.setHeSoLuongCa(rs.getFloat("HeSoLuongCa"));
                chamCong.setCaLam(rs.getString("CaLam"));
                chamCong.setNgayChamCong(rs.getDate("NgayChamCong"));
                chamCong.setTrangThai(rs.getString("TrangThai"));
                chamCong.setPhanCongCN(phanCong);
                chamCongList.add(chamCong);
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }
        return chamCongList;
    }
    //String maChamCong, PhanCong phanCong, int soLuongSanPham, float heSoLuongCa, String caLam, String trangThai
    
    public ChamCongCN timChamCongTheoMaCN(String ma) throws Exception {
        String sql = "select cc.* from CHAMCONGCONGNHAN cc join BANGPHANCONG pc on cc.MaPhanCong = pc.MaPhanCong join CONGNHAN cn on pc.MaCongNhan = cn.MaCongNhan Where cn.MaCongNhan = '" + ma + "'";
        Connection con = ConnectDB.getInstance().getConnection();
        try (
              //  Connection con = ConnectDB1.opConnection();
               PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                  ChamCongCN chamCongCN = new ChamCongCN();
                    chamCongCN.setMaChamCong(rs.getString("MaChamCong"));
                    chamCongCN.setCaLam(rs.getString("CaLam"));
                    chamCongCN.setHeSoLuongCa((float)rs.getDouble("HeSoLuongCa"));
                    chamCongCN.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
                    chamCongCN.setNgayChamCong(rs.getDate("NgayChamCong"));
                    PhanCongCNDao phanCongCN_dao = new PhanCongCNDao();
                    PhanCong phanCongCN = phanCongCN_dao.getPCCNByID(rs.getString("MaPhanCong"));
                    chamCongCN.setPhanCongCN(phanCongCN);
                    chamCongCN.setTrangThai(rs.getString("TrangThai"));
                    con.commit();
                    return chamCongCN;
                }
            }
            return null;
        }
    }
    
    

    public boolean themChamCongCongNhan(ChamCongCN chamCong) {
        try {
            String sql = "INSERT INTO CHAMCONGCONGNHAN(MaChamCong, MaPhanCong, SoLuongSanPham, HeSoLuongCa, CaLam, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
            Connection connection = ConnectDB.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, chamCong.getMaChamCong());
            pstmt.setString(2, chamCong.getPhanCong().getMaPC());
            pstmt.setInt(3, chamCong.getSoLuongSanPham());
            pstmt.setFloat(4, chamCong.getHeSoLuongCa());
            pstmt.setString(5, chamCong.getCaLam());
            pstmt.setString(6, chamCong.getTrangThai());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoaChamCong(String maChamCong, String maPhanCong) {
        String sql = "DELETE FROM CHAMCONGCONGNHAN WHERE MaChamCong = ? AND MaPhanCong = ?";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maChamCong);
            preparedStatement.setString(2, maPhanCong);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
