/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.exceptions;

/**
 *
 * @author ADMIN
 */
public class ServicesControllerException extends Exception {

    public ServicesControllerException() {
        super();
    }

    public ServicesControllerException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServicesControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicesControllerException(String message) {
        super(message);
    }

    public ServicesControllerException(Throwable cause) {
        super(cause);
    }

}
