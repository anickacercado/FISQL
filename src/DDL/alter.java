/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDL;

import archivos.EscrituraBD;
import archivos.LecturaBD;
import archivos.db.database;
import archivos.db.propertyField;
import archivos.memoria;
import archivos.objeto.object;
import archivos.parametro;
import archivos.retornoObjetoBD;
import archivos.tabla.fila_tabla;
import archivos.tabla.fila_tabla_objeto;
import archivos.tabla.registro_objeto;
import archivos.tabla.table;
import estructuraUSQL.ambito;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class alter {

    EscrituraBD escritura = new EscrituraBD();
    LecturaBD lectura = new LecturaBD();
    int fila = 0;
    retornoObjetoBD rob = new retornoObjetoBD();

    String tipo = "";
    String nombre_objeto = "";
    String contrasenia = "";
    Object parametros = "";
    public ambito ambito;

    public alter(String tipo, String nombre_objeto, String contrasenia, Object parametros, ambito ambito) {
        this.tipo = tipo;
        this.nombre_objeto = nombre_objeto;
        this.contrasenia = contrasenia;
        this.parametros = parametros;
        this.ambito = ambito;
    }

    public void ejecucion() {
        switch (tipo) {
            case "ALTER_TABLE_AGREGAR":
                alter_table_agregar(memoria.use_db, nombre_objeto, lista_table());
                break;
            case "ALTER_TABLE_QUITAR":
                alter_table_quitar(memoria.use_db, nombre_objeto, lista_para());
                break;
            case "ALTER_OBJETO_AGREGAR":
                alter_objeto_agregar(memoria.use_db, nombre_objeto, lista_para());
                break;
            case "ALTER_OBJETO_QUITAR":
                alter_objeto_quitar(memoria.use_db, nombre_objeto, lista_para());
                break;
            case "ALTER_USUARIO":
                alterUsuario(nombre_objeto, contrasenia);
                break;
            default:
                break;
        }
    }

    //CODIGO RE -------------------SHUCOTE :O
    private ArrayList<parametro> lista_para() {
        ArrayList<parametro> para = new ArrayList<parametro>();
        try {
            ArrayList<parametro> p = (ArrayList<parametro>) parametros;
            for (int i = 0; i < p.size(); i++) {
                alterParametro(para, p.get(i).getNombre(), p.get(i).getTipo());
            }
        } catch (Exception e) {
        }
        return para;
    }

    private ArrayList<table> lista_table() {
        ArrayList<table> tab = new ArrayList<table>();
        ArrayList<table> tabla = rob.retornoTabla(memoria.use_db, nombre_objeto);
        fila = getColumnaInsert(tabla);
        ArrayList<propertyField> p = (ArrayList<propertyField>) parametros;
        for (int l = 0; l < p.size(); l++) {
            alterColumn(tab, p.get(l).getNombre(), p.get(l).getTipo().toUpperCase(), p.get(l).getNulo(), p.get(l).getNo_nulo(), p.get(l).getAutoincrementable(), p.get(l).getLlave_primaria(), p.get(l).getLlave_foranea());
        }
        return tab;
    }

    private void alterColumn(ArrayList<table> tab, String nombre, String tipo, String nulo, String no_nulo, String autoincrementable, String llave_primaria, String llave_foranea) {
        table ta;
        fila_tabla ft;
        fila_tabla_objeto fto;
        registro_objeto ro;
        if (tipo.equals("ENTERO") || tipo.equals("CADENA") || tipo.equals("DOUBLE") || tipo.equals("BOOL") || tipo.equals("DATE") || tipo.equals("DATETIME")) {
            ArrayList<fila_tabla> registro = new ArrayList<fila_tabla>();
            for (int i = 0; i < fila; i++) {
                ft = new fila_tabla(0, "NULL");
                registro.add(ft);
            }
            ta = new table(nombre, tipo, nulo, no_nulo, autoincrementable, llave_primaria, llave_foranea, registro, false, null);
            tab.add(ta);
        } else {
            tipo = tipo.toLowerCase();
            ArrayList<fila_tabla_objeto> registro_objeto = new ArrayList<fila_tabla_objeto>();
            ArrayList<registro_objeto> lro = new ArrayList<registro_objeto>();
            object obj = rob.retornoObjeto(memoria.use_db, tipo);
            if (obj != null) {
                for (int j = 0; j < obj.getAtributo().size(); j++) {
                    ro = new registro_objeto(obj.getAtributo().get(j).getTipo(), "NULL");
                    lro.add(ro);
                }
                for (int i = 0; i < fila; i++) {
                    fto = new fila_tabla_objeto(0, lro);
                    registro_objeto.add(fto);
                }

                ta = new table(nombre, tipo, nulo, no_nulo, autoincrementable, llave_primaria, llave_foranea, null, true, registro_objeto);
                tab.add(ta);
            } else {
                //NO EXISTE OBJETO DENTRO DE BASE DE DATOS
            }
        }
    }

    private void alter_table_agregar(String nombre_bd, String nombre_table, ArrayList<table> tab) {
        ArrayList<database> tempData = new ArrayList<database>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("TABLE")) {
                        if (tempData.get(j).getNombre().equals(nombre_table)) {
                            fila = getColumnaInsert(tempData.get(j).getTable());
                            for (int k = 0; k < tab.size(); k++) {
                                if (tempData.get(j).existTable(tab.get(k).getNombre_campo()) == false) {
                                    tempData.get(j).addTable(tab.get(k));
                                }
                            }
                        }
                    }
                }
            }
        }
        escritura.Escribir();
    }

    private int getColumnaInsert(ArrayList<table> table) {
        int fila = 0;
        try {
            fila = table.get(0).noFila();
        } catch (Exception e) {
        }
        return fila;
    }

    private void alterParametro(ArrayList<parametro> lp, String nombre, String tipo) {
        parametro p = new parametro(nombre, tipo);
        lp.add(p);
    }

    private void alter_table_quitar(String nombre_bd, String nombre_table, ArrayList<parametro> para) {
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
            }
        }
        escritura.Escribir();
    }

    private void alter_objeto_agregar(String nombre_bd, String nombre_obj, ArrayList<parametro> para) {
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
                    }
                }
            }
        }
        escritura.Escribir();
    }

    private void alter_objeto_quitar(String nombre_bd, String nombre_obj, ArrayList<parametro> para) {
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
                    }
                }
            }
        }
        escritura.Escribir();
    }

    private void alterUsuario(String usuario, String contrasenia) {
        for (int i = 0; i < memoria.arbolUsuario.size(); i++) {
            if (memoria.arbolUsuario.get(i).getNombre().equals(usuario)) {
                memoria.arbolUsuario.get(i).setPass(contrasenia);
                escritura.Escribir();
            }
        }
    }

    //CODIGO RE -------------------SHUCOTE :O
}
