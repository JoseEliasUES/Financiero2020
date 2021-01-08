package DAO;

/**
 *
 * @author Josue
 */
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Categoria;
import modelos.MargenGanancia;
import modelos.Producto;

public class DAO_Productos {

    private final Conexion conexion;
    private Producto usuario;

    public DAO_Productos() {
        this.conexion = new Conexion();
    }

    public ArrayList<Producto> getProductos() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProd(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setStock(rs.getInt(5));
                prod.setCodCategoria(rs.getInt(7));
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;

    }

    public ArrayList<MargenGanancia> getMargenGanancia() throws SQLException {
        ArrayList<MargenGanancia> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM margenganancia";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MargenGanancia prod = new MargenGanancia();
                prod.setPorcentaje(rs.getDouble(3));
                prod.setCategoria2(rs.getInt(4));
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return productos;
    }

    public ArrayList<Producto> getProductosPVenta() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "p.id_producto,\n"
                    + "p.nombre,\n"
                    + "p.stock,\n"
                    + "dc.precCompra,\n"
                    + "categoria.descripcion,\n"
                    + "categoria.id_categoria\n"
                    + "FROM\n"
                    + "productos AS p\n"
                    + "INNER JOIN detcompra AS dc ON dc.id_producto = p.id_producto\n"
                    + "INNER JOIN categoria ON p.id_categoria = categoria.id_categoria";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProd(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setStock(rs.getInt(3));
                prod.setPrecio(rs.getDouble(4));
                prod.setIdcategoria(rs.getInt(6));
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;

    }

    public ArrayList<Producto> getDetProducto() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM detcompra where ";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProd(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setStock(rs.getInt(5));
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;

    }

}
