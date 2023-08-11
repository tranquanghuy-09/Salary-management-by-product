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
 * @author duy19
 */
public class PhanDoanDao {
       public List<PhanDoan> layDSCongDoanTheoMaSP(String ma) throws SQLException, Exception {
        String sql = "select * from PHANDOAN Where MaSanPham =  '" + ma + "'";
        Connection con = ConnectDB.getInstance().getConnection();
        List<PhanDoan> list = new ArrayList<PhanDoan>();
        SanPhamDao sp_dao = new SanPhamDao();
        SanPham sp = sp_dao.timSanPhamTheoMa(ma);
           try {
           //Connection con = ConnectDB1.opConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               PhanDoan cd = new PhanDoan(rs.getString("MaPhanDoan"), rs.getString("TenPhanDoan"),sp, rs.getDouble("GiaPhanDoan"), rs.getString("PhanDoanYeuCau"));
                list.add(cd); 
                con.commit();
            }
           } catch (Exception e) {
               e.printStackTrace();
               con.rollback();
           } finally {
               
           }
           
        

        return list;
    }
       
      public PhanDoan getCDByID(String id) throws Exception {
        SanPhamDao sp_dao = new SanPhamDao();
        String sql = "select * from PHANDOAN where MaPhanDoan =  '" + id + "'";
        Connection con = ConnectDB.getInstance().getConnection();
        try (
                //Connection con = ConnectDB1.opConnection();
                PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                   PhanDoan cd = new PhanDoan();
                   cd.setMaPhanDoan(rs.getString("MaPhanDoan"));
                   cd.setTenPhanDoan(rs.getString("TenPhanDoan"));
                   cd.setGiaPhanDoan(rs.getDouble("GiaPhanDoan"));
                   cd.setPhanDoanYeuCau(rs.getString("PhanDoanYeuCau"));
                   SanPham sp = sp_dao.timSanPhamTheoMa(rs.getString("MaSanPham"));
                   cd.setSanPham(sp);
                   con.commit();
                   return cd;
                }
            }
            return null;
        }
    } 
      
      public PhanDoan timPhanDoanTheoMa(String id) throws Exception {
       
       
        String sql = "select MaPhanDoan from PHANDOAN where MaPhanDoan =  '" + id + "'";
        Connection con = ConnectDB.getInstance().getConnection();
        try (
               //Connection con = ConnectDB1.opConnection();
               PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                   PhanDoan cd = new PhanDoan();
                   cd.setMaPhanDoan(rs.getString("MaPhanDoan"));
                   con.commit();
                   return cd;
                }
            }
            return null;
        }
    } 
      
       public List<String> getTenPhanDoanList() {
        List<String> tenPhanDoanList = new ArrayList<>();
        String sql = "SELECT TenPhanDoan FROM PHANDOAN";
        Connection connection = ConnectDB.getInstance().getConnection();
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
       
       public List<PhanDoan> getPhanDoanByMaSanPham(String maSanPham) {
        List<PhanDoan> phanDoanList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            String sql = "SELECT PHANDOAN.*, SANPHAM.TenSanPham FROM PHANDOAN JOIN SANPHAM ON PHANDOAN.MaSanPham = SANPHAM.MaSanPham WHERE PHANDOAN.MaSanPham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSanPham);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SanPham sanPham = new SanPham(
                        resultSet.getString("MaSanPham"),
                        resultSet.getString("TenSanPham"));
                PhanDoan phanDoan;
                phanDoan = new PhanDoan(
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
        Connection connection = ConnectDB.getInstance().getConnection();
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
       Connection connection = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maPhanDoan);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
