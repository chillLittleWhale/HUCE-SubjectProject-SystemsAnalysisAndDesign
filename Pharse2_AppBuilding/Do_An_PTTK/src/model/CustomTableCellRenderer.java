package model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBorder(null);
        // Căn giữa nội dung của ô
        setHorizontalAlignment(SwingConstants.CENTER);

        // Thiết lập màu nền khi ô được chọn và khi chưa được chọn
        if (isSelected) {
            component.setBackground(new Color(241,245,255)); // Màu nền khi ô được chọn
            component.setForeground(Color.BLACK); // Màu chữ khi ô được chọn
        } 
        else {
            component.setBackground(Color.WHITE); // Màu nền khi ô chưa được chọn
            component.setForeground(Color.BLACK); // Màu chữ khi ô chưa được chọn
        }
        return component;
    }
}

