/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import archivos.objeto.object;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class pilaVariable {

    public ArrayList<variable> tabla;

    public pilaVariable() {
        tabla = memoria.tablaVariables;
    }

    public pilaVariable(ArrayList<variable> tabla) {
        this.tabla = tabla;
    }

    public ArrayList<variable> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<variable> tabla) {
        this.tabla = tabla;
    }


    public variable retornaObjeto(String nombre_objeto, String nombre_atributo) {
        variable vab = null;
        expresion exp;
        objeto obj;
        for (int i = tabla.size() - 1; i >= 0; i--) {
            variable vab2 = tabla.get(i);
            if (vab2.nombre.equals(nombre_objeto) && vab2.rol.equals("VARIABLE")) {
                exp = (expresion) vab2.valor;
                obj= exp.objeto;
                if (obj != null) {
                    for (int j = 0; j < obj.lista_variable.size(); j++) {
                        variable vab3 = obj.lista_variable.get(j);
                        if (vab3.nombre.equals(nombre_atributo) && vab3.rol.equals("VARIABLE")) {
                            return vab3;
                        }
                    }
                }
            }
        }
        return vab;
    }

    public variable retornaVariable(String nombre_vab) {
        variable vab = null;
        nombre_vab = nombre_vab.toLowerCase();
        for (int i = tabla.size() - 1; i >= 0; i--) {
            variable vab2 = tabla.get(i);
            if (vab2.nombre.equals(nombre_vab) && vab2.rol.equals("VARIABLE")) {
                return vab2;
            }
        }
        return vab;
    }

    public void insertarVariable(variable vab) {
        tabla.add(vab);
    }

    public void popVariable() {
        tabla.remove(tabla.size() - 1);
    }

    public void popVariable(String nombre_vab) {
        nombre_vab = nombre_vab.toLowerCase();
        for (int i = tabla.size() - 1; i >= 0; i--) {
            if (tabla.get(i).getNombre().equals(nombre_vab) && tabla.get(i).getRol().equals("VARIABLE")) {
                tabla.remove(i);
                break;
            }
        }
    }
}
