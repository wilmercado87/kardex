/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByPkVenta", query = "SELECT v FROM Venta v WHERE v.pkVenta = ?1")
    , @NamedQuery(name = "Venta.findByIdCliente", query = "SELECT v FROM Venta v WHERE v.idCliente = ?1")
    , @NamedQuery(name = "Venta.findByNombreCliente", query = "SELECT v FROM Venta v WHERE v.nombreCliente = ?1")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = ?1")
    , @NamedQuery(name = "Venta.findByValorTotal", query = "SELECT v FROM Venta v WHERE v.valorTotal = ?1")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_VENTA")
    private Integer pkVenta;
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private long idCliente;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @JoinColumn(name = "FK_PK_USUARIO", referencedColumnName = "PK_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Venta() {
    }

    public Venta(Integer pkVenta) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkVenta != null ? pkVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.pkVenta == null && other.pkVenta != null) || (this.pkVenta != null && !this.pkVenta.equals(other.pkVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "pkVenta=" + pkVenta + ", idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", fecha=" + fecha + ", valorTotal=" + valorTotal + ", usuario=" + usuario + '}';
    }

}
