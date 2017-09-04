/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import DDL.alter;
import DDL.create;
import archivos.EscrituraBD;
import archivos.LecturaBD;
import archivos.db.database;
import archivos.maestro.master;
import archivos.memoria;
import archivos.parametro;
import archivos.tabla.table;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.db.ParseException;
import xml.db.db;
import xml.usuario.usuario;

/**
 *
 * @author anick
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
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
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("ANALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<parametro> lp = new ArrayList<parametro>();
    ArrayList<table> lt = new ArrayList<table>();
    create cre = new create();
    alter alt = new alter();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //BD en memoria
        LecturaBD lb = new LecturaBD();
        lb.leer();
       
        cre.crearBD("Titus");
        

        //Creación de Objeto, Procedimiento, Funcion
        cre.insertParametro(lp, "campo1", "TEXT");
        cre.insertParametro(lp, "campo2", "INTEGER");
        cre.insertParametro(lp, "campo3", "DATE");
        cre.CrearObjeto("anicka", "objeto1", lp);
        cre.CrearProc("anicka", "procedimiento1", lp, "instrucciones");
        cre.CrearFunc("anicka", "funcion1", lp, "instrucciones", "DATE");
        cre.CrearObjeto("anicka", "objeto2", lp);
        cre.CrearProc("anicka", "procedimiento2", lp, "instrucciones");
        cre.CrearFunc("anicka", "Funcion2", lp, "instrucciones", "DATE");
        
        //Creación de Tabla
        cre.insertColumn(lt, "COLUMNA1", "INTEGER", "Y", "Y", "Y", "Y", "N");
        cre.insertColumn(lt, "COLUMNA2", "INTEGER", "Y", "Y", "Y", "Y", "N");
        cre.insertColumn(lt, "COLUMNA3", "INTEGER", "Y", "Y", "Y", "Y", "N");
        cre.insertColumn(lt, "COLUMNA4", "INTEGER", "Y", "Y", "Y", "Y", "N");
        cre.CrearTable("anicka", "TABLA1", lt);
        cre.CrearTable("anicka", "TABLA2", lt);
        cre.CrearTable("anicka", "TABLA3", lt);
        cre.CrearTable("anicka", "TABLA4", lt);
        cre.CrearTable("anicka", "TABLA5", lt);
        
        cre.crearBD("Ecuador");
        cre.crearBD("ElSalvador");
  
        //Crear usuario
        cre.createUsuario("anicka", "123", "user");
        cre.createUsuario("santiago", "123", "user");
        cre.crearBD("Santiaguito");
        cre.crearBD("Roma");
        cre.CrearTable("Santiaguito", "TABLA1", lt);
        cre.CrearTable("Santiaguito", "TABLA2", lt);
        cre.CrearTable("Santiaguito", "TABLA3", lt);
        cre.CrearTable("Santiaguito", "TABLA4", lt);
        cre.CrearTable("Santiaguito", "TABLA5", lt);
        cre.crearBD("Italia");
        cre.crearBD("USA");
        
        alt.alter_table_agregar("anicka","TABLA1", alt.alterColumn("COLUMNAALTER1", "INTEGER", "Y", "Y", "Y", "Y", "N"));
        alt.alter_table_agregar("anicka","TABLA1", alt.alterColumn("COLUMNAALTER2", "OBJETO", "Y", "Y", "Y", "Y", "N"));
        
        ArrayList<master> arbolMaestro= memoria.arbolMaestro;
    }//GEN-LAST:event_jButton1ActionPerformed

    //Probar gramatica
    private void testUsuario() {
        usuario g = new usuario(new java.io.StringReader(this.jTextArea1.getText()));
        try {
            g.S();
            System.out.print("Exito");
        } catch (xml.usuario.ParseException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
