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

    public ArrayList<simbolo> tablaSimbolo;
    public ambito padre;
    public String nombre;

    public ambito(String nombre, ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
        this.padre = null;
        this.nombre = nombre;
    }

    public ambito(String nombre) {
        this.nombre = nombre;
        this.tablaSimbolo = new ArrayList<>();
    }

}
