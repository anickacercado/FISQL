/*
 * To change this license header, choose License Headers in Project Properties.
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

    public expresion Izquierda;
    public expresion Derecha;
    public String Tipo, Nombre;
    public int Fila, Columna;
    public int Entero;
    public double Decimal;
    public String Cadena;
    public Date Date;
    public Date DateTime;
    public boolean Bool;
    public llamadaMetodo llamadaMetodo;
    public llamadaVariable llamadaVariable;
    public llamadaTabla llamadaTabla;

    public expresion(expresion nodo) {
        this.Izquierda = nodo.Izquierda;
        this.Derecha = nodo.Derecha;
        this.Tipo = nodo.Tipo;
        this.Nombre = nodo.Nombre;
        this.Fila = nodo.Fila;
        this.Columna = nodo.Columna;
        this.Entero = nodo.Entero;
        this.Decimal = nodo.Decimal;
        this.Cadena = nodo.Cadena;
        this.Date = nodo.Date;
        this.DateTime = nodo.DateTime;
        this.Bool = nodo.Bool;
        this.llamadaMetodo = nodo.llamadaMetodo;
        this.llamadaVariable = nodo.llamadaVariable;
        this.llamadaTabla = nodo.llamadaTabla;
    }

    public expresion(expresion izq, expresion der, String tipo, String nombre, int fila, int columna, Object valor) {
        this.Izquierda = izq;
        this.Derecha = der;
        this.Tipo = tipo;
        this.Nombre = nombre;
        this.Fila = fila;
        this.Columna = columna;

        switch (tipo) {
            case "ENTERO":
                this.Entero = Integer.parseInt(valor.toString());
                this.Cadena = valor.toString();
                break;

            case "DECIMAL":
                this.Decimal = Double.parseDouble(valor.toString());
                this.Cadena = valor.toString();
                break;

            case "CADENA":
                this.Cadena = (String) valor;
                break;

            case "BOOL":
                this.Cadena = valor.toString();
                if (this.Cadena.equals("true") || this.Cadena.equals("verdadero")) {
                    this.Bool = true;
                    this.Entero = 1;
                    this.Decimal = 1;
                } else {
                    this.Bool = false;
                    this.Entero = 0;
                    this.Decimal = 0;
                }
                break;

            case "DATE":
                this.Cadena = valor.toString();
                try {
                    this.Date = memoria.formatDate.parse(this.Cadena);
                } catch (ParseException ex) {
                    Logger.getLogger(expresion.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "DATETIME":
                this.Cadena = valor.toString();
                try {
                    this.DateTime = memoria.formatDateTime.parse(this.Cadena);
                } catch (ParseException ex) {
                    Logger.getLogger(expresion.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "METODO":
                this.llamadaMetodo = (llamadaMetodo) valor;
                break;

            case "VARIABLE":
                this.llamadaVariable = (llamadaVariable) valor;
                break;

            case "TABLA":
                this.llamadaTabla = (llamadaTabla) valor;
                break;

        }
    }

    public expresion ResolverExpresion() {
        return ResolverExpresion(this);
    }

    private expresion ResolverExpresion(expresion nodo) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", nodo.Fila, nodo.Columna, null);
        expresion izq = nodo.Izquierda;
        expresion der = nodo.Derecha;

        if (nodo.Izquierda != null) {
            izq = nodo.Izquierda.ResolverExpresion();
        }

        if (nodo.Derecha != null) {
            der = nodo.Derecha.ResolverExpresion();
        }
        switch (nodo.Tipo) {
            case "+":
                aux = Suma(izq, der);
                break;

            case "-":
                if (nodo.Izquierda != null) {
                    aux = Resta(izq, der);
                } else {
                    aux = Resta(der);
                }
                break;

            case "*":
                aux = Multiplicacion(izq, der);
                break;

            case "/":
                aux = Division(izq, der);
                break;

            case "^":
                aux = Potencia(izq, der);
                break;

            case "++":
                aux = Aumento(izq);
                break;

            case "--":
                aux = Disminucion(izq);
                break;

            case ">":
                aux = Mayor(izq, der);
                break;

            case "<":
                aux = Menor(izq, der);
                break;

            case ">=":
                aux = MayorIgual(izq, der);
                break;

            case "<=":
                aux = MenorIgual(izq, der);
                break;

            case "==":
                aux = Igual(izq, der);
                break;

            case "!=":
                aux = Diferente(izq, der);
                break;

            case "||":
                aux = Or(izq, der);
                break;

            case "&&":
                aux = And(izq, der);
                break;

            case "!":
                aux = Not(der);
                break;

            case "ENTERO":
                aux = new expresion(nodo);
                break;

            case "DECIMAL":
                aux = new expresion(nodo);
                break;

            case "CADENA":
                aux = new expresion(nodo);
                break;

            case "BOOL":
                aux = new expresion(nodo);
                break;

            case "DATE":
                aux = new expresion(nodo);
                break;

            case "DATETIME":
                aux = new expresion(nodo);
                break;

            case "VARIABLE":
                variable vab = this.llamadaVariable.ejecucion();
                if (vab != null) {
                    if (vab.valor == null) {
                        memoria.addError("ERROR SEMANTICO ", "VARIABLE TIPO NULL", Fila, Columna);
                    } else {
                        aux = (expresion) vab.valor;
                    }
                }
                else {
                memoria.addError("ERROR SEMANTICO ", "NO EXISTE LA VARIABLE", Fila, Columna);
                }
                break;
        }
        return aux;
    }

    public expresion Suma(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero + der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero + der.Decimal);
                        break;

                    case "CADENA":
                        aux = new expresion(null, null, "CADENA", "CADENA", Fila, Columna, String.valueOf(izq.Entero) + der.Cadena);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero + der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO", izq.Tipo + " + " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal + der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal + der.Decimal);
                        break;

                    case "CADENA":
                        aux = new expresion(null, null, "CADENA", "CADENA", Fila, Columna, String.valueOf(izq.Decimal) + der.Cadena);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal + der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO", izq.Tipo + " + " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "CADENA":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "CADENA", "CADENA", Fila, Columna, izq.Cadena + String.valueOf(der.Entero));
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "CADENA", "CADENA", Fila, Columna, izq.Cadena + String.valueOf(der.Decimal));
                        break;

                    case "CADENA":
                        aux = new expresion(null, null, "CADENA", "CADENA", Fila, Columna, izq.Cadena + der.Cadena);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO", izq.Tipo + " + " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero + der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero + der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Bool || der.Bool);
                        break;

                    case "CADENA":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Cadena + der.Cadena);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO", izq.Tipo + " + " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATE":
                switch (der.Tipo) {

                    case "CADENA":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Cadena + der.Cadena);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO", izq.Tipo + " + " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATETIME":
                switch (der.Tipo) {

                    case "CADENA":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Cadena + der.Cadena);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO", izq.Tipo + " + " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public expresion Resta(expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (der.Tipo) {
            case "ENTERO":
                aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, -der.Entero);
                break;

            case "DECIMAL":
                aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, -der.Decimal);

                break;

            case "BOOL":
                aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, -der.Entero);
                break;

            default:
                memoria.addError("ERROR SEMANTICO", der.Tipo + " - " + der.Tipo, Fila, Columna);
                break;
        }
        return aux;
    }

    public expresion Resta(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero - der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero - der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero - der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " - " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal - der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal - der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal - der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " - " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero - der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero - der.Decimal);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " - " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public expresion Multiplicacion(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero * der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero * der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero * der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " * " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal * der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal * der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal * der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " * " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero * der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero * der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Bool && der.Bool);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " * " + der.Tipo, Fila, Columna);
                        break;
                }
                break;
        }
        return aux;
    }

    public expresion Division(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero / der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero / der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero / der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " / " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal / der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal / der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal / der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " / " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero / der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Entero / der.Decimal);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " / " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public expresion Potencia(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        double p = Math.pow(izq.Entero, der.Entero);
                        int v = (int) p;
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, v);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, Math.pow(izq.Entero, der.Decimal));
                        break;

                    case "BOOL":
                        double pb = Math.pow(izq.Entero, der.Entero);
                        int vb = (int) pb;
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, vb);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " ^ " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, Math.pow(izq.Decimal, der.Entero));
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, Math.pow(izq.Decimal, der.Decimal));

                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, Math.pow(izq.Decimal, der.Entero));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " ^ " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        double p = Math.pow(izq.Entero, der.Entero);
                        int v = (int) p;
                        aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, v);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, Math.pow(izq.Entero, der.Decimal));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " ^ " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public expresion Aumento(expresion izq) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero + 1);
                break;

            case "DECIMAL":
                aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal + 1);
                break;

            default:
                memoria.addError("ERROR SEMANTICO ", izq.Tipo + " ++ ", Fila, Columna);
                break;

        }
        return aux;
    }

    public expresion Disminucion(expresion izq) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                aux = new expresion(null, null, "ENTERO", "ENTERO", Fila, Columna, izq.Entero - 1);
                break;

            case "DECIMAL":
                aux = new expresion(null, null, "DECIMAL", "DECIMAL", Fila, Columna, izq.Decimal - 1);
                break;

            default:
                memoria.addError("ERROR SEMANTICO ", izq.Tipo + " -- ", Fila, Columna);
                break;

        }
        return aux;
    }

    public expresion Mayor(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero > der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero > der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero > der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " > " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal > der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal > der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal > der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " > " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero > der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero > der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero > der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " > " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATE":
                switch (der.Tipo) {
                    case "DATE":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, (izq.Date).after(der.Date));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " > " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATETIME":
                switch (der.Tipo) {
                    case "DATETIME":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, (izq.DateTime).after(der.DateTime));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " > " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public expresion Menor(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero < der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero < der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero < der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " < " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal < der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal < der.Decimal);

                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal < der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " < " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero < der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero < der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero < der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " < " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATE":
                switch (der.Tipo) {
                    case "DATE":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, (izq.Date).before(der.Date));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " < " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATETIME":
                switch (der.Tipo) {
                    case "DATETIME":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, (izq.DateTime).before(der.DateTime));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " < " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public expresion Igual(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero == der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero == der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero == der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " = " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal == der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal == der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal == der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " = " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "CADENA":
                switch (der.Tipo) {
                    case "CADENA":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Cadena.equals(der.Cadena));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " = " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero == der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero == der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Bool == der.Bool);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " = " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATE":
                switch (der.Tipo) {
                    case "DATE":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Date.equals(der.Date));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " = " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATETIME":
                switch (der.Tipo) {
                    case "DATETIME":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.DateTime.equals(der.DateTime));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " = " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public expresion Diferente(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "ENTERO":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero != der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero != der.Decimal);

                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero != der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " != " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DECIMAL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal != der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal != der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Decimal != der.Entero);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " != " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "CADENA":
                switch (der.Tipo) {
                    case "CADENA":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, !izq.Cadena.equals(der.Cadena));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " != " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "BOOL":
                switch (der.Tipo) {
                    case "ENTERO":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero != der.Entero);
                        break;

                    case "DECIMAL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Entero != der.Decimal);
                        break;

                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Bool != der.Bool);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " != " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATE":
                switch (der.Tipo) {
                    case "DATE":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, !izq.Date.equals(der.Date));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " != " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case "DATETIME":
                switch (der.Tipo) {
                    case "DATETIME":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, !izq.DateTime.equals(der.DateTime));
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " != " + der.Tipo, Fila, Columna);
                        break;
                }
                break;
        }
        return aux;
    }

    public expresion MayorIgual(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);
        expresion mayor = Mayor(izq, der);
        expresion igual = Igual(izq, der);

        switch (mayor.Tipo) {
            case "BOOL":
                switch (igual.Tipo) {
                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, mayor.Bool || igual.Bool);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " >= " + der.Tipo, Fila, Columna);
                        break;
                }
                break;
        }
        return aux;
    }

    public expresion MenorIgual(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);
        expresion menor = Menor(izq, der);
        expresion igual = Igual(izq, der);

        switch (menor.Tipo) {
            case "BOOL":
                switch (igual.Tipo) {
                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, menor.Bool || igual.Bool);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " <= " + der.Tipo, Fila, Columna);
                        break;
                }
                break;
        }
        return aux;
    }

    public expresion Or(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "BOOL":
                switch (der.Tipo) {
                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Bool || der.Bool);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " || " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            default:
                break;
        }
        return aux;
    }

    public expresion And(expresion izq, expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (izq.Tipo) {
            case "BOOL":
                switch (der.Tipo) {
                    case "BOOL":
                        aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, izq.Bool && der.Bool);
                        break;

                    default:
                        memoria.addError("ERROR SEMANTICO ", izq.Tipo + " && " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            default:
                break;
        }
        return aux;
    }

    public expresion Not(expresion der) {
        expresion aux = new expresion(null, null, "ERROR", "ERROR", Fila, Columna, null);

        switch (der.Tipo) {
            case "BOOL":
                aux = new expresion(null, null, "BOOL", "BOOL", Fila, Columna, !der.Bool);
                break;

            default:
                memoria.addError("ERROR SEMANTICO ", "!" + der.Tipo, Fila, Columna);
                break;
        }
        return aux;
    }

}
