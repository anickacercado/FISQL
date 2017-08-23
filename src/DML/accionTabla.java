/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DML;
import  archivos.tabla.*;
import java.util.ArrayList;

/**
 *
 * @author 3plgtanickacf
 */
public class accionTabla {
    
    public boolean insertTable(ArrayList<table> tabla, String nombre_campo, String valor){
        int fila=0;    
       //Se inserta el registro
        for(int i=0;i< tabla.size();i++){
            if(tabla.get(i).nombre_campo.equals(nombre_campo)){
                fila= tabla.get(i).registro.size();
                fila_tabla ft= new fila_tabla(fila,valor);
                tabla.get(i).registro.add(ft);
                return true;
            }
        }
        
        //Se inserta el primer registro
        fila_tabla ft= new fila_tabla(fila,valor);
        ArrayList<fila_tabla> reg= new ArrayList<fila_tabla>();
        reg.add(ft);
        table t = new table(nombre_campo,reg,false,null);
        tabla.add(t);
        return true;
    }
    
    public boolean insertTableObject(ArrayList<table> tabla, String nombre_campo, ArrayList<registro_objeto> ro){
         
        int fila=0;
        //Se inserta el registro
        for(int i=0;i< tabla.size();i++){
            if(tabla.get(i).nombre_campo.equals(nombre_campo) && tabla.get(i).es_objeto==true){
                
                fila= tabla.get(i).registro_objeto.size();
                fila_tabla_objeto fto= new fila_tabla_objeto(fila,ro);               
                tabla.get(i).registro_objeto.add(fto);
                return true;
            }
        }
        
        //Se inserta el primer registro
         fila_tabla_objeto fto= new fila_tabla_objeto(fila,ro);
         ArrayList<fila_tabla_objeto> reg_obj= new ArrayList<fila_tabla_objeto>();
         reg_obj.add(fto);
         table t = new table(nombre_campo,null,true,reg_obj);
         tabla.add(t);   
        return true;
    }    
}
