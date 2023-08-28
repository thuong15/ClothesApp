/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project2;

import SanPham.SanPham_detail_bill;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Photocopy HoaQuan
 */
public class detail_bill extends javax.swing.JFrame {

    /**
     * Creates new form detail_bill
     */
    ArrayList<SanPham_detail_bill> sp_detail = new ArrayList<SanPham_detail_bill>();
    DefaultTableModel table;
    int dong = 0;
    
    public void LoadDataForTable_detail(){
    sp_detail.clear();
        try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                String sql = "SELECT * FROM detail_bill";    
                PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();
                    sp_detail.clear();
                    while(rs.next()){
                        String SoHoaDon = rs.getString(2);
                        String MaSanPham = rs.getString(3);
                        String TenSanPham = rs.getString(4);
                        int DonGia = rs.getInt(5);
                        int SoLuong = rs.getInt(6);
                        String ThanhTien = rs.getString(7);
                        int TienKhachCha = rs.getInt(8);
                        int TienChaKhach = rs.getInt(9);
                        
                        SanPham_detail_bill detail = new SanPham_detail_bill(SoHoaDon, MaSanPham, TenSanPham, DonGia, SoLuong, ThanhTien,TienKhachCha,TienChaKhach);
                        sp_detail.add(detail);
                    }
                    conn.close();
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private String idHoaDon;
    public void LoadDataForTable_detailWhereBill(String id){
        this.idHoaDon = id;
    sp_detail.clear();
        try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                String sql = "SELECT * FROM detail_bill Where SoHoaDon = ?";    
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, idHoaDon);
                    ResultSet rs = stmt.executeQuery();
                    sp_detail.clear();
                    while(rs.next()){
                        String SoHoaDon = rs.getString(2);
                        String MaSanPham = rs.getString(3);
                        String TenSanPham = rs.getString(4);
                        int DonGia = rs.getInt(5);
                        int SoLuong = rs.getInt(6);
                        String ThanhTien = rs.getString(7);
                        int TienKhachCha = rs.getInt(8);
                        int TienChaKhach = rs.getInt(9);
                        
                        SanPham_detail_bill detail = new SanPham_detail_bill(SoHoaDon, MaSanPham, TenSanPham, DonGia, SoLuong, ThanhTien,TienKhachCha,TienChaKhach);
                        sp_detail.add(detail);
                    }
                    conn.close();
                    LoadDataArrayListToTable_detail();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void LoadDataArrayListToTable_detail(){
    table = (DefaultTableModel) tbl_Detail.getModel();
        table.setRowCount(0);
        for(SanPham_detail_bill s: sp_detail){
            table.addRow(new Object[]{table.getRowCount() + 1,s.getSoHoaDon(),s.getMaSanPham(),s.getTenSanPham(),s.getDonGia(),s.getSoLuong(),s.getThanhTien()});
        }
    }
    private int idnv;
    private String id;
    private String masp;
    
    public void detail(int idnv){
        this.idnv = idnv;
    }
    
    
    public void detail(String id,String masp,int idnv){
        this.idnv = idnv;
        this.masp = masp;
        this.id = id;
        
        sp_detail.clear();
        txtSoHoaDon.setText(id);
        txtMaSanPham.setText(masp);
        try{
          
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
            
        String sql = "SELECT * FROM detail_bill WHERE SoHoaDon = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            System.out.println(""+stmt);
        ResultSet rs = stmt.executeQuery();
        System.out.println(""+stmt);
        if(rs.next()){
                        String SoHoaDon = rs.getString(2);
                        String MaSanPham = rs.getString(3);
                        String TenSanPham = rs.getString(4);
                        int DonGia = rs.getInt(5);
                        int SoLuong = rs.getInt(6);
                        String ThanhTien = rs.getString(7);
                        int TienKhachCha = rs.getInt(8);
                        int TienChaKhach = rs.getInt(9);
                        SanPham_detail_bill spham= new SanPham_detail_bill(SoHoaDon, MaSanPham, TenSanPham, DonGia, SoLuong, ThanhTien,TienKhachCha,TienChaKhach);
                        sp_detail.add(spham);
                        
//                        String sql1 = "SELECT * FROM information WHERE MaSanPham = ?";
//                        PreparedStatement stmt1 = conn.prepareStatement(sql1);
//                        stmt1.setString(1, masp);
//            ResultSet rs2 = stmt.executeQuery();
//            System.out.println(""+stmt);
//            if(rs2.next()){
//                        String MaSanPham1 = rs2.getString(2);
//                        String TenSanPham1 = rs2.getString(3);
//                        String KichCo1 = rs2.getString(4);
//                        String SoLuong1 = rs2.getString(5);
//                        String NgayNhap1 = rs2.getString(6);
//                        String NhaCungCap1 = rs2.getString(7);
//                        String GiaNhap1 = rs2.getString(8);
//                        String GiaBan1 = rs2.getString(9);
                    txtSoHoaDon.setText(id);
                    txtMaSanPham.setText(MaSanPham);
                    txtTenSanPham.setText(TenSanPham);
                    txtDonGia.setText(DonGia+"");
                    txtSoLuong.setText(SoLuong+"");
                    txtThanhTien.setText(ThanhTien);
                    txtTienChaKhach.setText(TienChaKhach+"");
                    txtTienKhachcha.setText(TienKhachCha+"");
//                    
//        }
            
            
        }
        
        conn.close();
        
        LoadDataArrayListToTable_detail();
            
        }catch(Exception e){
            
        }
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
            
        
        }catch(Exception e){
            
        }
        
    }
    
    
    public detail_bill() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        LoadDataForTable_detail();
        LoadDataArrayListToTable_detail();
        this.txtDonGia.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Detail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSoHoaDon = new javax.swing.JTextField();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTruoc = new javax.swing.JButton();
        btnSau = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTienKhachcha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTienChaKhach = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTongHoaDon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_Detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Số Hóa Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        tbl_Detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Detail);

        jLabel1.setText("Số Hóa Đơn");

        jLabel2.setText("Mã Sản Phẩm");

        jLabel3.setText("Tên Sản Phẩm");

        jLabel4.setText("Đơn Giá");

        jLabel5.setText("Số Lượng");

        jLabel6.setText("Thành Tiền");

        txtMaSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaSanPhamKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSanPhamKeyReleased(evt);
            }
        });

        txtDonGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDonGiaKeyReleased(evt);
            }
        });

        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/updated.png"))); // NOI18N
        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-button.png"))); // NOI18N
        btnTruoc.setText("Sau");
        btnTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocActionPerformed(evt);
            }
        });

        btnSau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next-button.png"))); // NOI18N
        btnSau.setText("Trước");
        btnSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/house.png"))); // NOI18N
        btnTrangChu.setText("Trang chủ");
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/log-out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Chi Tiết Hóa Đơn");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seach.png"))); // NOI18N
        jLabel8.setText("Tìm Kiếm");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel9.setText("Tiền Khách Trả");

        txtTienKhachcha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachchaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachchaKeyReleased(evt);
            }
        });

        jLabel10.setText("Tiền Thừa:");

        txtTienChaKhach.setText(" ");

        txtThanhTien.setText(" ");

        jLabel11.setText("Tổng Hóa Đơn");

        txtTongHoaDon.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTienChaKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(txtTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(41, 41, 41)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTienKhachcha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnCapNhap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnSau)
                                .addGap(36, 36, 36)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrangChu)
                            .addComponent(jLabel4))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtTongHoaDon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTienKhachcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(jLabel10)
                    .addComponent(txtTienChaKhach)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtThanhTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCapNhap)
                        .addComponent(btnXoa)
                        .addComponent(btnTruoc)
                        .addComponent(btnSau)
                        .addComponent(btnLamMoi)))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        dispose();
        Information i = new Information();
        i.Information(idnv);
        i.show();
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int Soluong= 0;
        try{
            if(txtSoHoaDon.getText().equals("")||txtMaSanPham.getText().equals("")|| txtSoLuong.getText().equals("")
                    ||txtDonGia.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Số hóa đơn không được để trống");
            }else{
                 if(JOptionPane.showConfirmDialog(this, "Bạn muốn thêm chứ :3")== JOptionPane.YES_OPTION){
                
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
//                String sql1 = "SELECT * FROM detail_bill where SoHoaDon = ?";    
//                PreparedStatement stmt = conn.prepareStatement(sql1);
//                     
//                    stmt.setString(1, txtSoHoaDon.getText());
//                    //System.out.println(""+stmt);
//                    ResultSet rs = stmt.executeQuery();
//                if(rs.next()){
//                    JOptionPane.showMessageDialog(null, "Đã có số hóa đơn nầy");
//                }else{
                    
                    String sql5="SELECT*FROM bill Where SoHoaDon = ?";
                    PreparedStatement pstmt5 = conn.prepareStatement(sql5);
                    pstmt5.setString(1, txtSoHoaDon.getText());
                    ResultSet rs5 = pstmt5.executeQuery();
                    if(rs5.next()){
                        String sql2="SELECT *FROM information where MaSanPham = ?";
                    System.out.println(""+sql2);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1,txtMaSanPham.getText());
                System.out.println(""+pstmt2);
                ResultSet rs2 = pstmt2.executeQuery();
                    
                if(rs2.next()){
                    int SoLuongBanDau = rs2.getInt(5);
                    System.out.println(""+SoLuongBanDau);
                    if(SoLuongBanDau == 0){
                        JOptionPane.showMessageDialog(null, "Đã hết mặt hàng nầy");
                    }else{
                    int SoLuong = Integer.parseInt(txtSoLuong.getText());
                    int SoLuongMoi = SoLuongBanDau - SoLuong;
                    if(SoLuongMoi<= 0){
                        JOptionPane.showMessageDialog(null, "Không đủ số lượng");
                    }else{
                        String sql3 = "INSERT INTO detail_bill(ID_detail,SoHoaDon,MaSanPham,TenSanPham,DonGia,SoLuong,ThanhTien,TienKhachcha,TienChaKhach) VALUES(?,?,?,?,?,?,?,?,?)";    
                    PreparedStatement pstmt = conn.prepareStatement(sql3);
                        pstmt.setString(1, null);
                        pstmt.setString(2, txtSoHoaDon.getText());
                        pstmt.setString(3, txtMaSanPham.getText());
                        pstmt.setString(4, txtTenSanPham.getText());
                        pstmt.setInt(5, Integer.parseInt(txtDonGia.getText()));
                        pstmt.setInt(6, Integer.parseInt(txtSoLuong.getText()));
                        pstmt.setString(7, txtThanhTien.getText());
                        pstmt.setInt(8, Integer.parseInt(txtTienKhachcha.getText()));
                        pstmt.setInt(9, Integer.parseInt(txtTienChaKhach.getText()));
                        pstmt.execute();
                        System.out.println(""+pstmt);
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        LoadDataForTable_detailWhereBill(txtSoHoaDon.getText());

                        String sqlCheck="SELECT*FROM detail_bill Where SoHoaDon = ?";
                        PreparedStatement pstmt1 = conn.prepareStatement(sqlCheck);
                        pstmt1.setString(1, txtSoHoaDon.getText());
                        ResultSet rscheck = pstmt1.executeQuery();
                        if(rscheck.next()){
                            String sqlKiemTra = "SELECT * FROM detail_bill Where MaSanPham = ?";
                            PreparedStatement pstmt3 = conn.prepareStatement(sqlKiemTra);
                        pstmt1.setString(1, txtMaSanPham.getText());
                        ResultSet rsKiemTra = pstmt1.executeQuery();
                        if(rsKiemTra.next()){
                            int soluongbandau = rsKiemTra.getInt(6);
                            int soluongmua = Integer.parseInt(txtSoLuong.getText());
                            int SoLuongHienTai = soluongbandau + soluongmua;
                            String sqlupdate = "Update detail_bill set SoLuong = ? Where MaSanPham = ?";
                            PreparedStatement pstmt4 = conn.prepareStatement(sqlupdate);
                        pstmt4.setString(1, SoLuongHienTai+"");
                        pstmt4.setString(2, txtMaSanPham.getText());
                        }else{
                            
//                            String SoHoaDon = rscheck.getString(2);
//                            String MaSanPham = rscheck.getString(3);
//                            String TenSanPham = rscheck.getString(4);
//                            int DonGia = rscheck.getInt(5);
//                            int SoLuong1 = rscheck.getInt(6);
//                            String ThanhTien = rscheck.getString(7);
//                            int TienKhachCha = rscheck.getInt(8);
//                            int TienChaKhach = rscheck.getInt(9);
                            
//                            String SoHoaDon = txtSoHoaDon.getText();
//                            String MaSanPham = txtMaSanPham.getText();
//                            String TenSanPham = txtTenSanPham.getText();
//                            int DonGia = Integer.parseInt(txtDonGia.getText());
//                            int SoLuong1 =Integer.parseInt(txtSoLuong.getText());
//                            String ThanhTien = txtThanhTien.getText();
//                            int TienKhachCha =Integer.parseInt(txtTienKhachcha.getText());
//                            int TienChaKhach =Integer.parseInt(txtTienChaKhach.getText());
//
//                            SanPham_detail_bill detail = new SanPham_detail_bill(SoHoaDon, MaSanPham, TenSanPham, DonGia, SoLuong1, ThanhTien,TienKhachCha,TienChaKhach);
//                        sp_detail.add(detail);
                            LoadDataForTable_detailWhereBill(txtSoHoaDon.getText());
                        }
                        }
                       
                        
                        //LoadDataArrayListToTable_detail();
                        this.pack();
                        String sql4="Update information set SoLuong = ? WHERE MaSanPham = ?";
                        PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                        pstmt4.setInt(1, SoLuongMoi);
                        pstmt4.setString(2, txtMaSanPham.getText());
                        System.out.println(""+pstmt4);
                        pstmt4.execute();
                    }
                    }
                }else{
                     JOptionPane.showMessageDialog(null, "không có mã sản phẩm nầy");
                 }
                    conn.close();
                    }else{
                        JOptionPane.showMessageDialog(null, "yêu Cầu lập Hóa Đơn trước!");
                    }
                    
                
                   // }
                 }else{
                return;
                }
            }
            
        }catch(SQLException ex){
        
            }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        // TODO add your handling code here:
        try{
            if(txtSoHoaDon.getText().equals("")||txtSoLuong.getText().equals("")
                    ||txtDonGia.getText().equals("")||txtThanhTien.getText().equals("")
                    || txtTienKhachcha.equals("")){
                txtSoHoaDon.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Số hóa đơn không được để trống");
                txtSoHoaDon.setBackground(Color.white);
            }else{
                if(JOptionPane.showConfirmDialog(this, "Bạn muốn cập nhập chứ ?")== JOptionPane.YES_OPTION){
                txtMaSanPham.setBackground(Color.white);
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                String sql1 = "SELECT * FROM detail_bill where MaSanPham = ?";    
                PreparedStatement stmt1 = conn.prepareStatement(sql1);
                    
                    stmt1.setString(1, txtMaSanPham.getText());
                    System.out.println(""+stmt1);
                    ResultSet rs = stmt1.executeQuery();
                if(rs.next()){
                    System.out.println("okeaksjd");
                //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                String sql = "Update detail_bill set MaSanPham = ?,TenSanPham = ?,DonGia = ?,SoLuong = ?,ThanhTien=?,TienKhachCha=?,TienChaKhach=? WHERE SoHoaDon = ?"  ;    
                PreparedStatement stmt = conn.prepareStatement(sql);
                    
                    
                    stmt.setString(8, txtSoHoaDon.getText());
                    stmt.setString(1, txtMaSanPham.getText());
                    stmt.setString(2, txtTenSanPham.getText());
                    stmt.setInt(3, Integer.parseInt(txtDonGia.getText()));
                    stmt.setInt(4, Integer.parseInt(txtSoLuong.getText()));
                    stmt.setString(5, txtThanhTien.getText());
                    stmt.setInt(6, Integer.parseInt(txtTienKhachcha.getText()));
                    stmt.setInt(7, Integer.parseInt(txtTienChaKhach.getText()));
                    System.out.println(""+stmt);
                    stmt.execute();
           JOptionPane.showMessageDialog(null, "Cập nhập thành công");
           LoadDataForTable_detail();
           LoadDataArrayListToTable_detail();
           this.pack();
            
            conn.close();
                }
                else{
                JOptionPane.showMessageDialog(null, "Không có");
                }
            }else{
                return;
                
            }
            }
        }catch(SQLException ex){
        
            }
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try{
            if(txtSoHoaDon.getText().equals("")){
                txtSoHoaDon.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Số hóa đơn không được để trống");
            }
            else{
            if(JOptionPane.showConfirmDialog(this, "Bạn chắc chưa?")== JOptionPane.YES_OPTION){
                txtMaSanPham.setBackground(Color.white);
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                String sql1 = "SELECT * FROM detail_bill where MaSanPham = ?";    
                PreparedStatement stmt1 = conn.prepareStatement(sql1);
                    
                    stmt1.setString(1, txtMaSanPham.getText());
                    ResultSet rs = stmt1.executeQuery();
                if(rs.next()){
                txtSoHoaDon.setBackground(Color.white);
                //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                String sql = "DELETE FROM detail_bill WHERE MaSanPham = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, txtMaSanPham.getText());
                    
//                    System.out.println(""+stmt1);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    LoadDataForTable_detail();
                    LoadDataArrayListToTable_detail();
                    this.pack();
            
            conn.close();
                }else{
                    JOptionPane.showMessageDialog(null, "Không có!");
                }
                }else{
                return;
                
            }
            }
        }catch(SQLException ex){
        
            }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocActionPerformed
        // TODO add your handling code here:
        dong++;
        if(dong>= sp_detail.size()){
            JOptionPane.showConfirmDialog(null, "nhìn bảng chưa mà ấn!!!");
            return;
        }
        hienthi(dong);
        tbl_Detail.setRowSelectionInterval(dong, dong);
    }//GEN-LAST:event_btnTruocActionPerformed

    private void btnSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauActionPerformed
        // TODO add your handling code here:
        dong--;
        if(dong < 0){
            JOptionPane.showConfirmDialog(null, "Bạn đang ở cuối chang!");
            return;
        }
