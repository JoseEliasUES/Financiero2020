/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import DAO.DAO_Marca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelos.MarcaV;

/**
 *
 * @author gemelos
 */
public class tablaMarcas implements TableModel{

    DAO_Marca daoMarc;
    ArrayList<MarcaV> marcas;
    public tablaMarcas() {
        daoMarc = new DAO_Marca();
        try {
            marcas= daoMarc.getMarca();
        } catch (SQLException ex) {
            Logger.getLogger(tablaMarcas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public tablaMarcas(ArrayList tipo) {
        this.marcas = tipo;
    }
    @Override
    public int getRowCount() {
        return marcas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                MarcaV marcG = (MarcaV) marcas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return marcG.getIdMarca();
            case 1:
                return marcG.getMarca();
                 case 2:
                return marcG.getDescripcion();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "CÓDIGO";
            case 1:
                return "MARCA";
             case 2:
                return "DESCRIPCION";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}
