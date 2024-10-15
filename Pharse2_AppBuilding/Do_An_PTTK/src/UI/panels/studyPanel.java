package UI.panels;

import UI.searchBar.SearchOption;
import UI.searchBar.SearchOptionEvent;
import UI.swing.scrollbar.ScrollBarCustom;
import controller.DAO_sv;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import model.Account;

import model.*;
import nofitication.Notification;
import view.sub_addHocky;
import view.sub_addMon;
import view.sub_updateGhiChu;

public class studyPanel extends javax.swing.JPanel {

    boolean isRowSelected = false;
    Account acc;
    private ArrayList< Grade> dsDiem = new ArrayList<Grade>();
    DefaultTableModel modelDiem;
    int slRowDiem;
    private int selectedRow = -1;
    private int selectedCol = -1;
    private JFrame frame;
    private KetQuaHocKy ketqua;
    private KetQuaTichLuy ketquaTichLuy;
    public studyPanel(Account acc, JFrame frame) {
        initComponents();
        this.acc = acc;
        this.frame = frame;
        btn_addMon.setEnabled(false);
        if(!acc.getDsHocKy().isEmpty()){
            btn_addMon.setEnabled(true);
        }
        resetHocky();
        if(cbBox_hocKy.getItemCount() != 0){
            this.dsDiem = new DAO_sv().getGradeList1svByhocKy(acc.getSdt(), cbBox_hocKy.getSelectedItem().toString());
        }
        
        setTableDiem();
        showTableDiem();
        showKetQua();
        setSearchBar();
    }

    public void resetHocky(){
        cbBox_hocKy.removeAllItems();
        for (String hk : acc.getDsHocKy()) { 
            cbBox_hocKy.addItem(hk); 
        }
    }
    
