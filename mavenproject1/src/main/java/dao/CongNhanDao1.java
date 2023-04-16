/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB1;
import entity.CongNhan1;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duy19
 */
public class CongNhanDao1 {

    private CongNhan1 cn = new CongNhan1();
 
    public List<CongNhan1> getDanhSachCN() throws SQLException, Exception {
        String sql = "select * from CONGNHAN";
        Connection connection = ConnectDB1.opConnection();
        List<CongNhan1> list = new ArrayList<CongNhan1>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                boolean gt;
                if (rs.getInt("GioiTinh") == 1) {
                    gt = true;
                } else {
                    gt = false;
                }
                CongNhan1 cn = new CongNhan1();
                cn = new CongNhan1(rs.getString("MaCongNhan"), rs.getString("TenCongNhan"), rs.getDate("NgaySinh"), gt, rs.getString("DiaChi"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("CMND"),
                        rs.getDate("NgayBatDau"), rs.getDouble("TroCap"), rs.getString("TayNghe"));

                list.add(cn);
            }
            connection.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            connection.rollback();
        }

        return list;
    }

    

    public Boolean themCN(CongNhan1 cn) throws Exception {
        int n;
        String sql = "INSERT INTO [dbo].[CONGNHAN]([MaCongNhan],[TenCongNhan],[NgaySinh],[GioiTinh],[DiaChi],[SoDienThoai],[Email],[CMND],[NgayBatDau],[TayNghe],[TroCap])VALUES(?,?,?,?,?,?,?,?,?,?,?)";
         Connection connection = ConnectDB1.opConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cn.getMaCongNhan());
            stmt.setString(2, cn.getTenCongNhan());
            stmt.setDate(3, new java.sql.Date(cn.getNgaySinh().getTime()));
            stmt.setInt(4, cn.isGioiTinh() ? 1 : 0);
            stmt.setString(5, cn.getDiaChi());
            stmt.setString(6, cn.getSoDienThoai());
            stmt.setString(7, cn.getEmail());
            stmt.setString(8, cn.getCmnd());
            stmt.setDate(9, new java.sql.Date(cn.getNgayBatDau().getTime()));
            stmt.setString(10, cn.getTayNghe());
            stmt.setDouble(11, cn.getTroCap());
            n = stmt.executeUpdate();
            connection.close();
            return n > 0;
        } catch (SQLException ex) {
            //logger.getLogger(CongNhanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean xoaCongNhan(String maCN) {
        int n;
        String sql = "DELETE FROM [dbo].[CONGNHAN]\n"
                + "WHERE MaCongNhan =?";
        
        try {
             Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, maCN);
            n = stmt.executeUpdate();
            connection.close();
            return n > 0;
        } catch (Exception ex) {
            //Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean suaCongNhan(CongNhan1 cn) throws SQLException, Exception {
        int n;
        String sql = "UPDATE [dbo].[CONGNHAN]\n"
                + "   SET [TenCongNhan] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[SoDienThoai] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[CMND] = ?\n"
                + "       ,[NgayBatDau] = ?\n"
                + "       ,[TayNghe] = ?\n"
                + "       ,[TroCap] = ?\n"
                + " WHERE MaCongNhan = ?";
       
        try {
              Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cn.getTenCongNhan());
            stmt.setDate(2, new java.sql.Date(cn.getNgaySinh().getTime()));
            stmt.setInt(3, cn.isGioiTinh() ? 1 : 0);
            stmt.setString(4, cn.getDiaChi());
            stmt.setString(5, cn.getSoDienThoai());
            stmt.setString(6, cn.getEmail());
            stmt.setString(7, cn.getCmnd());
            stmt.setDate(8, new java.sql.Date(cn.getNgayBatDau().getTime()));
            stmt.setString(9, cn.getTayNghe());
            stmt.setDouble(10, cn.getTroCap());
            stmt.setString(11, cn.getMaCongNhan());
            n = stmt.executeUpdate();
           
            return n > 0;
        } catch (Exception ex) {
            Logger.getLogger(CongNhan1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public CongNhan1 getCNByID(String id) throws Exception {
        String sql = "select * from CONGNHAN where MaCongNhan =  '" + id + "'";
        try (
                  Connection connection = ConnectDB1.opConnection();
                 PreparedStatement stm = connection.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    CongNhan1 cn = new CongNhan1();
                    cn.setMaCongNhan(rs.getString("MaCongNhan"));
                    cn.setTenCongNhan(rs.getString("TenCongNhan"));
                    cn.setNgaySinh(rs.getDate("NgaySinh"));
                    if (rs.getInt("GioiTinh") == 1) {
                        cn.setGioiTinh(true);
                    } else {
                        cn.setGioiTinh(false);
                    }
                    cn.setDiaChi(rs.getString("DiaChi"));
                    cn.setSoDienThoai(rs.getString("SoDienThoai"));
                    cn.setEmail(rs.getString("Email"));
                    cn.setCmnd(rs.getString("CMND"));
                    cn.setNgayBatDau(rs.getDate("NgayBatDau"));
                    cn.setTroCap(rs.getDouble("TroCap"));
                    cn.setTayNghe(rs.getString("TayNghe"));
                    
                    return cn;
                }

            }
            return null;
        }
        
    }
    
    public CongNhan1 timCNTheoMa(String id) throws Exception{
          String sql = "select MaCongNhan from CONGNHAN where MaCongNhan =  '" + id + "'";
        try (
                  Connection connection = ConnectDB1.opConnection();
                 PreparedStatement stm = connection.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    CongNhan1 cn = new CongNhan1();
                    cn.setMaCongNhan(rs.getString("MaCongNhan"));
                 
                    return cn;
                }

            }
            return null;
    }
    }
    
        public List<CongNhan1> dsCongNhanDaChamCong() throws Exception{
        String sql = "select cn.* from CHAMCONGCONGNHAN cc join BANGPHANCONG pc \n" +
                        "on pc.MaPhanCong = cc.MaPhanCong join CONGNHAN cn \n" +
                        "on cn.MaCongNhan = pc.MaCongNhan";
        List<CongNhan1> list = new ArrayList<CongNhan1>();
        Connection connection = ConnectDB1.opConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                boolean gt;
                if (rs.getInt("GioiTinh") == 1) {
                    gt = true;
                } else {
                    gt = false;
                }
                CongNhan1 cn = new CongNhan1();
                cn = new CongNhan1(rs.getString("MaCongNhan"), rs.getString("TenCongNhan"), rs.getDate("NgaySinh"), gt, rs.getString("DiaChi"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("CMND"),
                        rs.getDate("NgayBatDau"), rs.getDouble("TroCap"), rs.getString("TayNghe"));

                list.add(cn);
            }
            connection.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            connection.rollback();
        }
        return list;
        
    }
}
