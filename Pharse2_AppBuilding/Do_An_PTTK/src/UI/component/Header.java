package UI.component;

import UI.panels.rankPanel;
import UI.searchBar.SearchOption;
import UI.searchBar.SearchOptionEvent;
import UI.swing.PanelTransparent;
import controller.DAO_sv;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Account;

public class Header extends PanelTransparent {

    Account acc;
    rankPanel rankPN;
    public Header(Account acc) throws SQLException {
        initComponents();
        this.acc = acc;
        setTransparent(0.5f);
        if(acc.getAvatarImageIcon() != null){
            Image image = acc.getAvatarImageIcon().getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            pic.setIcon(icon);
        }

        lbUserName.setText(acc.getName());
        
        txt_search.addEventOptionSelected(new SearchOptionEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txt_search.setHint("Search by " + option.getName() + "...");
            }
        });
        txt_search.addOption(new SearchOption("User name", new ImageIcon(getClass().getResource("/icon/name-25.png"))));
        txt_search.addOption(new SearchOption("Grade", new ImageIcon(getClass().getResource("/icon/grade-25.png"))));
        txt_search.addOption(new SearchOption("Class", new ImageIcon(getClass().getResource("/icon/university-25.png"))));
        txt_search.addOption(new SearchOption("City", new ImageIcon(getClass().getResource("/icon/city-25.png"))));
    
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    public void updateAvatar() throws SQLException{
        this.acc = new DAO_sv().getAccBySdt(acc.getSdt());
        if(acc.getAvatarImageIcon() != null){
            Image image = acc.getAvatarImageIcon().getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            pic.setIcon(icon);
        }
        lbUserName.setText(acc.getName());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new UI.swing.Button();
        pic = new UI.swing.ImageAvatar();
        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonBadges1 = new UI.swing.ButtonBadges();
        buttonBadges2 = new UI.swing.ButtonBadges();
        txt_search = new UI.searchBar.TextFieldSearchOption();

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu-45.png"))); // NOI18N

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/avartar_male-100.png"))); // NOI18N

        lbUserName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(153, 153, 153));
        lbUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserName.setText("User name");

        lbRole.setForeground(new java.awt.Color(153, 153, 153));
        lbRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbRole.setText("User");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonBadges1.setForeground(new java.awt.Color(103, 153, 255));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/email-25.png"))); // NOI18N
        buttonBadges1.setBadges(5);

        buttonBadges2.setForeground(new java.awt.Color(255, 102, 102));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bell-35.png"))); // NOI18N
        buttonBadges2.setBadges(88);

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lbRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbUserName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbRole))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
//        if(txt_search.isSelected()){
//            int option = txt_search.getSelectedIndex();
//            if(option == 0){ // tìm theo tên
//                
//            }
//            else if(option == 1){ // tìm theo điểm
//                
//            }
//            else if(option == 2){ // tìm theo trường
//                
//            }
//            else if(option == 3){ // tìm theo tỉnh
//                System.out.println(option);
//                JTable table1 = rankPN.getTable();
//    String keyword = txt_search.getText().toLowerCase();  // lấy giá trị từ ô search
//    DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
//    
//    // Tạo một DefaultRowSorter với DefaultTableModel
//    DefaultRowSorter<DefaultTableModel, Integer> sorter = new TableRowSorter<>(tableModel);
//    table1.setRowSorter(sorter);
//    
//    // Đặt bộ lọc cho DefaultRowSorter
//    RowFilter<DefaultTableModel, Integer> filter = RowFilter.regexFilter("(?i)" + keyword, 9);  // tìm ở cột 9
//    sorter.setRowFilter(filter);               
//            }
//        }
    }//GEN-LAST:event_txt_searchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.swing.ButtonBadges buttonBadges1;
    private UI.swing.ButtonBadges buttonBadges2;
    private UI.swing.Button cmdMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private UI.swing.ImageAvatar pic;
    private UI.searchBar.TextFieldSearchOption txt_search;
    // End of variables declaration//GEN-END:variables
}
