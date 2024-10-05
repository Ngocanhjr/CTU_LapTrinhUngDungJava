/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myctu.javaswingmvccrudphamcuong;

import com.myctu.javaswingmvccrudphamcuong.model.Product;
import com.myctu.javaswingmvccrudphamcuong.model.ProductDAO;
import com.myctu.javaswingmvccrudphamcuong.view.ProductView;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class JavaSwingMVCCRUDPhamCuong {

    public static void main(String[] args) {
        new ProductView();
//        try {
//            
//            ProductDAO productDAO =new ProductDAO();
//            
//            List<Product> products  = productDAO.getListProducts();
//            
//            for(Product p : products){
//                System.out.println(p.getName());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(JavaSwingMVCCRUDPhamCuong.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
