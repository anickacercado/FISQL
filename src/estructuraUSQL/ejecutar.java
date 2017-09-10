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
public class ejecutar {
    ArrayList<simbolo> tablaSimbolo;

    public ejecutar(ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
    }
    
    public void ejecucion(){
        ejecutarAmbito ejeA = new ejecutarAmbito(tablaSimbolo);
        ejeA.secuenciaEjecucion();
    }   
}
