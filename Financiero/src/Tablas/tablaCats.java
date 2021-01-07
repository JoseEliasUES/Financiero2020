/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import DAO.DAO_Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelos.Categoria;

/**
 *
 * @author gemelos
 */
public class tablaCats implements TableModel{

    DAO_Categoria daoCat;
    ArrayList<Categoria> categorias;
    public tablaCats() {
        daoCat = new DAO_Categoria();
        try {
            categorias= daoCat.getCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(tablaCats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public tablaCats(ArrayList tipo) {
        this.categorias = tipo;
    }
    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                Categoria catG = (Categoria) categorias.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return catG.getIdCat();
            case 1:
                return catG.getnCat();
                 case 2:
                return catG.getDescripcion();
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
                return "NOMBRE";
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
