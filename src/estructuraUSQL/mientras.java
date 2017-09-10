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
    public expresion condicion;

    public mientras(ambito ambito, expresion condicion) {
        this.ambito = ambito;
        this.condicion = condicion;
    }

    public void ejecucion() {
        expresion exp = condicion.ResolverExpresion();
        tablaUSQL tabla = new tablaUSQL();
        ejecutarAmbito ea = new ejecutarAmbito(ambito.tablaSimbolo);
        if (exp.Tipo.equals("BOOL")) {
            while (exp.Bool) {
                ea.secuenciaEjecucion();
                /* Variable cambia durante la ejecución de la lista simbolos
                *  Se resuelve de nuevo la expresion
                 */
                if (tabla.encontrarDetener()) {
                    break;
                }

                exp = condicion.ResolverExpresion();
                ea.popAmbito();
            }
            if (tabla.encontrarDetener()) {
                tabla.popVariable();
                ea.popAmbito();
            }
        } else {
            memoria.addError("ERROR SEMANTICO", "SE ESPERABA CONDICION BOOL EN MIENTRAS", exp.Fila, exp.Columna);
        }
    }
}
