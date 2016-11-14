package softhing.model;

import java.util.ArrayList;
import java.util.List;

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
        }
        
        return objs;
    }
}
