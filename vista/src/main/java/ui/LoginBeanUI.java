/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import helper.LoginHelper;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import macrocombo.sauap.entity.Administrador;

import java.io.IOException;
import java.io.Serializable;

@Named("loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable{
    private LoginHelper loginHelper;
    private Administrador administrador;
    
    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }
    
    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init(){
        administrador= new Administrador();
    }

     public void login() throws IOException{
        String appURL = "/index.xhtml";
        // los atributos de administrador vienen del xhtml 
        Administrador us= new Administrador();
        us.setId(0);
        us = loginHelper.Login(administrador.getNombreUsuario(), administrador.getContrasena());
          if(us != null && us.getId()!=null){
            // asigno el administrador encontrado al administrador de esta clase para que 
            // se muestre correctamente en la pagina de informacion
            administrador=us;
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Administrador o contraseña incorrecta:", "Intente de nuevo"));
        }
    }

    
    /* getters y setters*/

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
    
    
    
    
    
    

    

    
}