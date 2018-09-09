/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.generic;

import com.kardex.ejb.exceptions.ServicesControllerException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Contiene las operaciones genericas de persistencia
 *
 * @author ADMIN
 *
 * @param <Entity>
 * @param <PK>
 */
public class GenericController<Entity, PK extends Serializable> implements IGenericController<Entity, PK>, Serializable {

    private EntityManager entityManager;
    private Class<Entity> type;

    public GenericController() {

    }

    public GenericController(Class<Entity> type) {
        this.type = type;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Entity create(Entity t) throws ServicesControllerException {
        entityManager.persist(t);
        return t;
    }

    @Override
    public Entity edit(Entity t) throws ServicesControllerException {
        entityManager.merge(t);
        return t;
    }
    
    @Override
    public void detach(Entity t) throws ServicesControllerException {
        entityManager.detach(t);
    }

    @Override
    public Entity findEntity(PK id) throws ServicesControllerException {
        entityManager = getEntityManager();
        return entityManager.find(type, id);
    }

    @Override
    public void remove(Entity t) throws ServicesControllerException {
        entityManager.remove(t);
    }

    @Override
    public List<Entity> findEntities() throws ServicesControllerException {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Entity> findEntities(int maxResults, int firstResult) throws ServicesControllerException {
        return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Entity> findEntities(boolean all, int maxResults, int firstResult) throws ServicesControllerException {
        Query query = entityManager.createQuery(
                "select o from " + type.getName().substring(
                        type.getName().lastIndexOf(".") + 1, type.getName().length()) + " o");
        if (!all) {
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
        }

        return query.getResultList();

    }

    @Override
    public Integer getCount() throws ServicesControllerException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(type)));
        return entityManager.createQuery(cq).getSingleResult().intValue();
    }

    @Override
    public List<Entity> findByQuery(String nameQuery, Object... bindValues) throws ServicesControllerException {
        Query query = entityManager.createNamedQuery(nameQuery);
        for (int i = 0; i < bindValues.length; i++) {
            query.setParameter(i + 1, bindValues[i]);
        }
        
        return query.getResultList();
    }

    @Override
    public Entity findByQueryWithSingleRecord(String nameQuery, Object... bindValues) throws ServicesControllerException {
        Query query = entityManager.createNamedQuery(nameQuery);
        for (int i = 0; i < bindValues.length; i++) {
            query.setParameter(i + 1, bindValues[i]);
        }
        return (Entity) query.getSingleResult();
    }

    @Override
    public Object findValueByQueryWithSingleRecord(String nameQuery, Object... bindValues) throws ServicesControllerException {
        Query query = entityManager.createNamedQuery(nameQuery);
        for (int i = 0; i < bindValues.length; i++) {
            query.setParameter(i + 1, bindValues[i]);
        }

        return (Object) query.getSingleResult();
    }
}
