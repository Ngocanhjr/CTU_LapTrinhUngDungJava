/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myctu.testconnect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class TestConnect {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String connURL = "jdbc:sqlserver://localhost:1433;databaseName=EXTOUR;user=sa;password=12345678;"
                + "encrypt=true;trustServerCertificate=true";
        try {
            Connection conn = DriverManager.getConnection(connURL);
            DatabaseMetaData data = (DatabaseMetaData)conn.getMetaData();
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
            
            ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("tour_id"));
                System.out.println("Tên: " + rs.getString("customer_id"));
                System.out.println("Date: " + rs.getString("book_date"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TestConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
