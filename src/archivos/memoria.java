/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import archivos.maestro.master;
import archivos.usuario.user;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class memoria {
  
  //Path  
  public static String DB= "C:\\DBMS";
  public static String user= "C:\\DBMS\\user.xml";
  public static String maestro= "C:\\DBMS\\maestro.xml";     
  
  //Base de Datos
  public static ArrayList<user> arbolUsuario;
  public static ArrayList<master> arbolMaestro;

}
