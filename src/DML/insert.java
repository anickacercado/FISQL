/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DML;

import archivos.EscrituraBD;
import archivos.db.database;
import archivos.memoria;
import archivos.objeto.object;
import archivos.retornoObjetoBD;
import archivos.tabla.fila_tabla;
import archivos.tabla.fila_tabla_objeto;
import archivos.tabla.registro_objeto;
import archivos.tabla.table;
import estructuraUSQL.ambito;
import estructuraUSQL.expresion;
import estructuraUSQL.objeto;
import estructuraUSQL.variable;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class insert {

    EscrituraBD escritura = new EscrituraBD();
    retornoObjetoBD rob = new retornoObjetoBD();
    public String nombre_tabla;
    public ArrayList<String> lista_id;
    public ArrayList<expresion> lista_expresion;
    public ArrayList<String> campo_nulo = new ArrayList<String>();
    public ambito ambito;

    public insert(String nombre_tabla, ArrayList<String> lista_id, ArrayList<expresion> lista_expresion, ambito ambito) {
        this.nombre_tabla = nombre_tabla;
        this.lista_id = lista_id;
        this.lista_expresion = lista_expresion;
        this.ambito= ambito;
    }

    public String getNombre_tabla() {
        return nombre_tabla;
    }

    public void setNombre_tabla(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
    }

    public ArrayList<String> getLista_id() {
        return lista_id;
    }

    public void setLista_id(ArrayList<String> lista_id) {
        this.lista_id = lista_id;
    }

    public ArrayList<expresion> getLista_expresion() {
        return lista_expresion;
    }

    public void setLista_expresion(ArrayList<expresion> lista_expresion) {
        this.lista_expresion = lista_expresion;
    }

    public void ejecucion() {
        ArrayList<table> tabla = rob.retornoTabla(memoria.use_db, nombre_tabla);
        database data = rob.retornoTablaData(memoria.use_db, nombre_tabla);
        ArrayList<registro_objeto> lro = new ArrayList<registro_objeto>();
        fila_tabla ft;
        fila_tabla_objeto fto;
        registro_objeto ro;
        variable vab = null;
        table columna;
        

        if (data != null) {
            if (lista_id == null) {
                //Es una inserción simple
                if (tabla != null) {
                    if (tabla.size() == lista_expresion.size()) {
                        data.setContador(data.getContador() + 1);
                        for (int i = 0; i < tabla.size(); i++) {
                            expresion exp = lista_expresion.get(i);
                            exp = exp.resCondicion();
                            columna = tabla.get(i);
                            if (columna.isEs_objeto()) {
                                if (columna.getTipo().toLowerCase().equals(exp.nombre)) {
                                    objeto obj = exp.objeto;
                                    for (int j = 0; j < obj.lista_variable.size(); j++) {
                                        vab = obj.lista_variable.get(j);
                                        expresion exp2 = (expresion) vab.valor;
                                        ro = new registro_objeto(vab.tipo, exp2.cadena);
                                        lro.add(ro);
                                    }
                                    fto = new fila_tabla_objeto(0, lro);
                                    columna.addRegistroObjeto(fto);
                                    lro = new ArrayList<registro_objeto>();
                                } else {
                                    object obj = rob.retornoObjeto(memoria.use_db, columna.getTipo().toLowerCase());
                                    if (obj != null) {
                                        for (int j = 0; j < obj.getAtributo().size(); j++) {
                                            String tipo = obj.getAtributo().get(j).getTipo();
                                            ro = new registro_objeto(tipo, "NULL");
                                            lro.add(ro);
                                        }
                                        fto = new fila_tabla_objeto(0, lro);
                                        columna.addRegistroObjeto(fto);
                                        lro = new ArrayList<registro_objeto>();
                                    }
                                    //TIPO DE DATOS NO COINCIDEN
                                }
                            } else {
                                if (columna.getTipo().equals(exp.tipo)) {

                                    if (columna.getAutoincrementable().equals("Y")) {
                                        ft = new fila_tabla(0, String.valueOf(data.getContador()));
                                        columna.addRegistro(ft);
                                    } else {
                                        ft = new fila_tabla(0, exp.cadena);
                                        columna.addRegistro(ft);
                                    }
                                } else {

                                    if (columna.getAutoincrementable().equals("Y")) {
                                        ft = new fila_tabla(0, String.valueOf(data.getContador()));
                                        columna.addRegistro(ft);
                                    } else {
                                        ft = new fila_tabla(0, "NULL");
                                        columna.addRegistro(ft);
                                    }
                                    //TIPO DE DATOS NO COINCIDEN 
                                }
                            }
                        }
                    } else {
                        //VALUES NO COINCIDEN EN CANTIDAD CON EXPRESIONES
                    }
                } else {//NO EXISTE TABLA

                }
            } else {
                if (lista_id.size() == lista_expresion.size()) {
                    data.setContador(data.getContador() + 1);
                    for (int i = 0; i < lista_id.size(); i++) {
                        expresion exp = lista_expresion.get(i);
                        exp = exp.resCondicion();
                        columna = rob.retorno_Campo_Tabla(memoria.use_db, nombre_tabla, lista_id.get(i));
                        if (columna != null) {
                            if (columna.isEs_objeto()) {
                                if (columna.getTipo().toLowerCase().equals(exp.nombre)) {
                                    objeto obj = exp.objeto;
                                    for (int j = 0; j < obj.lista_variable.size(); j++) {
                                        vab = obj.lista_variable.get(j);
                                        expresion exp2 = (expresion) vab.valor;
                                        ro = new registro_objeto(vab.tipo, exp2.cadena);
                                        lro.add(ro);
                                    }
                                    fto = new fila_tabla_objeto(0, lro);
                                    columna.addRegistroObjeto(fto);
                                    lro = new ArrayList<registro_objeto>();
                                } else {
                                    object obj = rob.retornoObjeto(memoria.use_db, columna.getTipo().toLowerCase());
                                    if (obj != null) {
                                        for (int j = 0; j < obj.getAtributo().size(); j++) {
                                            String tipo = obj.getAtributo().get(j).getTipo();
                                            ro = new registro_objeto(tipo, "NULL");
                                            lro.add(ro);
                                        }
                                        fto = new fila_tabla_objeto(0, lro);
                                        columna.addRegistroObjeto(fto);
                                        lro = new ArrayList<registro_objeto>();
                                    }
                                    //TIPO DE DATOS NO COINCIDEN
                                }
                            } else {
                                if (columna.getTipo().equals(exp.tipo)) {
                                    if (columna.getAutoincrementable().equals("Y")) {
                                        ft = new fila_tabla(0, String.valueOf(data.getContador()));
                                        columna.addRegistro(ft);
                                    } else {
                                        ft = new fila_tabla(0, exp.cadena);
                                        columna.addRegistro(ft);
                                    }

                                } else {
                                    if (columna.getAutoincrementable().equals("Y")) {
                                        ft = new fila_tabla(0, String.valueOf(data.getContador()));
                                        columna.addRegistro(ft);
                                    } else {
                                        ft = new fila_tabla(0, "NULL");
                                        columna.addRegistro(ft);
                                    }
                                    //TIPO DE DATOS NO COINCIDEN 
                                }
                            }

                        } else {//NO EXISTE TABLA
                        }
                    }
                    filasEquitativas();
                } else {
                    //VALUES NO COINCIDEN EN CANTIDAD CON EXPRESIONES
                }
            }
        } else {
            //NO EXISTE DB EN BASE DE DATOS
        }

        escritura.Escribir();
    }

    private void filasEquitativas() {
        String nombre = "";
        table columna;
        fila_tabla ft;
        fila_tabla_objeto fto;
        registro_objeto ro;
        ArrayList<registro_objeto> lro = new ArrayList<registro_objeto>();
        database data = rob.retornoTablaData(memoria.use_db, nombre_tabla);
        ArrayList<table> tabla = rob.retornoTabla(memoria.use_db, nombre_tabla);

        for (int i = 0; i < tabla.size(); i++) {
            nombre = tabla.get(i).getNombre_campo();
            if (!existsCampo(nombre)) {
                columna = rob.retorno_Campo_Tabla(memoria.use_db, nombre_tabla, nombre);
                if (columna != null) {
                    if (columna.isEs_objeto()) {
                        object obj = rob.retornoObjeto(memoria.use_db, columna.getTipo().toLowerCase());
                        if (obj != null) {
                            for (int j = 0; j < obj.getAtributo().size(); j++) {
                                String tipo = obj.getAtributo().get(j).getTipo();
                                ro = new registro_objeto(tipo, "NULL");
                                lro.add(ro);
                            }
                            fto = new fila_tabla_objeto(0, lro);
                            columna.addRegistroObjeto(fto);
                            lro = new ArrayList<registro_objeto>();
                        }

                    } else {
                        if (columna.getAutoincrementable().equals("Y")) {
                            ft = new fila_tabla(0, String.valueOf(data.getContador()));
                            columna.addRegistro(ft);
                        } else {
                            ft = new fila_tabla(0, "NULL");
                            columna.addRegistro(ft);
                        }

                    }
                }

            }
        }
    }

    private boolean existsCampo(String nombre) {
        for (int i = 0; i < lista_id.size(); i++) {
            if (lista_id.get(i).equals(nombre)) {
                return true;
            }
        }
        return false;
    }
}
