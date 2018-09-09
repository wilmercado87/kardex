/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.web.rs;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.local.UsuarioEJBLocal;
import com.kardex.ejb.vo.MessageVo;
import com.kardex.ejb.vo.UsuarioVo;
import com.kardex.web.rs.response.ResponseGeneric;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 * REST Web Service
 *
 * @author ADMIN
 */
@Path("usuarioLogin")
@RequestScoped
public class UsuarioLoginResource {
    
    private static final Logger LOG = Logger.getLogger(UsuarioLoginResource.class);

    @Context
    private UriInfo context;

    @EJB(name = "usuarioEJB")
    UsuarioEJBLocal usuarioEJBLocal;

    /**
     * Creates a new instance of UsuarioLoginResource
     */
    public UsuarioLoginResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.unitox.web.rs.UsuarioLoginResource
     *
     * @param userName
     * @param userPass
     * @param request
     * @return an instance of UsuarioVo
     */
    @Path("/find/usuarioLogin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public Response getUsuarioLogin(@QueryParam("userName") String userName, @QueryParam("userPass") String userPass, @Context HttpServletRequest request) {
        ResponseGeneric responseUsuario = new ResponseGeneric();

        try {
            UsuarioVo usuarioVo = usuarioEJBLocal.getUsuarioVoLogin(userName, userPass);
            if (usuarioVo != null) {
                responseUsuario.setObjectVo(usuarioVo);
                responseUsuario.setMessageVo(new MessageVo(request.getRemoteAddr()));
            } else {
                responseUsuario.setMessageVo(new MessageVo(Boolean.FALSE, MessageVo.USER_NO_FOUND));
            }

        } catch (ServicesControllerException e) {
            LOG.error("ServicesControllerException", e);
            return Response.serverError().status(Response.Status.BAD_GATEWAY).entity(new MessageVo(Boolean.FALSE, MessageVo.ERROR_SERVICE)).build();
        } catch (Exception e) {
            LOG.error("ServicesControllerException", e);
            return Response.serverError().status(Response.Status.BAD_GATEWAY).entity(new MessageVo(Boolean.FALSE, MessageVo.ERROR_SERVICE)).build();
        }

        return Response.status(Response.Status.OK).entity(responseUsuario).build();
    }

}
