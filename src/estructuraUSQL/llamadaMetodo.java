/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class llamadaMetodo {

    public String nombre;
    public int fila, columna;
    public ArrayList<expresion> parametros = new ArrayList<>();

    public llamadaMetodo(String nombre, ArrayList<expresion> parametros, int fila, int columna) {
        this.nombre = nombre;
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
}
