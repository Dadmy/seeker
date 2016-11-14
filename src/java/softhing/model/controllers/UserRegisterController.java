/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhing.model.controllers;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import softhing.model.Person;
import softhing.model.User;
import softhing.model.util.HibernateUtil;

/**
 *
 * @author Armando
 */
@ManagedBean
@SessionScoped
public class UserRegisterController {

    private String usuario;
    private String email;
    private String facultad;
    private String password;
    private String numeroCuenta;

    public UserRegisterController() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void registrar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Person p = new Person(usuario, usuario, email, password, new Date(), new Date());

        session.save(p);

        User u = new User();
        u.setFaculty(facultad);
        u.setAccountNumber(Integer.parseInt(numeroCuenta));
        u.setCreatedAt(new Date());
        u.setUpdatedAt(new Date());

        u.setPerson(p);

        session.save(u);

        session.getTransaction().commit();
        session.close();

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Usuario agregado!", ""));

        email = numeroCuenta = password = usuario = "";
        facultad = "Facultad de Arquitectura";
    }
}
