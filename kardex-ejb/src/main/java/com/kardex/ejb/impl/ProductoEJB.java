/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.impl;

import com.kardex.ejb.dao.ProductoDAO;
import com.kardex.ejb.entities.Producto;
import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.generic.BaseEJB;
import com.kardex.ejb.generic.BaseOperationTransaction;
import com.kardex.ejb.local.ProductoEJBLocal;
import com.kardex.ejb.remote.ProductoEJBRemote;
import com.kardex.ejb.utilities.JPAUtil;
import com.kardex.ejb.vo.ProductoVo;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author ADMIN
 */
@TransactionManagement(TransactionManagementType.BEAN)
@Stateless(name = "productoEJB")
public class ProductoEJB extends BaseOperationTransaction implements ProductoEJBLocal, ProductoEJBRemote {

    @Resource
    private SessionContext ctx;

    private EntityManager entityManager;

    @EJB
    private BaseEJB baseEJB;

    @EJB(name = "productoDAO")
    private ProductoDAO productoDAO;

    @Override
    public ProductoVo addProducto(ProductoVo productoVo) throws ServicesControllerException {
        Producto producto = (Producto) baseEJB.convertVoToEntity(ProductoVo.class, Producto.class, productoVo);
        try {
            entityManager = JPAUtil.getEntityManager();
            openTransaction();
            productoDAO.setEntityManager(entityManager);
            productoDAO.create(producto);
            commitTransaction();
        } catch (ServicesControllerException e) {
            rollback();
            throw e;
        } finally {
            entityManager.close();
        }

        productoVo = (ProductoVo) baseEJB.convertEntityToVo(Producto.class, ProductoVo.class, producto);
        return productoVo;
    }

    @Override
    public ProductoVo getProductoByNombre(String nameProducto) throws ServicesControllerException {
        entityManager = JPAUtil.getEntityManager();
        productoDAO.setEntityManager(entityManager);
        Producto producto = productoDAO.getProductoByNombre(nameProducto);
        ProductoVo productoVo = (ProductoVo) baseEJB.convertEntityToVo(Producto.class, ProductoVo.class, producto);
        
        entityManager.close();
        return productoVo;
    }

    @Override
    public void openTransaction() throws ServicesControllerException {
        try {
            ctx.getUserTransaction().begin();
        } catch (NotSupportedException | SystemException e) {
            throw new ServicesControllerException("Error openTransaction", e);
        }
    }

    @Override
    public void commitTransaction() throws ServicesControllerException {
        try {
            ctx.getUserTransaction().commit();
        } catch (RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | SystemException e) {
            throw new ServicesControllerException("Error commitTransaction", e);
        }
    }

    @Override
    public void rollback() throws ServicesControllerException {
        try {
            ctx.getUserTransaction().rollback();
        } catch (IllegalStateException | SecurityException | SystemException e) {
            throw new ServicesControllerException("Error rollback", e);
        }
    }
}
