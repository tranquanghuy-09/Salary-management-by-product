/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.PhanDoan;
import entity.CongNhan;
import entity.PhanCong;
import entity.SanPham;
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
public class PhanCongCNDao {
    private CongNhanDao cn_dao = new CongNhanDao();
    private CongNhan cn;
    private PhanDoanDao cd_dao = new PhanDoanDao();
    private PhanDoan cd;
    private SanPhamDao sp_dao = new SanPhamDao();
    private SanPham sp;

    
    
    public PhanCong taoPhanCong(ResultSet rs) throws SQLException, Exception{
        PhanCong phanCongCN = new PhanCong();
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
    
    public List<PhanCong> getDSPhanCong() throws Exception{
        String sql = "select * from BANGPHANCONG pc join CONGNHAN cn \n" +
"	on pc.MaCongNhan = cn.MaCongNhan join PHANDOAN pd\n" +
"	on pc.MaPhanDoan = pd.MaPhanDoan join SANPHAM sp\n" +
"	on pd.MaSanPham = sp.MaSanPham";
	List<PhanCong> list = new ArrayList<PhanCong>();
        Connection connection = ConnectDB.getInstance().getConnection();
	try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
		PhanCong pcCN = taoPhanCong(rs);
                    list.add(pcCN);
		}
			connection.commit();
		} catch (Exception e) {
// TODO: handle exception
            connection.rollback();
		}
		return list;
    }
    
     public Boolean themPhanCong(PhanCong pccn) throws Exception {
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
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
             // Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pccn.getMaPC());
            stmt.setString(2, pccn.getCongDoan().getMaPhanDoan());
            stmt.setString(3, pccn.getCongNhan().getMaCongNhan());
            stmt.setInt(4, pccn.getSoLuongCanLam());
            stmt.setDate(5, new java.sql.Date( pccn.getNgayPhanCong().getTime()));
            stmt.setDate(6, new java.sql.Date( pccn.getNgayHoanThanh().getTime()));
            stmt.setString(7, pccn.getTrangThai());
            n = stmt.executeUpdate();
            connection.commit();
            return n > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhanCong.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
        }
        return false;
    }

    public Boolean xoaPhanCong(String ma) throws SQLException {
        int n;
        String sql = "DELETE FROM [dbo].[BANGPHANCONG]\n"
                + "WHERE MaPhanCong = ?";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
           // Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ma);
            n = stmt.executeUpdate();
            connection.commit();
            return n > 0;
        } catch (Exception ex) {
           connection.rollback();
        }
        return false;
    }
    
     public Boolean suaPhanCong(PhanCong pccn) throws Exception {
        int n;
        String sql = "UPDATE [dbo].[BANGPHANCONG]\n" +
"      SET [MaPhanDoan] = ?\n" +
"      ,[MaCongNhan] = ?\n" +
"      ,[SoLuongCanLam] = ?\n" +
"      ,[NgayPhanCong] = ?\n" +
"      ,[NgayHoanThanh] = ?\n" +
"      ,[TrangThai] = ?\n" +
"       WHERE [MaPhanCong] = ?";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
         //   Connection connection = ConnectDB1.opConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pccn.getCongDoan().getMaPhanDoan());
            stmt.setString(2, pccn.getCongNhan().getMaCongNhan());
            stmt.setInt(3, pccn.getSoLuongCanLam());
            stmt.setDate(4, new java.sql.Date( pccn.getNgayPhanCong().getTime()));
            stmt.setDate(5, new java.sql.Date( pccn.getNgayHoanThanh().getTime()));
            stmt.setString(6, pccn.getTrangThai());
            stmt.setString(7, pccn.getMaPC());
            n = stmt.executeUpdate();
            connection.commit();
            return n > 0;
        } catch (SQLException ex) {
           connection.rollback();
        }
        return false;
    }
     
     public PhanCong getPCCNByID(String id) throws Exception {
        PhanCongCNDao pccn_Dao = new PhanCongCNDao();
        String sql = "select * from BANGPHANCONG where MaPhanCong =  '" + id + "'";
        Connection connection = ConnectDB.getInstance().getConnection();
        try (
                 // Connection connection = ConnectDB1.opConnection();
                PreparedStatement stm = connection.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    PhanCong phanCongCN = new PhanCong();
                    phanCongCN.setMaPC(rs.getString("MaPhanCong"));
                    cd = cd_dao.getCDByID(rs.getString("MaPhanDoan"));
                    phanCongCN.setCongDoan(cd);
                    cn =cn_dao.getCNByID(rs.getString("MaCongNhan"));
                    phanCongCN.setCongNhan(cn);
                    phanCongCN.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
                    phanCongCN.setNgayPhanCong(rs.getDate("NgayPhanCong"));
                    phanCongCN.setSoLuongCanLam(rs.getInt("SoLuongCanLam"));
                    phanCongCN.setTrangThai(rs.getString("TrangThai"));
                   connection.commit();
                   return phanCongCN;
                }
            }
            return null;
        }
    } 
     
      public List<PhanCong> getAllPhanCong() {
        List<PhanCong> phanCongs = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM BANGPHANCONG"); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CongNhan congNhan = new CongNhan(resultSet.getString("MaCongNhan"));
                PhanDoan phanDoan = new PhanDoan(resultSet.getString("MaPhanDoan"));
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
