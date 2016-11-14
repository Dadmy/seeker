/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhing.model.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import softhing.model.User;
import softhing.model.util.HibernateUtil;

/**
 *
 * @author Armando
 */
public abstract class Dao<T> {

    public void insertar(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(t);
        session.getTransaction().commit();
        session.close();
    }
//    boolean actualizar(T t);
//    boolean borrar(T t);

    public abstract List<T> listarTodos();
}
