/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.PhanDoan;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trung
 */
public class PhanDoanDao {

    private Connection connection = ConnectDB.getInstance().getConnection();

    public List<PhanDoan> getPhanDoanByMaSanPham(String maSanPham) {
        List<PhanDoan> phanDoanList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT PHANDOAN.*, SANPHAM.TenSanPham FROM PHANDOAN JOIN SANPHAM ON PHANDOAN.MaSanPham = SANPHAM.MaSanPham WHERE PHANDOAN.MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSanPham);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SanPham sanPham = new SanPham(
                        resultSet.getString("MaSanPham"),
                        resultSet.getString("TenSanPham"));
                PhanDoan phanDoan = new PhanDoan(
                        resultSet.getString("MaPhanDoan"),
                        resultSet.getString("TenPhanDoan"),
                        resultSet.getDouble("GiaPhanDoan"),
                        resultSet.getString("PhanDoanYeuCau"),
                        sanPham
                );
                phanDoanList.add(phanDoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanDoanList;
    }

    public boolean themPhanDoan(PhanDoan pd) {
        String sql = "INSERT INTO PHANDOAN(MaPhanDoan, TenPhanDoan, MaSanPham, GiaPhanDoan, PhanDoanYeuCau) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pd.getMaPhanDoan());
            ps.setString(2, pd.getTenPhanDoan());
            ps.setString(3, pd.getSanPham().getMaSanPham());
            ps.setDouble(4, pd.getGiaPhanDoan());
            ps.setString(5, pd.getPhanDoanYeuCau());

            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean xoaPhanDoan(String maPhanDoan) {
        String sql = "DELETE FROM PHANDOAN WHERE MaPhanDoan = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maPhanDoan);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> getTenPhanDoanList() {
        List<String> tenPhanDoanList = new ArrayList<>();
        String sql = "SELECT TenPhanDoan FROM PHANDOAN";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String tenPhanDoan = rs.getString("TenPhanDoan");
                tenPhanDoanList.add(tenPhanDoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenPhanDoanList;
    }
}
