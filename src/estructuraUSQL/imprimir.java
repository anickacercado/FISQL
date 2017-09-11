/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class imprimir {

    public expresion valor;
    public ambito ambito;

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
        if (exp.tipo.equals("ENTERO")) {
            System.out.println(String.valueOf(exp.entero));
        }
        else if (exp.tipo.equals("DECIMAL")) {
            System.out.println(String.valueOf(exp.decimal));
        }
        else if (exp.tipo.equals("CADENA")) {
            System.out.println(String.valueOf(exp.cadena));
        }
        else if (exp.tipo.equals("BOOL")) {
            System.out.println(String.valueOf(exp.bool));
        }
        else if (exp.tipo.equals("DATE")) {
            System.out.println(String.valueOf(exp.cadena));
        }
        else if (exp.tipo.equals("DATETIME")) {
            System.out.println(String.valueOf(exp.cadena));
        }
    }
}
