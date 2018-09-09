/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.generic;

import com.kardex.ejb.exceptions.ServicesControllerException;
import java.io.Serializable;
import java.util.List;

/**
 * Interfaz que define las operaciones genericas de persistencia
 *
 * @author ADMIN
 *
 * @param <Entity>
 * @param <PK>
 */
public interface IGenericController<Entity, PK extends Serializable> {

    public static final String UNIT_NAME = "kardex-unit";

    Entity create(Entity t) throws ServicesControllerException;

    Entity edit(Entity t) throws ServicesControllerException;
    
    public void detach(Entity t) throws ServicesControllerException;

    Entity findEntity(PK id) throws ServicesControllerException;
    
    List<Entity> findByQuery(String sqlQuery, Object... bindValues) throws ServicesControllerException;
    
    Entity findByQueryWithSingleRecord(String sqlQuery, Object... bindValues) throws ServicesControllerException;
    
    Object findValueByQueryWithSingleRecord(String nameQuery, Object... bindValues) throws ServicesControllerException;

    void remove(Entity t) throws ServicesControllerException;

    List<Entity> findEntities() throws ServicesControllerException;

    List<Entity> findEntities(int maxResults, int firstResult) throws ServicesControllerException;

    public List<Entity> findEntities(boolean all, int maxResults, int firstResult) throws ServicesControllerException;

    Integer getCount() throws ServicesControllerException;

}
