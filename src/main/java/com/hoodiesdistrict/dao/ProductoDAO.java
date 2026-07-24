package com.hoodiesdistrict.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hoodiesdistrict.conexion.Conexion;
import com.hoodiesdistrict.modelo.Producto;

public class ProductoDAO {

    public void insertarProducto(Producto producto) {

        String sql = "INSERT INTO productos(nombre, precio, cantidad) VALUES (?, ?, ?)";

        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setDouble(2, producto.getPrecio());
            sentencia.setInt(3, producto.getCantidad());

            sentencia.executeUpdate();

            System.out.println("Producto registrado correctamente.");

        } catch (SQLException e) {

            System.out.println("Error al insertar: " + e.getMessage());

        }
    }

    public List<Producto> listarProductos() {

        List<Producto> listaProductos = new ArrayList<>();

        String sql = "SELECT * FROM productos";

        try (
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                Producto producto = new Producto();

                producto.setId(resultado.getInt("id"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCantidad(resultado.getInt("cantidad"));

                listaProductos.add(producto);
            }

        } catch (SQLException e) {

            System.out.println("Error al consultar: " + e.getMessage());

        }

        return listaProductos;
    }
    
    public void actualizarProducto(Producto producto) {

    String sql = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";

    try (
        Connection conexion = Conexion.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)
    ) {

        sentencia.setString(1, producto.getNombre());
        sentencia.setDouble(2, producto.getPrecio());
        sentencia.setInt(3, producto.getCantidad());
        sentencia.setInt(4, producto.getId());

        sentencia.executeUpdate();

        System.out.println("Producto actualizado correctamente.");

    } catch (SQLException e) {

        System.out.println("Error al actualizar: " + e.getMessage());

    }
}public void eliminarProducto(int id) {

    String sql = "DELETE FROM productos WHERE id = ?";

    try (
        Connection conexion = Conexion.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)
    ) {

        sentencia.setInt(1, id);

        sentencia.executeUpdate();

        System.out.println("Producto eliminado correctamente.");

    } catch (SQLException e) {

        System.out.println("Error al eliminar: " + e.getMessage());

    }
}
}