package Tablas;

import DAO.DAO_Abono;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;
import modelos.Abono;

/**
 *
 * @author Monica
 */
public class tablaCuentasxCobrar implements TableModel {

    DAO_Abono daoAbono;
    private ArrayList<Abono> abonos;
    public tablaCuentasxCobrar() {
        daoAbono = new DAO_Abono();
        try {
            abonos = daoAbono.getCxC();
            
        } catch (SQLException ex) {
            Logger.getLogger(tablaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public tablaCuentasxCobrar(String dui) {
                daoAbono = new DAO_Abono();
                abonos = daoAbono.getCxCF(dui);
    }

    @Override
    public int getRowCount() {
        return abonos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Abono abo = (Abono) abonos.get(rowIndex);
//        DAO_Cuentas daoCuenta = new DAO_Cuentas();
//        String tipo = daoCuenta.getTipo(cuenta.getTipo()).getTipo();
        switch (columnIndex) {
            case 0:
                return abo.getFactura();
            case 1:
                return abo.getDui();
            case 2:
                return abo.getCliente();
            case 3:
                return abo.getProducto();
            case 4:
                return abo.getCredInicial();
            case 5:
                return (abo.getCredInicial()- abo.getSaldoPendiente());
            case 6:
                return abo.getFechaCredito();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "#Factura";
            case 1:
                return "DUI";
            case 2:
                return "Cliente";
            case 3:
                return "Producto";
            case 4:
                return "Crédito Inicial";
            case 5:
                return "Saldo Pendiente";
            case 6:
                return "Fecha Crédito";
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

    public ArrayList<Abono> getAbonos() {
        return abonos;
    }

}
