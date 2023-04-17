/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import connectDB.ConnectDB;
import dao.BangLuongNVDao;
import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.BangLuongNhanVien;
import entity.NhanVien;
import helper.DoubleTriple;
import helper.RightRenderer;
import helper.XuatFileExcel;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author huylauri
 */
public class FrmTinhLuongNhanVien extends javax.swing.JPanel {

    private NhanVienDao nhanVienDao = new NhanVienDao();
    private PhongBanDao phongBanDao = new PhongBanDao();
    private BangLuongNVDao bangLuongNVDao = new BangLuongNVDao();

    private DefaultTableModel modelDsNhanVien;
    private DefaultTableModel modelDsBangLuong;

    /**
     * Creates new form FrmTinhLuongNhanVien
     */
    public FrmTinhLuongNhanVien() {
        initComponents();
        txtMaNhanVien.setEditable(false);
        txtSoNgayLam.setEditable(false);
        txtTongLuong.setEditable(false);
        for (int i = 2; i <= 12; i++) {
            cmbThang.addItem(String.format("%02d", i));
        }
        cmbThang.setSelectedItem("01");
        for (int year = 2015; year <= 2024; year++) {
            cmbNam.addItem(String.valueOf(year));
        }
        cmbNam.setSelectedItem("2023");
        btnInBangLuong.setEnabled(false);
        loadDataCmbPhongBanLoc();
        initTable();
        loadDataTblDsNhanVien();
        int thangLuong = Integer.parseInt(cmbThang.getSelectedItem().toString());
        int namLuong = Integer.parseInt(cmbNam.getSelectedItem().toString());
        loadDataTblDsBangLuong(thangLuong, namLuong);
        
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

    private void loadDataTblDsBangLuong(int thangLuong, int namLuong) {
        try {
            List<BangLuongNhanVien> list = bangLuongNVDao.layDsBangLuongNVTheoThangNam(thangLuong, namLuong);
            modelDsBangLuong.setRowCount(0);
            for (BangLuongNhanVien blnv : list) {
                {
                    NhanVien nv = blnv.getNhanVien();
//                    DecimalFormat decimalFormat = new DecimalFormat("#");
                    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                    modelDsBangLuong.addRow(new Object[]{
                        blnv.getMaBangLuong(), blnv.getNhanVien().getMaNhanVien(), blnv.getNhanVien().getTenNhanVien(), blnv.getNhanVien().getPhongBan().getTenPhongBan(),
                        blnv.getNhanVien().getHeSoLuong(), blnv.getThangLuong(), blnv.getNamLuong(), blnv.getSoNgayLam(), decimalFormat.format(nv.getLuongCoBan()),
                        decimalFormat.format(blnv.getNhanVien().getPhuCap()), decimalFormat.format(blnv.getTongLuong())
                    });
                }
            }
            modelDsBangLuong.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

    private void initTable() {
        modelDsNhanVien = new DefaultTableModel();
        modelDsBangLuong = new DefaultTableModel();
        modelDsNhanVien.setColumnIdentifiers(new String[]{"Mã NV", "Tên NV", "Ngày sinh", "Phòng ban", "Chức vụ"});
        modelDsBangLuong.setColumnIdentifiers(new String[]{"Mã Bảng lương", "Mã Nhân viên", "Tên Nhân viên", "Phòng ban", "Hệ số lương",
            "Tháng lương", "Năm lương", "Số ngày làm", "Lương cơ bản", "Phụ cấp", "Tổng lương"});
        tblDsNhanVien.setModel(modelDsNhanVien);
        tblDsTinhLuong.setModel(modelDsBangLuong);

        TableColumnModel columnModel = tblDsTinhLuong.getColumnModel();
        columnModel.getColumn(4).setCellRenderer(new RightRenderer());
        columnModel.getColumn(5).setCellRenderer(new RightRenderer());
        columnModel.getColumn(6).setCellRenderer(new RightRenderer());
        columnModel.getColumn(7).setCellRenderer(new RightRenderer());
        columnModel.getColumn(8).setCellRenderer(new RightRenderer());
        columnModel.getColumn(9).setCellRenderer(new RightRenderer());
        columnModel.getColumn(10).setCellRenderer(new RightRenderer());
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

    private void xoaRong() {
        txtMaNhanVien.setText("");
        cmbNhanVien.setSelectedIndex(0);
        cmbThang.setSelectedItem("01");
        cmbThang.setSelectedItem("2023");
        txtSoNgayLam.setText("");
        txtTongLuong.setText("");
        tblDsNhanVien.clearSelection();
        tblDsTinhLuong.clearSelection();
    }

    private static int demNgayChuNhatThangNam(int nam, int thang) {
        LocalDate firstDayOfMonth = LocalDate.of(nam, thang, 1);
        int daysInMonth = firstDayOfMonth.getMonth().length(firstDayOfMonth.isLeapYear());
        int count = 0;
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = LocalDate.of(nam, thang, day);
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                count++;
            }
        }
        return count;
    }

//    Tính tổng tiền lương theo mã Nhân viên
    private double tinhTongLuongTheoMaNV(String maNhanVien, int thang, int nam, Map<Double, Double> map) {
        double tongLuong = 0.0;
        try {
            int soNgayCongChuan = 31 - demNgayChuNhatThangNam(nam, thang);
            NhanVien nv = nhanVienDao.layNVTheoMa(maNhanVien);
            Double luongCoBan = nv.getLuongCoBan();
            Double phuCap = nv.getPhuCap();
//            Map<Double, Double> laySoNgayLamTheoMaNV = bangLuongNVDao.laySoNgayLamTheoMaNV("NV_0001");
            for (Map.Entry<Double, Double> entry : map.entrySet()) {
                double heSoLuong = entry.getKey();
                double soNgayLam = entry.getValue();
                double luong = heSoLuong * (soNgayLam / soNgayCongChuan) * luongCoBan;
                tongLuong += luong;
            }
            tongLuong += phuCap;
        } catch (Exception ex) {
            Logger.getLogger(FrmTinhLuongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongLuong;
    }

//    Tính lương theo số ngày với ngày công chuẩn
    private double tinhLuongTheoHeSo(double heSo, double soNgay, double ngayCongChuan, double luongCoban) {
        double tong = 0.0;
        tong = heSo * (soNgay / ngayCongChuan) * luongCoban;
        return tong;
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
        pnlLocDsNhanVien = new javax.swing.JPanel();
        lblPhongBanLoc = new javax.swing.JLabel();
        cmbPhongBanLoc = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        btnBoLoc = new javax.swing.JButton();
        pnlDsNhanVien = new javax.swing.JPanel();
        scrDsNhanVien = new javax.swing.JScrollPane();
        tblDsNhanVien = new javax.swing.JTable();
        pnlThongTinTinhLuong = new javax.swing.JPanel();
        txtSoNgayLam = new javax.swing.JTextField();
        lblNam = new javax.swing.JLabel();
        lblThang = new javax.swing.JLabel();
        cmbNam = new javax.swing.JComboBox<>();
        lblSoNgayLam = new javax.swing.JLabel();
        lblTongLuong = new javax.swing.JLabel();
        txtTongLuong = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        lblMaNhanVien = new javax.swing.JLabel();
        cmbThang = new javax.swing.JComboBox<>();
        lblNhanVien = new javax.swing.JLabel();
        cmbNhanVien = new javax.swing.JComboBox<>();
        pnlNutChucNang = new javax.swing.JPanel();
        btnTinhLuong = new javax.swing.JButton();
        btnXoaTinhLuong = new javax.swing.JButton();
        btnBoChon = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnInBangLuong = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        pnlDsTinhLuong = new javax.swing.JPanel();
        scrDsTinhLuong = new javax.swing.JScrollPane();
        tblDsTinhLuong = new javax.swing.JTable();

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(51, 0, 255));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("TÍNH LƯƠNG NHÂN VIÊN HÀNH CHÍNH");
        lblTieuDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
                .addContainerGap(13, Short.MAX_VALUE))
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
            .addComponent(scrDsNhanVien)
        );
        pnlDsNhanVienLayout.setVerticalGroup(
            pnlDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDsNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pnlThongTinTinhLuong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin tính lương", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pnlThongTinTinhLuong.setMaximumSize(new java.awt.Dimension(100, 100));

        txtSoNgayLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNgayLamActionPerformed(evt);
            }
        });

        lblNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNam.setText("Năm:");

        lblThang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblThang.setText("Tháng:");

        cmbNam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015" }));
        cmbNam.setName(""); // NOI18N
        cmbNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNamItemStateChanged(evt);
            }
        });

        lblSoNgayLam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoNgayLam.setText("Số ngày làm:");

        lblTongLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTongLuong.setText("Tổng lương:");

        txtTongLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTongLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongLuongActionPerformed(evt);
            }
        });

        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });

        lblMaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaNhanVien.setText("Mã NV:");

        cmbThang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01" }));
        cmbThang.setName(""); // NOI18N
        cmbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbThangItemStateChanged(evt);
            }
        });

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNhanVien.setText("Nhân viên:");

        cmbNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cmbNhanVien.setName(""); // NOI18N
        cmbNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNhanVienItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinTinhLuongLayout = new javax.swing.GroupLayout(pnlThongTinTinhLuong);
        pnlThongTinTinhLuong.setLayout(pnlThongTinTinhLuongLayout);
        pnlThongTinTinhLuongLayout.setHorizontalGroup(
            pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinTinhLuongLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoNgayLam, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(lblTongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtTongLuong)
                    .addComponent(txtSoNgayLam, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbThang, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbNam, javax.swing.GroupLayout.Alignment.TRAILING, 0, 170, Short.MAX_VALUE)
                    .addComponent(cmbNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlThongTinTinhLuongLayout.setVerticalGroup(
            pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinTinhLuongLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinTinhLuongLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlThongTinTinhLuongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoNgayLam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayLam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinTinhLuongLayout.createSequentialGroup()
                        .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbThang, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(pnlThongTinTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btnTinhLuong.setBackground(new java.awt.Color(0, 204, 51));
        btnTinhLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTinhLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/them.png"))); // NOI18N
        btnTinhLuong.setText("Tính lương");
        btnTinhLuong.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btnTinhLuong.setMaximumSize(new java.awt.Dimension(115, 37));
        btnTinhLuong.setMinimumSize(new java.awt.Dimension(115, 37));
        btnTinhLuong.setPreferredSize(new java.awt.Dimension(125, 37));
        btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuongActionPerformed(evt);
            }
        });

        btnXoaTinhLuong.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaTinhLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaTinhLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-xoachamcong.png"))); // NOI18N
        btnXoaTinhLuong.setText("Xoá Tính lương");
        btnXoaTinhLuong.setMargin(new java.awt.Insets(2, 0, 3, 0));
        btnXoaTinhLuong.setPreferredSize(new java.awt.Dimension(125, 23));
        btnXoaTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTinhLuongActionPerformed(evt);
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

        btnInBangLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInBangLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-in.png"))); // NOI18N
        btnInBangLuong.setText("In Bảng lương");
        btnInBangLuong.setMargin(new java.awt.Insets(2, 0, 3, 0));
        btnInBangLuong.setPreferredSize(new java.awt.Dimension(125, 23));
        btnInBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBangLuongActionPerformed(evt);
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
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(btnTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXoaTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnInBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        pnlNutChucNangLayout.setVerticalGroup(
            pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutChucNangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pnlDsTinhLuong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách tính lương", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblDsTinhLuong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDsTinhLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsTinhLuongMouseClicked(evt);
            }
        });
        scrDsTinhLuong.setViewportView(tblDsTinhLuong);

        javax.swing.GroupLayout pnlDsTinhLuongLayout = new javax.swing.GroupLayout(pnlDsTinhLuong);
        pnlDsTinhLuong.setLayout(pnlDsTinhLuongLayout);
        pnlDsTinhLuongLayout.setHorizontalGroup(
            pnlDsTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDsTinhLuong)
        );
        pnlDsTinhLuongLayout.setVerticalGroup(
            pnlDsTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDsTinhLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlNutChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlThongTinTinhLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlLocDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addComponent(pnlDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlDsTinhLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlLocDsNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(pnlThongTinTinhLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNutChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDsTinhLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPhongBanLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPhongBanLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPhongBanLocActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        try {
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

        int thangLuong = Integer.parseInt(cmbThang.getSelectedItem().toString());
        int namLuong = Integer.parseInt(cmbNam.getSelectedItem().toString());
        loadDataTblDsBangLuong(thangLuong, namLuong);
    }//GEN-LAST:event_btnBoLocActionPerformed

    private void tblDsNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsNhanVienMouseClicked
        int row = tblDsNhanVien.getSelectedRow();
        String maNVChon = modelDsNhanVien.getValueAt(row, 0).toString();
        try {
            NhanVien nv = nhanVienDao.layNVTheoMa(maNVChon);
            txtMaNhanVien.setText(String.valueOf(nv.getMaNhanVien()));
            String tenNV = nv.getTenNhanVien();
            cmbNhanVien.removeAllItems();
            cmbNhanVien.addItem("Tất cả");
            cmbNhanVien.addItem(tenNV);
            cmbNhanVien.setSelectedItem(tenNV);

            int thangLuong = Integer.parseInt(cmbThang.getSelectedItem().toString());
            int namLuong = Integer.parseInt(cmbNam.getSelectedItem().toString());
            Map<Double, Double> map = bangLuongNVDao.laySoNgayLamTheoMaNV(maNVChon, thangLuong, namLuong);
            double soNgayLam = 0;
            for (double value : map.values()) {
                soNgayLam += value;
            }
            txtSoNgayLam.setText(String.valueOf(soNgayLam));

            Double tongLuong = tinhTongLuongTheoMaNV(maNVChon, thangLuong, namLuong, map);
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            String formattedTongLuong = decimalFormat.format(tongLuong);

            txtTongLuong.setText(String.valueOf(formattedTongLuong));

        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDsNhanVienMouseClicked

    private void scrDsNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrDsNhanVienMouseClicked

    }//GEN-LAST:event_scrDsNhanVienMouseClicked

    private void txtSoNgayLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNgayLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNgayLamActionPerformed

    private void txtTongLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongLuongActionPerformed

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuongActionPerformed
        try {
            int row = tblDsNhanVien.getSelectedRow();
            String maNVChon = modelDsNhanVien.getValueAt(row, 0).toString();
            NhanVien nv = nhanVienDao.layNVTheoMa(maNVChon);

            int thangLuong = Integer.parseInt(cmbThang.getSelectedItem().toString());
            int namLuong = Integer.parseInt(cmbNam.getSelectedItem().toString());
            if (bangLuongNVDao.layBangLuongTheoMaNVThangNamLuong(maNVChon, thangLuong, namLuong) == null) {
                BangLuongNhanVien blnv = new BangLuongNhanVien(nv, namLuong, thangLuong, Double.parseDouble(txtSoNgayLam.getText()),
                        Double.parseDouble(txtTongLuong.getText().replace(",", "")));
                bangLuongNVDao.themBangLuongNV(blnv);
                loadDataTblDsBangLuong(thangLuong, namLuong);
                int lastRow = tblDsTinhLuong.getRowCount() - 1;
                tblDsTinhLuong.setRowSelectionInterval(lastRow, lastRow);
            } else {
                JOptionPane.showMessageDialog(this, "Nhân viên này đã được tính lương!");
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmTinhLuongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTinhLuongActionPerformed

    private void btnBoChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoChonActionPerformed
        xoaRong();
        txtMaNhanVien.setEnabled(true);
        txtSoNgayLam.setEnabled(true);
        txtTongLuong.setEnabled(true);
    }//GEN-LAST:event_btnBoChonActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        XuatFileExcel.xuatFileExcel(tblDsTinhLuong);
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void tblDsTinhLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsTinhLuongMouseClicked
        int row = tblDsTinhLuong.getSelectedRow();
        String maNVChon = modelDsBangLuong.getValueAt(row, 1).toString();
        btnInBangLuong.setEnabled(true);
        System.out.println(maNVChon);
    }//GEN-LAST:event_tblDsTinhLuongMouseClicked

    private void btnInBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBangLuongActionPerformed
        try {
            int row = tblDsTinhLuong.getSelectedRow();
            String maBangLuong = modelDsBangLuong.getValueAt(row, 0).toString();
            String maNV = modelDsBangLuong.getValueAt(row, 1).toString();
            NhanVien nv = nhanVienDao.layNVTheoMa(maNV);
            double luongCoBan = nv.getLuongCoBan();
            double phuCap = nv.getPhuCap();

            int thangLuong = Integer.parseInt(modelDsBangLuong.getValueAt(row, 5).toString());
            System.out.println(thangLuong);

            int namLuong = Integer.parseInt(modelDsBangLuong.getValueAt(row, 6).toString());
            System.out.println(namLuong);
            System.out.println(maNV);
            System.out.println(luongCoBan);

            int ngayCongChuan = 31 - demNgayChuNhatThangNam(namLuong, thangLuong);
            System.out.println(ngayCongChuan);

            double ngayLamViecThucTe = 0.0;
            double ngayNghiPhep = 0.0;
            double ngayNgoaiGio = 0.0;
            double luongCBTinh = 0.0;
            double luongNghiPhep = 0.0;
            double luongNgoaiGio = 0.0;

            List<DoubleTriple> list = bangLuongNVDao.laySoNgayLamNgayNghiTheoMaNV(maNV, thangLuong, namLuong);
            list.forEach(d -> System.out.println(d));
            if (list.size() == 1) {
                DoubleTriple dt = list.get(0);
                ngayLamViecThucTe = dt.getSecond();
                ngayNghiPhep = dt.getThird();
                luongCBTinh = tinhLuongTheoHeSo(dt.getFirst(), dt.getSecond(), ngayCongChuan, luongCoBan);
                luongNghiPhep = tinhLuongTheoHeSo(dt.getFirst(), dt.getThird(), ngayCongChuan, luongCoBan);
            } else if (list.size() == 2) {
                DoubleTriple dt = list.get(0);
                ngayLamViecThucTe = dt.getSecond();
                ngayNghiPhep = dt.getThird();
                luongCBTinh = tinhLuongTheoHeSo(dt.getFirst(), dt.getSecond(), ngayCongChuan, luongCoBan);
                luongNghiPhep = tinhLuongTheoHeSo(dt.getFirst(), dt.getThird(), ngayCongChuan, luongCoBan);

                DoubleTriple dt2 = list.get(1);
                luongNgoaiGio = tinhLuongTheoHeSo(dt2.getFirst(), dt2.getSecond(), ngayCongChuan, luongCoBan);
                ngayNgoaiGio = dt2.getSecond();
            }

            double tongLuong = luongCBTinh + luongNghiPhep + luongNgoaiGio + phuCap;
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/main/java/report/rptChiTietLuong.jrxml");
            map.put("maNV", maNV);
            map.put("ngayCongChuan", ngayCongChuan);
            map.put("ngayLamViecThucTe", ngayLamViecThucTe);
            map.put("ngayNghiPhep", ngayNghiPhep);
            map.put("ngayNgoaiGio", ngayNgoaiGio);
            map.put("luongCoBan", decimalFormat.format(luongCBTinh));
            map.put("nghiPhepHuongLuong", decimalFormat.format(luongNghiPhep));
            map.put("luongNgoaiGio", decimalFormat.format(luongNgoaiGio));
            map.put("namLuong", namLuong);
            map.put("thangLuong", thangLuong);
            map.put("tongLuong", decimalFormat.format(tongLuong));
            map.put("phuCap", decimalFormat.format(phuCap));

            Connection con = ConnectDB.getInstance().getConnection();

            JasperPrint p = JasperFillManager.fillReport(report, map, con);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (JRException ex) {
            Logger.getLogger(FrmTinhLuongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmTinhLuongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnInBangLuongActionPerformed

    private void cmbThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbThangItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int thangLuong = Integer.parseInt(cmbThang.getSelectedItem().toString());
            int namLuong = Integer.parseInt(cmbNam.getSelectedItem().toString());
            loadDataTblDsBangLuong(thangLuong, namLuong);
        }
    }//GEN-LAST:event_cmbThangItemStateChanged

    private void cmbNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNamItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int thangLuong = Integer.parseInt(cmbThang.getSelectedItem().toString());
            int namLuong = Integer.parseInt(cmbNam.getSelectedItem().toString());
            loadDataTblDsBangLuong(thangLuong, namLuong);
        }
    }//GEN-LAST:event_cmbNamItemStateChanged

    private void btnXoaTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTinhLuongActionPerformed
        int row = tblDsTinhLuong.getSelectedRow();
        String maBangLuongXoa = modelDsBangLuong.getValueAt(row, 0).toString();
        try {
            if (bangLuongNVDao.xoaBangLuongNV(maBangLuongXoa)) {
                JOptionPane.showMessageDialog(this, "Xoá Bảng lương thành công!");
                modelDsBangLuong.removeRow(row);
            } else {
                System.out.println("Xoá Bảng lương không thành công");
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        xoaRong();
    }//GEN-LAST:event_btnXoaTinhLuongActionPerformed

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

    private void cmbNhanVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNhanVienItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        String selectedItem = (String) cmbNhanVien.getSelectedItem();
        if (selectedItem.equals("Tất cả")) {
            txtMaNhanVien.setEnabled(false);
            txtSoNgayLam.setEnabled(false);
            txtTongLuong.setEnabled(false);
            
            //Còn xử lý tính lương 1 lần nhiều nhân viên
        } 

    }
    }//GEN-LAST:event_cmbNhanVienItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoChon;
    private javax.swing.JButton btnBoLoc;
    private javax.swing.JButton btnInBangLuong;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTinhLuong;
    private javax.swing.JButton btnXoaTinhLuong;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cmbNam;
    private javax.swing.JComboBox<String> cmbNhanVien;
    private javax.swing.JComboBox<String> cmbPhongBanLoc;
    private javax.swing.JComboBox<String> cmbThang;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhongBanLoc;
    private javax.swing.JLabel lblSoNgayLam;
    private javax.swing.JLabel lblThang;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTongLuong;
    private javax.swing.JPanel pnlDsNhanVien;
    private javax.swing.JPanel pnlDsTinhLuong;
    private javax.swing.JPanel pnlLocDsNhanVien;
    private javax.swing.JPanel pnlNutChucNang;
    private javax.swing.JPanel pnlThongTinTinhLuong;
    private javax.swing.JScrollPane scrDsNhanVien;
    private javax.swing.JScrollPane scrDsTinhLuong;
    private javax.swing.JTable tblDsNhanVien;
    private javax.swing.JTable tblDsTinhLuong;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoNgayLam;
    private javax.swing.JTextField txtTongLuong;
    // End of variables declaration//GEN-END:variables
}
