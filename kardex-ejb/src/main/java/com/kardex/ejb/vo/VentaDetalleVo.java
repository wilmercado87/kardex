/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.vo;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class VentaDetalleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pkVentaDetalle;
    private int cantidad;
    private ProductoVo productoVo;
    private VentaVo ventaVo;

    public VentaDetalleVo() {
    }

    public VentaDetalleVo(Integer pkVentaDetalle) {
        this.pkVentaDetalle = pkVentaDetalle;
    }

    public Integer getPkVentaDetalle() {
        return pkVentaDetalle;
    }

    public void setPkVentaDetalle(Integer pkVentaDetalle) {
        this.pkVentaDetalle = pkVentaDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoVo getProductoVo() {
        return productoVo;
    }

    public void setProductoVo(ProductoVo productoVo) {
        this.productoVo = productoVo;
    }

    public VentaVo getVentaVo() {
        return ventaVo;
    }

    public void setVentaVo(VentaVo ventaVo) {
        this.ventaVo = ventaVo;
    }

    @Override
    public String toString() {
        return "VentaDetalleVo{" + "pkVentaDetalle=" + pkVentaDetalle + ", cantidad=" + cantidad + ", productoVo=" + productoVo + ", ventaVo=" + ventaVo + '}';
    }

}
