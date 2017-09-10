/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class tablaUSQL {

    public ArrayList<variable> tabla;

    public tablaUSQL() {
        tabla = memoria.tablaVariables;
    }

    public variable retornaFuncion(llamadaMetodo metodo) {
        variable vab = null;
        for(int i= tabla.size() - 1; i>=0; i--){
            variable func = tabla.get(i);
            if (func.nombre.equals(metodo.nombre) && func.rol.equals("METODO")) {
                return func;
            }
        }
        return vab;
    }

    public variable retornaVariable(String nombre_vab) {
        variable vab = null;
         for(int i= tabla.size() - 1; i>=0; i--){
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
        for(int i= tabla.size() - 1; i>=0; i--){
            if (tabla.get(i).getNombre().equals(nombre_vab) && tabla.get(i).getRol().equals("VARIABLE")) {
                tabla.remove(i);
                break;
            }
        }
    }

    public boolean encontrarRertorno() {
        return tabla.get(tabla.size() - 1).rol.equals("RETORNAR");
    }

    public boolean encontrarDetener() {
       return tabla.get(tabla.size() - 1).rol.equals("DETENER");
    }

}
