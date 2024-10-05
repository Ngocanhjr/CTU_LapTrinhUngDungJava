/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.javaswingmvccrudphamcuong.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DatabaseUtils {

    public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=PRODUCT;user=sa;password=12345678;"
            + "encrypt=true;trustServerCertificate=true";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

//            System.out.println("connect successfull");
//
//            DatabaseMetaData data = (DatabaseMetaData) conn.getMetaData();
//            System.out.println("Driver Name: " + data.getDriverName());
//            System.out.println("Driver Version: " + data.getDriverVersion());
//            System.out.println("Database Name: " + data.getDatabaseProductName());

            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database closed!.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//       Connection conn =  getConnection();
//    }
}
