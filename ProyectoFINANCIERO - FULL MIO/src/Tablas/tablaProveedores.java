package Tablas;

import DAO.DAO_Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;
import modelos.Proveedor;

/**
 *
 * @author Monica
 */
public class tablaProveedores implements TableModel {

    DAO_Proveedor daoProv;
    ArrayList<Proveedor> proveedores;

    public tablaProveedores() {
        daoProv = new DAO_Proveedor();
        try {
            proveedores = daoProv.getProveedor();
        } catch (SQLException ex) {
            Logger.getLogger(tablaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public tablaProveedores(ArrayList tipo) {
        this.proveedores = tipo;
    }
 
    @Override
    public int getRowCount() {
        return proveedores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proveedor prove = (Proveedor) proveedores.get(rowIndex);

//        DAO_Cuentas daoCuenta = new DAO_Cuentas();
//        String tipo = daoCuenta.getTipo(cuenta.getTipo()).getTipo();
        switch (columnIndex) {
            case 0:
                return prove.getId();
            case 1:
                return prove.getNombre();
                 case 2:
                return prove.getTelefono();
            case 3:
                return prove.getDireccion();
            case 4:
                return prove.getCorreo();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "CÓDIGO";
            case 1:
                return "NOMBRE";
             case 2:
                return "TELEFONO";
             case 3:
                return "DIRECCION";
             case 4:
                return "CORREO";
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
