/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import archivos.memoria;
import consola.principal;
import estructuraUSQL.analizar;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import usql.analizador;

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
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                System.out.println("Conexion con Cliente");

                String readLine = "";
                String mensajeRecibido = "";
                String mensajeFuncProc = "";
                while ((readLine = entrada.readLine()) != null) {
                    if (readLine.equals("$$$$$*$*$*$*****$$$$$")) {
                        break;
                    }
                    mensajeRecibido += readLine + "\n";
                    mensajeFuncProc += readLine + " ";
                    System.out.println(">>>> " + readLine);
                }
                memoria.cod_client= mensajeRecibido;
                memoria.cod_client_sin_saltos = mensajeFuncProc;

                //Aqui mandar a analizar el mensaje recibido en la variable mensajeRecibido
                analizar a = new analizar();
                a.iniciarEjecucion();

                //Luego la respuesta del analisis enviarla de regreso

                /*Envía Mensaje*/
                DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream());
                mensaje.writeUTF("Mensaje prueba\nlinea 2\n");
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
