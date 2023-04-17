/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB1;
import entity.PhanDoan1;
import entity.SanPham1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duy19
 */
public class PhanDoanDao1 {
       public List<PhanDoan1> layDSCongDoanTheoMaSP(String ma) throws SQLException, Exception {
        String sql = "select * from PHANDOAN Where MaSanPham =  '" + ma + "'";
       
        List<PhanDoan1> list = new ArrayList<PhanDoan1>();
        SanPhamDao1 sp_dao = new SanPhamDao1();
        SanPham1 sp = sp_dao.timSanPhamTheoMa(ma);
           try {
           Connection con = ConnectDB1.opConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               PhanDoan1 cd = new PhanDoan1(rs.getString("MaPhanDoan"), rs.getString("TenPhanDoan"),sp, rs.getDouble("GiaPhanDoan"), rs.getString("PhanDoanYeuCau"));
                list.add(cd); 
            }
           } catch (Exception e) {
           } finally {
           }
           
        

        return list;
    }
       
      public PhanDoan1 getCDByID(String id) throws Exception {
        SanPhamDao1 sp_dao = new SanPhamDao1();
        String sql = "select * from PHANDOAN where MaPhanDoan =  '" + id + "'";
        try (
                 Connection con = ConnectDB1.opConnection();
                PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                   PhanDoan1 cd = new PhanDoan1();
                   cd.setMaPhanDoan(rs.getString("MaPhanDoan"));
                   cd.setTenPhanDoan(rs.getString("TenPhanDoan"));
                   cd.setGiaPhanDoan(rs.getDouble("GiaPhanDoan"));
                   cd.setPhanDoanYeuCau(rs.getString("PhanDoanYeuCau"));
                   SanPham1 sp = sp_dao.timSanPhamTheoMa(rs.getString("MaSanPham"));
                   cd.setSanPham(sp);
                  
                   return cd;
                }
            }
            return null;
        }
    } 
      
      public PhanDoan1 timPhanDoanTheoMa(String id) throws Exception {
       
       
        String sql = "select MaPhanDoan from PHANDOAN where MaPhanDoan =  '" + id + "'";
        try (
                 Connection con = ConnectDB1.opConnection();
               PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                   PhanDoan1 cd = new PhanDoan1();
                   cd.setMaPhanDoan(rs.getString("MaPhanDoan"));
                   
                   return cd;
                }
            }
            return null;
        }
    } 
}
