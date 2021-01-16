/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Categoria;
import modelos.Inventario;
import modelos.MarcaV;
import modelos.Producto;
import modelos.Proveedor;
import modelos.RegVentas;

/**
 *
 * @author gemelos
 */
public class DAO_Inventario {

    Conexion conexion;

    public DAO_Inventario() {
        this.conexion = new Conexion();
    }

    public ArrayList<Inventario> getProductos() throws SQLException {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "detcompra.precCompra,\n"
                    + "detcompra.cantidad,\n"
                    + "detcompra.fecha,\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre\n"
                    + "FROM\n"
                    + "detcompra\n"
                    + "INNER JOIN productos ON detcompra.id_producto = productos.id_producto\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setPrecioCompra(rs.getDouble(1));
                inv.setCantidadC(rs.getInt(2));
                inv.setFechaC(rs.getDate(3));
                inv.setNombreC(rs.getString(4));
                inv.setModeloC(rs.getString(5));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(6));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(7));
                inv.setCatC(c);
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;

    }

    public ArrayList<Inventario> getProductosV() throws SQLException {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "detventa.cantidad,\n"
                    + "detventa.total,\n"
                    + "venta.fecha,\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN productos ON detventa.idProd = productos.id_producto\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setCantidadC(rs.getInt(1));
                inv.setPrecioCompra(rs.getDouble(2));
                inv.setFechaC(rs.getDate(3));
                inv.setNombreC(rs.getString(4));
                inv.setModeloC(rs.getString(5));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(6));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(7));
                inv.setCatC(c);
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;

    }

    public ArrayList<Inventario> getProductosE() {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre,\n"
                    + "productos.stock\n"
                    + "FROM\n"
                    + "productos\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setNombreC(rs.getString(1));
                inv.setModeloC(rs.getString(2));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(3));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(4));
                inv.setCatC(c);
                inv.setStock(rs.getInt(5));
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public ArrayList<Inventario> getProductosF(int anio, int mes) {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "detcompra.precCompra,\n"
                    + "detcompra.cantidad,\n"
                    + "detcompra.fecha,\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre\n"
                    + "FROM\n"
                    + "detcompra\n"
                    + "INNER JOIN productos ON detcompra.id_producto = productos.id_producto\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria\n"
                    + "WHERE YEAR(detcompra.fecha) = '" + anio + "' AND MONTH(detcompra.fecha) = '" + mes + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setPrecioCompra(rs.getDouble(1));
                inv.setCantidadC(rs.getInt(2));
                inv.setFechaC(rs.getDate(3));
                inv.setNombreC(rs.getString(4));
                inv.setModeloC(rs.getString(5));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(6));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(7));
                inv.setCatC(c);
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public ArrayList<Inventario> getProductosFV(int anio, int mes) {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "detventa.cantidad,\n"
                    + "detventa.total,\n"
                    + "venta.fecha,\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN productos ON detventa.idProd = productos.id_producto\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria\n"
                    + "WHERE YEAR(venta.fecha) = '" + anio + "' AND MONTH(venta.fecha) = '" + mes + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setCantidadC(rs.getInt(1));
                inv.setPrecioCompra(rs.getDouble(2));
                inv.setFechaC(rs.getDate(3));
                inv.setNombreC(rs.getString(4));
                inv.setModeloC(rs.getString(5));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(6));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(7));
                inv.setCatC(c);
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public ArrayList<Inventario> getProductosF(int anio, int mes, String prod) {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "detcompra.precCompra,\n"
                    + "detcompra.cantidad,\n"
                    + "detcompra.fecha,\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre\n"
                    + "FROM\n"
                    + "detcompra\n"
                    + "INNER JOIN productos ON detcompra.id_producto = productos.id_producto\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria\n"
                    + "WHERE YEAR(detcompra.fecha) = '" + anio + "' AND MONTH(detcompra.fecha) = '" + mes + "'\n"
                    + "AND productos.nombre like '%" + prod + "%'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setPrecioCompra(rs.getDouble(1));
                inv.setCantidadC(rs.getInt(2));
                inv.setFechaC(rs.getDate(3));
                inv.setNombreC(rs.getString(4));
                inv.setModeloC(rs.getString(5));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(6));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(7));
                inv.setCatC(c);
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public ArrayList<Inventario> getProductosFV(int anio, int mes, String prod) {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "detventa.cantidad,\n"
                    + "detventa.total,\n"
                    + "venta.fecha,\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN productos ON detventa.idProd = productos.id_producto\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria\n"
                    + "WHERE YEAR(venta.fecha) = '" + anio + "' AND MONTH(venta.fecha) = '" + mes + "' \n"
                    + "AND productos.nombre like '%" + prod + "%'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setCantidadC(rs.getInt(1));
                inv.setPrecioCompra(rs.getDouble(2));
                inv.setFechaC(rs.getDate(3));
                inv.setNombreC(rs.getString(4));
                inv.setModeloC(rs.getString(5));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(6));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(7));
                inv.setCatC(c);
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public ArrayList<Inventario> getProductosE(String prod) {
        ArrayList<Inventario> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "productos.nombre,\n"
                    + "productos.modelo,\n"
                    + "marca.nombre,\n"
                    + "categoria.catNombre,\n"
                    + "productos.stock\n"
                    + "FROM\n"
                    + "productos\n"
                    + "INNER JOIN marca ON productos.id_marca = marca.id_marca\n"
                    + "INNER JOIN categoria ON productos.id_categoria = categoria.id_categoria\n"
                    + "WHERE productos.nombre like '%" + prod + "%'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setNombreC(rs.getString(1));
                inv.setModeloC(rs.getString(2));
                MarcaV m = new MarcaV();
                m.setMarca(rs.getString(3));
                inv.setMarcaC(m);
                Categoria c = new Categoria();
                c.setnCat(rs.getString(4));
                inv.setCatC(c);
                inv.setStock(rs.getInt(5));
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public ArrayList<RegVentas> getProductosVentas() {
        ArrayList<RegVentas> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "productos.nombre,\n"
                    + "detventa.cantidad,\n"
                    + "venta.fecha,\n"
                    + "clientes.DUI,\n"
                    + "detventa.estado,\n"
                    + "detventa.total\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN productos ON detventa.idProd = productos.id_producto\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN clientes ON venta.cliente = clientes.id_cliente";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                RegVentas inv = new RegVentas();
                inv.setProducto(rs.getString(1));
                inv.setCantidad(rs.getInt(2));
                inv.setFecha(rs.getDate(3));
                inv.setDuiCliente(rs.getString(4));
                if (rs.getInt(5)== 1) {
                    inv.setEstado("Pagado");
                }else{
                    inv.setEstado("Deudor y/o Credito");
                }
                inv.setTotal(rs.getDouble(6));
                productos.add(inv);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

}
