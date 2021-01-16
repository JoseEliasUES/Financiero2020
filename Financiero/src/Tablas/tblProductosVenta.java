package Tablas;

import DAO.DAO_Categoria;
import DAO.DAO_Marca;
import DAO.DAO_Productos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelos.Producto;

/**
 *
 * @author rodol
 */
public class tblProductosVenta extends AbstractTableModel {

    DAO_Productos daoProd;
    DAO_Marca m;
    DAO_Categoria c;
    ArrayList<Producto> productos;

    public tblProductosVenta() {
        m =new DAO_Marca();
        c= new DAO_Categoria();
        daoProd = new DAO_Productos();
        productos = daoProd.getProductosV();
    }

    public tblProductosVenta(ArrayList tipo) {
        m = new DAO_Marca();
        this.productos = tipo;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto prov = (Producto) productos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return prov.getId();
            case 1:
                return prov.getNombre();
            case 2:
        {
            try {
                return m.busqM(prov.getMarca().getIdMarca()).getMarca();
            } catch (SQLException ex) {
                Logger.getLogger(tblProductosVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            case 3:
                return prov.getModelo();
            case 4:
                return prov.getStock();
            case 5: 
                return prov.getPrecio();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "N";
            case 1:
                return "NOMBRE DEL PRODUCTO";
            case 2:
                return "MARCA";
            case 3: 
                return "MODELO";
            case 4: 
                return "STOCK";
            case 5: 
                return "PRECIO";
        }
        return null;
    }

}
