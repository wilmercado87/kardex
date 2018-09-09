/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.remote;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.vo.PedidoVo;
import com.kardex.ejb.vo.ProductoVo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ADMIN
 */
@Remote
public interface GenericEJBRemote {

    List<ProductoVo> getListProducto(boolean filter) throws ServicesControllerException;
    
    List<PedidoVo> getListOrder() throws com.kardex.ejb.exceptions.ServicesControllerException;

}
