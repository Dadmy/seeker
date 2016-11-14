/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhing.model.dao;

import java.util.List;
import org.hibernate.Session;
import softhing.model.User;
import softhing.model.util.HibernateUtil;

/**
 *
 * @author Armando
 */
public class UserDao extends Dao<User> {
    
    public UserDao() {
        
    }

    @Override
    public List<User> listarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> objects = session.createQuery("FROM User").list();
            
        session.getTransaction().commit();
        session.close();
        
        return objects;
    }
    
}
