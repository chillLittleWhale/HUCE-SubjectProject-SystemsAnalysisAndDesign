package UI.panels;

import controller.DAO_sv;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Account;
import nofitication.Notification;

public class settingPanel extends javax.swing.JPanel {

    private Account acc;
    private JFrame frame;
    public settingPanel(Account acc, JFrame frame) {
        initComponents();
        this.acc = acc;
        this.frame = frame;
        txt_newpass.setLabelText("Nhập mật khẩu mới");
        txt_xacthuc.setLabelText("Nhập lại mật khẩu");
        txt_canhbao.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_newpass = new model.TextField();
        txt_xacthuc = new model.TextField();
        tbn = new javax.swing.JButton();
        cbb_condition_1 = new javax.swing.JCheckBox();
        cbb_condition_2 = new javax.swing.JCheckBox();
        cbb_condition_3 = new javax.swing.JCheckBox();
        txt_canhbao = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1025, 466));

        txt_newpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_newpassKeyReleased(evt);
            }
        });

        tbn.setText("Thay đổi");
        tbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnActionPerformed(evt);
            }
        });

        cbb_condition_1.setForeground(new java.awt.Color(153, 153, 153));
        cbb_condition_1.setText("Có độ dài ít nhất 5 ký tự");
        cbb_condition_1.setEnabled(false);

        cbb_condition_2.setForeground(new java.awt.Color(153, 153, 153));
        cbb_condition_2.setText("Mật khẩu bao gồm ký tự số");
        cbb_condition_2.setEnabled(false);

        cbb_condition_3.setForeground(new java.awt.Color(153, 153, 153));
        cbb_condition_3.setText("Mật khẩu bao gồm ký tự in hoa");
        cbb_condition_3.setEnabled(false);

        txt_canhbao.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        txt_canhbao.setForeground(new java.awt.Color(255, 51, 51));
        txt_canhbao.setText("*Mật khẩu không trùng khớp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_xacthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_condition_1)
                            .addComponent(cbb_condition_2)
                            .addComponent(cbb_condition_3)
                            .addComponent(txt_canhbao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(tbn)))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txt_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_xacthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_canhbao)
                .addGap(39, 39, 39)
                .addComponent(cbb_condition_1)
                .addGap(18, 18, 18)
                .addComponent(cbb_condition_2)
                .addGap(18, 18, 18)
                .addComponent(cbb_condition_3)
                .addGap(44, 44, 44)
                .addComponent(tbn)
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnActionPerformed
        if(!cbb_condition_1.isSelected() || !cbb_condition_2.isSelected() || !cbb_condition_3.isSelected()){
            JOptionPane.showMessageDialog(null, "Mật khẩu chưa đúng định dạng");
            return;
        }
        String password = String.valueOf(txt_newpass.getText());
        String confirmPw = String.valueOf(txt_xacthuc.getText());
        if( !password.equals(confirmPw)){
            JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp");
            return;
        }
        else {
            acc.setMk(confirmPw);
            if(new DAO_sv().updateSinhVien(acc)){
                Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Thay đổi mật khẩu thành công ");
                noti.showNotification();
            }
            else{
                Notification noti = new Notification(frame, Notification.Type.FALSE, Notification.Location.TOP_CENTER, "Thay đổi mật khẩu không thành công ");
                noti.showNotification();
            }
        }
    }//GEN-LAST:event_tbnActionPerformed

    private void txt_newpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_newpassKeyReleased
        String password = String.valueOf(txt_newpass.getText());
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
    }//GEN-LAST:event_txt_newpassKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbb_condition_1;
    private javax.swing.JCheckBox cbb_condition_2;
    private javax.swing.JCheckBox cbb_condition_3;
    private javax.swing.JButton tbn;
    private javax.swing.JLabel txt_canhbao;
    private model.TextField txt_newpass;
    private model.TextField txt_xacthuc;
    // End of variables declaration//GEN-END:variables
}
