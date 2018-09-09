/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "venta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaDetalle.findAll", query = "SELECT v FROM VentaDetalle v")
    , @NamedQuery(name = "VentaDetalle.findByPkVentaDetalle", query = "SELECT v FROM VentaDetalle v WHERE v.pkVentaDetalle = ?1")
    , @NamedQuery(name = "VentaDetalle.findByCantidad", query = "SELECT v FROM VentaDetalle v WHERE v.cantidad = ?1")})
public class VentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_VENTA_DETALLE")
    private Integer pkVentaDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "FK_PK_PRODUCTO", referencedColumnName = "PK_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "FK_PK_VENTA", referencedColumnName = "PK_VENTA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Venta venta;

    public VentaDetalle() {
    }

    public VentaDetalle(Integer pkVentaDetalle) {
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkVentaDetalle != null ? pkVentaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalle)) {
            return false;
        }
        VentaDetalle other = (VentaDetalle) object;
        if ((this.pkVentaDetalle == null && other.pkVentaDetalle != null) || (this.pkVentaDetalle != null && !this.pkVentaDetalle.equals(other.pkVentaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VentaDetalle{" + "pkVentaDetalle=" + pkVentaDetalle + ", cantidad=" + cantidad + ", producto=" + producto + ", venta=" + venta + '}';
    }

}
