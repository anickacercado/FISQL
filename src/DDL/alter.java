/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDL;

import archivos.EscrituraBD;
import archivos.db.database;
import archivos.memoria;
import archivos.tabla.fila_tabla;
import archivos.tabla.fila_tabla_objeto;
import archivos.tabla.table;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class alter {

    EscrituraBD escritura = new EscrituraBD();

    public void alter_table_agregar(String nombre_bd, String nombre_table, table tab) {
        ArrayList<database> tempData = new ArrayList<database>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE")) {
                        if (tempData.get(j).getNombre().equals(nombre_table)) {
                            if (tempData.get(j).existTable(tab.getNombre_campo()) == false) {
                                tempData.get(j).addTable(tab);
                            }
                        }
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
                escritura.Escribir();
            }
        }
    }

    public table alterColumn(String nombre, String tipo, String nulo, String no_nulo, String autoincrementable, String llave_primaria, String llave_foranea) {
        table ta;
        if (tipo.equals("INTEGER")
                || tipo.equals("TEXT")
                || tipo.equals("DOUBLE")
                || tipo.equals("BOOL")
                || tipo.equals("DATE")
                || tipo.equals("DATETIME")) {

            ArrayList<fila_tabla> registro = new ArrayList<fila_tabla>();
            ta = new table(nombre, tipo, nulo, no_nulo, autoincrementable, llave_primaria, llave_foranea, registro, false, null);
        } else {
            ArrayList<fila_tabla_objeto> registro_objeto = new ArrayList<fila_tabla_objeto>();
            ta = new table(nombre, tipo, nulo, no_nulo, autoincrementable, llave_primaria, llave_foranea, null, true, registro_objeto);
        }
        return ta;
    }

}
