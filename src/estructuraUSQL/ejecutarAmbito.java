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
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class ejecutarAmbito {

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
                        break;
                    case "ASIGNACION":
                        asignacion asi = (asignacion) tablaSimbolo.get(i).valor;
                        asi.ejecucion();
                        break;
                    case "SI":
                        si s = (si) tablaSimbolo.get(i).valor;
                        s.ejecucion();
                        break;
                    case "SELECCIONA":
                        selecciona sele = (selecciona) tablaSimbolo.get(i).valor;
                        sele.ejecucion();
                        break;
                    case "PARA":
                        para pa = (para) tablaSimbolo.get(i).valor;
                        pa.ejecucion();
                        break;
                    case "MIENTRAS":
                        mientras mien = (mientras) tablaSimbolo.get(i).valor;
                        mien.ejecucion();
                        break;
                    case "DETENER":
                        memoria.DETENER = true;
                        break;
                    case "METODO":
                        metodo met = (metodo) tablaSimbolo.get(i).valor;
                        met.ejecucion();
                        break;
                    case "IMPRIMIR":
                        imprimir imp = (imprimir) tablaSimbolo.get(i).valor;
                        imp.ejecucion();
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
                        break;
                    case "LLAMADA_METODO":
                        llamadaMetodo llame = (llamadaMetodo) tablaSimbolo.get(i).valor;
                        llame.ejecucion();
                        break;
                    case "CREAR":
                        EjecucionCreate ec = (EjecucionCreate) tablaSimbolo.get(i).valor;
                        ec.ejecucion();
                        break;
                    case "INSERT":
                        insert ins = (insert) tablaSimbolo.get(i).valor;
                        ins.ejecucion();
                        break;
                    case "ALTER":
                        alter alt = (alter) tablaSimbolo.get(i).valor;
                        alt.ejecucion();
                        break;
                    case "ELIMINAR":
                        eliminar eli = (eliminar) tablaSimbolo.get(i).valor;
                        eli.ejecucion();
                        break;
                    case "BACKUP":
                        backup back = (backup) tablaSimbolo.get(i).valor;
                        back.ejecucion();
                        break;
                    case "SELECT":
                        select se = (select) tablaSimbolo.get(i).valor;
                        se.ejecucion();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
