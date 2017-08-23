/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.tabla;

import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class table {
    
public String nombre_campo; 
public ArrayList<fila_tabla> registro;
public boolean es_objeto;
public ArrayList<fila_tabla_objeto> registro_objeto;

public table(String nombre_campo, 
 ArrayList<fila_tabla> registro,
 boolean es_objeto,
 
 ArrayList<fila_tabla_objeto> registro_objeto){
    this.nombre_campo=nombre_campo;
    this.registro=registro;
    this.es_objeto=es_objeto;
    this.registro_objeto=registro_objeto;
}
    
}
