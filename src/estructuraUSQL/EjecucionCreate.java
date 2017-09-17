/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraUSQL;
import DDL.create;
import archivos.db.propertyField;
import archivos.memoria;
import archivos.parametro;
import archivos.tabla.table;
import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class EjecucionCreate {
    
    create cre= new create();
    public String tipo;      //CREARBD,CREAROBJETO,CREARTABLA,CREARUSUARIO
    public String nombre_bd; //usuario
    public String nombre;    //contraseña
    public Object parametros;
    public ambito ambito;

    public EjecucionCreate(String tipo, String nombre_bd, String nombre, Object parametros, ambito ambito) {
        this.tipo = tipo;
        this.nombre_bd = nombre_bd;
        this.nombre = nombre;
        this.parametros = parametros;
        this.ambito = ambito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre_bd() {
        return nombre_bd;
    }

    public void setNombre_bd(String nombre_bd) {
        this.nombre_bd = nombre_bd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getParametros() {
        return parametros;
    }

    public void setParametros(Object parametros) {
        this.parametros = parametros;
    }

    public ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(ambito ambito) {
        this.ambito = ambito;
    }
    
    public ArrayList<parametro> lista_para() {
        ArrayList<parametro> para = new ArrayList<parametro>();
        ArrayList<parametro> p= (ArrayList<parametro>) parametros;
        for (int i = 0; i < p.size(); i++) {
            cre.insertParametro(para, p.get(i).getNombre(), p.get(i).getTipo());
        }
        return para;
    }
    
      public ArrayList<table> lista_table() {
        ArrayList<table> tab = new ArrayList<table>();
        ArrayList<propertyField> p= (ArrayList<propertyField>) parametros;
        for (int i = 0; i < p.size(); i++) {
            cre.insertColumn(tab, p.get(i).getNombre(), p.get(i).getTipo().toUpperCase(), p.get(i).getNulo(),p.get(i).getNo_nulo(), p.get(i).getAutoincrementable(), p.get(i).getLlave_primaria(), p.get(i).getLlave_foranea());
        }
        return tab;
    }
    
    public void ejecucion(){   
        switch (tipo) {
            case "CREARBD":
                cre.crearBD(nombre_bd);
                break;
            case "CREAROBJETO":
                cre.CrearObjeto(memoria.use_db, nombre, lista_para());
                break;
            case "CREARUSUARIO":
                cre.createUsuario(nombre_bd, nombre, "user");
                break;
            case "CREARTABLA":
                cre.CrearTable(memoria.use_db, nombre, lista_table());
                break;
            default:
                break;
        }     
    }
}
