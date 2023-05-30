/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.ThongKeCNDao;
import entity.ThongKeCN;
import helper.XuatFileExcel;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chanhne
 */
public class FrmThongKeCongNhan extends javax.swing.JPanel {

    public FrmThongKeCongNhan() {
        initComponents();

    }

    private void tinhTongTienLuong() {
        float tongTienLuong = 0.0f;
        for (int i = 0; i < tblDanhSachLuong.getRowCount(); i++) {
            tongTienLuong += Float.parseFloat(tblDanhSachLuong.getValueAt(i, 6).toString());
        }
        DecimalFormat df = new DecimalFormat("#,### VND");
        String tongTienLuongStr = df.format(tongTienLuong);
        txtTongTienLuongCuaThang.setText(tongTienLuongStr);
    }

    private void tinhTienLuongTrungBinh() {
        float tongTienLuong = 0.0f;
        int soHang = tblDanhSachLuong.getRowCount();
        for (int i = 0; i < soHang; i++) {
            tongTienLuong += Float.parseFloat(tblDanhSachLuong.getValueAt(i, 6).toString());
        }
        float tienLuongTrungBinh = tongTienLuong / soHang;
        DecimalFormat df = new DecimalFormat("#,### VND");
        String tienLuongTrungBinhStr = df.format(tienLuongTrungBinh);
        txtTienLuongTrungBinh.setText(tienLuongTrungBinhStr);
    }

    private void timLuongLonNhat() {
        float maxTienLuong = 0.0f;
        for (int i = 0; i < tblDanhSachLuong.getRowCount(); i++) {
            float tienLuong = Float.parseFloat(tblDanhSachLuong.getValueAt(i, 6).toString());
            if (tienLuong > maxTienLuong) {
                maxTienLuong = tienLuong;
            }
        }
        DecimalFormat df = new DecimalFormat("#,### VND");
        String maxTienLuongStr = df.format(maxTienLuong);
        txtMaxTienLuong.setText(maxTienLuongStr);
    }

    private void timLuongNhoNhat() {
        float luongNhoNhat = Float.parseFloat(tblDanhSachLuong.getValueAt(0, 6).toString());
        for (int i = 1; i < tblDanhSachLuong.getRowCount(); i++) {
            float luongHienTai = Float.parseFloat(tblDanhSachLuong.getValueAt(i, 6).toString());
            if (luongHienTai < luongNhoNhat) {
                luongNhoNhat = luongHienTai;
            }
        }
        DecimalFormat df = new DecimalFormat("#,### VND");
        String luongNhoNhatStr = df.format(luongNhoNhat);
        txtLuongNhoNhat.setText(luongNhoNhatStr);
    }

