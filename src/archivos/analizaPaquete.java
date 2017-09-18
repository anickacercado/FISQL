/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import archivos.usuario.permisos;
import archivos.usuario.user;
import consola.principal;
import estructuraUSQL.analizar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import paquetes.ParseException;
import paquetes.paquete;
import usql.analizador;

/**
 *
 * @author anick
 */
public class analizaPaquete {

    public void analizar() {
        paquete g = new paquete(new java.io.StringReader(memoria.cod_client));
        try {
            g.S();
        } catch (ParseException ex) {
            // Logger.getLogger(analizaPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        analiza();
    }

    private String respuesta = "";

    public void analiza() {
        switch (memoria.paquetePly) {
            case "LOGIN":
                login();
                break;
            case "FIN":
                memoria.limpiar();
                break;
            case "USQL":
                usql();
                break;
            case "REPORTE":
                reporte();
                break;
            default:
                break;
        }
    }

    public void login() {
        if (existsUsuario(memoria.usrPly, memoria.passPly)) {
            respuesta = "[\n"
                    + "  \"validar\":\"1500\",\n"
                    + "  \"login\":\"true\"\n"
                    + "]";
        } else {
            respuesta = "[\n"
                    + "  \"validar\":\"1500\",\n"
                    + "  \"login\":\"false\"\n"
                    + "]";

        }
        memoria.respuestaPly = respuesta;
    }

    public boolean existsUsuario(String usuario, String contrasenia) {
        for (int i = 0; i < memoria.arbolUsuario.size(); i++) {
            if (memoria.arbolUsuario.get(i).getNombre().equals(usuario) && memoria.arbolUsuario.get(i).getPass().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public void usql() {
        String datos = "";
        String ejecucion = "";
        String mensaje = "";
        String historial = "";

        memoria.cod_client_sin_saltos = memoria.codigoPly;
        analizar a = new analizar();
        a.iniciarEjecucion();

        if (memoria.lista_de_select != null && memoria.lista_de_select.size() != 0) {
            datos =  memoria.lista_de_select.get(memoria.lista_de_select.size() - 1).codigo ;
        }

        for (int i = 0; i < memoria.tablaErroresUSQL.size(); i++) {
            ejecucion += " TIPO " + memoria.tablaErroresUSQL.get(i).getTipo()
                    + " DESCRIPCION " + memoria.tablaErroresUSQL.get(i).getDescripcion()
                    + " LINEA " + memoria.tablaErroresUSQL.get(i).getLinea()
                    + " COLUMNA " + memoria.tablaErroresUSQL.get(i).getColumna()
                    ;
        }
        
        
        mensaje = principal.getText();
            
                
        respuesta = "["
                + "\n \"paquete\":" + "\"usql\"" + ","
                + "\n \"datos\":   \"" + datos.replace("\"","\\\"").replace("\n","\\n") + "\","
                + "\n \"ejecucion\": \"" + ejecucion.replace("\"","\\\"").replace("\n","\\n") + "\","
                + "\n \"mensaje\":  \"" + mensaje.replace("\"","\\\"").replace("\n","\\n") + "\","
                + "\n \"historial\": \"" + historial.replace("\"","\\\"").replace("\n","\\n") + "\""
                + "]";
        System.out.println(respuesta);
        memoria.respuestaPly = respuesta;
    }

    public void reporte() {
        String instruccion = "";

        memoria.cod_client_sin_saltos = memoria.codigoPly;
        analizar a = new analizar();
        a.iniciarEjecucion();

        if (memoria.lista_de_select != null) {
            instruccion =   memoria.lista_de_select.get(memoria.lista_de_select.size() - 1).codigo ;
        }

        respuesta = "["
                + "\n\"paquete\": \"reporte\","
                + "\n\"datos\":" + "\"" + instruccion.replace("\n","\\n") + "\""
                + "]";
        memoria.respuestaPly = respuesta;
    }
    
    public void arbol(){
    
    
    }
}
