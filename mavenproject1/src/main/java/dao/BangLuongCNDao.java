/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BangLuongCN;
import entity.ChamCongCN;
import entity.CongNhan;
import entity.PhanCong;
import entity.PhanDoan;
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
public class BangLuongCNDao {

    public List<BangLuongCN> getDSLuongCN() throws Exception {
        List<BangLuongCN> list = new ArrayList<>();
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            String sql = "select * from BANGLUONGCONGNHAN";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BangLuongCN bangLuongCN = new BangLuongCN();
                bangLuongCN.setMaPhieuLuong(rs.getString("MaPhieuLuong"));
                bangLuongCN.setNamLuong(rs.getInt("NamLuong"));
                bangLuongCN.setThangLuong(rs.getInt("ThangLuong"));
                bangLuongCN.setNgaylap(rs.getDate("NgayLapPhieuLuong"));
                bangLuongCN.setTongLuong(rs.getDouble("TongLuong"));
                CongNhanDao cn_dao = new CongNhanDao();
                CongNhan cn = cn_dao.getCNByID(rs.getString("MaCongNhan"));
                ChamCongCNDao chamCong_dao = new ChamCongCNDao();
                ChamCongCN chamCongCN = chamCong_dao.timChamCongTheoMaCN(cn.getMaCongNhan());
                bangLuongCN.setChamCongCN(chamCongCN);
                list.add(bangLuongCN);
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        }
        return list;
    }

    public Boolean themLuongCN(BangLuongCN bangLuong) throws Exception {
        int n;
        String sql = "INSERT INTO [dbo].[BANGLUONGCONGNHAN]\n"
                + "           ([MaPhieuLuong]\n"
                + "           ,[MaCongNhan]\n"
                + "           ,[NamLuong]\n"
                + "           ,[ThangLuong]\n"
                + "           ,[SoLuongDaLam]\n"
                + "           ,[TongLuong])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, bangLuong.getMaPhieuLuong());
            stmt.setString(2, bangLuong.getChamCongCN().getPhanCong().getCongNhan().getMaCongNhan());
            stmt.setInt(3, bangLuong.getNamLuong());
            stmt.setInt(4, bangLuong.getThangLuong());
            stmt.setInt(5, bangLuong.getChamCongCN().getSoLuongSanPham());
            stmt.setDouble(6, bangLuong.getTongLuong());
            n = stmt.executeUpdate();
            connection.commit();
            return n > 0;
        } catch (SQLException ex) {
            //    logger.getLogger(BangLuongCNDao.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
        }
        return false;
    }

    
   public BangLuongCN getBangLuongByID(String id) throws Exception {
        String sql = "SELECT CHAMCONGCONGNHAN.*, BANGLUONGCONGNHAN.*\n" +
"                   FROM  CHAMCONGCONGNHAN INNER JOIN\n" +
"                  BANGPHANCONG ON CHAMCONGCONGNHAN.MaPhanCong = BANGPHANCONG.MaPhanCong, BANGLUONGCONGNHAN where MaPhieuLuong = '"+id+"'";
        Connection con = ConnectDB.getInstance().getConnection();
        try (          
                PreparedStatement stm = con.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    BangLuongCN bangLuongCN = new BangLuongCN();
                    bangLuongCN.setMaPhieuLuong(rs.getString("MaPhieuLuong"));
                    bangLuongCN.setNamLuong(rs.getInt("NamLuong"));
                    bangLuongCN.setNgaylap(rs.getDate("NgayLapPhieuLuong"));
                    bangLuongCN.setThangLuong(rs.getInt("ThangLuong"));
                    bangLuongCN.setTongLuong(rs.getDouble("TongLuong"));
                    ChamCongCNDao chamCongCNDAO = new ChamCongCNDao();
                    ChamCongCN chamCongCN = chamCongCNDAO.getChamCongByIDAndMaPC(rs.getString("MaChamCong"), rs.getString("MaPhanCong"));
                    bangLuongCN.setChamCongCN(chamCongCN);
                    con.commit();
                    return bangLuongCN;
                }

            }
            return null;
        }
    }
}
