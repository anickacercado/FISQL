/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

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
                tU.popVariable(tablaSimbolo.get(i).nombre);
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
            if (memoria.DETENER == false && memoria.RETORNA==false && tablaSimbolo.get(i) != null) {
                switch (tablaSimbolo.get(i).tipo) {
                    case "RETORNAR":
                        expresion exp= (expresion) tablaSimbolo.get(i).valor;
                        exp = exp.resCondicion();
                        variable vab = new variable("RETORNO", "RETORNO", "VARIABLE",tablaSimbolo.get(i).fila, tablaSimbolo.get(i).fila, tablaSimbolo.get(i).ambito , exp);
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
                        } else {
                            memoria.addError("ERROR BD ", "No existe BD " + nombre, tablaSimbolo.get(i).fila, tablaSimbolo.get(i).fila);
                            memoria.use_db = "";
                        }
                        break;
                    case "LLAMADA_METODO":
                        llamadaMetodo llame = (llamadaMetodo) tablaSimbolo.get(i).valor;
                        llame.ejecucion();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
