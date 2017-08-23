/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.objeto;

import archivos.parametro;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class object {
    
    public String nombre;
    public ArrayList<parametro> atributo;
    
    public object(String nombre, ArrayList<parametro> atributo){
        this.nombre=nombre;
        this.atributo=atributo;
    }   
    
     public void addAtributo(String nombre,String tipo){
         parametro attr = new parametro(nombre,tipo);
         this.atributo.add(attr);
    }
     
    public void removeAtributo(String nombre,String tipo){
         parametro attr = new parametro(nombre,tipo);
         this.atributo.remove(attr);
    }
    
     public boolean existsAtributo(String nombre,String tipo){
        for(int i=0;i< this.atributo.size();i++){
            if(this.atributo.get(i).nombre.equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    
}
