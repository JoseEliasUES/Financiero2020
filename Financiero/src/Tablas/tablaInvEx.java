/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import DAO.DAO_Inventario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelos.Inventario;

/**
 *
 * @author gemelos
 */
public class tablaInvEx extends AbstractTableModel {

    ArrayList<Inventario> productos;
    DAO_Inventario daoI;

    public tablaInvEx() {
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        productos = daoI.getProductosE();
    }

    public tablaInvEx(String prod) {
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        productos = daoI.getProductosE(prod);
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
        Inventario i = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getNombreC();
            case 1:
                return i.getMarcaC().getMarca();
            case 2:
                return i.getModeloC();
            case 3:
                return i.getCatC().getnCat();
            case 4:
                return i.getStock();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Producto";
            case 1:
                return "Marca";
            case 2:
                return "Modelo";
            case 3:
                return "Categoria";
            case 4:
                return "Stock";
        }
        return null;
    }

    public ArrayList<Inventario> getProductos() {
        return productos;
    }

}
