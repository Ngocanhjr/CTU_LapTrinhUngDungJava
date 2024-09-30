package com.myctu.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {

    public static Connection getConnection() {
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=BAN_HANG;user=sa;password=12345678;"
                + "encrypt=true;trustServerCertificate=true";
        try {
            // Kết nối tới cơ sở dữ liệu
            return DriverManager.getConnection(url);
        } catch (SQLException ex) {
            // Ghi log khi có lỗi kết nối
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Trả về null nếu kết nối thất bại
        return null;
    }

    public static void getMetaData() throws SQLException {
        Connection conn = null;
        try {
            // Lấy kết nối
            conn = getConnection();
            if (conn != null) {
                // Lấy metadata từ kết nối
                DatabaseMetaData data = conn.getMetaData();
                System.out.println("Driver Name: " + data.getDriverName());
                System.out.println("Driver Version: " + data.getDriverVersion());
                System.out.println("Database Name: " + data.getDatabaseProductName());
                System.out.println("Connection successful");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException ex) {
            // Ghi log khi có lỗi
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đảm bảo đóng kết nối sau khi lấy metadata
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        // Gọi phương thức getMetaData để kiểm tra kết nối và lấy thông tin
        getMetaData();
    }
}
