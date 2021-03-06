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
import gramatica_HTML.ghtml;
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

    LecturaBD lectura = new LecturaBD();

    public void analizar() {
        lectura.leer();
        paquete g = new paquete(new java.io.StringReader(memoria.cod_client));
        try {
            g.S();
        } catch (ParseException ex) {
            Logger.getLogger(analizaPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        analiza();
    }

    private String respuesta = "";

    public void analiza() {
        switch (memoria.paquetePly) {
            case "LOGIN":
                login();
                memoria.limpiar();  
                break;
            case "FIN":
                arbol();
                memoria.limpiar();   
                break;
            case "USQL":
                usql();
                memoria.limpiar();  
                break;
            case "REPORTE":
                reporte();
                memoria.limpiar();  
                break;
            case "ARBOL":
                arbol();
                memoria.limpiar();  
                break;
            default:
                break;
        }
    }

    public void login() {
        if (existsUsuario(memoria.usrPly, memoria.passPly)) {
            respuesta = "{login:\"True\"  usr:\"" + memoria.usrPly + "\"}";
        } else {
            respuesta = "{login:\"False\"  usr:\"" + memoria.usrPly + "\"}";
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
        String comilla= String.valueOf((char)148);
        String carac= String.valueOf((char)155);
        String datos = "";
        String ejecucion = "";
        String mensaje = "";
        String historial = "";

        memoria.cod_client=memoria.codigoPly;
        memoria.cod_client_sin_saltos = memoria.codigoPly;
        analizar a = new analizar();
        a.iniciarEjecucion();

          for(int i=0; i<memoria.lista_de_select.size();i++) {
            datos += memoria.lista_de_select.get(i).codigo + " ";
        }


        for (int i = 0; i < memoria.tablaErroresUSQL.size(); i++) {
            ejecucion += "\n TIPO: " + memoria.tablaErroresUSQL.get(i).getTipo()
                    + " DESCRIPCION: " + memoria.tablaErroresUSQL.get(i).getDescripcion()
                    + " LINEA: " + memoria.tablaErroresUSQL.get(i).getLinea()
                    + " COLUMNA: " + memoria.tablaErroresUSQL.get(i).getColumna();
                    ejecucion = ejecucion.replace(comilla, "\\\"").replace(".", "").replace(carac, "");
            System.out.println(ejecucion);
        }

        mensaje = principal.getText();

        respuesta = "["
                + "\n \"paquete\":" + "\"usql\"" + ","
                + "\n \"datos\":   \"" + datos.replace("\"", "\\\"") + "\","
                + "\n \"ejecucion\": \"" + ejecucion.replace("\"", "\\\"").replace("\r\n", "\\n").replace("\n", "\\n") + "\","
                + "\n \"mensaje\":  \"" + mensaje.replace("\"", "\\\"").replace("\n", "\\n") + "\","
                + "\n \"historial\": \"" + historial.replace("\"", "\\\"").replace("\n", "\\n") + "\""
                + "]";
        System.out.println(respuesta);
        memoria.respuestaPly = limpiar_cadena(respuesta);
    }

    public void reporte() {
        String instruccion = "";
        
        ghtml g = new ghtml(new java.io.StringReader(memoria.codigoPly));
        try {
            g.S();
        } catch (gramatica_HTML.ParseException ex) {
            //Logger.getLogger(probarGramatica.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        memoria.cod_client_sin_saltos = memoria.codigoHTML;
        memoria.cod_client=memoria.codigoHTML;
        analizar a = new analizar();
        a.iniciarEjecucion();

        for(int i=0; i<memoria.lista_de_select.size();i++) {
            instruccion += memoria.lista_de_select.get(i).codigo + " ";
        }

        respuesta = "["
                + "\n\"paquete\": \"reporte\","
                + "\n\"datos\":" + "\"" + instruccion.replace("\"", "\\\"").replace("\n", "\n\\n")+ "\""
                + "]";
        memoria.respuestaPly = limpiar_cadena(respuesta);
    }

    public void arbol() {
        String cadena;
        cadena = "\n{";
        cadena += "\n\"databases\": [";
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (i == memoria.arbolMaestro.size() - 1) {
                cadena += memoria.arbolMaestro.get(i).ARBOL();
            } else {
                cadena += memoria.arbolMaestro.get(i).ARBOL() + ",";
            }
        }
        cadena += "\n],";
        //usuario
        cadena += "\n\"users\":[";
        for (int i = 0; i < memoria.arbolUsuario.size(); i++) {
            if (i == memoria.arbolUsuario.size() - 1) {
                cadena +=  "\""+memoria.arbolUsuario.get(i).getNombre()+ "\"";
            } else {
                cadena +=  "\""+memoria.arbolUsuario.get(i).getNombre() + "\""+ ",";
            }
        }
        cadena += "]\n}";
        memoria.respuestaPly = cadena;
    }
    
    public String limpiar_cadena(String cadena) {
        String variable = cadena;
        variable = variable.replace("Ó", "O");
        variable = variable.replace("Á", "A");
        variable = variable.replace("É", "E");
        variable = variable.replace("Í", "I");
        variable = variable.replace("Ú", "U");
        variable = variable.replace("ó", "o");
        variable = variable.replace("á", "a");
        variable = variable.replace("é", "e");
        variable = variable.replace("í", "i");
        variable = variable.replace("ú", "u");
        variable = variable.replace("[", "{");
        variable = variable.replace("]", "}");
        variable = variable.replace("ñ", "n");
        return variable;
    }
}
