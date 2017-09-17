/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.objeto;

import archivos.parametro;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class object {

    public String nombre;
    public ArrayList<parametro> atributo;

    public object(String nombre, ArrayList<parametro> atributo) {
        this.nombre = nombre;
        this.atributo = atributo;
    }

    public String XML() {
        String cadena = "";
        cadena += "<Obj>\n"
                + "\t<nombre>\"" + nombre + "\"</nombre>\n"
                + "\t<attr>\n";

        for (int i = 0; i < atributo.size(); i++) {
            cadena += atributo.get(i).XML();
        }

        cadena += "\t</attr>\n"
                + "\t</Obj>\n";
        return cadena;
    }

    public void addAtributo(parametro attr) {
        this.atributo.add(attr);
    }

    public void removeAtributo(String nombre) {
        for (int i = 0; i < this.atributo.size(); i++) {
            if (this.atributo.get(i).getNombre().equals(nombre)) {
                this.atributo.remove(i);
            }
        }
    }

    public boolean existsAtributo(String nombre) {
        for (int i = 0; i < this.atributo.size(); i++) {
            if (this.atributo.get(i).getNombre().equals(nombre)) {
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

    public ArrayList<parametro> getAtributo() {
        return atributo;
    }

    public void setAtributo(ArrayList<parametro> atributo) {
        this.atributo = atributo;
    }

}
