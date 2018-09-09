/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.dao;

import com.kardex.ejb.entities.Pedido;
import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.generic.GenericController;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;

/**
 *
 * @author ADMIN
 */
@Stateless(name = "pedidoDAO")
public class PedidoDAO extends GenericController<Pedido, Long> {

    private static final long serialVersionUID = -8894946014574205083L;
    private static final Logger LOG = Logger.getLogger(PedidoDAO.class);

    public PedidoDAO() {
        super(Pedido.class);
    }

    public List<Pedido> getListOrder() throws ServicesControllerException {
        LOG.info("Init PedidoDAO.getListOrder");
        List<Pedido> list;
        try {
            list = findByQuery("Pedido.findAll");
        } catch (NoResultException e) {
            list = new ArrayList<>();
        } catch (ServicesControllerException e) {
            list = new ArrayList<>();
            throw e;
        }

        return list;
    }

}
