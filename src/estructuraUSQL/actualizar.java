/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.EscrituraBD;
import archivos.memoria;
import archivos.retornoObjetoBD;
import archivos.tabla.fila_tabla;
import archivos.tabla.table;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class actualizar {

    public String nombre;
    public ArrayList<String> lista_columna;
    public ArrayList<expresion> lista_exp;
    public expresion expresion;
    public ambito ambito;

    public actualizar(String nombre, ArrayList<String> lista_columna, ArrayList<expresion> lista_exp, expresion expresion, ambito ambito) {
        this.nombre = nombre;
        this.lista_columna = lista_columna;
        this.lista_exp = lista_exp;
        this.expresion = expresion;
        this.ambito = ambito;
    }

    public void ejecucion() {
        memoria.tipoDetransaccion = 2;
        seleccionaTabla st = new seleccionaTabla(nombre);
        st.ejecucion();
        memoria.updateTabla = st;
        memoria.posicion = 0;

        if (expresion != null) {
            for (int i = 0; i < memoria.updateTabla.size(); i++) {
                expresion exp = expresion.resCondicion();
                if (exp.tipo.equals("BOOL")) {
                    if (exp.bool) {
                        act();
                    }
                }
                memoria.posicion++;
            }
        } else {
            for (int i = 0; i < memoria.updateTabla.size(); i++) {
                act();
                memoria.posicion++;
            }
        }
        escribirDB();
    }

    public void act() {
        if (lista_columna.size() == lista_exp.size()) {
            for (int i = 0; i < lista_columna.size(); i++) {
                memoria.updateTabla.actualizaCol(lista_columna.get(i), lista_exp.get(i));
            }
        }
    }

    retornoObjetoBD rob = new retornoObjetoBD();
    EscrituraBD escritura = new EscrituraBD();
    public void escribirDB() {
        ArrayList<fila_tabla> lista_ft = new ArrayList<fila_tabla>();
        ArrayList<columna> lista_col = new ArrayList<columna>();
        lista_col = memoria.updateTabla.lista_columna;

        for (int i = 0; i < lista_col.size(); i++) {
            table columna = rob.retorno_Campo_Tabla(memoria.use_db, nombre, lista_col.get(i).objeto);
            if (!columna.es_objeto) {
                lista_ft = new ArrayList<fila_tabla>();
                for (int k=0;  k<memoria.updateTabla.size(); k++){
                    expresion exp= lista_col.get(i).exp.get(k).resCondicion();
                    fila_tabla ft = new fila_tabla(0,exp.cadena);
                    lista_ft.add(ft);
                }
                columna.setRegistro(lista_ft);
            }
        }
        escritura.Escribir();
    }
}
