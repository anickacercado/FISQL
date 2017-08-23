/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.metodo;

import archivos.parametro;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class procedure {
    
    public String nombre, codigo;
    public ArrayList<parametro> parametro;
    
    public procedure(String nombre, ArrayList<parametro> parametro, String codigo){
        this.nombre = nombre;
        this.parametro = parametro;
        this.codigo = codigo;
    }   
    
     public void addParametro(String nombre,String tipo){
         parametro attr = new parametro(nombre,tipo);
         this.parametro.add(attr);
    }
     
    public void removeParametro(String nombre,String tipo){
         parametro attr = new parametro(nombre,tipo);
         this.parametro.remove(attr);
    }
    
     public boolean existsParametro(String nombre,String tipo){
        for(int i=0;i< this.parametro.size();i++){
            if(this.parametro.get(i).nombre.equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    
    
}
