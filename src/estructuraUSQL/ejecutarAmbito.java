/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

import DDL.alter;
import DDL.eliminar;
import DML.insert;
import archivos.memoria;
import consola.principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author anick
 */
public class ejecutarAmbito {

    Date date = new Date();
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    ArrayList<simbolo> tablaSimbolo = new ArrayList<simbolo>();

    public ejecutarAmbito(ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
    }

    public void popAmbito() {
        pilaVariable tU = new pilaVariable();
        for (int i = tablaSimbolo.size() - 1; i >= 0; i--) {
            if (tablaSimbolo.get(i).rol.equals("DECLARACION")) {
                declaracion decla = (declaracion) tablaSimbolo.get(i).valor;
                tU.popVariable(decla.nombre);
            }
        }
    }

    public ArrayList<simbolo> getTablaSimbolo() {
        return tablaSimbolo;
    }

    public void setTablaSimbolo(ArrayList<simbolo> tablaSimbolo) {
        this.tablaSimbolo = tablaSimbolo;
    }

    public void secuenciaEjecucion() {
        for (int i = 0; i < tablaSimbolo.size(); i++) {
            if (memoria.DETENER == false && memoria.RETORNA == false && tablaSimbolo.get(i) != null) {
                switch (tablaSimbolo.get(i).tipo) {
                    case "RETORNAR":
                        expresion exp = (expresion) tablaSimbolo.get(i).valor;
                        exp = exp.resCondicion();
                        variable vab = new variable("RETORNO", "RETORNO", "VARIABLE", tablaSimbolo.get(i).fila, tablaSimbolo.get(i).fila, tablaSimbolo.get(i).ambito, exp);
                        memoria.tablaVariables.add(vab);
                        memoria.RETORNA = true;
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN RETORNAR");
                        break;
                    case "INSERTAR":
                        break;
                    case "ACTUALIZAR":
                        break;
                    case "BORRAR":
                        break;
                    case "SELECCIONAR":
                        break;
                    case "DECLARACION":
                        declaracion decla = (declaracion) tablaSimbolo.get(i).valor;
                        decla.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN DECLARACION");
                        break;
                    case "ASIGNACION":
                        asignacion asi = (asignacion) tablaSimbolo.get(i).valor;
                        asi.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN ASIGNACION");
                        break;
                    case "SI":
                        si s = (si) tablaSimbolo.get(i).valor;
                        s.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN SI");
                        break;
                    case "SELECCIONA":
                        selecciona sele = (selecciona) tablaSimbolo.get(i).valor;
                        sele.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN SELECCIONA");
                        break;
                    case "PARA":
                        para pa = (para) tablaSimbolo.get(i).valor;
                        pa.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN PARA");
                        break;
                    case "MIENTRAS":
                        mientras mien = (mientras) tablaSimbolo.get(i).valor;
                        mien.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN MIENTRAS");
                        break;
                    case "DETENER":
                        memoria.DETENER = true;
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN DETENER");
                        break;
                    case "METODO":
                        metodo met = (metodo) tablaSimbolo.get(i).valor;
                        met.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN METODO");
                        break;
                    case "IMPRIMIR":
                        imprimir imp = (imprimir) tablaSimbolo.get(i).valor;
                        imp.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN IMPRIMIR");
                        break;
                    case "USAR_BD":
                        String nombre = (String) tablaSimbolo.get(i).valor;
                        if (memoria.existsBD(nombre)) {
                            memoria.use_db = nombre;
                            usqldump u = new usqldump();
                            u.ejecucion();
                        } else {
                            memoria.addError("ERROR BD ", "No existe BD " + nombre, tablaSimbolo.get(i).fila, tablaSimbolo.get(i).fila);
                            memoria.use_db = "";
                        }
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN USAR DB");
                        break;
                    case "LLAMADA_METODO":
                        llamadaMetodo llame = (llamadaMetodo) tablaSimbolo.get(i).valor;
                        llame.ejecucion();
                         principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN LLAMAR METODO");
                        break;
                    case "CREAR":
                        EjecucionCreate ec = (EjecucionCreate) tablaSimbolo.get(i).valor;
                        ec.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN CREAR OBJETO BD");
                        break;
                    case "INSERT":
                        insert ins = (insert) tablaSimbolo.get(i).valor;
                        ins.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN INSERTAR");
                        break;
                    case "ALTER":
                        alter alt = (alter) tablaSimbolo.get(i).valor;
                        alt.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN ALTERAR OBJETO BD");
                        break;
                    case "ELIMINAR":
                        eliminar eli = (eliminar) tablaSimbolo.get(i).valor;
                        eli.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN ELIMINAR OBJETO BD");
                        break;
                    case "BACKUP":
                        backup back = (backup) tablaSimbolo.get(i).valor;
                        back.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN BACKUP PARCIAL ");
                        break;
                    case "SELECT":
                        select se = (select) tablaSimbolo.get(i).valor;
                        se.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN SELECCIONAR TABLA");
                        break;
                    case "UPDATE":
                        actualizar up = (actualizar) tablaSimbolo.get(i).valor;
                        up.ejecucion();
                        principal.imprimir(hourFormat.format(date) + " INSTRUCCIÓN UPDATE TABLA");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
