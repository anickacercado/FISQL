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
public class columna {
    
    public String tabla;
    public String objeto;
    public String atributo;
    public String tipo;
    public ArrayList<expresion> exp;

    public columna(String tabla, String objeto, String atributo, String tipo, ArrayList<expresion> exp) {
        this.tabla = tabla;
        this.objeto = objeto;
        this.atributo = atributo;
        this.tipo = tipo;
        this.exp = exp;
    } 

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<expresion> getExp() {
        return exp;
    }

    public void setExp(ArrayList<expresion> exp) {
        this.exp = exp;
    }
}
