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
    public ambito ambito;
    public ArrayList<simbolo> parametros;
    public int fila, columna;
    public String tipo, nombre;

    public metodo(String visibilidad, ArrayList<simbolo> parametro, ambito ambito, int fila, int columna, String tipo, String nombre) {
    this.ambito = ambito;
    this.parametros = parametro;
    this.fila = fila;
    this.columna = columna;
    this.tipo = tipo;
    this.nombre = nombre;
    }
    
}
