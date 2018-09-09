/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.local;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.vo.PedidoVo;
import javax.ejb.Local;

/**
 *
 * @author ADMIN
 */
@Local
public interface PedidoEJBLocal {
    
    PedidoVo addOrder(PedidoVo pedidoVo) throws ServicesControllerException;
    
}
