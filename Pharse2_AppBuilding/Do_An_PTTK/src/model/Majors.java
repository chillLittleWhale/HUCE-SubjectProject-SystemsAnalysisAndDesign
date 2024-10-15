package model;

public class Majors {
    private String idNganh;
    private String tenNganh;
    private String thuocKhoa;

    public Majors() {
    }

    public Majors(String idNganh, String tenNganh, String thuocKhoa) {
        this.idNganh = idNganh;
        this.tenNganh = tenNganh;
        this.thuocKhoa = thuocKhoa;
    }

    public String getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(String idNganh) {
        this.idNganh = idNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getThuocKhoa() {
        return thuocKhoa;
    }

    public void setThuocKhoa(String thuocKhoa) {
        this.thuocKhoa = thuocKhoa;
    }
    
    public static void main(String[] args) {
        
    }   
}
