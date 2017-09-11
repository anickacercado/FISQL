/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;

/**
 *
 * @author anick
 */
public class mientras {

    public ambito ambito;
    public expresion valor;

    public mientras(ambito ambito, expresion valor) {
        this.ambito = ambito;
        this.valor = valor;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }

    public expresion getCondicion() {
        return valor;
    }

    public void setCondicion(expresion condicion) {
        this.valor = condicion;
    }

    public void ejecucion() {
        expresion exp = valor.resCondicion();
        tablaVariable tabla = new tablaVariable();
        ejecutarAmbito ea = new ejecutarAmbito(ambito.tablaSimbolo);
        if (exp.tipo.equals("BOOL")) {
            while (exp.bool && memoria.DETENER == false) {
                ea.secuenciaEjecucion();

                /* Variable cambia durante la ejecución de la lista simbolos
                *  Se resuelve de nuevo la expresion
                 */
                exp = valor.resCondicion();
                ea.popAmbito();
            }
            memoria.DETENER = false;
        } else {
            memoria.addError("ERROR SEMANTICO", "SE ESPERABA CONDICION BOOL EN MIENTRAS", exp.fila, exp.columna);
        }
    }
}
