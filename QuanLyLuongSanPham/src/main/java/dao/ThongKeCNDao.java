/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.CongNhan;
import entity.ThongKeCN;
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
public class ThongKeCNDao {

    private Connection connection = ConnectDB.getInstance().getConnection();

    public List<ThongKeCN> findByThangNam(int thang, int nam) {
        List<ThongKeCN> tienLuongList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM BANGLUONGCONGNHAN INNER JOIN CONGNHAN ON BANGLUONGCONGNHAN.MaCongNhan = CONGNHAN.MaCongNhan WHERE ThangLuong = ? AND NamLuong = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, thang);
            preparedStatement.setInt(2, nam);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CongNhan congNhan = new CongNhan(
                        resultSet.getString("MaCongNhan"),
                        resultSet.getString("TenCongNhan"),
                        resultSet.getString("DiaChi"));
                ThongKeCN tienLuong = new ThongKeCN(
                        resultSet.getString("MaPhieuLuong"),
                        resultSet.getInt("ThangLuong"),
                        resultSet.getInt("NamLuong"),
                        resultSet.getInt("SoLuongDaLam"),
                        resultSet.getFloat("TongLuong"),
                        congNhan
                );
                tienLuongList.add(tienLuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tienLuongList;
    }
}
