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

    public String tipo;
    public String nombre;
    public ambito ambito;
    public ambito padre;
    public expresion valor;
    public int fila;
    public int columna;

    public declaracion(String tipo, String nombre, ambito ambito, expresion valor, int fila, int columna) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.ambito = ambito;
        this.padre = null;
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public expresion getValor() {
        return valor;
    }

    public void setValor(expresion valor) {
        this.valor = valor;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void ejecucion() {
        expresion exp = valor.resCondicion();
        variable vab;
        if (exp != null) {
            switch (tipo) {
                case "ENTERO":
                    if (exp.tipo.equals("ENTERO")) {
                        vab = new variable("ENTERO", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("BOOL")) {
                        exp.tipo = "ENTERO";
                        vab = new variable("ENTERO", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.tipo, fila, columna);
                    }
                    break;
                case "CADENA":
                    if (exp.tipo.equals("CADENA")) {
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("ENTERO")) {
                        exp.tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("DOUBLE")) {
                        exp.tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("DATE")) {
                        exp.tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("DATETIME")) {
                        exp.tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("BOOL")) {
                        exp.tipo = "CADENA";
                        vab = new variable("CADENA", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.tipo, fila, columna);
                    }
                    break;
                case "DOUBLE":
                    if (exp.tipo.equals("DOUBLE")) {
                        vab = new variable("DOUBLE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("BOOL")) {
                        exp.tipo = "DOUBLE";
                        vab = new variable("DOUBLE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else if (exp.tipo.equals("ENTERO")) {
                        exp.tipo = "DOUBLE";
                        vab = new variable("DOUBLE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.tipo, fila, columna);
                    }
                    break;
                case "DATE":
                    if (exp.tipo.equals("DATE")) {
                        vab = new variable("DATE", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.tipo, fila, columna);
                    }
                    break;
                case "DATETIME":
                    if (exp.tipo.equals("DATETIME")) {
                        vab = new variable("DATETIME", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.tipo, fila, columna);
                    }
                    break;
                case "BOOL":
                    if (tipo.equals("BOOL")) {
                        vab = new variable("BOOL", nombre, "VARIABLE", fila, columna, ambito, exp);
                        memoria.tablaVariables.add(vab);
                    } else {
                        memoria.addError("ERROR SEMANTICO ", tipo + " NO COINCIDE CON " + exp.tipo, fila, columna);
                    }
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", " EXPRESION NO VALIDA ", fila, columna);
                    break;
            }
        }
    }

}
