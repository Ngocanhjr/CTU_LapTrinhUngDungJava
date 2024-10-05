/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.javaswingmvccrudphamcuong.model;

import com.myctu.javaswingmvccrudphamcuong.JavaSwingMVCCRUDPhamCuong;
import com.myctu.javaswingmvccrudphamcuong.database.DatabaseUtils;
import static com.myctu.javaswingmvccrudphamcuong.database.DatabaseUtils.closeConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ProductDAO {

    public ProductDAO() {

    }

    /**
     *
     * @return @throws java.sql.SQLException
     */
    public List<Product> getListProducts() throws SQLException {
        Connection con = DatabaseUtils.getConnection();

        List<Product> products = new ArrayList<>();

        String sqlSelect = "select * from products";

        try {
            Statement selectStatement;
            ResultSet result;
            selectStatement = con.createStatement();
            result = selectStatement.executeQuery(sqlSelect);

            while (result.next()) {
                int id = result.getInt("ID");
                String name = result.getString("Name");
                int quantity = result.getInt("Quantity");

                Product product = new Product(id, name, quantity);
                products.add(product);
            }

            selectStatement.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(JavaSwingMVCCRUDPhamCuong.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            if (con != null && !con.isClosed()) {
//                con.close();
//                System.out.println("Database closed!.");
//            }
            closeConnection(con);
        }
        return products;
    }

    public void add(Product pr) {
        Connection con = DatabaseUtils.getConnection();
        String insertSQL = "insert into products (Name, Quantity) values (?, ?)";
        
        try {
            PreparedStatement stm = con.prepareStatement(insertSQL);
            
            stm.setString(1, pr.getName());
            stm.setInt(2, pr.getQuantity());
            
            stm.executeUpdate();
            
            System.out.println("Add completely!");
            
            stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DatabaseUtils.closeConnection(con);
        }
        
    }
    
    public void edit(Product pr){
        Connection con = DatabaseUtils.getConnection();
        
        String sql = "update products set Name = ?, Quantity = ? where ID = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, pr.getName());
            stm.setInt(2, pr.getQuantity());
            stm.setInt(3, pr.getId());
            stm.executeUpdate();
            
            System.out.println("Updated!");
            
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DatabaseUtils.closeConnection(con);
        }
        
    }
}
