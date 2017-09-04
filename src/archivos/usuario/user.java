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
public class user {

    private String tipo;
    private String nombre;
    private String pass;
    private String estado;
    public ArrayList<permisos> permisos;
    
    public user(String nombre, String pass, String tipo, String estado, ArrayList<permisos> permisos)
    {
        this.nombre=nombre;
        this.pass=pass;
        this.tipo= tipo;
        this.estado = estado;
        this.permisos = permisos; 
    }
    
    
  public String XML(){
        String codigo ="";
       
        codigo += "<usr>\n"
                + "\t<nombre>\"" + nombre + "\"</nombre>\n"
                + "\t<pass>\"" + pass + "\"</pass>\n"
                + "\t<tipo>\"" + tipo +"\"</tipo>\n"
                + "\t<estado>\"" + estado +"\"</estado>\n"
                + "\t<permiso>\n"
                ;
        
        for(int i =0; i < permisos.size(); i++){
            codigo += permisos.get(i).XML();
        }
        
        codigo += "\t</permiso>\n"
                + "</usr>";
        
        return codigo;
    }
    
    public boolean inicioSesion(String nombre, String pass)
    {
        if (this.nombre.equals(nombre) && this.pass.equals(pass)){
           this.estado= "activo";
           return true;
        }
        return false;
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