    private void tinhTongSoLuong() {
        int tongSoLuong = 0;
        for (int i = 0; i < tblDanhSachLuong.getRowCount(); i++) {
            tongSoLuong += Integer.parseInt(tblDanhSachLuong.getValueAt(i, 5).toString());
        }
        txtTongSoLuongLamDuoc.setText(String.valueOf(tongSoLuong));
    }

//    private void loadTableData() {
//        Object selectedThang = jComboBoxThang.getSelectedItem();
//        int thang = Integer.parseInt(selectedThang.toString());
////        int thang = Integer.parseInt(txtThang.getText());
//        int nam = Integer.parseInt(txtNam.getText());
//        TienLuongDao tienLuongDao = new TienLuongDao();
//        List<TienLuong> tienLuongList = tienLuongDao.findByThangNam(thang, nam);
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Mã công nhân");
//        model.addColumn("Tên công nhân");
//        model.addColumn("Địa chỉ");
//        model.addColumn("Tháng lương");
//        model.addColumn("Năm lương");
//        model.addColumn("Số lượng đã làm");
//        model.addColumn("Tổng lương");
//        for (TienLuong tienLuong : tienLuongList) {
//            model.addRow(new Object[]{
//                tienLuong.getMaCongNhan(),
//                tienLuong.getTenCongNhan(),
//                tienLuong.getDiaChi(),
//                tienLuong.getNamLuong(),
//                tienLuong.getThangLuong(),
//                tienLuong.getSoLuongDaLam(),
//                tienLuong.getTongLuong()
//            });
//        }
//        tblDanhSachLuong.setModel(model);
//    }
    private void loadTableData() {
        Object selectedThang = jComboBoxThang.getSelectedItem();
        String thangStr = selectedThang.toString();
        if (thangStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng!");
            return;
        }
        int thang = Integer.parseInt(thangStr);
        String namStr = txtNam.getValue() + "";
        if (namStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập năm!");
            return;
        }
        int nam = Integer.parseInt(namStr);
        ThongKeCNDao tienLuongDao = new ThongKeCNDao();
        List<ThongKeCN> tienLuongList = tienLuongDao.findByThangNam(thang, nam);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã công nhân");
        model.addColumn("Tên công nhân");
        model.addColumn("Địa chỉ");
        model.addColumn("Tháng lương");
        model.addColumn("Năm lương");
        model.addColumn("Số lượng đã làm");
        model.addColumn("Tổng lương");
        for (ThongKeCN tienLuong : tienLuongList) {
            model.addRow(new Object[]{
                tienLuong.getCongNhan().getMaCongNhan(),
                tienLuong.getCongNhan().getTenCongNhan(),
                tienLuong.getCongNhan().getDiaChi(),
                tienLuong.getNamLuong(),
                tienLuong.getThangLuong(),
                tienLuong.getSoLuongDaLam(),
                tienLuong.getTongLuong()
            });
        }
        tblDanhSachLuong.setModel(model);
    }

    private void checkTableData() {
        if (tblDanhSachLuong.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu, vui lòng chọn tháng/năm khác", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            xoaRong();
            xoaDuLieuTrongBang();
        }
    }

    private void xoaRong() {
        txtMaxTienLuong.setText("");
        txtLuongNhoNhat.setText("");
        txtTienLuongTrungBinh.setText("");
        txtTongTienLuongCuaThang.setText("");
        txtTongSoLuongLamDuoc.setText("");
    }

    private void xoaDuLieuTrongBang() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachLuong.getModel();
        model.setRowCount(0);
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
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDanhSachLuong = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblMaSanPham = new javax.swing.JLabel();
        lblMaSanPham1 = new javax.swing.JLabel();
        btnXem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jComboBoxThang = new javax.swing.JComboBox<>();
        txtNam = new com.toedter.calendar.JYearChooser();
        btnXuatDS = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblMaSanPham2 = new javax.swing.JLabel();
        txtMaxTienLuong = new javax.swing.JTextField();
        lblMaSanPham3 = new javax.swing.JLabel();
        lblMaSanPham4 = new javax.swing.JLabel();
        lblMaSanPham5 = new javax.swing.JLabel();
        txtTienLuongTrungBinh = new javax.swing.JTextField();
        txtLuongNhoNhat = new javax.swing.JTextField();
        txtTongTienLuongCuaThang = new javax.swing.JTextField();
        lblMaSanPham6 = new javax.swing.JLabel();
        txtTongSoLuongLamDuoc = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setPreferredSize(new java.awt.Dimension(1120, 824));

