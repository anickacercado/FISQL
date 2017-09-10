/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDL;

import archivos.EscrituraBD;
import archivos.LecturaBD;
import archivos.db.database;
import archivos.memoria;
import archivos.objeto.object;
import archivos.parametro;
import archivos.tabla.fila_tabla;
import archivos.tabla.fila_tabla_objeto;
import archivos.tabla.table;
import archivos.usuario.permisos;
import archivos.usuario.user;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class alter {

    EscrituraBD escritura = new EscrituraBD();
    LecturaBD lectura = new LecturaBD();

    public void alter_table_agregar(String nombre_bd, String nombre_table, ArrayList<table> tab) {
        ArrayList<database> tempData = new ArrayList<database>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE")) {
                        if (tempData.get(j).getNombre().equals(nombre_table)) {
                            for (int k = 0; k < tab.size(); k++) {
                                if (tempData.get(j).existTable(tab.get(k).getNombre_campo()) == false) {
                                    tempData.get(j).addTable(tab.get(k));
                                }
                            }
                        }
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
        escritura.Escribir();
    }

    public void ajustarFila(String nombre_bd, String nombre_table, String nombre_campo, String valor) {
//        int fila = 0;
//        ArrayList<database> tempData = new ArrayList<database>();
//        ArrayList<table> tempTable = new ArrayList<table>();
//        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
//            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
//                tempData = memoria.arbolMaestro.get(i).getDatabase();
//                for (int j = 0; j < tempData.size(); j++) {
//                    if (tempData.get(j).getTipo().equals("TABLE")) {
//                        if (tempData.get(j).getNombre().equals(nombre_table)) {
//                            tempTable = tempData.get(j).getTable();
//                            for (int k = 0; k < tempTable.size(); k++) {
//                                if (tempTable.get(k).getNombre_campo().equals(nombre_campo)) {
//                                    fila = tempTable.get(k).getRegistro().size();
//                                    fila_tabla ft = new fila_tabla(fila, valor);
//                                    tempTable.get(k).addRegistro(ft);
//                                }
//                            }
//                            tempData.get(j).setTable(tempTable);
//                        }
//                    }
//                }
//                memoria.arbolMaestro.get(i).setDatabase(tempData);
//            }
//        }
    }

    public void alter_table_quitar(String nombre_bd, String nombre_table, ArrayList<parametro> para) {
        ArrayList<database> tempData = new ArrayList<database>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE")) {
                        if (tempData.get(j).getNombre().equals(nombre_table)) {
                            for (int k = 0; k < para.size(); k++) {
                                tempData.get(j).removeTable(para.get(k).getNombre());
                            }
                        }
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
        escritura.Escribir();
    }

    public void alter_objeto_agregar(String nombre_bd, String nombre_obj, ArrayList<parametro> para) {
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<object> tempObject = new ArrayList<object>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("OBJECT")) {
                        tempObject = tempData.get(j).getObject();
                        for (int k = 0; k < tempObject.size(); k++) {
                            if (tempObject.get(k).getNombre().equals(nombre_obj)) {
                                for (int l = 0; l < para.size(); l++) {
                                    if (tempObject.get(k).existsAtributo(para.get(l).getNombre()) == false) {
                                        tempObject.get(k).addAtributo(para.get(l));
                                    }
                                }
                            }
                        }
                        tempData.get(j).setObject(tempObject);
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
        escritura.Escribir();
    }

    public void alter_objeto_quitar(String nombre_bd, String nombre_obj, ArrayList<parametro> para) {
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<object> tempObject = new ArrayList<object>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("OBJECT")) {
                        tempObject = tempData.get(j).getObject();
                        for (int k = 0; k < tempObject.size(); k++) {
                            if (tempObject.get(k).getNombre().equals(nombre_obj)) {
                                for (int l = 0; l < para.size(); l++) {
                                    tempObject.get(k).removeAtributo(para.get(l).getNombre());
                                }
                            }
                        }
                        tempData.get(j).setObject(tempObject);
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
            }
        }
        escritura.Escribir();
    }

    public void alterUsuario(String usuario, String contrasenia) {
        for (int i = 0; i < memoria.arbolUsuario.size(); i++) {
            if (memoria.arbolUsuario.get(i).getNombre().equals(usuario)) {
                memoria.arbolUsuario.get(i).setPass(contrasenia);
                escritura.Escribir();
            }
        }
    }

    public void alterParametro(ArrayList<parametro> lp, String nombre, String tipo) {
        parametro p = new parametro(nombre, tipo);
        lp.add(p);
    }

    public void alterColumn(ArrayList<table> tab, String nombre, String tipo, String nulo, String no_nulo, String autoincrementable, String llave_primaria, String llave_foranea) {
        table ta;
        if (tipo.equals("INTEGER")
                || tipo.equals("TEXT")
                || tipo.equals("DOUBLE")
                || tipo.equals("BOOL")
                || tipo.equals("DATE")
                || tipo.equals("DATETIME")) {

            ArrayList<fila_tabla> registro = new ArrayList<fila_tabla>();
            ta = new table(nombre, tipo, nulo, no_nulo, autoincrementable, llave_primaria, llave_foranea, registro, false, null);
            tab.add(ta);
        } else {
            ArrayList<fila_tabla_objeto> registro_objeto = new ArrayList<fila_tabla_objeto>();
            ta = new table(nombre, tipo, nulo, no_nulo, autoincrementable, llave_primaria, llave_foranea, null, true, registro_objeto);
            tab.add(ta);
        }
    }

}
