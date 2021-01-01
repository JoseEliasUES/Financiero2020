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
                prod.setId(rs.getInt(1));
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
                prod.setId(rs.getInt(1));
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
