package UI.panels;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class paylacPanel extends JPanel implements ActionListener {

    private int colorIndex = 0;
    private final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, 
                                    Color.GREEN, Color.BLUE, Color.MAGENTA};
    private Timer timer;

    public paylacPanel() {
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradient = new GradientPaint(0, 0, colors[colorIndex], getWidth(), getHeight(), colors[(colorIndex + 1) % colors.length]);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        colorIndex = (colorIndex + 1) % colors.length;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Gradient Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        paylacPanel panel = new paylacPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
