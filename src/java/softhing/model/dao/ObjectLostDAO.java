/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhing.model.dao;

import java.util.Date;
import java.util.Set;
import org.hibernate.Session;
import softhing.model.Form;
import softhing.model.ObjectLossed;
import softhing.model.Publish;
import softhing.model.User;
import softhing.model.util.HibernateUtil;

/**
 *
 * @author Armando
 */
public class ObjectLostDAO {
    public static void registrarObjeto(User usuario, ObjectLossed objeto, Set<Form> preguntas){
        Publish publish = new Publish(new Date(), new Date());
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        objeto.setUser(usuario);
        session.save(objeto);
        
        publish.setUser(usuario);
        publish.setObjectLossed(objeto);
        
        session.save(publish);
        
        for (Form pregunta : preguntas) {
            pregunta.setPublish(publish);
            session.save(pregunta);
        }
        
        session.getTransaction().commit();
        session.close();
    }
    
}
