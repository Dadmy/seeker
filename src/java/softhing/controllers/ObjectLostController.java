/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softhing.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import softhing.controllers.util.SessionUtils;
import softhing.model.Form;
import softhing.model.ObjectLossed;
import softhing.model.User;
import softhing.model.dao.ObjectLostDAO;
import softhing.model.dao.UserDAO;
import softhing.model.util.HibernateUtil;

@ManagedBean
@SessionScoped
public class ObjectLostController {
    private List<ObjectLossed> objetos;
    private ObjectLossed objetoSeleccionado;
    
    /**
     * Creates a new instance of ObjectLostController
     */
    public ObjectLostController() {
        inicializarLista();
    }
    
    public void inicializarLista(){
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
 
    /*****Para la parte del registro******************************************/
    private String nombre;
    private String descripcion;
    private String categoria;
    private String subcategoria;
    private String fecha;
    private String lugar;
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
    private String pregunta4;
    private String pregunta5;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public String getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(String pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public String getPregunta4() {
        return pregunta4;
    }

    public void setPregunta4(String pregunta4) {
        this.pregunta4 = pregunta4;
    }

    public String getPregunta5() {
        return pregunta5;
    }

    public void setPregunta5(String pregunta5) {
        this.pregunta5 = pregunta5;
    }
    
    public String registrar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        Object email = SessionUtils.getEmail();
        
        if(email == null || email.equals("")){
            context.addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, 
                            "Inicie sesión", "Inicie sesión o registrese para agregar objetos"));
            return "login";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d = null;
        try {
            d = sdf.parse(fecha);
        } catch (ParseException ex) {
            context.addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, 
                            "Formato de fecha incorrecto", "Introduzca la fecha con el formato  dd-MM-yyyy"));
            return "objetoRegistrar";
        }
        
        User u = UserDAO.consultarUsuario(UserDAO.consultarUsuarioPorMail(email.toString()));
        
        ObjectLossed o = new ObjectLossed();
        o.setCreatedAt(d);
        o.setUpdatedAt(d);
        o.setName(nombre + "|" + descripcion + "|" + lugar);
        o.setClass_(categoria);
        o.setSubclass(subcategoria);
        
        Set<Form> set = new HashSet<>();
        Form f;
        if(pregunta1 != null && !pregunta1.equals("")){
            f =new Form(pregunta1, new Date(), new Date());
            set.add(f);
        }
        if(pregunta2 != null && !pregunta2.equals("")){
            f =new Form(pregunta2, new Date(), new Date());
            set.add(f);
        }
        if(pregunta3 != null && !pregunta3.equals("")){
            f =new Form(pregunta3, new Date(), new Date());
            set.add(f);
        }
        if(pregunta4 != null && !pregunta4.equals("")){
            f =new Form(pregunta4, new Date(), new Date());
            set.add(f);
        }
        if(pregunta5 != null && !pregunta5.equals("")){
            f =new Form(pregunta5, new Date(), new Date());
            set.add(f);
        }
        
        ObjectLostDAO.registrarObjeto(u, o, set);
        
        context.addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                            "Objeto Registrado", ""));
        
        inicializarLista();
        
        return "index";
    }
}
