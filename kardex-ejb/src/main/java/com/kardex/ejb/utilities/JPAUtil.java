/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.utilities;

import com.kardex.ejb.generic.IGenericController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ADMIN
 */
public class JPAUtil {

    private static EntityManagerFactory factory;

    public static EntityManager getEntityManager() {
        instanceEntityManagerFactory();
        return factory.createEntityManager();
    }

    private static void instanceEntityManagerFactory() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(IGenericController.UNIT_NAME);
        }
    }

    public static void shutdown() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }

}
