/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.LecturaBD;
import archivos.db.database;
import archivos.maestro.master;
import archivos.memoria;
import archivos.metodo.function;
import archivos.metodo.procedure;
import consola.principal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usql.analizador;

/**
 *
 * @author anick
 */
public class ejecutar {

    LecturaBD lb = new LecturaBD();
    ArrayList<simbolo> tablaSimbolo;
    
    public ejecutar(){}

    public ejecutar(ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
    }

    public ArrayList<simbolo> getTablaSimbolo() {
        return tablaSimbolo;
    }

    public void setTablaSimbolo(ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
    }
    
    public void ejecucion(){
        EjecucionPasada1();
        EjecucionPasada2();
    }
    
    public void EjecucionPasada1() {
        lb.leer();
        memoriaMetodoProc();
    }

    public void EjecucionPasada2() {
        ejecutarAmbito ejeA = new ejecutarAmbito(tablaSimbolo);
        ejeA.secuenciaEjecucion();
    }

    //Recorrido de Métodos y Funciones Base de Datos
    public void memoriaMetodoProc() {
        memoria.tablaMetodo = new ArrayList<>();
        ArrayList<simbolo> listasimb = new ArrayList<>();
        database tempData;
        master tempMaestro;
        procedure tempProcedure;
        function tempFunction;
        simbolo sim;

        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            tempMaestro = memoria.arbolMaestro.get(i);
            memoria.tablaMetodo.add(new tablaMetodo(tempMaestro.getNombre(), listasimb));

            for (int j = 0; j < tempMaestro.getDatabase().size(); j++) {
                tempData = tempMaestro.getDatabase().get(j);

                if (tempData.getTipo().equals("PROCEDURE")) {
                    for (int k = 0; k < tempData.getProcedure().size(); k++) {

                        tempProcedure = tempData.getProcedure().get(k);
                        analizador g = new analizador(new java.io.StringReader(tempProcedure.getCodigo()));
                        try {
                            sim = g.S().getTablaSimbolo().get(0);
                            //Escribir en Tabla de Metodos
                            memoria.tablaMetodo.get(i).insertMetodo(sim);
                        } catch (usql.ParseException ex) {
                           // Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                } else if (tempData.getTipo().equals("FUNCTION")) {
                    for (int k = 0; k < tempData.getFunction().size(); k++) {

                        tempFunction = tempData.getFunction().get(k);
                        analizador g = new analizador(new java.io.StringReader(tempFunction.getCodigo()));
                        try {
                            sim = g.S().getTablaSimbolo().get(0);
                            //Escribir en Tabla de Metodos
                            memoria.tablaMetodo.get(i).insertMetodo(sim);
                            //g.CREAR_FUNCION();
                        } catch (usql.ParseException ex) {
                            //Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
//              else if (tempData.getTipo().equals("OBJECT")) {
//                    for (int k = 0; k < tempMaestro.getDatabase().size(); k++) {
//                        
//                    }
//                }
            }
        }

    }
}
