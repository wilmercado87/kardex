/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class VentaVo implements Serializable {

    private Integer pkVenta;
    private long idCliente;
    private String nombreCliente;
    private Date fecha;
    private BigDecimal valorTotal;
    private UsuarioVo usuarioVo;

    public VentaVo() {

    }

    public VentaVo(Integer pkVenta) {
        this.pkVenta = pkVenta;
    }

    public Integer getPkVenta() {
        return pkVenta;
    }

    public void setPkVenta(Integer pkVenta) {
        this.pkVenta = pkVenta;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    @Override
    public String toString() {
        return "VentaVo{" + "pkVenta=" + pkVenta + ", idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", fecha=" + fecha + ", valorTotal=" + valorTotal + ", usuarioVo=" + usuarioVo + '}';
    }

}
