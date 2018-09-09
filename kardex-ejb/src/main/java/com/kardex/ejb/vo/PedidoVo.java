/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class PedidoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pkPedido;
    private Date fecha;
    private int cantidad;
    private ProductoVo productoVo;

    public PedidoVo() {

    }

    public PedidoVo(Integer pkPedido) {
        this.pkPedido = pkPedido;
    }

    public Integer getPkPedido() {
        return pkPedido;
    }

    public void setPkPedido(Integer pkPedido) {
        this.pkPedido = pkPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ProductoVo getProductoVo() {
        return productoVo;
    }

    public void setProductoVo(ProductoVo productoVo) {
        this.productoVo = productoVo;
    }

    @Override
    public String toString() {
        return "PedidoVo{" + "pkPedido=" + pkPedido + ", fecha=" + fecha + ", cantidad=" + cantidad + ", productoVo=" + productoVo + '}';
    }

}
