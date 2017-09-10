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

    public imprimir(expresion valor) {
        this.valor = valor;
        this.ambito = new ambito("IMPRIMIR", new ArrayList<simbolo>());
    }

    public void ejecucion() {
        expresion exp = valor.ResolverExpresion();
        if (exp.Tipo.equals("ENTERO")) {
            System.out.print(String.valueOf(exp.Entero));
        }
        else if (exp.Tipo.equals("DECIMAL")) {
            System.out.print(String.valueOf(exp.Decimal));
        }
        else if (exp.Tipo.equals("CADENA")) {
            System.out.print(String.valueOf(exp.Cadena));
        }
        else if (exp.Tipo.equals("BOOL")) {
            System.out.print(String.valueOf(exp.Bool));
        }
        else if (exp.Tipo.equals("DATE")) {
            System.out.print(String.valueOf(exp.Cadena));
        }
        else if (exp.Tipo.equals("DATETIME")) {
            System.out.print(String.valueOf(exp.Cadena));
        }
    }
}
