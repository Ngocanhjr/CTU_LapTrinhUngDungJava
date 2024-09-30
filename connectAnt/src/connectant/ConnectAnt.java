/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectant;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.DatabaseMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class ConnectAnt {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String connURL = "jdbc:sqlserver://localhost:1433;databaseName=EXTOUR;user=sa;password=12345678;"
                + "encrypt=true;trustServerCertificate=true";
        
        try {
            Connection conn = DriverManager.getConnection(connURL); 
            System.out.println("connect successfull");
            
            DatabaseMetaData data = (DatabaseMetaData) conn.getMetaData();
            System.out.println("Driver Name: " + data.getDriverName());
            System.out.println("Driver Version: " + data.getDriverVersion());
            System.out.println("Database Name: " + data.getDatabaseProductName());
            
            
            Statement st = conn.createStatement();
//            String createTableSQL = "CREATE TABLE KhachHang (ID INT PRIMARY KEY, Ten NVARCHAR(100), Email NVARCHAR(100), SoDienThoai NVARCHAR(15))";
//            st.executeUpdate(createTableSQL);
//            System.out.println("Table created successfully.");
            
            // 2. Chèn dữ liệu
//            String insertSQL = "INSERT INTO KhachHang (ID, Ten, Email, SoDienThoai) VALUES (1, 'Nguyen Van A', 'nguyenvana@example.com', '0123456789')";
//            st.executeUpdate(insertSQL);
//            System.out.println("Data inserted successfully.");

            // 3. Lấy dữ liệu
            String selectSQL = "select * from [dbo].[booking]";
            String sql = "SELECT * FROM booking";
            
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("tour_id"));
                System.out.println("Tên: " + rs.getString("customer_id"));
                System.out.println("Date: " + rs.getString("book_date"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectAnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
