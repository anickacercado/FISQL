/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.LecturaEscritura;
import archivos.memoria;
import java.io.File;

/**
 *
 * @author anick
 */
public class usqldump {
    
    LecturaEscritura le= new LecturaEscritura();
    
    public void ejecucion(){
        String Path= memoria.backup + "\\" + memoria.use_db + ".umdp";
        le.Crear(Path);
        le.Escritura(Path, "\n  " + memoria.cod_client );   
    }     
}
