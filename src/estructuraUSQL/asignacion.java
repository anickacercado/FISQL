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
public class asignacion {

    public ambito ambito;
    public ambito padre;
    public llamadaVariable retornaVariable;
    public expresion valor;

    public asignacion(llamadaVariable retornaVariable, ambito ambito, Object valor) {
        this.ambito = ambito;
        this.padre = null;
        this.retornaVariable = retornaVariable;
        this.valor = (expresion) valor;
    }

    public void ejecucion() {
        variable vab;
        if (valor != null) {
            expresion exp = valor;
            exp = exp.ResolverExpresion();

            vab = retornaVariable.ejecucion();
            if (vab != null) {
                if (exp != null) {
                    switch (vab.tipo) {
                        case "ENTERO":
                            if (exp.Tipo.equals("ENTERO")) {
                            } else if (exp.Tipo.equals("BOOL")) {
                                exp.Tipo = "ENTERO";
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.Tipo, exp.Fila, exp.Columna);
                            }
                            break;
                        case "CADENA":
                            if (exp.Tipo.equals("CADENA")) {
                            } else if (exp.Tipo.equals("ENTERO")) {
                                exp.Tipo = "CADENA";
                            } else if (exp.Tipo.equals("DOUBLE")) {
                                exp.Tipo = "CADENA";
                            } else if (exp.Tipo.equals("DATE")) {
                                exp.Tipo = "CADENA";
                            } else if (exp.Tipo.equals("DATETIME")) {
                                exp.Tipo = "CADENA";
                            } else if (exp.Tipo.equals("BOOL")) {
                                exp.Tipo = "CADENA";
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.Tipo, exp.Fila, exp.Columna);
                            }
                            break;
                        case "DOUBLE":
                            if (exp.Tipo.equals("DOUBLE")) {
                            } else if (exp.Tipo.equals("BOOL")) {
                                exp.Tipo = "DOUBLE";
                            } else if (exp.Tipo.equals("ENTERO")) {
                                exp.Tipo = "DOUBLE";
                                memoria.tablaVariables.add(vab);
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.Tipo, exp.Fila, exp.Columna);
                            }
                            break;
                        case "DATE":
                            if (exp.Tipo.equals("DATE")) {
                                memoria.tablaVariables.add(vab);
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.Tipo, exp.Fila, exp.Columna);
                            }
                            break;
                        case "DATETIME":
                            if (exp.Tipo.equals("DATETIME")) {
                                memoria.tablaVariables.add(vab);
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.Tipo, exp.Fila, exp.Columna);
                            }
                            break;
                        case "BOOL":
                            if (exp.Tipo.equals("BOOL")) {
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.Tipo, exp.Fila, exp.Columna);
                            }
                            break;
                        default:
                            memoria.addError("ERROR SEMANTICO ", "EXPRESION NO VALIDA", exp.Fila, exp.Columna);
                            break;
                    }
                }
                vab.valor = exp;
            }
        }
    }
}
