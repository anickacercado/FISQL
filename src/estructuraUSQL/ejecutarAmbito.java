/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;

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

    public void secuenciaEjecucion() {
        for (int i = 0; i < tablaSimbolo.size(); i++) {
            switch (tablaSimbolo.get(i).tipo) {
                case "RETORNAR":
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
                    break;
                case "METODO":
                    break;
                case "IMPRIMIR":
                    imprimir imp = (imprimir) tablaSimbolo.get(i).valor;
                    imp.ejecucion();
                    break;
                default:
                    break;
            }
        }
    }

    public void popAmbito() {
        tablaUSQL tU= new tablaUSQL();
        for(int i= tablaSimbolo.size() - 1; i>=0; i--)
            if (tablaSimbolo.get(i).rol.equals("DECLARACION")) {
                    tU.popVariable(tablaSimbolo.get(i).nombre);
            }
        }        
}
