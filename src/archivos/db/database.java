/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.db;

import archivos.metodo.function;
import archivos.metodo.procedure;
import archivos.objeto.object;
import archivos.tabla.table;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class database {

    private String tipo;
    private String nombre;
    private String path;
    private ArrayList<function> function;
    private ArrayList<procedure> procedure;
    private ArrayList<object> object;
    private ArrayList<table> table;

    public database(String tipo, String nombre, String path, ArrayList<function> function, ArrayList<procedure> procedure, ArrayList<object> object, ArrayList<table> table) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.path = path;
        this.function = function;
        this.procedure = procedure;
        this.object = object;
        this.table = table;
    }

    public String XML() {
        String cadena = "";
        switch (tipo) {
            case "PROCEDURE":
                cadena += "<Procedure>\n"
                        + "\t<path>\"" + path + "\"</path>\n"
                        + "\t</Procedure>\n";
                break;
            case "FUNCTION":
                cadena += "<Function>\n"
                        + "\t<path>\"" + path + "\"</path>\n"
                        + "\t</Function>\n";
                break;
            case "OBJECT":
                cadena += "<Object>\n"
                        + "\t<path>\"" + path + "\"</path>\n"
                        + "\t</Object>\n";
                break;
            case "TABLE":
                cadena += "<Table>\n"
                        + "\t<nombre>\"" + nombre + "\"</nombre>\n"
                        + "\t<path>\"" + path + "\"</path>\n"
                        + "\t<rows>\n";

                for (int i = 0; i < table.size(); i++) {
                    cadena += table.get(i).Create_XML();
                }

                cadena += "\t</rows>\n"
                        + "\t</Table>\n";
                break;
            default:
                break;
        }
        return cadena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<function> getFunction() {
        return function;
    }

    public void setFunction(ArrayList<function> function) {
        this.function = function;
    }

    public ArrayList<procedure> getProcedure() {
        return procedure;
    }

    public void setProcedure(ArrayList<procedure> procedure) {
        this.procedure = procedure;
    }

    public ArrayList<object> getObject() {
        return object;
    }

    public void setObject(ArrayList<object> object) {
        this.object = object;
    }

    public ArrayList<table> getTable() {
        return table;
    }

    public void setTable(ArrayList<table> table) {
        this.table = table;
    }

    public boolean existFunction(String nombre) {
        for (int i = 0; i < function.size(); i++) {
            if (function.get(i).getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean existProcedure(String nombre) {
        for (int i = 0; i < procedure.size(); i++) {
            if (procedure.get(i).getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean existObject(String nombre) {
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i).getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean existTable(String nombre) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getNombre_campo().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void addFunction(function func) {
        function.add(func);
    }

    public void addProcedure(procedure proc) {
        procedure.add(proc);
    }

    public void addObject(object obj) {
        object.add(obj);
    }

    public void addTable(table tab) {
        table.add(tab);
    }

    public void removeFunction(String nombre) {
        for (int i = 0; i < function.size(); i++) {
            if (function.get(i).getNombre().equals(nombre)) {
                function.remove(i);
            }
        }
    }

    public void removeProcedure(String nombre) {
        for (int i = 0; i < procedure.size(); i++) {
            if (procedure.get(i).getNombre().equals(nombre)) {
                procedure.remove(i);
            }
        }
    }
    public void removeObject(String nombre) {
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i).getNombre().equals(nombre)) {
                object.remove(i);
            }
        }
    }

    public void removeTable(String nombre) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getNombre_campo().equals(nombre)) {
                table.remove(i);
            }
        }
    }
}
