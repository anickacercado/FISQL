/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class si {

    public ambito si;
    public ambito sino;
    public ambito ambito;
    public expresion condicion;

    public si(expresion condicion, ambito si, ambito sino, ambito ambito) {
        this.si = si;
        this.sino = sino;
        this.condicion = condicion;
        this.ambito = ambito;
    }

    public void ejecucion() {
        expresion exp = condicion.ResolverExpresion();
        if (exp.Tipo.equals("BOOL")) {
            if (exp.Bool) {
                ejecutarAmbito ea = new ejecutarAmbito(si.tablaSimbolo);
                ea.secuenciaEjecucion();
                ea.popAmbito();

            } else {
                ejecutarAmbito ea = new ejecutarAmbito(sino.tablaSimbolo);
                ea.secuenciaEjecucion();
                ea.popAmbito();
            }
        } else {
            memoria.addError("ERROR SEMANTICO ", "SE ESPERABA EXPRESION BOOL EN SI", exp.Fila, exp.Columna);
        }
    }
}
