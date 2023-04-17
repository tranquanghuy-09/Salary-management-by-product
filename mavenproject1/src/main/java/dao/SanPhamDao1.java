/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.SanPham1;

/**
 *
 * @author trung
 */
public class SanPhamDao1 {

    public List<SanPham1> getAllSanPham() throws Exception {
        List<SanPham1> sanPhams = new ArrayList<>();

        try {
            Connection con = ConnectDB1.opConnection();
            String query = "SELECT * FROM SanPham";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SanPham1 sanPham = new SanPham1(
                        resultSet.getString("MaSanPham"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("LoaiSanPham"),
                        resultSet.getString("MauSac"),
                        resultSet.getString("ChatLieu"),
                        resultSet.getInt("SoLuongCanLam"),
                        resultSet.getInt("SoLuongDaLam"),
                        resultSet.getDate("NgayHoanThanh"),
                        resultSet.getString("TrangThai")
                );

                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sanPhams;
    }

    public boolean themSanPham(SanPham1 sanPham) throws Exception {
        String sql = "INSERT INTO SANPHAM(MaSanPham, TenSanPham, LoaiSanPham, MauSac, ChatLieu, SoLuongCanLam, SoLuongDaLam, NgayHoanThanh, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            
            Connection con = ConnectDB1.opConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, sanPham.getMaSanPham());
            preparedStatement.setString(2, sanPham.getTenSanPham());
            preparedStatement.setString(3, sanPham.getLoaiSanPham());
            preparedStatement.setString(4, sanPham.getMauSac());
            preparedStatement.setString(5, sanPham.getChatLieu());
            preparedStatement.setInt(6, sanPham.getSoLuongCanLam());
            preparedStatement.setInt(7, sanPham.getSoLuongDaLam());
            preparedStatement.setDate(8, new java.sql.Date(sanPham.getNgayHoanThanh().getTime()));
            preparedStatement.setString(9, sanPham.getTrangThai());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaSanPham(String maSanPham) throws Exception {
        String sql = "DELETE FROM SANPHAM WHERE MaSanPham = ?";
        try {
            Connection con = ConnectDB1.opConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maSanPham);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaSanPham(SanPham1 sanPham) throws Exception {
        String sql = "UPDATE SANPHAM SET TenSanPham = ?, LoaiSanPham = ?, MauSac = ?, ChatLieu = ?, SoLuongCanLam = ?, SoLuongDaLam = ?, NgayHoanThanh = ?, TrangThai = ? WHERE MaSanPham = ?";
        try {
            Connection con = ConnectDB1.opConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, sanPham.getTenSanPham());
            preparedStatement.setString(2, sanPham.getLoaiSanPham());
            preparedStatement.setString(3, sanPham.getMauSac());
            preparedStatement.setString(4, sanPham.getChatLieu());
            preparedStatement.setInt(5, sanPham.getSoLuongCanLam());
            preparedStatement.setInt(6, sanPham.getSoLuongDaLam());
            preparedStatement.setDate(7, new java.sql.Date(sanPham.getNgayHoanThanh().getTime()));
            preparedStatement.setString(8, sanPham.getTrangThai());
            preparedStatement.setString(9, sanPham.getMaSanPham());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public SanPham1 timSanPhamTheoMa(String ma) throws Exception {
        String sql = "select * from SANPHAM where MaSanPham =  '" + ma + "'";
        try (
                Connection con = ConnectDB1.opConnection(); PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    SanPham1 sp = new SanPham1();
                    sp.setMaSanPham(rs.getString("MaSanPham"));
                    sp.setTenSanPham(rs.getString("TenSanPham"));
                    sp.setLoaiSanPham(rs.getString("LoaiSanPham"));
                    sp.setChatLieu(rs.getString("ChatLieu"));
                    sp.setMauSac(rs.getString("MauSac"));
                    sp.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
                    sp.setSoLuongDaLam(rs.getInt("SoLuongDaLam"));
                    sp.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
                    sp.setTrangThai(rs.getString("TrangThai"));
                    return sp;
                }
            }
            return null;
        }
    }
}
