/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.remote;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.vo.PedidoVo;
import javax.ejb.Remote;


/**
 *
 * @author ADMIN
 */
@Remote
public interface PedidoEJBRemote {
    
    PedidoVo addOrder(PedidoVo pedidoVo) throws ServicesControllerException;
    
}
