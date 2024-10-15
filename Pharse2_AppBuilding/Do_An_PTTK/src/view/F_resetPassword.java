package view;

import controller.DAO_sv;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Account;

public class F_resetPassword extends javax.swing.JFrame {

    private String accsdt ;
    public F_resetPassword(String accsdt) {
        initComponents();
        this.accsdt = accsdt;
        txt_mk.setLabelText("Mật khẩu:");
        txt_xacNhanmk.setLabelText("Xác nhận mật khẩu:");
        txt_canhbao.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_mk = new model.PasswordField();
        txt_xacNhanmk = new model.PasswordField();
        cbb_condition_1 = new javax.swing.JCheckBox();
        cbb_condition_3 = new javax.swing.JCheckBox();
        cbb_condition_2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        btn_confirm = new javax.swing.JButton();
        txt_canhbao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_mk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mkKeyReleased(evt);
            }
        });

        txt_xacNhanmk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_xacNhanmkFocusLost(evt);
            }
        });

        cbb_condition_1.setForeground(new java.awt.Color(153, 153, 153));
        cbb_condition_1.setText("Có độ dài ít nhất 5 ký tự");
        cbb_condition_1.setEnabled(false);

        cbb_condition_3.setForeground(new java.awt.Color(153, 153, 153));
        cbb_condition_3.setText("Mật khẩu bao gồm ký tự in hoa");
        cbb_condition_3.setEnabled(false);

        cbb_condition_2.setForeground(new java.awt.Color(153, 153, 153));
        cbb_condition_2.setText("Mật khẩu bao gồm ký tự số");
        cbb_condition_2.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đặt lại mật khẩu");

        btn_confirm.setText("Xác nhận");
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });

        txt_canhbao.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        txt_canhbao.setForeground(new java.awt.Color(255, 51, 51));
        txt_canhbao.setText("*Mật khẩu không trùng khớp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_condition_3)
                            .addComponent(cbb_condition_2)
                            .addComponent(cbb_condition_1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_xacNhanmk, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addComponent(txt_mk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txt_canhbao))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_confirm)
                        .addGap(189, 189, 189))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addGap(0, 166, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_xacNhanmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_canhbao)
                .addGap(18, 18, 18)
                .addComponent(cbb_condition_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_condition_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_condition_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btn_confirm)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_mkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mkKeyReleased
        String password = String.valueOf(txt_mk.getPassword());
        boolean containsUppercase = false;
        boolean containsDigit = false;
        if(password.length() > 4){
            cbb_condition_1.setSelected(true);
            cbb_condition_1.setForeground(Color.black);
        }
        else {
            cbb_condition_1.setSelected(false);
            cbb_condition_1.setForeground(new Color(153,153,153));
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
            cbb_condition_2.setSelected(true);
            cbb_condition_2.setForeground(Color.BLACK);
        } else {
            cbb_condition_2.setSelected(false);
            cbb_condition_2.setForeground(new Color(153, 153, 153));
        }
        
        if (containsUppercase) {
            cbb_condition_3.setSelected(true);
            cbb_condition_3.setForeground(Color.BLACK);
        } else {
            cbb_condition_3.setSelected(false);
            cbb_condition_3.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txt_mkKeyReleased

    private void txt_xacNhanmkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_xacNhanmkFocusLost
        String password = String.valueOf(txt_mk.getPassword());
        String confirmPw = String.valueOf(txt_xacNhanmk.getPassword());
        if( !password.equals(confirmPw)){
            txt_canhbao.setVisible(true);
        }
        else{
            txt_canhbao.setVisible(false);
        }
    }//GEN-LAST:event_txt_xacNhanmkFocusLost

    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        if(!cbb_condition_1.isSelected() || !cbb_condition_2.isSelected() || !cbb_condition_3.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu chưa đúng định dạng");
            return;
        }
        String password = String.valueOf(txt_mk.getPassword());
        String confirmPw = String.valueOf(txt_xacNhanmk.getPassword());
        if( !password.equals(confirmPw)){
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu không trùng khớp");
            return;
        }
        else {
            Account acc = new DAO_sv().getAccBySdt(accsdt);
            acc.setMk( String.valueOf(txt_mk.getPassword()) );
            if(new DAO_sv().updateSinhVien(acc)){
                log_in liform = new log_in();
                liform.setSdt(accsdt);
                liform.setVisible(true);
                liform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btn_confirmActionPerformed

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
            java.util.logging.Logger.getLogger(F_resetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_resetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_resetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_resetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new F_resetPassword().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_confirm;
    private javax.swing.JCheckBox cbb_condition_1;
    private javax.swing.JCheckBox cbb_condition_2;
    private javax.swing.JCheckBox cbb_condition_3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_canhbao;
    private model.PasswordField txt_mk;
    private model.PasswordField txt_xacNhanmk;
    // End of variables declaration//GEN-END:variables
}
