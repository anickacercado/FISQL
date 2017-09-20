/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.metodo;

import archivos.parametro;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class function {

    private String nombre;
    private String codigo;
    public String retorno;
    private ArrayList<parametro> parametro;

    public function(String nombre, ArrayList<parametro> parametro, String codigo, String retorno) {
        this.nombre = nombre;
        this.parametro = parametro;
        this.codigo = codigo;
        this.retorno = retorno;
    }
    
    

    public String XML() {
        String cadena = "";
        cadena += "<Func>\n"
                + "\t<nombre>\"" + nombre + "\"</nombre>\n"
                + "\t<params>\n";

        for (int i = 0; i < parametro.size(); i++) {
            cadena += parametro.get(i).XML();
        }

        cadena += "\t</params>\n"
                + "\t<src>~" + codigo + "~</src>\n"
                + "\t<tipo>\"" + retorno + "\"</tipo>\n"
                + "\t</Func>\n";

        return cadena;
    }
    

    public void addParametro(String nombre, String tipo) {
        parametro attr = new parametro(nombre, tipo);
        this.parametro.add(attr);
    }

    public void removeParametro(String nombre, String tipo) {
        parametro attr = new parametro(nombre, tipo);
        this.parametro.remove(attr);
    }

    public boolean existsParametro(String nombre, String tipo) {
        for (int i = 0; i < this.parametro.size(); i++) {
            if (this.parametro.get(i).getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public ArrayList<parametro> getParametro() {
        return parametro;
    }

    public void setParametro(ArrayList<parametro> parametro) {
        this.parametro = parametro;
    }

}
