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
public class tablaMetodo {

    public String nombre_bd;
    public ArrayList<simbolo> lista_metodo = new ArrayList<simbolo>();

    
    public void insertMetodo(simbolo simb){
        metodo tempNuevo= (metodo) simb.valor;
        metodo tempMetodo;
        boolean existe= false;
        for(int i=0; i<lista_metodo.size(); i++){
           tempMetodo = (metodo) lista_metodo.get(i).valor;
           if (tempMetodo.nombre.equals(tempNuevo.nombre)){
               existe=true;
           }
        }
        if (existe==false){
             lista_metodo.add(simb);
        }
    }
    
    
    public tablaMetodo(String nombre_bd, ArrayList<simbolo> metodo) {
        this.nombre_bd = nombre_bd;
        this.lista_metodo = metodo;
    }
   
    public String getNombre_bd() {
        return nombre_bd;
    }

    public void setNombre_bd(String nombre_bd) {
        this.nombre_bd = nombre_bd;
    }

    public ArrayList<simbolo> getMetodo() {
        return lista_metodo;
    }

    public void setMetodo(ArrayList<simbolo> metodo) {
        this.lista_metodo = metodo;
    }

    public metodo returnMetodo(String nombre_metodo) {
        for (int i = 0; i < lista_metodo.size(); i++) {
            metodo met = (metodo) lista_metodo.get(i).valor;
            if (met.nombre.toLowerCase().equals(nombre_metodo)) {
                return met;
            }
        }
        return null;
    }
}
