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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.DetVenta;
import modelos.Empleados;
import modelos.Producto;
import modelos.Venta;

public class DAO_Venta {

    private final Conexion conexion;
    private Producto usuario;

    public DAO_Venta() {
        this.conexion = new Conexion();
    }

    public void GuardarVenta(Venta venta) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO venta VALUES('" + 0 + "','" + venta.getFecha() + "','" + venta.getEmpleado() + "','"
                    + venta.getCliente() + "','" + venta.getFactura() + "')");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void GuardarDetVenta(DetVenta detV) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO detventa VALUES('" + 0 + "','" + detV.getIdVenta() + "','"
                    + detV.getIdProducto() + "','" + detV.getCantidad() + "','" + detV.getMeses() + "','" + detV.getEstado() + "','" + detV.getCuota() + "','" + detV.getTotal()+ "')");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int selectVenta() throws SQLException {
        ResultSet rs = null;
        int idVenta = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "select id_venta from venta order by id_venta desc limit 1";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                idVenta = (rs.getInt(1));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return idVenta;
    }
    
     public int selectDetVenta() throws SQLException {
        ResultSet rs = null;
        int idVenta = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "select id_detVenta from detventa order by id_detVenta desc limit 1";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                idVenta = (rs.getInt(1));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return idVenta;
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

    public ArrayList<Producto> getProductosPVenta() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "p.id_producto,\n"
                    + "p.nombre,\n"
                    + "p.stock,\n"
                    + "dc.precCompra\n"
                    + "FROM\n"
                    + "productos as p\n"
                    + "INNER JOIN detcompra as dc ON dc.id_producto = p.id_producto";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProd(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setStock(rs.getInt(3));
                prod.setPrecio(rs.getDouble(4));
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

    public int getNumFactu() throws SQLException {
        ResultSet rs = null;
        int num = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT count(id_venta) FROM venta";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                num = (rs.getInt(1));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return num;

    }

}
