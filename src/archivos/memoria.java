/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import archivos.maestro.master;
import archivos.usuario.user;
import errores.error;
import estructuraUSQL.variable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
  public static ArrayList<user> arbolUsuario = new ArrayList<user>();
  public static ArrayList<master> arbolMaestro = new  ArrayList<master>();
  public static String Insert_db_actual = "";
  public static String Insert_table_actual = "";
  
  //Fechas
  public static DateFormat formatDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  public static DateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
  
  //Errores USQL
  public static ArrayList<error> tablaErroresUSQL = new ArrayList<error>();
  
    public static boolean contarError() {
        return tablaErroresUSQL.size()== 0;
    }

    public static void limpiarError() {
        tablaErroresUSQL = new ArrayList<error>();
    }
    public static void addError(String tipo, String descripcion, int linea, int columna){  
        error e = new error(tipo,descripcion,linea,columna);
        memoria.tablaErroresUSQL.add(e);
    }
    
    //Tabla variable
    public static ArrayList<variable> tablaVariables= new ArrayList<variable>();
    
    //Detener - Retorna
    public static boolean DETENER =false;
    public static boolean RETORNA =false;
  
}
