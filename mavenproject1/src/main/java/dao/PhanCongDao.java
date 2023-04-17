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
import entity.CongNhan;
import entity.PhanCong;
import entity.PhanDoan;

/**
 *
 * @author trung
 */
public class PhanCongDao {

    private Connection connection = ConnectDB.getInstance().getConnection();

    public List<PhanCong> getAllPhanCong() {
        List<PhanCong> phanCongs = new ArrayList<>();

        try {
            String query = "SELECT * FROM BANGPHANCONG";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CongNhan congNhan = new CongNhan(
                        resultSet.getString("MaCongNhan"));
                PhanDoan phanDoan = new PhanDoan(
                        resultSet.getString("MaPhanDoan"));
                PhanCong phanCong = new PhanCong(
                        resultSet.getString("MaPhanCong"),
                        phanDoan,
                        congNhan,
                        resultSet.getInt("SoLuongCanLam"),
                        resultSet.getDate("NgayPhanCong"),
                        resultSet.getDate("NgayHoanThanh"),
                        resultSet.getString("TrangThai")
                );
                phanCongs.add(phanCong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanCongs;
    }

}
