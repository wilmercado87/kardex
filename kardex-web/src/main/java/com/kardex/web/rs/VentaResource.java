/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.web.rs;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.local.VentaEJBLocal;
import com.kardex.ejb.vo.MessageVo;
import com.kardex.ejb.vo.VentaDetalleVo;
import com.kardex.ejb.vo.VentaVo;
import com.kardex.web.rs.response.ResponseGeneric;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("venta")
public class VentaResource {

    private static final Logger LOG = Logger.getLogger(VentaResource.class);

    @Context
    private UriInfo context;

    @EJB(name = "ventaEJB")
    VentaEJBLocal ventaEJBLocal;

    /**
     * Creates a new instance of VentaResource
     */
    public VentaResource() {
    }

    @Path("/add/venta")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVenta(VentaVo ventaVo) {
        ResponseGeneric responseParameter = new ResponseGeneric();
        try {
            ventaVo = ventaEJBLocal.addVenta(ventaVo);
            responseParameter.setObjectVo(ventaVo);
            responseParameter.setMessageVo(new MessageVo());
            LOG.info("VentaVo:" + ventaVo);
        } catch (ServicesControllerException e) {
            LOG.error("ServicesControllerException", e);
            return Response.serverError().status(Response.Status.BAD_GATEWAY).entity(new MessageVo(Boolean.FALSE, MessageVo.ERROR_SERVICE)).build();
        } catch (Exception e) {
            LOG.error("Exception", e);
            return Response.serverError().status(Response.Status.BAD_GATEWAY).entity(new MessageVo(Boolean.FALSE, MessageVo.ERROR_SERVICE)).build();
        }

        return Response.status(Response.Status.OK).entity(responseParameter).build();

    }

    @Path("/add/ventaDetalle")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVentaDetalle(List<VentaDetalleVo> ventaDetalleVoList) {
        ResponseGeneric responseParameter = new ResponseGeneric();

        try {
            ventaEJBLocal.addVentaDetalleList(ventaDetalleVoList);
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
