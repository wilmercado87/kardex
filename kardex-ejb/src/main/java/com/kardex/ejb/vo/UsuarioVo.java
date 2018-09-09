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
public class UsuarioVo implements Serializable {

    private Integer pkUsuario;
    private String nombreUsuario;
    private String contrasena;
    
    public UsuarioVo(){
        
    }
    
    public UsuarioVo(Integer pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public Integer getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(Integer pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "UsuarioVo{" + "pkUsuario=" + pkUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + '}';
    }
    
}
