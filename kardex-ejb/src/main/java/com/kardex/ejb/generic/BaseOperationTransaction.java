/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.generic;

import com.kardex.ejb.exceptions.ServicesControllerException;

/**
 *
 * @author ADMIN
 */
public abstract class BaseOperationTransaction {

    public abstract void openTransaction() throws ServicesControllerException;

    public abstract void commitTransaction() throws ServicesControllerException;

    public abstract void rollback() throws ServicesControllerException;
}
