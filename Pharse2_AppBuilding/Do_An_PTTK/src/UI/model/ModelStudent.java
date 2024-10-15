package UI.model;

import UI.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

public class ModelStudent {

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruong() {
        return Truong;
    }

    public void setTruong(String Truong) {
        this.Truong = Truong;
    }

    public String getTinh() {
        return Tinh;
    }

    public void setTinh(String Tinh) {
        this.Tinh = Tinh;
    }

    public double getDiemCC() {
        return DiemCC;
    }

    public void setDiemCC(double DiemCC) {
        this.DiemCC = DiemCC;
    }

    public double getDiemGK() {
        return DiemGK;
    }

    public void setDiemGK(double DiemGK) {
        this.DiemGK = DiemGK;
    }

    public double getDiemCK() {
        return DiemCK;
    }

    public void setDiemCK(double DiemCK) {
        this.DiemCK = DiemCK;
    }

    public double getDiemHe4() {
        return DiemHe4;
    }

    public void setDiemHe4(double DiemHe4) {
        this.DiemHe4 = DiemHe4;
    }

    public double getDiemTBM() {
        return DiemTBM;
    }

    public void setDiemTBM(double DiemTBM) {
        this.DiemTBM = DiemTBM;
    }

    public String getDiemChu() {
        return DiemChu;
    }

    public void setDiemChu(String DiemChu) {
        this.DiemChu = DiemChu;
    }

    public ModelStudent(int stt, Icon icon, String name, String sdt, double DiemCC, double DiemGK, double DiemCK, double DiemTBM, double DiemHe4, String DiemChu, String Truong, String Tinh ) {
        this.STT = stt;
        this.icon = icon;
        this.name = name;
        this.sdt = sdt;
        this.DiemCC = DiemCC;
        this.DiemGK = DiemGK;
        this.DiemCK = DiemCK;
        this.DiemTBM = DiemTBM;
        this.DiemHe4 = DiemHe4;
        this.DiemChu = DiemChu;
        this.Truong = Truong;
        this.Tinh = Tinh;
    }
    
    public ModelStudent(int stt, Icon icon, String name, String sdt, int tongtin, int tindat, int tinno, String Truong, String Tinh ) {
        this.STT = stt;
        this.icon = icon;
        this.name = name;
        this.sdt = sdt;
        this.tongtin = tongtin;
        this.tindat= tindat;
        this.tinno = tinno;
        this.Truong = Truong;
        this.Tinh = Tinh;
    }
    
    public ModelStudent(int stt, Icon icon, String name, int tongtin, int tindat, int tinno, String Truong, String Tinh ) {
        this.STT = stt;
        this.icon = icon;
        this.name = name;
        this.tongtin = tongtin;
        this.tindat= tindat;
        this.tinno = tinno;
        this.Truong = Truong;
        this.Tinh = Tinh;
    }
    public ModelStudent() {
    }
    private int STT;
    private String sdt;
    private Icon icon;
    private String name;
    private String Truong;
    private String Tinh;
    private double DiemCC;
    private double DiemGK;
    private double DiemCK;
    private double DiemHe4;
    private double DiemTBM;
    private String DiemChu;
    
    private int tongtin;
    private int tindat;
    private int tinno;
    
    
    public Object[] toRowTable() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new Object[]{ STT,new ModelProfile(icon, name, sdt), df.format(DiemCC), df.format(DiemGK), df.format(DiemCK), df.format(DiemTBM), df.format(DiemHe4), DiemChu, Truong, Tinh};
    }
  
    public Object[] toRowTable2() {
        double percentage = (double) tindat / tongtin * 100;
        String formattedPercentage = String.format("%.2f%%", percentage);
        return new Object[]{STT, new ModelProfile(icon, name, sdt), tindat, tongtin,formattedPercentage, tinno, Truong, Tinh};
    }
}
