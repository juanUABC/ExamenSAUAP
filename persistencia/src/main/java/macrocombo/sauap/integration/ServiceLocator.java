package macrocombo.sauap.integration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jakarta.persistence.EntityManager;
import macrocombo.sauap.dao.AdministradorDAO;
import macrocombo.sauap.dao.AsignaDAO;
import macrocombo.sauap.dao.ProfesorDAO;
import macrocombo.sauap.dao.UnidadAprendizajeDAO;
import macrocombo.sauap.persistence.HibernateUtil;


/**
 *
 * @author total
 */
public class ServiceLocator {

    private static ProfesorDAO profesorDAO;
    private static UnidadAprendizajeDAO upDAO;
    private static AsignaDAO asignaDAO;
    private static AdministradorDAO adminDAO;


    private static EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }


    /**
     * se crea la instancia de ProfesorDAO si esta no existe
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO(getEntityManager());
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    /**
     * se crea la instancia de UnidadAprendizajeDAO si esta no existe
     */
    public static UnidadAprendizajeDAO getInstanceUnidadAprendizajeDAO(){
        if(upDAO == null){
            upDAO = new UnidadAprendizajeDAO(getEntityManager());
            return upDAO;
        } else{
            return upDAO;
        }
    }
    /**
     * se crea la instancia de AsignaDAO si esta no existe
     */
    public static AsignaDAO getInstanceAsignaDAO(){
        if(asignaDAO == null){
            asignaDAO = new AsignaDAO(getEntityManager());
            return asignaDAO;
        } else{
            return asignaDAO;
        }
    }
    /**
     * se crea la instancia de AdministradorDAO si esta no existe
     */
    public static AdministradorDAO getInstanceAdministradorDAO(){
        if(adminDAO == null){
            adminDAO = new AdministradorDAO(getEntityManager());
            return adminDAO;
        } else{
            return adminDAO;
        }
    }
}