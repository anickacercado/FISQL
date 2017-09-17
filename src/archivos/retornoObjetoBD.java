/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import archivos.db.database;
import archivos.objeto.object;
import archivos.tabla.table;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class retornoObjetoBD {

    public object retornoObjeto(String nombre_bd, String nombre_obj) {
        ArrayList<database> tempData = new ArrayList<database>();
        object obj = null;
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("OBJECT")) {
                        obj = tempData.get(j).returnObject(nombre_obj);
                        return obj;
                    }
                }
            }
        }
        return null;
    }

    public database retornoTablaData(String nombre_bd, String nombre_table) {
        ArrayList<database> tempData = new ArrayList<database>();
        database db = null;
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE") && tempData.get(j).getNombre().equals(nombre_table)) {
                        db = tempData.get(j);
                        return db;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<table> retornoTabla(String nombre_bd, String nombre_table) {
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<table> tab = new ArrayList<table>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE") && tempData.get(j).getNombre().equals(nombre_table)) {
                        tab = tempData.get(j).getTable();
                        return tab;
                    }
                }
            }
        }
        return null;
    }

    public table retorno_Campo_Tabla(String nombre_bd, String nombre_table, String nombre_campo) {
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<table> tab = new ArrayList<table>();
        table ret_tab = null;
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE") && tempData.get(j).getNombre().equals(nombre_table)) {
                        tab = tempData.get(j).getTable();
                        for (int k = 0; k < tab.size(); k++) {
                            ret_tab = tab.get(k);
                            if (ret_tab.getNombre_campo().equals(nombre_campo)) {
                                return ret_tab;
                            }
                        }
                    }
                }
            }
        }
        return ret_tab;
    }

}
