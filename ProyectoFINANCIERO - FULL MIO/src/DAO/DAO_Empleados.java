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
import modelos.Empleados;
import modelos.Proveedor;

public class DAO_Empleados {

    private Conexion conexion;
    private Empleados empleados;

    public DAO_Empleados() {
        this.conexion = new Conexion();
    }

    public void GuardarEmpleado(Empleados emple) throws SQLException {
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

    public ArrayList<Empleados> getEmpleados() throws SQLException {
        ArrayList<Empleados> lstEmpleados = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM empleados ORDER BY nombres DESC";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleados pr = new Empleados();
                pr.setDui(rs.getString(1));
                pr.setNombres(rs.getString(2));
                pr.setApellidos(rs.getString(3));
                pr.setSexo(rs.getString(4));
                pr.setFechaNac(rs.getDate(5));
                pr.setTelefono(rs.getString(6));
                pr.setEmail(rs.getString(7));
                pr.setDireccion(rs.getString(8));
                pr.setCargo(rs.getString(9));
                lstEmpleados.add(pr);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lstEmpleados;

    }

    public Empleados getDUIEmpleado(String nombre, String apellido) throws SQLException {
        Empleados pr = new Empleados();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM empleados where nombres = '" + nombre + "' AND apellidos = '" + apellido + "'");

            while (rs.next()) {
                pr.setDui(rs.getString(1));
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
