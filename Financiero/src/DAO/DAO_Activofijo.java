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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Activofijo;
import modelos.MarcaV;

public class DAO_Activofijo {

    private final Conexion conexion;
    private Activofijo activof;

    public DAO_Activofijo() {
        this.conexion = new Conexion();
    }

    public ArrayList<Activofijo> getLsActivosf() throws SQLException {
        ArrayList<Activofijo> lsActivo = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM activofijo";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Activofijo act = new Activofijo();
                act.setId_activof(rs.getInt(1));
                act.setCodigo(rs.getString(2));
                act.setDescripcion(rs.getString(3));
                MarcaV m = new MarcaV();
                m.setIdMarca(rs.getInt(4));
                act.setMarca(m);
                act.setModelo(rs.getString(5));
                act.setSerie(rs.getString(6));
                act.setFechaadq(rs.getDate(7));
                act.setValor(rs.getDouble(8));
                act.setTipo(rs.getString(9));
                lsActivo.add(act);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return lsActivo;

    }

    

    public void nuevoActivof(Activofijo activo) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO `activofijo`(`codigo`, `descripcion`, `marca_id`, `modelo`, `serie`, `fechaadq`, `valor`, `tipo`) VALUES (\n"
                    + "'" + activo.getCodigo()+ "','" + activo.getDescripcion()+ "','" + activo.getMarca().getIdMarca()+ "','" + activo.getModelo()+ "',\n"
                    + "'" + activo.getSerie()+ "','" + sdf.format(activo.getFechaadq())+ "','" + activo.getValor()+ "','" + activo.getTipo()+ "')");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void updateActivof(Activofijo activo) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE\n"
                    + "    activofijo\n"
                    + "SET\n"
                    + "    codigo = '" + activo.getCodigo()+ "',\n"
                    + "    descripcion = '" + activo.getDescripcion() + "',\n"
                    + "    marca_id = '" + activo.getMarca().getIdMarca()+ "',\n"
                    + "    modelo = '" + activo.getModelo()+ "',\n"
                    + "    serie = '" + activo.getSerie()+ "',\n"
                    + "    fechaadq='" + sdf.format(activo.getFechaadq())+ "',\n"
                    + "    valor='"+ activo.getValor()+ "',\n"
                    + "    tipo='" + activo.getTipo()+ "'\n"
                    + "WHERE id_activof= '" + activo.getId_activof() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }
    
    public Activofijo getActivof(Integer nombre) throws SQLException {
        Activofijo act = new Activofijo();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT *FROM activofijo where id_activof = '" + nombre + "'");

            while (rs.next()) {
                act.setId_activof(rs.getInt(1));
                act.setCodigo(rs.getString(2));
                act.setDescripcion(rs.getString(3));
                MarcaV m = new MarcaV();
                m.setIdMarca(rs.getInt(4));
                act.setMarca(m);
                act.setModelo(rs.getString(5));
                act.setSerie(rs.getString(6));
                act.setFechaadq(rs.getDate(7));
                act.setValor(rs.getDouble(8));
                act.setTipo(rs.getString(9));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return act;
    }

}
