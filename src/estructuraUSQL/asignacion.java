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

    public llamadaVariable retornaVariable;
    public ambito ambito;
    public expresion valor;
    public ambito padre;
    
 
    public asignacion(llamadaVariable retornaVariable, ambito ambito, expresion valor) {
        this.ambito = ambito;
        this.retornaVariable = retornaVariable;
        this.valor = valor;
        this.padre = null;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }

    public ambito getPadre() {
        return padre;
    }

    public void setPadre(ambito padre) {
        this.padre = padre;
    }

    public llamadaVariable getRetornaVariable() {
        return retornaVariable;
    }

    public void setRetornaVariable(llamadaVariable retornaVariable) {
        this.retornaVariable = retornaVariable;
    }

    public expresion getValor() {
        return valor;
    }

    public void setValor(expresion valor) {
        this.valor = valor;
    }
    
        public void ejecucion() {
        variable vab;
        if (valor != null) {
            expresion exp = valor;
            exp = exp.resCondicion();

            vab = retornaVariable.ejecucion();
            if (vab != null) {
                if (exp != null) {
                    switch (vab.tipo) {
                        case "ENTERO":
                            if (exp.tipo.equals("ENTERO")) {
                            } else if (exp.tipo.equals("BOOL")) {
                                exp.tipo = "ENTERO";
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.tipo, exp.fila, exp.columna);
                            }
                            break;
                        case "CADENA":
                            if (exp.tipo.equals("CADENA")) {
                            } else if (exp.tipo.equals("ENTERO")) {
                                exp.tipo = "CADENA";
                            } else if (exp.tipo.equals("DOUBLE")) {
                                exp.tipo = "CADENA";
                            } else if (exp.tipo.equals("DATE")) {
                                exp.tipo = "CADENA";
                            } else if (exp.tipo.equals("DATETIME")) {
                                exp.tipo = "CADENA";
                            } else if (exp.tipo.equals("BOOL")) {
                                exp.tipo = "CADENA";
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.tipo, exp.fila, exp.columna);
                            }
                            break;
                        case "DOUBLE":
                            if (exp.tipo.equals("DOUBLE")) {
                            } else if (exp.tipo.equals("BOOL")) {
                                exp.tipo = "DOUBLE";
                            } else if (exp.tipo.equals("ENTERO")) {
                                exp.tipo = "DOUBLE";
                                memoria.tablaVariables.add(vab);
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.tipo, exp.fila, exp.columna);
                            }
                            break;
                        case "DATE":
                            if (exp.tipo.equals("DATE")) {
                                memoria.tablaVariables.add(vab);
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.tipo, exp.fila, exp.columna);
                            }
                            break;
                        case "DATETIME":
                            if (exp.tipo.equals("DATETIME")) {
                                memoria.tablaVariables.add(vab);
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.tipo, exp.fila, exp.columna);
                            }
                            break;
                        case "BOOL":
                            if (exp.tipo.equals("BOOL")) {
                            } else {
                                memoria.addError("ERROR SEMANTICO ", vab.tipo + " NO COINCIDE CON " + exp.tipo, exp.fila, exp.columna);
                            }
                            break;
                        default:
                            memoria.addError("ERROR SEMANTICO ", "EXPRESION NO VALIDA", exp.fila, exp.columna);
                            break;
                    }
                }
                vab.valor = exp;
            }
        }
    }
}
