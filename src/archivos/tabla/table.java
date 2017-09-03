/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.tabla;

import java.util.ArrayList;

/**
 *
 * @author anick
 */
public class table {

    private String nombre_campo;
    private String tipo;
    private String nulo;
    private String no_nulo;
    private String autoincrementable;
    private String llave_primaria;
    private String llave_foranea;
    private ArrayList<fila_tabla> registro = new ArrayList<fila_tabla>();
    private boolean es_objeto;
    private ArrayList<fila_tabla_objeto> registro_objeto = new ArrayList<fila_tabla_objeto>();

    //table t= new table(nombre_param,"INTEGER",nulo,no_nulo,autoincrementable,llave_primaria,llave_foranea,registro,false,null);
    public table(String nombre_campo,
            String tipo,
            String nulo,
            String no_nulo,
            String autoincrementable,
            String llave_primaria,
            String llave_foranea,
            ArrayList<fila_tabla> registro,
            boolean es_objeto,
            ArrayList<fila_tabla_objeto> registro_objeto) {

        this.nombre_campo = nombre_campo;
        this.tipo = tipo;
        this.nulo = nulo;
        this.no_nulo = no_nulo;
        this.autoincrementable = autoincrementable;
        this.llave_primaria = llave_primaria;
        this.llave_foranea = llave_foranea;
        this.registro = registro;
        this.es_objeto = es_objeto;
        this.registro_objeto = registro_objeto;

    }

    public String Create_XML() {
        String cadena = "";
        cadena += "<field>\n"
                + "\t<" + tipo + ">\"" + nombre_campo + "\"</" + tipo + ">\n"
                + "\t<property>\n"
                + "\t<nulo>\"" + nulo + "\"</nulo>\n"
                + "\t<no_nulo>\"" + no_nulo + "\"</no_nulo>\n"
                + "\t<autoincrementable>\"" + autoincrementable + "\"</autoincrementable>\n"
                + "\t<llave_primaria>\"" + llave_primaria + "\"</llave_primaria>\n"
                + "\t<llave_foranea>\"" + llave_foranea + "\"</llave_foranea>\n"
                + "\t</property>\n"
                + "\t</field>\n";
        return cadena;
    }

    public void addRegistro(fila_tabla ft) {
        registro.add(ft);
    }

    public void addRegistroObjeto(fila_tabla_objeto fto) {
        registro_objeto.add(fto);
    }

    public String XML(int fila) {
        String cadena = "";
        if (es_objeto) {
            cadena += "\t<" + nombre_campo + ">\n"
                    + registro_objeto.get(fila).XML()
                    + "\t</" + nombre_campo + ">\n";

        } else {
            cadena += "\t<" + nombre_campo + ">\"" + registro.get(fila).getValor() + "\"</" + nombre_campo + ">\n";
        }
        return cadena;
    }

    public int noFila() {
        return registro.size();
    }

    public String getNombre_campo() {
        return nombre_campo;
    }

    public void setNombre_campo(String nombre_campo) {
        this.nombre_campo = nombre_campo;
    }

    public ArrayList<fila_tabla> getRegistro() {
        return registro;
    }

    public void setRegistro(ArrayList<fila_tabla> registro) {
        this.registro = registro;
    }

    public boolean isEs_objeto() {
        return es_objeto;
    }

    public void setEs_objeto(boolean es_objeto) {
        this.es_objeto = es_objeto;
    }

    public ArrayList<fila_tabla_objeto> getRegistro_objeto() {
        return registro_objeto;
    }

    public void setRegistro_objeto(ArrayList<fila_tabla_objeto> registro_objeto) {
        this.registro_objeto = registro_objeto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNulo() {
        return nulo;
    }

    public void setNulo(String nulo) {
        this.nulo = nulo;
    }

    public String getNo_nulo() {
        return no_nulo;
    }

    public void setNo_nulo(String no_nulo) {
        this.no_nulo = no_nulo;
    }

    public String getAutoincrementable() {
        return autoincrementable;
    }

    public void setAutoincrementable(String autoincrementable) {
        this.autoincrementable = autoincrementable;
    }

    public String getLlave_primaria() {
        return llave_primaria;
    }

    public void setLlave_primaria(String llave_primaria) {
        this.llave_primaria = llave_primaria;
    }

    public String getLlave_foranea() {
        return llave_foranea;
    }

    public void setLlave_foranea(String llave_foranea) {
        this.llave_foranea = llave_foranea;
    }

}
