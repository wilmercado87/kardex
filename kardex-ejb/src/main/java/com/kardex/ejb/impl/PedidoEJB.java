/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.impl;

import com.kardex.ejb.dao.PedidoDAO;
import com.kardex.ejb.dao.ProductoDAO;
import com.kardex.ejb.entities.Pedido;
import com.kardex.ejb.entities.Producto;
import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.generic.BaseEJB;
import com.kardex.ejb.generic.BaseOperationTransaction;
import com.kardex.ejb.local.PedidoEJBLocal;
import com.kardex.ejb.remote.PedidoEJBRemote;
import com.kardex.ejb.utilities.JPAUtil;
import com.kardex.ejb.vo.PedidoVo;
import com.kardex.ejb.vo.ProductoVo;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.SessionContext;
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
@Stateless(name = "pedidoEJB")
public class PedidoEJB extends BaseOperationTransaction implements PedidoEJBLocal, PedidoEJBRemote{

    @Resource
    private SessionContext ctx;

    private EntityManager entityManager;

    @EJB
    private BaseEJB baseEJB;
    
    @EJB(name = "pedidoDAO")
    private PedidoDAO pedidoDAO;
    
    @EJB(name = "productoDAO")
    private ProductoDAO productoDAO;

    @Override
    public PedidoVo addOrder(PedidoVo pedidoVo) throws ServicesControllerException {
        Pedido pedido = (Pedido) baseEJB.convertVoToEntity(PedidoVo.class, Pedido.class, pedidoVo);
        try {
            entityManager = JPAUtil.getEntityManager();
            openTransaction();
            pedidoDAO.setEntityManager(entityManager);
            pedidoDAO.create(pedido);
            
            Long stock = (Long) pedidoDAO.findValueByQueryWithSingleRecord("Pedido.countByCantidad", pedidoVo.getProductoVo().getPkProducto());
            productoDAO.setEntityManager(entityManager);
            Producto producto = productoDAO.findEntity(pedidoVo.getProductoVo().getPkProducto());
            producto.setStock(stock.intValue());
            productoDAO.edit(producto);
            commitTransaction();
        } catch (ServicesControllerException e) {
            rollback();
            throw e;
        } finally {
            entityManager.close();
        }

        pedidoVo = (PedidoVo) baseEJB.convertEntityToVo(Pedido.class, PedidoVo.class, pedido);
        return pedidoVo;
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
