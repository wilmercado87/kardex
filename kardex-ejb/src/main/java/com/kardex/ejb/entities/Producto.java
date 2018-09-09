/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p order by p.nombre asc")
    , @NamedQuery(name = "Producto.findByPkProducto", query = "SELECT p FROM Producto p WHERE p.pkProducto = ?1")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = ?1")
    , @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock <> ?1")
    , @NamedQuery(name = "Producto.findByValorVentaUnidad", query = "SELECT p FROM Producto p WHERE p.valorVentaUnidad = ?1")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_PRODUCTO")
    private Integer pkProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "STOCK")
    private int stock;
    @Basic(optional = false)
    @Column(name = "VALOR_VENTA_UNIDAD")
    private BigDecimal valorVentaUnidad;

    public Producto() {
    }

    public Producto(Integer pkProducto) {
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
    public int hashCode() {
        int hash = 0;
        hash += (pkProducto != null ? pkProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.pkProducto == null && other.pkProducto != null) || (this.pkProducto != null && !this.pkProducto.equals(other.pkProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "pkProducto=" + pkProducto + ", nombre=" + nombre + ", stock=" + stock + ", valorVentaUnidad=" + valorVentaUnidad + '}';
    }

}
