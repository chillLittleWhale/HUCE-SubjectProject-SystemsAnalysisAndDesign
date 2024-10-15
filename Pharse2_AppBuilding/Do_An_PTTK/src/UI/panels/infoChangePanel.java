package UI.panels;

import UI.component.Header;
import controller.DAO_admin;
import controller.DAO_sv;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Account;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clas;
import model.Majors;

public class infoChangePanel extends javax.swing.JPanel {

    Account acc;
    byte[] photo = null;
    private Header header;
    private ArrayList< Clas> dsLop =new ArrayList<>();
    private ArrayList< Majors> dsNganh =new ArrayList<>();
    public infoChangePanel(Account acc, Header header) throws SQLException, IOException {
        initComponents();
        this.acc = new DAO_sv().getAccBySdt(acc.getSdt());
        this.header = header;
        dsLop = new DAO_admin().getClasList();
        for (Clas uni : dsLop) { 
            cbBox_lop.addItem(uni.getTenLop()); 
        }
        dsNganh = new DAO_admin().getMajList();
        for (Majors maj : dsNganh) { 
            cbBox_nganh.addItem(maj.getTenNganh()); 
        }
        txt_name.setText(acc.getName());
        cbBox_lop.setSelectedItem(acc.getLop());
        cbBox_nganh.setSelectedItem(acc.getNganh());
        txt_email.setText(acc.getEmail());
        txt_dob.setText(acc.getNgaySinh().toString());
        txt_quequan.setText(acc.getQueQuan());
        if(acc.getGioiTinh()== true){
            checkBox_nam.setSelected(true);
        } else {
            checkBox_nu.setSelected(true);
        }
        if(acc.getAvatarImageIcon() != null){
                Image image = acc.getAvatarImageIcon().getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                lb_imgUp.setIcon(icon);
        }
//        ImageIcon avatarIcon = acc.getAvatarImageIcon();
//        if (avatarIcon != null) {
//            try {
//                Image image = acc.getAvatarImageIcon().getImage().getScaledInstance(lb_imgUp.getWidth(), lb_imgUp.getHeight(), Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(image);
//                lb_imgUp.setIcon(icon);
//            } catch (SQLException ex) {
//                Logger.getLogger(infoPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            // Xử lý khi avatarIcon là null: đ làm gì cả
//        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        lb_imgUp = new model.CustomLabel();
        btn_upImg = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        lb_imgPath = new javax.swing.JLabel();
        txt_imgPath = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_dob = new javax.swing.JTextField();
        txt_quequan = new javax.swing.JTextField();
        cbBox_lop = new javax.swing.JComboBox<>();
        checkBox_nam = new javax.swing.JCheckBox();
        checkBox_nu = new javax.swing.JCheckBox();
        cbBox_nganh = new javax.swing.JComboBox<>();
        btn_dateChoose = new javax.swing.JButton();

        dateChooser1.setForeground(new java.awt.Color(121, 164, 241));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txt_dob);

        setBackground(new java.awt.Color(255, 255, 255));

        lb_imgUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_upImg.setText("Upload Img");
        btn_upImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upImgActionPerformed(evt);
            }
        });

        btn_save.setText("Lưu");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        lb_imgPath.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb_imgPath.setText("Path:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Họ tên :");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Lớp :");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Ngành  :");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Email :");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Ngày sinh :");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("Quê quán :");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Giới tính :");

        cbBox_lop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

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

        cbBox_nganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbBox_nganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBox_nganhActionPerformed(evt);
            }
        });

        btn_dateChoose.setText("...");
        btn_dateChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dateChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBox_nam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBox_nu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE))
                            .addComponent(txt_name)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBox_nganh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbBox_lop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_quequan)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_dob)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_dateChoose))
                            .addComponent(txt_email))))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(checkBox_nam)
                    .addComponent(checkBox_nu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dateChoose))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_quequan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbBox_nganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbBox_lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_imgPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_imgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_imgUp, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_upImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_imgUp, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_imgPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_imgPath))
                .addGap(18, 18, 18)
                .addComponent(btn_upImg)
                .addGap(59, 59, 59)
                .addComponent(btn_save)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_upImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upImgActionPerformed
        JFileChooser browseImgFile = new JFileChooser();
        // tạo định dạng
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpn", "jpeg");
        browseImgFile.addChoosableFileFilter(fnef);
        int showOpenDialog = browseImgFile.showOpenDialog(null);
        
        if(showOpenDialog == JFileChooser.APPROVE_OPTION){
            File selectedImgFile = browseImgFile.getSelectedFile();
            String selectedImgPath = selectedImgFile.getAbsolutePath();
            // hiện ảnh lên lable
            ImageIcon ii = new ImageIcon(selectedImgPath);
            // resize ảnh cho vừa lable
            Image image = ii.getImage().getScaledInstance(lb_imgUp.getWidth(), lb_imgUp.getHeight(), Image.SCALE_SMOOTH);
            lb_imgUp.setIcon(new ImageIcon(image));
            txt_imgPath.setText(selectedImgPath);
            try {
                File imageFile = new File(selectedImgPath);
                FileInputStream fis = new FileInputStream(imageFile);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum= fis.read(buf)) != -1;){
                    bos.write(buf, 0, readNum);
                }
                photo = bos.toByteArray();
            } catch (Exception e) {
            }
        }        
    }//GEN-LAST:event_btn_upImgActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(photo != null){
            if(new DAO_sv().updateAccImg(acc, photo)){
                //JOptionPane.showMessageDialog(null, "saved !"); 
                try {
                    header.updateAvatar();
                } catch (SQLException ex) {
                    Logger.getLogger(infoChangePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật avatar !"); 
                return;
            }
        }
        // cập nhật thông tin
        if(!txt_email.getText().matches("[A-Za-z0-9]+@huce\\.edu\\.vn")){
            JOptionPane.showMessageDialog(this, "Email không thuộc trường Đại học Xây Dựng Hà Nội!");
            return;
        }

        Account accc = new DAO_sv().getAccBySdt(acc.getSdt());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = dateFormat.parse(txt_dob.getText());
            accc.setNgaySinh(new java.sql.Date(utilDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật ngày sinh");
            return;
        }
        accc.setName(txt_name.getText());
        accc.setGioiTinh( checkBox_nam.isSelected());
        accc.setQueQuan(txt_quequan.getText());
        accc.setNganh(cbBox_nganh.getSelectedItem().toString());
        accc.setLop(cbBox_lop.getSelectedItem().toString());
        accc.setSdt(this.acc.getSdt());
        accc.setEmail(txt_email.getText());
        if(new DAO_sv().updateSinhVien( accc)){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!"); 
        }  
               
    }//GEN-LAST:event_btn_saveActionPerformed

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

    private void btn_dateChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dateChooseActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_btn_dateChooseActionPerformed

    private void cbBox_nganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBox_nganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBox_nganhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dateChoose;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_upImg;
    private javax.swing.JComboBox<String> cbBox_lop;
    private javax.swing.JComboBox<String> cbBox_nganh;
    private javax.swing.JCheckBox checkBox_nam;
    private javax.swing.JCheckBox checkBox_nu;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_imgPath;
    private model.CustomLabel lb_imgUp;
    private javax.swing.JTextField txt_dob;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_imgPath;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_quequan;
    // End of variables declaration//GEN-END:variables
}
