package Tablas;

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
public class tablaProductos extends AbstractTableModel {

    DAO_Productos daoProd;
    ArrayList<Producto> productos;

    public tablaProductos() {
        daoProd = new DAO_Productos();
        try {
            productos = daoProd.getProductos();
        } catch (SQLException ex) {
            Logger.getLogger(tablaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public tablaProductos(ArrayList tipo) {
        this.productos = tipo;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto prov = (Producto) productos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return prov.getIdProd();
            case 1:
                return prov.getNombre();
            case 2:
                return prov.getStock();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "CÓDIGO";
            case 1:
                return "NOMBRE DEL PRODUCTO";
            case 2:
                return "STOCK";
        }
        return null;
    }

}
