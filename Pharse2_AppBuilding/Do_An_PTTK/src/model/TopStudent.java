package model;

import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class TopStudent {
    private String sdt;    // primary key
    private String name;
    private Float diemcc;
    private Float diemgk;
    private Float diemck;    
    private Float diemTBmon;  
    private Float diemHe4;  
    private String diemchu;   
    private String queQuan;
    private String lop;
    private Blob avatar;

    public TopStudent() {
    }

    public TopStudent(String sdt, String name, Float diemcc, Float diemgk, Float diemck, String queQuan, String truong, Blob avatar) {
        this.sdt = sdt;
        this.name = name;
        this.diemcc = diemcc;
        this.diemgk = diemgk;
        this.diemck = diemck;
        this.queQuan = queQuan;
        this.lop = truong;
        this.avatar = avatar;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDiemcc() {
        return diemcc;
    }

    public void setDiemcc(Float diemcc) {
        this.diemcc = diemcc;
    }

    public Float getDiemgk() {
        return diemgk;
    }

    public void setDiemgk(Float diemgk) {
        this.diemgk = diemgk;
    }

    public Float getDiemck() {
        return diemck;
    }

    public void setDiemck(Float diemck) {
        this.diemck = diemck;
    }

    public Float getDiemTBmon() {
        return diemTBmon;
    }

//    public void setDiemtbhe10() {
//        if (diemcc != null && diemgk != null && diemck != null) {
//            float diem =  (diemcc.floatValue()*0.3f + ( diemgk.floatValue()*0.3f + diemck.floatValue()*0.7f)*0.7f);
//            BigDecimal roundedValue = new BigDecimal(diem).setScale(2, RoundingMode.HALF_UP);
//            this.diemTBmon = roundedValue.floatValue();
//        } else {
//            this.diemTBmon = null;
//        }
//    }

    public void setDiemtbhe10(Float diemtbhe10){
        this.diemTBmon = diemtbhe10;
    }
    public Float getDiemHe4() {
        return diemHe4;
    }

    public void setDiemHe4AndDiemChu() {
        Float diemtbmon = diemTBmon;
            if(diemtbmon < 4.0){
                this.diemHe4 = 0.0f;
                this.diemchu = "F";
            }
            else if(diemtbmon>= 4.0 && diemtbmon < 5.0){
                diemHe4 = 1.0f;
                diemchu = "D";
            }
            else if(diemtbmon >= 5.0 && diemtbmon < 5.5){
                diemHe4 = 1.5f;
                diemchu = "D+";
            }
            else if(diemtbmon >= 5.5 && diemtbmon < 6.5){
                diemHe4 = 2.0f;
                diemchu = "C";
            }
            else if(diemtbmon >= 6.5 && diemtbmon < 7.0){
                diemHe4 = 2.5f;
                diemchu = "C+";
            }
            else if(diemtbmon >= 7.0 && diemtbmon < 8.0){
                diemHe4 = 3.0f;
                diemchu = "B";
            }
            else if(diemtbmon >= 8.0 && diemtbmon < 8.5){
                diemHe4 = 3.5f;
                diemchu = "B+";
            }
            else {
                diemHe4 = 4.0f;
                diemchu = "A";
            }
    }

    public String getDiemchu() {
        return diemchu;
    }

    public void setDiemchu(String diemchu) {
        this.diemchu = diemchu;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }
    
    public ImageIcon getAvatarImageIcon() throws SQLException {
        // Chuyển đổi Blob thành byte array
        if(this.avatar != null){
            byte[] imageData = avatar.getBytes(1, (int) avatar.length());
            // Tạo ImageIcon từ byte array
            return new ImageIcon(imageData);
        }
        return null;
    }     
}
