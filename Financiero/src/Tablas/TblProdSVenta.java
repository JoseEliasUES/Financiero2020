/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Conexion.Conexion;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelos.Venta;

/**
 *
 * @author gemelos
 */
public class TblProdSVenta extends AbstractTableModel {

    ArrayList<Venta> productosVentas;

    public TblProdSVenta(ArrayList tipo) {
        this.productosVentas = tipo;
    }

    @Override
    public int getRowCount() {
        return productosVentas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta v = (Venta) productosVentas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex+1;
            case 1:
                return v.getProducto().getNombre();
            case 2:
                return v.getProducto().getMarca().getMarca();
            case 3:
                return v.getCantidad();
            case 4:
                return String.format("%.2f", v.getCuota());
            case 5: 
                return String.format("%.2f", v.getSubtotal());
                    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
                switch (column) {
            case 0:
                return "N";
            case 1:
                return "Producto";
            case 2:
                return "Marca";
            case 3:
                return "Cantidad";
            case 4:
                return "Cuota";
            case 5: 
                return "Subtotal";
                    
        }
        return null;
    }

}
