/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinanciero;

import DAO.DAO_Categoria;
import DAO.DAO_Marca;
import DAO.DAO_Productos;
import Tablas.tablaProductos;
import Tablas.tblPr;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Categoria;
import modelos.MarcaV;
import modelos.Producto;
import static proyectofinanciero.DCompra.modelo;
import Conexion.Conexion;
import DAO.DAO_Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Proveedor;

/**
 *
 * @author gemelos
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Marca
     */
    DefaultTableModel md;
    tblPr tPr;
    Categoria categoria;
    Producto pro;
    boolean flag;
    Integer idP;
    static DefaultComboBoxModel comboModelC;
    static DefaultComboBoxModel comboModelM;
    static DefaultComboBoxModel comboModelP;
    ArrayList<Categoria> datosCat;
    ArrayList<MarcaV> datosM;
    ArrayList<Proveedor> datosP;

    public Productos() {
        initComponents();
        tPr = new tblPr();
        categoria = new Categoria();
        pro = new Producto();
        tblProd.setModel(tPr);
        flag = false;
        comboModelC = new DefaultComboBoxModel();
        comboModelM = new DefaultComboBoxModel();
        comboModelP = new DefaultComboBoxModel();
        llenaC();
    }

    private void llenaC() {

        comboModelC.removeAllElements();
        comboModelM.removeAllElements();
        comboModelP.removeAllElements();
        comboModelC.addElement("Seleccione Categoria...");
        comboModelM.addElement("Seleccione Marca...");
        comboModelP.addElement("Seleccione Proveedor...");
        DAO_Categoria daoCat = new DAO_Categoria();
        try {
            datosCat = daoCat.getCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        DAO_Marca daoM = new DAO_Marca();
        try {
            datosM = daoM.getMarca();
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        DAO_Proveedor daoP = new DAO_Proveedor();
        try {
            datosP = daoP.getProveedor();
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        datosCat.forEach((c) -> {
            comboModelC.addElement(c.getnCat());
        });
        datosM.forEach((m) -> {
            comboModelM.addElement(m.getMarca());
        });
        datosP.forEach((p) -> {
            comboModelP.addElement(p.getNombre());
        });
        cCat.setModel(comboModelC);
        cMarca.setModel(comboModelM);
        cmbP.setModel(comboModelP);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnCance = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cMarca = new javax.swing.JComboBox<>();
        cCat = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cmbP = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRAR PRODUCTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        tblProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblProdMouseEntered(evt);
            }
        });
        tblProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProdKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProd);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setText("Nombre");

        jLabel4.setText("Marca");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnEdit.setText("Guardar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCance.setText("Cancelar");
        btnCance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceActionPerformed(evt);
            }
        });

        btnAdd.setText("Editar");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDel.setText("Eliminar");
        btnDel.setEnabled(false);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel2.setText("Modelo");

        jLabel5.setText("Categoria");

        jLabel6.setText("Descripcion");

        cMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione marca" }));

        cCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoria" }));

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane2.setViewportView(txtDesc);

        jLabel7.setText("Proveedor");

        cmbP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(cMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCance, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(cCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int selectMar = cMarca.getSelectedIndex();
        int selectCat = cCat.getSelectedIndex();
        int selectP =cmbP.getSelectedIndex();
        String nombre = txtNombre.getText();
        String modelo = txtModelo.getText();
        String desc = txtDesc.getText();
        if (selectP == 0 || selectCat == 0 || selectMar == 0 || !"".equals(nombre)
                || !"".equals(modelo) || !"".equals(desc)) {
            DAO_Productos dP = new DAO_Productos();
            if (!flag) {
                try {
                    dP.nProducto(new Producto(nombre, modelo, 0, datosM.get(selectMar - 1), datosCat.get(selectCat - 1), desc,datosP.get(selectP-1)));
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    dP.updateProducto(new Producto(pro.getId(), nombre, modelo, datosM.get(selectMar - 1), datosCat.get(selectCat - 1), desc,datosP.get(selectP-1)));
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiar();
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Campos vacios");

        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int x = tblProd.getSelectedRow();
        if (x == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un Producto");
        } else {
            idP = Integer.parseInt(tblProd.getValueAt(x, 0).toString());
            try {
                if (busqM(idP)) {
                    txtNombre.setText(pro.getNombre());
                    txtDesc.setText(pro.getDescripcion());
                    txtModelo.setText(pro.getModelo());
                    for (int i = 0; i < datosCat.size(); i++) {
                        if (datosCat.get(i).getIdCat() == pro.getCategoria().getIdCat()) {
                            cCat.getModel().setSelectedItem(datosCat.get(i).getnCat());
                        }
                    }
                    for (int i = 0; i < datosM.size(); i++) {
                        if (datosM.get(i).getIdMarca() == pro.getMarca().getIdMarca()) {
                            cMarca.getModel().setSelectedItem(datosM.get(i).getMarca());
                        }
                    }
                    for (int i = 0; i < datosP.size(); i++) {
                        if (datosP.get(i).getId() == pro.getProv().getId()) {
                            cmbP.getModel().setSelectedItem(datosP.get(i).getNombre());
                        }
                    }
                    btnAdd.setEnabled(false);
                    btnDel.setEnabled(false);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProdKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProdKeyPressed

    private void tblProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdMouseEntered
        // TODO add your handling code here
    }//GEN-LAST:event_tblProdMouseEntered

    private void tblProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdMouseClicked
        // TODO add your handling code here:
        flag = true;
        btnAdd.setEnabled(flag);
        btnDel.setEnabled(flag);
    }//GEN-LAST:event_tblProdMouseClicked

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        int x = tblProd.getSelectedRow();
        if (x == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
        } else {
            try {
                Integer idP = Integer.parseInt(tblProd.getValueAt(x, 0).toString());
                if (busqM(idP)) {
                    DAO_Productos daoC = new DAO_Productos();
                    daoC.eliminarProducto(pro);
                    actualizarTabla();
                    btnDel.setEnabled(false);
                    btnAdd.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnCanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceActionPerformed
        // TODO add your handling code here:
        flag = false;
        btnAdd.setEnabled(flag);
        btnDel.setEnabled(flag);
        limpiar();
    }//GEN-LAST:event_btnCanceActionPerformed
    public void actualizarTabla() {

        tblProd.setModel(new DefaultTableModel());
        tblProd.setModel(new tblPr());
    }

    public void limpiar() {
        txtModelo.setText("");
        txtNombre.setText("");
        cMarca.setSelectedIndex(0);
        cCat.setSelectedIndex(0);
        cmbP.setSelectedIndex(0);
        txtDesc.setText("");
    }

    private boolean busqM(Integer nombre) throws SQLException {
        DAO_Productos daoC = new DAO_Productos();
        for (Producto x : daoC.getProductos()) {
            if (nombre.equals(x.getId())) {
                pro = x;
                return true;
            }
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCance;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cCat;
    private javax.swing.JComboBox<String> cMarca;
    private javax.swing.JComboBox<String> cmbP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
