/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import archivos.analizaPaquete;
import archivos.memoria;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
                    if(readLine.equals("$*@n!ck@*$")) 
                        break;
                    mensajeRecibido+=readLine + "\n";
                    mensajeFuncProc+=readLine + " ";
                    System.out.println(">>>> " + readLine);
                }
                
                memoria.cod_client= mensajeRecibido;
                memoria.cod_client_sin_saltos = mensajeFuncProc;

                //Aqui mandar a analizar el mensaje recibido en la variable mensajeRecibido
                analizaPaquete a= new analizaPaquete();
                a.analizar();

                //Luego la respuesta del analisis enviarla de regreso

                               /*Envía Mensaje*/
                String respuesta = "Se recibio el mensaje:\n"
                + mensajeRecibido
                + "\n----------------------------------- aqui termina\n";
                
                System.out.println(mensajeRecibido);
                String variable= memoria.respuestaPly;
                variable= variable.replace("Ó","O");
                variable= variable.replace("Á","A");
                variable= variable.replace("É","E");
                variable= variable.replace("Í","I");
                variable= variable.replace("Ú","U");
                variable= variable.replace("ó","o");
                variable= variable.replace("á","a");
                variable= variable.replace("é","e");
                variable= variable.replace("í","i");
                variable= variable.replace("ú","u");
                variable= variable.replace("[","{");
                variable= variable.replace("]","}");  
                variable= variable.replace("ñ","n");
                
                String[] partes = variable.split("\n");

                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                //pw.println(memoria.respuestaPly+"\n");
                for (String v : partes){
                    pw.println(v);
                }
                //pw.println(variable+"\n");
                pw.println("$$$$$$$$$$");
                
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