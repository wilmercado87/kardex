/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.local;

import com.kardex.ejb.vo.PedidoVo;
import com.kardex.ejb.vo.ProductoVo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ADMIN
 */
@Local
public interface GenericEJBLocal {

    List<ProductoVo> getListProducto(boolean filter) throws com.kardex.ejb.exceptions.ServicesControllerException;
    
    List<PedidoVo> getListOrder() throws com.kardex.ejb.exceptions.ServicesControllerException;

}
