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
import modelos.Categoria;

/**
 *
 * @author gemelos
 */
public class DAO_Categoria {

    private Conexion conexion;

    public DAO_Categoria() {
        this.conexion = new Conexion();
    }

    public ArrayList<Categoria> getCategoria() throws SQLException {
        ArrayList<Categoria> categorias = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM CATEGORIA";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setIdCat(rs.getInt(1));
                cat.setDescripcion(rs.getString(2));
                cat.setnCat(rs.getString(3));
                categorias.add(cat);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return categorias;

    }

    public Categoria getMarc(String nombre) throws SQLException {
        Categoria m = new Categoria();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categoria where id_categoria = '" + nombre + "'");

            while (rs.next()) {
                m.setIdCat(rs.getInt(1));
                m.setDescripcion(rs.getString(2));
                m.setnCat(rs.getString(3));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return m;
    }

    public void nuevaCategoria(Categoria marc) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO categoria(descripcion,\n"
                    + "catNombre)\n"
                    + "VALUES('" + marc.getDescripcion() + "',\n"
                    + "'" + marc.getnCat() + "')");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void updateCategoria(Categoria marc) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE CATEGORIA\n"
                    + "SET catNombre ='" + marc.getnCat() + "', \n"
                    + "descripcion ='" + marc.getDescripcion() + "'\n"
                    + "WHERE\n"
                    + "id_categoria='" + marc.getIdCat() + "';");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminarCategoria(Categoria marc) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM categoria WHERE id_categoria = '" + marc.getIdCat() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Categoria busqC(Integer nombre) throws SQLException {
        DAO_Categoria daoM = new DAO_Categoria();
        for (Categoria x : daoM.getCategoria()) {
            if (nombre.equals(x.getIdCat())) {
                Categoria cat = x;
                return cat;
            }
        }
        return null;
    }
}
