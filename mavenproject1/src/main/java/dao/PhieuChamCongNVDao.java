/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhieuChamCongNV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huylauri
 */
public class PhieuChamCongNVDao {

    private PhieuChamCongNV taoPhieuChamCongNV(ResultSet rs) throws Exception {
        NhanVienDao nhanVienDao = new NhanVienDao();
        PhieuChamCongNV chamCongNV = new PhieuChamCongNV();
        NhanVien nv = nhanVienDao.layNVTheoMa(rs.getString("MaNhanVien"));
        chamCongNV.setMaChamCong(rs.getString("MaChamCong"));
        chamCongNV.setNhanVien(nv);
        chamCongNV.setCaLam(rs.getString("CaLam"));
        chamCongNV.setHeSoLuong(rs.getFloat("HeSoLuongCa"));
        chamCongNV.setTrangThai(rs.getInt("TrangThai"));
        chamCongNV.setNghiPhep(rs.getInt("NghiPhep"));
        chamCongNV.setNgayChamCong(rs.getDate("NgayChamCong"));
        chamCongNV.setGhiChu(rs.getString("GhiChu"));
        return chamCongNV;
    }

    //Lấy toàn bộ danh sách chấm công nhân viên
    public List<PhieuChamCongNV> layDsPhieuChamCongNV() throws Exception {
        String sql = "select * from CHAMCONGNHANVIEN";
        Connection con = ConnectDB.getInstance().getConnection();
        List<PhieuChamCongNV> list = new ArrayList<PhieuChamCongNV>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PhieuChamCongNV chamCongNV = new PhieuChamCongNV();
                chamCongNV = taoPhieuChamCongNV(rs);
                list.add(chamCongNV);
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return list;
    }

    public boolean themPhieuChamCongNV(PhieuChamCongNV phieuChamCongNV) throws Exception {
        String query = "select Max([MaChamCong]) from [dbo].[CHAMCONGNHANVIEN]";
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt1 = con.prepareStatement(query);
        boolean hasResultSet = stmt1.execute();
        if (hasResultSet) {
            ResultSet rs = stmt1.getResultSet();
            System.out.println(rs);
            if (rs.next()) {
                String maxIdString = rs.getString(1);
                if(maxIdString == null){
                    maxIdString = "CCNV-000000";
                }
                    
                int maxId = Integer.parseInt(maxIdString.substring(5));
                String maPhieuChamCong = String.format("CCNV-%06d", maxId + 1);
                
//                java.util.Date utilNgayChamCong = phieuChamCongNV.getNgayChamCong();
//                java.sql.Date sqlNgayChamCong = new java.sql.Date(utilNgayChamCong.getTime());


                String sql = "INSERT INTO [dbo].[CHAMCONGNHANVIEN]\n"
                        + "           ([MaChamCong],[MaNhanVien],[CaLam],[HeSoLuongCa],[TrangThai],[NghiPhep],[GhiChu],[NgayChamCong])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, maPhieuChamCong);
                    stmt.setString(2, phieuChamCongNV.getNhanVien().getMaNhanVien());
                    stmt.setString(3, phieuChamCongNV.getCaLam());
                    stmt.setFloat(4, (float) phieuChamCongNV.getHeSoLuong());
                    stmt.setInt(5, phieuChamCongNV.getTrangThai());
                    stmt.setInt(6, phieuChamCongNV.getNghiPhep());
                    stmt.setString(7, phieuChamCongNV.getGhiChu());
                    stmt.setDate(8, phieuChamCongNV.getNgayChamCong());

                    stmt.executeUpdate();
                    con.commit();
                    return true;

                } catch (Exception e) {
                    e.printStackTrace();
                    con.rollback();
                }
            }
        }
        return false;
    }

    public boolean xoaPhieuChamCong(String maPhieuChamCong) throws Exception {
        String sql = "DELETE FROM CHAMCONGNHANVIEN WHERE MaChamCong = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maPhieuChamCong);
            
            stmt.executeUpdate();
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }

}
