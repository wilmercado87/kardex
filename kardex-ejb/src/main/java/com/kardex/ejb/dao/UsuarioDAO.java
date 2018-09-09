/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.dao;

import com.kardex.ejb.entities.Usuario;
import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.generic.GenericController;
import com.kardex.ejb.utilities.SecurityPassword;
import java.util.Arrays;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;

@Stateless(name = "usuarioDAO")
public class UsuarioDAO extends GenericController<Usuario, Integer> {

    private static final long serialVersionUID = -8894946014574205083L;
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class);

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario getUsuarioLogin(String userName, String passName) throws ServicesControllerException {
        LOG.info("Init UsuarioDAO.getUsuarioLogin, userName:[" + userName + "]");
        Usuario usuario;

        try {
            byte[] passDecrypt = SecurityPassword.encrypt(passName);
            String convertpassDecrypt = Arrays.toString(passDecrypt).replace(" ","");
            usuario = findByQueryWithSingleRecord("Usuario.findByNombreUsuarioContrasena", userName, convertpassDecrypt);
            LOG.info("End UsuarioDAO.getUsuarioByLogin, Usuario:[" + usuario.toString() + "]");
        } catch (NoResultException e) {
            usuario = null;
        } catch (Exception e) {
            usuario = null;
            throw new ServicesControllerException(e);
        }
        return usuario;
    }

}
