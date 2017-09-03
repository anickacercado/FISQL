/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.usuario;

import java.util.ArrayList;


/**
 *
 * @author anick
 */
public class permisos {
    
    private String nombre_bd;
    private ArrayList<String> table;
    private ArrayList<String> object;
    private ArrayList<String> function;
    private ArrayList<String> procedure;
    
    public permisos(String nombre_bd, ArrayList<String> table, ArrayList<String> object, ArrayList<String> function, ArrayList<String> procedure)
    {
        this.nombre_bd = nombre_bd;
        this.table = table;
        this.object = object;
        this.function = function;
        this.procedure = procedure;
    }
    
    
    public String XML(){
    String codigo="";
            codigo += "\t\t<db>\n"
                + "\t\t\t<nombre>\"" + nombre_bd + "\"</nombre>\n";
        
        for(int i = 0; i < table.size(); i++){
            codigo += "\t\t\t<tabla>\"" + table.get(i) + "\"</tabla>\n";
        }
        
        for(int i = 0; i < object.size(); i++){
            codigo += "\t\t\t<obj>\"" + object.get(i) + "\"</obj>\n";
        }
        
        for(int i = 0; i < function.size(); i++){
            codigo += "\t\t\t<func>\"" + function.get(i) + "\"</func>\n";
        }
        
        for(int i = 0; i < procedure.size(); i++){
            codigo += "\t\t\t<proc>\"" + procedure.get(i) + "\"</proc>\n";
        }
        
        codigo += "\t\t</db>\n";
    return codigo;
    }

    public ArrayList<String> getProcedure() {
        return procedure;
    }

    public void setProcedure(ArrayList<String> procedure) {
        this.procedure = procedure;
    }

    public String getNombre_bd() {
        return nombre_bd;
    }

    public void setNombre_bd(String nombre_bd) {
        this.nombre_bd = nombre_bd;
    }

    public ArrayList<String> getTable() {
        return table;
    }

    public void setTable(ArrayList<String> table) {
        this.table = table;
    }

    public ArrayList<String> getObject() {
        return object;
    }

    public void setObject(ArrayList<String> object) {
        this.object = object;
    }

    public ArrayList<String> getFunction() {
        return function;
    }

    public void setFunction(ArrayList<String> function) {
        this.function = function;
    }
    
    
}
