package Conexion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static Connection conexion = null;
    private static final ResultSet rs = null;
    private static Statement sentencia = null;
    private static final PreparedStatement ps = null;
    private static final String url = "jdbc:mysql://localhost:3306/financiero";
    private static final String usuario = "root";
    private static final String password = "";

    public Connection getConexion() {
        Connection con = null;
        try {
            // Obtener la Conexion
            con = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
        } catch (Exception e) {
        }
        return con;
    }

    public  void cerrarConexiones() throws SQLException {
        if (sentencia != null) {
            sentencia.close();
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la base de datos" + e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la base de datos" + e);
            }
        }
    }

}
