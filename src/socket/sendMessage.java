/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author anick
 */
public class sendMessage extends Thread {

    public void run() {
        while (true) {
            try {
                Socket socket = new Socket("localhost", 9770);
                System.out.println("Intentando enviar...");
                DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream());
                mensaje.writeUTF("Mensaje prueba");
                System.out.println("Mensaje enviado...");
                socket.close();
                
                

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
