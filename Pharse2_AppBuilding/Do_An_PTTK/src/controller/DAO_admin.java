package controller;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.*;
import model.*;

public class DAO_admin {
    private Connection conn;
    
    public DAO_admin(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databasename=QL_DiemThi_ver2;username=tam;password=12345;encrypt=false");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean addClass( Clas cla){
        String sql = "INSERT INTO tbl_Class(MACLA, TENCLA) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cla.getIdLop());
            ps.setString(2, cla.getTenLop());            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateClass(Clas cla) {
        String sql = "UPDATE tbl_Class SET TENCLA = ? WHERE MACLA = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cla.getTenLop());
            ps.setString(2, cla.getIdLop());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteClass(Clas cla) {
        String sql = "DELETE FROM tbl_Class WHERE MACLA=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cla.getIdLop());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList< Clas> getClasList(){
        ArrayList< Clas> claList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Class";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Clas cla = new Clas(rs.getString("MACLA"),
                        rs.getString("TENCLA"));
                claList.add(cla);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claList;
    }
    
// 
    public ArrayList< Clas> timLopTheoTen(String tenLop) throws UnsupportedEncodingException {
        ArrayList< Clas> claList = new DAO_admin().getClasList();
        ArrayList< Clas> claList2 = new ArrayList<>();
        
        String searchTerm = tenLop.trim(); // Lấy chuỗi từ ô tìm kiếm
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); // Chuyển đổi chuỗi sang mã hóa UTF-8
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); // Chuyển đổi lại sang chuỗi UTF-8 để kiểm tra tính đúng đắn

        // Tìm kiếm trong danh sách các trường học
        for (Clas uni : claList) {
            if (uni.getTenLop().toLowerCase().contains(searchTermUTF8.toLowerCase())) { // So sánh chuỗi tìm kiếm với tên trường học
                claList2.add(uni);
            }
        }
        return claList2;
    }
    
    public ArrayList< Clas> timLopTheoMa(String maLop){
        ArrayList< Clas> claList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Class WHERE MAUNI LIKE '%"+maLop+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Clas cla = new Clas(rs.getString("MACLA"),
                        rs.getString("TENCLA"));
                claList.add(cla);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claList;
    }
    
    
    public boolean addMajors( Majors maj){
        String sql = "INSERT INTO tbl_Majors(MAMAJ, TENMAJ, THUOCKHOA) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maj.getIdNganh());
            ps.setString(2, maj.getTenNganh());
            ps.setString(3, maj.getThuocKhoa());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateMajors(Majors maj) {
        String sql = "UPDATE tbl_Majors SET TENMAJ = ?, THUOCKHOA = ? WHERE MAMAJ = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maj.getTenNganh());
            ps.setString(2, maj.getThuocKhoa());
            ps.setString(3, maj.getIdNganh());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteMajors(Majors maj) {
        String sql = "DELETE FROM tbl_Majors WHERE MAMAJ=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maj.getIdNganh());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList< Majors> getMajList(){
        ArrayList< Majors> majList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Majors";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Majors maj = new Majors(rs.getString("MAMAJ"),
                        rs.getString("TENMAJ"),
                        rs.getString("THUOCKHOA"));
                majList.add(maj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return majList;
    }
    
    public ArrayList< Majors> timNganhTheoTen(String tenMaj) throws UnsupportedEncodingException{
        ArrayList< Majors> majList = new DAO_admin().getMajList();
        ArrayList< Majors> majList2 = new ArrayList<>();
        
        String searchTerm = tenMaj.trim(); 
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); 
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); 
        
        for (Majors maj : majList) {
            if (maj.getTenNganh().toLowerCase().contains(searchTermUTF8.toLowerCase())) { 
                majList2.add(maj);
            }
        }
        return majList2;
    }
    
    public ArrayList< Majors> timNganhTheoMa(String maMaj){
        ArrayList< Majors> majList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Majors WHERE MAMAJ LIKE '%"+maMaj+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Majors maj = new Majors(rs.getString("MAMAJ"),
                        rs.getString("TENMAJ"),
                        rs.getString("THUOCKHOA"));
                majList.add(maj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return majList;
    }
    
    public ArrayList< Majors> timNganhTheoKhoa(String tenkhoa) throws UnsupportedEncodingException{
        ArrayList< Majors> majList = new DAO_admin().getMajList();
        ArrayList< Majors> majList2 = new ArrayList<>();
        
        String khoa = tenkhoa.trim(); 
        byte[] khoaBytes = khoa.getBytes("UTF-8"); 
        String khoaUTF8 = new String(khoaBytes, "UTF-8"); 

        // Tìm kiếm trong danh sách các nganh học
        for (Majors maj : majList) {
            if (maj.getThuocKhoa().toLowerCase().contains(khoaUTF8.toLowerCase())) { 
                majList2.add(maj);
            }
        }
        return majList2;
    }   
    
    public boolean addSubject( Subject sub){
        String sql = "INSERT INTO tbl_Subject(MASUB, TENSUB) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sub.getIdMon());
            ps.setString(2, sub.getTenMon());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateSubject(Subject sub) {
        String sql = "UPDATE tbl_Subject SET TENSUB = ? WHERE MASUB = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sub.getTenMon());
            ps.setString(2, sub.getIdMon());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteSubject(Subject sub) {
        String sql = "DELETE FROM tbl_Subject WHERE MASUB=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sub.getIdMon());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList< Subject> getSubList(){
        ArrayList< Subject> subList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Subject";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Subject sub = new Subject(rs.getString("MASUB"),
                        rs.getString("TENSUB"));
                subList.add(sub);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(subList, Comparator.naturalOrder());
        return subList;
    }
    
    public ArrayList< Subject> timMonTheoTen(String tenMon) throws UnsupportedEncodingException{
        ArrayList< Subject> subList = new DAO_admin().getSubList();
        ArrayList< Subject> subList2 = new ArrayList<>();
        
        String ten = tenMon.trim(); 
        byte[] tenBytes = ten.getBytes("UTF-8"); 
        String tenUTF8 = new String(tenBytes, "UTF-8"); 

        for (Subject sub : subList) {
            if (sub.getTenMon().toLowerCase().contains(tenUTF8.toLowerCase())) { 
                subList2.add(sub);
            }
        }
        return subList2;
    }
    
    public ArrayList< Subject> timMonTheoMa(String maMon){
        ArrayList< Subject> subList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Subject WHERE MASUB LIKE '%"+maMon+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Subject sub = new Subject(rs.getString("MASUB"),
                        rs.getString("TENSUB"));
                subList.add(sub);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subList;
    }
    
//    public static void main(String[] args) {
//        new DAO_admin();
//    }
}
