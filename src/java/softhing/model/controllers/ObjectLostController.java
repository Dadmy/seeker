/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhing.model.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import softhing.model.ObjectLossed;
import softhing.model.util.HibernateUtil;

/**
 *
 * @author Armando
 */
@ManagedBean
@SessionScoped
public class ObjectLostController {
    private List<ObjectLossed> objetos;
    private ObjectLossed objetoSeleccionado;
    
    /**
     * Creates a new instance of ObjectLostController
     */
    public ObjectLostController() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        objetos = session.createQuery("from ObjectLossed").list();
        
        session.getTransaction().commit();
        session.close();
    }

    public List<ObjectLossed> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<ObjectLossed> objetos) {
        this.objetos = objetos;
    }

    public ObjectLossed getObjetoSeleccionado() {
        return objetoSeleccionado;
    }

    public void setObjetoSeleccionado(ObjectLossed objetoSeleccionado) {
        this.objetoSeleccionado = objetoSeleccionado;
    }
    
}
