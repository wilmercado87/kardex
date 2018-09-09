/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.dao;

import com.kardex.ejb.entities.VentaDetalle;
import com.kardex.ejb.generic.GenericController;
import javax.ejb.Stateless;

/**
 *
 * @author ADMIN
 */
@Stateless(name = "ventaDetalleDAO")
public class VentaDetalleDAO extends GenericController<VentaDetalle, Integer>{
    
    private static final long serialVersionUID = -8894946014574205083L;

    public VentaDetalleDAO() {
        super(VentaDetalle.class);
    }
}
