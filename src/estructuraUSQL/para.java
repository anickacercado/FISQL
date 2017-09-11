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
public class para {

    public simbolo declara;
    public String DecreAum;
    public expresion valor;
    public ambito ambito;

    public para(simbolo inicio, String DecreAum, expresion valor, ambito ambito) {
        this.declara = inicio;
        this.DecreAum = DecreAum;
        this.valor = valor;
        this.ambito = ambito;
    }

    public simbolo getDeclara() {
        return declara;
    }

    public void setDeclara(simbolo declara) {
        this.declara = declara;
    }

    public String getDecreAum() {
        return DecreAum;
    }

    public void setDecreAum(String DecreAum) {
        this.DecreAum = DecreAum;
    }

    public expresion getCondicion() {
        return valor;
    }

    public void setCondicion(expresion condicion) {
        this.valor = condicion;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }

    public void ejecucion() {

        tablaVariable tabla = new tablaVariable();
        variable vab;
        declaracion decla = (declaracion) declara.valor;
        decla.ejecucion();
        ejecutarAmbito ea = new ejecutarAmbito(ambito.tablaSimbolo);
        expresion exp = valor.resCondicion();

        if (exp.tipo.equals("BOOL")) {
            while (exp.bool && memoria.DETENER == false) {
                ea.secuenciaEjecucion();
                /*Variable cambia durante la ejecución de la lista simbolos
                * Se resuelve de nuevo la expresion
                 */
                if (DecreAum.equals("++")) {
                    vab = tabla.retornaVariable(decla.nombre);
                    expresion temp = (expresion) vab.valor;
                    temp.entero = temp.entero + 1;
                    temp.decimal = temp.entero + 1;
                    temp.cadena = String.valueOf(temp.entero);
                } else if (DecreAum.equals("--")) {
                    vab = tabla.retornaVariable(decla.nombre);
                    expresion temp = (expresion) vab.valor;
                    temp.entero = temp.entero - 1;
                    temp.decimal = temp.entero - 1;
                    temp.cadena = String.valueOf(temp.entero);
                }
                exp = valor.resCondicion();
                ea.popAmbito();
            }
            memoria.DETENER = false;
            tabla.popVariable(decla.nombre);
        } else {
            memoria.addError("ERROR SEMANTICO", "SE ESPERABA CONDICION BOOL EN MIENTRAS", exp.fila, exp.columna);
        }
    }
}
