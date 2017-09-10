/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DML;

import archivos.db.database;
import archivos.memoria;
import archivos.metodo.function;
import archivos.tabla.*;
import java.util.ArrayList;

/**
 *
 * @author 3plgtanickacf
 */
public class accionTabla {

    public void insertTable(String nombre_bd, String nombre_table, String nombre_campo, String valor) {
        int fila = 0;
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<table> tempTable = new ArrayList<table>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE")) {
                        if (tempData.get(j).getNombre().equals(nombre_table)) {
                            tempTable = tempData.get(j).getTable();
                            for (int k = 0; k < tempTable.size(); k++) {
                                if (tempTable.get(k).getNombre_campo().equals(nombre_campo)) {
                                    fila = tempTable.get(k).getRegistro().size();
                                    fila_tabla ft = new fila_tabla(fila, valor);
                                    tempTable.get(k).addRegistro(ft);
                                }
                            }
                            tempData.get(j).setTable(tempTable);
                        }
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
    }

    public void insertTableObject(String nombre_bd, String nombre_table, String nombre_campo, ArrayList<registro_objeto> ro) {
        int fila = 0;
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<table> tempTable = new ArrayList<table>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE")) {
                        if (tempData.get(j).getNombre().equals(nombre_table)) {
                            tempTable = tempData.get(j).getTable();
                            for (int k = 0; k < tempTable.size(); k++) {
                                if (tempTable.get(k).getNombre_campo().equals(nombre_campo) && tempTable.get(k).isEs_objeto() == true) {
                                    fila = tempTable.get(k).getRegistro_objeto().size();
                                    fila_tabla_objeto fto = new fila_tabla_objeto(fila, ro);
                                    tempTable.get(k).addRegistroObjeto(fto);
                                }
                            }
                            tempData.get(j).setTable(tempTable);
                        }
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
    }
}
