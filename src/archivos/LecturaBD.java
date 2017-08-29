/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import archivos.db.database;
import archivos.maestro.master;
import archivos.metodo.function;
import archivos.metodo.procedure;
import archivos.objeto.object;
import archivos.tabla.table;
import archivos.usuario.user;
import consola.principal;
import java.io.File;
import xml.maestro.maestro;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.db.ParseException;
import xml.db.db;
import xml.funcion.funcion;
import xml.metodo.metodo;
import xml.objeto.objeto;
import xml.tabla.tabla;
import xml.usuario.usuario;

/**
 *
 * @author anick
 */
public class LecturaBD {

    LecturaEscritura le = new LecturaEscritura();
    ArrayList<user> arbolUsuario;
    ArrayList<master> arbolMaestro;
    ArrayList<database> arbolDataBase;
    ArrayList<procedure> arbolProcedure;
    ArrayList<function> arbolFunction;
    ArrayList<object> arbolObject;
    ArrayList<table> arbolTable;

    public LecturaBD() {
        File DB = new File(memoria.DB);
        if (!DB.exists()) {
            crearEstructura(DB);
        } else {
            leerUser();
            leerMaestro();
        }
    }

    private void crearEstructura(File DB) {
        if (DB.mkdirs()) {

            /*Crea Archivo Maestro*/
            le.Crear(memoria.maestro);


            /*Crea Archivo User*/
            String cadena = "<usr>\n"
                    + "	<nombre>\"admin\"</nombre>\n"
                    + "	<pass>\"admin\"</pass>\n"
                    + "	<tipo>\"admin\"</tipo>\n"
                    + "	<estado>\"inactivo\"</estado>\n"
                    + "	<permiso>		\n"
                    + "	</permiso>\n"
                    + "</usr>";
            le.Crear_Escritura(memoria.user, cadena);
        }
    }

   private void nuevoObjetoBD(){
    arbolProcedure= new ArrayList<procedure>() ;
    arbolFunction= new ArrayList<function>() ;
    arbolObject= new ArrayList<object>();
    arbolTable= new ArrayList<table>();
   }
   
    private void leerUser(){
       String cadenaUser = le.lectura(memoria.user);
        if (cadenaUser != "NO") {
            usuario gu = new usuario(new java.io.StringReader(cadenaUser));
            try {
                memoria.arbolUsuario = gu.S();
            } catch (xml.usuario.ParseException ex) {
               Logger.getLogger(LecturaBD.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        arbolUsuario= memoria.arbolUsuario;
    }
    
    private void leerMaestro() {
        String cadenaMaestro = le.lectura(memoria.maestro);
        if (cadenaMaestro != "NO") {
            maestro gm = new maestro(new java.io.StringReader(cadenaMaestro));
            try {
                memoria.arbolMaestro = gm.S();
                leerRegistroBD();
            } catch (xml.maestro.ParseException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        arbolMaestro= memoria.arbolMaestro;
    }

    private void leerRegistroBD() {
        String path = "";
        String cadenaDB = "";
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {

            path = memoria.arbolMaestro.get(i).getPath();
            cadenaDB = le.lectura(path);

            if (cadenaDB != "NO") {
                db gd = new db(new java.io.StringReader(cadenaDB));
                try {
                    arbolDataBase = gd.S();
                    leerTipo(arbolDataBase);
                    memoria.arbolMaestro.get(i).setDatabase(arbolDataBase);

                } catch (ParseException ex) {
                    Logger.getLogger(LecturaBD.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        arbolMaestro = memoria.arbolMaestro;
    }

    private void leerTipo(ArrayList<database> adb) {
        String path;
        String cadena;

        for (int i = 0; i < adb.size(); i++) {
            path = adb.get(i).getPath();
            cadena = le.lectura(path);

            if (cadena != "NO") {
                if (adb.get(i).getTipo().equals("PROCEDURE")) {
                    metodo gm = new metodo(new java.io.StringReader(cadena));
                    try {
                        arbolProcedure = gm.S();
                        adb.get(i).setProcedure(arbolProcedure);
                    } catch (xml.metodo.ParseException ex) {
                        Logger.getLogger(LecturaBD.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (adb.get(i).getTipo().equals("FUNCTION")) {
                    funcion gf = new funcion(new java.io.StringReader(cadena));
                    try {
                        arbolFunction = gf.S();
                        adb.get(i).setFunction(arbolFunction);
                    } catch (xml.funcion.ParseException ex) {
                        Logger.getLogger(LecturaBD.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (adb.get(i).getTipo().equals("OBJECT")) {
                    objeto go = new objeto(new java.io.StringReader(cadena));
                    try {
                        arbolObject = go.S();
                        adb.get(i).setObject(arbolObject);
                    } catch (xml.objeto.ParseException ex) {
                        Logger.getLogger(LecturaBD.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (adb.get(i).getTipo().equals("TABLE")) {
                    tabla gt = new tabla(new java.io.StringReader(cadena));
                    try {
                        arbolTable = gt.S();
                        adb.get(i).setTable(arbolTable);
                    } catch (xml.tabla.ParseException ex) {
                        Logger.getLogger(LecturaBD.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        nuevoObjetoBD();
    }
}
