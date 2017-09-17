/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import consola.principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author anick
 */
public class imprimir {

    public expresion valor;
    public ambito ambito;
     Date date = new Date();
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

    public imprimir(expresion valor, ambito ambito) {
        this.valor = valor;
        this.ambito = ambito;
    }
    
    public expresion getValor() {
        return valor;
    }

    public void setValor(expresion valor) {
        this.valor = valor;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }
    
    public void ejecucion() {
        expresion exp = valor.resCondicion();
        String imp= "";
        if (exp.tipo.equals("ENTERO")) {
            imp= String.valueOf(exp.entero);
            principal.imprimir(hourFormat.format(date) + " Imprimir Salida -->" + imp);
        }
        else if (exp.tipo.equals("DECIMAL")) {
            imp= String.valueOf(exp.decimal);
            principal.imprimir(hourFormat.format(date) + " Imprimir Salida -->" + imp);
        }
        else if (exp.tipo.equals("CADENA")) {
            imp= String.valueOf(exp.cadena);
            principal.imprimir(hourFormat.format(date) + " Imprimir Salida -->" + imp);
        }
        else if (exp.tipo.equals("BOOL")) {
            imp= String.valueOf(exp.bool);
            principal.imprimir(hourFormat.format(date) + " Imprimir Salida -->" + imp);
        }
        else if (exp.tipo.equals("DATE")) {
            imp= String.valueOf(exp.cadena);
            principal.imprimir(hourFormat.format(date) + " Imprimir Salida -->" + imp);
        }
        else if (exp.tipo.equals("DATETIME")) {
            imp= String.valueOf(exp.cadena);
            principal.imprimir(hourFormat.format(date) + " Imprimir Salida -->" + imp);
        }
    }
}
