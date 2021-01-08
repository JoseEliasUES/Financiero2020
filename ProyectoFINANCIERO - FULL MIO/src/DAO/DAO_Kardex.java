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
import modelos.Kardex;
import modelos.Proveedor;

public class DAO_Kardex {

    private Conexion conexion;
    private Cliente clientes;

    public DAO_Kardex() {
        this.conexion = new Conexion();
    }

    public ArrayList<Kardex> getKardex(int idProd) throws SQLException {
        ArrayList<Kardex> k = new ArrayList<>();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT\n"
                    + "compra.fecha,\n"
                    + "\"Compra\",\n"
                    + "@cantC:=detcompra.cantidad as canC,\n"
                    + "@precioUC:= detcompra.precCompra as preUC,\n"
                    + "@totalC:=detcompra.cantidad*detcompra.precCompra as total,\n"
                    + "0,0,0,\n"
                    + "@cantC-@cantV,\n"
                    + "@precioUC,\n"
                    + "@totalC-@totalV\n"
                    + "FROM\n"
                    + "compra\n"
                    + "INNER JOIN detcompra ON detcompra.id_compra = compra.id_compra\n"
                    + "INNER JOIN productos ON detcompra.id_producto = productos.id_producto\n"
                    + "WHERE productos.id_producto = " + idProd + "\n"
                    + "UNION\n"
                    + "SELECT\n"
                    + "venta.fecha,\n"
                    + "\"Venta\",\n"
                    + "0,\n"
                    + "0,\n"
                    + "0,\n"
                    + "@cantV:=detventa.cantidad as cant,\n"
                    + "@precioUV:=detventa.total/detventa.cantidad as precioU,\n"
                    + "@totalV:=detventa.total as total,\n"
                    + "@cantC-@cantV,\n"
                    + "@precioUC,\n"
                    + "@totalC-@totalV \n"
                    + "FROM\n"
                    + "detventa\n"
                    + "INNER JOIN venta ON detventa.id_venta = venta.id_venta\n"
                    + "INNER JOIN productos ON detventa.idProd = productos.id_producto");

            while (rs.next()) {
                Kardex kar = new Kardex();
                kar.setFecha(rs.getDate(1));
                kar.setDetalle(rs.getString(2));
                kar.setCantidadC(rs.getInt(3));
                kar.setPrecioUC(rs.getDouble(4));
                kar.setTotalC(rs.getDouble(5));
                kar.setCantidadV(rs.getInt(6));
                kar.setPrecioUV(rs.getDouble(7));
                kar.setTotalV(rs.getDouble(8));
                kar.setCantidadE(rs.getInt(9));
                kar.setPrecioUE(rs.getDouble(10));
                kar.setTotalE(rs.getDouble(11));
                k.add(kar);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return k;
    }

}
