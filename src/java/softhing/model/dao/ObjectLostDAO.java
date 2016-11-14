package softhing.model.dao;

import java.util.Date;
import java.util.Set;
import org.hibernate.Session;
import softhing.model.Form;
import softhing.model.ObjectLossed;
import softhing.model.Publish;
import softhing.model.User;
import softhing.model.util.HibernateUtil;

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
