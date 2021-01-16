/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import DAO.DAO_Inventario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelos.DetVenta;
import modelos.RegVentas;

/**
 *
 * @author gemelos
 */
public class tablaRegVentas extends AbstractTableModel {

    private ArrayList<RegVentas> detVenta;
    DAO_Inventario daoI;

    public tablaRegVentas() {
        detVenta = new ArrayList<>();
        daoI = new DAO_Inventario();
        detVenta= daoI.getProductosVentas();
    }

    @Override
    public int getRowCount() {
        return detVenta.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegVentas rVenta = detVenta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rVenta.getFecha();
            case 1:
                return rVenta.getProducto();
            case 2:
                return rVenta.getCantidad();
            case 3:
                return rVenta.getEstado();
            case 4:
                return rVenta.getTotal();
            case 5:
                return rVenta.getDuiCliente();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Fecha";
            case 1:
                return "Producto";
            case 2:
                return "Cantidad";
            case 3:
                return "Estado";
            case 4:
                return "Total";
            case 5:
                return "DUI Cliente";
        }
        return null;
    }

    public ArrayList<RegVentas> getDetVenta() {
        return detVenta;
    }

}
