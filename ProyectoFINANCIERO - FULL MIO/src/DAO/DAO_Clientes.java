package DAO;

/**
 *
 * @author Josué
 */
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.Empleados;
import modelos.Proveedor;

public class DAO_Clientes {

    private Conexion conexion;
    private Cliente clientes;

    public DAO_Clientes() {
        this.conexion = new Conexion();
    }

    public void GuardarCliente(Empleados emple) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO empleados VALUES('" + emple.getDui() + "','" + emple.getNombres() + "','"
                    + emple.getApellidos() + "','" + emple.getSexo() + "','" + emple.getFechaNac() + "','" + emple.getTelefono() + "','" + emple.getEmail() + "','" + emple.getDireccion() + "','" + emple.getCargo() + "')");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarEmpleado(Empleados emp) {

        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM empleados WHERE dui = '" + emp.getDui() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Cliente> getClientes() throws SQLException {
        ArrayList<Cliente> lstClientes = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM clientes";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente pr = new Cliente();
                pr.setIdCliente(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setApellido(rs.getString(3));
                pr.setDui(rs.getString(4));
                pr.setSexo(rs.getString(5));
                pr.setTelefono(rs.getString(6));
                pr.setEmail(rs.getString(7));
                pr.setDireccion(rs.getString(8));
                pr.setEstado(rs.getInt(9));
                lstClientes.add(pr);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lstClientes;

    }

    public boolean getClienteFrecuente(String dui) throws SQLException {
        int fre=0;
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT\n"
                    + "COUNT(clientes.DUI)\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN venta ON venta.id_venta = detventa.id_venta\n"
                    + "INNER JOIN clientes ON venta.cliente = clientes.id_cliente where DUI = '" + dui + "'");

            while (rs.next()) {
                fre = (rs.getInt(1));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return fre>2;
    }

    public Proveedor getCliente(String nombre) throws SQLException {
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

    public void ModificarEmepleado(Empleados cuenta) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE empleados SET "
                    + "nombres='" + cuenta.getNombres() + "',"
                    + "apellidos='" + cuenta.getApellidos() + "',"
                    + "sexo='" + cuenta.getSexo() + "',"
                    + "fechaNac='" + cuenta.getFechaNac() + "',"
                    + "telefono='" + cuenta.getTelefono() + "',"
                    + "email='" + cuenta.getEmail() + "',"
                    + "direccion='" + cuenta.getDireccion() + "',"
                    + "cargo='" + cuenta.getCargo() + "'"
                    + "WHERE dui='" + cuenta.getDui() + "';"
            );
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
