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
public class objeto {
    
    public ArrayList<variable>  lista_variable = new ArrayList<variable>();
    public String nombre;

    public objeto(ArrayList<variable>  lista_variable, String nombre) {
        this.lista_variable = lista_variable;
        this.nombre = nombre;
    }

    public ArrayList<variable> getLista_variable() {
        return lista_variable;
    }

    public void setLista_variable(ArrayList<variable> lista_variable) {
        this.lista_variable = lista_variable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
}
