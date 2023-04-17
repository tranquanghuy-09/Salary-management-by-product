/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.ChamCongCN;
import entity.CongNhan;
import entity.PhanCong;
import entity.PhanDoan;

/**
 *
 * @author trung
 */
public class ChamCongCNDao {

    private Connection connection = ConnectDB.getInstance().getConnection();

    public List<ChamCongCN> getAllChamCong() {
        List<ChamCongCN> chamCongList = new ArrayList<>();
        try {
            String sql = "SELECT cc.MaChamCong, cc.SoLuongSanPham, cc.HeSoLuongCa, cc.CaLam, cc.TrangThai, cc.NgayChamCong, pc.MaPhanCong, pc.SoLuongCanLam, pc.NgayPhanCong, pc.NgayHoanThanh, pc.TrangThai, pc.MaPhanDoan, pc.MaCongNhan FROM CHAMCONGCONGNHAN cc JOIN BANGPHANCONG pc ON cc.MaPhanCong = pc.MaPhanCong";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhanCong phanCong = new PhanCong();
                phanCong.setMaPhanCong(rs.getString("MaPhanCong"));
                phanCong.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
                phanCong.setNgayPhanCong(rs.getDate("NgayPhanCong"));
                phanCong.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
                phanCong.setTrangThai(rs.getString("TrangThai"));

                PhanDoan phanDoan = new PhanDoan();
                phanDoan.setMaPhanDoan(rs.getString("MaPhanDoan"));
                phanCong.setPhanDoan(phanDoan);

                CongNhan congNhan = new CongNhan();
                congNhan.setMaCongNhan(rs.getString("MaCongNhan"));
                phanCong.setCongNhan(congNhan);

                ChamCongCN chamCong = new ChamCongCN();
                chamCong.setMaChamCong(rs.getString("MaChamCong"));
                chamCong.setSoLuongSanPham(rs.getInt("SoLuongSanPham"));
                chamCong.setHeSoLuongCa(rs.getFloat("HeSoLuongCa"));
                chamCong.setCaLam(rs.getString("CaLam"));
                chamCong.setNgayChamCong(rs.getDate("NgayChamCong"));
                chamCong.setTrangThai(rs.getString("TrangThai"));

                chamCong.setPhanCong(phanCong);

                chamCongList.add(chamCong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chamCongList;
    }

    public boolean themChamCongCongNhan(ChamCongCN chamCong) {
        try {
            String sql = "INSERT INTO CHAMCONGCONGNHAN(MaChamCong, MaPhanCong, SoLuongSanPham, HeSoLuongCa, CaLam, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, chamCong.getMaChamCong());
            pstmt.setString(2, chamCong.getPhanCong().getMaPhanCong());
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

    public boolean xoaChamCong(String maChamCong) {
        String sql = "DELETE FROM CHAMCONGCONGNHAN WHERE MaChamCong = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maChamCong);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
