package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.DetalleCompra;

/**
 *
 * @author rodol
 */
public class DAO_detalleCompra {

    private Conexion conexion;
    private DetalleCompra partida;
    private Statement stament;
    public ResultSet resultado;

//    ConexionAuxiliar cc = new ConexionAuxiliar();
//    Connection cn = cc.abrirConexion();
    public DAO_detalleCompra() {
        this.conexion = new Conexion();
    }

    public void RegistrarDetallePartida(DetalleCompra detalle) throws SQLException {
//        try {
//            this.conexion.getConexion();
//            Statement st = this.conexion.getConexion().createStatement();
//            st.executeUpdate("INSERT INTO detalle_partida(id_partida,cod_cuenta,parcial,debe,haber) VALUES ('" + detalle.getIdDetallePartida() + "','" + detalle.getCod_cuenta() + "',"
//                    + detalle.getParcial() + "," + detalle.getDebe() + "," + detalle.getHaber() + ")");
//            conexion.cerrarConexiones();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
    }

    public void GuardarDetallePartida(DetalleCompra detalle) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate(
                    "INSERT INTO compra values ('"
                    + null + "','"
                    + detalle.getFecha() + "','"
                    + detalle.getIdProv() + "')");
            st.executeUpdate(
                    "INSERT INTO detcompra values ('"
                    + null + "','"
                    + detalle.getPrecioCompra() + "','"
                    + detalle.getCantidad() + "','"
                    + detalle.getIdProd() + "','"
                    + detalle.getIdCompra() + "')");
            stament.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Ingresar los Datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public void LimpiarDetalle() {
//        try {
//            cc.abrirConexion();
//            cc.sentencia = cn.createStatement();
//            cc.sentencia.executeUpdate("DELETE FROM detalle_partida");
//            cc.cerrarConexion();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public ArrayList<DetalleCompra> getDetalles() throws SQLException {
        ArrayList<DetalleCompra> detalles = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM detalle_partida";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleCompra detalle = new DetalleCompra();
//                detalle.setIdDetallePartida(rs.getInt(2));
//                detalle.setCod_cuenta(rs.getInt(3));
//                detalle.setParcial(rs.getDouble(4));
//                detalle.setDebe(rs.getDouble(5));
//                detalle.setHaber(rs.getDouble(6));
                detalles.add(detalle);

            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return detalles;

    }
}
