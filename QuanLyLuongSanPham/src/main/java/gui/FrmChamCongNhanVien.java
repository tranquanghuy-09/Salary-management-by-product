/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhanVienDao;
import dao.PhieuChamCongNVDao;
import dao.PhongBanDao;
import entity.NhanVien;
import entity.PhieuChamCongNV;
import helper.XuatFileExcel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huylauri
 */
public class FrmChamCongNhanVien extends javax.swing.JPanel {
    private PhongBanDao phongBanDao = new PhongBanDao();
    private NhanVienDao nhanVienDao = new NhanVienDao();
    private PhieuChamCongNVDao phieuChamCongNVDao = new PhieuChamCongNVDao();
    private DefaultTableModel modelDsNhanVien;
    private DefaultTableModel modelDsPhieuChamCongNV;
    /**
     * Creates new form FrmChamCongNhanVien
     */
    public FrmChamCongNhanVien() {
        initComponents();
        txtHoTen.setEditable(false);
        txtPhongBan.setEditable(false);
        txtMaNhanVien.setEditable(false);
        btnGroup.add(radCoMat);
        btnGroup.add(radCoPhep);
        loadDataCmbPhongBanLoc();
        initTable();
        loadDataTblDsNhanVien();
        
        LocalDate currentDate = LocalDate.now();
        Date ngayChamCong = Date.valueOf(currentDate);
//        dchNgayCham.setDate(ngayChamCong);
        loadDataTblDsChamCong(ngayChamCong);
    }
    
    private void loadDataCmbPhongBanLoc() {
        try {
            List<String> data = phongBanDao.layDsTenPhongBan();
            DefaultComboBoxModel<String> newModel = new DefaultComboBoxModel<>(data.toArray((new String[data.size()])));
            cmbPhongBanLoc.setModel(newModel);
        } catch (Exception ex) {
            Logger.getLogger(FrmChamCongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDataTblDsNhanVien() {
        try {
            List<NhanVien> list = nhanVienDao.layDSNhanVien();
            modelDsNhanVien.setRowCount(0);
            for (NhanVien nv : list) {
                {
                    modelDsNhanVien.addRow(new Object[]{
                        nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getPhongBan().getTenPhongBan(), nv.getChucVu()
                    });
                }
            }
            modelDsNhanVien.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    
    private void loadDataTblDsNhanVien(List<NhanVien> list, DefaultTableModel model) {
        try {
            model.setRowCount(0);
            for (NhanVien nv : list) {
                {
                    model.addRow(new Object[]{
                       nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getPhongBan().getTenPhongBan(), nv.getChucVu()
                    });
                }
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    
    private void loadDataTblDsChamCong(Date date) {
        try {
            List<PhieuChamCongNV> list = phieuChamCongNVDao.layDsPhieuChamCongNV(date);
            modelDsPhieuChamCongNV.setRowCount(0);
            for (PhieuChamCongNV chamCongNV : list) {
                {
                    modelDsPhieuChamCongNV.addRow(new Object[]{
                        chamCongNV.getMaChamCong(), chamCongNV.getNhanVien().getMaNhanVien(), chamCongNV.getNhanVien().getTenNhanVien(), chamCongNV.getNgayChamCong(),
                        chamCongNV.getCaLam(), chamCongNV.getTrangThai(), chamCongNV.getNghiPhep(), chamCongNV.getGhiChu()
                    });
                }
            }
            modelDsPhieuChamCongNV.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

    private void initTable() {
        modelDsNhanVien = new DefaultTableModel();
        modelDsPhieuChamCongNV = new DefaultTableModel();
        modelDsNhanVien.setColumnIdentifiers(new String[]{"Mã NV", "Tên NV", "Ngày sinh", "Phòng ban", "Chức vụ"});
        modelDsPhieuChamCongNV.setColumnIdentifiers(new String[]{"Mã Chấm công", "Mã Nhân viên", "Tên Nhân viên", "Ngày chấm", "Ca làm", "Trạng thái", "Nghỉ phép", "Ghi chú"});
        tblDsNhanVien.setModel(modelDsNhanVien);
        tblDsChamCong.setModel(modelDsPhieuChamCongNV);
    }

    private void xoaRong() {
        txtHoTen.setText("");
        Calendar calendar = Calendar.getInstance();
        dchNgayCham.setDate(calendar.getTime());
        txtHoTen.setText("");
        txtPhongBan.setText("");
        txtMaNhanVien.setText("");
        txtGhiChu.setText("");
        radCoMat.setSelected(false);
        radCoPhep.setSelected(false);
    }
    
    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        lblTieuDe = new javax.swing.JLabel();
        pnlThongTinChamCong = new javax.swing.JPanel();
        txtHoTen = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        lblNgayCham = new javax.swing.JLabel();
        cmbCaLam = new javax.swing.JComboBox<>();
        dchNgayCham = new com.toedter.calendar.JDateChooser();
        lblTenNhanVien = new javax.swing.JLabel();
        lblPhongBan = new javax.swing.JLabel();
        radCoMat = new javax.swing.JRadioButton();
        radCoPhep = new javax.swing.JRadioButton();
        lblChamCong = new javax.swing.JLabel();
        txtPhongBan = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        lblGhiChu = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        lblMaNhanVien = new javax.swing.JLabel();
        pnlDsNhanVien = new javax.swing.JPanel();
        scrDsNhanVien = new javax.swing.JScrollPane();
        tblDsNhanVien = new javax.swing.JTable();
        pnlNutChucNang = new javax.swing.JPanel();
        btnChamCong = new javax.swing.JButton();
        btnXoaChamCong = new javax.swing.JButton();
        btnBoChon = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        pnlDsChamCong = new javax.swing.JPanel();
        scrDsChamCong = new javax.swing.JScrollPane();
        tblDsChamCong = new javax.swing.JTable();
        pnlLocDsNhanVien = new javax.swing.JPanel();
        lblPhongBanLoc = new javax.swing.JLabel();
        cmbPhongBanLoc = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        btnBoLoc = new javax.swing.JButton();

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(51, 0, 255));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("CHẤM CÔNG NHÂN VIÊN HÀNH CHÍNH");

        pnlThongTinChamCong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chấm công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pnlThongTinChamCong.setMaximumSize(new java.awt.Dimension(100, 100));

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        lblHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHoTen.setText("Ca làm:");

        lblNgayCham.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayCham.setText("Ngày chấm:");

        cmbCaLam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca sáng", "Ca chiều" }));
        cmbCaLam.setName(""); // NOI18N
        cmbCaLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCaLamActionPerformed(evt);
            }
        });

        dchNgayCham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dchNgayChamPropertyChange(evt);
            }
        });

        lblTenNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenNhanVien.setText("Nhân viên:");

        lblPhongBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhongBan.setText("Phòng ban:");

        radCoMat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radCoMat.setText("Có mặt");
        radCoMat.setMargin(new java.awt.Insets(2, 6, 3, 2));

        radCoPhep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radCoPhep.setText("Có phép");
        radCoPhep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCoPhepActionPerformed(evt);
            }
        });

