package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class KetQuaHocKy {
    private int tinDangKy;
    private int tinDat;
    private int tinNo;
    private Float DiemTbHe10;
    private Float DiemTbHe4;
    private String xepLoai;

    public KetQuaHocKy() {
        this.xepLoai ="";
    }

    public int getTinDangKy() {
        return tinDangKy;
    }

    public void setTinDangKy(int tinDangKy) {
        this.tinDangKy = tinDangKy;
    }

    public int getTinDat() {
        return tinDat;
    }

    public void setTinDat(int tinDat) {
        this.tinDat = tinDat;
    }

    public int getTinNo() {
        return tinNo;
    }

    public void setTinNo(int tinNo) {
        this.tinNo = tinNo;
    }

    public Float getDiemTbHe10() {
        return DiemTbHe10;
    }

    public void setDiemTbHe10(Float DiemTbHe10) {
        this.DiemTbHe10 = DiemTbHe10;
    }

    public Float getDiemTbHe4() {
        return DiemTbHe4;
    }

    public void setDiemTbHe4(Float DiemTbHe4) {
        this.DiemTbHe4 = DiemTbHe4;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
    
    public void setDiemAuto() {
        //this.DiemTbHe4 = DiemTbHe10 * 0.4f * 1f;
        float diemTbHe4 = DiemTbHe10 * 0.4f * 1f;
        // Làm tròn giá trị đến 2 chữ số sau dấu phẩy và thay thế dấu phẩy thành dấu chấm
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US)); // Sử dụng ký tự phân tách phần thập phân là dấu chấm
        String diemTbHe10String = decimalFormat.format(diemTbHe4).replace(",", ".");
        diemTbHe4 = Float.parseFloat(diemTbHe10String);
        this.DiemTbHe4 = diemTbHe4;
        
        if(DiemTbHe10 < 4.0){
            this.xepLoai = "Kém";
        }
        else if(DiemTbHe10>= 4.0 && DiemTbHe10 < 5.0){
            xepLoai = "Yếu";
        }
        else if(DiemTbHe10 >= 5.0 && DiemTbHe10 < 7.0){
            xepLoai = "Trung bình";
        }
        else if(DiemTbHe10 >= 7.0 && DiemTbHe10 < 8.0){
            xepLoai = "Khá";
        }
        else if(DiemTbHe10 >= 8.0 && DiemTbHe10 < 9.0){
            xepLoai = "Giỏi";
        }
        else if(DiemTbHe10 >= 9.0 && DiemTbHe10 <= 10.0){
            xepLoai = "Xuất sắc";
        }
    }
}
