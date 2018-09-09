/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p order by p.fecha desc")
    , @NamedQuery(name = "Pedido.findByPkPedido", query = "SELECT p FROM Pedido p WHERE p.pkPedido = ?1")
    , @NamedQuery(name = "Pedido.countByCantidad", query = "SELECT sum(p.cantidad) FROM Pedido p WHERE p.producto.pkProducto = ?1")
    , @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = ?1")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_PEDIDO")
    private Integer pkPedido;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "FK_PK_PRODUCTO", referencedColumnName = "PK_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;

    public Pedido() {
    }

    public Pedido(Integer pkPedido) {
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPedido != null ? pkPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pkPedido == null && other.pkPedido != null) || (this.pkPedido != null && !this.pkPedido.equals(other.pkPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "pkPedido=" + pkPedido + ", cantidad=" + cantidad + ", fecha=" + fecha + ", producto=" + producto + '}';
    }

}
