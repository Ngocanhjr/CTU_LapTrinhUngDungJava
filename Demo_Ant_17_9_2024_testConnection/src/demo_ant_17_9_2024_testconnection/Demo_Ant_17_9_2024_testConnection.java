/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo_ant_17_9_2024_testconnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class Demo_Ant_17_9_2024_testConnection {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        System.out.println("test conn");
        String strULR = "jdbc:sqlserver://localhost:1433;databseName=EXTOUR;user=sa;password=12345678;"
                + "encrypt=true;trustServerCertificate=true";
        
        try {
            Connection conn = DriverManager.getConnection(strULR);
//            Statement st = conn.createStatement();
            System.out.println("Connection Successful");
            
            DatabaseMetaData data = (DatabaseMetaData) conn.getMetaData();
            System.out.println("Driver Name " + data.getDriverName());
            System.out.println("Driver Version " + data.getDriverVersion());
            System.out.println("Database name " + data.getDatabaseProductName());
            
//            String createTableSQL = "CREATE TABLE KhachHang (ID INT PRIMARY KEY, Ten NVARCHAR(100), Email NVARCHAR(100), SoDienThoai NVARCHAR(15))";
//            st.executeUpdate(createTableSQL);
//            System.out.println("Table created successfully.");

            // 2. Chèn dữ liệu
//            String insertSQL = "INSERT INTO KhachHang (ID, Ten, Email, SoDienThoai) VALUES (1, 'Nguyen Van A', 'nguyenvana@example.com', '0123456789')";
//            st.executeUpdate(insertSQL);
//            System.out.println("Data inserted successfully.");

            // 3. Lấy dữ liệu
//            String selectSQL = "select * from [dbo].[booking]";
//String sql = "SELECT * FROM booking";
//PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("tour_id"));
//                System.out.println("Tên: " + rs.getString("customer_id"));
//                System.out.println("Date: " + rs.getString("book_date"));
//            }

//             4. Cập nhật dữ liệu
//            String updateSQL = "UPDATE KhachHang SET Email = 'newemail@example.com' WHERE ID = 1";
//            st.executeUpdate(updateSQL);
//            System.out.println("Data updated successfully.");

//            // 5. Xóa dữ liệu
//            String deleteSQL = "DELETE FROM KhachHang WHERE ID = 1";
//            st.executeUpdate(deleteSQL);
//            System.out.println("Data deleted successfully.");
            
            
//            String sel = "SELECT * FROM [dbo].[tour]";
//      
//            
//            ResultSet rs = st.executeQuery(sel);
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("ID"));
//                System.out.println("Tên: " + rs.getString("Ten"));
//                System.out.println("Email: " + rs.getString("Email"));
//                System.out.println("Số điện thoại: " + rs.getString("SoDienThoai"));
//            }

            String sql = "SELECT * FROM booking"; // Chuỗi truy vấn
            PreparedStatement pst = conn.prepareStatement(sql); // Tạo PreparedStatement
            
            ResultSet rs = pst.executeQuery(); // Thực thi truy vấn

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("tour_id"));
                System.out.println("Tên: " + rs.getString("customer_id"));
                System.out.println("Date: " + rs.getString("book_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo_Ant_17_9_2024_testConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
