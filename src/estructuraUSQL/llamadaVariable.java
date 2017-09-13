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
public class llamadaVariable {

    public String nombre;
    public String objeto;
    public int fila;
    public int columna;

    public llamadaVariable(String nombre, String objeto, int fila, int columna) {
        this.nombre = nombre.toLowerCase();
        this.objeto = objeto;
        this.fila = fila;
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
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
    
     public variable ejecucion() {
        pilaVariable tUSQL = new pilaVariable();
        variable vab = tUSQL.retornaVariable(nombre);
        if (vab != null) {
            {
                if (vab.valor != null) {
                    return vab;
                }
            }
        }
        return vab;
    }
}
