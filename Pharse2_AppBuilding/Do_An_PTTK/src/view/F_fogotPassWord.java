package view;

import model.*;
import controller.*;
import java.util.*;
import javax.swing.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class F_fogotPassWord extends javax.swing.JFrame {
    private String accsdt;
    private String accEmail;
    private ArrayList< Account> dstk;
    private Integer vericode;
    
    public void setAccSdt(String accsdt){
        this.accsdt = accsdt;
        txt_sdt.setText(accsdt);
    }
    public F_fogotPassWord() {
        initComponents();
        this.vericode = 111111;
        this.setLocationRelativeTo(null);
        dstk = new DAO_sv().getAccList();
        lb_verfi.setVisible(false);
        txt_code.setVisible(false);
        btn_continue.setVisible(false);        
    }
    
    public void createVeriCode(){
        Random ran = new Random();
        this.vericode = ran.nextInt(100000);
    }

    public boolean sentEmail( String userEmail, int maXacThuc){
        // tài khoản, mật khẩu của admin
        final String adminEmail = "fatroll74@gmail.com";
        final String appPassword = "iarxovobqpdmgnzm";

        // khởi tạo thông số cấu hình
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", "587");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        // tạo 1 phiên đăng nhập ngầm vào gmail của admin để xác thực gmail
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(adminEmail, appPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(adminEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(accEmail)
            );
            message.setSubject("Lấy lại mật khẩu app SV Who Care");
            message.setText("Vui lòng nhập mã xác thực để lấy lại mật khẩu của bạn. \n"
                    + "Mã xác thực của bạn là: "+maXacThuc +"\n\n"
                    //+"Anh Long 1 đời liêm khiết"
            );

            Transport.send(message);

            System.out.println("Done");
            JOptionPane.showMessageDialog(rootPane, "Mã xác thực đã được gửi đến Email: "+accEmail );

        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Gửi code không thành công");
            return false;
        }
        return true;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_sentCode = new javax.swing.JButton();
        txt_sdt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lb_verfi = new javax.swing.JLabel();
        txt_code = new javax.swing.JTextField();
        btn_continue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang lấy lại mật khẩu");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setText("Fogot  PassWord");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Enter your email address");

        btn_sentCode.setText("sent code");
        btn_sentCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sentCodeMouseClicked(evt);
            }
        });
        btn_sentCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sentCodeActionPerformed(evt);
            }
        });

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        jLabel3.setText("Phone number:");

        lb_verfi.setText("Verification code:");

        btn_continue.setText("continue");
        btn_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_continueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_verfi)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_continue))))
                .addGap(110, 145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sentCode)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_verfi)
                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_continue)
                .addContainerGap(20, Short.MAX_VALUE))
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

    public int getVericode() {
        return vericode;
    }
    public void setVericode(int vericode) {
        this.vericode = vericode;
    }
    
    private void btn_sentCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sentCodeActionPerformed
        if(this.isVisible()){
            if(txt_sdt.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Nhập sdt của bạn");
                return;
            } 

            accsdt = txt_sdt.getText();
            boolean ok = false;
            for (Account account : dstk) {
                if(account.getSdt().equals(accsdt) ){
                    ok = true;
                }
            }
            if( ok == false){
                JOptionPane.showMessageDialog(rootPane,"Số điện thoại bạn đã nhập chưa đăng ký tài khoản" );
                return;
            }

            Account acc = new DAO_sv().getAccBySdt(accsdt);
            accEmail = acc.getEmail();
            createVeriCode();
            if(sentEmail(acc.getEmail(), vericode)){
                lb_verfi.setVisible(true);
                txt_code.setVisible(true);
                btn_continue.setVisible(true);
            }
        }
    }//GEN-LAST:event_btn_sentCodeActionPerformed

    private void btn_sentCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sentCodeMouseClicked
        
    }//GEN-LAST:event_btn_sentCodeMouseClicked

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void btn_continueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_continueActionPerformed
        accsdt = txt_sdt.getText();
        if(this.isVisible()){
            if(txt_code.getText().toString().equals(vericode.toString())){
                F_resetPassword rsPw = new F_resetPassword(accsdt);
                rsPw.setVisible(true);
                rsPw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane,
                        "Bạn hãy gửi lại mã xác thực", "Mã xác thực không trùng khớp", 
                        JOptionPane.WARNING_MESSAGE);
            }                
        }
    }//GEN-LAST:event_btn_continueActionPerformed

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
            java.util.logging.Logger.getLogger(F_fogotPassWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_fogotPassWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_fogotPassWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_fogotPassWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_fogotPassWord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_continue;
    private javax.swing.JButton btn_sentCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_verfi;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
