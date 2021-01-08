package Tablas;

import DAO.DAO_Abono;
import DAO.DAO_Clientes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;
import modelos.Abono;
import modelos.Cliente;

/**
 *
 * @author Monica
 */
public class tablaAbonos implements TableModel {

    DAO_Abono daoAbono;
    ArrayList<Abono> abonos;

    public tablaAbonos(String factura) {
        daoAbono = new DAO_Abono();
        try {
            abonos = daoAbono.getAbonos(factura);
        } catch (SQLException ex) {
            Logger.getLogger(tablaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return abonos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Abono prove = (Abono) abonos.get(rowIndex);

//        DAO_Cuentas daoCuenta = new DAO_Cuentas();
//        String tipo = daoCuenta.getTipo(cuenta.getTipo()).getTipo();
        switch (columnIndex) {
            case 0:
                return rowIndex+1;
            case 1:
                return prove.getAbono();
            case 2:
                return prove.getFecha();
            case 3:
                return prove.getDescripcion();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "N° Abono";
            case 1:
                return "Abono efectuado";
            case 2:
                return "Fechas";
            case 3:
                return "Comentarios";
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
