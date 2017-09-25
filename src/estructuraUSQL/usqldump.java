/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import archivos.LecturaEscritura;
import archivos.memoria;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anick
 */
public class usqldump {

    LecturaEscritura le = new LecturaEscritura();

    public void ejecucion() {
        String Path = memoria.backup + "\\" + memoria.use_db + ".umdp";
        le.Crear(Path);
        le.escribirExiste(Path, "\n  " + memoria.cod_client);
    }
}
