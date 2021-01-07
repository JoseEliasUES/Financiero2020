/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.MarcaV;

/**
 *
 * @author gemelos
 */
public class DAO_Marca {

    private Conexion conexion;

    public DAO_Marca() {
        this.conexion = new Conexion();
    }

    public ArrayList<MarcaV> getMarca() throws SQLException {
        ArrayList<MarcaV> marcas = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM marca";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MarcaV marc = new MarcaV();
                marc.setIdMarca(rs.getInt(1));
                marc.setMarca(rs.getString(2));
                marc.setDescripcion(rs.getString(3));
                marcas.add(marc);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return marcas;

    }

    public MarcaV getMarc(String nombre) throws SQLException {
        MarcaV m = new MarcaV();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM marca where marca = '" + nombre + "'");

            while (rs.next()) {
                m.setIdMarca(rs.getInt(1));
                m.setMarca(rs.getString(2));
                m.setDescripcion(rs.getString(3));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return m;
    }

    public void nuevaMarca(MarcaV marc) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO marca(nombre,\n"
                    + "descripcion)\n"
                    + "VALUES('" + marc.getMarca() + "',\n"
                    + "'" + marc.getDescripcion() + "')");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void updateMarca(MarcaV marc) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE marca\n"
                    + "SET nombre ='" + marc.getMarca() + "', \n"
                    + "descripcion ='" + marc.getDescripcion() + "'\n"
                    + "WHERE\n"
                    + "id_marca='" + marc.getIdMarca() + "';");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminarMarca(MarcaV marc) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM marca WHERE id_marca = '" + marc.getIdMarca() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
