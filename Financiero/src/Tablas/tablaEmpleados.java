package Tablas;

import DAO.DAO_Empleados;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;
import modelos.Empleados;

/**
 *
 * @author Monica
 */
public class tablaEmpleados implements TableModel {

    DAO_Empleados daoEmp;
    ArrayList<Empleados> empleados;

    public tablaEmpleados(){
        daoEmp = new DAO_Empleados();    
        try {
            empleados = daoEmp.getEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(tablaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleados prove = (Empleados) empleados.get(rowIndex);

//        DAO_Cuentas daoCuenta = new DAO_Cuentas();
//        String tipo = daoCuenta.getTipo(cuenta.getTipo()).getTipo();
        switch (columnIndex) {
            case 0:
                return prove.getDui();
            case 1:
                return prove.getNombres();
            case 2:
                return prove.getApellidos();
            case 3:
                return prove.getSexo();
            case 4:
                return prove.getTelefono();
            case 5:
                return prove.getEmail();
            case 6:
                return prove.getCargo();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "DUI";
            case 1:
                return "NOMBRES";
            case 2:
                return "APELLIDOS";
            case 3:
                return "SEXO";
            case 4:
                return "TELÉFONO";
            case 5:
                return "EMAIL";
            case 6:
                return "CARGO";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

    @Override
    public void addTableModelListener(TableModelListener tl) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {

    }

}
