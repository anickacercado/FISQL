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
    public expresion condicion;
    public ambito ambito;

    public para(simbolo inicio, String DecreAum, expresion condicion, ambito ambito) {
        this.declara = inicio;
        this.DecreAum = DecreAum;
        this.condicion = condicion;
        this.ambito = ambito;
    }

    public void ejecucion() {
        
        tablaUSQL tabla = new tablaUSQL();
        variable vab;
        declaracion decla = (declaracion) declara.valor;
        decla.ejecucion();
        ejecutarAmbito ea = new ejecutarAmbito(ambito.tablaSimbolo);
        expresion exp = condicion.ResolverExpresion();


        if (exp.Tipo.equals("BOOL")) {
            while (exp.Bool) {
                ea.secuenciaEjecucion();
                
                if (tabla.encontrarDetener()) {
                    break;
                }
                /*Variable cambia durante la ejecución de la lista simbolos
                * Se resuelve de nuevo la expresion
                 */
                if (DecreAum.equals("++")) {
                    vab = tabla.retornaVariable(decla.nombre);
                    expresion temp = (expresion) vab.valor;
                    temp.Entero = temp.Entero + 1;
                    temp.Decimal = temp.Entero + 1;
                    temp.Cadena = String.valueOf(temp.Entero);
                } else if (DecreAum.equals("--")) {
                    vab = tabla.retornaVariable(decla.nombre);
                    expresion temp = (expresion) vab.valor;
                    temp.Entero = temp.Entero - 1;
                    temp.Decimal = temp.Entero - 1;
                    temp.Cadena = String.valueOf(temp.Entero);
                }
                exp = condicion.ResolverExpresion();
                ea.popAmbito();
            }
            if(tabla.encontrarDetener()){
                tabla.popVariable();
                ea.popAmbito();
            }
            tabla.popVariable(decla.nombre);
        } else {
            memoria.addError("ERROR SEMANTICO", "SE ESPERABA CONDICION BOOL EN MIENTRAS", exp.Fila, exp.Columna);
        }
    }
}
