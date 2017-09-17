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
public class tabla {
    
    public String nombre;
    public String objeto;
    public String atributo;
    public ArrayList<expresion> expresion;
    ambito ambito;

    public tabla(String nombre, String objeto, String atributo, ArrayList<expresion> expresion, ambito ambito) {
        this.nombre = nombre;
        this.objeto = objeto;
        this.atributo = atributo;
        this.expresion = expresion;
        this.ambito = ambito;
    }
    
    

    public ArrayList<expresion> getExpresion() {
        return expresion;
    }

    public void setExpresion(ArrayList<expresion> expresion) {
        this.expresion = expresion;
    }
    
    
    public void ejecucion(){

    }      
}
