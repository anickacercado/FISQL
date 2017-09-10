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
public class llamadaTabla {
    String tabla;
    String columna;
    String objeto;
    int fila, col;

    public llamadaTabla(String tabla, String columna, String objeto, int fila, int col) {
        this.tabla = tabla;
        this.columna = columna;
        this.objeto = objeto;
        this.fila = fila;
        this.col = col;
    }   
}
