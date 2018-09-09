/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class ProductoVo implements Serializable {

    private Integer pkProducto;
    private String nombre;
    private int stock;
    private BigDecimal valorVentaUnidad;

    public ProductoVo() {

    }

    public ProductoVo(Integer pkProducto) {
        this.pkProducto = pkProducto;
    }

    public Integer getPkProducto() {
        return pkProducto;
    }

    public void setPkProducto(Integer pkProducto) {
        this.pkProducto = pkProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getValorVentaUnidad() {
        return valorVentaUnidad;
    }

    public void setValorVentaUnidad(BigDecimal valorVentaUnidad) {
        this.valorVentaUnidad = valorVentaUnidad;
    }

    @Override
    public String toString() {
        return "ProductoVo{" + "pkProducto=" + pkProducto + ", nombre=" + nombre + ", stock=" + stock + ", valorVentaUnidad=" + valorVentaUnidad + '}';
    }

}
