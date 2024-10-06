/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.javaswingmvccrudphamcuong.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ProductTableModel extends AbstractTableModel {

    private String[] columnNames = {"ID", "Product Name", "Quantity"};

    private List<Product> products;

    public ProductTableModel() {
        products = new ArrayList<>();
    }

    public void setData(List<Product> products) {
        this.products = products;
        /*
        Mỗi khi dữ liệu của TableModel đc cập nhật qua hàm setData thì
        tableModel sẽ thông báo cho cái table trong view cập nhật lại  
         */
        System.out.println("Data set: " + products.size() + " products");
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
//        System.out.println("Row: " + rowIndex + ", Column: " + columnIndex);
//        System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity());
        switch (columnIndex) {
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getQuantity();

        }

        return null;

    }
}
