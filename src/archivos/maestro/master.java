/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.maestro;

import archivos.db.database;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class master {

    private String nombre;
    private String path;
    private ArrayList<database> database;

    public master(String nombre,
            String path,
            ArrayList<database> database
    ) 
    {
        this.nombre = nombre;
        this.path = path;
        this.database = database;
    }

    public ArrayList<database> getDatabase() {
        return database;
    }

    public void setDatabase(ArrayList<database> database) {
        this.database = database;
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
    
    
}
