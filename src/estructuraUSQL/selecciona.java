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

    public expresion valor;
    public ArrayList<caso> lista_caso;
    public caso defecto;
    public ambito ambito;
    
    public selecciona(expresion valor, ArrayList<caso> casos, caso defecto, ambito ambito) {
        this.valor = valor;
        this.lista_caso = casos;
        this.defecto = defecto;
        this.ambito = ambito;     
    }
    
    public expresion getCondicion() {
        return valor;
    }

    public void setCondicion(expresion condicion) {
        this.valor = condicion;
    }

    public ArrayList<caso> getLista_caso() {
        return lista_caso;
    }

    public void setLista_caso(ArrayList<caso> lista_caso) {
        this.lista_caso = lista_caso;
    }

    public caso getDefecto() {
        return defecto;
    }

    public void setDefecto(caso defecto) {
        this.defecto = defecto;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }
    
      public void ejecucion() {
        expresion expGlobal = valor.resCondicion();
        pilaVariable tabla = new pilaVariable();
        ejecutarAmbito ea;
        boolean coincidencia = false;
        for (int i = 0; i < lista_caso.size(); i++) {
            if (memoria.DETENER==false) {
                expresion expCase = lista_caso.get(i).valor.resCondicion();
                if (expGlobal.tipo.equals(expCase.tipo)) {
                    switch (expGlobal.tipo) {
                        case "ENTERO":
                            if (expGlobal.entero == expCase.entero) {
                                ea = new ejecutarAmbito(lista_caso.get(i).ambito.tablaSimbolo);
                                ea.secuenciaEjecucion();
                                ea.popAmbito();
                                coincidencia = true;
                            }
                            break;
                        case "DOUBLE":
                            if (expGlobal.decimal == expCase.decimal) {
                                ea = new ejecutarAmbito(lista_caso.get(i).ambito.tablaSimbolo);
                                ea.secuenciaEjecucion();
                                ea.popAmbito();
                                coincidencia = true;
                            }
                            break;
                        case "CADENA":
                            if (expGlobal.cadena.equals(expCase.cadena)) {
                                ea = new ejecutarAmbito(lista_caso.get(i).ambito.tablaSimbolo);
                                ea.secuenciaEjecucion();
                                ea.popAmbito();
                                coincidencia = true;
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                    memoria.addError("ERROR SEMANTICO ", "NO COINCIDEN TIPOS CASE " + expGlobal.tipo + " CON " + expCase.tipo, expCase.fila, expCase.columna);
                }

            }
        }
        if (coincidencia == false) {
            ea = new ejecutarAmbito(defecto.ambito.tablaSimbolo);
            ea.secuenciaEjecucion();
            ea.popAmbito();
        }
        memoria.DETENER = false;
    }
}
