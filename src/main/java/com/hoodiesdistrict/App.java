package com.hoodiesdistrict;

import com.hoodiesdistrict.dao.ProductoDAO;

public class App {

    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAO();

        productoDAO.eliminarProducto(1);

    }
}