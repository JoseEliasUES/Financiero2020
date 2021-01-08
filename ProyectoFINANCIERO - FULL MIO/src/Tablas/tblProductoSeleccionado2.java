package Tablas;

import DAO.DAO_Productos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelos.Categoria;
import modelos.MargenGanancia;
import modelos.Producto;

/**
 *
 * @author rodol
 */
public class tblProductoSeleccionado2 extends AbstractTableModel {

    DAO_Productos daoProd;
    ArrayList<Producto> productos;

    public tblProductoSeleccionado2() {
        daoProd = new DAO_Productos();
        try {
            productos = daoProd.getProductosPVenta();
        } catch (SQLException ex) {
            Logger.getLogger(tablaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                return prov.getStock();
            case 3: {
                try {
                    for (MargenGanancia categoria : daoProd.getMargenGanancia()) {
                        if (categoria.getCategoria2() == (prov.getIdcategoria())) {
                            return (((prov.getPrecio() * categoria.getPorcentaje()) / 100) + prov.getPrecio());
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(tblProductoSeleccionado2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
                return "PRODUCTO";
            case 2:
                return "STOCK";
            case 3:
                return "PRECIO U.";
        }
        return null;
    }

}
