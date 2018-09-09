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
import com.kardex.ejb.local.GenericEJBLocal;
import com.kardex.ejb.remote.GenericEJBRemote;
import com.kardex.ejb.utilities.JPAUtil;
import com.kardex.ejb.vo.PedidoVo;
import com.kardex.ejb.vo.ProductoVo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author ADMIN
 */
@Stateless(name = "genericEJB")
public class GenericEJB implements GenericEJBLocal, GenericEJBRemote {

    private EntityManager entityManager;

    @EJB
    private BaseEJB baseEJB;

    @EJB(name = "productoDAO")
    private ProductoDAO productoDao;

    @EJB(name = "pedidoDAO")
    private PedidoDAO pedidoDao;

    @Override
    public List<ProductoVo> getListProducto(boolean filter) throws ServicesControllerException {
        entityManager = JPAUtil.getEntityManager();
        productoDao.setEntityManager(entityManager);
        List<Producto> listProducto = productoDao.getListProducto(filter);
        List<ProductoVo> listProductoVo = new ArrayList<>();

        if (!listProducto.isEmpty()) {
            for (Producto producto : listProducto) {
                ProductoVo productoVo = (ProductoVo) baseEJB.convertEntityToVo(Producto.class, ProductoVo.class, producto);
                listProductoVo.add(productoVo);
            }
        }

        entityManager.close();
        return listProductoVo;
    }

    @Override
    public List<PedidoVo> getListOrder() throws ServicesControllerException {
        entityManager = JPAUtil.getEntityManager();
        pedidoDao.setEntityManager(entityManager);
        List<Pedido> listPedido = pedidoDao.getListOrder();
        List<PedidoVo> listPedidoVo = new ArrayList<>();

        if (!listPedido.isEmpty()) {
            for (Pedido pedido : listPedido) {
                PedidoVo pedidoVo = (PedidoVo) baseEJB.convertEntityToVo(Pedido.class, PedidoVo.class, pedido);
                listPedidoVo.add(pedidoVo);
            }
        }

        entityManager.close();
        return listPedidoVo;
    }

}
