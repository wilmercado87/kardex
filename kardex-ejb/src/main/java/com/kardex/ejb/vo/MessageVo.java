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
public class MessageVo implements Serializable {

    private boolean exit = true;
    private String message = "Response Success";
    private String data;
    public static final String USER_NO_FOUND = "Invalid User";
    public static final String PARAMETER_NO_FOUND = "Paramter not found";
    public static final String ERROR_SERVICE = "Error Service";

    public MessageVo(){
        
    }
    
    public MessageVo(String data) {
        this.data = data;
    }

    public MessageVo(boolean exit, String message) {
        this.exit = exit;
        this.message = message;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