//        if(dong==0){
//            JOptionPane.showConfirmDialog(null, "Không có sản phẩm nào");
//        }
        hienthi(dong);
        tbl_Detail.setRowSelectionInterval(dong, dong);
    }//GEN-LAST:event_btnSauActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtSoHoaDon.setText("");
            txtMaSanPham.setText("");
            txtTenSanPham.setText("");
            txtDonGia.setText("");
            txtSoLuong.setText("");
            txtThanhTien.setText("");
            txtTienKhachcha.setText("");
            txtTienChaKhach.setText("");
            LoadDataForTable_detail();
           LoadDataArrayListToTable_detail();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tbl_DetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DetailMouseClicked
        // TODO add your handling code here:
        dong = tbl_Detail.getSelectedRow();
        hienthi(dong);
    }//GEN-LAST:event_tbl_DetailMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        sp_detail.clear();
        try{
          
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
        String sql = "SELECT * FROM detail_bill WHERE SoHoaDon LIKE N'%"+ txtTimKiem.getText()+"%'";
//        String sql = "SELECT * FROM detail_bill WHERE TenSanPham LIKE N'%"+ txtTimKiem.getText()+"%'OR SoHoaDon LIKE N'%"+txtTimKiem.getText()+"%'OR MaSanPham LIKE N'%"+txtTimKiem.getText()+"%'";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        System.out.println(""+stmt);
        while(rs.next()){
                        String SoHoaDon = rs.getString(2);
                        String MaSanPham = rs.getString(3);
                        String TenSanPham = rs.getString(4);
                        int DonGia = rs.getInt(5);
                        int SoLuong = rs.getInt(6);
                        String ThanhTien = rs.getString(7);
                        int TienKhacCha = rs.getInt(8);
                        int TienChaKhach = rs.getInt(9);
                        
                        SanPham_detail_bill spham= new SanPham_detail_bill(SoHoaDon, MaSanPham, TenSanPham, DonGia, SoLuong, ThanhTien,TienKhacCha,TienChaKhach);
                        sp_detail.add(spham);
                        
        }
        conn.close();
        
        LoadDataArrayListToTable_detail();
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtSoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyPressed
        // TODO add your handling code here:
        
        

    }//GEN-LAST:event_txtSoLuongKeyPressed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        // TODO add your handling code here:
        int ThanhTien = 0;
        txtThanhTien.setText("0");
