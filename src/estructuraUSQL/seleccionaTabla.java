/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.memoria;
import archivos.objeto.object;
import archivos.retornoObjetoBD;
import archivos.tabla.fila_tabla_objeto;
import archivos.tabla.registro_objeto;
import archivos.tabla.table;
import java.util.ArrayList;
import archivos.memoria;

/**
 *
 * @author anick
 */
public class seleccionaTabla {

    ArrayList<columna> lista_columna = new ArrayList<columna>();
    String nombre_tabla;
    retornoObjetoBD rob = new retornoObjetoBD();
    public String codigo;

    public seleccionaTabla(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
    }

    public seleccionaTabla() {

    }

    public void HTML() {
        String nombre_campo = "";
        String codigo = "";
        //String codigo = "\n <html> \n <body> ";
        codigo += "\n<table>";
        codigo += "\n<tr>";
        for (int i = 0; i < lista_columna.size(); i++) {
            nombre_campo = lista_columna.get(i).tabla + " " + lista_columna.get(i).objeto + " " + lista_columna.get(i).atributo;
            codigo += "\n<td>" + nombre_campo + "</td>";
        }
        codigo += "\n</tr>";

        try {
            for (int i = 0; i < size(); i++) {
                codigo += "\n<tr>";
                for (int j = 0; j < lista_columna.size(); j++) {
                    expresion exp = lista_columna.get(j).exp.get(i).resCondicion();
                    nombre_campo = exp.cadena;
                    codigo += "\n<td>" + nombre_campo + "</td>";
                }
                codigo += "\n</tr>";
            }
        } catch (Exception exp) {
        }
        codigo += "\n</table>";
        //codigo += "\n </body> \n </html>";
        this.codigo = codigo;
    }

