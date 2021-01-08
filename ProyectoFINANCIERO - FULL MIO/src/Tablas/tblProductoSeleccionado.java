package Tablas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelos.Producto;

/**
 *
 * @author rodol
 */
public class tblProductoSeleccionado extends AbstractTableModel {

    ArrayList<Producto> productos;

    public tblProductoSeleccionado(ArrayList prod) {
        this.productos = prod;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
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
                return prov.getCantidad();
            case 3:
                return prov.getPrecio();
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
                return "CÁNTIDAD";
                case 3:
                return "PRECIO";
        }
        return null;
    }

}
