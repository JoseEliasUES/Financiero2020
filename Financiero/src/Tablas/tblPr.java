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
public class tblPr extends AbstractTableModel {

    DAO_Productos daoProd;
    DAO_Marca m;
    DAO_Categoria c;
    ArrayList<Producto> productos;

    public tblPr() {
        m =new DAO_Marca();
        c= new DAO_Categoria();
        daoProd = new DAO_Productos();
        try {
            productos = daoProd.getProductos();
        } catch (SQLException ex) {
            Logger.getLogger(tblPr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public tblPr(ArrayList tipo) {
        this.productos = tipo;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
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
                Logger.getLogger(tblPr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            case 3:
                return prov.getModelo();
            case 4:
        {
            try {
                return c.busqC(prov.getCategoria().getIdCat()).getnCat();
            } catch (SQLException ex) {
                Logger.getLogger(tblPr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                return "MARCA";
            case 3: 
                return "MODELO";
            case 4: 
                return "CATEGORIA";
        }
        return null;
    }

}
