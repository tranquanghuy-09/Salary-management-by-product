/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.SanPham;

/**
 *
 * @author trung
 */
public class SanPhamDao {

    public List<SanPham> getAllSanPham() throws Exception {
        List<SanPham> sanPhams = new ArrayList<>();
        Connection con = ConnectDB.getInstance().getConnection();
        try {
           // Connection con = ConnectDB1.opConnection();
            String query = "SELECT * FROM SanPham";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham(
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
                con.commit();
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }

        return sanPhams;
    }

    public boolean themSanPham(SanPham sanPham) throws Exception {
        String sql = "INSERT INTO SANPHAM(MaSanPham, TenSanPham, LoaiSanPham, MauSac, ChatLieu, SoLuongCanLam, SoLuongDaLam, NgayHoanThanh, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = ConnectDB.getInstance().getConnection();
        try {  
          //  Connection con = ConnectDB1.opConnection();
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
            con.commit();
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }

    public boolean xoaSanPham(String maSanPham) throws Exception {
        String sql = "DELETE FROM SANPHAM WHERE MaSanPham = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
         //   Connection con = ConnectDB1.opConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maSanPham);
            con.commit();
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }

    public boolean suaSanPham(SanPham sanPham) throws Exception {
        String sql = "UPDATE SANPHAM SET TenSanPham = ?, LoaiSanPham = ?, MauSac = ?, ChatLieu = ?, SoLuongCanLam = ?, SoLuongDaLam = ?, NgayHoanThanh = ?, TrangThai = ? WHERE MaSanPham = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
          //  Connection con = ConnectDB1.opConnection();
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
            con.commit();
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }
    
    public SanPham timSanPhamTheoMa(String ma) throws Exception {
        String sql = "select * from SANPHAM where MaSanPham =  '" + ma + "'";
        Connection con = ConnectDB.getInstance().getConnection();
        try (
                //Connection con = ConnectDB1.opConnection(); 
                PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaSanPham(rs.getString("MaSanPham"));
                    sp.setTenSanPham(rs.getString("TenSanPham"));
                    sp.setLoaiSanPham(rs.getString("LoaiSanPham"));
                    sp.setChatLieu(rs.getString("ChatLieu"));
                    sp.setMauSac(rs.getString("MauSac"));
                    sp.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
                    sp.setSoLuongDaLam(rs.getInt("SoLuongDaLam"));
                    sp.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
                    sp.setTrangThai(rs.getString("TrangThai"));
                    con.commit();
                    return sp;
                }
            }
            return null;
        }
    }
    
     public List<SanPham> timKiemSanPham(String maSanPham, String tenSanPham, String loaiSanPham, String mauSac, String chatLieu) {
        List<SanPham> sanPhams = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE MaSanPham LIKE ? AND TenSanPham LIKE ? AND LoaiSanPham LIKE ? AND MauSac LIKE ? AND ChatLieu LIKE ?";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + maSanPham + "%");
            statement.setString(2, "%" + tenSanPham + "%");
            statement.setString(3, "%" + loaiSanPham + "%");
            statement.setString(4, "%" + mauSac + "%");
            statement.setString(5, "%" + chatLieu + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SanPham sanPham = new SanPham(
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
    
}
