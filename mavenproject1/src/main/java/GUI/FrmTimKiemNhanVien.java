/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.NhanVien;
import helper.RightRenderer;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author huylauri
 */
public class FrmTimKiemNhanVien extends javax.swing.JPanel {

    private PhongBanDao phongBanDao = new PhongBanDao();
    private NhanVienDao nhanVienDao = new NhanVienDao();
    private String dieuKienWhere = "WHERE";
    private DefaultTableModel model;

    /**
     * Creates new form FrmTimKiemNhanVien
     */
    public FrmTimKiemNhanVien() {
        initComponents();
        loadDataCmbPhongBanLoc();
        initTable();
        System.out.println(dieuKienWhere);

        txtMaNhanVien.setEnabled(false);
        txtTenNhanVien.setEnabled(false);
        txtCCCD.setEnabled(false);
        txtSoDienThoai.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtChucVu.setEnabled(false);
        cmbGioiTinh.setEnabled(false);
        cmbPhongBan.setEnabled(false);

    }

    private void loadDataCmbPhongBanLoc() {
        try {
            List<String> data = phongBanDao.layDsTenPhongBan();
            DefaultComboBoxModel<String> newModel = new DefaultComboBoxModel<>(data.toArray((new String[data.size()])));
            cmbPhongBan.setModel(newModel);
        } catch (Exception ex) {
            Logger.getLogger(FrmTimKiemNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    Cập nhật điều kiện tìm kiếm
    private String capNhatDieuKienWhere() {
        String maNhanVien = txtMaNhanVien.getText();
        String tenNhanVien = txtTenNhanVien.getText(); //TenNhanVien like N'%HUY%'
        String soCCCD = txtCCCD.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText(); //DiaChi like N'%Bình Định%'
        int gioiTinh = 1;
        if (cmbGioiTinh.getSelectedItem().equals("Nữ")) {
            gioiTinh = 0;
        }
        String tenPhongBan = cmbPhongBan.getSelectedItem().toString();
        String maPhongBan = "";
        try {
            maPhongBan = phongBanDao.layPBTheoTen(tenPhongBan).getMaPhongBan();
        } catch (Exception ex) {
            Logger.getLogger(FrmTimKiemNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        String chucVu = txtChucVu.getText();

        if (radMaNhanVien.isSelected() && !maNhanVien.isEmpty()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " MaNhanVien = '" + maNhanVien + "' ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " MaNhanVien = '" + maNhanVien + "' ";
            }
        }

        if (radTenNhanVien.isSelected() && !tenNhanVien.isEmpty()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " TenNhanVien LIKE N'%" + tenNhanVien + "%' ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " TenNhanVien LIKE N'%" + tenNhanVien + "%' ";
            }
        }

        if (radCCCD.isSelected() && !soCCCD.isEmpty()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " CMND = '" + soCCCD + "' ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " CMND = '" + soCCCD + "' ";
            }
        }

        if (radSoDienThoai.isSelected() && !soDienThoai.isEmpty()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " SoDienThoai = '" + soDienThoai + "' ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " SoDienThoai = '" + soDienThoai + "' ";
            }
        }

        if (radDiaChi.isSelected() && !diaChi.isEmpty()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " DiaChi LIKE N'%" + diaChi + "%' ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " DiaChi LIKE N'%" + diaChi + "%' ";
            }
        }

        if (radGioiTinh.isSelected()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " GioiTinh = " + gioiTinh + " ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " GioiTinh = " + gioiTinh + " ";
            }
        }

