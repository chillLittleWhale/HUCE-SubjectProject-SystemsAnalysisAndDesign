package view;

import model.*;
import controller.*;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Admin_view extends javax.swing.JFrame {
    private ArrayList< Clas> dsLop;
    private ArrayList< Majors> dsNganh;
    private ArrayList< Subject> dsMon;
    private ArrayList< Account> dsSV;
    DefaultTableModel modelLop;
    DefaultTableModel modelNganh;
    DefaultTableModel modelMon;
    DefaultTableModel modelSV;
    int slRowLop;
    int slRowNganh;
    int slRowMon;
    int slRowSV;
    
    public Admin_view() {
        initComponents();
        this.setLocationRelativeTo(null);
        dsLop = new DAO_admin().getClasList();
        dsNganh = new DAO_admin().getMajList();
        dsMon = new DAO_admin().getSubList();
        dsSV = new DAO_sv().getAccSvList();
        setTableLop();
        setTableNganh();
        setTableMon();
        setTableSV();
        showTableLop();
        showTableNganh();
        showTableMon();
        showTableSV();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_lop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_IdLop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_TenLop = new javax.swing.JTextField();
        bnt_addLop = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txt_searchLop = new javax.swing.JTextField();
        btn_searchLop = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbBoxLop = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn_renewLop = new javax.swing.JButton();
        btn_xoaLop = new javax.swing.JButton();
        btn_updateLop = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_nganh = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_IdNganh = new javax.swing.JTextField();
        txt_tenNganh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_addNganh = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        cbBoxNganh = new javax.swing.JComboBox<>();
        txt_searchNganh = new javax.swing.JTextField();
        btn_searchNganh = new javax.swing.JButton();
        btn_renewNganh = new javax.swing.JButton();
        btn_xoaNganh = new javax.swing.JButton();
        btn_updateNganh = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_thuocKhoa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_mon = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txt_IdMon = new javax.swing.JTextField();
        txt_TenMon = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_addMon = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        cbBoxMon = new javax.swing.JComboBox<>();
        txt_searchMon = new javax.swing.JTextField();
        btn_searchMon = new javax.swing.JButton();
        btn_renewMon = new javax.swing.JButton();
        btn_xoaMon = new javax.swing.JButton();
        btn_updateMon = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_sv = new javax.swing.JTable();
        txt_searchSv = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_tenSv = new javax.swing.JTextField();
        txt_dob = new javax.swing.JTextField();
        txt_queQuan = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_nganhSv = new javax.swing.JTextField();
        txt_lopSv = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_themSv = new javax.swing.JButton();
        btn_suaSv = new javax.swing.JButton();
        btn_xoaSv = new javax.swing.JButton();
        btn_renewSv = new javax.swing.JButton();
        btn_searchSv = new javax.swing.JButton();
        cbBoxSv = new javax.swing.JComboBox<>();
        checkBox_nam = new javax.swing.JCheckBox();
        checkBox_nu = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alpha access level");

        table_lop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Tên lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_lop.setMinimumSize(new java.awt.Dimension(10, 0));
        table_lop.getTableHeader().setReorderingAllowed(false);
        table_lop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_lopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_lop);
        if (table_lop.getColumnModel().getColumnCount() > 0) {
            table_lop.getColumnModel().getColumn(0).setMinWidth(20);
            table_lop.getColumnModel().getColumn(0).setPreferredWidth(20);
            table_lop.getColumnModel().getColumn(1).setMinWidth(20);
            table_lop.getColumnModel().getColumn(1).setPreferredWidth(20);
            table_lop.getColumnModel().getColumn(2).setPreferredWidth(170);
        }

        jLabel1.setText("ID lớp :");

        jLabel2.setText("Tên lớp :");

        bnt_addLop.setText("Thêm");
        bnt_addLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_addLopActionPerformed(evt);
            }
        });

        txt_searchLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchLopActionPerformed(evt);
            }
        });
        txt_searchLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchLopKeyReleased(evt);
            }
        });

        btn_searchLop.setText("Tìm");
        btn_searchLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchLopActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm");

        cbBoxLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tên", "Địa chỉ" }));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Thêm mới");

        btn_renewLop.setText("Làm mới");
        btn_renewLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_renewLopActionPerformed(evt);
            }
        });
        btn_renewLop.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                btn_renewLopVetoableChange(evt);
            }
        });

        btn_xoaLop.setText("Xóa");
        btn_xoaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaLopActionPerformed(evt);
            }
        });

        btn_updateLop.setText("Cập nhật");
        btn_updateLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateLopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btn_xoaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(bnt_addLop, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(btn_updateLop))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_IdLop, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_TenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(139, 139, 139)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbBoxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txt_searchLop, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btn_searchLop, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_renewLop)
                .addGap(199, 199, 199))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_IdLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_TenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnt_addLop)
                            .addComponent(btn_updateLop)
                            .addComponent(btn_xoaLop))
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbBoxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_searchLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_searchLop))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_renewLop)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản ký lớp học", jPanel1);

        table_nganh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Ngành học", "Thuộc khoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_nganh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_nganhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_nganh);
        if (table_nganh.getColumnModel().getColumnCount() > 0) {
            table_nganh.getColumnModel().getColumn(0).setPreferredWidth(15);
            table_nganh.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_nganh.getColumnModel().getColumn(2).setPreferredWidth(170);
            table_nganh.getColumnModel().getColumn(3).setPreferredWidth(170);
        }

        jLabel6.setText("ID ngành :");

        jLabel7.setText("Tên ngành :");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Thêm mới");

        btn_addNganh.setText("Thêm");
        btn_addNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addNganhActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setText("Tìm kiếm");

        cbBoxNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tên", "Khoa" }));

        txt_searchNganh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchNganhKeyReleased(evt);
            }
        });

        btn_searchNganh.setText("Tìm");
        btn_searchNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchNganhActionPerformed(evt);
            }
        });

        btn_renewNganh.setText("Làm mới");
        btn_renewNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_renewNganhActionPerformed(evt);
            }
        });

        btn_xoaNganh.setText("Xóa");
        btn_xoaNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaNganhActionPerformed(evt);
            }
        });

        btn_updateNganh.setText("Cập nhật");
        btn_updateNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateNganhActionPerformed(evt);
            }
        });

        jLabel10.setText("Thuộc khoa :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9)
                            .addGap(50, 50, 50)
                            .addComponent(cbBoxNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addComponent(jLabel8))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btn_xoaNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGap(40, 40, 40)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_addNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_IdNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addComponent(btn_updateNganh))
                                .addComponent(txt_thuocKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txt_searchNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btn_searchNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_renewNganh)
                .addGap(232, 232, 232))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_IdNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_tenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_thuocKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_xoaNganh)
                            .addComponent(btn_addNganh)
                            .addComponent(btn_updateNganh))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbBoxNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_searchNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_searchNganh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_renewNganh)
                .addGap(0, 85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý ngành học", jPanel2);

        table_mon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Môn học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_mon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_monMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_mon);
        if (table_mon.getColumnModel().getColumnCount() > 0) {
            table_mon.getColumnModel().getColumn(0).setPreferredWidth(15);
            table_mon.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_mon.getColumnModel().getColumn(2).setPreferredWidth(170);
        }

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel11.setText("Thêm mới");

        txt_TenMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TenMonActionPerformed(evt);
            }
        });

        jLabel12.setText("ID môn :");

        jLabel13.setText("Tên môn :");

        btn_addMon.setText("Thêm ");
        btn_addMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addMonActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel14.setText("Tìm kiếm");

        cbBoxMon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tên" }));

        txt_searchMon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchMonKeyReleased(evt);
            }
        });

        btn_searchMon.setText("Tìm");
        btn_searchMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchMonActionPerformed(evt);
            }
        });

        btn_renewMon.setText("Làm mới");
        btn_renewMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_renewMonActionPerformed(evt);
            }
        });

        btn_xoaMon.setText("Xóa");
        btn_xoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaMonActionPerformed(evt);
            }
        });

        btn_updateMon.setText("Cập nhật");
        btn_updateMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateMonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(btn_xoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_IdMon, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(txt_TenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(btn_addMon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(48, 48, 48)
                                            .addComponent(btn_updateMon))))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(203, 203, 203))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)))))
                        .addComponent(jSeparator5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btn_searchMon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbBoxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(txt_searchMon, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_renewMon)
                .addGap(208, 208, 208))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_IdMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_addMon)
                            .addComponent(btn_xoaMon)
                            .addComponent(btn_updateMon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbBoxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_searchMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_searchMon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_renewMon)
                .addGap(87, 87, 87))
        );

        jTabbedPane1.addTab("Quản lý môn học", jPanel3);

        table_sv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ tên", "Giới tính", "Ngày sinh", "Quê quán", "Ngành", "Lớp", "Số điện thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_sv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_svMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_svMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(table_sv);
        if (table_sv.getColumnModel().getColumnCount() > 0) {
            table_sv.getColumnModel().getColumn(0).setPreferredWidth(5);
            table_sv.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_sv.getColumnModel().getColumn(2).setPreferredWidth(50);
            table_sv.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        txt_searchSv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchSvKeyReleased(evt);
            }
        });

        jLabel15.setText("Họ tên :");

        jLabel16.setText("Giới tính :");

        jLabel17.setText("Ngày sinh :");

        jLabel18.setText("Quê quán :");

        jLabel19.setText("Ngành :");

        jLabel20.setText("Lớp quản lý:");

        jLabel21.setText("Số điện thoại :");

        jLabel22.setText("Email :");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_themSv.setText("Thêm");
        btn_themSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSvActionPerformed(evt);
            }
        });

        btn_suaSv.setText("Cập nhật");
        btn_suaSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaSvActionPerformed(evt);
            }
        });

        btn_xoaSv.setText("Xóa");
        btn_xoaSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaSvActionPerformed(evt);
            }
        });

        btn_renewSv.setText("Làm mới");
        btn_renewSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_renewSvActionPerformed(evt);
            }
        });

        btn_searchSv.setText("Tìm kiếm");
        btn_searchSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchSvActionPerformed(evt);
            }
        });

        cbBoxSv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Họ tên", "Giới tính", "Ngày sinh", "Quê quán", "Ngành ", "Trường", "SDT", "Email", " " }));

        checkBox_nam.setText("Nam");
        checkBox_nam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBox_namMouseClicked(evt);
            }
        });

        checkBox_nu.setText("Nữ");
        checkBox_nu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBox_nuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_queQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txt_dob)
                            .addComponent(txt_tenSv)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(checkBox_nam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBox_nu)))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_searchSv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nganhSv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_lopSv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(105, 105, 105)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_suaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_themSv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_renewSv))
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_searchSv, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBoxSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searchSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchSv)
                    .addComponent(cbBoxSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19)
                            .addComponent(txt_tenSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nganhSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20)
                            .addComponent(txt_lopSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBox_nam)
                            .addComponent(checkBox_nu))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_queQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btn_themSv)
                            .addGap(18, 18, 18)
                            .addComponent(btn_suaSv)
                            .addGap(18, 18, 18)
                            .addComponent(btn_xoaSv)
                            .addGap(18, 18, 18)
                            .addComponent(btn_renewSv))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Quản lý sinh viên", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void setTableLop(){
        modelLop = (DefaultTableModel) table_lop.getModel();
        modelLop.setColumnIdentifiers(new Object[]{
            "STT", "ID lớp", "Tên lớp"
        });
        table_lop.getColumnModel().getColumn(0).setPreferredWidth(15);
        table_lop.getColumnModel().getColumn(1).setPreferredWidth(20);
        table_lop.getColumnModel().getColumn(2).setPreferredWidth(170);
    }
    public void setTableNganh(){
        modelNganh = (DefaultTableModel) table_nganh.getModel();
        modelNganh.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Ngành học", "Thuộc khoa"
        });
        table_nganh.getColumnModel().getColumn(0).setPreferredWidth(15);
        table_nganh.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_nganh.getColumnModel().getColumn(2).setPreferredWidth(170);
        table_nganh.getColumnModel().getColumn(3).setPreferredWidth(170);
    }
    
    public void setTableMon(){
        modelMon = (DefaultTableModel) table_mon.getModel();
        modelMon.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Môn học"
        });
        table_mon.getColumnModel().getColumn(0).setPreferredWidth(15);
        table_mon.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_mon.getColumnModel().getColumn(2).setPreferredWidth(170);
    }
    public void setTableSV(){
        modelSV = (DefaultTableModel) table_sv.getModel();
        modelSV.setColumnIdentifiers(new Object[]{
            "STT", "Họ tên", "Giới tính", "Ngày sinh", "Quê quán", "Ngành", "Lớp", "Số điện thoại", "Email"
        });
        table_sv.getColumnModel().getColumn(0).setPreferredWidth(25); //STT
        table_sv.getColumnModel().getColumn(1).setPreferredWidth(140); //Họ tên
        table_sv.getColumnModel().getColumn(2).setPreferredWidth(40);  // gioi tinh
        table_sv.getColumnModel().getColumn(3).setPreferredWidth(70); // ngay sinh
        table_sv.getColumnModel().getColumn(4).setPreferredWidth(60); // que
        table_sv.getColumnModel().getColumn(5).setPreferredWidth(150); // nganh
        table_sv.getColumnModel().getColumn(6).setPreferredWidth(50); // lop
        table_sv.getColumnModel().getColumn(7).setPreferredWidth(90); // sdt
        table_sv.getColumnModel().getColumn(8).setPreferredWidth(180); // email
    }
    int sttTruong ;
    public void showTableLop(){
        sttTruong = 1;
        for (Clas uni : dsLop) {
            modelLop.addRow(new Object[]{
            sttTruong++, uni.getIdLop(), uni.getTenLop()});
        }
    }
    public void showResultLop(){
        Clas cla = dsLop.get(dsLop.size()-1);
        modelLop.addRow(new Object[]{
            sttTruong++, cla.getIdLop(), cla.getTenLop()});
    }
    
    int sttNganh ;
    public void showTableNganh(){
        sttNganh = 1;
        for (Majors maj : dsNganh) {
            modelNganh.addRow(new Object[]{
            sttNganh++, maj.getIdNganh(), maj.getTenNganh(), maj.getThuocKhoa()});
        }
    }
    
    public void showResultNganh(){
        Majors maj = dsNganh.get(dsNganh.size()-1);
        modelNganh.addRow(new Object[]{
            sttNganh++, maj.getIdNganh(), maj.getTenNganh(), maj.getThuocKhoa()});
    }
    
    int sttMon ;
    public void showTableMon(){
        sttMon = 1;
        for (Subject sub : dsMon) {
            modelMon.addRow(new Object[]{
            sttMon++, sub.getIdMon(), sub.getTenMon()} );
        }
    }
    public void showResultMon(){
        Subject sub = dsMon.get(dsMon.size()-1);
        modelMon.addRow(new Object[]{
            sttMon++, sub.getIdMon(), sub.getTenMon()});
    }
    
    int sttSV ;
    public void showTableSV(){
        sttSV = 1;
        for (Account acc : dsSV) {
            String gioiTinh = acc.getGioiTinh() ? "Nam" : "Nữ";
            modelSV.addRow(new Object[]{
                sttSV++, acc.getName(), gioiTinh, acc.getNgaySinh(),acc.getQueQuan(), 
                acc.getNganh(), acc.getLop(), acc.getSdt(), acc.getEmail()});
        }
    }
    public void showResultSV(){
        Account acc = dsSV.get(dsSV.size()-1);
        String gioiTinh = acc.getGioiTinh() ? "Nam" : "Nữ";
        modelSV.addRow(new Object[]{
            sttSV++, acc.getName(), gioiTinh, acc.getNgaySinh(),acc.getQueQuan(), 
            acc.getNganh(), acc.getLop(), acc.getSdt(), acc.getEmail()});
    }
    private void txt_searchLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchLopActionPerformed

    private void txt_TenMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TenMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TenMonActionPerformed

    private void bnt_addLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_addLopActionPerformed
        if(!txt_IdLop.getText().equals("")
                && !txt_TenLop.getText().equals("")){
            Clas cla = new Clas(txt_IdLop.getText(),
                    txt_TenLop.getText());
            if( new DAO_admin().addClass(cla)){
                JOptionPane.showMessageDialog(rootPane, "Thêm lớp thành công");
                dsLop.add(cla);
                showResultLop();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Id lớp bị trùng lặp!");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Thông tin không được bỏ trống");
        }
        
    }//GEN-LAST:event_bnt_addLopActionPerformed

    private void table_lopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_lopMouseClicked
        slRowLop = table_lop.getSelectedRow();
        txt_IdLop.setText(modelLop.getValueAt(slRowLop, 1).toString());
        txt_TenLop.setText(modelLop.getValueAt(slRowLop, 2).toString());
    }//GEN-LAST:event_table_lopMouseClicked

    private void btn_updateLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateLopActionPerformed
        Clas cla = new Clas(txt_IdLop.getText(),
                txt_TenLop.getText());
        if( new DAO_admin().updateClass(cla)){
            modelLop.setValueAt(txt_TenLop.getText(), slRowLop, 2);
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "ID lớp không hợp lệ");
        }        
    }//GEN-LAST:event_btn_updateLopActionPerformed

    private void btn_xoaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaLopActionPerformed
        if(!txt_IdLop.getText().equals("")){
            Clas uni = new Clas(txt_IdLop.getText(),
                    txt_TenLop.getText());
            if( new DAO_admin().deleteClass(uni)){
                modelLop.setRowCount(0);
                dsLop = new DAO_admin().getClasList();
                modelLop = (DefaultTableModel) table_lop.getModel();
                modelLop.setColumnIdentifiers(new Object[]{
                    "STT", "ID lớp", "Tên lớp"
                });
                setTableLop();
                showTableLop();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ID lớp không hợp lệ");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn đối tượng");
        } 
    }//GEN-LAST:event_btn_xoaLopActionPerformed

    private void btn_renewLopVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_btn_renewLopVetoableChange

    }//GEN-LAST:event_btn_renewLopVetoableChange

    private void btn_renewLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_renewLopActionPerformed
        modelLop.setRowCount(0);
        dsLop = new DAO_admin().getClasList();
        modelLop = (DefaultTableModel) table_lop.getModel();
        modelLop.setColumnIdentifiers(new Object[]{
            "STT", "ID lớp", "Tên lớp"
        });
        setTableLop();
        showTableLop();
    }//GEN-LAST:event_btn_renewLopActionPerformed

    private void btn_searchLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchLopActionPerformed
        String selectedValue = cbBoxLop.getSelectedItem().toString();
        
        if(selectedValue.equals("ID")){
            dsLop = new DAO_admin().timLopTheoMa(txt_searchLop.getText());
        }
        else {
            try {
                dsLop = new DAO_admin().timLopTheoTen(txt_searchLop.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        setTableLop();
        modelLop.setRowCount(0);
        showTableLop();
    }//GEN-LAST:event_btn_searchLopActionPerformed

    private void btn_addMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addMonActionPerformed
        if(!txt_IdMon.getText().equals("")
                && !txt_TenMon.getText().equals("")){
            Subject sub = new Subject(txt_IdMon.getText(),txt_TenMon.getText());
            if( new DAO_admin().addSubject(sub)){
                JOptionPane.showMessageDialog(rootPane, "thêm môn học thành công");
                dsMon.add(sub);
                showResultMon();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Id môn không được trùng");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Thông tin không được bỏ trống");
        }
    }//GEN-LAST:event_btn_addMonActionPerformed

    private void table_nganhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_nganhMouseClicked
        slRowNganh = table_nganh.getSelectedRow();
        txt_IdNganh.setText(modelNganh.getValueAt(slRowNganh, 1).toString());
        txt_tenNganh.setText(modelNganh.getValueAt(slRowNganh, 2).toString());
        txt_thuocKhoa.setText(modelNganh.getValueAt(slRowNganh, 3).toString());
    }//GEN-LAST:event_table_nganhMouseClicked

    private void btn_addNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addNganhActionPerformed
        if(!txt_IdNganh.getText().equals("")
                && !txt_tenNganh.getText().equals("")
                && !txt_thuocKhoa.getText().equals("")){
            Majors maj = new Majors(txt_IdNganh.getText(),
                    txt_tenNganh.getText(), txt_thuocKhoa.getText());
            if( new DAO_admin().addMajors(maj)){
                JOptionPane.showMessageDialog(rootPane, "Thêm ngành thành công");
                dsNganh.add(maj);
                showResultNganh();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Id ngành không được trùng");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Thông tin không được bỏ trống");
        }
    }//GEN-LAST:event_btn_addNganhActionPerformed

    private void btn_renewNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_renewNganhActionPerformed
        modelNganh.setRowCount(0);
        dsNganh = new DAO_admin().getMajList();
        modelNganh = (DefaultTableModel) table_nganh.getModel();
        modelNganh.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Ngành học", "Thuộc khoa"
        });
        setTableNganh();
        showTableNganh();
    }//GEN-LAST:event_btn_renewNganhActionPerformed

    private void btn_updateNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateNganhActionPerformed
        Majors maj = new Majors(txt_IdNganh.getText(),
                txt_tenNganh.getText(), txt_thuocKhoa.getText());
        if( new DAO_admin().updateMajors(maj)){
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
            modelNganh.setValueAt(txt_tenNganh.getText(), slRowNganh, 2);
            modelNganh.setValueAt(txt_thuocKhoa.getText(), slRowNganh, 3);
        } else {
            JOptionPane.showMessageDialog(rootPane, "ID ngành không hợp lệ");
        }
    }//GEN-LAST:event_btn_updateNganhActionPerformed

    private void btn_xoaNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaNganhActionPerformed
        if(!txt_IdNganh.getText().equals("")){
            Majors maj = new Majors(txt_IdNganh.getText(),
                    txt_tenNganh.getText(), txt_thuocKhoa.getText());
            if( new DAO_admin().deleteMajors(maj)){
                modelNganh.setRowCount(0);
                dsNganh = new DAO_admin().getMajList();
                modelNganh = (DefaultTableModel) table_nganh.getModel();
                modelNganh.setColumnIdentifiers(new Object[]{
                    "STT", "ID", "Ngành học", "Thuộc khoa"
                });
                setTableNganh();
                showTableNganh();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ID ngành không hợp lệ");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn đối tượng");
        } 
    }//GEN-LAST:event_btn_xoaNganhActionPerformed

    private void btn_searchNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchNganhActionPerformed
        String selectedValue = cbBoxNganh.getSelectedItem().toString();
        if(selectedValue.equals("ID")){
            dsNganh = new DAO_admin().timNganhTheoMa(txt_searchNganh.getText());
        }
        else if(selectedValue.equals("Tên")){
            try {
                dsNganh = new DAO_admin().timNganhTheoTen(txt_searchNganh.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(selectedValue.equals("Khoa")){
            try {
                dsNganh = new DAO_admin().timNganhTheoKhoa(txt_searchNganh.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setTableNganh();
        modelNganh.setRowCount(0);
        showTableNganh();
    }//GEN-LAST:event_btn_searchNganhActionPerformed

    private void table_monMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_monMouseClicked
        slRowMon = table_mon.getSelectedRow();
        txt_IdMon.setText(modelMon.getValueAt(slRowMon, 1).toString());
        txt_TenMon.setText(modelMon.getValueAt(slRowMon, 2).toString());
    }//GEN-LAST:event_table_monMouseClicked

    private void btn_xoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaMonActionPerformed
        if(!txt_IdMon.getText().equals("")){
            Subject sub = new Subject(txt_IdMon.getText(),
                    txt_TenMon.getText());
            if( new DAO_admin().deleteSubject(sub)){
                modelMon.setRowCount(0);
                dsMon = new DAO_admin().getSubList();
                modelMon = (DefaultTableModel) table_mon.getModel();
                modelMon.setColumnIdentifiers(new Object[]{"STT", "ID", "Môn học"});
                setTableMon();
                showTableMon();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ID môn không hợp lệ");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn đối tượng");
        } 
    }//GEN-LAST:event_btn_xoaMonActionPerformed

    private void btn_updateMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateMonActionPerformed
        Subject sub = new Subject(txt_IdMon.getText(),txt_TenMon.getText());
        if( new DAO_admin().updateSubject(sub)){
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
            modelMon.setValueAt(txt_TenMon.getText(), slRowMon, 2);
        } else {
            JOptionPane.showMessageDialog(rootPane, "ID môn không hợp lệ");
        }
    }//GEN-LAST:event_btn_updateMonActionPerformed

    private void btn_searchMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchMonActionPerformed
        String selectedValue = cbBoxMon.getSelectedItem().toString();
        if(selectedValue.equals("ID")){
            dsMon = new DAO_admin().timMonTheoMa(txt_searchMon.getText());
        }
        else if(selectedValue.equals("Tên")){
            try {
                dsMon = new DAO_admin().timMonTheoTen(txt_searchMon.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setTableMon();
        modelMon.setRowCount(0);
        showTableMon();
    }//GEN-LAST:event_btn_searchMonActionPerformed

    private void btn_renewMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_renewMonActionPerformed
        modelMon.setRowCount(0);
        dsMon = new DAO_admin().getSubList();
        modelMon = (DefaultTableModel) table_mon.getModel();
        modelMon.setColumnIdentifiers(new Object[]{
            "STT", "ID", "Môn học"
        });
        setTableMon();
        showTableMon();
    }//GEN-LAST:event_btn_renewMonActionPerformed

    private void table_svMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_svMouseClicked
        if(selectedCol != -1 && selectedRow != -1){
            slRowSV = table_sv.getSelectedRow();
            txt_tenSv.setText(modelSV.getValueAt(slRowSV, 1).toString());
            //txt_gioiTinh.setText(modelSV.getValueAt(slRowSV, 2).toString());
            checkBox_nam.setSelected(modelSV.getValueAt(slRowSV, 2).toString().toLowerCase().equals("nam"));
            checkBox_nu.setSelected(modelSV.getValueAt(slRowSV, 2).toString().toLowerCase().equals("nữ"));
            txt_dob.setText(modelSV.getValueAt(slRowSV, 3).toString());
            txt_queQuan.setText(modelSV.getValueAt(slRowSV, 4).toString());
            txt_nganhSv.setText(modelSV.getValueAt(slRowSV, 5).toString());
            txt_lopSv.setText(modelSV.getValueAt(slRowSV, 6).toString());
            txt_sdt.setText(modelSV.getValueAt(slRowSV, 7).toString());
            txt_email.setText(modelSV.getValueAt(slRowSV, 8).toString());
        }
        else{
            txt_tenSv.setText("");
            txt_dob.setText("");
            txt_queQuan.setText("");
            txt_nganhSv.setText("");
            txt_lopSv.setText("");
            txt_sdt.setText("");
            txt_email.setText("");
        }
        
    }//GEN-LAST:event_table_svMouseClicked

    private void btn_themSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSvActionPerformed
        if(!txt_tenSv.getText().isEmpty()&& !txt_sdt.getText().isEmpty()&& !txt_email.getText().isEmpty()){            
            Account acc = new Account(txt_sdt.getText(),"defaultPass123",txt_email.getText());
            
            if(txt_dob.getText() != null){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date utilDate = dateFormat.parse(txt_dob.getText());
                    acc.setNgaySinh(new java.sql.Date(utilDate.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Ngày tháng không đúng định dạng");
                    return;
                }
            }

            acc.setName(txt_tenSv.getText());
            acc.setGioiTinh( checkBox_nam.isSelected());
            acc.setQueQuan(txt_queQuan.getText());
            acc.setNganh(txt_nganhSv.getText());
            acc.setLop(txt_lopSv.getText());
            
            if( new DAO_sv().addAccount(acc)){
                JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên thành công");
                dsSV.add(acc);
                showResultSV();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sdt này đã được đăng ký");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Thông tin tên, sdt, email không được bỏ trống");
        }
    }//GEN-LAST:event_btn_themSvActionPerformed

    private void btn_suaSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaSvActionPerformed
        if(txt_sdt.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn đối tượng");
            return;
        }
        if(!modelSV.getValueAt(slRowSV, 7).toString().equals(txt_sdt.getText())){
            JOptionPane.showMessageDialog(rootPane, "không thể thay đổi số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Account acc = new Account();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = dateFormat.parse(txt_dob.getText());
            acc.setNgaySinh(new java.sql.Date(utilDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        acc.setName(txt_tenSv.getText());
        acc.setGioiTinh( checkBox_nam.isSelected());
        acc.setQueQuan(txt_queQuan.getText());
        acc.setNganh(txt_nganhSv.getText());
        acc.setLop(txt_lopSv.getText());
        acc.setSdt(txt_sdt.getText());
        acc.setEmail(txt_email.getText());
        
        if( new DAO_sv().updateSinhVien(acc)){
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
            modelSV.setValueAt(txt_tenSv.getText(), slRowSV, 1);
            String gioiTinh = checkBox_nam.isSelected()?"Nam":"Nữ";
            modelSV.setValueAt(gioiTinh, slRowSV, 2);
            modelSV.setValueAt(txt_dob.getText(), slRowSV, 3);
            modelSV.setValueAt(txt_queQuan.getText(), slRowSV, 4);
            modelSV.setValueAt(txt_nganhSv.getText(), slRowSV, 5);
            modelSV.setValueAt(txt_lopSv.getText(), slRowSV, 6);
            modelSV.setValueAt(txt_email.getText(), slRowSV, 8);
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công");
        }
    }//GEN-LAST:event_btn_suaSvActionPerformed

    private void btn_xoaSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaSvActionPerformed
        if(!txt_sdt.getText().isEmpty()){
            Account acc = new Account();
            acc.setSdt(txt_sdt.getText());
            if( new DAO_sv().deleteSinhVien(acc)){
                modelSV.setRowCount(0);
                dsSV = new DAO_sv().getAccSvList();
                modelSV = (DefaultTableModel) table_sv.getModel();
                modelSV.setColumnIdentifiers(new Object[]{"STT", "Họ tên", "Giới tính", 
                    "Ngày sinh", "Quê quán", "Ngành", "Trường", "Số điện thoại", "Email"});
                setTableSV();
                showTableSV();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa không thành công");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn đối tượng");
        } 
    }//GEN-LAST:event_btn_xoaSvActionPerformed

    private void btn_renewSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_renewSvActionPerformed
        modelSV.setRowCount(0);
        dsSV = new DAO_sv().getAccSvList();
        modelSV = (DefaultTableModel) table_sv.getModel();
        modelSV.setColumnIdentifiers(new Object[]{"STT", "Họ tên", "Giới tính", 
            "Ngày sinh", "Quê quán", "Ngành", "Trường", "Số điện thoại", "Email"});
        setTableSV();
        showTableSV();
    }//GEN-LAST:event_btn_renewSvActionPerformed

    private void btn_searchSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchSvActionPerformed
        String selectedValue = cbBoxSv.getSelectedItem().toString();
        if(selectedValue.equals("Họ tên")){
            try {
                dsSV = new DAO_sv().timSvTheoTen(txt_searchSv.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(selectedValue.equals("Giới tính")){
            String gt = txt_searchSv.getText().toLowerCase();
            if(!gt.equals("nam") && !gt.equals("nữ")){
                JOptionPane.showMessageDialog(rootPane, "chỉ có 2 loại giới tính: nam và nữ");
                return;
            }
            dsSV = new DAO_sv().timSvTheoGioiTinh(gt.equals("nam"));
        }
        else if(selectedValue.equals("Ngày sinh")){
            dsSV = new DAO_sv().timSvTheoNgaySinh(txt_searchSv.getText());
        }
        else if(selectedValue.equals("Quê quán")){
            try {
                dsSV = new DAO_sv().timSvTheoQueQuan(txt_searchSv.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(selectedValue.equals("Ngành")){
            try {
                dsSV = new DAO_sv().timSvTheoNganh(txt_searchSv.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(selectedValue.equals("Trường")){
            try {
                dsSV = new DAO_sv().timSvTheoLop(txt_searchSv.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(selectedValue.equals("SDT")){
            try {
                dsSV = new DAO_sv().timSvTheoSdt(txt_searchSv.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(selectedValue.equals("Email")){
            try {
                dsSV = new DAO_sv().timSvTheoEmail(txt_searchSv.getText());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Admin_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setTableSV();
        modelSV.setRowCount(0);
        showTableSV();
    }//GEN-LAST:event_btn_searchSvActionPerformed

    private void txt_searchLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchLopKeyReleased
        String keyword = txt_searchLop.getText().toLowerCase();  // lấy giá trị từ ô search
        DefaultTableModel tableModel = (DefaultTableModel) table_lop.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table_lop.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
    }//GEN-LAST:event_txt_searchLopKeyReleased

    private void txt_searchNganhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchNganhKeyReleased
        String keyword = txt_searchNganh.getText().toLowerCase();  // lấy giá trị từ ô search
        DefaultTableModel tableModel = (DefaultTableModel) table_nganh.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table_nganh.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
    }//GEN-LAST:event_txt_searchNganhKeyReleased

    private void txt_searchMonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchMonKeyReleased
        String keyword = txt_searchMon.getText().toLowerCase();  // lấy giá trị từ ô search
        DefaultTableModel tableModel = (DefaultTableModel) table_mon.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table_mon.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
    }//GEN-LAST:event_txt_searchMonKeyReleased

    private void txt_searchSvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchSvKeyReleased
        String keyword = txt_searchSv.getText().toLowerCase();  // lấy giá trị từ ô search
        DefaultTableModel tableModel = (DefaultTableModel) table_sv.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table_sv.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
    }//GEN-LAST:event_txt_searchSvKeyReleased

    private int selectedRow = -1;
    private int selectedCol = -1;
    private void table_svMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_svMousePressed
        int row = table_sv.rowAtPoint(evt.getPoint());
        int col = table_sv.columnAtPoint(evt.getPoint());
        // Check if the cell is valid and left mouse button is clicked
        if (row >= 0 && col >= 0 && SwingUtilities.isLeftMouseButton(evt)) {
            // If cell is already selected, then deselect it
            if (row == selectedRow && col == selectedCol) {
                table_sv.clearSelection();
                selectedRow = -1;
                selectedCol = -1;
            } else {
                // Otherwise, select the cell
    //            table_sv.setRowSelectionInterval(row, row);
    //            table_sv.setColumnSelectionInterval(col, col);
                table_sv.changeSelection(row, col, false, false);
                selectedRow = row;
                selectedCol = col;
            }
        }

    }//GEN-LAST:event_table_svMousePressed

    private void checkBox_namMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBox_namMouseClicked
        if(checkBox_nam.isSelected()){
            checkBox_nu.setSelected(false);
        }
        else{
            checkBox_nu.setSelected(true);
        }
    }//GEN-LAST:event_checkBox_namMouseClicked

    private void checkBox_nuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBox_nuMouseClicked
        if(checkBox_nu.isSelected()){
            checkBox_nam.setSelected(false);
        }
        else{
            checkBox_nam.setSelected(true);
        }
    }//GEN-LAST:event_checkBox_nuMouseClicked

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
            java.util.logging.Logger.getLogger(Admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_addLop;
    private javax.swing.JButton btn_addMon;
    private javax.swing.JButton btn_addNganh;
    private javax.swing.JButton btn_renewLop;
    private javax.swing.JButton btn_renewMon;
    private javax.swing.JButton btn_renewNganh;
    private javax.swing.JButton btn_renewSv;
    private javax.swing.JButton btn_searchLop;
    private javax.swing.JButton btn_searchMon;
    private javax.swing.JButton btn_searchNganh;
    private javax.swing.JButton btn_searchSv;
    private javax.swing.JButton btn_suaSv;
    private javax.swing.JButton btn_themSv;
    private javax.swing.JButton btn_updateLop;
    private javax.swing.JButton btn_updateMon;
    private javax.swing.JButton btn_updateNganh;
    private javax.swing.JButton btn_xoaLop;
    private javax.swing.JButton btn_xoaMon;
    private javax.swing.JButton btn_xoaNganh;
    private javax.swing.JButton btn_xoaSv;
    private javax.swing.JComboBox<String> cbBoxLop;
    private javax.swing.JComboBox<String> cbBoxMon;
    private javax.swing.JComboBox<String> cbBoxNganh;
    private javax.swing.JComboBox<String> cbBoxSv;
    private javax.swing.JCheckBox checkBox_nam;
    private javax.swing.JCheckBox checkBox_nu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table_lop;
    private javax.swing.JTable table_mon;
    private javax.swing.JTable table_nganh;
    private javax.swing.JTable table_sv;
    private javax.swing.JTextField txt_IdLop;
    private javax.swing.JTextField txt_IdMon;
    private javax.swing.JTextField txt_IdNganh;
    private javax.swing.JTextField txt_TenLop;
    private javax.swing.JTextField txt_TenMon;
    private javax.swing.JTextField txt_dob;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_lopSv;
    private javax.swing.JTextField txt_nganhSv;
    private javax.swing.JTextField txt_queQuan;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_searchLop;
    private javax.swing.JTextField txt_searchMon;
    private javax.swing.JTextField txt_searchNganh;
    private javax.swing.JTextField txt_searchSv;
    private javax.swing.JTextField txt_tenNganh;
    private javax.swing.JTextField txt_tenSv;
    private javax.swing.JTextField txt_thuocKhoa;
    // End of variables declaration//GEN-END:variables
}