    private void setSearchBar(){
        txt_search.addEventOptionSelected(new SearchOptionEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txt_search.setHint("Search by " + option.getName() + "...");
            }
        });
        txt_search.addOption(new SearchOption("Subject Id", new ImageIcon(getClass().getResource("/icon/tag-25.png"))));
        txt_search.addOption(new SearchOption("Subject Name", new ImageIcon(getClass().getResource("/icon/book-25.png"))));
        txt_search.addOption(new SearchOption("Credits", new ImageIcon(getClass().getResource("/icon/certificate-25.png"))));
        txt_search.addOption(new SearchOption("Grade", new ImageIcon(getClass().getResource("/icon/grade-25.png"))));        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_diem = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_addMon = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbBox_hocKy = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tinDangKy = new javax.swing.JTextField();
        txt_diemTBHK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_tinDat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_tinNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_xepLoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_diemHe4 = new javax.swing.JTextField();
        txt_tl_diemTb10 = new javax.swing.JTextField();
        txt_search = new UI.searchBar.TextFieldSearchOption();
        jLabel9 = new javax.swing.JLabel();
        txt_tl_soTinNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_tl_tongTinDangKy = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_tl_soTinDat = new javax.swing.JTextField();

        setBackground(new java.awt.Color(235, 235, 235));

        jPanel1.setBackground(new java.awt.Color(251, 251, 251));

        table_diem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã môn", "Tên môn", "Số tín ", "cc", "gk", "ck", "hệ 10", "hệ 4", "điểm chữ", "Đạt", "Tùy chỉnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_diem.setRowHeight(40);
        table_diem.getTableHeader().setReorderingAllowed(false);
        table_diem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_diemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_diem);

        jLabel1.setText("Điểm TBHK hệ 10 :");

        btn_addMon.setText("thêm môn");
        btn_addMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addMonActionPerformed(evt);
            }
        });

        jButton1.setText("Học kỳ mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbBox_hocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBox_hocKyActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(251, 251, 251));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kết quả học tập");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jScrollPane1.setViewportView(jLabel2);

        jLabel3.setText("Số tín đăng ký :");

        txt_tinDangKy.setEditable(false);
        txt_tinDangKy.setBorder(null);

        txt_diemTBHK.setEditable(false);
        txt_diemTBHK.setBorder(null);

        jLabel4.setText("Số tín chỉ đạt :");

        txt_tinDat.setEditable(false);
        txt_tinDat.setBorder(null);

        jLabel5.setText("Số tín chỉ nợ :");

        txt_tinNo.setEditable(false);
        txt_tinNo.setBorder(null);

        jLabel6.setText("Xếp loại học lực kỳ :");

        txt_xepLoai.setEditable(false);
        txt_xepLoai.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_xepLoai.setBorder(null);

        jLabel7.setText("Điểm TB tích lũy :");

        jLabel8.setText("Điểm TBHK hệ 4 :");

        txt_diemHe4.setEditable(false);
        txt_diemHe4.setBorder(null);

        txt_tl_diemTb10.setEditable(false);
        txt_tl_diemTb10.setBorder(null);

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jLabel9.setText("Số tín nợ :");

        txt_tl_soTinNo.setBorder(null);
        txt_tl_soTinNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tl_soTinNoActionPerformed(evt);
            }
        });

        jLabel10.setText("Tổng tín đăng ký :");

        txt_tl_tongTinDangKy.setBorder(null);

        jLabel11.setText("Số tín đạt :");

        txt_tl_soTinDat.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)
                                .addComponent(txt_tinDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31)
                                .addComponent(txt_tinDat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7)
                                .addComponent(txt_diemTBHK, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_diemHe4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tinNo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_xepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_addMon, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tl_diemTb10, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                    .addComponent(txt_tl_tongTinDangKy))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tl_soTinDat, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(txt_tl_soTinNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(cbBox_hocKy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_tl_tongTinDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(txt_tl_soTinDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBox_hocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addMon)
                    .addComponent(jLabel7)
                    .addComponent(txt_tl_diemTb10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_tl_soTinNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tinDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tinDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tinNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_diemTBHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_xepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_diemHe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addMonActionPerformed
        sub_addMon adView = new sub_addMon(this, acc, cbBox_hocKy.getSelectedItem().toString());
        adView.setVisible(true);
        adView.setLocationRelativeTo(null);
        adView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_addMonActionPerformed

    private void cbBox_hocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBox_hocKyActionPerformed
        resetStudyPanel();
    }//GEN-LAST:event_cbBox_hocKyActionPerformed

    private void table_diemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_diemMouseClicked
        int row = table_diem.rowAtPoint(evt.getPoint());
        int col = table_diem.columnAtPoint(evt.getPoint());
        
        // Check if the cell is valid and left mouse button is clicked
        if (row >= 0 && col >= 0 && SwingUtilities.isLeftMouseButton(evt)) {
            // If cell is already selected and isSelected is true, then deselect it
            if (row == selectedRow && col == selectedCol) {
                table_diem.removeRowSelectionInterval(row, row);
                table_diem.removeColumnSelectionInterval(0, 10);
                selectedRow = -1;
                selectedCol = -1;
            } else {
                // Otherwise, select the cell
                table_diem.changeSelection(row, col, false, false);
                selectedRow = row;
                selectedCol = col;
            }
        }  
    }//GEN-LAST:event_table_diemMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sub_addHocky adView = new sub_addHocky(this, acc);
        adView.setVisible(true);
        adView.setLocationRelativeTo(null);
        adView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        if(txt_search.isSelected()){
            int option = txt_search.getSelectedIndex();
            String keyword = txt_search.getText().toLowerCase();  // lấy giá trị từ ô search
            DefaultTableModel tableModel = (DefaultTableModel) table_diem.getModel();
            DefaultRowSorter<DefaultTableModel, Integer> sorter = new TableRowSorter<>(tableModel); // Tạo một DefaultRowSorter với DefaultTableModel
            table_diem.setRowSorter(sorter);
            if(option == 0){ // tìm theo mã môn
                RowFilter<DefaultTableModel, Integer> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(keyword), 1); // Đặt bộ lọc cho DefaultRowSorter
                sorter.setRowFilter(filter);  
            }
            else if(option == 1){ // tìm theo tên môn
                RowFilter<DefaultTableModel, Integer> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(keyword), 2); // Đặt bộ lọc cho DefaultRowSorter
                sorter.setRowFilter(filter);                
            }
            else if(option == 2){ // tìm theo số tín
                RowFilter<DefaultTableModel, Integer> filter = RowFilter.regexFilter("(?i)" + keyword, 3); // Đặt bộ lọc cho DefaultRowSorter
                sorter.setRowFilter(filter);                
            }
            else if(option == 3){ // tìm theo điểm chữ
                RowFilter<DefaultTableModel, Integer> filter = RowFilter.regexFilter("(?i)" + keyword, 9); // Đặt bộ lọc cho DefaultRowSorter
                sorter.setRowFilter(filter);
            }
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_tl_soTinNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tl_soTinNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tl_soTinNoActionPerformed
    public void setTableDiem(){
        modelDiem = (DefaultTableModel) table_diem.getModel();
        modelDiem.setColumnIdentifiers(new Object[]{
            "STT", "Mã môn", "Tên môn", "Số tín chỉ", "Điểm CC", "Điểm GK", 
            "Điểm CK", "Điểm TB môn", "Điểm hệ 4", "Điểm chữ","Đạt", "Tùy chỉnh"
        });
        table_diem.getColumnModel().getColumn(0).setPreferredWidth(40);
        table_diem.getColumnModel().getColumn(1).setPreferredWidth(60);
        table_diem.getColumnModel().getColumn(2).setPreferredWidth(170);
        table_diem.getColumnModel().getColumn(3).setPreferredWidth(60);
        table_diem.getColumnModel().getColumn(4).setPreferredWidth(70);
        table_diem.getColumnModel().getColumn(5).setPreferredWidth(70);
        table_diem.getColumnModel().getColumn(6).setPreferredWidth(70);
        table_diem.getColumnModel().getColumn(7).setPreferredWidth(90);
        table_diem.getColumnModel().getColumn(8).setPreferredWidth(70);
        table_diem.getColumnModel().getColumn(9).setPreferredWidth(70);
        table_diem.getColumnModel().getColumn(10).setPreferredWidth(40);
        table_diem.getColumnModel().getColumn(11).setPreferredWidth(100);
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                DefaultTableModel model = (DefaultTableModel) table_diem.getModel();
                Grade gra = new Grade(acc.getSdt(),modelDiem.getValueAt(row, 1).toString(),cbBox_hocKy.getSelectedItem().toString());
            
                // Kiểm tra và ép kiểu cho Diemcc
                String diemccValue = model.getValueAt(row, 4).toString();
                if (diemccValue instanceof String) {
                    if (diemccValue.isEmpty()) {
                        gra.setDiemcc(null);
                    } else {
                        try {
                            Float diemccFloat = Float.valueOf(diemccValue);
                            System.out.println(diemccFloat);
                            System.out.println(diemccFloat.floatValue());
                            gra.setDiemcc(diemccFloat);
                        } catch (NumberFormatException e) {
                            gra.setDiemcc(null);
                            JOptionPane.showMessageDialog(null, "Điểm cc là số thực trong khoảng từ 1 đến 10, đéo phải chữ ");
                        } 

                    }
                }
                
                String diemgkValue = model.getValueAt(row, 5).toString();
                if (diemgkValue instanceof String) {
                    String diemgkString = (String) diemgkValue;
                    if (diemgkString.isEmpty()) {
                        gra.setDiemgk(null);
                    } else {
                        try {
                            Float diemgkFloat = Float.valueOf(diemgkString);
                            gra.setDiemgk(diemgkFloat);
                        } catch (NumberFormatException e) {
                            gra.setDiemgk(null);
                            JOptionPane.showMessageDialog(null, "Điểm gk là số thực trong khoảng từ 1 đến 10 ");
                        } 
                    }
                }
                
                String diemckValue = model.getValueAt(row, 6).toString();
                if (diemckValue instanceof String) {
                    String diemckString = (String) diemckValue;
                    if (diemckString.isEmpty()) {
                        gra.setDiemck(null);
                    } else {
                        try {
                            Float diemckFloat = Float.valueOf(diemckString);
                            gra.setDiemck(diemckFloat);
                        } catch (NumberFormatException e) {
                            gra.setDiemck(null);
                            JOptionPane.showMessageDialog(null, "Điểm ck là số thực trong khoảng từ 1 đến 10 ");
                        } 
                    }
                }
                int answer = JOptionPane.showConfirmDialog(null, "Cập nhật điểm cho môn học này?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
                if(answer == 0){
                    if( new DAO_sv().updateGrade(gra)){
                        resetStudyPanel();
                        Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Cập nhật điểm thành công ");
                        noti.showNotification();
                    }
                    else {
                        System.out.println("False when Edit row "+ row);
                    }
                    return;
                }
            }
            @Override
            public void onDelete(int row) {
                if(table_diem.isEditing()){
                    table_diem.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table_diem.getModel();
                Grade gra = new Grade(acc.getSdt(),modelDiem.getValueAt(row, 1).toString(),cbBox_hocKy.getSelectedItem().toString());
                int answer = JOptionPane.showConfirmDialog(null,"Xóa môn học này khỏi bảng điểm của bạn?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
                if(answer == 0){
                    if(new DAO_sv().deleteGrade(gra)){
                        resetStudyPanel();
                        Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Xóa điểm thành công ");
                        noti.showNotification();
                        return;
                    }
                }
                return;
            }
            @Override
            public void onNote(int row) {
                DefaultTableModel model = (DefaultTableModel) table_diem.getModel();
                Grade gra = new Grade(acc.getSdt(),modelDiem.getValueAt(row, 1).toString(),cbBox_hocKy.getSelectedItem().toString());
                sub_updateGhiChu noteView = new sub_updateGhiChu(studyPanel.this, gra);
                noteView.setVisible(true);
                noteView.setLocationRelativeTo(null);
                noteView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        };
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table_diem.setDefaultRenderer(Object.class, centerRenderer);

        JTableHeader header = table_diem.getTableHeader();
        header.setDefaultRenderer(centerRenderer);
        TableColumnModel columnModel = table_diem.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component headerComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    ((JLabel) headerComponent).setHorizontalAlignment(SwingConstants.CENTER);
                    ((JLabel) headerComponent).setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Thay đổi border theo yêu cầu
                    ((JLabel) headerComponent).setBackground(new Color(200,200,200));
                    return headerComponent;
                }
            });
        }

        table_diem.setDefaultRenderer(Object.class, new CenterColumnRenderer());
        table_diem.getColumnModel().getColumn(11).setCellRenderer(new TableActionCellRender());
        table_diem.getColumnModel().getColumn(11).setCellEditor(new TableActionCellEditer(event));
        table_diem.getColumnModel().getColumn(10).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Object valueAtColumn9 = table.getModel().getValueAt(row, 9);
                if (valueAtColumn9 != null &&  valueAtColumn9.toString().equals("")) {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
                    PanelTrong trong = new PanelTrong();
                    if(isSelected == false && row%2 == 0){
                        trong.setBackground(Color.WHITE);
                    }
                    else{
                        trong.setBackground(com.getBackground());
                    }
                    return trong;
                } 
                else if (valueAtColumn9 != null &&  valueAtColumn9.toString().equals("F")){
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    PanelNiem niem = new PanelNiem();
                    if(isSelected == false && row%2 == 0){
                        niem.setBackground(Color.WHITE);
                    }
                    else{
                        niem.setBackground(com.getBackground());
                    }
                    return niem;
                }
                else {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    PanelDat dat = new PanelDat();
                    if(isSelected == false && row%2 == 0){
                        dat.setBackground(Color.WHITE);
                    }
                    else{
                        dat.setBackground(com.getBackground());
                    }
                    return dat;                
                    }                
            }
        });
        fixTable(jScrollPane2);
    }
    
    int sttDiem ;
    public void showTableDiem(){
        if(!dsDiem.isEmpty()){
        sttDiem = 1;
        for (Grade gra : dsDiem) {
            float diemhe4 = 0;
            String diemchu ="";
            if(gra.getDiemtbhe10() == null){
                diemchu ="";
            }
            else if(gra.getDiemtbhe10() < 4.0){
                diemchu = "F";
            }
            else if(gra.getDiemtbhe10() >= 4.0 && gra.getDiemtbhe10() < 5.0){
                diemhe4 = 1.0f;
                diemchu = "D";
            }
            else if(gra.getDiemtbhe10() >= 5.0 && gra.getDiemtbhe10() < 5.5){
                diemhe4 = 1.5f;
                diemchu = "D+";
            }
            else if(gra.getDiemtbhe10() >= 5.5 && gra.getDiemtbhe10() < 6.5){
                diemhe4 = 2.0f;
                diemchu = "C";
            }
            else if(gra.getDiemtbhe10() >= 6.5 && gra.getDiemtbhe10() < 7.0){
                diemhe4 = 2.5f;
                diemchu = "C+";
            }
            else if(gra.getDiemtbhe10() >= 7.0 && gra.getDiemtbhe10() < 8.0){
                diemhe4 = 3.0f;
                diemchu = "B";
            }
            else if(gra.getDiemtbhe10() >= 8.0 && gra.getDiemtbhe10() < 8.5){
                diemhe4 = 3.5f;
                diemchu = "B+";
            }
            else if(gra.getDiemtbhe10() >= 8.5 && gra.getDiemtbhe10() <= 10.0){
                diemhe4 = 4.0f;
                diemchu = "A";
            }

            Object[] rowData = {
            sttDiem++,
            gra.getIdMon(),
            gra.getTenMon(),
            gra.getSotinchi(),
            gra.getDiemcc() != null ? gra.getDiemcc() : "",
            gra.getDiemgk() != null ? gra.getDiemgk() : "",
            gra.getDiemck() != null ? gra.getDiemck() : "",
            gra.getDiemtbhe10() != null ? gra.getDiemtbhe10() : "",
            gra.getDiemtbhe10() != null ? diemhe4 : "",
            diemchu,
            gra.getGhichu()
            };
            modelDiem.addRow(rowData);
        }
    }
    }
    public void showResultDiem(){
        Grade gra = dsDiem.get(dsDiem.size()-1);
        modelDiem.addRow(new Object[]{
            sttDiem++, gra.getIdMon(), gra.getTenMon(), gra.getSotinchi(), gra.getDiemcc(), 
            gra.getDiemgk(), gra.getDiemck(), gra.getDiemtbhe10(), 0, 0, gra.getGhichu()});
    }
    
    public void showKetQua(){
        if(cbBox_hocKy.getItemCount() != 0){
            ketqua = new DAO_sv().getKetQua(acc.getSdt(), cbBox_hocKy.getSelectedItem().toString());
            txt_tinDangKy.setText(String.valueOf(ketqua.getTinDangKy()));
            txt_tinDat.setText(String.valueOf(ketqua.getTinDat()));
            txt_tinNo.setText(String.valueOf(ketqua.getTinNo()));
            txt_diemTBHK.setText(String.valueOf(ketqua.getDiemTbHe10()));
            txt_xepLoai.setText(ketqua.getXepLoai());
            txt_diemHe4.setText(String.valueOf(ketqua.getDiemTbHe4()));
            
            ketquaTichLuy = new DAO_sv().getKetQuaTichLuy(acc.getSdt());
            txt_tl_diemTb10.setText(String.valueOf(ketquaTichLuy.getDiemTbHe10()));
            txt_tl_tongTinDangKy.setText(String.valueOf(ketquaTichLuy.getTinDangKy()));
            txt_tl_soTinDat.setText(String.valueOf(ketquaTichLuy.getTinDat()));
            txt_tl_soTinNo.setText(String.valueOf(ketquaTichLuy.getTinNo()));
        }
    }
    
    public void resetStudyPanel(){
        if(acc.getDsHocKy().isEmpty()){
            btn_addMon.setEnabled(false);
        }
        else {
            btn_addMon.setEnabled(true);
        }
        if(modelDiem != null){
            modelDiem.setRowCount(0);
            if(cbBox_hocKy.getItemCount() != 0){
                this.dsDiem = new DAO_sv().getGradeList1svByhocKy(acc.getSdt(), cbBox_hocKy.getSelectedItem().toString());
            }
            modelDiem = (DefaultTableModel) table_diem.getModel();
            modelDiem.setColumnIdentifiers(new Object[]{
                "STT", "Mã môn", "Tên môn", "Số tín chỉ", "Điểm CC", "Điểm GK", 
                "Điểm CK", "Điểm TB môn", "Điểm hệ 4", "Điểm chữ", "Đạt", "Tùy chỉnh"});
            setTableDiem();
            showTableDiem();
            showKetQua();
        }
    }
        
        public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        //scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addMon;
    private javax.swing.JComboBox<String> cbBox_hocKy;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_diem;
    private javax.swing.JTextField txt_diemHe4;
    private javax.swing.JTextField txt_diemTBHK;
    private UI.searchBar.TextFieldSearchOption txt_search;
    private javax.swing.JTextField txt_tinDangKy;
    private javax.swing.JTextField txt_tinDat;
    private javax.swing.JTextField txt_tinNo;
    private javax.swing.JTextField txt_tl_diemTb10;
    private javax.swing.JTextField txt_tl_soTinDat;
    private javax.swing.JTextField txt_tl_soTinNo;
    private javax.swing.JTextField txt_tl_tongTinDangKy;
    private javax.swing.JTextField txt_xepLoai;
    // End of variables declaration//GEN-END:variables
    public ArrayList< String> getDsDiem(){
        ArrayList<String> ds =new ArrayList<>();
        for (Grade gra : this.dsDiem) {
            ds.add(gra.getTenMon());
        }
        return ds;
    }
    
    public javax.swing.JComboBox<String> GetCBBoxHK(){
        return cbBox_hocKy;
    }
}
