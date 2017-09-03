/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.db;

/**
 *
 * @author anick
 */
public class propertyField {
    
        private String nombre;
        private String tipo;
        private String nulo;
        private String no_nulo;
        private String autoincrementable;
        private String llave_primaria;
        private String llave_foranea;

    public propertyField(String nombre, String tipo, String nulo, String no_nulo, String autoincrementable, String llave_primaria, String llave_foranea) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nulo = nulo;
        this.no_nulo = no_nulo;
        this.autoincrementable = autoincrementable;
        this.llave_primaria = llave_primaria;
        this.llave_foranea = llave_foranea;
    }
    
       public String XML() {
        String cadena = "";
        cadena += "<field>\n"
                + "\t<"+tipo+">\"" + nombre + "\"</"+tipo+">\n"
                    + "\t<property>\n"
                        + "\t<nulo>\""+nulo+"\"</nulo>\n"
                        + "\t<no_nulo>\""+no_nulo+"\"</no_nulo>\n"
                        + "\t<autoincrementable>\""+autoincrementable+"\"</autoincrementable>\n"
                        + "\t<llave_primaria>\""+llave_primaria+"\"</llave_primaria>\n"
                        + "\t<llave_foranea>\""+llave_foranea+"\"</llave_foranea>\n"
                    + "\t</property>\n"
                + "\t</field>\n";
        return cadena;
       }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
