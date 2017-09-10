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
public class declaracion {

    public ambito ambito, padre;
    public String tipo, nombre;
    public expresion valor;
    public int fila, columna;

    public declaracion(String tipo, String nombre, ambito ambito, Object valor, int fila, int columna) {
        this.ambito = ambito;
        this.padre = null;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.valor = (expresion) valor;
    }

    public void ejecucion() {
        expresion exp = valor.ResolverExpresion();
        variable vab;
        if (exp != null) {
            switch (tipo) {
                case "ENTERO":
                    if (exp.Tipo.equals("ENTERO")) {
                        vab = new variable("ENTERO", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("BOOL")) {
                        exp.Tipo = "ENTERO";
                        vab = new variable("ENTERO", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.Tipo, fila, columna);
                    }
                    break;
                case "CADENA":
                    if (exp.Tipo.equals("CADENA")) {
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("ENTERO")) {
                        exp.Tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("DOUBLE")) {
                        exp.Tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("DATE")) {
                        exp.Tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("DATETIME")) {
                        exp.Tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("BOOL")) {
                        exp.Tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.Tipo, fila, columna);
                    }
                    break;
                case "DOUBLE":
                    if (exp.Tipo.equals("DOUBLE")) {
                        vab = new variable("DOUBLE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("BOOL")) {
                        exp.Tipo = "DOUBLE";
                        vab = new variable("DOUBLE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.Tipo.equals("ENTERO")) {
                        exp.Tipo = "DOUBLE";
                        vab = new variable("DOUBLE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.Tipo, fila, columna);
                    }
                    break;
                case "DATE":
                    if (exp.Tipo.equals("DATE")) {
                        vab = new variable("DATE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.Tipo, fila, columna);
                    }
                    break;
                case "DATETIME":
                    if (exp.Tipo.equals("DATETIME")) {
                        vab = new variable("DATETIME", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.Tipo, fila, columna);
                    }
                    break;
                case "BOOL":
                    if (tipo.equals("BOOL")) {
                        vab = new variable("BOOL", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.Tipo, fila, columna);
                    }
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", " EXPRESION NO VALIDA " , fila, columna);
                    break;
            }
        }
    }
}
