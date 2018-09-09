/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.impl;

import com.kardex.ejb.dao.ProductoDAO;
import com.kardex.ejb.dao.VentaDAO;
import com.kardex.ejb.dao.VentaDetalleDAO;
import com.kardex.ejb.entities.Producto;
import com.kardex.ejb.entities.Venta;
import com.kardex.ejb.entities.VentaDetalle;
import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.generic.BaseEJB;
import com.kardex.ejb.generic.BaseOperationTransaction;
import com.kardex.ejb.local.VentaEJBLocal;
import com.kardex.ejb.remote.VentaEJBRemote;
import com.kardex.ejb.utilities.JPAUtil;
import com.kardex.ejb.vo.ProductoVo;
import com.kardex.ejb.vo.VentaDetalleVo;
import com.kardex.ejb.vo.VentaVo;
import java.util.List;
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
@Stateless(name = "ventaEJB")
public class VentaEJB extends BaseOperationTransaction implements VentaEJBLocal, VentaEJBRemote {

    @Resource
    private SessionContext ctx;

    private EntityManager entityManager;

    @EJB
    private BaseEJB baseEJB;

    @EJB(name = "ventaDAO")
    private VentaDAO ventaDAO;
    
    @EJB(name = "ventaDetalleDAO")
    private VentaDetalleDAO ventaDetalleDAO;
    
    @EJB(name = "productoDAO")
    private ProductoDAO productoDAO;

    @Override
    public VentaVo addVenta(VentaVo ventaVo) throws ServicesControllerException {
        Venta venta = (Venta) baseEJB.convertVoToEntity(VentaVo.class, Venta.class, ventaVo);
        try {
            entityManager = JPAUtil.getEntityManager();
            openTransaction();
            ventaDAO.setEntityManager(entityManager);
            venta = ventaDAO.create(venta);
            commitTransaction();
        } catch (ServicesControllerException e) {
            rollback();
            throw e;
        } finally {
            entityManager.close();
        }

        ventaVo = (VentaVo) baseEJB.convertEntityToVo(Venta.class, VentaVo.class, venta);
        return ventaVo;
    }
    
    @Override
    public void addVentaDetalleList(List<VentaDetalleVo> ventaDetalleVoList) throws ServicesControllerException {
        try {
            entityManager = JPAUtil.getEntityManager();
            ventaDetalleDAO.setEntityManager(entityManager);
            productoDAO.setEntityManager(entityManager);
            openTransaction();
            for (VentaDetalleVo ventaDetalleVo : ventaDetalleVoList) {
                VentaDetalle ventaDetalle = (VentaDetalle) baseEJB.convertVoToEntity(VentaDetalleVo.class, VentaDetalle.class, ventaDetalleVo);
                ventaDetalleDAO.create(ventaDetalle);
                ProductoVo productoVo = ventaDetalleVo.getProductoVo();
                Producto producto = productoDAO.findEntity(productoVo.getPkProducto());
                producto.setStock(producto.getStock() - ventaDetalleVo.getCantidad());
                productoDAO.edit(producto);
            }
            
            commitTransaction();
        } catch (ServicesControllerException e) {
            rollback();
            throw e;
        } finally {
            entityManager.close();
        }
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
