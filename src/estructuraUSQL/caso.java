/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

/**
 *
 * @author anick
 */
public class caso {
    public expresion valor;
    public ambito ambito;

    public caso(expresion valor, ambito ambito) {
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
    
}
