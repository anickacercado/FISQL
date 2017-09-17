/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

/**
 *
 * @author anick
 */
public class parametro {
    
    public String nombre;
    public String tipo;
    
    public parametro(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
     public String XML(){
        String codigo ="";
        codigo = "\t<"+tipo+">\"" + nombre + "\"</"+tipo+">\n";
        return codigo;
    }  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }     
}
