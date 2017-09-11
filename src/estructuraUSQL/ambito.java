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
public class ambito {

    public String nombre;
    public ArrayList<simbolo> tablaSimbolo;
    public ambito padre;
    
    public ambito(String nombre, ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
        this.padre = null;
        this.nombre = nombre;
    }

    public ambito(String nombre) {
        this.nombre = nombre;
        this.tablaSimbolo = new ArrayList<>();
    }

    public ArrayList<simbolo> getTablaSimbolo() {
        return tablaSimbolo;
    }

    public void setTablaSimbolo(ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
    }

    public ambito getPadre() {
        return padre;
    }

    public void setPadre(ambito padre) {
        this.padre = padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
