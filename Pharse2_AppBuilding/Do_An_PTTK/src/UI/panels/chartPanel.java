package UI.panels;

import model.Account;
import UI.chart.component.ModelChart;
import controller.DAO_sv;
import java.awt.Color;
import java.util.ArrayList;
import model.Grade;

public class chartPanel extends javax.swing.JPanel {

    private Account acc;
    private ArrayList< Grade> dsDiem = new ArrayList<>();
    public chartPanel(Account acc) {
        initComponents();
        this.acc = acc;
        for (String hk : this.acc.getDsHocKy()) { 
            cbBox_hocky.addItem(hk); 
        }
        
        chart.addLegend("Điểm TB trường", new Color(240, 202, 115));
        chart.addLegend("Điểm của bạn", new Color(135, 189, 245));
        //chart.addLegend("Điểm TB ALL", new Color(189, 135, 245));        
        
        chart.start();
    }

    private void setupChart(){       
        dsDiem = new DAO_sv().getGradeList1svByhocKy(acc.getSdt(), cbBox_hocky.getSelectedItem().toString());
        if( !dsDiem.isEmpty()){
            for (Grade gra : dsDiem) {
                String name = gra.getTenMon();
                //double diemTbTruong = new DAO_sv().getDTB_Lop(gra.getIdMon(), acc);
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

        cbBox_hocky = new javax.swing.JComboBox<>();
        chart = new UI.chart.component.Chart();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1025, 466));

        cbBox_hocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBox_hockyActionPerformed(evt);
            }
        });

        chart.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbBox_hocky, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbBox_hocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbBox_hockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBox_hockyActionPerformed
        chart.clear();
        setupChart();
    }//GEN-LAST:event_cbBox_hockyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbBox_hocky;
    private UI.chart.component.Chart chart;
    // End of variables declaration//GEN-END:variables
}
