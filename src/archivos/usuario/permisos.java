/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.usuario;

import java.util.ArrayList;


/**
 *
 * @author anick
 */
public class permisos {
    
    public String nombre_bd;
    public ArrayList<String> table;
    public ArrayList<String> object;
    public ArrayList<String> function;
    public ArrayList<String> procedure;
    
    public permisos(String nombre_bd, ArrayList<String> table, ArrayList<String> object, ArrayList<String> function, ArrayList<String> procedure)
    {
        this.nombre_bd = nombre_bd;
        this.table = table;
        this.object = object;
        this.function = function;
        this.procedure = procedure;
    }
}
