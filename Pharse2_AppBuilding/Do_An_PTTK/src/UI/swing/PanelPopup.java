package UI.swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelPopup extends JPanel {

    public PanelPopup() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(50, 50, 50));
        g2.fillRect(8, 0, getSize().width - 8, getSize().height);      // vẽ hình chữ nhật
        int x[] = {0, 10, 10};
        int y[] = {35, 28, 42};
        g2.fillPolygon(x, y, x.length);     // vẽ đa giác ( trong trường hợp này là tam giác)
        super.paintComponent(grphcs);
    }
}
