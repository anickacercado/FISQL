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
public class fila_tabla_objeto {
    public int no_fila;
    public ArrayList<registro_objeto> registro;
    
    public fila_tabla_objeto( int no_fila, ArrayList<registro_objeto> registro){
     this.no_fila= no_fila;
     this.registro= registro;
    }
    
}
