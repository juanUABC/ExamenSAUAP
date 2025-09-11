/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import macrocombo.sauap.integration.ServiceFacadeLocator;
import macrocombo.sauap.entity.Administrador;

import java.io.Serializable;

public class LoginHelper implements Serializable {
    

    /**
     * Metodo para hacer login llamara a la instancia de adminFacade
     * @param nombre
     * @param password
     * @return 
     */
    public Administrador Login(String nombre, String password){
        return ServiceFacadeLocator.getInstanceFacadeAdministrador().login(password, nombre);
    }
    
    
    
}