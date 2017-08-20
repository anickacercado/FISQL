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
    
    public String nombre_bd;
    public ArrayList<String> table;
    public ArrayList<String> object;
    public ArrayList<String> function;
    public ArrayList<String> procedure;
    
    public permisos(String nombre_bd, ArrayList<String> table, ArrayList<String> object, ArrayList<String> function, ArrayList<String> procedure)
    {
        this.nombre_bd = nombre_bd;
        this.table = table;
        this.object = object;
        this.function = function;
        this.procedure = procedure;
    }

    public void addTable(String nombre){
        this.table.add(nombre);
    }
    
    public void addObject(String nombre){
        this.object.add(nombre);
    }
    
    public void addFunction(String nombre){
        this.function.add(nombre);
    }
    
    public void addProcedure(String nombre){
        this.procedure.add(nombre);
    }
    
       public void removeTable(String nombre){
        this.table.remove(nombre);
    }
    
    public void removeObject(String nombre){
        this.object.remove(nombre);
    }
    
    public void removeFunction(String nombre){
        this.function.remove(nombre);
    }
    
    public void removeProcedure(String nombre){
        this.procedure.remove(nombre);
        
    }
    
    public boolean existsTable(String nombre){
        for(int i=0;i< table.size();i++){
            if(table.get(i).equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existsObject(String nombre){
        for(int i=0;i< object.size();i++){
            if(object.get(i).equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existsFunction(String nombre){
        for(int i=0;i< function.size();i++){
            if(function.get(i).equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existsProcedure(String nombre){
        for(int i=0;i< procedure.size();i++){
            if(procedure.get(i).equals(nombre)){
                return true;
            }
        }
        return false;
    }  

}
