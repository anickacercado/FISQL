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

    public expresion valor;
    public ambito si;
    public ambito sino;
    public ambito ambito;
    
    public si(expresion valor, ambito si, ambito sino, ambito ambito) {
        this.valor = valor;
        this.si = si;
        this.sino = sino;  
        this.ambito = ambito;
    }

    public expresion getCondicion() {
        return valor;
    }

    public void setCondicion(expresion condicion) {
        this.valor = condicion;
    }

    public ambito getSi() {
        return si;
    }

    public void setSi(ambito si) {
        this.si = si;
    }

    public ambito getSino() {
        return sino;
    }

    public void setSino(ambito sino) {
        this.sino = sino;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }
    
    public void ejecucion() {
        expresion exp = valor.resCondicion();
        if (exp.tipo.equals("BOOL")) {
            if (exp.bool) {
                ejecutarAmbito ea = new ejecutarAmbito(si.tablaSimbolo);
                ea.secuenciaEjecucion();
                ea.popAmbito();

            } else {
                ejecutarAmbito ea = new ejecutarAmbito(sino.tablaSimbolo);
                ea.secuenciaEjecucion();
                ea.popAmbito();
            }
        } else {
            memoria.addError("ERROR SEMANTICO ", "SE ESPERABA EXPRESION BOOL EN SI", exp.fila, exp.columna);
        }
    }

}