//        char c = evt.getKeyChar();
//        if(!(Character.isLetter(c))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)){
//            int DonGia1 = Integer.parseInt(txtDonGia.getText());
//        int SoLuong1 = Integer.parseInt(txtSoLuong.getText());
//        ThanhTien = DonGia1*SoLuong1;
//        txtThanhTien.setText(ThanhTien+"");
//            txtSoLuong.setEditable(true);
//        
//        }else{
//            ThanhTien = 0;
//            txtSoLuong.setEditable(false);
//            txtThanhTien.setText(ThanhTien+"");
//        
//        }
        
        if(txtSoLuong.getText() == 0+"" || txtSoLuong.getText().equals("") ){
            ThanhTien = 0;
            txtThanhTien.setText(ThanhTien+"");
        }else{
            if(txtSoLuong.getText().chars().allMatch(Character:: isDigit)){
                int DonGia1 = Integer.parseInt(txtDonGia.getText());
                int SoLuong1 = Integer.parseInt(txtSoLuong.getText());
                ThanhTien = DonGia1*SoLuong1;
                txtThanhTien.setText(ThanhTien+"");
            }
        }
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void txtTienKhachchaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachchaKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTienKhachchaKeyPressed
    private int TienChaKhach = 0;
    private void txtTienKhachchaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachchaKeyReleased
        // TODO add your handling code here:
        
        
        if(txtThanhTien.getText() == 0+"" || txtThanhTien.getText().equals("") ){
             TienChaKhach= 0;
            txtTienChaKhach.setText(TienChaKhach+"");
        }else{
            if(txtTienKhachcha.getText().chars().allMatch(Character:: isDigit)){
                int ThanhTien = Integer.parseInt(txtThanhTien.getText());
                int TienKhachCha = Integer.parseInt(txtTienKhachcha.getText());
                TienChaKhach = TienKhachCha-ThanhTien;
                txtTienChaKhach.setText(TienChaKhach+"");
            }
        }
    }//GEN-LAST:event_txtTienKhachchaKeyReleased

    private void txtDonGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonGiaKeyReleased
        // TODO add your handling code here:
         int ThanhTien = 0;
        txtThanhTien.setText("0");

        if(txtDonGia.getText() == 0+"" || txtDonGia.getText().equals("") ){
            ThanhTien = 0;
            txtThanhTien.setText(ThanhTien+"");
        }else{
            if(txtDonGia.getText().chars().allMatch(Character:: isDigit)){
                int DonGia1 = Integer.parseInt(txtDonGia.getText());
                int SoLuong1 = Integer.parseInt(txtSoLuong.getText());
                ThanhTien = DonGia1*SoLuong1;
                txtThanhTien.setText(ThanhTien+"");
            }
        }
    }//GEN-LAST:event_txtDonGiaKeyReleased

    private void txtMaSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSanPhamKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtMaSanPhamKeyPressed

    private void txtMaSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSanPhamKeyReleased
        // TODO add your handling code here:
        if(txtMaSanPham.getText() == 0+"" || txtMaSanPham.getText().equals("") ){
            txtDonGia.setText("0");
        }else{
            try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                String sql = "SELECT * FROM information Where MaSanPham = ?";    
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtMaSanPham.getText());
                    ResultSet rs = stmt.executeQuery();
                    sp_detail.clear();
                    while(rs.next()){
                        
                        String TenSanPham = rs.getString(3);
                        String KichCo = rs.getString(4);
                        String SoLuong = rs.getString(5);
                        String NgayNhap = rs.getString(6);
                        String NhaCungCap = rs.getString(7);
                        String DonGia = rs.getString(8);
                        String GiaBan = rs.getString(9);
                        txtTenSanPham.setText(TenSanPham);
                        txtDonGia.setText(DonGia+"");
                        txtSoLuong.setText(0+"");
                        txtTienKhachcha.setText(0+"");
                    }
            }catch(Exception e){
                
            }
                
                
        }
    }//GEN-LAST:event_txtMaSanPhamKeyReleased

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    public void hienthi(int dong){
        SanPham_detail_bill spham = sp_detail.get(dong);
        txtSoHoaDon.setText(spham.getSoHoaDon());
        txtMaSanPham.setText(spham.getMaSanPham());
        txtTenSanPham.setText(spham.getTenSanPham());
        txtDonGia.setText(spham.getDonGia()+"");
        txtSoLuong.setText(spham.getSoLuong()+"");
        txtThanhTien.setText(spham.getThanhTien());
        txtTienKhachcha.setText(spham.getTienKhachCha()+"");
        txtTienChaKhach.setText(spham.getTienChaKhach()+"");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(detail_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detail_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detail_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detail_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detail_bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSau;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnTruoc;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_Detail;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSoHoaDon;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JLabel txtThanhTien;
    private javax.swing.JLabel txtTienChaKhach;
    private javax.swing.JTextField txtTienKhachcha;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JLabel txtTongHoaDon;
    // End of variables declaration//GEN-END:variables
}
