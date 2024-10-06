/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.myctu.javaswingmvccrudphamcuong;

import com.myctu.javaswingmvccrudphamcuong.controller.ProductController;
//import com.myctu.javaswingmvccrudphamcuong.model.ProductDAO_Demo;
import com.myctu.javaswingmvccrudphamcuong.view.ProductView;
import java.awt.EventQueue;

/**
 *
 * @author ASUS
 */
public class App {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                
                ProductView newView = new ProductView();

                ProductController control = new ProductController(newView);

                control.showProductView();
            }
        });

//        new ProductView();
//        try {
//            
//            ProductDAO_Demo productDAO =new ProductDAO_Demo();
//            
//            List<Product> products  = productDAO.getListProducts();
//            
//            for(Product p : products){
//                System.out.println(p.getName());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
