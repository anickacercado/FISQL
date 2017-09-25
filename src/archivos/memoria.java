/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import archivos.maestro.master;
import archivos.usuario.user;
import consola.principal;
import errores.error;
import estructuraUSQL.seleccionaTabla;
import estructuraUSQL.variable;
import estructuraUSQL.tablaMetodo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class memoria {

    //Path  
    public static String DB = "C:\\DBMS";
    public static String user = "C:\\DBMS\\user.xml";
    public static String maestro = "C:\\DBMS\\maestro.xml";
    public static String backup = "C:\\BACKUP";
    public static String backupUsuario = "C:\\BACKUPUSUARIO";

    //Base de Datos
    public static ArrayList<user> arbolUsuario = new ArrayList<user>();
    public static ArrayList<master> arbolMaestro = new ArrayList<master>();
    public static String Insert_db_actual = "";
    public static String Insert_table_actual = "";

    public static String use_db = "";
    public static String cod_client_sin_saltos = "";
    public static String cod_client = "";

    public static int posIni = 0;
    public static int posFin = 0;

    //Fechas
    public static DateFormat formatDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static DateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

    //Errores USQL
    public static ArrayList<error> tablaErroresUSQL = new ArrayList<error>();

    public static boolean contarError() {
        return tablaErroresUSQL.size() == 0;
    }

    public static void limpiarError() {
        tablaErroresUSQL = new ArrayList<error>();
    }

    public static void addError(String tipo, String descripcion, int linea, int columna) {
        error e = new error(tipo, descripcion, linea, columna);
        memoria.tablaErroresUSQL.add(e);
    }

    //Tablas
    public static ArrayList<variable> tablaVariables = new ArrayList<variable>();
    public static ArrayList<tablaMetodo> tablaMetodo = new ArrayList<tablaMetodo>();

    //Detener - Retorna
    public static boolean DETENER = false;
    public static boolean RETORNA = false;

    public static boolean existsBD(String nombre) {
        for (int i = 0; i < memoria.arbolMaestro.size(); i++) {
            if (memoria.arbolMaestro.get(i).getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    //Select
    public static seleccionaTabla select = null;
    public static seleccionaTabla select_union = null;
    public static seleccionaTabla updateTabla = null;

    public static int posicion = 0;
    public static int tipoDetransaccion = 0;
    public static ArrayList<seleccionaTabla> lista_de_select = new ArrayList<seleccionaTabla>();
    public static ArrayList<String> mensaje_consola = new ArrayList<String>();

    public static String paquetePly = "";
    public static String codigoPly = "";
    public static String usrPly = "";
    public static String passPly = "";
    public static String respuestaPly = "";
    public static String codigoHTML = "";

    public static void limpiar() {
        principal.limpiarConsola();
        posicion = 0;
        tipoDetransaccion = 0;
        lista_de_select = new ArrayList<seleccionaTabla>();
        mensaje_consola = new ArrayList<String>();
        tablaVariables = new ArrayList<variable>();
        DETENER = false;
        RETORNA = false;
        tablaErroresUSQL = new ArrayList<error>();

        Insert_db_actual = "";
        Insert_table_actual = "";

        cod_client_sin_saltos = "";
        cod_client = "";
        posIni = 0;
        posFin = 0;
        paquetePly = "";
        codigoPly = "";
        usrPly = "";
        passPly = "";
        codigoHTML = "";
    }

}
