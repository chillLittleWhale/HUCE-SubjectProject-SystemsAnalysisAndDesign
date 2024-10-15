package UI.main;

import UI.component.Header;
import UI.component.Menu;
import UI.event.EventMenuSelected;
import UI.event.EventShowPopupMenu;
import UI.panels.*;
import UI.component.MainForm;
import UI.swing.MenuItem;
import UI.swing.PopupMenu;
import controller.DAO_sv;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Account;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import view.log_in;

public class User_view extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    private Account acc;
    private JFrame view;
    public User_view( Account acc) throws SQLException {
        initComponents();
        this.acc = acc;
        this.view = this;
        init();
    }

    private void init() throws SQLException {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header(acc);
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                        try {
                            main.showForm(new homePanel(acc, User_view.this));
                        } catch (SQLException ex) {
                            Logger.getLogger(User_view.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                else if( menuIndex == 1){                   
                    if(subMenuIndex == 0){
                        try {
                            main.showForm(new infoPanel(new DAO_sv().getAccBySdt(acc.getSdt())));
                        } catch (SQLException ex) {
                            Logger.getLogger(User_view.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(User_view.class.getName()).log(Level.SEVERE, null, ex);
                        }                        
                    }
                    else if(subMenuIndex == 1){
                        try {
                            main.showForm(new infoChangePanel(new DAO_sv().getAccBySdt(acc.getSdt()), header));
                        } catch (SQLException ex) {
                            Logger.getLogger(User_view.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(User_view.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else if( menuIndex == 2){
                    try {
                        main.showForm(new rankPanel(new DAO_sv().getAccBySdt(acc.getSdt())));
                    } catch (SQLException ex) {
                        Logger.getLogger(User_view.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if( menuIndex == 3){
                        main.showForm(new studyPanel(new DAO_sv().getAccBySdt(acc.getSdt()),view));      
                }
                else if( menuIndex == 4){
                    if(subMenuIndex == -1){
                        main.showForm(new chartPanel(new DAO_sv().getAccBySdt(acc.getSdt())));
                    }
                }
                else if( menuIndex == 5){
                    if(subMenuIndex == 1){
                        main.showForm(new settingPanel(new DAO_sv().getAccBySdt(acc.getSdt()), User_view.this));
                    }
                    else if(subMenuIndex == 0){
                        int dangxuat = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát ?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
                        if(dangxuat == 0){
                            log_in liform = new log_in();
                            liform.setVisible(true);
                            liform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            User_view.this.dispose();
                        }
                    }                    
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(User_view.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = User_view.this.getX() + 52;
                int y = User_view.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 200!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (140 * (1f - fraction));
                } else {
                    width = 60 + (140 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.HideAllMenu();
                }
            }
        });
        //  Start with this form
        main.showForm(new homePanel(acc, User_view.this));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 625));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(1100, 569));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(User_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String sdt = "0813988966";
                Account sv = new DAO_sv().getAccBySdt(sdt);
                try {
                    new User_view( sv).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(User_view.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
    public MainForm getMainForm(){
        return this.main;
    }
}
