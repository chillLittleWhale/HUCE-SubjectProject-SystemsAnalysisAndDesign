package model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import java.awt.Insets;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class PasswordField extends JPasswordField{

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public boolean isShowandHide() {
        return showandHide;
    }

    public void setShowandHide(boolean showandHide) {
        this.showandHide = showandHide;
        repaint();
    }
    
    
    private final Animator animator;
    private boolean animateHinText=true;
    private float location;
    private boolean show;
    private boolean mouseOver = false;
    private String labelText = "Label";
    private Color lineColor=new Color(3,155,216);
    private  Image eye ;
    private final Image eye_hide;
    private boolean hide = true;
    private boolean showandHide;
    private Timer animationTimer;
    private int currentFrame;

      
    public PasswordField(){
        setShowandHide(true);
        currentFrame = 0;
        URL imageURL = getClass().getResource("/icon/eye_scan-35.gif");
        ImageIcon icon = new ImageIcon(imageURL);
        eye = icon.getImage();
        setBorder(new EmptyBorder(20,3,10,30));
        setSelectionColor(new Color(76,204,255));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                mouseOver=true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver=false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (showandHide) {
                    int x = getWidth() - 30;
                    if (new Rectangle(x,0,30,30).contains(me.getPoint())) {
                        hide=!hide;
                        if (hide) {
                            setEchoChar('*');
                        } else {
                            setEchoChar((char)0);
                        }
                        repaint();
                    }
                }
            }
            
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                showing(false);
                animationTimer.start();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                showing(true);
                //animationTimer.stop();           
            }
            
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                if(showandHide){
                    int x = getWidth() - 30;
                if (new Rectangle(x, 0, 30, 30).contains(me.getPoint())){
                    setCursor(new  Cursor(Cursor.HAND_CURSOR));
                }
                else{
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            }
                }
          
        });


        TimingTarget target=new TimingTargetAdapter(){
            @Override
            public void begin() {
                animateHinText = String.valueOf(getPassword()).equals("");
            }

            @Override
            public void timingEvent(float fraction) {
                location = fraction;
                repaint();
            }
            
        };
        
        //eye = new  ImageIcon(getClass().getResource("/icon/eye-35.png")).getImage();
        eye_hide = new  ImageIcon(getClass().getResource("/icon/closed_blu_eye-35.png")).getImage();
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        
        animationTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tăng currentFrame lên 1
                currentFrame++;
                // Kiểm tra nếu currentFrame đã vượt quá số khung hình của icon động
                // Đặt currentFrame về 0 để bắt đầu từ đầu
                if (currentFrame >= 60) {
                    currentFrame = 0;
                }
                repaint();
            }
        });
        animationTimer.start();
    }
    private void showing(boolean action){
        if(animator.isRunning()){
            animator.stop();
        }else{
            location = 1;
        }
        animator.setStartFraction(1f - location);
        show = action;
        location = 1f - location;
        animator.start();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (!visible) {
            animationTimer.stop();
        } else {
            animationTimer.start();
        }
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        animationTimer.stop();
    }
    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); 
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        int width=getWidth();
        int height=getHeight();
        if (mouseOver) {
            g2.setColor(lineColor);
        } else {
            g2.setColor(new Color(150, 150, 150));
        }
        g2.fillRect(2, height - 1,  width - 4, 1);
        createHintText(g2);
        createLineStyle(g2);
        if(showandHide){
            createShowHide(g2);
        }
        g2.dispose();
    }
    
    private void createShowHide(Graphics2D g2) {
        int x = getWidth() - 40 + 5;
        int y = (getHeight() - 35) / 2;
        Image frame = getFrameFromAnimatedIcon(currentFrame);
        g2.drawImage(frame, x, y, null);

    }

    private Image getFrameFromAnimatedIcon(int frameIndex) {
        if (hide) {
            return eye_hide;
        } else {
            return eye;
        }
    }

    
    private void createHintText(Graphics2D g2){
        Insets in = getInsets();
        g2.setColor(new Color(150, 150,150));
        FontMetrics ft=g2.getFontMetrics();
        Rectangle2D r2= ft.getStringBounds(labelText, g2);
        double height = getHeight() - in.top - in.bottom;
        double textY=(height-r2.getHeight())/2;
        double size;
        if (animateHinText) {
            if (show) {
                size = 18 * (1 - location);
            } else {
                    size = 18*location;
            }
        }else {
            size = 18;
        }
        g2.drawString(labelText, in.left, (int) (in.top + textY + ft.getAscent() - size));
    }
    
    private void createLineStyle(Graphics2D g2){
        if(isFocusOwner()){
            double width=getWidth()-4;
            int height = getHeight();
            g2.setColor(lineColor);
            double size;
            if (show) {
                size=width*(1-location);
            } else {
                size=width*location;
            }
            double x = (width-size)/2;
            g2.fillRect((int) (x + 2), height - 2, (int) size , 2);
        }
    }
    
    @Override
    public void setText(String string){
        if (!String.valueOf(getPassword()).equals("")) {
            showing(string.equals(""));
        }
        super.setText(string);
    }
}