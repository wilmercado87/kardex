/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.impl;

import com.kardex.ejb.dao.UsuarioDAO;
import com.kardex.ejb.entities.Usuario;
import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.generic.BaseEJB;
import com.kardex.ejb.local.UsuarioEJBLocal;
import com.kardex.ejb.remote.UsuarioEJBRemote;
import com.kardex.ejb.utilities.JPAUtil;
import com.kardex.ejb.vo.UsuarioVo;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;

/**
 *
 * @author ADMIN
 */
@TransactionManagement(TransactionManagementType.BEAN)
@Stateless(name = "usuarioEJB")
public class UsuarioEJB implements UsuarioEJBLocal, UsuarioEJBRemote {
    
    private EntityManager entityManager;
    
    @EJB
    private BaseEJB baseEJB;

    @EJB(name = "usuarioDAO")
    private UsuarioDAO usuarioDao;

    @Override
    public UsuarioVo getUsuarioVoLogin(String user, String pass) throws ServicesControllerException {
        entityManager = JPAUtil.getEntityManager();
        usuarioDao.setEntityManager(entityManager);
        Usuario usuario = usuarioDao.getUsuarioLogin(user, pass);
        UsuarioVo usuarioVo = null;

        if (usuario != null) {
            usuarioVo = (UsuarioVo) baseEJB.convertEntityToVo(Usuario.class, UsuarioVo.class, usuario);
        }
        
        entityManager.close();
        return usuarioVo;
    }

}
