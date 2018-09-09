/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.web.rs;

import com.kardex.ejb.exceptions.ServicesControllerException;
import com.kardex.ejb.local.GenericEJBLocal;
import com.kardex.ejb.vo.MessageVo;
import com.kardex.web.rs.response.ResponseGeneric;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 * REST Web Service
 *
 * @author ADMIN
 */
@Path("generic")
public class GenericResource {

    private static final Logger LOG = Logger.getLogger(GenericResource.class);
    public static final String LIST_PRODUCT = "LIST_PRODUCT";
    public static final String LIST_ORDER = "LIST_ORDER";

    @Context
    private UriInfo context;

    @EJB(name = "genericEJB")
    GenericEJBLocal genericEJBLocal;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.unitox.web.rs.GenericResource
     *
     * @param paramteter
     * @param filter
     * @param request
     * @return an instance of Response
     */
    @Path("/find/all/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListParameter(
            @QueryParam("parameter") String paramteter,
            @QueryParam("filter") boolean filter) {
        ResponseGeneric responseParameter = new ResponseGeneric();
        List<?> list = new ArrayList<>();
        try {

            switch (paramteter) {
                case LIST_PRODUCT:
                    list = genericEJBLocal.getListProducto(filter);
                    break;

                case LIST_ORDER:
                    list = genericEJBLocal.getListOrder();
                    break;
            }

            responseParameter.setObjectsVo(list);
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

    /**
     * Retrieves representation of an instance of
     * com.unitox.web.rs.GenericResource
     *
     * @param request
     * @return an instance of Response
     */
    @Path("/remove/all/session")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeAllSession(@Context HttpServletRequest request) {
        ResponseGeneric responseParameter = new ResponseGeneric();
        request.getSession().removeAttribute(LIST_PRODUCT);
        responseParameter.setMessageVo(new MessageVo());
        return Response.status(Response.Status.OK).entity(responseParameter).build();
    }

}
