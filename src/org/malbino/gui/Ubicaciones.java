/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.malbino.gui;

import java.util.List;
import org.malbino.daos.UbicacionDao;
import org.malbino.gui.tablemodels.TableModelUbicacion;
import org.malbino.models.Ubicacion;

/**
 *
 * @author Tincho
 */
public class Ubicaciones extends javax.swing.JInternalFrame {
    
    UbicacionDao ubicacionDao;

    /**
     * Creates new form ubicaciones
     */
    public Ubicaciones() {
        initComponents();
        
        ubicacionDao = new UbicacionDao();
        
        jTable1.getTableHeader().setReorderingAllowed(false);
    }

    public void actualizarLista() {
        List<Ubicacion> listaUbicacions = ubicacionDao.listaUbicaciones();
        TableModelUbicacion tableModelUbicacion = new TableModelUbicacion(listaUbicacions);
        jTable1.setModel(tableModelUbicacion);

        jTable1.getColumnModel().getColumn(1).setMinWidth(400); //nombre
        jTable1.getColumnModel().getColumn(2).setMinWidth(200); //observaciones
    }
    
    public void nuevaUbicacion() {
        Ubicacion ubicacion = new Ubicacion("", "");
        ubicacionDao.nuevaUbicacion(ubicacion);
        
        actualizarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ubicaciones");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/malbino/img/nuevo.png"))); // NOI18N
        jButton1.setText("Nueva Ubicación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nuevaUbicacion();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
