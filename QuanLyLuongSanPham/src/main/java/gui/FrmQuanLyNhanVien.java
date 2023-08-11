/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhanVienDao;
import dao.PhongBanDao;
import entity.NhanVien;
import entity.PhongBan;
import helper.RightRenderer;
import helper.XuatFileExcel;
import java.text.DecimalFormat;
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
import javax.swing.table.TableColumnModel;

/**
 *
 * @author huylauri
 */
public class FrmQuanLyNhanVien extends javax.swing.JPanel {

    private NhanVienDao nhanVienDao = new NhanVienDao();
    private PhongBanDao phongBanDao = new PhongBanDao();
    private DefaultTableModel model;

    /**
     * Creates new form pnlQuanLyNhanVien
     */
    public FrmQuanLyNhanVien() {
        initComponents();
        initTable();
        loadDataToTable();
        loadDataCmbPhongBan();

    }
    
    private void loadDataCmbPhongBan() {
        try {
            List<String> data = phongBanDao.layDsTenPhongBan();
            DefaultComboBoxModel<String> newModel = new DefaultComboBoxModel<>(data.toArray((new String[data.size()])));
            cmbPhongBan.setModel(newModel);
        } catch (Exception ex) {
            Logger.getLogger(FrmChamCongNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataToTable() {
        try {

            List<NhanVien> list = nhanVienDao.layDSNhanVien();
            model.setRowCount(0);
            for (NhanVien nv : list) {
                {
                    Double luongCoban = nv.getLuongCoBan();
                    DecimalFormat decimalFormat = new DecimalFormat("#");
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
        columnModel.getColumn(7).setCellRenderer(new RightRenderer());
        columnModel.getColumn(8).setCellRenderer(new RightRenderer());
        columnModel.getColumn(9).setCellRenderer(new RightRenderer());
    }

    private void xoaRong() {
        txtMaNhanVien.setText("");
        txtHoTen.setText("");
        cmbGioiTinh.setSelectedIndex(0);
        dchNgaySinh.setDate(null);
        txtCmnd.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        dchNgayBatDau.setDate(null);
        txtDiaChi.setText("");
//        cmbPhongBan.removeAllItems();
        loadDataCmbPhongBan();
        txtChucVu.setText("");
        txtLuongCoBan.setText("");
        txtPhuCap.setText("");
        txtHeSoLuong.setText("");
    }
    
    public String kiemTraDuLieu(NhanVien nv){
        String loi = "";
        if (!nv.getMaNhanVien().matches("NV_[0-9]{4}")) {
            loi = "Mã nhân viên phải có dạng NV_XXXX, X là các số từ 0 đến 9.";
            return loi;
        }       
        
        if (!(nv.getNgaySinh().toLocalDate().compareTo(LocalDate.now()) < 0)) {
            loi = "Ngày sinh phải nhỏ hơn ngày hiện tại.";
            return loi;
        }
        if (!(nv.getNgayBatDau().toLocalDate().compareTo(LocalDate.now()) < 0)) {
            loi = "Ngày bắt đầu làm phải nhỏ hơn ngày hiện tại.";
            return loi;
        }
        
        if (!nv.getSoDienThoai().matches("[0-9]{10}")) {
            loi = "Số điện thoại không đúng cú pháp.";
            return loi;
        }
        
        if (!nv.getEmail().contains("@") || nv.getEmail().contains(" ")) {
            loi = "Email không đúng cú pháp.";
            return loi;
        }
        
        if (!nv.getCmnd().matches("[0-9]{9}|[0-9]{12}")) {
            loi = "Số CMND không đúng cú pháp.";
            return loi;
        }
        
        if (nv.getHeSoLuong() < 1.0) {
            loi = "Hệ số lương phải lớn hơn 1.0";
            return loi;
        }
        
        if (nv.getLuongCoBan() <= 0) {
            loi = "Lương cơ bản phải lớn hơn 0";
            return loi;
        }
        
        if (nv.getPhuCap() < 0) {
            loi = "Phụ cấp phải lớn hơn 0";
            return loi;
        }
        
        return null;
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
        pnlThongTinNV = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        txtCmnd = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        lblSoDienThoai = new javax.swing.JLabel();
        lblCmnd = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblNgayBatDau = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        dchNgaySinh = new com.toedter.calendar.JDateChooser();
        dchNgayBatDau = new com.toedter.calendar.JDateChooser();
        lblChucVu = new javax.swing.JLabel();
        lblPhongBan = new javax.swing.JLabel();
        cmbPhongBan = new javax.swing.JComboBox<>();
        lblPhuCap = new javax.swing.JLabel();
        txtPhuCap = new javax.swing.JTextField();
        lblHeSoLuong = new javax.swing.JLabel();
        txtHeSoLuong = new javax.swing.JTextField();
        txtLuongCoBan = new javax.swing.JTextField();
        lblLuongCoBan = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        pnlNutChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnThoiViec = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNhanVien = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTieuDe1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTieuDe1.setForeground(new java.awt.Color(51, 0, 255));
        lblTieuDe1.setText("NHÂN VIÊN HÀNH CHÍNH");

        pnlThongTinNV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pnlThongTinNV.setMaximumSize(new java.awt.Dimension(100, 100));

        lblMaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaNhanVien.setText("Mã nhân viên:");

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        lblHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHoTen.setText("Họ tên:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGioiTinh.setText("Giới tính:");

        lblNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgaySinh.setText("Ngày sinh:");

        lblSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoDienThoai.setText("Số điện thoại:");

        lblCmnd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCmnd.setText("CMND:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblNgayBatDau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayBatDau.setText("Ngày bắt đầu:");

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDiaChi.setText("Địa chỉ:");

        cmbGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cmbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGioiTinhActionPerformed(evt);
            }
        });

        lblChucVu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChucVu.setText("Chức vụ:");

        lblPhongBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhongBan.setText("Phòng ban:");

        lblPhuCap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhuCap.setText("Phụ cấp:");

        txtPhuCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhuCapActionPerformed(evt);
            }
        });

        lblHeSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHeSoLuong.setText("Hệ số lương:");

        txtLuongCoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongCoBanActionPerformed(evt);
            }
        });

        lblLuongCoBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLuongCoBan.setText("Lương cơ bản:");

        txtChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChucVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinNVLayout = new javax.swing.GroupLayout(pnlThongTinNV);
        pnlThongTinNV.setLayout(pnlThongTinNVLayout);
        pnlThongTinNVLayout.setHorizontalGroup(
            pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinNVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                        .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCmnd))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNhanVien))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPhuCap))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLuongCoBan)))
                        .addGap(70, 70, 70)
                        .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dchNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChucVu))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dchNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                                .addComponent(lblHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongTinNVLayout.setVerticalGroup(
            pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinNVLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dchNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dchNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
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
                .addContainerGap(141, Short.MAX_VALUE)
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
                .addContainerGap(142, Short.MAX_VALUE))
        );
        pnlNutChucNangLayout.setVerticalGroup(
            pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutChucNangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlNutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoiViec, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
        jScrollPane1.setViewportView(tblDSNhanVien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongTinNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(0, 0, 0)
                .addComponent(pnlThongTinNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(pnlNutChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtPhuCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhuCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhuCapActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        PhongBan phongBan = new PhongBan();
        String tenPB = cmbPhongBan.getSelectedItem().toString();
        try {
            phongBan = phongBanDao.layPBTheoTen(tenPB);
        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        String txtGT = (String) cmbGioiTinh.getSelectedItem();
        boolean gt = txtGT.equalsIgnoreCase("Nam");
        NhanVien nv = new NhanVien(txtMaNhanVien.getText(), txtHoTen.getText(), new java.sql.Date(dchNgaySinh.getDate().getTime()), gt,
                txtDiaChi.getText(), txtSoDienThoai.getText(), txtEmail.getText(), txtCmnd.getText(), new java.sql.Date(dchNgayBatDau.getDate().getTime()),
                txtChucVu.getText(), Double.valueOf(txtHeSoLuong.getText()), Double.valueOf(txtLuongCoBan.getText()),
                Double.valueOf(txtPhuCap.getText()), phongBan);

        try {
            if (nhanVienDao.layNVTheoMa(nv.getMaNhanVien()) == null) {
                String rs = kiemTraDuLieu(nv);
                if (rs == null) {
                    if (nhanVienDao.themNhanVien(nv)) {
                        JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công.");
                        loadDataToTable();
                        xoaRong();
                    } else {
                        System.out.println("Lỗi");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, rs);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!");
            }

        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtLuongCoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongCoBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongCoBanActionPerformed

    private void txtChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChucVuActionPerformed

    private void cmbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGioiTinhActionPerformed

    private void tblDSNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNhanVienMouseClicked
        int row = tblDSNhanVien.getSelectedRow();
        String maNVChon = model.getValueAt(row, 0).toString();
        try {
            NhanVien nv = nhanVienDao.layNVTheoMa(maNVChon);
            txtMaNhanVien.setText(nv.getMaNhanVien());
            txtHoTen.setText(nv.getTenNhanVien());
            cmbGioiTinh.setSelectedIndex(nv.isGioiTinh() ? 0 : 1);
            dchNgaySinh.setDate(nv.getNgaySinh());
            txtCmnd.setText(nv.getCmnd());
            txtSoDienThoai.setText(nv.getSoDienThoai());
            txtEmail.setText(nv.getEmail());
            dchNgayBatDau.setDate(nv.getNgayBatDau());
            txtDiaChi.setText(nv.getDiaChi());
            String phongBan = nv.getPhongBan().getTenPhongBan();
            cmbPhongBan.addItem(phongBan);
            cmbPhongBan.setSelectedItem(phongBan);
            txtChucVu.setText(nv.getChucVu());
            Double luongCoban = nv.getLuongCoBan();
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            txtLuongCoBan.setText(String.valueOf(decimalFormat.format(luongCoban)));
            txtHeSoLuong.setText(String.valueOf(nv.getHeSoLuong()));
            txtPhuCap.setText(String.valueOf(nv.getPhuCap()));
        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDSNhanVienMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        xoaRong();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThoiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiViecActionPerformed
        int row = tblDSNhanVien.getSelectedRow();
        String maNhanVienXoa = model.getValueAt(row, 0).toString();
        try {
            if (nhanVienDao.xoaNhanVien(maNhanVienXoa)) {
                JOptionPane.showMessageDialog(this, "Xoá Nhân viên thành công!");
                model.removeRow(row);
            } else {
                System.out.println("Xoá nhân viên không thành công");
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmQuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        xoaRong();


    }//GEN-LAST:event_btnThoiViecActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
//      Lấy JTabbedPane chính
        JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
//      Xác định index của tab hiện tại
        int index = tabbedPane.indexOfComponent(this);
//      Xóa tab hiện tại
        if (index != -1) {
            tabbedPane.removeTabAt(index);
        }
//      Nếu không còn tab nào hiển thị, đặt lại giao diện chính
        if (tabbedPane.getTabCount() == 0) {
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(tabbedPane);
            mainFrame.getContentPane().removeAll();
            mainFrame.getContentPane().add(new TrangChu_GUI());
            mainFrame.getContentPane().revalidate();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        XuatFileExcel.xuatFileExcel(tblDSNhanVien);
    }//GEN-LAST:event_btnXuatExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThoiViec;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbPhongBan;
    private com.toedter.calendar.JDateChooser dchNgayBatDau;
    private com.toedter.calendar.JDateChooser dchNgaySinh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblCmnd;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHeSoLuong;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblLuongCoBan;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblNgayBatDau;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblPhongBan;
    private javax.swing.JLabel lblPhuCap;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTieuDe1;
    private javax.swing.JPanel pnlNutChucNang;
    private javax.swing.JPanel pnlThongTinNV;
    private javax.swing.JTable tblDSNhanVien;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHeSoLuong;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuongCoBan;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtPhuCap;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
