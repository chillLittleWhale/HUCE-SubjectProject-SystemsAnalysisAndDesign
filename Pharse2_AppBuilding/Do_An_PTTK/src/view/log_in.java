package view;

import model.*;
import controller.*;
import java.util.*;
import javax.swing.*;
import UI.main.User_view;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class log_in extends javax.swing.JFrame {

    private ArrayList< Account> dstk;
    private String sdtStr = ""; 
    public log_in() {
        initComponents();
        this.setLocationRelativeTo(null);
        dstk = new DAO_sv().getAccList();
        txt_mk.setLabelText("Mật khẩu:");
        txt_sdt.setLabelText("Tài khoản:");
        this.getRootPane().setDefaultButton(btn_dangNhap);
    }

    public void setSdt(String sdt){
        this.sdtStr = sdt;
        txt_sdt.setText(sdt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_dangNhap = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        label_dangKi = new javax.swing.JLabel();
        label_quenmk = new javax.swing.JLabel();
        txt_mk = new model.PasswordField();
        txt_sdt = new model.TextField();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang đăng nhập");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setText("Log In");

        btn_dangNhap.setText("Đăng nhập");
        btn_dangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_dangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dangNhapMouseClicked(evt);
            }
        });
        btn_dangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangNhapActionPerformed(evt);
            }
        });

        jLabel6.setText("Chưa có tài khoản ?");

        label_dangKi.setForeground(new java.awt.Color(0, 102, 255));
        label_dangKi.setText("Đăng kí ngay");
        label_dangKi.setBorder(null);
        label_dangKi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_dangKi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_dangKiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_dangKiMouseEntered(evt);
            }
        });

        label_quenmk.setForeground(new java.awt.Color(0, 102, 255));
        label_quenmk.setText("Quên mật khẩu ?");
        label_quenmk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_quenmk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_quenmkMouseClicked(evt);
            }
        });

        txt_mk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_mkFocusLost(evt);
            }
        });

        txt_sdt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_sdtFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_quenmk, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btn_dangNhap)
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_dangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_quenmk, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_dangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dangKi)
                    .addComponent(jLabel6))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_dangKiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_dangKiMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_label_dangKiMouseEntered

    private void label_dangKiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_dangKiMouseClicked
        sign_up suform = new sign_up();
        suform.setVisible(true);
        suform.setLocationRelativeTo(null);
        suform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_label_dangKiMouseClicked

    private void btn_dangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangNhapActionPerformed
        if(this.isVisible()){
            String passwordStr = new String(txt_mk.getPassword());

            if(sdtStr.length() == 0){
                JOptionPane.showMessageDialog(rootPane, "vui lòng nhập số điện thoại");
                return;
            }
            else if(passwordStr.length() == 0){
                JOptionPane.showMessageDialog(rootPane, "vui lòng nhập mật khẩu");
                return;
            }
            else{
                int ok = 0;
                for (Account account : dstk) {
                    if( account.getSdt().equals(sdtStr)
                        && account.getMk().equals(passwordStr)){
                        ok =1;
                        if(account.getRole().equals("admin")){
                            Admin_view adView = new Admin_view();
                            adView.setVisible(true);
                            adView.setLocationRelativeTo(null);
                            adView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            this.dispose();
                            break;
                        }
                        else{
                            User_view svView = null;
                            try {
                                svView = new User_view(new DAO_sv().getAccBySdt(account.getSdt( )));
                            } catch (SQLException ex) {
                                Logger.getLogger(log_in.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            svView.setVisible(true);
                            svView.setLocationRelativeTo(null);
                            svView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            this.dispose();
                            break;
                        }
                    }
                }
                if(ok == 0){
                    JOptionPane.showMessageDialog(rootPane, "tài khoản hoặc mật khẩu không chính xác");
                    return;
                }
            }
        }
    }//GEN-LAST:event_btn_dangNhapActionPerformed

    private void btn_dangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangNhapMouseClicked

    }//GEN-LAST:event_btn_dangNhapMouseClicked

    private void label_quenmkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_quenmkMouseClicked
        sdtStr = txt_sdt.getText();
        F_fogotPassWord fpwform = new F_fogotPassWord();
        fpwform.setAccSdt(sdtStr);
        fpwform.setLocationRelativeTo(null);
        fpwform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fpwform.setVisible(true);
    }//GEN-LAST:event_label_quenmkMouseClicked

    private void txt_sdtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_sdtFocusLost
        sdtStr = txt_sdt.getText();
    }//GEN-LAST:event_txt_sdtFocusLost

    private void txt_mkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mkFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mkFocusLost

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
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new log_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangNhap;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_dangKi;
    private javax.swing.JLabel label_quenmk;
    private model.PasswordField txt_mk;
    private model.TextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
