package controller;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import model.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DAO_sv {
    private Connection conn;
    
    public DAO_sv(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databasename=QL_DiemThi_ver2;username=tam;password=12345;encrypt=false");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean addAccount( Account acc){
        String sql = "INSERT INTO tbl_Account(SDT, MATKHAU, EMAIL, VAITRO, HOTEN, NGAYSINH, GIOITINH, QUEQUAN, NGANH, LOP, DSHOCKY) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getSdt());
            ps.setString(2, acc.getMk());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getRole());
            ps.setString(5, acc.getName());
            ps.setDate(6, acc.getNgaySinh());
            // Chuyển đổi giá trị boolean thành giá trị bit
            boolean gioiTinh = acc.getGioiTinh();
            byte gioiTinhBit = gioiTinh ? (byte) 1 : (byte) 0;       // nam true 1, nu false 0
            ps.setByte(7, gioiTinhBit);
            ps.setString(8, acc.getQueQuan());
            ps.setString(9, acc.getNganh());
            ps.setString(10, acc.getLop());
            // chuyển đổi list trong account về 1 string để thêm vào sql
            if(acc.getDsHocKy().isEmpty()){
                ps.setString(11, null);
            }
            else{
                ps.setString(11, acc.getDsHKString());
            }
            
            //ps.setFloat(12, acc.getDiemTichLuy());
          
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateSinhVien(Account acc) {
        String sql = "UPDATE tbl_Account SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, QUEQUAN = ?, NGANH = ?,"
                + " LOP = ?, EMAIL = ?, MATKHAU = ?, DSHOCKY = ? WHERE SDT = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getName());
            boolean gioiTinh = acc.getGioiTinh();
            byte gioiTinhBit = gioiTinh ? (byte) 1 : (byte) 0;
            ps.setByte(2, gioiTinhBit);
            ps.setDate(3, acc.getNgaySinh());
            ps.setString(4, acc.getQueQuan());
            ps.setString(5, acc.getNganh());
            ps.setString(6, acc.getLop());
            ps.setString(7, acc.getEmail());
            ps.setString(8, acc.getMk());
            ps.setString(9, acc.getDsHKString());
            ps.setString(10, acc.getSdt());
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteSinhVien(Account acc) {
        String sql = "DELETE FROM tbl_Grade WHERE SDT = ?  "
                + "DELETE FROM tbl_Account WHERE SDT = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getSdt());
            ps.setString(2, acc.getSdt());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList< Account> timSvTheoTen(String ten) throws UnsupportedEncodingException {
        ArrayList< Account> accList = new DAO_sv().getAccSvList();
        ArrayList< Account> accList2 = new ArrayList<>();
        
        String searchTerm = ten.trim(); // Lấy chuỗi từ ô tìm kiếm
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); // Chuyển đổi chuỗi sang mã hóa UTF-8
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); // Chuyển đổi lại sang chuỗi UTF-8 để kiểm tra tính đúng đắn

        // Tìm kiếm trong danh sách các trường học
        for (Account acc : accList) {
            if (acc.getName().toLowerCase().contains(searchTermUTF8.toLowerCase())) { // So sánh chuỗi tìm kiếm với tên 
                accList2.add(acc);
            }
        }
        
        return accList2;
    }
    
    public ArrayList<Account> timSvTheoNgaySinh(String ngaySinh) {
        ArrayList<Account> accList = new DAO_sv().getAccSvList();
        ArrayList<Account> accList2 = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for (Account acc : accList) {
            String accNgaySinhStr = dateFormat.format(acc.getNgaySinh());
            if (accNgaySinhStr.equals(ngaySinh)) {
                accList2.add(acc);
            }
        }
        return accList2;
    }


    public ArrayList<Account> timSvTheoGioiTinh(boolean gioiTinh) {
        ArrayList<Account> accList = new DAO_sv().getAccSvList();
        ArrayList<Account> accList2 = new ArrayList<>();

        for (Account acc : accList) {
            if (acc.getGioiTinh() == gioiTinh){
                accList2.add(acc);
            }
        }
        return accList2;
    }
    
    public ArrayList< Account> timSvTheoQueQuan(String ten) throws UnsupportedEncodingException {
        ArrayList< Account> accList = new DAO_sv().getAccSvList();
        ArrayList< Account> accList2 = new ArrayList<>();
        
        String searchTerm = ten.trim(); // Lấy chuỗi từ ô tìm kiếm
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); // Chuyển đổi chuỗi sang mã hóa UTF-8
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); // Chuyển đổi lại sang chuỗi UTF-8 để kiểm tra tính đúng đắn

        for (Account acc : accList) {
            if (acc.getQueQuan().toLowerCase().contains(searchTermUTF8.toLowerCase())) { // So sánh chuỗi tìm kiếm với tên 
                accList2.add(acc);
            }
        }
        return accList2;
    }
    
    public ArrayList< Account> timSvTheoNganh(String ten) throws UnsupportedEncodingException {
        ArrayList< Account> accList = new DAO_sv().getAccSvList();
        ArrayList< Account> accList2 = new ArrayList<>();
        
        String searchTerm = ten.trim(); // Lấy chuỗi từ ô tìm kiếm
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); // Chuyển đổi chuỗi sang mã hóa UTF-8
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); // Chuyển đổi lại sang chuỗi UTF-8 để kiểm tra tính đúng đắn

        // Tìm kiếm trong danh sách các trường học
        for (Account acc : accList) {
            if (acc.getNganh().toLowerCase().contains(searchTermUTF8.toLowerCase())) { // So sánh chuỗi tìm kiếm với tên 
                accList2.add(acc);
            }
        }
        return accList2;
    }
    
    public ArrayList< Account> timSvTheoLop(String ten) throws UnsupportedEncodingException {
        ArrayList< Account> accList = new DAO_sv().getAccSvList();
        ArrayList< Account> accList2 = new ArrayList<>();
        
        String searchTerm = ten.trim(); // Lấy chuỗi từ ô tìm kiếm
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); // Chuyển đổi chuỗi sang mã hóa UTF-8
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); // Chuyển đổi lại sang chuỗi UTF-8 để kiểm tra tính đúng đắn

        // Tìm kiếm trong danh sách các trường học
        for (Account acc : accList) {
            if (acc.getLop().toLowerCase().contains(searchTermUTF8.toLowerCase())) { // So sánh chuỗi tìm kiếm với tên 
                accList2.add(acc);
            }
        }
        return accList2;
    }
    
    public ArrayList< Account> timSvTheoSdt(String ten) throws UnsupportedEncodingException {
        ArrayList< Account> accList = new DAO_sv().getAccSvList();
        ArrayList< Account> accList2 = new ArrayList<>();
        
        String searchTerm = ten.trim(); // Lấy chuỗi từ ô tìm kiếm
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); // Chuyển đổi chuỗi sang mã hóa UTF-8
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); // Chuyển đổi lại sang chuỗi UTF-8 để kiểm tra tính đúng đắn

        for (Account acc : accList) {
            if (acc.getSdt().toLowerCase().contains(searchTermUTF8.toLowerCase())) { // So sánh chuỗi tìm kiếm với tên 
                accList2.add(acc);
            }
        }
        return accList2;
    }
    
    public ArrayList< Account> timSvTheoEmail(String ten) throws UnsupportedEncodingException {
        ArrayList< Account> accList = new DAO_sv().getAccSvList();
        ArrayList< Account> accList2 = new ArrayList<>();
        
        String searchTerm = ten.trim(); // Lấy chuỗi từ ô tìm kiếm
        byte[] searchTermBytes = searchTerm.getBytes("UTF-8"); 
        String searchTermUTF8 = new String(searchTermBytes, "UTF-8"); 

        for (Account acc : accList) {
            if (acc.getEmail().toLowerCase().contains(searchTermUTF8.toLowerCase())) { 
                accList2.add(acc);
            }
        }
        return accList2;
    }
    
    // lấy toàn bộ account 
    public ArrayList< Account> getAccList(){
        ArrayList< Account> accList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Account";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account acc = new Account(rs.getString("SDT"),
                        rs.getString("MATKHAU"),
                        rs.getString("EMAIL"));
                acc.setRole(rs.getString("VAITRO"));
                accList.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accList;
    }
    
    // lấy toàn bộ account của sinh viên
    public ArrayList< Account> getAccSvList(){
        ArrayList< Account> accList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Account WHERE VAITRO = 'sv' ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account acc = new Account(rs.getString("SDT"),
                        rs.getString("MATKHAU"),
                        rs.getString("EMAIL"));
                acc.setRole(rs.getString("VAITRO"));
                acc.setName(rs.getString("HOTEN"));
                acc.setNganh(rs.getString("NGANH"));
                acc.setLop(rs.getString("LOP")); 
                acc.setQueQuan(rs.getString("QUEQUAN"));
                acc.setGioiTinh(rs.getByte("GIOITINH") == 1);
                acc.setNgaySinh(rs.getDate("NGAYSINH"));
                
                accList.add(acc);
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accList;
    }
    
    public ArrayList< TopStudent> getTopSvbyMon(String tenmon){
        ArrayList< TopStudent> accList = new ArrayList<>();
        String sql = "SELECT TOP 10 * FROM tbl_Grade "
                + "WHERE TENMON = ? AND DIEMTBM IS NOT NULL  ORDER BY DIEMTBM DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenmon);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TopStudent acc = new TopStudent();
                acc.setSdt(rs.getString("SDT"));
                acc.setDiemcc(rs.getFloat("DIEMCC"));
                acc.setDiemgk(rs.getFloat("DIEMGK"));
                acc.setDiemck(rs.getFloat("DIEMCK"));
                acc.setDiemtbhe10(rs.getFloat("DIEMTBM"));
                acc.setDiemHe4AndDiemChu();
                
                Account accc = new DAO_sv().getAccBySdt(acc.getSdt());
                acc.setName(accc.getName());
                acc.setQueQuan(accc.getQueQuan());
                acc.setLop(accc.getLop());
                acc.setAvatar(accc.getAvatar());
                
                accList.add(acc);
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accList;
    }
    
    public ArrayList<String> setDsHKFromString(String dsBanStr) {
        // cho vào 1 chuỗi từ trong sql, đặt cho ds học kỳ của account
        return new ArrayList<String>(Arrays.asList(dsBanStr.split(",")));
    }
    
    // lấy đầy đủ 1 tất cả thông tin của 1 user duy nhất
    public Account getAccBySdt(String sdt){
        Account acc = new Account();
        String sql = "SELECT * FROM tbl_Account WHERE SDT = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            acc = new Account(rs.getString("SDT"),
                    rs.getString("MATKHAU"),
                    rs.getString("EMAIL"));
            
            acc.setRole(rs.getString("VAITRO"));
            acc.setName(rs.getString("HOTEN"));
            acc.setNgaySinh(rs.getDate("NGAYSINH"));
            acc.setGioiTinh(rs.getByte("GIOITINH") == 1);   // nếu đúng trả về true, tức nam và ngược lại
            acc.setQueQuan(rs.getString("QUEQUAN"));
            acc.setNganh(rs.getString("NGANH"));
            acc.setLop(rs.getString("LOP"));
          //  acc.setDsHocKy(setDsHKFromString(rs.getString("DSHOCKY")));
            //acc.setDiemTichLuy(rs.getFloat("DIEMTICHLUY"));

            String dshk = rs.getString("DSHOCKY");
            if (dshk != null) {
                acc.setDsHKFromString(dshk);
                System.out.println("Khác null, dshk:"+dshk+"---");
            }
            else{
                acc.setDsHocKy(new ArrayList<String>());
                System.out.println("dshk == null");
            }
            
            byte[] avatarData = rs.getBytes("AVATAR");
            Blob avatarBlob = null;
            if (avatarData != null) {
                avatarBlob = new javax.sql.rowset.serial.SerialBlob(avatarData);
            }
            acc.setAvatar(avatarBlob); 
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
    
    // lấy toàn bộ điểm trong danh sách
    public ArrayList< Grade> getGradeList(){
        ArrayList< Grade> gradeList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Grade";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grade gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                BigDecimal diemccValue = rs.getBigDecimal("DIEMCC");
                if (diemccValue != null) {
                    gra.setDiemcc(diemccValue.floatValue());
                }else {
                    gra.setDiemcc(null);
                }

                BigDecimal diemgkValue = rs.getBigDecimal("DIEMGK");
                if (diemgkValue != null) {
                    gra.setDiemgk(diemgkValue.floatValue());
                }else {
                    gra.setDiemgk(null);
                }

                BigDecimal diemckValue = rs.getBigDecimal("DIEMCK");
                if (diemckValue != null) {
                    gra.setDiemck(diemckValue.floatValue());
                }else {
                    gra.setDiemck(null);
                }
                gra.setDiemtbhe10();
                gra.setGhichu(rs.getString("GHICHU"));
                
                gradeList.add(gra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeList;
    }
    // lấy điểm của 1 sinh viên trong danh sách
    public ArrayList< Grade> getGradeList1sv(String sdt){
        ArrayList< Grade> gradeList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Grade WHERE SDT= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grade gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                // Kiểm tra giá trị null cho trường DIEMCC
                float diemcc = rs.getFloat("DIEMCC");
                if (rs.wasNull()) {
                    gra.setDiemcc(null);
                } else { gra.setDiemcc(diemcc); }
                
                // Kiểm tra giá trị null cho trường DIEMGK
                float diemgk = rs.getFloat("DIEMGK");
                if (rs.wasNull()) {
                    gra.setDiemgk(null);
                } else { gra.setDiemgk(diemgk); }
                
                // Kiểm tra giá trị null cho trường DIEMCK
                float diemck = rs.getFloat("DIEMCK");
                if (rs.wasNull()) {
                    gra.setDiemck(null);
                } else { gra.setDiemck(diemck); }
                
                gra.setDiemtbhe10();
                gra.setGhichu(rs.getString("GHICHU"));
                
                gradeList.add(gra);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeList;
    }
    
    //lấy điểm 1 sinh viên trong 1 kỳ học
    public ArrayList< Grade> getGradeList1svByhocKy(String sdt, String hocky){
        ArrayList< Grade> gradeList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Grade WHERE SDT= ? AND HOCKY =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ps.setString(2, hocky);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grade gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                // Kiểm tra giá trị null cho trường DIEMCC
                float diemcc = rs.getFloat("DIEMCC");
                if (rs.wasNull()) {
                    gra.setDiemcc(null);
                } else { gra.setDiemcc(diemcc); }
                
                // Kiểm tra giá trị null cho trường DIEMGK
                float diemgk = rs.getFloat("DIEMGK");
                if (rs.wasNull()) {
                    gra.setDiemgk(null);
                } else { gra.setDiemgk(diemgk); }
                
                // Kiểm tra giá trị null cho trường DIEMCK
                float diemck = rs.getFloat("DIEMCK");
                if (rs.wasNull()) {
                    gra.setDiemck(null);
                } else { gra.setDiemck(diemck); }
                
                gra.setDiemtbhe10();
                gra.setGhichu(rs.getString("GHICHU"));
                
                gradeList.add(gra);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeList;
    }
    // thêm 1 điểm vào danh sách điểm
    public boolean addDiemTrongHK( Grade diem){
        String sql = "INSERT INTO tbl_Grade(SDT, IDMON, HOCKY, TENMON, SOTINCHI, DIEMCC, DIEMGK, DIEMCK, DIEMTBM, GHICHU) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, diem.getSdt());
            ps.setString(2, diem.getIdMon());
            ps.setString(3, diem.getHocKy());
            ps.setString(4, diem.getTenMon());
            ps.setInt(5, diem.getSotinchi());
            if (diem.getDiemcc() != null) {
                BigDecimal diemccValue = BigDecimal.valueOf(diem.getDiemcc());
                ps.setBigDecimal(6, diemccValue);
            } else { ps.setNull(6, Types.DECIMAL);}
            
            if (diem.getDiemgk() != null) {
                BigDecimal diemgkValue = BigDecimal.valueOf(diem.getDiemgk());
                ps.setBigDecimal(7, diemgkValue);
            } else { ps.setNull(7, Types.DECIMAL);}
            
            if (diem.getDiemck() != null) {
                BigDecimal diemckValue = BigDecimal.valueOf(diem.getDiemck());
                ps.setBigDecimal(8, diemckValue);
            } else { ps.setNull(8, Types.DECIMAL);}
            
            if (diem.getDiemtbhe10() != null) {
                //ps.setFloat(9, diem.getDiemtbhe10().floatValue());
                BigDecimal diemtbmValue = BigDecimal.valueOf(diem.getDiemtbhe10());
                ps.setBigDecimal(9, diemtbmValue);
            } else { ps.setNull(9, Types.DECIMAL);}
            
            ps.setString(10, diem.getGhichu());
          
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // xóa 1 điểm trong danh sách
    public boolean deleteGrade(Grade gra) {
        String sql = "DELETE FROM tbl_Grade WHERE SDT = ? AND IDMON = ? AND HOCKY = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gra.getSdt());
            ps.setString(2, gra.getIdMon());
            ps.setString(3, gra.getHocKy());
 
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // cập nhật 1 điểm trong danh sách
    public boolean updateGrade(Grade gra) {
        String sql = "UPDATE tbl_Grade SET DIEMCC = ?, DIEMGK = ?, DIEMCK = ?, DIEMTBM = ? "
                + "WHERE SDT = ? AND IDMON = ? AND HOCKY = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            if (gra.getDiemcc() != null) {
                BigDecimal diemccValue = BigDecimal.valueOf(gra.getDiemcc());
                ps.setBigDecimal(1, diemccValue);
            } else {
                ps.setNull(1, Types.DECIMAL);
            }

            if (gra.getDiemgk() != null) {
//                ps.setFloat(2, gra.getDiemgk().floatValue());
                BigDecimal diemgkValue = BigDecimal.valueOf(gra.getDiemgk());
                ps.setBigDecimal(2, diemgkValue);
            } else {
                ps.setNull(2, Types.DECIMAL);
            }

            if (gra.getDiemck() != null) {
                //ps.setFloat(3, gra.getDiemck().floatValue());
                BigDecimal diemckValue = BigDecimal.valueOf(gra.getDiemck());
                ps.setBigDecimal(3, diemckValue);
            } else {
                ps.setNull(3, Types.DECIMAL);
            }

            if (gra.getDiemcc() != null && gra.getDiemgk() != null && gra.getDiemck() != null) {
                //ps.setFloat(4, gra.getDiemtbhe10().floatValue());
                BigDecimal diemtbmValue = BigDecimal.valueOf(gra.getDiemtbhe10());
                ps.setBigDecimal(4, diemtbmValue);
            } else {
                ps.setNull(4, Types.DECIMAL);
            }

            ps.setString(5, gra.getSdt());
            ps.setString(6, gra.getIdMon());
            ps.setString(7, gra.getHocKy());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // cập nhật ghi chú 
    public boolean updateNoteOfGrade(Grade gra) {
        String sql = "UPDATE tbl_Grade SET GHICHU = ? "
                + "WHERE SDT = ? AND IDMON = ? AND HOCKY = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gra.getGhichu());
            ps.setString(2, gra.getSdt());
            ps.setString(3, gra.getIdMon());
            ps.setString(4, gra.getHocKy());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // lấy đầy đủ thông tin của 1 điểm trong danh sách
    public Grade getGradebyGrade(Grade grade){
        Grade gra = grade;
        String sql = "SELECT * FROM tbl_Grade WHERE SDT = ? AND IDMON = ? AND HOCKY = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gra.getSdt());
            ps.setString(2, gra.getIdMon());
            ps.setString(3, gra.getHocKy());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                // Kiểm tra giá trị null cho trường DIEMCC
                float diemcc = rs.getFloat("DIEMCC");
                if (rs.wasNull()) {
                    gra.setDiemcc(null);
                } else { gra.setDiemcc(diemcc); }
                
                // Kiểm tra giá trị null cho trường DIEMGK
                float diemgk = rs.getFloat("DIEMGK");
                if (rs.wasNull()) {
                    gra.setDiemgk(null);
                } else { gra.setDiemgk(diemgk); }
                
                // Kiểm tra giá trị null cho trường DIEMCK
                float diemck = rs.getFloat("DIEMCK");
                if (rs.wasNull()) {
                    gra.setDiemck(null);
                } else { gra.setDiemck(diemck); }
                
                gra.setDiemtbhe10();
                gra.setGhichu(rs.getString("GHICHU"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gra;
    }
    
    // lấy id môn qua tên môn
    public String getSubIDByName(String ten) throws UnsupportedEncodingException {
        String kq = "";
        String sql = "SELECT * FROM tbl_Subject WHERE TENSUB = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                kq = rs.getString("MASUB");
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

// real
        public boolean updateAccImg(Account acc, byte[] photo) {
            String sql = "UPDATE tbl_Account SET AVATAR = ? "
                    + "WHERE SDT = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setBytes(1, photo);
                ps.setString(2, acc.getSdt());

                return ps.executeUpdate() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        
    // lấy điểm tb của 1 môn của toàn thể sinh viên trong hệ thống
    public double getDTB_All(String idmon){
        double diem = 0;
        double sodiem = 0;
        ArrayList< Grade> gradeList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Grade WHERE IDMON= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idmon);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grade gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                // Kiểm tra giá trị null cho trường DIEMCC
                float diemcc = rs.getFloat("DIEMCC");
                if (rs.wasNull()) {
                    gra.setDiemcc(null);
                } else { gra.setDiemcc(diemcc); }
                
                // Kiểm tra giá trị null cho trường DIEMGK
                float diemgk = rs.getFloat("DIEMGK");
                if (rs.wasNull()) {
                    gra.setDiemgk(null);
                } else { gra.setDiemgk(diemgk); }
                
                // Kiểm tra giá trị null cho trường DIEMCK
                float diemck = rs.getFloat("DIEMCK");
                if (rs.wasNull()) {
                    gra.setDiemck(null);
                } else { gra.setDiemck(diemck); }
                
                gra.setDiemtbhe10();
                gra.setGhichu(rs.getString("GHICHU"));
                
                gradeList.add(gra); 
            }
            for (Grade grade : gradeList) {
                if(grade.getDiemtbhe10() != null){
                    diem += grade.getDiemtbhe10();
                    sodiem += 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diem/sodiem;
    }

    // lấy điểm trung bình toàn trường của 1 học sinh theo môn
    public double getDTB_Lop(String idmon, Account acc){
        double diem = 0;
        double sodiem = 0;
        ArrayList< Grade> gradeList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Grade WHERE IDMON= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idmon);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grade gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                // Kiểm tra giá trị null cho trường DIEMCC
                float diemcc = rs.getFloat("DIEMCC");
                if (rs.wasNull()) {
                    gra.setDiemcc(null);
                } else { gra.setDiemcc(diemcc); }
                
                // Kiểm tra giá trị null cho trường DIEMGK
                float diemgk = rs.getFloat("DIEMGK");
                if (rs.wasNull()) {
                    gra.setDiemgk(null);
                } else { gra.setDiemgk(diemgk); }
                
                // Kiểm tra giá trị null cho trường DIEMCK
                float diemck = rs.getFloat("DIEMCK");
                if (rs.wasNull()) {
                    gra.setDiemck(null);
                } else { gra.setDiemck(diemck); }
                
                gra.setDiemtbhe10();
                gra.setGhichu(rs.getString("GHICHU"));
                
                gradeList.add(gra); 
            }
            for (Grade grade : gradeList) {
                Account account = new DAO_sv().getAccBySdt(grade.getSdt());
                if(grade.getDiemtbhe10() != null){
                    if(acc.getLop().equals(account.getLop())){
                        diem += grade.getDiemtbhe10();
                        sodiem += 1;                        
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diem/sodiem;
    }
    
//  lấy kết quả học tập tích lũy
     public KetQuaTichLuy getKetQuaTichLuy(String sdt){
        KetQuaTichLuy ketqua = new KetQuaTichLuy();
        int soTinDangKy = 0;
        int soTinDat = 0;
        int soTinNo = 0;
        float tongDiem = 0;
        // lấy các giá trị điểm cao nhất của 1 sinh viên
        String sql = "SELECT g1.*\n" +
            "FROM tbl_Grade g1\n" +
            "LEFT JOIN tbl_Grade g2\n" +
            "    ON g1.SDT = g2.SDT\n" +
            "    AND g1.IDMON = g2.IDMON\n" +
            "    AND COALESCE(g1.DIEMTBM, -1) < COALESCE(g2.DIEMTBM, -1)\n" +
            "WHERE g2.SDT IS NULL\n" +
            "    AND g1.SDT = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grade gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                BigDecimal diemccValue = rs.getBigDecimal("DIEMCC");
                if (diemccValue != null) {
                    gra.setDiemcc(diemccValue.floatValue());
                }else {
                    gra.setDiemcc(null);
                }

                BigDecimal diemgkValue = rs.getBigDecimal("DIEMGK");
                if (diemgkValue != null) {
                    gra.setDiemgk(diemgkValue.floatValue());
                }else {
                    gra.setDiemgk(null);
                }

                BigDecimal diemckValue = rs.getBigDecimal("DIEMCK");
                if (diemckValue != null) {
                    gra.setDiemck(diemckValue.floatValue());
                }else {
                    gra.setDiemck(null);
                }
                gra.setDiemtbhe10();
                
                soTinDangKy += gra.getSotinchi();
                if(gra.getDiemtbhe10() != null){
                    tongDiem += gra.getSotinchi() * gra.getDiemtbhe10();
                    if(gra.getDiemtbhe10() < 4){
                        soTinNo += gra.getSotinchi();
                    }
                    else {
                        soTinDat += gra.getSotinchi();
                    }
                }
            }
            ketqua.setTinDangKy(soTinDangKy);
            ketqua.setTinDat(soTinDat);
            ketqua.setTinNo(soTinNo);
 
            float diemTbHe10 = tongDiem / soTinDangKy;
            // Làm tròn giá trị đến 2 chữ số sau dấu phẩy và thay thế dấu phẩy thành dấu chấm
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US)); // Sử dụng ký tự phân tách phần thập phân là dấu chấm
            String diemTbHe10String = decimalFormat.format(diemTbHe10).replace(",", ".");
            diemTbHe10 = Float.parseFloat(diemTbHe10String);
            ketqua.setDiemTbHe10(diemTbHe10);
            
            ketqua.setDiemAuto();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
//  lấy kết quả học tập theo kỳ của 1 sinh viên
    public KetQuaHocKy getKetQua(String sdt, String hk){
        KetQuaHocKy ketqua = new KetQuaHocKy();
        int soTinDangKy = 0;
        int soTinDat = 0;
        int soTinNo = 0;
        float tongDiem = 0;
        
        String sql = "SELECT * FROM tbl_Grade Where SDT = ? AND HOCKY = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ps.setString(2, hk);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grade gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                gra.setSotinchi(rs.getInt("SOTINCHI"));
                BigDecimal diemccValue = rs.getBigDecimal("DIEMCC");
                if (diemccValue != null) {
                    gra.setDiemcc(diemccValue.floatValue());
                }else {
                    gra.setDiemcc(null);
                }

                BigDecimal diemgkValue = rs.getBigDecimal("DIEMGK");
                if (diemgkValue != null) {
                    gra.setDiemgk(diemgkValue.floatValue());
                }else {
                    gra.setDiemgk(null);
                }

                BigDecimal diemckValue = rs.getBigDecimal("DIEMCK");
                if (diemckValue != null) {
                    gra.setDiemck(diemckValue.floatValue());
                }else {
                    gra.setDiemck(null);
                }
                gra.setDiemtbhe10();
                
                soTinDangKy += gra.getSotinchi();
                if(gra.getDiemtbhe10() != null){
                    tongDiem += gra.getSotinchi() * gra.getDiemtbhe10();
                    if(gra.getDiemtbhe10() < 4){
                        soTinNo += gra.getSotinchi();
                    }
                    else {
                        soTinDat += gra.getSotinchi();
                    }
                }
            }
            ketqua.setTinDangKy(soTinDangKy);
            ketqua.setTinDat(soTinDat);
            ketqua.setTinNo(soTinNo);
 
            float diemTbHe10 = tongDiem / soTinDangKy;
            // Làm tròn giá trị đến 2 chữ số sau dấu phẩy và thay thế dấu phẩy thành dấu chấm
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US)); // Sử dụng ký tự phân tách phần thập phân là dấu chấm
            String diemTbHe10String = decimalFormat.format(diemTbHe10).replace(",", ".");
            diemTbHe10 = Float.parseFloat(diemTbHe10String);
            ketqua.setDiemTbHe10(diemTbHe10);
            
            ketqua.setDiemAuto();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
    // lấy ra top 10 sinh viên có số tín chỉ tích lũy cao nhất
//    public ArrayList< TopStudent2> getTopSvbyTinchiTichLuy(int a){
//        ArrayList< TopStudent2> accList = new ArrayList<>();
//        String sql;
//        String x;
//        switch (a) {
//            case 0:
//                x = "TongTinHocHoanThanh DESC, TongTinDangKy DESC, TileHoanThanh";
//                break;
//            case 1:
//                x = "TongTinDangKy DESC, TongTinHocHoanThanh DESC, TileHoanThanh ";
//                break;
//            case 2:
//                x = "TileHoanThanh DESC,TongTinHocHoanThanh DESC, TongTinDangKy ";
//                break;
//            default:
//                // Xử lý khi giá trị a không khớp với bất kỳ trường hợp nào
//                x = "TongTinHocHoanThanh DESC, TongTinDangKy DESC, TileHoanThanh";
//        }
//        
//        sql = String.format("WITH maxGrade AS (\n" +
//            "    SELECT IDMON, SDT, MAX(DIEMTBM) AS MaxDIEMTBM\n" +
//            "    FROM tbl_Grade\n" +
//            "    GROUP BY IDMON, SDT\n" +
//            ")\n" +
//            "SELECT TOP 10 a.SDT, a.HOTEN,\n" +
//            "    SUM(g.SOTINCHI) AS TongTinDangKy,\n" +
//            "    SUM(CASE WHEN g.DIEMTBM IS NOT NULL AND g.DIEMTBM >= 4 THEN g.SOTINCHI ELSE 0 END) AS TongTinHocHoanThanh,\n" +
//            "    SUM(CASE WHEN g.DIEMTBM IS NOT NULL AND g.DIEMTBM < 4 THEN g.SOTINCHI ELSE 0 END) AS TongTinNo,\n" +
//            "    a.truong,\n" +
//            "    a.quequan,\n" +
//            "    a.avatar,\n" +
//            "    CAST((SUM(CASE WHEN g.DIEMTBM IS NOT NULL AND g.DIEMTBM >= 4 THEN g.SOTINCHI ELSE 0 END) * 100.0) / NULLIF(SUM(g.SOTINCHI), 0) AS DECIMAL(10, 2)) AS TileHoanThanh\n" +
//            "FROM tbl_Account a\n" +
//            "JOIN maxGrade ON a.SDT = maxGrade.SDT\n" +
//            "JOIN tbl_Grade g ON a.SDT = g.SDT AND maxGrade.IDMON = g.IDMON AND (\n" +
//            "    (g.DIEMTBM = maxGrade.MaxDIEMTBM) OR (g.DIEMTBM IS NULL AND NOT EXISTS (\n" +
//            "        SELECT 1\n" +
//            "        FROM tbl_Grade\n" +
//            "        WHERE SDT = g.SDT AND IDMON = g.IDMON AND DIEMTBM IS NOT NULL\n" +
//            "    ))\n" +
//            ")\n" +
//            "GROUP BY a.SDT, a.HOTEN, a.truong, a.quequan, a.avatar\n" +
//            "ORDER BY %s DESC;", x) ;
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                TopStudent2 acc = new TopStudent2();
//                acc.setSdt(rs.getString("SDT"));
//                acc.setSotinTichLuy(rs.getInt("TongTinDangKy"));
//                acc.setSotinDat(rs.getInt("TongTinHocHoanThanh"));
//                acc.setSotinNo(rs.getInt("TongTinNo"));
//                acc.setName(rs.getString("HOTEN"));
//                acc.setQueQuan(rs.getString("quequan"));
//                acc.setTruong(rs.getString("truong"));
//                acc.setAvatar(rs.getBlob("avatar"));
//                
//                accList.add(acc);
//            }  
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return accList;
//    }
 
    public ArrayList<String> dsMonChung(String sdt1, String sdt2){
        ArrayList<String> dsmon = new ArrayList<>();
        String sql ="SELECT IDMON, TENMON\n" +
            "FROM tbl_Grade\n" +
            "WHERE SDT IN (?, ?)\n" +
            "AND diemtbm IS NOT NULL "+
            "GROUP BY IDMON, TENMON\n" +
            "HAVING COUNT(DISTINCT SDT) = 2;";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt1);
            ps.setString(2, sdt2);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dsmon.add(rs.getString("TENMON"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsmon;
    }

     public Grade getGradeByTenMon(String sdt,String tenmon){
        Grade gra = new Grade();
        String sql = "SELECT TOP 1 *\n" +
            "FROM tbl_Grade\n" +
            "WHERE SDT = ? AND TENMON = ?\n" +
            "ORDER BY DIEMTBM DESC;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ps.setString(2, tenmon);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gra = new Grade(rs.getString("SDT"),
                        rs.getString("IDMON"),
                        rs.getString("HOCKY"));
                gra.setTenMon(rs.getString("TENMON"));
                // Kiểm tra giá trị null cho trường DIEMCC
                float diemcc = rs.getFloat("DIEMCC");
                if (rs.wasNull()) {
                    gra.setDiemcc(null);
                } else { gra.setDiemcc(diemcc); }
                
                // Kiểm tra giá trị null cho trường DIEMGK
                float diemgk = rs.getFloat("DIEMGK");
                if (rs.wasNull()) {
                    gra.setDiemgk(null);
                } else { gra.setDiemgk(diemgk); }
                
                // Kiểm tra giá trị null cho trường DIEMCK
                float diemck = rs.getFloat("DIEMCK");
                if (rs.wasNull()) {
                    gra.setDiemck(null);
                } else { gra.setDiemck(diemck); }
                
                gra.setDiemtbhe10();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gra;
    }
}