        lblTieuDe1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTieuDe1.setForeground(new java.awt.Color(51, 0, 255));
        lblTieuDe1.setText("THỐNG KÊ CÔNG NHÂN");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dữ liệu thống kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblDanhSachLuong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachLuongMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDanhSachLuong);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblMaSanPham.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSanPham.setText("Tháng:");

        lblMaSanPham1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSanPham1.setText("Năm:");

        btnXem.setBackground(new java.awt.Color(204, 255, 204));
        btnXem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXem.setText("Xem");
        btnXem.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnXem.setMaximumSize(new java.awt.Dimension(115, 37));
        btnXem.setMinimumSize(new java.awt.Dimension(115, 37));
        btnXem.setPreferredSize(new java.awt.Dimension(125, 37));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(51, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnLamMoi.setMaximumSize(new java.awt.Dimension(115, 37));
        btnLamMoi.setMinimumSize(new java.awt.Dimension(115, 37));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(125, 37));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jComboBoxThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        btnXuatDS.setBackground(new java.awt.Color(255, 102, 102));
        btnXuatDS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXuatDS.setText("Xuất danh sách");
        btnXuatDS.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnXuatDS.setMaximumSize(new java.awt.Dimension(115, 37));
        btnXuatDS.setMinimumSize(new java.awt.Dimension(115, 37));
        btnXuatDS.setPreferredSize(new java.awt.Dimension(125, 37));
        btnXuatDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSanPham1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxThang, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnXuatDS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxThang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaSanPham1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXuatDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMaSanPham2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSanPham2.setText("Tiền lương cao nhất của tháng:");

        txtMaxTienLuong.setBackground(new java.awt.Color(204, 204, 204));
        txtMaxTienLuong.setForeground(new java.awt.Color(255, 0, 0));

        lblMaSanPham3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSanPham3.setText("Tiền lương thấp nhất của tháng:");

        lblMaSanPham4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSanPham4.setText("Tiền lương trung bình của tháng:");

        lblMaSanPham5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSanPham5.setText("Tổng tiền lương của tháng:");

        txtTienLuongTrungBinh.setBackground(new java.awt.Color(204, 204, 204));
        txtTienLuongTrungBinh.setForeground(new java.awt.Color(255, 0, 0));

        txtLuongNhoNhat.setBackground(new java.awt.Color(204, 204, 204));
        txtLuongNhoNhat.setForeground(new java.awt.Color(255, 0, 0));

        txtTongTienLuongCuaThang.setBackground(new java.awt.Color(204, 204, 204));
        txtTongTienLuongCuaThang.setForeground(new java.awt.Color(255, 0, 0));

        lblMaSanPham6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSanPham6.setText("Tổng số lượng làm được:");

        txtTongSoLuongLamDuoc.setBackground(new java.awt.Color(204, 204, 204));
        txtTongSoLuongLamDuoc.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblMaSanPham6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTongSoLuongLamDuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaSanPham4)
                            .addComponent(lblMaSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaSanPham3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaSanPham5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongTienLuongCuaThang, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienLuongTrungBinh, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaxTienLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongNhoNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxTienLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuongNhoNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienLuongTrungBinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienLuongCuaThang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongSoLuongLamDuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(615, 615, 615)
                        .addComponent(lblTieuDe1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblTieuDe1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachLuongMouseClicked

    }//GEN-LAST:event_tblDanhSachLuongMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        xoaDuLieuTrongBang();
        xoaRong();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        loadTableData();
        checkTableData();
        tinhTongTienLuong();
        tinhTienLuongTrungBinh();
        timLuongLonNhat();
        timLuongNhoNhat();
        tinhTongSoLuong();

    }//GEN-LAST:event_btnXemActionPerformed

    private void btnXuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSActionPerformed
        // TODO add your handling code here:
        XuatFileExcel.xuatFileExcelCN(tblDanhSachLuong);
    }//GEN-LAST:event_btnXuatDSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXuatDS;
    private javax.swing.JComboBox<String> jComboBoxThang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblMaSanPham;
    private javax.swing.JLabel lblMaSanPham1;
    private javax.swing.JLabel lblMaSanPham2;
    private javax.swing.JLabel lblMaSanPham3;
    private javax.swing.JLabel lblMaSanPham4;
    private javax.swing.JLabel lblMaSanPham5;
    private javax.swing.JLabel lblMaSanPham6;
    private javax.swing.JLabel lblTieuDe1;
    private javax.swing.JTable tblDanhSachLuong;
    private javax.swing.JTextField txtLuongNhoNhat;
    private javax.swing.JTextField txtMaxTienLuong;
    private com.toedter.calendar.JYearChooser txtNam;
    private javax.swing.JTextField txtTienLuongTrungBinh;
    private javax.swing.JTextField txtTongSoLuongLamDuoc;
    private javax.swing.JTextField txtTongTienLuongCuaThang;
    // End of variables declaration//GEN-END:variables
}
