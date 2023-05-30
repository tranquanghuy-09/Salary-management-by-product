/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.CongNhan;
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
public class CongNhanDao {

    private CongNhan cn = new CongNhan();
    //private Connection connection;
 
    public List<CongNhan> getDanhSachCN() throws SQLException, Exception {
        String sql = "select * from CONGNHAN";
        List<CongNhan> list = new ArrayList<CongNhan>();
        Connection connection = ConnectDB.getInstance().getConnection();
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
                CongNhan cn = new CongNhan();
                cn = new CongNhan(rs.getString("MaCongNhan"), rs.getString("TenCongNhan"), rs.getDate("NgaySinh"), gt, rs.getString("DiaChi"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("CMND"),
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

    

    public Boolean themCN(CongNhan cn) throws Exception {
        int n;
        String sql = "INSERT INTO [dbo].[CONGNHAN]([MaCongNhan],[TenCongNhan],[NgaySinh],[GioiTinh],[DiaChi],[SoDienThoai],[Email],[CMND],[NgayBatDau],[TayNghe],[TroCap])VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = ConnectDB.getInstance().getConnection();
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
           connection.commit();
            return n > 0;
        } catch (SQLException ex) {
            //logger.getLogger(CongNhanDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
        }
        return false;
    }

    public Boolean xoaCongNhan(String maCN) throws SQLException {
        int n;
        String sql = "DELETE FROM [dbo].[CONGNHAN]\n"
                + "WHERE MaCongNhan =?";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            // Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, maCN);
            n = stmt.executeUpdate();
          //  connection.close();
          connection.commit();
            return n > 0;
        } catch (Exception ex) {
            //Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
        }
        return false;
    }

    public boolean suaCongNhan(CongNhan cn) throws SQLException, Exception {
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
       Connection connection = ConnectDB.getInstance().getConnection();
        try {
             // Connection connection = ConnectDB1.opConnection();
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
           connection.commit();
            return n > 0;
        } catch (Exception ex) {
            Logger.getLogger(CongNhan.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
        }
        return false;
    }

    public CongNhan getCNByID(String id) throws Exception {
        String sql = "select * from CONGNHAN where MaCongNhan =  '" + id + "'";
        Connection connection = ConnectDB.getInstance().getConnection();
        try (
               //   Connection connection = ConnectDB1.opConnection();
                 PreparedStatement stm = connection.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    CongNhan cn = new CongNhan();
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
                    connection.commit();
                    return cn;
                }

            }
            return null;
        }
        
    }
    
    public CongNhan timCNTheoMa(String id) throws Exception{
          String sql = "select MaCongNhan from CONGNHAN where MaCongNhan =  '" + id + "'";
          Connection connection = ConnectDB.getInstance().getConnection();
        try (
                //  Connection connection = ConnectDB1.opConnection();
                 PreparedStatement stm = connection.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    CongNhan cn = new CongNhan();
                    cn.setMaCongNhan(rs.getString("MaCongNhan"));
                 connection.commit();
                    return cn;
                }

            }
            return null;
    }
    }
    
        public List<CongNhan> dsCongNhanDaChamCong() throws Exception{
        String sql = "select cn.* from CHAMCONGCONGNHAN cc join BANGPHANCONG pc \n" +
                        "on pc.MaPhanCong = cc.MaPhanCong join CONGNHAN cn \n" +
                        "on cn.MaCongNhan = pc.MaCongNhan";
        List<CongNhan> list = new ArrayList<CongNhan>();
       // Connection connection = ConnectDB1.opConnection();
       Connection connection = ConnectDB.getInstance().getConnection();
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
                CongNhan cn = new CongNhan();
                cn = new CongNhan(rs.getString("MaCongNhan"), rs.getString("TenCongNhan"), rs.getDate("NgaySinh"), gt, rs.getString("DiaChi"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("CMND"),
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
        
        public List<CongNhan> timKiemCongNhan(String maCongNhan, String tenCongNhan, String diaChi, String soDienThoai, String email, String CMND) {
        List<CongNhan> congNhans = new ArrayList<>();
        String query = "SELECT * FROM CONGNHAN WHERE MaCongNhan LIKE ? AND TenCongNhan LIKE ? AND DiaChi LIKE ? AND SoDienThoai LIKE ? AND Email LIKE ? AND CMND LIKE ?";
        Connection connection = ConnectDB.getInstance().getConnection();
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
