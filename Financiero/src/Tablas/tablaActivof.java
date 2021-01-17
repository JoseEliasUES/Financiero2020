/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import DAO.DAO_Activofijo;
import DAO.DAO_Marca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelos.Activofijo;
/**
 *
 * @author TonyFabian
 */
public class tablaActivof extends AbstractTableModel  {
    DAO_Activofijo daoAct;
    DAO_Marca m;
    ArrayList<Activofijo> lsActivof;

    public tablaActivof() {
        m =new DAO_Marca();
        daoAct = new DAO_Activofijo();
        try {
            lsActivof = daoAct.getLsActivosf();
        } catch (SQLException ex) {
            Logger.getLogger(tablaActivof.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public tablaActivof(ArrayList tipo) {
        this.lsActivof = tipo;
    }

    @Override
    public int getRowCount() {
        return lsActivof.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Activofijo activo = (Activofijo) lsActivof.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return activo.getId_activof();
            case 1:
                return activo.getCodigo();
            case 2:
                return activo.getDescripcion();
            case 3:
        {
            try {
                return m.busqM(activo.getMarca().getIdMarca()).getMarca();
            } catch (SQLException ex) {
                Logger.getLogger(tablaActivof.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            case 4:
                return activo.getModelo();
            case 5:
                 return activo.getSerie();
            case 6:
                 return activo.getFechaadq();
            case 7:
                 return "$ "+activo.getValor();
            case 8:
                 return activo.getTipo();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "CÓDIGO";
            case 2:
                return "DESCRIPCIÓN";
            case 3:
                return "MARCA";
            case 4: 
                return "MODELO";
            case 5: 
                return "SERIE";
            case 6: 
                return "FECHA ADQ";
            case 7: 
                return "VALOR";
            case 8: 
                return "TIPO";
        }
        return null;
    }

    
}
