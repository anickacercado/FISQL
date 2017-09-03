/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDL;

import archivos.EscrituraBD;
import archivos.LecturaEscritura;
import archivos.db.database;
import archivos.db.propertyField;
import archivos.maestro.master;
import archivos.memoria;
import archivos.metodo.function;
import archivos.metodo.procedure;
import archivos.objeto.object;
import archivos.parametro;
import archivos.tabla.fila_tabla;
import archivos.tabla.fila_tabla_objeto;
import archivos.tabla.table;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class create {

    LecturaEscritura le = new LecturaEscritura();
    EscrituraBD escritura = new EscrituraBD();
    ArrayList<master> maes;

    public void crearBD(String nombre) {
        if (ExisteBD(nombre) == false) {
            String pathDB = memoria.DB + "\\" + nombre + "\\DB.xml";
            String pathProcedure = memoria.DB + "\\" + nombre + "\\procedure.xml";
            String pathFunction = memoria.DB + "\\" + nombre + "\\function.xml";
            String pathObject = memoria.DB + "\\" + nombre + "\\object.xml";

            ArrayList<function> func = new ArrayList<function>();
            ArrayList<procedure> proc = new ArrayList<procedure>();
            ArrayList<object> obj = new ArrayList<object>();
            database dpro = new database("PROCEDURE", null, pathProcedure, func, null, null, null);
            database dfun = new database("FUNCTION", null, pathFunction,  null, proc, null, null);
            database dobj = new database("OBJECT", null, pathObject, null, null, obj, null);
            ArrayList<database> adb = new ArrayList<database>();
            adb.add(dpro);
            adb.add(dfun);
            adb.add(dobj);
            master m = new master(nombre, pathDB, adb);
            memoria.arbolMaestro.add(m);
            escritura.Escribir();
        }
        maes = memoria.arbolMaestro;
    }

    public void CrearObjeto(String nombre_bd, String nombre_obj, ArrayList<parametro> para) {
        Boolean existeObj = false;
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
                                existeObj = true;
                            }
                        }
                        if (existeObj == false) {
                            object o = new object(nombre_obj, para);
                            tempObject.add(o);
                        }
                        tempData.get(j).setObject(tempObject);
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
                escritura.Escribir();
            }
        }
        maes = memoria.arbolMaestro;
    }

    public void CrearProc(String nombre_bd, String nombre_proc, ArrayList<parametro> para, String codigo) {
        Boolean existeProc = false;
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<procedure> tempProc = new ArrayList<procedure>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                tempData = memoria.arbolMaestro.get(i).getDatabase();
                for (int j = 0; j < tempData.size(); j++) {
                    if (tempData.get(j).getTipo().equals("PROCEDURE")) {
                        tempProc = tempData.get(j).getProcedure();
                        for (int k = 0; k < tempProc.size(); k++) {
                            if (tempProc.get(k).getNombre().equals(nombre_proc)) {
                                existeProc = true;
                            }
                        }
                        if (existeProc == false) {
                            procedure p = new procedure(nombre_proc, para, codigo);
                            tempProc.add(p);
                        }
                        tempData.get(j).setProcedure(tempProc);
                    }
                }
                memoria.arbolMaestro.get(i).setDatabase(tempData);
                escritura.Escribir();
            }
        }
        maes = memoria.arbolMaestro;
    }

    public void CrearFunc(String nombre_bd, String nombre_func, ArrayList<parametro> para, String codigo, String retorno) {
        Boolean existeFunc = false;
        ArrayList<database> tempData = new ArrayList<database>();
        ArrayList<function> tempFunc = new ArrayList<function>();
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            tempData = memoria.arbolMaestro.get(i).getDatabase();
            for (int j = 0; j < tempData.size(); j++) {
                if (tempData.get(j).getTipo().equals("FUNCTION")) {
                    tempFunc = tempData.get(j).getFunction();
                    for (int k = 0; k < tempFunc.size(); k++) {
                        if (tempFunc.get(k).getNombre().equals(nombre_func)) {
                            existeFunc = true;
                        }
                    }
                    if (existeFunc == false) {
                        function p = new function(nombre_func, para, codigo, retorno);
                        tempFunc.add(p);
                    }
                    tempData.get(j).setFunction(tempFunc);
                }
            }
            memoria.arbolMaestro.get(i).setDatabase(tempData);
            escritura.Escribir();
        }
        maes = memoria.arbolMaestro;
    }

    public void CrearTable(String nombre_bd, String nombre_table, ArrayList<table> ta) {
        Boolean existeTable = false;
        ArrayList<database> tempData = new ArrayList<database>();

        if (memoria.arbolMaestro != null) {
            for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
                if (memoria.arbolMaestro.get(i).getNombre().equals(nombre_bd)) {
                    tempData = memoria.arbolMaestro.get(i).getDatabase();
                    for (int j = 0; j < tempData.size(); j++) {
                        if (tempData.get(j).getTipo().equals("TABLE")) {
                            if (tempData.get(j).getNombre().equals(nombre_table)) {
                                existeTable = true;
                            }
                        }
                    }
                    if (existeTable == false) {
                        String path = memoria.DB + "\\" + nombre_bd + "\\" + nombre_table + ".xml";
                        database data = new database("TABLE", nombre_table, path, null, null, null, ta);
                        memoria.arbolMaestro.get(i).insertDataBase(data);
                        escritura.Escribir();
                    }
                }
            }
        }
        maes = memoria.arbolMaestro;
    }

    public void insertColumn(ArrayList<table> lt, String nombre, String tipo, String nulo, String no_nulo, String autoincrementable, String llave_primaria, String llave_foranea) {

        boolean existe = false;
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getNombre_campo().equals(nombre)) {
                existe = true;
            }
        }

        if (existe == false) {
            if (tipo.equals("INTEGER")
                    || tipo.equals("TEXT")
                    || tipo.equals("DOUBLE")
                    || tipo.equals("BOOL")
                    || tipo.equals("DATE")
                    || tipo.equals("DATETIME")) {
   
                ArrayList<fila_tabla> registro = new ArrayList<fila_tabla>();
                table ta= new table(nombre,tipo,nulo,no_nulo,autoincrementable,llave_primaria,llave_foranea,registro,false,null);
                lt.add(ta);
            }
            
            else{
                ArrayList<fila_tabla_objeto> registro_objeto = new ArrayList<fila_tabla_objeto>();
                table ta= new table(nombre,tipo,nulo,no_nulo,autoincrementable,llave_primaria,llave_foranea,null,true,registro_objeto);
                lt.add(ta);
            }

        } else {
            System.out.println("Ya existe campo en tabla");
        }
    }

    public void insertParametro(ArrayList<parametro> lp, String nombre, String tipo) {
        boolean existe = false;
        for (int i = 0; i < lp.size(); i++) {
            if (lp.get(i).getNombre().equals(nombre)) {
                existe = true;
            }
        }
        if (existe == false) {
            parametro p = new parametro(nombre, tipo);
            lp.add(p);
        } else {
            System.out.println("Ya existe parametro");
        }
    }

    private boolean ExisteBD(String nombre) {
        if (memoria.arbolMaestro != null) {
            for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
                if (memoria.arbolMaestro.get(i).getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }
}