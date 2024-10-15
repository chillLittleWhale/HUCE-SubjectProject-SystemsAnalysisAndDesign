
package view;

import UI.main.User_view;
import javax.swing.*;
import controller.DAO_sv;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
public class sign_up extends javax.swing.JFrame {

    private boolean condition_1;
    private boolean condition_2;
    private boolean condition_3;
    public sign_up() {
        initComponents();
        this.setLocationRelativeTo(null);
        txt_sdt.setLabelText("Số điện thoại:");
        txt_email.setLabelText("Email:");
        txt_mk.setLabelText("Mật khẩu:");
        txt_xacNhanmk.setLabelText("Xác nhận mật khẩu:");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_sdt = new model.TextField();
        txt_mk = new model.PasswordField();
        txt_xacNhanmk = new model.PasswordField();
        txt_email = new model.TextField();
        checkBox_dieuKhoan = new javax.swing.JCheckBox();
        btn_dangKi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        label_dangNhap = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang đăng kí");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_mk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mkKeyReleased(evt);
            }
        });

        checkBox_dieuKhoan.setText("I accept the Terms of Use & Privacy Policy.");
        checkBox_dieuKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_dieuKhoanActionPerformed(evt);
            }
        });

        btn_dangKi.setText("Đăng kí");
        btn_dangKi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dangKiMouseClicked(evt);
            }
        });
        btn_dangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangKiActionPerformed(evt);
            }
        });
        btn_dangKi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_dangKiKeyPressed(evt);
            }
        });

        jLabel1.setText("Đã có tài khoản ?");

        label_dangNhap.setForeground(new java.awt.Color(0, 102, 255));
        label_dangNhap.setText("Đăng nhập");
        label_dangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_dangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_dangNhapMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setText("Sign up");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_dangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_xacNhanmk, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(txt_mk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(btn_dangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(checkBox_dieuKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txt_xacNhanmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(checkBox_dieuKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_dangKi)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_dangNhap))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangKiActionPerformed
        
        if(this.isVisible()){
            String mk = new String(txt_mk.getPassword());
            String xnmk = new String(txt_xacNhanmk.getPassword());
            if(txt_sdt.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Số điện thoại không được để trống");
            }
            else if(txt_sdt.getText().length() != 10){
                JOptionPane.showMessageDialog(rootPane, "Số điện thoại không đúng định dạng");
            }
            else if(mk.equals("")){
                JOptionPane.showMessageDialog(rootPane, " Mật khẩu không được để trống");
            }
            else if(!condition_1 || !condition_2 || !condition_3){
                JOptionPane.showMessageDialog(rootPane, "Mật khẩu cần tối thiểu 5 ký tự, bao gồm cả chữ in hoa và số");
            }            
            else if(xnmk.equals("")){
                JOptionPane.showMessageDialog(rootPane, " Bạn cần xác nhận lại mật khẩu");
            }
            else if(!mk.equals(xnmk)){
                JOptionPane.showMessageDialog(rootPane, "Mật khẩu không trùng khớp");
            }
            else if(txt_email.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Email không được để trống");
            }
            else if(!txt_email.getText().matches("[A-Za-z0-9]+@huce\\.edu\\.vn")){
                JOptionPane.showMessageDialog(this, "Email không thuộc trường Đại học Xây Dựng Hà Nội!");
            }
            else if(!checkBox_dieuKhoan.isSelected()){
                JOptionPane.showMessageDialog(rootPane, " Bạn chưa đồng ý các điều khoản");
            }
            else{
                Account acc = new Account(txt_sdt.getText(),mk, txt_email.getText());
                if( new DAO_sv().addAccount(acc)){
                    JOptionPane.showMessageDialog(rootPane, "Đăng ký thành công");
                    User_view svView = null;
                    try {
                        svView = new User_view(new DAO_sv().getAccBySdt(acc.getSdt( )));
                    } catch (SQLException ex) {
                        Logger.getLogger(log_in.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    svView.setVisible(true);
                    svView.setLocationRelativeTo(null);
                    svView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();                    
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Số điện thoại này đã được đăng ký");
                }
            } 
        }
    }//GEN-LAST:event_btn_dangKiActionPerformed

    private void checkBox_dieuKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_dieuKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBox_dieuKhoanActionPerformed

    private void label_dangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_dangNhapMouseClicked
        log_in liform = new log_in();
        liform.setVisible(true);
        liform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_label_dangNhapMouseClicked

    private void btn_dangKiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangKiMouseClicked
        
    }//GEN-LAST:event_btn_dangKiMouseClicked

    private void btn_dangKiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_dangKiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dangKiKeyPressed

    private void txt_mkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mkKeyReleased
        String password = String.valueOf(txt_mk.getPassword());
        boolean containsUppercase = false;
        boolean containsDigit = false;
        if(password.length() > 4){
            condition_1 = true ;
        }
        else {
            condition_1 = false;
        }
        
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                containsUppercase = true;
            }
            if (Character.isDigit(ch)) {
                containsDigit = true;
            }
        }
        
        if (containsDigit) {
            condition_2 = true;
        } else {
            condition_2 = false;
        }
        
        if (containsUppercase) {
            condition_3 = true;
        } else {
            condition_3 = false;
        }
    }//GEN-LAST:event_txt_mkKeyReleased

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
            java.util.logging.Logger.getLogger(sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangKi;
    private javax.swing.JCheckBox checkBox_dieuKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_dangNhap;
    private model.TextField txt_email;
    private model.PasswordField txt_mk;
    private model.TextField txt_sdt;
    private model.PasswordField txt_xacNhanmk;
    // End of variables declaration//GEN-END:variables
}
