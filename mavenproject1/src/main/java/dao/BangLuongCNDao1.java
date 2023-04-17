/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import connectDB.ConnectDB1;

import entity.BangLuongCN1;
import entity.ChamCongCN1;
import entity.CongNhan1;
import entity.PhanCong1;
import entity.PhanDoan1;
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
public class BangLuongCNDao1 {
      
       public List<BangLuongCN1> getDSLuongCN() throws Exception {
        List<BangLuongCN1> list = new ArrayList<>();
        Connection con = ConnectDB1.opConnection();
        try {
            String sql = "select * from BANGLUONGCONGNHAN";
           
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               BangLuongCN1 bangLuongCN = new BangLuongCN1();
               bangLuongCN.setMaPhieuLuong(rs.getString("MaPhieuLuong"));
               bangLuongCN.setNamLuong(rs.getInt("NamLuong"));
               bangLuongCN.setThangLuong(rs.getInt("ThangLuong"));
               bangLuongCN.setNgaylap(rs.getDate("NgayLapPhieuLuong"));
               bangLuongCN.setTongLuong(rs.getDouble("TongLuong"));
               CongNhanDao1 cn_dao = new CongNhanDao1();
               CongNhan1 cn = cn_dao.getCNByID(rs.getString("MaCongNhan"));
               ChamCongCNDao1 chamCong_dao = new ChamCongCNDao1();
               ChamCongCN1 chamCongCN = chamCong_dao.timChamCongTheoMaCN(cn.getMaCongNhan());
               bangLuongCN.setChamCongCN(chamCongCN);
               list.add(bangLuongCN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
        public Boolean themLuongCN(BangLuongCN1 bangLuong) throws Exception {
        int n;
        String sql = "INSERT INTO [dbo].[BANGLUONGCONGNHAN]\n" +
"           ([MaPhieuLuong]\n" +
"           ,[MaCongNhan]\n" +
"           ,[NamLuong]\n" +
"           ,[ThangLuong]\n" +
"           ,[SoLuongDaLam]\n" +
"           ,[TongLuong])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
         Connection connection = ConnectDB1.opConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, bangLuong.getMaPhieuLuong());
            stmt.setString(2, bangLuong.getChamCongCN().getPhanCong().getCongNhan().getMaCongNhan());
            stmt.setInt(3, bangLuong.getNamLuong());
            stmt.setInt(4, bangLuong.getThangLuong());
            stmt.setInt(5, bangLuong.getChamCongCN().getSoLuongSanPham());
            stmt.setDouble(6, bangLuong.getTongLuong());
            n = stmt.executeUpdate();
            connection.close();
            return n > 0;
        } catch (SQLException ex) {
        //    logger.getLogger(BangLuongCNDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
