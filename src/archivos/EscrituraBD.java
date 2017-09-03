/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import archivos.db.database;
import archivos.metodo.function;
import archivos.metodo.procedure;
import archivos.objeto.object;
import archivos.tabla.table;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class EscrituraBD {

    LecturaEscritura le = new LecturaEscritura();
    ArrayList<procedure> arbolProcedure;
    ArrayList<function> arbolFunction;
    ArrayList<object> arbolObject;
    ArrayList<table> arbolTable;

    public void Escribir() {
        File f = new File(memoria.DB);
        le.Eliminar_directorio(f);
        EscrituraUsuario();
    }

    private void EscrituraUsuario() {
        File f = new File(memoria.DB);
        if (f.mkdirs()) {
            String cadena = "";
            for (int i = 0; i < memoria.arbolUsuario.size(); i++) {
                cadena = cadena + memoria.arbolUsuario.get(i).XML();
            }
            le.Crear_Escritura(memoria.user, cadena);
            EscrituraMaster();
        }
    }

    private void EscrituraMaster() {
        String cadena = "";
        String path = "";
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            cadena = cadena + memoria.arbolMaestro.get(i).XML();
            path = memoria.arbolMaestro.get(i).getPath();
            le.Crear_BD(path);
            EscrituraEstructuraBD(memoria.arbolMaestro.get(i).getDatabase(), path);
        }
        le.Crear_Escritura(memoria.maestro, cadena);
    }

    private void EscrituraEstructuraBD(ArrayList<database> data, String path) {
        String cadena = "";
        for (int i = 0; i < data.size(); i++) {
            cadena = cadena + data.get(i).XML();
        }
        le.Crear_Escritura(path, cadena);
        EscrituraObjeto(data);
    }

    private void EscrituraObjeto(ArrayList<database> data) {
        String cadena = "";
        String tipo = "";
        String pathObjeto = "";

        for (int i = 0; i < data.size(); i++) {
            cadena = "";
            tipo = data.get(i).getTipo();
            pathObjeto = data.get(i).getPath();
            switch (tipo) {
                case "PROCEDURE":
                    arbolProcedure = data.get(i).getProcedure();
                    if (arbolProcedure != null) {
                        for (int j = 0; j < arbolProcedure.size(); j++) {
                            cadena = cadena + arbolProcedure.get(j).XML();
                        }
                    }
                    le.Crear_Escritura(pathObjeto, cadena);

                    break;
                case "FUNCTION":
                    arbolFunction = data.get(i).getFunction();
                    if (arbolFunction != null) {
                        for (int j = 0; j < arbolFunction.size(); j++) {
                            cadena = cadena + arbolFunction.get(j).XML();
                        }
                    }
                    le.Crear_Escritura(pathObjeto, cadena);

                    break;
                case "OBJECT":
                    arbolObject = data.get(i).getObject();
                    if (arbolObject != null) {
                        for (int j = 0; j < arbolObject.size(); j++) {
                            cadena = cadena + arbolObject.get(j).XML();
                        }
                    }
                    le.Crear_Escritura(pathObjeto, cadena);

                    break;
                case "TABLE":
                    arbolTable = data.get(i).getTable();
                    if (arbolTable != null) {
                        cadena = EscribirTabla(arbolTable);
                    }
                    le.Crear_Escritura(pathObjeto, cadena);
                    break;
                default:
                    break;
            }
        }
    }

    private String EscribirTabla(ArrayList<table> table) {

        String cadena = "";

        try {
            int fila = table.get(0).noFila();
            for (int i = 0; i < fila; i++) {
                cadena += "\t<Row>\n";
                for (int j = 0; j < table.size(); j++) {
                    cadena += table.get(j).XML(i);
                }
                cadena += "\t</Row>\n";
            }
        } catch (Exception e) {
        }

        return cadena;
    }

}
