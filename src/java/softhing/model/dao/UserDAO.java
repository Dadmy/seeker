package softhing.model.dao;

import org.hibernate.Session;
import softhing.model.Person;
import softhing.model.User;
import softhing.model.util.HibernateUtil;

public class UserDAO {
    
    public static void insertarUsuario(Person p, User u){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(p);

        u.setPerson(p);
        
        session.save(u);

        session.getTransaction().commit();
        session.close();
        
    }
    
    public static boolean validar(String email, String password) {
        Person u = consultarUsuarioPorMail(email);
        
        return u != null && u.getPassword().equals(password);
    }
    
    public static Person consultarUsuarioPorMail(String email) {
        Person u;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        u = (Person)session.createQuery(
                "FROM Person AS P WHERE P.email = '" + email + "'").uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return u;
    } 
    
    public static User consultarUsuario(Person p){
        User u;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        u = (User)session.createQuery(
                "FROM User AS U WHERE U.person.email = '" + p.getEmail() + "'").uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return u;
    }
    
    public static User consultarUsuarioPorNumeroCuenta(Integer numeroCuenta){
        User u;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        u = (User)session.createQuery(
                "FROM User AS U WHERE U.accountNumber = " + numeroCuenta).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        return u;
    }
    
}
