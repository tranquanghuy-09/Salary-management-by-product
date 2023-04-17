/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import connectDB.ConnectDB1;
import entity.CongNhan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trung
 */
public class CongNhanDao {

    private Connection connection = ConnectDB.getInstance().getConnection();

    public List<CongNhan> timKiemCongNhan(String maCongNhan, String tenCongNhan, String diaChi, String soDienThoai, String email, String CMND) {
        List<CongNhan> congNhans = new ArrayList<>();
        String query = "SELECT * FROM CONGNHAN WHERE MaCongNhan LIKE ? AND TenCongNhan LIKE ? AND DiaChi LIKE ? AND SoDienThoai LIKE ? AND Email LIKE ? AND CMND LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + maCongNhan + "%");
            statement.setString(2, "%" + tenCongNhan + "%");
            statement.setString(3, "%" + diaChi + "%");
            statement.setString(4, "%" + soDienThoai + "%");
            statement.setString(5, "%" + email + "%");
            statement.setString(6, "%" + CMND + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CongNhan congNhan = new CongNhan(
                        resultSet.getString("MaCongNhan"),
                        resultSet.getString("TenCongNhan"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getBoolean("GioiTinh"),
                        resultSet.getString("DiaChi"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("Email"),
                        resultSet.getString("CMND"),
                        resultSet.getDate("NgayBatDau"),
                        resultSet.getDouble("TroCap"),
                        resultSet.getString("TayNghe")
                );
                congNhans.add(congNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congNhans;
    }
}
