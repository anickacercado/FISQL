/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author anick
 */
public class receiveMessage extends Thread {

    public void run() {
        while (true) {
            System.out.println("Entra Hilo...");
            try {
                ServerSocket serverSo = new ServerSocket(9770);
                Socket socket = new Socket();
                System.out.println("Esperando Respuesta...");

                /*Recibe Mensaje*/
                socket = serverSo.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Conexion con Cliente");

                String mensajeRecibido = entrada.readLine();
                System.out.println(mensajeRecibido);

                /*Envía Mensaje*/
                DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream());
                mensaje.writeUTF("Mensaje prueba");
                System.out.println("Mensaje Enviado...");

                serverSo.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }
        }
    }

}
