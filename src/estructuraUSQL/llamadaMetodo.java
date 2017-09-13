/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class llamadaMetodo {

    public String nombre;
    public ArrayList<expresion> parametros = new ArrayList<>();
    public int fila;
    public int columna;

    public llamadaMetodo(String nombre, ArrayList<expresion> parametros, int fila, int columna) {
        this.nombre = nombre.toLowerCase();
        this.parametros = parametros;
        this.fila = fila;
        this.columna = columna;
    }

    public void insertarParametro(expresion parametro) {
        parametros.add(parametro);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public ArrayList<expresion> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<expresion> parametros) {
        this.parametros = parametros;
    }

    public expresion ejecucion() {
        pilaVariable tabla = new pilaVariable();
        boolean existMetodo = false;
        boolean existBase = false;
        boolean tipoDato = false;
        int contPop = 0;
        for (int i = 0; i < memoria.tablaMetodo.size(); i++) {
            if (memoria.tablaMetodo.get(i).nombre_bd.equals(memoria.use_db)) {
                existBase = true;
                metodo tempMetodo = memoria.tablaMetodo.get(i).returnMetodo(nombre);
                if (tempMetodo != null) {
                    existMetodo = true;
                    if (tempMetodo.parametros.size() == parametros.size()) {
                        for (int j = 0; j < tempMetodo.parametros.size(); j++) {
                            expresion exp = parametros.get(j).resCondicion();
                            
                            declaracion tempDecla = (declaracion) tempMetodo.parametros.get(j).valor;
                            if (tempDecla.tipo.equals(exp.tipo)) {
                                tempDecla.valor = exp;
                                tempDecla.ejecucion();
                                contPop++;
                            } else {
                                tipoDato = true;
                                memoria.addError("ERROR SEMANTICO ", "TIPO DE DATOS NO COINCIDEN DE METODO " + nombre, fila, columna);
                            }
                        }
                        if (tipoDato == false) {
                            ejecutarAmbito ea = new ejecutarAmbito(tempMetodo.ambito.tablaSimbolo);
                            ea.secuenciaEjecucion();                            
                                                        
                            if(memoria.RETORNA==true){
                                expresion aux= (expresion) tabla.retornaVariable("RETORNO").valor;
                                tabla.popVariable();
                                memoria.RETORNA=false;
                                return aux;
                            }
                            
                            ea.popAmbito();
                        }
                        for (int k = 0; k < contPop; k++) {
                            tabla.popVariable();
                        }
                    } else {
                        memoria.addError("ERROR SEMANTICO ", "NO COINCIDEN PARAMETROS DE METODO " + nombre, fila, columna);
                    }
                }
            }
        }
        if (existBase == false) {
            memoria.addError("ERROR BD ", "No existe BD " + memoria.use_db, fila, columna);
        }
        if (existMetodo == false) {
            {
                memoria.addError("ERROR BD ", "No existe Metodo " + nombre, fila, columna);
            }
        }
        memoria.RETORNA=false;
        return null;
    }
}
