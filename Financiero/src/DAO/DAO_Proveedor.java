package DAO;

/**
 *
 * @author Monica
 */
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Proveedor;

public class DAO_Proveedor {

    private Conexion conexion;
    private Proveedor proveedor;

    public DAO_Proveedor() {
        this.conexion = new Conexion();
    }

    public ArrayList<Proveedor> getProveedor() throws SQLException {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM proveedor";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setDireccion(rs.getString(3));
                pr.setTelefono(rs.getString(4));
                pr.setCorreo(rs.getString(5));
                proveedores.add(pr);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return proveedores;

    }

    public Proveedor getProveedor(String nombre) throws SQLException {
        Proveedor pr = new Proveedor();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM proveedor where nombre = '" + nombre + "'");

            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setTelefono(rs.getString(3));
                pr.setDireccion(rs.getString(4));
                pr.setCorreo(rs.getString(5));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return pr;
    }

    public void nuevoProv(Proveedor prov) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO proveedor (\n"
                    + "	nombre,\n"
                    + "	direccion,\n"
                    + "	telefono,\n"
                    + "	correo\n"
                    + ")\n"
                    + "VALUES\n"
                    + "	(\n"
                    + "		'" + prov.getNombre() + "',\n"
                    + "		'" + prov.getDireccion() + "',\n"
                    + "		'" + prov.getTelefono() + "',\n"
                    + "		'" + prov.getCorreo() + "'\n"
                    + "	)");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void updateProv(Proveedor prov) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE proveedor\n"
                    + "SET nombre ='"+prov.getNombre()+"', \n"
                    + "direccion ='"+prov.getDireccion()+"', telefono ='"+prov.getTelefono()+"', \n"
                    + "correo ='"+prov.getCorreo()+"'\n"
                    + "WHERE\n"
                    + "id_proveedor='" + prov.getId()+ "';");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminarProveedor(Proveedor proveedorsito) {
     try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM proveedor WHERE id_proveedor = '" + proveedorsito.getId() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
