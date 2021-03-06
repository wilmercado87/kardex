/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.web.rs;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.local.PedidoEJBLocal;
import com.kardex.ejb.vo.MessageVo;
import com.kardex.ejb.vo.PedidoVo;
import com.kardex.web.rs.response.ResponseGeneric;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 * REST Web Service
 *
 * @author ADMIN
 */
@Path("order")
public class OrderResource {

    private static final Logger LOG = Logger.getLogger(OrderResource.class);

    @Context
    private UriInfo context;

    @EJB(name = "pedidoEJB")
    PedidoEJBLocal pedidoEJBLocal;

    /**
     * Creates a new instance of ProductoResource
     */
    public OrderResource() {
    }

    @Path("/add/order")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(PedidoVo pedidoVo) {
        ResponseGeneric responseParameter = new ResponseGeneric();
        try {
            pedidoVo = pedidoEJBLocal.addOrder(pedidoVo);
            responseParameter.setObjectVo(pedidoVo);
            responseParameter.setMessageVo(new MessageVo());
        } catch (ServicesControllerException e) {
            LOG.error("ServicesControllerException", e);
            return Response.serverError().status(Response.Status.BAD_GATEWAY).entity(new MessageVo(Boolean.FALSE, MessageVo.ERROR_SERVICE)).build();
        } catch (Exception e) {
            LOG.error("Exception", e);
            return Response.serverError().status(Response.Status.BAD_GATEWAY).entity(new MessageVo(Boolean.FALSE, MessageVo.ERROR_SERVICE)).build();
        }

        return Response.status(Response.Status.OK).entity(responseParameter).build();

    }
}
