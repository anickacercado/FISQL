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
public class metodo {

    public ArrayList<simbolo> parametros;
    public ambito ambito;
    public int fila;
    public int columna;
    public String tipo;
    public String nombre;

    public metodo(ArrayList<simbolo> parametros, ambito ambito, int fila, int columna, String tipo, String nombre) {
        this.parametros = parametros;
        this.ambito = ambito;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }

    public ArrayList<simbolo> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<simbolo> parametros) {
        this.parametros = parametros;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
