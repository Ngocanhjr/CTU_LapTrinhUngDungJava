/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.javaswingmvccrudphamcuong.model;

import com.myctu.javaswingmvccrudphamcuong.App;
import com.myctu.javaswingmvccrudphamcuong.database.DatabaseUtils;
//import static com.myctu.javaswingmvccrudphamcuong.database.DatabaseUtils.closeConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
     * @throws java.sql.SQLException
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
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Database closed DAO!.");
            }
//            closeConnection(con);
        }
        return products;
    }

    public boolean add(Product pr) {
        Connection con = DatabaseUtils.getConnection();
        String insertSQL = "insert into products (Name, Quantity) values (?, ?)";

        try {
            PreparedStatement stm = con.prepareStatement(insertSQL);

            stm.setString(1, pr.getName());
            stm.setInt(2, pr.getQuantity());

            stm.executeUpdate();

//            System.out.println("Add completely!");
            stm.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //            DatabaseUtils.closeConnection(con);
                con.close();
                System.out.println("Database closed!.");
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean edit(Product pr) {
        Connection con = DatabaseUtils.getConnection();

        String sql = "update products set Name = ?, Quantity = ? where ID = ?";

        try {
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, pr.getName());
            stm.setInt(2, pr.getQuantity());
            stm.setInt(3, pr.getId());
            stm.executeUpdate();

//            System.out.println("Updated!");
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //            DatabaseUtils.closeConnection(con);
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(Product product) {
        Connection con = DatabaseUtils.getConnection();
        String sql = "delete from products where ID = ?";

        try {
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, product.getId());
            stm.executeUpdate();

            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //            DatabaseUtils.closeConnection(con);
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(" closed!.");
        }

        return false;
    }

}
