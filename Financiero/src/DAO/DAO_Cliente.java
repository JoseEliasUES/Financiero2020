package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Cliente;

public class DAO_Cliente {

    private Conexion conexion;
    private Cliente cliente;

    public DAO_Cliente() {
        this.conexion = new Conexion();
    }

    public ArrayList<Cliente> getClientes() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM clientes";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDui(rs.getString(4));
                c.setSexo(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setEmail(rs.getString(7));
                c.setDireccion(rs.getString(8));
                c.setEstado(rs.getInt(9));
                clientes.add(c);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return clientes;

    }

    public Cliente getCliente(String nombre) throws SQLException {
        Cliente c = new Cliente();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes where nombres = '" + nombre + "'");

            while (rs.next()) {
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDui(rs.getString(4));
                c.setSexo(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setEmail(rs.getString(7));
                c.setDireccion(rs.getString(8));
                c.setEstado(rs.getInt(9));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return c;
    }

    public void nuevoCliente(Cliente cli) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO clientes  (`nombres`, `apellidos`, `DUI`, `sexo`, `telefono`, `email`, `direccion`, `estado`) VALUES\n"
                    + "	('" + cli.getNombre() + "','" + cli.getApellido() + "','" + cli.getDui() + "','" + cli.getSexo() + "','" + cli.getTelefono() + "','" + cli.getEmail() + "',\n"
                    + "'" + cli.getDireccion() + "','" + cli.getEstado() + "')");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void updateCliente(Cliente cli) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE `clientes` SET `nombres`='" + cli.getNombre() + "',`apellidos`='" + cli.getApellido() + "',"
                    + "`DUI`='" + cli.getDui() + "',`sexo`='" + cli.getSexo() + "',`telefono`='" + cli.getTelefono() + "',`email`='" + cli.getEmail() + "',`direccion`='" + cli.getDireccion() + "',`estado`='" + cli.getEstado() + "' WHERE id_cliente='" + cli.getIdCliente() + "';");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminarCliente(Cliente cli) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM clientes WHERE id_cliente = '" + cli.getIdCliente() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Cliente getClienteId(Integer nombre) throws SQLException {
        Cliente c = new Cliente();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes where id_cliente = '" + nombre + "'");

            while (rs.next()) {
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDui(rs.getString(4));
                c.setSexo(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setEmail(rs.getString(7));
                c.setDireccion(rs.getString(8));
                c.setEstado(rs.getInt(9));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return c;
    }

    public ArrayList<Cliente> getClientesFiltrado(String duiF) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM clientes WHERE clientes.DUI = '" + duiF + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDui(rs.getString(4));
                c.setSexo(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setEmail(rs.getString(7));
                c.setDireccion(rs.getString(8));
                c.setEstado(rs.getInt(9));
                clientes.add(c);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return clientes;
    }
}
