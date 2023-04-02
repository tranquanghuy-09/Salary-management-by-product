/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huylauri
 */
public class PhongBanDao {

    //Tìm Phòng ban theo mã phòng ban
    public PhongBan layPBTheoMa(String maPhongBan) throws Exception {
        String sql = "select * from PHONGBAN where  MaPhongBan=?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maPhongBan);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PhongBan pb = new PhongBan();
                pb.setMaPhongBan(rs.getString("MaPhongBan"));
                pb.setTenPhongBan(rs.getString("TenPhongBan"));
                return pb;
            }
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return null;
    }
    //Tìm Phòng ban theo tên phòng ban
    public PhongBan layPBTheoTen(String tenPhongBan) throws Exception {
        String sql = "select * from PHONGBAN where  TenPhongBan=?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenPhongBan);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PhongBan pb = new PhongBan();
                pb.setMaPhongBan(rs.getString("MaPhongBan"));
                pb.setTenPhongBan(rs.getString("TenPhongBan"));
                return pb;
            }
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return null;
    }
    
    //Lấy toàn bộ tên Phòng ban
    public List<String> layDsTenPhongBan() throws Exception {
        String sql = "select * from PHONGBAN";
        Connection con = ConnectDB.getInstance().getConnection();
        List<String> list = new ArrayList<String>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("TenPhongBan"));
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return list;
    }
}
