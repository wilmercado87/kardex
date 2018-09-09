/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.local;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.vo.UsuarioVo;
import javax.ejb.Local;


/**
 *
 * @author ADMIN
 */
@Local
public interface UsuarioEJBLocal {
    
    UsuarioVo getUsuarioVoLogin(String userName, String passName) throws ServicesControllerException;
    
}
