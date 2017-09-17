/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.tabla;

import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class fila_tabla_objeto {

    public int no_fila;
    public ArrayList<registro_objeto> registro = new ArrayList<registro_objeto>();

    public fila_tabla_objeto(int no_fila,ArrayList<registro_objeto> registro) {
        this.no_fila = no_fila;
        this.registro = registro;
    }

    public String XML() {
        String cadena = "";
        try {
            for (int i = 0; i < registro.size(); i++) {
                String nombre_campo = registro.get(i).getNombre();
                cadena += "\t<" + nombre_campo + ">\"" + registro.get(i).getValor() + "\"</" + nombre_campo + ">\n";
            }
        } catch (Exception e) {

        }
        return cadena;
    }

    public int getNo_fila() {
        return no_fila;
    }

    public void setNo_fila(int no_fila) {
        this.no_fila = no_fila;
    }

    public ArrayList<registro_objeto> getRegistro() {
        return registro;
    }

    public void setRegistro(ArrayList<registro_objeto> registro) {
        this.registro = registro;
    }
}
