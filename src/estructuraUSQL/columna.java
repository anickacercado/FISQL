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
public class columna {
    
    public String tabla;
    public String objeto;
    public String atributo;
    public String tipo;
    public ArrayList<expresion> exp;

    public columna(String tabla, String objeto, String atributo, String tipo, ArrayList<expresion> exp) {
        this.tabla = tabla;
        this.objeto = objeto;
        this.atributo = atributo;
        this.tipo = tipo;
        this.exp = exp;
    } 
}
