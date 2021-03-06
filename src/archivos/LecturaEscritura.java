/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void Eliminar_directorio(File path) {
        if (!path.exists()) {
            return;
        }
        if (path.isDirectory()) {
            for (File f : path.listFiles()) {
                Eliminar_directorio(f);
            }
        }
        path.delete();
    }

    public void Crear_Directorio(String path) {
        File f = new File(path);
        f.mkdirs();
    }

    public void Crear_BD(String path) {

        String[] parts = path.split("\\\\");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
        path = part1 + "\\" + part2 + "\\" + part3;
        File f = new File(path);
        f.mkdirs();

    }

    public void abrirArchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void escribirExiste(String Path, String Cadena){
        File TextFile = new File(Path);
        FileWriter TextOut;
        try {
            TextOut = new FileWriter(TextFile, true);
            TextOut.write(Cadena);
            TextOut.close();
        } catch (IOException ex) {
            Logger.getLogger(LecturaEscritura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
