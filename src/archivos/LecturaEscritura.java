/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author anick
 */
public class LecturaEscritura {

    public String lectura(String path) {
        String linea = "";
        String cadena = "";
        try {
            FileReader f = new FileReader(path);
            BufferedReader b = new BufferedReader(f);
            try {
                while ((linea = b.readLine()) != null) {
                    cadena = cadena + linea;
                }
                b.close();
            } catch (IOException ex) {
                cadena = "NO";
            }
        } catch (FileNotFoundException ex) {
            cadena = "NO";
            return cadena;
        }
        return cadena;
    }

    public void Escritura(String path, String cadena) {
        File f = new File(path);
        try {
            try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "utf-8"))) {
                w.write(cadena);
            }
        } catch (IOException ex) {
        }
    }

    public void Crear(String path) {
        File f = new File(path);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
            }
        }
    }

    public void Crear_Escritura(String path, String cadena) {
        File f = new File(path);
        try {
            if (!f.exists()) {
                f.createNewFile();
                try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "utf-8"))) {
                    w.write(cadena);
                }
            }
        } catch (IOException ex) {
        }
    }
}
