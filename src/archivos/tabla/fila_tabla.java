/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.tabla;

/**
 *
 * @author anick
 */
public class fila_tabla {
    private int no_fila;
    private String valor;
    
    public fila_tabla(int no_fila, String valor){
        this.no_fila = no_fila;
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getNo_fila() {
        return no_fila;
    }

    public void setNo_fila(int no_fila) {
        this.no_fila = no_fila;
    }
}
