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
public class usuario {
    public String nombre,pass,tipo,estado;
    public ArrayList<permisos> permisos;
    
    public usuario(String nombre, String pass, String tipo, String estado, ArrayList<permisos> permisos)
    {
        this.nombre=nombre;
        this.pass=pass;
        this.tipo= tipo;
        this.estado = estado;
        this.permisos = permisos; 
    }
    
    public boolean inicioSesion(String nombre, String pass)
    {
        if (this.nombre.equals(nombre) && this.pass.equals(pass)){
           this.estado= "activo";
           return true;
        }
        return false;
    }    
}
