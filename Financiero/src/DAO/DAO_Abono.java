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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Abono;
import modelos.Cliente;
import modelos.Empleados;
import modelos.Proveedor;

public class DAO_Abono {

    private Conexion conexion;
    private Cliente clientes;

    public DAO_Abono() {
        this.conexion = new Conexion();
    }

    public void GuardarAbono(Abono emple) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO abonos(\n"
                    + "    id_detventa,\n"
                    + "    fecha,\n"
                    + "    abono,\n"
                    + "    mora,\n"
                    + "    prox_pago\n"
                    + ")\n"
                    + "VALUES(\n"
                    + "    '" + emple.getId_detVenta() + "',\n"
                    + "    '" + sdf.format(emple.getFecha()) + "',\n"
                    + "    '" + emple.getAbono() + "',\n"
                    + "    '" + emple.getMora() + "',\n"
                    + "    '" + sdf.format(emple.getProxPago()) + "'\n"
                    + ")");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Abono> getCuentaAbono(String factura) throws SQLException {
        ArrayList<Abono> lstCxC = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "venta.factura,\n"
                    + "clientes.DUI,\n"
                    + " CONCAT(clientes.nombres,' ',clientes.apellidos) as cliente ,\n"
                    + "detventa.meses*detventa.cuota AS credInicial,\n"
                    + "cuota,\n"
                    + "((detventa.meses*detventa.cuota) - abonos.abono) + abonos.mora as saldopendiente,\n"
                    + "venta.fecha\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN clientes ON venta.cliente = clientes.id_cliente\n"
                    + "INNER JOIN abonos ON abonos.id_detventa = detventa.id_detVenta\n"
                    + "WHERE venta.factura = '" + factura + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Abono ab = new Abono();
                ab.setFactura(rs.getString(1));
                ab.setDui(rs.getString(2));
                ab.setCliente(rs.getString(3));
                ab.setCredInicial(rs.getDouble(4));
                ab.setSaldoPendiente(rs.getDouble(5));
                ab.setFechaCredito(rs.getDate(6));
                lstCxC.add(ab);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lstCxC;
    }

    public ArrayList<Abono> getCxC() throws SQLException {
        ArrayList<Abono> lstCxC = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "	venta.factura,\n"
                    + "	clientes.DUI,\n"
                    + "	CONCAT(\n"
                    + "		clientes.nombres,\n"
                    + "		' ',\n"
                    + "		clientes.apellidos\n"
                    + "	) AS cliente,\n"
                    + "SUM(abonos.abono) as pagado\n"
                    + ",\n"
                    + "	venta.fecha,\n"
                    + "detventa.total\n"
                    + "FROM\n"
                    + "	detventa\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN clientes ON venta.cliente = clientes.id_cliente\n"
                    + "INNER JOIN abonos ON abonos.id_detventa = detventa.id_detVenta\n"
                    + "WHERE detventa.estado=0 GROUP BY venta.factura ORDER BY clientes.nombres desc";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Abono ab = new Abono();
                ab.setFactura(rs.getString(1));
                ab.setDui(rs.getString(2));
                ab.setCliente(rs.getString(3));
                ab.setSaldoPendiente(rs.getDouble(4));
                ab.setFechaCredito(rs.getDate(5));
                ab.setCredInicial(rs.getDouble(6));
                lstCxC.add(ab);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lstCxC;
    }

    public ArrayList<Abono> getAbonos(String factura) throws SQLException {
        ArrayList<Abono> lstCxC = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "abonos.abono,\n"
                    + "abonos.fecha,\n"
                    + "abonos.comentario\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN abonos ON abonos.id_detventa = detventa.id_detVenta\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "WHERE venta.factura = '" + factura + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Abono ab = new Abono();
                ab.setAbono(rs.getDouble(1));
                ab.setFecha(rs.getDate(2));
                ab.setDescripcion(rs.getString(3));
                lstCxC.add(ab);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lstCxC;
    }

    public ArrayList<Abono> getDatosClienteParaAbono(String factura) throws SQLException {
        ArrayList<Abono> lstCxC = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "venta.factura,\n"
                    + "abonos.mora,\n"
                    + "abonos.fecha,\n"
                    + "detventa.cuota,\n"
                    + "clientes.id_cliente,\n"
                    + "clientes.nombres,\n"
                    + "clientes.apellidos,\n"
                    + "detventa.id_detVenta,\n"
                    + "abonos.hora,\n"
                    + "abonos.abono,\n"
                    + "abonos.prox_pago,\n"
                    + "abonos.comentario\n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN abonos ON abonos.id_detventa = detventa.id_detVenta\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN clientes ON venta.cliente = clientes.id_cliente\n"
                    + "WHERE venta.factura = '" + factura + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Abono ab = new Abono();
                ab.setFactura(rs.getString(1));
                ab.setMora(rs.getDouble(2));
                ab.setFecha(rs.getDate(3));
                ab.setCuota(rs.getDouble(4));
                ab.setIdCliente(rs.getInt(5));
                ab.setCliente(rs.getString(6));
                ab.setId_detVenta(rs.getInt(8));
                ab.setHora(rs.getTime(9));
                ab.setAbono(rs.getInt(10));
                ab.setProxPago(rs.getDate(11));
                ab.setDescripcion(rs.getString(12));
                lstCxC.add(ab);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lstCxC;
    }

    public boolean getClienteFrecuente(String dui) throws SQLException {
        int fre = 0;
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
        return fre > 2;
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

    public void setEstado(Integer id) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE detventa\n"
                    + "SET estado = '" + 1 + "'\n"
                    + "WHERE id_detVenta'" + id + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ArrayList<Abono> getCxCF(String dui) {
        ArrayList<Abono> lstCxC = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT\n"
                    + "	venta.factura,\n"
                    + "	clientes.DUI,\n"
                    + "	CONCAT(\n"
                    + "		clientes.nombres,\n"
                    + "		' ',\n"
                    + "		clientes.apellidos\n"
                    + "	) AS cliente,\n"
                    + "SUM(abonos.abono) as pagado\n"
                    + ",\n"
                    + "	venta.fecha,\n"
                    + "detventa.total\n"
                    + "FROM\n"
                    + "	detventa\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN clientes ON venta.cliente = clientes.id_cliente\n"
                    + "INNER JOIN abonos ON abonos.id_detventa = detventa.id_detVenta\n"
                    + "WHERE detventa.estado=0 AND clientes.DUI LIKE '%" + dui + "%'"
                    + "GROUP BY venta.factura ORDER BY clientes.nombres desc";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Abono ab = new Abono();
                ab.setFactura(rs.getString(1));
                ab.setDui(rs.getString(2));
                ab.setCliente(rs.getString(3));
                ab.setSaldoPendiente(rs.getDouble(4));
                ab.setFechaCredito(rs.getDate(5));
                ab.setCredInicial(rs.getDouble(6));
                lstCxC.add(ab);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lstCxC;
    }
}
