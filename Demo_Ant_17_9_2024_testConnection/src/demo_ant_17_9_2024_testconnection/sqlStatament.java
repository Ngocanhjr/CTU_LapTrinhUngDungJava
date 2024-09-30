/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_ant_17_9_2024_testconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ASUS
 */
public class sqlStatament {
    public static void main(String[] args) {
        String strURL = "jdbc:sqlserver://localhost:1433;databaseName=EXTOUR;user=sa;password=12345678; "
                + "encrypt=true;trustServerCertificate=true";

        try (Connection conn = DriverManager.getConnection(strURL)) {
            String sql = "SELECT * FROM booking"; // Chuỗi truy vấn
            PreparedStatement pst = conn.prepareStatement(sql); // Tạo PreparedStatement
//            Statement st = conn.createStatement();
            
            String createTableSQL = "CREATE TABLE KhachHang (ID INT PRIMARY KEY, Ten NVARCHAR(100), Email NVARCHAR(100), SoDienThoai NVARCHAR(15))";
            pst.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");
             // 2. Chèn dữ liệu
            
//            String insertSQL = "INSERT INTO KhachHang (ID, Ten, Email, SoDienThoai) VALUES (1, 'Nguyen Van A', 'nguyenvana@example.com', '0123456789')";
//            pst.executeUpdate(insertSQL);
//            System.out.println("Data inserted successfully.");

//            ResultSet rs = pst.executeQuery(); // Thực thi truy vấn
//
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("tour_id"));
//                System.out.println("Tên: " + rs.getString("customer_id"));
//                System.out.println("Date: " + rs.getString("book_date"));
//            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi
        }
    }
}