        lblChamCong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChamCong.setText("Chấm công:");

        txtPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhongBanActionPerformed(evt);
            }
        });

        txtGhiChu.setToolTipText("");
        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });

        lblGhiChu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGhiChu.setText("Ghi chú:");

        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });

        lblMaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaNhanVien.setText("Mã NV:");

        javax.swing.GroupLayout pnlThongTinChamCongLayout = new javax.swing.GroupLayout(pnlThongTinChamCong);
        pnlThongTinChamCong.setLayout(pnlThongTinChamCongLayout);
        pnlThongTinChamCongLayout.setHorizontalGroup(
            pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinChamCongLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(lblTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(lblPhongBan, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(lblGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlThongTinChamCongLayout.createSequentialGroup()
                        .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtPhongBan)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(25, 25, 25)
                        .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlThongTinChamCongLayout.createSequentialGroup()
                                .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlThongTinChamCongLayout.createSequentialGroup()
                                        .addComponent(radCoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radCoPhep, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbCaLam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlThongTinChamCongLayout.createSequentialGroup()
                                .addComponent(lblNgayCham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(dchNgayCham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(txtGhiChu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongTinChamCongLayout.setVerticalGroup(
            pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinChamCongLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNgayCham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dchNgayCham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlThongTinChamCongLayout.createSequentialGroup()
                        .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radCoMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radCoPhep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlThongTinChamCongLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(pnlThongTinChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDsNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        scrDsNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrDsNhanVienMouseClicked(evt);
            }
        });

        tblDsNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDsNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsNhanVienMouseClicked(evt);
            }
        });
        scrDsNhanVien.setViewportView(tblDsNhanVien);

        javax.swing.GroupLayout pnlDsNhanVienLayout = new javax.swing.GroupLayout(pnlDsNhanVien);
        pnlDsNhanVien.setLayout(pnlDsNhanVienLayout);
        pnlDsNhanVienLayout.setHorizontalGroup(
            pnlDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDsNhanVienLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(scrDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        pnlDsNhanVienLayout.setVerticalGroup(
            pnlDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDsNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        btnChamCong.setBackground(new java.awt.Color(0, 204, 51));
        btnChamCong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChamCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/them.png"))); // NOI18N
        btnChamCong.setText("Chấm công");
        btnChamCong.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnChamCong.setMaximumSize(new java.awt.Dimension(115, 37));
        btnChamCong.setMinimumSize(new java.awt.Dimension(115, 37));
        btnChamCong.setPreferredSize(new java.awt.Dimension(125, 37));
        btnChamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCongActionPerformed(evt);
            }
        });

        btnXoaChamCong.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaChamCong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaChamCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-xoachamcong.png"))); // NOI18N
        btnXoaChamCong.setText("Xoá chấm công");
        btnXoaChamCong.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnXoaChamCong.setPreferredSize(new java.awt.Dimension(125, 23));
        btnXoaChamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChamCongActionPerformed(evt);
            }
        });

        btnBoChon.setBackground(new java.awt.Color(0, 206, 245));
        btnBoChon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBoChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-bochon.png"))); // NOI18N
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnBoChon.setPreferredSize(new java.awt.Dimension(125, 22));
        btnBoChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoChonActionPerformed(evt);
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
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-thoat.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoaChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNutChucNangLayout.setVerticalGroup(
            pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutChucNangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pnlDsChamCong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Chấm công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblDsChamCong.setModel(new javax.swing.table.DefaultTableModel(
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
        scrDsChamCong.setViewportView(tblDsChamCong);

        javax.swing.GroupLayout pnlDsChamCongLayout = new javax.swing.GroupLayout(pnlDsChamCong);
        pnlDsChamCong.setLayout(pnlDsChamCongLayout);
        pnlDsChamCongLayout.setHorizontalGroup(
            pnlDsChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDsChamCong)
        );
        pnlDsChamCongLayout.setVerticalGroup(
            pnlDsChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDsChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        pnlLocDsNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pnlLocDsNhanVien.setMaximumSize(new java.awt.Dimension(100, 100));

        lblPhongBanLoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhongBanLoc.setText("Phòng ban:");

        cmbPhongBanLoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbPhongBanLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPhongBanLocActionPerformed(evt);
            }
        });

        btnLoc.setBackground(java.awt.SystemColor.controlHighlight);
        btnLoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-loc-nho.png"))); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.setMargin(new java.awt.Insets(0, 2, 0, 2));
        btnLoc.setMaximumSize(new java.awt.Dimension(115, 37));
        btnLoc.setMinimumSize(new java.awt.Dimension(115, 37));
        btnLoc.setPreferredSize(new java.awt.Dimension(125, 37));
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        btnBoLoc.setBackground(java.awt.SystemColor.controlHighlight);
        btnBoLoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBoLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-boloc-nho.png"))); // NOI18N
        btnBoLoc.setText("Bỏ lọc");
        btnBoLoc.setMargin(new java.awt.Insets(0, 2, 0, 2));
        btnBoLoc.setMaximumSize(new java.awt.Dimension(115, 37));
        btnBoLoc.setMinimumSize(new java.awt.Dimension(115, 37));
        btnBoLoc.setPreferredSize(new java.awt.Dimension(125, 37));
        btnBoLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLocDsNhanVienLayout = new javax.swing.GroupLayout(pnlLocDsNhanVien);
        pnlLocDsNhanVien.setLayout(pnlLocDsNhanVienLayout);
        pnlLocDsNhanVienLayout.setHorizontalGroup(
            pnlLocDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocDsNhanVienLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblPhongBanLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmbPhongBanLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        pnlLocDsNhanVienLayout.setVerticalGroup(
            pnlLocDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocDsNhanVienLayout.createSequentialGroup()
                .addGroup(pnlLocDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLocDsNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlLocDsNhanVienLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlLocDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhongBanLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPhongBanLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlNutChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlThongTinChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlLocDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addComponent(pnlDsNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlDsChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlLocDsNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlThongTinChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlDsNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(pnlNutChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDsChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void cmbCaLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCaLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCaLamActionPerformed

    private void radCoPhepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCoPhepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radCoPhepActionPerformed

    private void btnChamCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongActionPerformed
        int row = tblDsNhanVien.getSelectedRow();
        NhanVien nhanVien = new NhanVien();
        try {
            nhanVien = nhanVienDao.layNVTheoMa(txtMaNhanVien.getText());
        } catch (Exception ex) {
            Logger.getLogger(FrmChamCongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        String caLam = cmbCaLam.getSelectedItem().toString();
        float heSoLuong;
        if (caLam.equalsIgnoreCase("Ca sáng") || caLam.equalsIgnoreCase("Ca chiều")) {
            heSoLuong = (float) 1.0;
        } else {
            heSoLuong = (float) 1.15;
        }
        LocalDate currentDate = LocalDate.now();
//        LocalDate date = LocalDate.of(2023, 1, 11);
        Date ngayChamCong = Date.valueOf(currentDate);
//        Date ngayChamCong = Date.valueOf(date);
        int coMat = radCoMat.isSelected() ? 1 : 0;
        int coPhep = radCoPhep.isSelected() ? 1 : 0;
        if (radCoMat.isSelected() == false && radCoPhep.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Có mặt hoặc Có phép");
        } else {
            PhieuChamCongNV phieuChamCongNV = new PhieuChamCongNV(nhanVien, caLam, heSoLuong, coMat,
                    coPhep, ngayChamCong, txtGhiChu.getText());
            try {
                if (phieuChamCongNVDao.themPhieuChamCongNV(phieuChamCongNV)) {
                    System.out.println("Chấm công thành công");
                    System.out.println(phieuChamCongNV);
//                JOptionPane.showMessageDialog(this, "Chấm công thành công");
                    loadDataTblDsChamCong(ngayChamCong);
                    xoaRong();
                    tblDsNhanVien.clearSelection();
                    modelDsNhanVien.removeRow(row);
                } else {
                    System.out.println("Lỗi");
                }
            } catch (Exception ex) {
                Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_btnChamCongActionPerformed

    private void btnBoChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoChonActionPerformed
        xoaRong();
    }//GEN-LAST:event_btnBoChonActionPerformed

    private void cmbPhongBanLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPhongBanLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPhongBanLocActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        try {
            // TODO add your handling code here:
            List<NhanVien> list = nhanVienDao.layDSNhanVien(String.valueOf(cmbPhongBanLoc.getSelectedItem()));
            initTable();
            loadDataTblDsNhanVien(list, modelDsNhanVien);
        } catch (Exception ex) {
            Logger.getLogger(FrmChamCongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnBoLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoLocActionPerformed
        initTable();
        loadDataTblDsNhanVien();
    }//GEN-LAST:event_btnBoLocActionPerformed

    private void scrDsNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrDsNhanVienMouseClicked
        
    }//GEN-LAST:event_scrDsNhanVienMouseClicked

    private void txtPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhongBanActionPerformed

    private void tblDsNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsNhanVienMouseClicked
        int row = tblDsNhanVien.getSelectedRow();
        String maNVChon = modelDsNhanVien.getValueAt(row, 0).toString();
        try {
            NhanVien nv = nhanVienDao.layNVTheoMa(maNVChon);
            Calendar calendar = Calendar.getInstance();
            dchNgayCham.setDate(calendar.getTime());
            txtHoTen.setText(nv.getTenNhanVien());
            txtPhongBan.setText(nv.getPhongBan().getTenPhongBan());
            txtMaNhanVien.setText(String.valueOf(nv.getMaNhanVien()));
        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDsNhanVienMouseClicked

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void btnXoaChamCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChamCongActionPerformed
        int row = tblDsChamCong.getSelectedRow();
        String maChamCong = tblDsChamCong.getValueAt(row, 0).toString();
        System.out.println(maChamCong);
        try {
            if(phieuChamCongNVDao.xoaPhieuChamCong(maChamCong)){
                System.out.println("Xoá Phiếu chấm công có mã " + maChamCong + " thành công");
                JOptionPane.showMessageDialog(this, "Xoá thành công!");
                modelDsPhieuChamCongNV.removeRow(row);
            }
                
            else
                System.out.println("Xoá Phiếu chấm công không thành công!");
        } catch (Exception ex) {
            Logger.getLogger(FrmChamCongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaChamCongActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        XuatFileExcel.xuatFileExcel(tblDsChamCong);
    }//GEN-LAST:event_btnXuatExcelActionPerformed

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

    private void dchNgayChamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dchNgayChamPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            Date date = new Date(dchNgayCham.getDate().getTime());
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String formattedDate = formatter.format(date);
            System.out.println(date);
            loadDataTblDsChamCong(date);
        }


    }//GEN-LAST:event_dchNgayChamPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoChon;
    private javax.swing.JButton btnBoLoc;
    private javax.swing.JButton btnChamCong;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoaChamCong;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cmbCaLam;
    private javax.swing.JComboBox<String> cmbPhongBanLoc;
    private com.toedter.calendar.JDateChooser dchNgayCham;
    private javax.swing.JLabel lblChamCong;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblNgayCham;
    private javax.swing.JLabel lblPhongBan;
    private javax.swing.JLabel lblPhongBanLoc;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlDsChamCong;
    private javax.swing.JPanel pnlDsNhanVien;
    private javax.swing.JPanel pnlLocDsNhanVien;
    private javax.swing.JPanel pnlNutChucNang;
    private javax.swing.JPanel pnlThongTinChamCong;
    private javax.swing.JRadioButton radCoMat;
    private javax.swing.JRadioButton radCoPhep;
    private javax.swing.JScrollPane scrDsChamCong;
    private javax.swing.JScrollPane scrDsNhanVien;
    private javax.swing.JTable tblDsChamCong;
    private javax.swing.JTable tblDsNhanVien;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtPhongBan;
    // End of variables declaration//GEN-END:variables

    
}
