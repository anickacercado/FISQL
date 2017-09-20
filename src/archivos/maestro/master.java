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
    ) {
        this.nombre = nombre;
        this.path = path;
        this.database = database;
    }

    public String ARBOL() {
        String cadena = "";
        cadena += "{";
        cadena += "\n\"database_id\":\"" + nombre + "\",";
        cadena += "\n\"tables\": [";
        for (int i = 0; i < database.size(); i++) {
            if (i >= 3) {
                if (i == database.size() - 1) {
                    cadena += database.get(i).ARBOL();
                } else {
                    cadena += database.get(i).ARBOL() + ",";
                }
            }
        }
        cadena += "],";
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                cadena += database.get(i).ARBOL();
            } else {
                cadena += database.get(i).ARBOL() + ",";
            }
        }
        cadena += "}";
        return cadena;
    }

    public master() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existTable(String nombre) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getTipo().equals("TABLE")) {
                if (database.get(i).getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeTable(String nombre) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getTipo().equals("TABLE")) {
                if (database.get(i).getNombre().equals(nombre)) {
                    database.remove(i);
                }
            }
        }
    }

    public String XML() {
        String codigo = "";
        codigo += "<DB>\n"
                + "\t<nombre>\"" + nombre + "\"</nombre>\n"
                + "\t<path>\"" + path + "\"</path>\n"
                + "</DB>";
        return codigo;
    }

    public void insertDataBase(database data) {
        database.add(data);
    }

    public void deleteDataBase(database data) {
        database.add(data);
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
