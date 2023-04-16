/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.CongNhanDao1;
import entity.CongNhan1;
import java.awt.Dimension;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duy19
 */
public class FrmQuanLyCongNhan extends javax.swing.JPanel {

    /**
     * Creates new form FrmQuanLyCongNhan
     */
    private CongNhanDao1 dao = new CongNhanDao1();
    private DefaultTableModel model;
    private CongNhan1 cn = new CongNhan1();
    // private TrangChu_GUI1 trangChu = new TrangChu_GUI1();
    private static int n;

    public FrmQuanLyCongNhan() throws SQLException {
        initComponents();
        initTable();
        loadDataToTable();
        btnXuatExcel.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTieuDe1 = new javax.swing.JLabel();
        pnlThongTinCN = new javax.swing.JPanel();
        lblMaNhanVien2 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        lblHoTen2 = new javax.swing.JLabel();
        lblGioiTinh2 = new javax.swing.JLabel();
        lblNgaySinh2 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        lblSoDienThoai2 = new javax.swing.JLabel();
        lblCmnd2 = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        lblNgayBatDau2 = new javax.swing.JLabel();
        txtEMAIL = new javax.swing.JTextField();
        lblDiaChi2 = new javax.swing.JLabel();
        txtDC = new javax.swing.JTextField();
        cmbGioiTinh2 = new javax.swing.JComboBox<>();
        lblChucVu2 = new javax.swing.JLabel();
        lblPhuCap2 = new javax.swing.JLabel();
        txtTroCap = new javax.swing.JTextField();
        txtTayNghe = new javax.swing.JTextField();
        txtMaCongNhan = new javax.swing.JTextField();
        pnlNutChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnThoiViec = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSCongNhan = new javax.swing.JTable();

        lblTieuDe1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTieuDe1.setForeground(new java.awt.Color(51, 0, 255));
        lblTieuDe1.setText("CÔNG NHÂN");

        pnlThongTinCN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Công Nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pnlThongTinCN.setMaximumSize(new java.awt.Dimension(100, 100));

        lblMaNhanVien2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaNhanVien2.setText("Mã công nhân:");

        txtHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHotenActionPerformed(evt);
            }
        });

        lblHoTen2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHoTen2.setText("Họ tên:");

        lblGioiTinh2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGioiTinh2.setText("Giới tính:");

        lblNgaySinh2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgaySinh2.setText("Ngày sinh:");

        lblSoDienThoai2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoDienThoai2.setText("Số điện thoại:");

        lblCmnd2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCmnd2.setText("CMND:");

        lblEmail2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEmail2.setText("Email:");

        lblNgayBatDau2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayBatDau2.setText("Ngày bắt đầu:");

        lblDiaChi2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDiaChi2.setText("Địa chỉ:");

        cmbGioiTinh2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbGioiTinh2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cmbGioiTinh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGioiTinh2ActionPerformed(evt);
            }
        });

        lblChucVu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChucVu2.setText("Tay nghề:");

        lblPhuCap2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhuCap2.setText("Trợ cấp:");

        txtTroCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTroCapActionPerformed(evt);
            }
        });

        txtTayNghe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTayNgheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinCNLayout = new javax.swing.GroupLayout(pnlThongTinCN);
        pnlThongTinCN.setLayout(pnlThongTinCNLayout);
        pnlThongTinCNLayout.setHorizontalGroup(
            pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinCNLayout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                        .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinCNLayout.createSequentialGroup()
                                    .addComponent(lblEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEMAIL))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinCNLayout.createSequentialGroup()
                                    .addComponent(lblCmnd2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCMND))
                                .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                                    .addComponent(lblGioiTinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbGioiTinh2, 0, 200, Short.MAX_VALUE))
                                .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                                    .addComponent(lblMaNhanVien2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMaCongNhan)))
                            .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                                .addComponent(lblPhuCap2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTroCap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNgayBatDau2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                                .addComponent(lblChucVu2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTayNghe))
                            .addComponent(lblNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                                .addComponent(lblSoDienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                                .addComponent(lblHoTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                        .addComponent(lblDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDC)))
                .addContainerGap(354, Short.MAX_VALUE))
        );
        pnlThongTinCNLayout.setVerticalGroup(
            pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinCNLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGioiTinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGioiTinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCmnd2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoDienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayBatDau2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChucVu2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTayNghe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhuCap2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTroCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThem.setBackground(new java.awt.Color(0, 204, 51));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnThem.setMaximumSize(new java.awt.Dimension(115, 37));
        btnThem.setMinimumSize(new java.awt.Dimension(115, 37));
        btnThem.setPreferredSize(new java.awt.Dimension(125, 37));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(51, 153, 255));
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-CapNhat.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnCapNhat.setMaximumSize(new java.awt.Dimension(115, 37));
        btnCapNhat.setMinimumSize(new java.awt.Dimension(115, 37));
        btnCapNhat.setPreferredSize(new java.awt.Dimension(125, 37));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnThoiViec.setBackground(new java.awt.Color(255, 102, 102));
        btnThoiViec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThoiViec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-ThoiViec.png"))); // NOI18N
        btnThoiViec.setText("Thôi việc");
        btnThoiViec.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnThoiViec.setPreferredSize(new java.awt.Dimension(125, 23));
        btnThoiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiViecActionPerformed(evt);
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

        btnXuatExcel.setBackground(new java.awt.Color(231, 242, 242));
        btnXuatExcel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-XuatExcel.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setMargin(new java.awt.Insets(2, 0, 3, 0));
        btnXuatExcel.setPreferredSize(new java.awt.Dimension(125, 22));
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(252, 33, 30));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-thoatPanel.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnThoat.setPreferredSize(new java.awt.Dimension(125, 23));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNutChucNangLayout = new javax.swing.GroupLayout(pnlNutChucNang);
        pnlNutChucNang.setLayout(pnlNutChucNangLayout);
        pnlNutChucNangLayout.setHorizontalGroup(
            pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutChucNangLayout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnThoiViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        pnlNutChucNangLayout.setVerticalGroup(
            pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThoiViec, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Công Nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblDSCongNhan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDSCongNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCongNhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSCongNhan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1)
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongTinCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNutChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTieuDe1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTieuDe1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThongTinCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNutChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlThongTinCN.getAccessibleContext().setAccessibleName("Thông tin Công Nhân");
        jPanel1.getAccessibleContext().setAccessibleName("Danh sách công nhân");
    }// </editor-fold>//GEN-END:initComponents

    private void txtHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHotenActionPerformed

    private void cmbGioiTinh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGioiTinh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGioiTinh2ActionPerformed

    private void txtTroCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTroCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTroCapActionPerformed

    private void txtTayNgheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTayNgheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTayNgheActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Boolean gt = null;

        if (cmbGioiTinh2.getSelectedItem().equals("Nam")) {
            gt = true;
        } else if (cmbGioiTinh2.getSelectedItem().equals("Nữ")) {
            gt = false;
        }
        try {

            CongNhan1 cn = new CongNhan1(txtMaCongNhan.getText(), txtHoten.getText(), txtNgaySinh.getDate(), gt, txtDC.getText(), txtSDT.getText(), txtEMAIL.getText(), txtCMND.getText(), txtNgayBatDau.getDate(), Double.valueOf(txtTroCap.getText()), txtTayNghe.getText());
            boolean n = dao.themCN(cn);
            System.out.println(cn);
            if (n) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi");
            }

        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyCongNhan.class.getName()).log(Level.SEVERE, null, ex);
        }

        // cleanValue();
        // txtHoTen.setText("");
        //btnTroLai.setEnabled(false);					Double.parseDouble(cboHeSL.getSelectedItem().toString())); 
        // cleanValue();
        // txtHoTen.setText("");
        //btnTroLai.setEnabled(false);					Double.parseDouble(cboHeSL.getSelectedItem().toString())); 
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblDSCongNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCongNhanMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblDSCongNhan.getSelectedRow();
            if (row >= 0) {
                String id = (String) tblDSCongNhan.getValueAt(row, 0);
                CongNhanDao1 dao = new CongNhanDao1();
                CongNhan1 cn = dao.getCNByID(id);
                if (cn != null) {
                    txtMaCongNhan.setText(cn.getMaCongNhan());
                    txtHoten.setText(cn.getTenCongNhan());
                    txtNgaySinh.setDate(cn.getNgaySinh());
                    txtNgayBatDau.setDate(cn.getNgayBatDau());
                    txtTroCap.setText(String.valueOf(cn.getTroCap()));
                    txtTayNghe.setText(cn.getTayNghe());
                    txtCMND.setText(cn.getCmnd());
                    txtEMAIL.setText(cn.getEmail());
                    txtDC.setText(cn.getDiaChi());
                    txtSDT.setText(cn.getSoDienThoai());
                    cmbGioiTinh2.setSelectedItem(cn.isGioiTinh() ? "Nam" : "Nữ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblDSCongNhanMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtMaCongNhan.setText("");
        txtHoten.setText("");
        txtNgaySinh.setDate(null);
        txtNgayBatDau.setDate(null);
        txtTroCap.setText("");
        txtTayNghe.setText("");
        txtCMND.setText("");
        txtEMAIL.setText("");
        txtDC.setText("");
        txtSDT.setText("");
        cmbGioiTinh2.setSelectedItem("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThoiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiViecActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa công nhân này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            dao.xoaCongNhan(txtMaCongNhan.getText());
            try {
                loadDataToTable();
            } catch (Exception ex) {

            }
        }

    }//GEN-LAST:event_btnThoiViecActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        Boolean gt = null;
        txtMaCongNhan.setEnabled(false);
        if (cmbGioiTinh2.getSelectedItem().equals("Nam")) {
            gt = true;
        } else if (cmbGioiTinh2.getSelectedItem().equals("Nữ")) {
            gt = false;
        }

        CongNhan1 cn = new CongNhan1(txtMaCongNhan.getText(), txtHoten.getText(), txtNgaySinh.getDate(), gt, txtDC.getText(), txtSDT.getText(), txtEMAIL.getText(), txtCMND.getText(), txtNgayBatDau.getDate(), Double.valueOf(txtTroCap.getText()), txtTayNghe.getText());

        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc muốn cập nhật không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try {
                dao.suaCongNhan(cn);
            } catch (Exception ex) {
                Logger.getLogger(FrmQuanLyCongNhan.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                loadDataToTable();
            } catch (Exception ex) {
                Logger.getLogger(FrmQuanLyCongNhan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        SwingUtilities.getWindowAncestor(this).dispose();
        this.setVisible(false);
        new TrangChu_GUI().setVisible(true);

    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThoiViec;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cmbGioiTinh2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChucVu2;
    private javax.swing.JLabel lblCmnd2;
    private javax.swing.JLabel lblDiaChi2;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblGioiTinh2;
    private javax.swing.JLabel lblHoTen2;
    private javax.swing.JLabel lblMaNhanVien2;
    private javax.swing.JLabel lblNgayBatDau2;
    private javax.swing.JLabel lblNgaySinh2;
    private javax.swing.JLabel lblPhuCap2;
    private javax.swing.JLabel lblSoDienThoai2;
    private javax.swing.JLabel lblTieuDe1;
    private javax.swing.JPanel pnlNutChucNang;
    private javax.swing.JPanel pnlThongTinCN;
    private javax.swing.JTable tblDSCongNhan;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMaCongNhan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTayNghe;
    private javax.swing.JTextField txtTroCap;
    // End of variables declaration//GEN-END:variables

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã công nhân", "Tên công nhân", "Giới tính", "Ngày sinh", "Số điện thoại",
            "Tay nghề", "Trợ cấp"});
        tblDSCongNhan.setModel(model);
    }

    public void loadDataToTable() {
        try {

            List<CongNhan1> list = dao.getDanhSachCN();
            model.setRowCount(0);
            for (CongNhan1 cn : list) {
                {
                    model.addRow(new Object[]{
                        cn.getMaCongNhan(), cn.getTenCongNhan(), cn.isGioiTinh() ? "Nam" : "Nữ",
                        cn.getNgaySinh(), cn.getSoDienThoai(), cn.getTayNghe(), cn.getTroCap()
                    });
                }
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

}
