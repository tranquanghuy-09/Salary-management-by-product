/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.BangLuongNhanVien;
import entity.NhanVien;
import entity.PhieuChamCongNV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author huylauri
 */
public class BangLuongNVDao {

    private BangLuongNhanVien taoBangLuongNV(ResultSet rs) throws Exception {
        NhanVienDao nhanVienDao = new NhanVienDao();
        BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
        NhanVien nv = nhanVienDao.layNVTheoMa(rs.getString("MaNhanVien"));
        bangLuongNhanVien.setMaBangLuong(rs.getString("MaBangLuong"));
        bangLuongNhanVien.setNhanVien(nv);
        bangLuongNhanVien.setNamLuong(rs.getInt("NamLuong"));
        bangLuongNhanVien.setThangLuong(rs.getInt("ThangLuong"));
        bangLuongNhanVien.setSoNgayLam(rs.getInt("SoNgayLam"));
        bangLuongNhanVien.setTongLuong(rs.getDouble("TongLuong"));
        bangLuongNhanVien.setNgayLapPhieuLuong(rs.getDate("NgayLapPhieuLuong"));
        return bangLuongNhanVien;
    }

    //Lấy toàn bộ danh sách Bảng lương nhân viên
    public List<BangLuongNhanVien> layDsBangLuongNV() throws Exception {
        String sql = "select * from BANGLUONGNHANVIEN";
        Connection con = ConnectDB.getInstance().getConnection();
        List<BangLuongNhanVien> list = new ArrayList<BangLuongNhanVien>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
                bangLuongNhanVien = taoBangLuongNV(rs);
                list.add(bangLuongNhanVien);
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return list;
    }

//    Thêm một Bảng lương nhân viên
    public boolean themBangLuongNV(BangLuongNhanVien bangLuongNhanVien) throws Exception {
        String query = "select Max([MaBangLuong]) from [dbo].[BANGLUONGNHANVIEN]";
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt1 = con.prepareStatement(query);
        boolean hasResultSet = stmt1.execute();
        if (hasResultSet) {
            ResultSet rs = stmt1.getResultSet();
            System.out.println(rs);
            if (rs.next()) {
                String maxIdString = rs.getString(1);
                int maxId = Integer.parseInt(maxIdString.substring(5));
                String maBangLuong = String.format("BLNV-%06d", maxId + 1);

                String sql = "INSERT INTO [dbo].[BANGLUONGNHANVIEN]\n"
                        + "           ([MaBangLuong],[MaNhanVien],[NamLuong],[ThangLuong],[SoNgayLam],[TongLuong])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?,?)";
                try {
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, maBangLuong);
                    stmt.setString(2, bangLuongNhanVien.getNhanVien().getMaNhanVien());
                    stmt.setInt(3, bangLuongNhanVien.getNamLuong());
                    stmt.setInt(4, bangLuongNhanVien.getThangLuong());
                    stmt.setInt(5, bangLuongNhanVien.getSoNgayLam());
                    stmt.setFloat(6, (float) bangLuongNhanVien.getTongLuong());

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

    //Tính số ngày làm của nhân Viên theo Hệ số lương và theo Mã nhân viên
    public Map<Double, Double> laySoNgayLamTheoMaNV(String maNhanVien, int thang, int nam) throws Exception {
        String sql = "SELECT   HeSoLuongCa, count(CHAMCONGNHANVIEN.MaChamCong)/2.0 as SoNgayLam\n"
                + "FROM         NHANVIEN INNER JOIN\n"
                + "                         CHAMCONGNHANVIEN ON NHANVIEN.MaNhanVien = CHAMCONGNHANVIEN.MaNhanVien\n"
                + "WHERE NHANVIEN.MaNhanVien = ? and MONTH([NgayChamCong]) = ? and YEAR([NgayChamCong]) = ?\n"
                + "GROUP BY NHANVIEN.MaNhanVien, HeSoLuongCa";
        Connection con = ConnectDB.getInstance().getConnection();
        Map<Double, Double> data = new HashMap<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            stmt.setInt(2, thang);
            stmt.setInt(3, nam);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                data.put(rs.getDouble("HeSoLuongCa"), rs.getDouble("SoNgayLam"));
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return data;
    }
}