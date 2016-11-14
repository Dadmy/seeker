package softhing.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import softhing.controllers.util.SessionUtils;
import softhing.model.Person;

import softhing.model.dao.UserDAO;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String password;
	private String msg;
	private String email;

    public LoginController() {
        msg = "Accede";
    }
        
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = UserDAO.validar(email, password);
		if (valid) {
                    
                        Person u = UserDAO.consultarUsuarioPorMail(email);
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", u.getUsername());
                        session.setAttribute("email", u.getEmail());
                        
                        FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Bienvenido",
							u.getUsername()));
                        msg = "Salir";
                        
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuario o Password incorrectos",
							"Introduzca usuario y password correctos"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
        
        public String loginLogout() {
            if(msg.equals("Accede"))
                return "login";
            
            msg = "Accede";
            return logout();
        }
}