        if (radPhongBan.isSelected() && !maPhongBan.isEmpty()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " MaPhongBan = '" + maPhongBan + "' ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " MaPhongBan = '" + maPhongBan + "' ";
            }
        }

        if (radChucVu.isSelected() && !chucVu.isEmpty()) {
            if (dieuKienWhere.equals("WHERE")) {
                dieuKienWhere += " ChucVu = '" + chucVu + "' ";
            } else {
                dieuKienWhere += " AND ";
                dieuKienWhere += " ChucVu = '" + chucVu + "' ";
            }
        }

        return dieuKienWhere;
    }

    private void loadDataTblDsNhanVienTK(String dieuKienWhere) {
        try {
            List<NhanVien> list = nhanVienDao.layDSNhanVienTheoDKWhere(dieuKienWhere);
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this, "Không tim thấy Nhân viên hợp lệ!");
            }
            model.setRowCount(0);
            for (NhanVien nv : list) {
                {
                    Double luongCoban = nv.getLuongCoBan();
                    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                    model.addRow(new Object[]{
                        nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getNgaySinh(), nv.getSoDienThoai(),
                        nv.getPhongBan().getTenPhongBan(), nv.getChucVu(), nv.getHeSoLuong(), decimalFormat.format(luongCoban), nv.getPhuCap()
                    });
                }
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại",
            "Phòng ban", "Chức vụ", "Hệ số lương", "Lương cơ bản", "Phụ cấp"});
        tblDSNhanVien.setModel(model);
        TableColumnModel columnModel = tblDSNhanVien.getColumnModel();
        columnModel.getColumn(7).setCellRenderer(new RightRenderer()); // Hệ số lương
        columnModel.getColumn(8).setCellRenderer(new RightRenderer()); // Lương cơ bản
        columnModel.getColumn(9).setCellRenderer(new RightRenderer()); // Phụ cấp
    }

    private void xoaRong() {
        txtMaNhanVien.setText("");
        radMaNhanVien.setSelected(false);
        txtTenNhanVien.setText("");
        radTenNhanVien.setSelected(false);
        txtCCCD.setText("");
        radCCCD.setSelected(false);
        txtSoDienThoai.setText("");
        radSoDienThoai.setSelected(false);
        txtDiaChi.setText("");
        radDiaChi.setSelected(false);
        cmbGioiTinh.setSelectedIndex(0);
        radGioiTinh.setSelected(false);
        cmbPhongBan.setSelectedIndex(0);
        radPhongBan.setSelected(false);
        txtChucVu.setText("");
        radChucVu.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTieuDe = new javax.swing.JLabel();
        pnlTimKiem = new javax.swing.JPanel();
        txtTenNhanVien = new javax.swing.JTextField();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        txtMaNhanVien = new javax.swing.JTextField();
        radMaNhanVien = new javax.swing.JRadioButton();
        radTenNhanVien = new javax.swing.JRadioButton();
        radSoDienThoai = new javax.swing.JRadioButton();
        txtSoDienThoai = new javax.swing.JTextField();
        radCCCD = new javax.swing.JRadioButton();
        txtCCCD = new javax.swing.JTextField();
        radPhongBan = new javax.swing.JRadioButton();
        radChucVu = new javax.swing.JRadioButton();
        txtChucVu = new javax.swing.JTextField();
        radDiaChi = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        radGioiTinh = new javax.swing.JRadioButton();
        cmbPhongBan = new javax.swing.JComboBox<>();
        pnlNutChucNang = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlKetQua = new javax.swing.JPanel();
        scrKetQua = new javax.swing.JScrollPane();
        tblDSNhanVien = new javax.swing.JTable();

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(51, 0, 255));
        lblTieuDe.setText("TÌM KIẾM NHÂN VIÊN HÀNH CHÍNH");

        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm Nhân viên theo các yếu tố", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pnlTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnlTimKiem.setMaximumSize(new java.awt.Dimension(100, 100));

        cmbGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        radMaNhanVien.setText("Mã Nhân viên:");
        radMaNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radMaNhanVienItemStateChanged(evt);
            }
        });

        radTenNhanVien.setText("Tên Nhân viên:");
        radTenNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radTenNhanVienItemStateChanged(evt);
            }
        });

        radSoDienThoai.setText("Số điện thoại:");
        radSoDienThoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radSoDienThoaiItemStateChanged(evt);
            }
        });

        radCCCD.setText("Số CMND/CCCD:");
        radCCCD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radCCCDItemStateChanged(evt);
            }
        });

        radPhongBan.setText("Phòng ban:");
        radPhongBan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radPhongBanItemStateChanged(evt);
            }
        });

        radChucVu.setText("Chức vụ:");
        radChucVu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radChucVuItemStateChanged(evt);
            }
        });

        radDiaChi.setText("Địa chỉ:");
        radDiaChi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radDiaChiItemStateChanged(evt);
            }
        });

        radGioiTinh.setText("Giới tính:");
        radGioiTinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radGioiTinhItemStateChanged(evt);
            }
        });
        radGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGioiTinhActionPerformed(evt);
            }
        });

        cmbPhongBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPhongBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addComponent(radGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnTimKiem.setBackground(new java.awt.Color(102, 102, 255));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-tìmkiemNV.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(125, 22));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(252, 33, 30));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-thoat.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnThoat.setPreferredSize(new java.awt.Dimension(125, 23));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(102, 255, 153));
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-LamMoi.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(125, 22));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNutChucNangLayout = new javax.swing.GroupLayout(pnlNutChucNang);
        pnlNutChucNang.setLayout(pnlNutChucNangLayout);
        pnlNutChucNangLayout.setHorizontalGroup(
            pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutChucNangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNutChucNangLayout.setVerticalGroup(
            pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutChucNangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pnlKetQua.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết quả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblDSNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDSNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNhanVienMouseClicked(evt);
            }
        });
        scrKetQua.setViewportView(tblDSNhanVien);

        javax.swing.GroupLayout pnlKetQuaLayout = new javax.swing.GroupLayout(pnlKetQua);
        pnlKetQua.setLayout(pnlKetQuaLayout);
        pnlKetQuaLayout.setHorizontalGroup(
            pnlKetQuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrKetQua)
        );
        pnlKetQuaLayout.setVerticalGroup(
            pnlKetQuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrKetQua, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTieuDe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlNutChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlKetQua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTieuDe)
                .addGap(5, 5, 5)
                .addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlNutChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(pnlKetQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPhongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPhongBanActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String dkWhere = capNhatDieuKienWhere();
        System.out.println(dkWhere);

        loadDataTblDsNhanVienTK(dkWhere);
        dieuKienWhere = "WHERE";
        System.out.println(dieuKienWhere);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblDSNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNhanVienMouseClicked

    }//GEN-LAST:event_tblDSNhanVienMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        xoaRong();
        dieuKienWhere = "WHERE";
        model.setRowCount(0);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void radGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGioiTinhActionPerformed

    }//GEN-LAST:event_radGioiTinhActionPerformed

    private void radDiaChiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radDiaChiItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtDiaChi.setEnabled(true);
            txtDiaChi.requestFocus();
        } else {
            txtDiaChi.setText("");
            txtDiaChi.setEnabled(false);
        }
    }//GEN-LAST:event_radDiaChiItemStateChanged

    private void radGioiTinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radGioiTinhItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cmbGioiTinh.setEnabled(true);
            cmbGioiTinh.requestFocusInWindow();
        } else {
            cmbGioiTinh.setSelectedIndex(0);
            cmbGioiTinh.setEnabled(false);
        }
    }//GEN-LAST:event_radGioiTinhItemStateChanged

    private void radPhongBanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radPhongBanItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cmbPhongBan.setEnabled(true);
            cmbPhongBan.requestFocusInWindow();
        } else {
            cmbPhongBan.setSelectedIndex(0);
            cmbPhongBan.setEnabled(false);
        }
    }//GEN-LAST:event_radPhongBanItemStateChanged

    private void radMaNhanVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radMaNhanVienItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtMaNhanVien.setEnabled(true);
            txtMaNhanVien.requestFocus();
        } else {
            txtMaNhanVien.setText("");
            txtMaNhanVien.setEnabled(false);
        }
    }//GEN-LAST:event_radMaNhanVienItemStateChanged

    private void radTenNhanVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radTenNhanVienItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtTenNhanVien.setEnabled(true);
            txtTenNhanVien.requestFocus();
        } else {
            txtTenNhanVien.setText("");
            txtTenNhanVien.setEnabled(false);
        }
    }//GEN-LAST:event_radTenNhanVienItemStateChanged

    private void radCCCDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radCCCDItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtCCCD.setEnabled(true);
            txtCCCD.requestFocus();
        } else {
            txtCCCD.setText("");
            txtCCCD.setEnabled(false);
        }
    }//GEN-LAST:event_radCCCDItemStateChanged

    private void radSoDienThoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radSoDienThoaiItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtSoDienThoai.setEnabled(true);
            txtSoDienThoai.requestFocus();
        } else {
            txtSoDienThoai.setText("");
            txtSoDienThoai.setEnabled(false);
        }
    }//GEN-LAST:event_radSoDienThoaiItemStateChanged

    private void radChucVuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radChucVuItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtChucVu.setEnabled(true);
            txtChucVu.requestFocus();
        } else {
            txtChucVu.setText("");
            txtChucVu.setEnabled(false);
        }
    }//GEN-LAST:event_radChucVuItemStateChanged

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
        int index = tabbedPane.indexOfComponent(this);
        if (index != -1) {
            tabbedPane.removeTabAt(index);
        }
        if (tabbedPane.getTabCount() == 0) {
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(tabbedPane);
            mainFrame.getContentPane().removeAll();
            mainFrame.getContentPane().add(new TrangChu_GUI());
            mainFrame.getContentPane().revalidate();
        }
    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbPhongBan;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlKetQua;
    private javax.swing.JPanel pnlNutChucNang;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JRadioButton radCCCD;
    private javax.swing.JRadioButton radChucVu;
    private javax.swing.JRadioButton radDiaChi;
    private javax.swing.JRadioButton radGioiTinh;
    private javax.swing.JRadioButton radMaNhanVien;
    private javax.swing.JRadioButton radPhongBan;
    private javax.swing.JRadioButton radSoDienThoai;
    private javax.swing.JRadioButton radTenNhanVien;
    private javax.swing.JScrollPane scrKetQua;
    private javax.swing.JTable tblDSNhanVien;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
