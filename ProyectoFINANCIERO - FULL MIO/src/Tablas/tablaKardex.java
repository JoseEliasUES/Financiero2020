package Tablas;

import DAO.DAO_Abono;
import DAO.DAO_Kardex;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;
import modelos.Abono;
import modelos.Kardex;

/**
 *
 * @author Monica
 */
public class tablaKardex implements TableModel {

    DAO_Kardex daoAbono;
    ArrayList<Kardex> abonos;

    public tablaKardex(int idProd) {
        daoAbono = new DAO_Kardex();
        try {
            abonos = daoAbono.getKardex(idProd);
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
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kardex abo = (Kardex) abonos.get(rowIndex);

//        DAO_Cuentas daoCuenta = new DAO_Cuentas();
//        String tipo = daoCuenta.getTipo(cuenta.getTipo()).getTipo();
        switch (columnIndex) {
            case 0:
                return abo.getFecha();
            case 1:
                return abo.getDetalle();
            case 2:
                return abo.getCantidadC();
            case 3:
                return abo.getPrecioUC();
            case 4:
                return abo.getTotalC();
            case 5:
                return abo.getCantidadV();
            case 6:
                return abo.getPrecioUV();
            case 7:
                return abo.getTotalV();
            case 8:
                return abo.getCantidadE();
            case 9:
                return abo.getPrecioUE();
            case 10:
                return abo.getTotalE();

        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "FECHA";
            case 1:
                return "DETALLE";
            case 2:
                return "CÁNTIDAD";
            case 3:
                return "V/ UNITARÍO";
            case 4:
                return "V/ TOTAL";
            case 5:
                return "CÁNTIDAD";
            case 6:
                return "V/ UNITARÍO";
            case 7:
                return "V/ TOTAL";
            case 8:
                return "CÁNTIDAD";
            case 9:
                return "V/ UNITARÍO";
            case 10:
                return "V/ TOTAL";

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
