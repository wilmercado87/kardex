/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.dao;

import com.kardex.ejb.entities.Producto;
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
@Stateless(name = "productoDAO")
public class ProductoDAO extends GenericController<Producto, Integer> {
    
    private static final long serialVersionUID = -8894946014574205083L;
    private static final Logger LOG = Logger.getLogger(ProductoDAO.class);
    
    public ProductoDAO() {
        super(Producto.class);
    }
    
    public List<Producto> getListProducto(boolean filter) throws ServicesControllerException {
        LOG.info("Init ProductoDAO.getListProducto");
        List<Producto> list;
        try {
            if (filter) {
                list = findByQuery("Producto.findByStock", 0);
            } else {
                list = findByQuery("Producto.findAll");
            }
        } catch (NoResultException e) {
            list = new ArrayList<>();
        } catch (ServicesControllerException e) {
            list = new ArrayList<>();
            throw e;
        }
        
        return list;
    }
    
    public Producto getProductoByNombre(String nameProducto) throws ServicesControllerException {
        LOG.info("Init ProductoDAO.getProductoByNombre:" + nameProducto);
        Producto producto;
        try {
            producto = findByQueryWithSingleRecord("Producto.findByNombre", nameProducto);
            LOG.info("ProductoDAO:" + producto);
        } catch (NoResultException e) {
            producto = null;
        } catch (ServicesControllerException e) {
            producto = null;
            throw e;
        }
        
        return producto;
    }
    
}
