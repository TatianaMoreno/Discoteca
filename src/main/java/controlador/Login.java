/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import logica.LogicaLogin;

/**
 *
 * @author AndresChila
 */
@ManagedBean(name = "userLoginView")
@SessionScoped
@Dependent
public class Login {
    private String username;
    private String password;
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    public String loguearse(){
        LogicaLogin logica = new LogicaLogin(username, password);
        logica.loguearse();
        return logica.getRedirecciona();
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
