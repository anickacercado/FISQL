/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author anick
 */
public class archivo {

    public archivo() {
        directorio();
    }

    private void directorio() {
        File DB = new File(direccion.DB);
        if (!DB.exists()) {
            crearCarpeta(DB);
        } else {
            leerMaestro();
        }
    }

    private void crearCarpeta(File DB) {
        if (DB.mkdirs()) { //Crea carpeta y archivo 

            File rutaMaestro = new File(direccion.maestro);
            if (!rutaMaestro.exists()) {
                try {
                    rutaMaestro.createNewFile();
                } catch (IOException ex) {
                }
            }

            File rutaUser = new File(direccion.user);
            if (!rutaUser.exists()) {
                try {
                    rutaUser.createNewFile();

                    Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaUser), "utf-8"));
                    w.write("<usr>\n"
                            + "	<nombre>\"admin\"</nombre>\n"
                            + "	<pass>\"admin\"</pass>\n"
                            + "	<tipo>\"admin\"</tipo>\n"
                            + "	<estado>\"inactivo\"</estado>\n"
                            + "	<permiso>		\n"
                            + "	</permiso>\n"
                            + "</usr>");
                    w.close();

                } catch (IOException ex) {
                }
            }
        }
    }

    private void leerMaestro() {
       System.out.println("Ya existe Directorio");
    }

}
