/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import DAO.DAO_Activofijo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelos.Activofijo;
import modelos.Depreciacion;

/**
 *
 * @author gemelos
 */
public class TablaDepreciacion extends AbstractTableModel {

    ArrayList<Depreciacion> aFijo;
    DAO_Activofijo daoA;
    Depreciacion d;
    ArrayList<String> tipoAc;
    Double depreciate;
    Double acumulado;
    Double vLibros;
    public TablaDepreciacion(Integer idActivo) {
        aFijo = new ArrayList();
        daoA = new DAO_Activofijo();
        aFijo = daoA.getLsActivosf(idActivo);
        d = aFijo.get(0);
        depreciate = 0.0;
        acumulado = 0.0;
        vLibros = d.getValor();
        tipoAc();
    }

    @Override
    public int getRowCount() {
        int rows = aFijo.get(0).getAnios();
        if ("Edificaciones".equals(aFijo.get(0).getTipo()) && rows >= 20) {
            return 21;
        } else if ("Edificaciones".equals(aFijo.get(0).getTipo()) && rows <= 20) {
            return rows+1;
        } else if (rows >= 6) {
            return 6;
        } else if (rows == 0) {
            return 1;
        } else {
            return rows+1;
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return periodo(rowIndex);
            case 1:
                return String.format("%.2f", calculo(rowIndex));
            case 2:
                return String.format("%.2f", acc(rowIndex));
            case 3:
                return String.format("%.2f", valorL(rowIndex));
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Periodo";
            case 1:
                return "Depreciacion Anual";
            case 2:
                return "Depreciacion Acumulada";
            case 3:
                return "Valor en libros";
        }
        return null;
    }

    private Object calculo(int row) {
        String tipo = d.getTipo();
        int tCal = 0;
        for (int i = 0; i < tipoAc.size(); i++) {
            if (tipo.equals(tipoAc.get(i))) {
                tCal = i;
            }
        }
        switch (tCal) {
            case 0:
                if (row == 0) {
                    return 0.0;
                } else {
                    depreciate = (d.getValor() * 0.05);
                    return depreciate;
                }
            case 1:
                if (row == 0) {
                    return 0.0;
                } else {
                    depreciate = (d.getValor() * 0.20);
                    return depreciate;
                }
            case 2:
                if (row == 0) {
                    return 0.0;
                } else {
                    depreciate = (d.getValor() * 0.25);
                    return depreciate;
                }
            case 3:
                if (row == 0) {
                    return 0.0;
                } else {
                    depreciate = (d.getValor() * 0.50);
                    return depreciate;
                }
        }
        return null;
    }

    private void tipoAc() {
        tipoAc = new ArrayList<>();
        tipoAc.add("Edificaciones");
        tipoAc.add("Maquinaria");
        tipoAc.add("Vehiculos");
        tipoAc.add("Otros");
    }

    private Object acc(int rowIndex) {
        if (rowIndex == 0) {
            return 0.0;
        } else {
            acumulado += depreciate;
            return acumulado;
        }
    }

    private Object valorL(int rowIndex) {
        if (rowIndex == 0) {
            return d.getValor();
        } else {
            vLibros -= depreciate;
            return vLibros;
        }
    }

    private Object periodo(int columnIndex) {
        return (d.getAdquisicion() + columnIndex);
    }
}
