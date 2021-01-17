package Tablas;

import DAO.DAO_Cliente;
import DAO.DAO_Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;

import javax.swing.table.TableModel;
import modelos.Cliente;
import modelos.Proveedor;

/**
 *
 * @author Monica
 */
public class tablaClientes implements TableModel {

    DAO_Cliente daoCli;
    ArrayList<Cliente> lsClientes;

    public tablaClientes() {
        daoCli = new DAO_Cliente();
        try {
            lsClientes = daoCli.getClientes();
        } catch (SQLException ex) {
            Logger.getLogger(tablaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public tablaClientes(ArrayList tipo) {
        this.lsClientes = tipo;
    }

    public tablaClientes(String duiF) {
        daoCli = new DAO_Cliente();
        lsClientes = daoCli.getClientesFiltrado(duiF);
    }

    @Override
    public int getRowCount() {
        return lsClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente clien = (Cliente) lsClientes.get(rowIndex);

//        DAO_Cuentas daoCuenta = new DAO_Cuentas();
//        String tipo = daoCuenta.getTipo(cuenta.getTipo()).getTipo();
        switch (columnIndex) {
            case 0:
                return clien.getIdCliente();
            case 1:
                return clien.getNombre();
            case 2:
                return clien.getApellido();
            case 3:
                return clien.getDui();
            case 4:
                return clien.getSexo();
            case 5:
                return clien.getTelefono();
            case 6:
                return clien.getEmail();
            case 7:
                return clien.getDireccion();
            case 8:
                String es = "";
                if (clien.getEstado() == 0) {
                    es = "Inactivo";
                } else {
                    es = "Activo";
                }
                return es;
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "CÓDIGO";
            case 1:
                return "NOMBRES";
            case 2:
                return "APELLIDOS";
            case 3:
                return "DUI";
            case 4:
                return "SEXO";
            case 5:
                return "TELÉFONO";
            case 6:
                return "EMAIL";
            case 7:
                return "DIRECCIÓN";
            case 8:
                return "ESTADO";
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
