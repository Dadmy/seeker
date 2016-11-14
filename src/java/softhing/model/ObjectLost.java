/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhing.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armando
 */
public class ObjectLost extends ObjectLossed {
    private String lugar;
    private String descripcion;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public static List<ObjectLost> listarObjetos(List<ObjectLossed> objetos){
        List<ObjectLost> objs = new ArrayList<>();
        
        for (ObjectLossed objeto : objetos) {
            ObjectLost obj = new ObjectLost();
            obj.setCreatedAt(objeto.getCreatedAt());
            obj.setUpdatedAt(objeto.getUpdatedAt());
            obj.setClass_(objeto.getClass_());
            obj.setSubclass(objeto.getSubclass());
            
            String datos[] = objeto.getName().split("@");
            obj.setName(datos[0]);
            obj.setDescripcion(datos[1]);
            obj.setLugar(datos[2]);
            
            objs.add(obj);
            System.out.println(objeto.getName());
            System.out.println(obj.getLugar());
            System.out.println(obj.getName());
        }
        
        return objs;
    }
}
