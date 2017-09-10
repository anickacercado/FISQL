/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDL;

import archivos.EscrituraBD;
import archivos.db.database;
import archivos.memoria;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class eliminar {
    
    EscrituraBD escritura= new EscrituraBD();
    
     public void eliminarObjeto(String nombre_bd, String nombre_obj) {
        ArrayList<database> tempData = new ArrayList<database>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("OBJECT")) {
                        tempData.get(j).removeObject(nombre_obj);
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
        escritura.Escribir();
    }
    
     public void eliminarProcedure(String nombre_bd, String nombre_proc) {
        ArrayList<database> tempData = new ArrayList<database>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("PROCEDURE")) {
                        tempData.get(j).removeProcedure(nombre_proc);
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
        escritura.Escribir();
    }
     
    public void eliminarFunction(String nombre_bd, String nombre_func) {
        ArrayList<database> tempData = new ArrayList<database>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("FUNCTION")) {
                        tempData.get(j).removeFunction(nombre_func);
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
        escritura.Escribir();
    }
    
    public void eliminarTable(String nombre_bd, String nombre_table) {
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                memoria.arbolMaestro.get(i).removeTable(nombre_table);
            }
        }
        escritura.Escribir();
    }
    
    public void eliminarUsuario(String usuario) {
        for (int i = 0; i < memoria.arbolUsuario.size(); i++) {
            if (memoria.arbolUsuario.get(i).getNombre().equals(usuario)) {
                memoria.arbolUsuario.remove(i);
            }
        }
    }    
}
