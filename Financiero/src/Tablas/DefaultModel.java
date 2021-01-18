/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import DAO.DAO_Productos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import modelos.DetVenta;
import modelos.Venta;

/**
 *
 * @author gemelos
 */
public class DefaultModel extends AbstractTableModel {

    DAO_Productos daoP;
    ArrayList<Venta> productosV;
    ArrayList<DetVenta> datosFactura;

    public DefaultModel(ArrayList<Venta> productosV, ArrayList<DetVenta> datosFactura) {
        this.productosV = productosV;
        this.datosFactura = datosFactura;
        daoP = new DAO_Productos();
    }

    @Override
    public int getRowCount() {
        return datosFactura.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta v = productosV.get(rowIndex);
        DetVenta d = datosFactura.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getCantidad();
            case 1: {
                try {
                    return daoP.busqM(d.getIdProducto()).getNombre();
                } catch (SQLException ex) {
                    Logger.getLogger(DefaultModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 2:
                return String.format("%.2f", d.getTotal() / d.getCantidad());
            case 3:
                return String.format("%.2f", d.getCuota());
            case 4:
                return String.format("%.2f", d.getTotal());
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Cantidad";
            case 1:
                return "Producto";
            case 2:
                return "Precio";
            case 3:
                return "Cuota";
            case 4:
                return "Subtotal";
        }
        return null;
    }
}
