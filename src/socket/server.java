/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import archivos.memoria;
import estructuraUSQL.analizar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anick
 */
public class server extends Thread {

    public void run() {
        Socket socket = new Socket();
        while (true) {
            System.out.println("Entra Hilo...");
            try {
                ServerSocket serverSo = new ServerSocket(9770);
                socket = new Socket();
                System.out.println("Esperando una conexion...");

                /*Recibe Mensaje*/
                socket = serverSo.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
                System.out.println("Conexion con Cliente");
                
                String readLine = "";
                String mensajeRecibido = "";
                String mensajeFuncProc = "";
                while ((readLine = entrada.readLine()) != null) {
                    if(readLine.equals("$*@n!ck@*$")) break;
                    mensajeRecibido+=readLine + "\n";
                    mensajeFuncProc+=readLine + " ";
                    System.out.println(">>>> " + readLine);
                }
                
                memoria.cod_client= mensajeRecibido;
                memoria.cod_client_sin_saltos = mensajeFuncProc;

                //Aqui mandar a analizar el mensaje recibido en la variable mensajeRecibido
                analizar a = new analizar();
                a.iniciarEjecucion();

                //Luego la respuesta del analisis enviarla de regreso

                               /*Envía Mensaje*/
                String respuesta = "Se recibio el mensaje:\n"
                + mensajeRecibido
                + "\n----------------------------------- aqui termina\n";
                
                System.out.println(mensajeRecibido);

                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                pw.println(respuesta);
                pw.println("$*@n!ck@*$");
                
                System.out.println("Respuesta enviada");

                serverSo.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}