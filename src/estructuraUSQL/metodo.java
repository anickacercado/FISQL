/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import DDL.create;
import archivos.memoria;
import archivos.parametro;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class metodo {

    ejecutar eje = new ejecutar();
    create cre = new create();
    public ArrayList<simbolo> parametros;
    public ambito ambito;
    public int fila;
    public int columna;
    public String tipo;
    public String nombre;
    public int iniMetodo;
    public int finMetodo;

    public metodo(ArrayList<simbolo> parametros, ambito ambito, int fila, int columna, String tipo, String nombre, int iniMetodo, int finMetodo) {
        this.parametros = parametros;
        this.ambito = ambito;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
        this.nombre = nombre.toLowerCase();
        this.iniMetodo = iniMetodo;
        this.finMetodo = finMetodo;
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

    public String codigo() {
        String cadena = "";
        cadena = memoria.cod_client_sin_saltos.substring(this.iniMetodo, this.finMetodo);
        return cadena;
    }

    public ArrayList<parametro> lista_para() {
        ArrayList<parametro> para = new ArrayList<parametro>();
        for (int i = 0; i < parametros.size(); i++) {
            declaracion decla = (declaracion) parametros.get(i).valor;
            cre.insertParametro(para, decla.nombre, decla.tipo);
        }
        return para;
    }

    public void ejecucion() {
        if (tipo.equals("PROCEDURE")) {
            cre.CrearProc(memoria.use_db, this.nombre, lista_para(), codigo());
        } else {
            cre.CrearFunc(memoria.use_db, this.nombre, lista_para(), codigo(), this.tipo);
        }
        eje.EjecucionPasada1();
    }
}
