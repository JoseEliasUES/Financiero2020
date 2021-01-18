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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Categoria;
import modelos.MarcaV;
import modelos.Producto;
import modelos.Proveedor;

public class DAO_Productos {

    private final Conexion conexion;
    private Producto usuario;

    public DAO_Productos() {
        this.conexion = new Conexion();
    }

    public ArrayList<Producto> getProductos() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setDescripcion(rs.getString(3));
                prod.setModelo(rs.getString(4));
                prod.setStock(rs.getInt(5));
                MarcaV m = new MarcaV();
                m.setIdMarca(rs.getInt(6));
                prod.setMarca(m);
                Categoria cat = new Categoria();
                cat.setIdCat(rs.getInt(7));
                prod.setCategoria(cat);
                Proveedor pro = new Proveedor();
                pro.setId(rs.getInt(8));
                prod.setProv(pro);
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;

    }

    public ArrayList<Producto> getDetProducto() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM detcompra where ";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setStock(rs.getInt(5));
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;

    }

    public void nProducto(Producto producto) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO productos(\n"
                    + "    nombre,\n"
                    + "    descripcion,\n"
                    + "    modelo,\n"
                    + "    id_marca,\n"
                    + "    stock,\n"
                    + "    id_categoria,\n"
                    + "    id_proveedor\n"
                    + ")\n"
                    + "VALUES(\n"
                    + "    '" + producto.getNombre() + "',\n"
                    + "    '" + producto.getDescripcion() + "',\n"
                    + "    '" + producto.getModelo() + "',\n"
                    + "    '" + producto.getMarca().getIdMarca() + "',\n"
                    + "    '" + producto.getStock() + "',\n"
                    + "    '" + producto.getCategoria().getIdCat() + "',\n"
                    + "    '" + producto.getProv().getId() + "'\n"
                    + ")");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void updateProducto(Producto producto) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE\n"
                    + "    productos\n"
                    + "SET\n"
                    + "    nombre = '" + producto.getNombre() + "',\n"
                    + "    descripcion = '" + producto.getDescripcion() + "',\n"
                    + "    modelo = '" + producto.getModelo() + "',\n"
                    + "    id_marca = '" + producto.getMarca().getIdMarca() + "',\n"
                    + "    id_categoria = '" + producto.getCategoria().getIdCat() + "',\n"
                    + "    id_proveedor='" + producto.getProv().getId() + "'\n"
                    + "WHERE\n"
                    + "    id_producto = '" + producto.getId() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminarProducto(Producto producto) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM productos WHERE id_producto = '" + producto.getId() + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Producto> getProductoS(Integer dato) {
         ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM productos where id_proveedor ='"+dato+"'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setDescripcion(rs.getString(3));
                prod.setModelo(rs.getString(4));
                prod.setStock(rs.getInt(5));
                MarcaV m = new MarcaV();
                m.setIdMarca(rs.getInt(6));
                prod.setMarca(m);
                Categoria cat = new Categoria();
                cat.setIdCat(rs.getInt(7));
                prod.setCategoria(cat);
                Proveedor pro = new Proveedor();
                pro.setId(rs.getInt(8));
                prod.setProv(pro);
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public Iterable<Producto> getProductosF(String nombre) {
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM productos WHERE "
                    + "productos.nombre LIKE '%"+nombre+"%'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setDescripcion(rs.getString(3));
                prod.setModelo(rs.getString(4));
                prod.setStock(rs.getInt(5));
                MarcaV m = new MarcaV();
                m.setIdMarca(rs.getInt(6));
                prod.setMarca(m);
                Categoria cat = new Categoria();
                cat.setIdCat(rs.getInt(7));
                prod.setCategoria(cat);
                Proveedor pro = new Proveedor();
                pro.setId(rs.getInt(8));
                prod.setProv(pro);
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }

    public ArrayList<Producto> getProductosV() {
       ArrayList<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setDescripcion(rs.getString(3));
                prod.setModelo(rs.getString(4));
                prod.setStock(rs.getInt(5));
                MarcaV m = new MarcaV();
                m.setIdMarca(rs.getInt(6));
                prod.setMarca(m);
                Categoria cat = new Categoria();
                cat.setIdCat(rs.getInt(7));
                prod.setCategoria(cat);
                Proveedor pro = new Proveedor();
                pro.setId(rs.getInt(8));
                prod.setProv(pro);
                prod.setPrecio(rs.getDouble(9));
                productos.add(prod);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return productos;
    }
    public Producto busqM(Integer nombre) throws SQLException {
        DAO_Productos daoM = new DAO_Productos();
        for (Producto x : daoM.getProductos()) {
            if (nombre.equals(x.getId())) {
                Producto marca = x;
                return marca;
            }
        }
        return null;
    }
}
