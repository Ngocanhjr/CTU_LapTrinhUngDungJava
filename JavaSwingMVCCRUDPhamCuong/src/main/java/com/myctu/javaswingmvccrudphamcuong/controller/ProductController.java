/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.javaswingmvccrudphamcuong.controller;

import com.myctu.javaswingmvccrudphamcuong.model.Product;
import com.myctu.javaswingmvccrudphamcuong.model.ProductDAO;
import com.myctu.javaswingmvccrudphamcuong.model.ProductTableModel;
import com.myctu.javaswingmvccrudphamcuong.view.ProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ASUS
 */
public class ProductController {

    private ProductView productView;

    private ProductDAO productDAO;
//fix
    private ProductTableModel tableModel;

    public ProductController(ProductView view) {
        this.productView = view;

        productDAO = new ProductDAO();
//fix
        tableModel = new ProductTableModel();

        productView.addTableSelecctionListener(new TableSelecctionListener());

        productView.addRefreshProductListener(new RefreshProductListener());

        productView.addAddProductListener(new AddProductListener());

        productView.addEditProductListener(new EditProductListener());

        productView.addDeleteProductListener(new DeleteProductListener());

    }

    public void showProductView() {
        try {
            //Đọc dữ liệu từ csdl về để hiển thị lên view
            List<Product> products = productDAO.getListProducts();
//add fix            
            tableModel.setData(products);

            productView.setTableModel(tableModel);

            productView.setLocationRelativeTo(null);
            productView.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class AddProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("add listener!");
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.add(product);

                if (success) {
                    try {
                        //Tự thêm try catch

//                        productView.showListProduct(productDAO.getListProducts());
                        tableModel.setData(productDAO.getListProducts());
                        JOptionPane.showMessageDialog(productView, "Added new product!!");
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(productView, "Added fail!");
                }

            }
        }
    }

    class EditProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.edit(product);

                if (success) {
                    JOptionPane.showMessageDialog(productView, "Edit successfull!");
                } else {
                    JOptionPane.showMessageDialog(productView, "Edit fail!");
                }
            }
        }
    }

    class DeleteProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.delete(product);

                if (success) {
                    JOptionPane.showMessageDialog(productView, "Deleted successfull!");
                } else {
                    JOptionPane.showMessageDialog(productView, "Deleted fail!");
                }
            }
        }

    }

    class RefreshProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
//                productView.showListProduct(productDAO.getListProducts());
                tableModel.setData(productDAO.getListProducts());
                System.out.println("Refresh ~~");
            } catch (SQLException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class TableSelecctionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            productView.fillInputForm();
        }

    }
}