    public void ejecucion() {
        expresion exp = null;
        String valor = "";
        String tipo = "";
        String atributo = "";

        ArrayList<expresion> lista_exp = null;
        ArrayList<table> tab = null;
        tab = rob.retornoTabla(memoria.use_db, nombre_tabla);
        if (tab != null) {
            for (int j = 0; j < tab.size(); j++) {
                table col = tab.get(j);
                if (!col.isEs_objeto()) {
                    lista_exp = new ArrayList<expresion>();
                    for (int k = 0; k < col.registro.size(); k++) {
                        valor = col.registro.get(k).valor;
                        tipo = col.tipo;
                        valor = returnValor(tipo, valor);
                        switch (tipo) {
                            case "ENTERO":
                                exp = new expresion(null, null, "ENTERO", "ENTERO", 0, 0, valor);
                                lista_exp.add(exp);
                                break;
                            case "CADENA":
                                exp = new expresion(null, null, "CADENA", "CADENA", 0, 0, valor);
                                lista_exp.add(exp);
                                break;
                            case "DOUBLE":
                                exp = new expresion(null, null, "DOUBLE", "DOUBLE", 0, 0, valor);
                                lista_exp.add(exp);
                                break;
                            case "BOOL":
                                exp = new expresion(null, null, "BOOL", "BOOL", 0, 0, valor);
                                lista_exp.add(exp);
                                break;
                            case "DATE":
                                exp = new expresion(null, null, "DATE", "DATE", 0, 0, valor);
                                lista_exp.add(exp);
                                break;
                            case "DATETIME":
                                exp = new expresion(null, null, "DATETIME", "DATETIME", 0, 0, valor);
                                lista_exp.add(exp);
                                break;
                            default:
                                break;
                        }
                    }
                    columna colum = new columna(nombre_tabla, col.nombre_campo, "", col.tipo, lista_exp);
                    lista_columna.add(colum);
                } else {
                    ArrayList<registro_objeto> registroObjeto;
                    ArrayList<fila_tabla_objeto> filaRegistroObjeto;
                    filaRegistroObjeto = col.registro_objeto;
                    object obj = rob.retornoObjeto(memoria.use_db, col.tipo.toLowerCase());
                    object objBD = rob.retornoObjeto(memoria.use_db, col.tipo.toLowerCase());

                    if (filaRegistroObjeto != null) {
                        registroObjeto = filaRegistroObjeto.get(0).registro;
                        int contadorAtributo = filaRegistroObjeto.get(0).registro.size();
                        for (int m = 0; m < contadorAtributo; m++) {
                            lista_exp = new ArrayList<expresion>();
                            atributo = objBD.atributo.get(m).getNombre();
                            for (int n = 0; n < filaRegistroObjeto.size(); n++) {
                                tipo = filaRegistroObjeto.get(n).registro.get(m).nombre;
                                valor = filaRegistroObjeto.get(n).registro.get(m).valor;
                                valor = returnValor(tipo, valor);
                                switch (tipo) {
                                    case "ENTERO":
                                        exp = new expresion(null, null, "ENTERO", "ENTERO", 0, 0, valor);
                                        lista_exp.add(exp);
                                        break;
                                    case "CADENA":
                                        exp = new expresion(null, null, "CADENA", "CADENA", 0, 0, valor);
                                        lista_exp.add(exp);
                                        break;
                                    case "DOUBLE":
                                        exp = new expresion(null, null, "DOUBLE", "DOUBLE", 0, 0, valor);
                                        lista_exp.add(exp);
                                        break;
                                    case "BOOL":
                                        exp = new expresion(null, null, "BOOL", "BOOL", 0, 0, valor);
                                        lista_exp.add(exp);
                                        break;
                                    case "DATE":
                                        exp = new expresion(null, null, "DATE", "DATE", 0, 0, valor);
                                        lista_exp.add(exp);
                                        break;
                                    case "DATETIME":
                                        exp = new expresion(null, null, "DATETIME", "DATETIME", 0, 0, valor);
                                        lista_exp.add(exp);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            columna colum = new columna(nombre_tabla, col.nombre_campo, atributo, col.tipo, lista_exp);
                            lista_columna.add(colum);
                        }
                    }
                }
            }
        } {
        memoria.addError("ERROR BD ", "No existe tabla en SELECCIONAR O UPDATE ", 0, 0);
        }
    }

    public String returnValor(String tipo, String valor) {
        String retornoValor = valor;
        if (valor.equals("NULL")) {
            switch (tipo) {
                case "ENTERO":
                    valor = "0";
                    break;
                case "CADENA":
                    valor = "";
                    break;
                case "DOUBLE":
                    valor = "0";
                    break;
                case "BOOL":
                    valor = "0";
                    break;
                case "DATE":
                    valor = "01-01-1900";
                    break;
                case "DATETIME":
                    valor = "01-01-1900 00:00:00";
                    break;
                default:
                    break;
            }
        }
        return retornoValor;
    }

    public int size() {
        int reg = lista_columna.get(0).exp.size();
        return reg;
    }

    public expresion retornaExp(String tabla, String objeto, String atributo) {
        if (!tabla.equals("") && !objeto.equals("") && !atributo.equals("")) {
            for (columna col : this.lista_columna) {
                if (col.tabla.equals(tabla) && col.objeto.equals(objeto) && col.atributo.equals(atributo)) {
                    return col.exp.get(memoria.posicion);
                }
            }
        }

        if (!tabla.equals("") && !objeto.equals("")) {
            for (columna col : this.lista_columna) {
                if (col.tabla.equals(tabla) && col.objeto.equals(objeto)) {
                    return col.exp.get(memoria.posicion);
                }
            }
        }

        if (!objeto.equals("") && tabla.equals("") && atributo.equals("")) {
            for (columna col : this.lista_columna) {
                if (col.atributo.equals(atributo)) {
                    return col.exp.get(memoria.posicion);
                } else if (col.objeto.equals(objeto)) {
                    return col.exp.get(memoria.posicion);
                }
            }
        }
        return null;
    }

    public void actualizaCol(String nombre, expresion exp) {
        for (columna col : this.lista_columna) {
            if (col.objeto.equals(nombre)) {
                col.exp.set(memoria.posicion, exp);
            }
        }
    }

    public void ingresar_select() {
        expresion exp;
        for (int i = 0; i < memoria.select_union.lista_columna.size(); i++) {
            exp = memoria.select_union.lista_columna.get(i).exp.get(memoria.posicion);
            memoria.select.lista_columna.get(i).exp.add(exp);
        }
        //memoria.select.lista_columna.get(i).exp.add(result);
    }

}
