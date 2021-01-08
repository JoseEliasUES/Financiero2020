package Tablas;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;
import modelos.Producto;

/**
 *
 * @author Monica
 */
public class tablaVenta implements TableModel {

    Producto prod;
    ArrayList<Producto> lstProd;

    public tablaVenta(ArrayList prods) {
        prod = new Producto();
        lstProd = prods;
    }

    @Override
    public int getRowCount() {
        return lstProd.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producs = (Producto) lstProd.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return producs.getNombre();
            case 1:
                return producs.getCantidad();
            case 2:
                return producs.getPrecio();
            case 3:
                return producs.getCuota();
            case 4:
                return producs.getPrima();
            case 5:
                return producs.getDescuento();
            case 6:
                return (producs.getPrecio() * producs.getCantidad()) - producs.getDescuento();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "PRODUCTO";
            case 1:
                return "CÁNTIDAD";
            case 2:
                return "PRECIO U.";
            case 3:
                return "CUOTA";
            case 4:
                return "PRIMA";
            case 5:
                return "DESCUENTO";
            case 6:
                return "SUBTOTAL";
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

    @Override
    public void addTableModelListener(TableModelListener tl) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {

    }

}
