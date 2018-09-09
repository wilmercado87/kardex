/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.utilities;

import com.kardex.ejb.entities.Pedido;
import com.kardex.ejb.entities.Venta;
import com.kardex.ejb.entities.VentaDetalle;
import com.kardex.ejb.entities.Producto;
import com.kardex.ejb.entities.Usuario;
import com.kardex.ejb.vo.PedidoVo;
import com.kardex.ejb.vo.UsuarioVo;
import com.kardex.ejb.vo.VentaVo;
import com.kardex.ejb.vo.VentaDetalleVo;
import com.kardex.ejb.vo.ProductoVo;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 *
 * @author ADMIN
 */
public class OrikaMapper {

    /**
     * Instancia
     */
    private static OrikaMapper instance;

    private MapperFactory mapperFactory;

    /**
     * Singular
     */
    private OrikaMapper() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(ProductoVo.class, Producto.class)
                .byDefault()
                .register();
        mapperFactory.classMap(PedidoVo.class, Pedido.class)
                .field("productoVo", "producto")
                .byDefault()
                .register();
        mapperFactory.classMap(VentaVo.class, Venta.class)
                .field("usuarioVo", "usuario")
                .byDefault()
                .register();
        mapperFactory.classMap(VentaDetalleVo.class, VentaDetalle.class)
                .field("productoVo", "producto")
                .field("ventaVo", "venta")
                .byDefault()
                .register();
        mapperFactory.classMap(UsuarioVo.class, Usuario.class)
                .byDefault()
                .register();
    }

    /**
     * Obtiene una instancia de OrikaMapper
     *
     * @return
     */
    public static OrikaMapper getInstance() {
        if (instance == null) {
            instance = new OrikaMapper();
        }
        return instance;
    }

    /**
     * @return the mapperFactory
     */
    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }

    /**
     * @param mapperFactory the mapperFactory to set
     */
    public void setMapperFactory(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    public static void main(String[] args) {

    }

}
