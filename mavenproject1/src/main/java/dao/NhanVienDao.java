/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huylauri
 */
public class NhanVienDao {
    PhongBanDao phongBanDao = new PhongBanDao();

    private NhanVien taoNhanVien(ResultSet rs) throws Exception {
        NhanVien nv = new NhanVien();
        PhongBan pb = phongBanDao.layPBTheoMa(rs.getString("MaPhongBan"));
        nv.setMaNhanVien(rs.getString("MaNhanVien"));
        nv.setTenNhanVien(rs.getString("TenNhanVien"));
        nv.setNgaySinh(rs.getDate("NgaySinh"));
        if(rs.getInt("GioiTinh") == 1){
            nv.setGioiTinh(true);
        }else{
            nv.setGioiTinh(false);
        }
        nv.setDiaChi(rs.getString("DiaChi"));
        nv.setSoDienThoai(rs.getString("SoDienThoai"));
        nv.setEmail(rs.getString("Email"));
        nv.setCmnd(rs.getString("CMND"));
        nv.setNgayBatDau(rs.getDate("NgayBatDau"));
        nv.setChucVu(rs.getString("ChucVu"));
        nv.setHeSoLuong(rs.getDouble("HeSoLuong"));
        nv.setLuongCoBan(rs.getDouble("LuongCoBan"));
        nv.setPhuCap(rs.getDouble("PhuCap"));
        nv.setPhongBan(pb);

        return nv;
    }

    //Lấy toàn bộ danh sách nhân viên
    public List<NhanVien> layDSNhanVien() throws Exception {
        String sql = "select * from NHANVIEN";
        Connection con = ConnectDB.getInstance().getConnection();
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = taoNhanVien(rs);
                list.add(nv);
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return list;
    }

    //Thêm một nhân viên mới
    public boolean themNhanVien(NhanVien nv) throws Exception {
        String sql = "INSERT INTO [dbo].[NHANVIEN]\n"
                + "           ([MaNhanVien],[MaPhongBan],[TenNhanVien],[NgaySinh],[GioiTinh],[DiaChi],[SoDienThoai],[Email],[CMND],[NgayBatDau],[ChucVu],[HeSoLuong],[LuongCoBan],[PhuCap])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?)\n";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
//            java.util.Date utilDateNgaySinh = nv.getNgaySinh();
//            System.out.println(utilDateNgaySinh);
//            java.sql.Date sqlDateNgaySinh = new java.sql.Date(utilDateNgaySinh.getTime());
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getMaNhanVien());
            stmt.setString(2, nv.getPhongBan().getMaPhongBan());
            stmt.setString(3, nv.getTenNhanVien());
            stmt.setDate(4, nv.getNgaySinh());
            stmt.setInt(5, nv.isGioiTinh()?1:0);
            stmt.setString(6, nv.getDiaChi());
            stmt.setString(7, nv.getSoDienThoai());
            stmt.setString(8, nv.getEmail());
            stmt.setString(9, nv.getCmnd());
            stmt.setDate(10, (Date) nv.getNgayBatDau());
            stmt.setString(11, nv.getChucVu());
            stmt.setDouble(12, nv.getHeSoLuong());
            stmt.setDouble(13, nv.getLuongCoBan());
            stmt.setDouble(14, nv.getPhuCap());

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

    //Lấy Nhân viên theo mã nhân viên
    public NhanVien layNVTheoMa(String maNhanVien) throws Exception {
        String sql = "select * from NhanVien where  MaNhanVien =?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = taoNhanVien(rs);
                return nv;
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return null;
    }
    
    //Lấy danh sách nhân viên theo tên phòng ban
    public List<NhanVien> layDSNhanVien(String tenPhongBan) throws Exception {
        String sql = "SELECT   NHANVIEN.*\n"
                + "FROM     NHANVIEN INNER JOIN\n"
                + "         PHONGBAN ON NHANVIEN.MaPhongBan = PHONGBAN.MaPhongBan \n"
                + "WHERE PHONGBAN.TenPhongBan LIKE ?";
        Connection con = ConnectDB.getInstance().getConnection();
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenPhongBan);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = taoNhanVien(rs);
                list.add(nv);
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return list;
    }

//    Xoá một Nhân viên theo mã nhân viên, có kiểm tra Nhân viên có tồn tại trong CSDL hay không
    public boolean xoaNhanVien(String maNhanVien) throws Exception {
        String sql = "SELECT * FROM NHANVIEN WHERE MaNhanVien = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sql = "DELETE FROM NHANVIEN WHERE MaNhanVien = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, maNhanVien);
                stmt.executeUpdate();
                con.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }

    //Lấy Lương cơ bản của Nhân viên theo mã nhân viên
    public double layLuongCobanTheoMa(String maNhanVien) throws Exception {
        String sql = "SELECT   LuongCoBan\n"
                + "FROM         NHANVIEN\n"
                + "WHERE MaNhanVien = ?";
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNhanVien);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("LuongCoBan");
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return 0;
    }
    
    //Lấy danh sách nhân viên theo điều kiện truyền vào
    public List<NhanVien> layDSNhanVienTheoDKWhere(String dieuKienWhere) throws Exception {
        String sql = "select * from NHANVIEN \n"
                + dieuKienWhere ;
        System.out.println("Nhân viên dao: " + dieuKienWhere);
        Connection con = ConnectDB.getInstance().getConnection();
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = taoNhanVien(rs);
                list.add(nv);
            }
            con.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            con.rollback();
        }
        return list;
    }
}
