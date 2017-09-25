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
public class select {

    public ArrayList<llamadaTabla> lista_columna;
    public boolean todaColumna;
    public ArrayList<String> lista_tabla;
    public expresion expresion;
    boolean tieneOrdenar;
    public ArrayList<llamadaTabla> tabla_ordenar;
    public String tipo_ordenar;
    int fila;
    int col;
    public ambito ambito;
    public seleccionaTabla pivote;

    public select(ArrayList<llamadaTabla> columna, boolean todaColumna, ArrayList<String> tabla, expresion expresion, boolean tieneOrdenar, ArrayList<llamadaTabla> tabla_ordenar, String tipo_ordenar, int fila, int col, ambito ambito) {
        this.lista_columna = columna;
        this.todaColumna = todaColumna;
        this.lista_tabla = tabla;
        this.expresion = expresion;
        this.tieneOrdenar = tieneOrdenar;
        this.tabla_ordenar = tabla_ordenar;
        this.tipo_ordenar = tipo_ordenar;
        this.fila = fila;
        this.col = col;
        this.ambito = ambito;
    }

    public void ejecucion() {
        memoria.tipoDetransaccion = 1;
        memoria.select_union = new seleccionaTabla();
        memoria.select_union = pivote();
        memoria.posicion = 0;
        memoria.select = new seleccionaTabla();
        hacerEncabezados();

        if (expresion != null) {
            for (int i = 0; i < memoria.select_union.size(); i++) {
                expresion exp = expresion.resCondicion();
                if (exp.tipo.equals("BOOL")) {
                    if (exp.bool) {
                        memoria.select.ingresar_select();
                    }
                }
                memoria.posicion++;
            }
        } else {
            memoria.select = memoria.select_union;
        }

        filtrar();
        memoria.select.HTML();
        //GENERAR EL HTML DE LA TABLA
        memoria.lista_de_select.add(memoria.select);
    }

    private void filtrar() {
        ArrayList<columna> listaTemp = new ArrayList<columna>();
        int getColumna = 0;
        if (!this.todaColumna) {
            for (int i = 0; i < lista_columna.size(); i++) {
                getColumna = memoria.select.filtrarTabla(lista_columna.get(i).tabla, lista_columna.get(i).columna, lista_columna.get(i).objeto);
                if (getColumna != 1000) {
                    columna col = memoria.select.lista_columna.get(getColumna);
                    listaTemp.add(col);
                }
            }
            memoria.select.lista_columna = listaTemp;
        }
    }

    private void hacerEncabezados() {
        ArrayList<columna> col = new ArrayList<columna>();
        ArrayList<expresion> lista_exp = new ArrayList<expresion>();
        col = memoria.select_union.lista_columna;

        for (int i = 0; i < col.size(); i++) {
            lista_exp = new ArrayList<expresion>();
            columna colum = new columna(col.get(i).tabla, col.get(i).objeto, col.get(i).atributo, col.get(i).tipo, lista_exp);
            memoria.select.lista_columna.add(colum);
        }

    }

    seleccionaTabla pivote() {
        int replicarData = 0;
        seleccionaTabla st = new seleccionaTabla(lista_tabla.get(0));
        st.ejecucion();
        ArrayList<columna> col = st.lista_columna;

        if (lista_tabla.size() > 1) {
            for (int i = 1; i < lista_tabla.size(); i++) {
                ArrayList<expresion> lista_exp = new ArrayList<expresion>();
                ArrayList<expresion> lista_exp_2 = new ArrayList<expresion>();
                ArrayList<columna> lista_columna = new ArrayList<columna>();

                seleccionaTabla stunion = new seleccionaTabla(lista_tabla.get(i));
                stunion.ejecucion();
                ArrayList<columna> colunion = stunion.lista_columna;
                int tamUnion = colunion.get(0).exp.size();

                for (int k = 0; k < col.size(); k++) {
                    lista_exp_2 = new ArrayList<expresion>();
                    lista_exp = col.get(k).exp;
                    for (int l = 0; l < lista_exp.size(); l++) {
                        for (int j = 0; j < tamUnion; j++) {
                            expresion filaExp = lista_exp.get(l);
                            lista_exp_2.add(filaExp);
                        }
                    }
                    columna colum = new columna(col.get(k).tabla, col.get(k).objeto, col.get(k).atributo, col.get(k).tipo, lista_exp_2);
                    lista_columna.add(colum);
                }

                lista_columna = lista_columna;
                replicarData = lista_columna.get(0).exp.size() / tamUnion;

                for (int k = 0; k < colunion.size(); k++) {
                    lista_exp_2 = new ArrayList<expresion>();
                    lista_exp = colunion.get(k).exp;
                    for (int j = 0; j < replicarData; j++) {
                        for (int l = 0; l < lista_exp.size(); l++) {
                            expresion filaExp = lista_exp.get(l);
                            lista_exp_2.add(filaExp);
                        }
                    }
                    columna colum = new columna(colunion.get(k).tabla, colunion.get(k).objeto, colunion.get(k).atributo, colunion.get(k).tipo, lista_exp_2);
                    lista_columna.add(colum);
                }
                lista_columna = lista_columna;
                col = lista_columna;
                st.lista_columna = col;
            }
        }
        return st;
    }

}
