/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB1;
import entity.PhanDoan1;
import entity.CongNhan1;
import entity.PhanCong1;
import entity.SanPham1;
import java.sql.Connection;
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
public class PhanCongCNDao1 {
    private CongNhanDao1 cn_dao = new CongNhanDao1();
    private CongNhan1 cn;
    private PhanDoanDao1 cd_dao = new PhanDoanDao1();
    private PhanDoan1 cd;
    private SanPhamDao1 sp_dao = new SanPhamDao1();
    private SanPham1 sp;

    
    
    public PhanCong1 taoPhanCong(ResultSet rs) throws SQLException, Exception{
        PhanCong1 phanCongCN = new PhanCong1();
        phanCongCN.setMaPC(rs.getString("MaPhanCong"));
        cd = cd_dao.getCDByID(rs.getString("MaPhanDoan"));
        phanCongCN.setCongDoan(cd);
        cn =cn_dao.getCNByID(rs.getString("MaCongNhan"));
        phanCongCN.setCongNhan(cn);
        phanCongCN.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
        phanCongCN.setNgayPhanCong(rs.getDate("NgayPhanCong"));
        phanCongCN.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
        phanCongCN.setTrangThai(rs.getString("TrangThai"));
        return phanCongCN; 
    }
    
    public List<PhanCong1> getDSPhanCong() throws Exception{
        String sql = "select * from BANGPHANCONG pc join CONGNHAN cn \n" +
"	on pc.MaCongNhan = cn.MaCongNhan join PHANDOAN pd\n" +
"	on pc.MaPhanDoan = pd.MaPhanDoan join SANPHAM sp\n" +
"	on pd.MaSanPham = sp.MaSanPham";
	List<PhanCong1> list = new ArrayList<PhanCong1>();
          Connection connection = ConnectDB1.opConnection();
	try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
		PhanCong1 pcCN = taoPhanCong(rs);
                    list.add(pcCN);
		}
			connection.commit();
		} catch (Exception e) {
// TODO: handle exception
            connection.rollback();
		}
		return list;
    }
    
     public Boolean themPhanCong(PhanCong1 pccn) throws Exception {
        int n;
        String sql = "INSERT INTO [dbo].[BANGPHANCONG]\n" +
"           ([MaPhanCong]\n" +
"           ,[MaPhanDoan]\n" +
"           ,[MaCongNhan]\n" +
"           ,[SoLuongCanLam]\n" +
"           ,[NgayPhanCong]\n" +
"           ,[NgayHoanThanh]\n" +
"           ,[TrangThai])\n" +
"            VALUES(?,?,?,?,?,?,?)";
        try {
              Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pccn.getMaPC());
            stmt.setString(2, pccn.getCongDoan().getMaPhanDoan());
            stmt.setString(3, pccn.getCongNhan().getMaCongNhan());
            stmt.setInt(4, pccn.getSoLuongCanLam());
            stmt.setDate(5, new java.sql.Date( pccn.getNgayPhanCong().getTime()));
            stmt.setDate(6, new java.sql.Date( pccn.getNgayHoanThanh().getTime()));
            stmt.setString(7, pccn.getTrangThai());
            n = stmt.executeUpdate();
        
            return n > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhanCong1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean xoaPhanCong(String ma) {
        int n;
        String sql = "DELETE FROM [dbo].[BANGPHANCONG]\n"
                + "WHERE MaPhanCong = ?";
      
        try {
            Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ma);
            n = stmt.executeUpdate();
            
            return n > 0;
        } catch (Exception ex) {
           
        }
        return false;
    }
    
     public Boolean suaPhanCong(PhanCong1 pccn) throws Exception {
        int n;
        String sql = "UPDATE [dbo].[BANGPHANCONG]\n" +
"      SET [MaPhanDoan] = ?\n" +
"      ,[MaCongNhan] = ?\n" +
"      ,[SoLuongCanLam] = ?\n" +
"      ,[NgayPhanCong] = ?\n" +
"      ,[NgayHoanThanh] = ?\n" +
"      ,[TrangThai] = ?\n" +
"       WHERE [MaPhanCong] = ?";
        try {
              Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pccn.getCongDoan().getMaPhanDoan());
            stmt.setString(2, pccn.getCongNhan().getMaCongNhan());
            stmt.setInt(3, pccn.getSoLuongCanLam());
            stmt.setDate(4, new java.sql.Date( pccn.getNgayPhanCong().getTime()));
            stmt.setDate(5, new java.sql.Date( pccn.getNgayHoanThanh().getTime()));
            stmt.setString(6, pccn.getTrangThai());
            stmt.setString(7, pccn.getMaPC());
            n = stmt.executeUpdate();
            
            return n > 0;
        } catch (SQLException ex) {
           
        }
        return false;
    }
     
     public PhanCong1 getPCCNByID(String id) throws Exception {
        PhanCongCNDao1 pccn_Dao = new PhanCongCNDao1();
        String sql = "select * from BANGPHANCONG where MaPhanCong =  '" + id + "'";
        try (
                  Connection connection = ConnectDB1.opConnection();
                PreparedStatement stm = connection.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    PhanCong1 phanCongCN = new PhanCong1();
                    phanCongCN.setMaPC(rs.getString("MaPhanCong"));
                    cd = cd_dao.getCDByID(rs.getString("MaPhanDoan"));
                    phanCongCN.setCongDoan(cd);
                    cn =cn_dao.getCNByID(rs.getString("MaCongNhan"));
                    phanCongCN.setCongNhan(cn);
                    phanCongCN.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
                    phanCongCN.setNgayPhanCong(rs.getDate("NgayPhanCong"));
                    phanCongCN.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
                    phanCongCN.setTrangThai(rs.getString("TrangThai"));
                   
                   return phanCongCN;
                }
            }
            return null;
        }
    } 
}
