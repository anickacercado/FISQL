/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.LecturaEscritura;
import archivos.memoria;

/**
 *
 * @author anick
 */
public class backup {
    
    public String tipo;
    public String nombre_bd;
    public String nueva_path;
    public ambito ambito;
    LecturaEscritura le = new LecturaEscritura();

    public backup(String tipo, String nombre_bd, String nueva_path, ambito ambito) {
        this.tipo = tipo;
        this.nombre_bd = nombre_bd;
        this.nueva_path = nueva_path;
        this.ambito = ambito;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre_bd() {
        return nombre_bd;
    }

    public void setNombre_bd(String nombre_bd) {
        this.nombre_bd = nombre_bd;
    }
    
    
    public void ejecucion(){  
        if(tipo.equals("BACKUP_USQLDUMP")){
           
            String pathBackup= memoria.backup + "\\" + nombre_bd + ".umdp";
            String pathUsuario= memoria.backupUsuario + "\\" + nueva_path + ".umdp";
            String cadena = le.lectura(pathBackup);
            le.Crear(pathUsuario);
            le.Escritura(pathUsuario, "\n  " + cadena);
            le.abrirArchivo(pathUsuario);
        }
        else if(tipo.equals("RESTAURAR_USQLDUMP")){
            String cadena = le.lectura(nueva_path);
            /*Aquí se manda la cadena al cliente*/
            le.abrirArchivo(nueva_path);
        }
    }
    
}
