/*
 * To change this license heaexpDer, choose License HeaexpDers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import static java.lang.String.format;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anick
 */
public class expresion {

    public int entero;
    public double decimal;
    public String cadena;
    public Date date;
    public Date dateTime;
    public boolean bool;
    public llamadaMetodo llamadaMetodo;
    public llamadaVariable llamadaVariable;
    public llamadaTabla llamadaTabla;
    public expresion expIzq;
    public expresion expDer;
    public String tipo;
    public String nombre;
    public int fila;
    public int columna;

    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public llamadaMetodo getLlamadaMetodo() {
        return llamadaMetodo;
    }

    public void setLlamadaMetodo(llamadaMetodo llamadaMetodo) {
        this.llamadaMetodo = llamadaMetodo;
    }

    public llamadaVariable getLlamadaVariable() {
        return llamadaVariable;
    }

    public void setLlamadaVariable(llamadaVariable llamadaVariable) {
        this.llamadaVariable = llamadaVariable;
    }

    public llamadaTabla getLlamadaTabla() {
        return llamadaTabla;
    }

    public void setLlamadaTabla(llamadaTabla llamadaTabla) {
        this.llamadaTabla = llamadaTabla;
    }

    public expresion getExpIzq() {
        return expIzq;
    }

    public void setExpIzq(expresion expIzq) {
        this.expIzq = expIzq;
    }

    public expresion getExpDer() {
        return expDer;
    }

