package UI.panels;
import UI.chart.component.ModelChart;
import UI.main.User_view;
import controller.DAO_sv;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.Account;
import model.Grade;

public class homePanel extends javax.swing.JPanel {

    private Account acc;
    private User_view userView;
    private ArrayList< Grade> dsDiem = new ArrayList<>();
    public homePanel(Account acc, User_view userView) throws SQLException {
        initComponents();
        this.acc = new DAO_sv().getAccBySdt(acc.getSdt());
        this.userView = userView;
        setupThongTin();
        for (String hk : this.acc.getDsHocKy()) { 
            cbBox_hocky.addItem(hk); 
        }
        
        chart.addLegend("Điểm TB trường", new Color(240, 202, 115));
        chart.addLegend("Điểm của bạn", new Color(135, 189, 245));
        chart.start();
    }

    public void setupThongTin() throws SQLException{
//        if(acc.getAvatarImageIcon() != null){
            pic.setIcon(acc.getAvatarImageIcon());
//        }
//        else if(acc.getGioiTinh() == true){
//            pic.setIcon(new ImageIcon(getClass().getResource("/icon/avartar_male-100.png"))); // NOI18N
//        }   
//        else{
//            pic.setIcon(new ImageIcon(getClass().getResource("/icon/avartar_female-100.png"))); // NOI18N
//        }
        
        txt_name.setText(acc.getName());
        txt_que.setText(acc.getQueQuan());
        txt_nganh.setText(acc.getNganh());
        //System.out.println("Lớp:"+acc.getLop()+"---");
        if(!acc.getLop().isEmpty() && !acc.getLop().equals(" ") ){
            txt_lop.setText(acc.getLop());
            String khoa = acc.getLop().substring(0, 2);
            try {
                int khoaInt = Integer.parseInt(khoa); // Thử chuyển đổi khoa thành Integer            
                txt_khoa.setText("K" + khoa + "(" + (1955 + khoaInt) + ")"); // Nếu không có ngoại lệ, có thể chuyển đổi thành công
            } catch (NumberFormatException e) {
                System.out.println("Không thể chuyển đổi khoa thành Integer.");
            }
        }

        txt_truong.setText("Đại học Xây Dựng Hà Nội (HUCE)");
        String gt = (acc.getGioiTinh() == true) ? "Nam" : "Nữ";
        txt_gioiTinh.setText(gt);
        txt_dob.setText(acc.getNgaySinh().toString());
    }
    private void setupChart(){     // lấy ra dữ liệu của học kỳ mới nhất  
        dsDiem = new DAO_sv().getGradeList1svByhocKy(acc.getSdt(), cbBox_hocky.getSelectedItem().toString());
        if( !dsDiem.isEmpty()){
            for (Grade gra : dsDiem) {
                String name = gra.getTenMon();
                double diemTbTruong = new DAO_sv().getDTB_All(gra.getIdMon());
                Float yourGrade = gra.getDiemtbhe10();
                if(yourGrade != null){
                    chart.addData(new ModelChart(name, new double[]{diemTbTruong, yourGrade.floatValue()}));
                }
            }            
        }
        chart.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        customLabel1 = new model.CustomLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        customLabel2 = new model.CustomLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        customLabel3 = new model.CustomLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        customLabel4 = new model.CustomLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        customLabel5 = new model.CustomLabel();
        jLabel14 = new javax.swing.JLabel();
        pn_chart = new javax.swing.JPanel();
        chart = new UI.chart.component.Chart();
        cbBox_hocky = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        pn_thongTin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pic = new UI.swing.ImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        txt_que = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_dob = new javax.swing.JLabel();
        txt_gioiTinh = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_khoa = new javax.swing.JLabel();
        txt_nganh = new javax.swing.JLabel();
        txt_truong = new javax.swing.JLabel();
        txt_lop = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 248, 248));
        setPreferredSize(new java.awt.Dimension(1025, 466));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        customLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/leaderboard-64.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Xếp hạng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        customLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/analyze-64.png"))); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cá nhân");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        customLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/study-64.png"))); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Học tập");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        customLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bar-chart-64.png"))); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Biểu đồ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        customLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gear-64.png"))); // NOI18N

        jLabel14.setText("   Cài đặt     ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_chart.setBackground(new java.awt.Color(255, 255, 255));

        chart.setBackground(new java.awt.Color(204, 204, 204));
        chart.setOpaque(false);

        cbBox_hocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBox_hockyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_chartLayout = new javax.swing.GroupLayout(pn_chart);
        pn_chart.setLayout(pn_chartLayout);
        pn_chartLayout.setHorizontalGroup(
            pn_chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_chartLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbBox_hocky, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        pn_chartLayout.setVerticalGroup(
            pn_chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_chartLayout.createSequentialGroup()
                .addComponent(cbBox_hocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pn_thongTin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Thông tin người dùng");

        jLabel2.setText("Họ tên :");

        txt_que.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txt_que.setForeground(new java.awt.Color(51, 51, 51));
        txt_que.setText(" ");

        jLabel4.setText("Giới tính :");

        jLabel5.setText("Ngày sinh :");

        jLabel6.setText("Quê quán :");

        txt_dob.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txt_dob.setForeground(new java.awt.Color(51, 51, 51));

        txt_gioiTinh.setBackground(new java.awt.Color(51, 51, 51));
        txt_gioiTinh.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        txt_name.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txt_name.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setText("Lớp học:");

        jLabel11.setText("Khóa :");

        jLabel12.setText("Chuyên ngành :");

        jLabel13.setText("Trường :");

        txt_khoa.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txt_khoa.setForeground(new java.awt.Color(51, 51, 51));

        txt_nganh.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txt_nganh.setForeground(new java.awt.Color(51, 51, 51));

        txt_truong.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txt_truong.setForeground(new java.awt.Color(51, 51, 51));

        txt_lop.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txt_lop.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pn_thongTinLayout = new javax.swing.GroupLayout(pn_thongTin);
        pn_thongTin.setLayout(pn_thongTinLayout);
        pn_thongTinLayout.setHorizontalGroup(
            pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_thongTinLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pn_thongTinLayout.createSequentialGroup()
                .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_thongTinLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_gioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, Short.MAX_VALUE)
                            .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_thongTinLayout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_thongTinLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pn_thongTinLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_thongTinLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_que, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_khoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_lop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_truong, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(txt_nganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_thongTinLayout.setVerticalGroup(
            pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_name)
                    .addComponent(jLabel10)
                    .addComponent(txt_lop))
                .addGap(18, 18, 18)
                .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_gioiTinh)
                    .addComponent(jLabel11)
                    .addComponent(txt_khoa))
                .addGap(18, 18, 18)
                .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_dob)
                    .addComponent(jLabel12)
                    .addComponent(txt_nganh))
                .addGap(18, 18, 18)
                .addGroup(pn_thongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_que)
                    .addComponent(jLabel13)
                    .addComponent(txt_truong))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pn_thongTin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10)
                .addComponent(pn_chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbBox_hockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBox_hockyActionPerformed
        chart.clear();
        setupChart();
    }//GEN-LAST:event_cbBox_hockyActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        try {
            userView.getMainForm().showForm(new rankPanel(acc));
        } catch (SQLException ex) {
            Logger.getLogger(homePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        try {
            userView.getMainForm().showForm(new infoPanel(acc));
        } catch (SQLException ex) {
            Logger.getLogger(homePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(homePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        userView.getMainForm().showForm(new studyPanel(acc, userView));
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        userView.getMainForm().showForm(new chartPanel(acc));
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        userView.getMainForm().showForm(new settingPanel(acc, userView));
    }//GEN-LAST:event_jPanel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbBox_hocky;
    private UI.chart.component.Chart chart;
    private model.CustomLabel customLabel1;
    private model.CustomLabel customLabel2;
    private model.CustomLabel customLabel3;
    private model.CustomLabel customLabel4;
    private model.CustomLabel customLabel5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private UI.swing.ImageAvatar pic;
    private javax.swing.JPanel pn_chart;
    private javax.swing.JPanel pn_thongTin;
    private javax.swing.JLabel txt_dob;
    private javax.swing.JLabel txt_gioiTinh;
    private javax.swing.JLabel txt_khoa;
    private javax.swing.JLabel txt_lop;
    private javax.swing.JLabel txt_name;
    private javax.swing.JLabel txt_nganh;
    private javax.swing.JLabel txt_que;
    private javax.swing.JLabel txt_truong;
    // End of variables declaration//GEN-END:variables
}
