/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import consola.principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import usql.analizador;

/**
 *
 * @author anick
 */
public class analizar {

    public void iniciarEjecucion() {
        pasada1();
    }

    private String replace(String cadena){
      cadena= cadena.replaceAll("\n", " ");
      cadena= cadena.replaceAll("\r", " ");
      cadena= cadena.replaceAll("\t", " ");
      cadena= cadena.toLowerCase();
      return cadena;
    }
    
    private void pasada1() {
        memoria.cod_client_sin_saltos=replace(memoria.cod_client_sin_saltos);
        analizador g = new analizador(new java.io.StringReader(memoria.cod_client_sin_saltos));
        try {
            g.S().ejecucion();
        } catch (usql.ParseException ex) {
            memoria.addError("ERROR DEFINICION", ex.getMessage(), 0, 0);
            System.out.println(ex.getMessage());
        }
    }

}
