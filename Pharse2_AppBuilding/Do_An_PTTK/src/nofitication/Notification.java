package nofitication;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import shadow.*;

public class Notification extends javax.swing.JComponent {

    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean showing;
    private Thread thread;
    private int animate = 10;
    private BufferedImage imageShadow;
    private int shadowsize = 6;
    private Type type;
    private Location location;
    
    public Notification(Frame fram, Type type, Location location, String message) {
        this.fram = fram;
        this.type = type;
        this.location = location;
        initComponents();
        init(message);
        initAnimator();
    }

    private void init(String message){
        setBackground(Color.WHITE);
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
        
        if(type == Type.SUCCESS){
            lb_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/success-30.png")));
            lb_message.setText("Success");
            lb_messageText.setText(message);
        }
        else if(type == Type.INFOR){
            lb_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/information-30.png")));
            lb_message.setText("Infor");
            lb_messageText.setText(message);
        }
        else if(type == Type.WARNING){
            lb_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/warning-30.png")));
            lb_message.setText("Warning");
            lb_messageText.setText(message);
        }
        else if(type == Type.FALSE){
            lb_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cross-30.png")));
            lb_message.setText("False");
            lb_messageText.setText(message);
        }
    }
    
    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x;
            private int top;
            private boolean top_to_bot;

            @Override
            public void timingEvent(float fraction) {
                if (showing) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                } else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
            }

            @Override
            public void begin() {
                if (!showing) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
                    if (location == Location.TOP_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.TOP_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.TOP_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.BOTTOM_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
                        top_to_bot = true;
                    }
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void end() {
                showing = !showing;
                if (showing) {
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sleep();
                            closeNotification();
                        }
                    });
                    thread.start();
                } else {
                    dialog.dispose();
                }
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }
    
    public void showNotification(){
        animator.start();
    }
    
    private void closeNotification() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!showing) {
                animator.stop();
                showing = true;
                animator.start();
            }
        } else {
            showing = true;
            animator.start();
        }
    }
        
    private void sleep(){
        try{
            Thread.sleep(2000);
        }
        catch( InterruptedException e){
        }
    }
    
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowsize;
        int y = shadowsize;
        int width = getWidth() - shadowsize * 2;
        int height = getHeight() - shadowsize * 2;
        g2.fillRect(x, y, width, height);
        if (type == Type.SUCCESS) {
            g2.setColor(new Color(18, 163, 24));
        } else if (type == Type.INFOR) {
            g2.setColor(new Color(28, 139, 206));
        } else {
            g2.setColor(new Color(241, 196, 15));
        }
        g2.fillRect(6, 5, 5, getHeight() - shadowsize * 2 + 1);
        g2.dispose();
        super.paint(grphcs);
    }
    
    

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height); 
        createImageShadow();
    }

    
    private void createImageShadow(){
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(createShadow(), 0, 0, null);
        g2.dispose();
    }
    
    private BufferedImage createShadow(){
        BufferedImage img = new BufferedImage(getWidth()-shadowsize*2, getHeight()-shadowsize*2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowsize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }
    
    public static void main(String[] args) {
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_icon = new model.CustomLabel();
        panel = new javax.swing.JPanel();
        lb_message = new javax.swing.JLabel();
        lb_messageText = new javax.swing.JLabel();
        customLabel1 = new model.CustomLabel();

        lb_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/success-30.png"))); // NOI18N

        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(100, 30));

        lb_message.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lb_message.setForeground(new java.awt.Color(38, 38, 38));
        lb_message.setText("Message");

        lb_messageText.setForeground(new java.awt.Color(127, 127, 127));
        lb_messageText.setText("Message text");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_messageText)
                    .addComponent(lb_message))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(lb_message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_messageText))
        );

        customLabel1.setBackground(new java.awt.Color(255, 255, 255));
        customLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close-20.png"))); // NOI18N
        customLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public static enum Type{
        SUCCESS, INFOR, WARNING, FALSE
    }
    
    public static enum Location{
        TOP_CENTER, TOP_LEFT, TOP_RIGHT, CENTER, BOTTOM_CENTER, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private model.CustomLabel customLabel1;
    private model.CustomLabel lb_icon;
    private javax.swing.JLabel lb_message;
    private javax.swing.JLabel lb_messageText;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
