/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author huylauri
 */
public class TaiKhoanDao {
    // Kiểm tra mã Nhân viên đã có tài khoản chưa
    public boolean kiemTraTaiKhoanTonTai(String maNhanVien) throws Exception {
        String sql = "SELECT COUNT(*) AS count FROM TAIKHOAN WHERE MaNhanVien = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }
    
    // Kiểm tra mã Nhân viên và mật khẩu đã đúng chưa
    public boolean kiemTraTaiKhoanDung(String maNhanVien, String matKhau) throws Exception {
        String sql = "SELECT COUNT(*) AS count FROM TAIKHOAN WHERE MaNhanVien = ? AND MatKhau = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }
    
    //Thêm một tài khoản mới
    public boolean themTaiKhoan(String maNhanVien, String matKhau) throws Exception {
        String sql = "INSERT INTO [dbo].[TAIKHOAN]\n"
                + "           ([MaNhanVien]\n"
                + "           ,[MatKhau])\n"
                + "     VALUES (?,?) ";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            stmt.setString(2, matKhau);
            stmt.executeUpdate();
            con.commit();
            return true;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }

    //Cập nhật mật khẩu mới cho tài khoảng
    public boolean capNhatMatKhau(String matKhauMoi, String maNhanVien) throws Exception {
        String sql = "UPDATE [dbo].[TAIKHOAN]\n"
                + "   SET [MatKhau] = ?\n"
                + " WHERE [MaNhanVien] = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, matKhauMoi);
            stmt.setString(2, maNhanVien);

            stmt.executeUpdate();
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }
    
    //Lấy Tài khoản theo mã nhân viên
    public TaiKhoan layTaiKhoanTheoMaNV(String maNhanVien) throws Exception {
        String sql = "select * from TaiKhoan where  MaNhanVien =?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setMaNhanVien(rs.getString("MaNhanVien"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                return taiKhoan;
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return null;
    }
}
