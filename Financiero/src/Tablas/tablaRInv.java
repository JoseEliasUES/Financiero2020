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
public class tablaRInv extends AbstractTableModel {

    ArrayList<Inventario> productos;
    DAO_Inventario daoI;
    Integer test;

    public tablaRInv() {
        test = null;
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        try {
            productos = daoI.getProductos();
        } catch (SQLException ex) {
            Logger.getLogger(tablaRInv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public tablaRInv(Integer a) {
        test = a;
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        try {
            productos = daoI.getProductosV();
        } catch (SQLException ex) {
            Logger.getLogger(tablaRInv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public tablaRInv(int anio, int mes) {
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        productos = daoI.getProductosF(anio, mes);
    }

    public tablaRInv(int anio, int mes, Integer a) {
        test = a;
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        productos = daoI.getProductosFV(anio, mes);
    }

    public tablaRInv(int anio, int mes, String prod) {
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        productos = daoI.getProductosF(anio, mes, prod);
    }

    public tablaRInv(int anio, int mes, int i, String prod) {
        test = i;
        productos = new ArrayList<>();
        daoI = new DAO_Inventario();
        productos = daoI.getProductosFV(anio, mes, prod);
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventario i = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getFechaC();
            case 1:
                return i.getNombreC();
            case 2:
                return i.getMarcaC().getMarca();
            case 3:
                return i.getModeloC();
            case 4:
                return i.getCatC().getnCat();
            case 5:
                return i.getCantidadC();
            case 6:
                return i.getPrecioCompra();
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
                return "Marca";
            case 3:
                return "Modelo";
            case 4:
                return "Categoria";
            case 5:
                return "Cantidad";
            case 6:
                if (test != null) {
                    return "Total Venta";
                } else {
                    return "Costo de Compra";
                }
        }
        return null;
    }

    public ArrayList<Inventario> getProductos() {
        return productos;
    }

}
