/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

/**
 *
 * @author anick
 */
public class simbolo {
    
    public int fila;
    public int columna;
    public String nombre;
    public String rol;
    public String tipo;
    public ambito ambito;
    public Object valor;


    public simbolo(int fila, int columna, String nombre, String rol, String tipo, ambito ambito, Object valor) {
        this.fila = fila;
        this.columna = columna;
        this.nombre = nombre;
        this.rol = rol;
        this.tipo = tipo;
        this.ambito = ambito;
        this.valor = valor;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }    
}
