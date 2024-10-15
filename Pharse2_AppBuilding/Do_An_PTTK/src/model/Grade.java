package model;

import java.awt.Rectangle;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Grade {
    String sdt;
    String idMon;
    String hocKy;
    String tenMon;
    Integer sotinchi;
    Float diemcc;
    Float diemgk;
    Float diemck;
    Float diemtbhe10;
    String ghichu;

    public Grade() {
    }

    public Grade(String sdt, String idMon, String hocKy) {
        this.sdt = sdt;
        this.idMon = idMon;
        this.hocKy = hocKy;
        this.tenMon = "";
        this.sotinchi = 0;
        this.diemcc = null;
        this.diemgk = null;
        this.diemck = null;
        this.diemtbhe10 = null;
        this.ghichu = "";
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public Integer getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(Integer sotinchi) {
        this.sotinchi = sotinchi;
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

    public Float getDiemtbhe10() {
        if (diemcc != null && diemgk != null && diemck != null) {
            //float diem =  (diemcc.floatValue()*0.3f + ( diemgk.floatValue()*0.3f + diemck.floatValue()*0.7f)*0.7f);
            float diem =  (diemcc.floatValue()*0.3f + diemgk.floatValue()*0.7f)*0.3f + diemck.floatValue()*0.7f;
            BigDecimal roundedValue = new BigDecimal(diem).setScale(2, RoundingMode.HALF_UP);
            return (Float) roundedValue.floatValue();
        } else {
            return null;
        }
    }

    public void setDiemtbhe10() {
        if (diemcc != null && diemgk != null && diemck != null) {
            float diem =  (diemcc.floatValue()*0.3f + ( diemgk.floatValue()*0.3f + diemck.floatValue()*0.7f)*0.7f);
            BigDecimal roundedValue = new BigDecimal(diem).setScale(2, RoundingMode.HALF_UP);
            this.diemtbhe10 = roundedValue.floatValue();
        } else {
            this.diemtbhe10 = null;
        }
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
   
}
