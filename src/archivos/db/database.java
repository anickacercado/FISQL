/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.db;

import archivos.parametro;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class database {
    public String tipo;
    public String nombre;
    public String path;
    public ArrayList<parametro> campo;
    
    public database(  String tipo,
     String nombre,
     String path,
     ArrayList<parametro> campo)
    {
        this.tipo=tipo;
        this.nombre=nombre;
        this.path=path;
        this.campo=campo;
    }
    
}
