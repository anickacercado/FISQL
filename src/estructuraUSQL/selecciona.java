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
public class selecciona {

    public ArrayList<caso> lista_caso;
    public ambito ambito;
    public caso defecto;
    public expresion condicion;

    public selecciona(expresion condicion, ArrayList<caso> casos, caso defecto, ambito ambito) {
        this.lista_caso = casos;
        this.defecto = defecto;
        this.ambito = ambito;
        this.condicion = condicion;
    }

    public void ejecucion() {
        expresion expGlobal = condicion.ResolverExpresion();
        tablaUSQL tabla = new tablaUSQL();
        ejecutarAmbito ea;
        boolean coincidencia = false;
        for (int i = 0; i < lista_caso.size(); i++) {
            if (coincidencia == false) {
                expresion expCase = lista_caso.get(i).valor.ResolverExpresion();
                if (expGlobal.Tipo.equals(expCase.Tipo)) {
                    switch (expGlobal.Tipo) {
                        case "ENTERO":
                            if (expGlobal.Entero == expCase.Entero) {
                                ea = new ejecutarAmbito(lista_caso.get(i).ambito.tablaSimbolo);
                                ea.secuenciaEjecucion();
                                if (tabla.encontrarDetener()) {
                                    tabla.popVariable();
                                    ea.popAmbito();
                                    break;
                                }
                                ea.popAmbito();
                                coincidencia = true;
                            }
                            break;
                        case "DOUBLE":
                            if (expGlobal.Decimal == expCase.Decimal) {
                                ea = new ejecutarAmbito(lista_caso.get(i).ambito.tablaSimbolo);
                                ea.secuenciaEjecucion();
                                if (tabla.encontrarDetener()) {
                                    tabla.popVariable();
                                    ea.popAmbito();
                                    break;
                                }
                                ea.popAmbito();
                                coincidencia = true;
                            }
                            break;
                        case "CADENA":
                            if (expGlobal.Cadena.equals(expCase.Cadena)) {
                                ea = new ejecutarAmbito(lista_caso.get(i).ambito.tablaSimbolo);
                                ea.secuenciaEjecucion();
                                if (tabla.encontrarDetener()) {
                                    tabla.popVariable();
                                    ea.popAmbito();
                                    break;
                                }
                                ea.popAmbito();
                                coincidencia = true;
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                   memoria.addError("ERROR SEMANTICO ", "NO COINCIDEN TIPOS CASE " + expGlobal.Tipo + " CON "+ expCase.Tipo , expCase.Fila, expCase.Columna);
                }

            }
        }
        if (coincidencia == false) {
            ea = new ejecutarAmbito(defecto.ambito.tablaSimbolo);
            ea.secuenciaEjecucion();
            ea.popAmbito();
            if (tabla.encontrarDetener()) {
                tabla.popVariable();
            }
        }
    }
}