    public void setExpDer(expresion expDer) {
        this.expDer = expDer;
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

    public expresion(expresion nodo) {
        this.expIzq = nodo.expIzq;
        this.expDer = nodo.expDer;
        this.tipo = nodo.tipo;
        this.nombre = nodo.nombre;
        this.fila = nodo.fila;
        this.columna = nodo.columna;
        this.entero = nodo.entero;
        this.decimal = nodo.decimal;
        this.cadena = nodo.cadena;
        this.date = nodo.date;
        this.dateTime = nodo.dateTime;
        this.bool = nodo.bool;
        this.llamadaMetodo = nodo.llamadaMetodo;
        this.llamadaVariable = nodo.llamadaVariable;
        this.llamadaTabla = nodo.llamadaTabla;
    }

    public expresion(expresion expIzq, expresion expDer, String tipo, String nombre, int fila, int columna, Object valor) {
        this.expIzq = expIzq;
        this.expDer = expDer;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        if (tipo.equals("ENTERO")) {
            this.entero = Integer.parseInt(valor.toString());
            this.cadena = valor.toString();
        } else if (tipo.equals("DECIMAL")) {
            this.decimal = Double.parseDouble(valor.toString());
            this.cadena = valor.toString();
        } else if (tipo.equals("CADENA")) {
            this.cadena = (String) valor;
        } else if (tipo.equals("BOOL")) {
            this.cadena = valor.toString();
            if (this.cadena.equals("true") || this.cadena.equals("verdaexpDero")) {
                this.bool = true;
                this.entero = 1;
                this.decimal = 1;
            } else {
                this.bool = false;
                this.entero = 0;
                this.decimal = 0;
            }
        } else if (tipo.equals("DATE")) {
            this.cadena = valor.toString();
            try {
                this.date = memoria.formatDate.parse(this.cadena);
            } catch (ParseException ex) {
                Logger.getLogger(expresion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (tipo.equals("DATETIME")) {
            this.cadena = valor.toString();
            try {
                this.dateTime = memoria.formatDateTime.parse(this.cadena);
            } catch (ParseException ex) {
                Logger.getLogger(expresion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (tipo.equals("LLAMADA_METODO")) {
            this.llamadaMetodo = (llamadaMetodo) valor;
        } else if (tipo.equals("VARIABLE")) {
            this.llamadaVariable = (llamadaVariable) valor;
        } else if (tipo.equals("TABLA")) {
            this.llamadaTabla = (llamadaTabla) valor;
        }
    }

    private expresion resCondicion(expresion nodo) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", nodo.fila, nodo.columna, null);
        expresion expIzq = nodo.expIzq;
        expresion expDer = nodo.expDer;

        if (nodo.expIzq != null) {
            expIzq = nodo.expIzq.resCondicion();
        }

        if (nodo.expDer != null) {
            expDer = nodo.expDer.resCondicion();
        }
        if (nodo.tipo.equals("+")) {
            temp = resSuma(expIzq, expDer);
        } else if (nodo.tipo.equals("-")) {
            if (nodo.expIzq != null) {
                temp = resResta(expIzq, expDer);
            } else {
                temp = expresion.this.resResta(expDer);
            }
        } else if (nodo.tipo.equals("*")) {
            temp = resMultiplicacion(expIzq, expDer);
        } else if (nodo.tipo.equals("/")) {
            temp = resDivision(expIzq, expDer);
        } else if (nodo.tipo.equals("^")) {
            temp = resPotencia(expIzq, expDer);
        } else if (nodo.tipo.equals("++")) {
            temp = resAumento(expIzq);
        } else if (nodo.tipo.equals("--")) {
            temp = resDecremento(expIzq);
        } else if (nodo.tipo.equals(">")) {
            temp = resMayor(expIzq, expDer);
        } else if (nodo.tipo.equals("<")) {
            temp = resMenor(expIzq, expDer);
        } else if (nodo.tipo.equals(">=")) {
            temp = resMayorIgual(expIzq, expDer);
        } else if (nodo.tipo.equals("<=")) {
            temp = resMenorIgual(expIzq, expDer);
        } else if (nodo.tipo.equals("==")) {
            temp = resIgual(expIzq, expDer);
        } else if (nodo.tipo.equals("!=")) {
            temp = resDiferente(expIzq, expDer);
        } else if (nodo.tipo.equals("||")) {
            temp = resOr(expIzq, expDer);
        } else if (nodo.tipo.equals("&&")) {
            temp = resAnd(expIzq, expDer);
        } else if (nodo.tipo.equals("!")) {
            temp = resNot(expDer);
        } else if (nodo.tipo.equals("ENTERO")) {
            temp = new expresion(nodo);
        } else if (nodo.tipo.equals("DECIMAL")) {
            temp = new expresion(nodo);
        } else if (nodo.tipo.equals("CADENA")) {
            temp = new expresion(nodo);
        } else if (nodo.tipo.equals("BOOL")) {
            temp = new expresion(nodo);
        } else if (nodo.tipo.equals("DATE")) {
            temp = new expresion(nodo);
        } else if (nodo.tipo.equals("DATETIME")) {
            temp = new expresion(nodo);
        } else if (nodo.tipo.equals("VARIABLE")) {
            variable vab = this.llamadaVariable.ejecucion();
            if (vab != null) {
                if (vab.valor == null) {
                    memoria.addError("ERROR SEMANTICO ", "VARIABLE TIPO NULL", fila, columna);
                } else {
                    temp = (expresion) vab.valor;
                }
            } else {
                memoria.addError("ERROR SEMANTICO ", "NO EXISTE LA VARIABLE", fila, columna);
            }
        } else if (nodo.tipo.equals("LLAMADA_METODO")) {
            pilaVariable tabla = new pilaVariable();
            llamadaMetodo llame = this.llamadaMetodo;
            expresion aux= llame.ejecucion();
            
            if (aux!=null) {
                temp = aux; 
                tabla.popVariable();
                memoria.RETORNA = false;
            } else {
                memoria.addError("ERROR SEMANTICO ", "METODO NO RETORNA VALOR ", fila, columna);
            }
        }
        return temp;
    }

    public expresion resCondicion() {
        return resCondicion(this);
    }

    public expresion resMayor(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero > expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero > expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero > expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " > " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal > expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal > expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal > expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " > " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero > expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero > expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero > expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " > " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATE")) {
            switch (expDer.tipo) {
                case "DATE":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, (expIzq.date).after(expDer.date));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " > " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATETIME")) {
            switch (expDer.tipo) {
                case "DATETIME":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, (expIzq.dateTime).after(expDer.dateTime));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " > " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resMenor(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero < expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero < expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero < expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " < " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal < expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal < expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal < expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " < " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero < expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero < expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero < expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " < " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATE")) {
            switch (expDer.tipo) {
                case "DATE":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, (expIzq.date).before(expDer.date));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " < " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATETIME")) {
            switch (expDer.tipo) {
                case "DATETIME":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, (expIzq.dateTime).before(expDer.dateTime));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " < " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resIgual(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero == expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero == expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero == expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " = " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal == expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal == expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal == expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " = " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("CADENA")) {
            switch (expDer.tipo) {
                case "CADENA":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.cadena.equals(expDer.cadena));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " = " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero == expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero == expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.bool == expDer.bool);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " = " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATE")) {
            switch (expDer.tipo) {
                case "DATE":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.date.equals(expDer.date));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " = " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATETIME")) {
            switch (expDer.tipo) {
                case "DATETIME":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.dateTime.equals(expDer.dateTime));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " = " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resDiferente(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero != expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero != expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero != expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " != " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal != expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal != expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.decimal != expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " != " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("CADENA")) {
            switch (expDer.tipo) {
                case "CADENA":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, !expIzq.cadena.equals(expDer.cadena));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " != " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero != expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.entero != expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.bool != expDer.bool);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " != " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATE")) {
            switch (expDer.tipo) {
                case "DATE":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, !expIzq.date.equals(expDer.date));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " != " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATETIME")) {
            switch (expDer.tipo) {
                case "DATETIME":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, !expIzq.dateTime.equals(expDer.dateTime));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " != " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resMayorIgual(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        expresion mayor = resMayor(expIzq, expDer);
        expresion igual = resIgual(expIzq, expDer);
        if (mayor.tipo.equals("BOOL")) {
            switch (igual.tipo) {
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, mayor.bool || igual.bool);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " >= " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resMenorIgual(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        expresion menor = resMenor(expIzq, expDer);
        expresion igual = resIgual(expIzq, expDer);
        if (menor.tipo.equals("BOOL")) {
            switch (igual.tipo) {
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, menor.bool || igual.bool);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " <= " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resOr(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.bool || expDer.bool);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " || " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resAnd(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "BOOL":
                    temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, expIzq.bool && expDer.bool);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " && " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resNot(expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expDer.tipo.equals("BOOL")) {
            temp = new expresion(null, null, "BOOL", "BOOL", fila, columna, !expDer.bool);
        } else {
            memoria.addError("ERROR SEMANTICO ", "!" + expDer.tipo, fila, columna);
        }
        return temp;
    }

    public expresion resSuma(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero + expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero + expDer.decimal);
                    break;
                case "CADENA":
                    temp = new expresion(null, null, "CADENA", "CADENA", fila, columna, String.valueOf(expIzq.entero) + expDer.cadena);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero + expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO", expIzq.tipo + " + " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal + expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal + expDer.decimal);
                    break;
                case "CADENA":
                    temp = new expresion(null, null, "CADENA", "CADENA", fila, columna, String.valueOf(expIzq.decimal) + expDer.cadena);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal + expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO", expIzq.tipo + " + " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("CADENA")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "CADENA", "CADENA", fila, columna, expIzq.cadena + String.valueOf(expDer.entero));
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "CADENA", "CADENA", fila, columna, expIzq.cadena + String.valueOf(expDer.decimal));
                    break;
                case "CADENA":
                    temp = new expresion(null, null, "CADENA", "CADENA", fila, columna, expIzq.cadena + expDer.cadena);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO", expIzq.tipo + " + " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero + expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero + expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.bool || expDer.bool);
                    break;
                case "CADENA":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.cadena + expDer.cadena);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO", expIzq.tipo + " + " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATE")) {
            switch (expDer.tipo) {
                case "CADENA":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.cadena + expDer.cadena);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO", expIzq.tipo + " + " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DATETIME")) {
            switch (expDer.tipo) {
                case "CADENA":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.cadena + expDer.cadena);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO", expIzq.tipo + " + " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resResta(expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expDer.tipo.equals("ENTERO")) {
            temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, -expDer.entero);
        } else if (expDer.tipo.equals("DECIMAL")) {
            temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, -expDer.decimal);
        } else if (expDer.tipo.equals("BOOL")) {
            temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, -expDer.entero);
        } else {
            memoria.addError("ERROR SEMANTICO", expDer.tipo + " - " + expDer.tipo, fila, columna);
        }
        return temp;
    }

    public expresion resResta(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero - expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero - expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero - expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " - " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal - expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal - expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal - expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " - " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero - expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero - expDer.decimal);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " - " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resMultiplicacion(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero * expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero * expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero * expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " * " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal * expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal * expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal * expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " * " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero * expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero * expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.bool && expDer.bool);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " * " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resDivision(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero / expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero / expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero / expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " / " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal / expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal / expDer.decimal);
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal / expDer.entero);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " / " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero / expDer.entero);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.entero / expDer.decimal);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " / " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resPotencia(expresion expIzq, expresion expDer) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    double p = Math.pow(expIzq.entero, expDer.entero);
                    int v = (int) p;
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, v);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, Math.pow(expIzq.entero, expDer.decimal));
                    break;
                case "BOOL":
                    double pb = Math.pow(expIzq.entero, expDer.entero);
                    int vb = (int) pb;
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, vb);
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " ^ " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("DECIMAL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, Math.pow(expIzq.decimal, expDer.entero));
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, Math.pow(expIzq.decimal, expDer.decimal));
                    break;
                case "BOOL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, Math.pow(expIzq.decimal, expDer.entero));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " ^ " + expDer.tipo, fila, columna);
                    break;
            }
        } else if (expIzq.tipo.equals("BOOL")) {
            switch (expDer.tipo) {
                case "ENTERO":
                    double p = Math.pow(expIzq.entero, expDer.entero);
                    int v = (int) p;
                    temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, v);
                    break;
                case "DECIMAL":
                    temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, Math.pow(expIzq.entero, expDer.decimal));
                    break;
                default:
                    memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " ^ " + expDer.tipo, fila, columna);
                    break;
            }
        }
        return temp;
    }

    public expresion resAumento(expresion expIzq) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero + 1);
        } else if (expIzq.tipo.equals("DECIMAL")) {
            temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal + 1);
        } else {
            memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " ++ ", fila, columna);
        }
        return temp;
    }

    public expresion resDecremento(expresion expIzq) {
        expresion temp = new expresion(null, null, "ERROR", "ERROR", fila, columna, null);
        if (expIzq.tipo.equals("ENTERO")) {
            temp = new expresion(null, null, "ENTERO", "ENTERO", fila, columna, expIzq.entero - 1);
        } else if (expIzq.tipo.equals("DECIMAL")) {
            temp = new expresion(null, null, "DECIMAL", "DECIMAL", fila, columna, expIzq.decimal - 1);
        } else {
            memoria.addError("ERROR SEMANTICO ", expIzq.tipo + " -- ", fila, columna);
        }
        return temp;
    }
}
